package br.com.euphoriarpg.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.NpcDTO;
import br.com.euphoriarpg.model.entity.Npc;

@Service
public interface NpcService extends GenericService<Npc, NpcDTO>{

	List<Npc> getNpcByNome(String nome);

}
