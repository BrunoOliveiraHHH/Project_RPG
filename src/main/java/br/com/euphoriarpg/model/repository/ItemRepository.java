package br.com.euphoriarpg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.euphoriarpg.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item>{

	@Query(value = "SELECT * FROM ITEM WHERE UPPER(NOME)=UPPER(:nome)", nativeQuery = true)
	Item getItem(@Param("nome") String nome);
}
