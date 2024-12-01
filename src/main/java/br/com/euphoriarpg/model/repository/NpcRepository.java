package br.com.euphoriarpg.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.euphoriarpg.model.entity.Npc;

@Repository
public interface NpcRepository extends JpaRepository<Npc, Long>, JpaSpecificationExecutor<Npc> {

	@Query(value = "SELECT * FROM NPC WHERE UPPER(NOME)=UPPER(:nome) AND IDADE=:idade AND RACA=:raca AND CLASSE=:classe", nativeQuery = true)
	Npc getNpc(@Param("nome") String nome, @Param("idade") String idade, @Param("raca") String raca,
			@Param("classe") String classe);
	
	@Query(value = "SELECT * FROM NPC WHERE UPPER(NOME)=UPPER(:nome)", nativeQuery = true)
	List<Npc> findByNome(@Param("nome") String nome);
	
	@Query(value = "SELECT * FROM NPC WHERE ID_NPC=:id", nativeQuery = true)
	Npc findByIdNpc(@Param("id") Long id);

}
