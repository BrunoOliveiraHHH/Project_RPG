package br.com.euphoriarpg.model.repository.specifications.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.euphoriarpg.model.entity.Usuario;
import br.com.euphoriarpg.model.repository.specifications.UsuarioRepositoryCustom;
import br.com.euphoriarpg.model.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> findUsuario(String nome) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> root = criteria.from(Usuario.class);

		Predicate[] predicates = restricoes(builder, root, nome);
		criteria.where(predicates);
		criteria.orderBy(builder.asc(root.get("id")));

		TypedQuery<Usuario> query = entityManager.createQuery(criteria);
		return query.getResultList();
	}
	
	public Predicate[] restricoes(CriteriaBuilder builder, Root<Usuario> root, String nome) {

		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isNullorEmpty(nome.trim()) && !nome.trim().contains("\"")) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
