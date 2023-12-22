package br.com.euphoriarpg.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.NpcDTO;
import br.com.euphoriarpg.model.entity.Npc;

@Service
public interface NpcService {

	List<Npc> getAll();

	Npc create(NpcDTO dado);

	Npc update(NpcDTO dado);

	void delete(Long id);

	Npc getNpc(Long id);

	List<Npc> getNpcByNome(String nome);

}
