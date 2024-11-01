package br.com.euphoriarpg.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.NpcDTO;
import br.com.euphoriarpg.model.entity.Npc;
import br.com.euphoriarpg.model.exceptions.AplicacaoException;
import br.com.euphoriarpg.model.repository.NpcRepository;
import br.com.euphoriarpg.model.service.NpcService;


@Service
public class NpcServiceImpl implements NpcService {

	@Autowired
	private NpcRepository repository;

	@Override
	public List<Npc> getAll() {
		List<Npc> listaDados = repository.findAll();

		if (listaDados == null) {
			throw new AplicacaoException("Npc não encontrado!");
		}

		return listaDados;
	}

	@Override
	public Npc getNpc(Long id) {
		Optional<Npc> dado = repository.findById(id);

		if (!dado.isPresent()) {
			throw new AplicacaoException("Npc não encontrado!");
		}

		return dado.get();
	}

	@Override
	public Npc create(NpcDTO dado) {
		Npc npc = repository.getNpc(dado.getNome(), dado.getIdade(), dado.getRaca(), dado.getClasse());

		if (npc != null) {
			throw new AplicacaoException("Npc já existe!");
		}

		npc = new Npc();
		npc.setNome(dado.getNome());
		npc.setIdade(dado.getIdade());
		npc.setRaca(dado.getRaca());
		npc.setClasse(dado.getClasse());

		return repository.save(npc);
	}

	@Override
	public Npc update(Long id, NpcDTO dado) {
		Npc npcAtual = repository.findByIdNpc(id);

		if (npcAtual == null) {
			throw new AplicacaoException("Npc não encontrado!");
		}

		npcAtual = this.validaCampoUpdate(npcAtual, dado);

		return repository.save(npcAtual);
	}

	private Npc validaCampoUpdate(Npc npcAtual, NpcDTO dado) {

		npcAtual.setNome((npcAtual.getNome().equals(dado.getNome()) ? npcAtual.getNome() : dado.getNome()));
		npcAtual.setIdade((npcAtual.getIdade().equals(dado.getIdade()) ? npcAtual.getIdade() : dado.getIdade()));
		npcAtual.setRaca((npcAtual.getRaca().equals(dado.getRaca()) ? npcAtual.getRaca() : dado.getRaca()));
		npcAtual.setClasse((npcAtual.getClasse().equals(dado.getClasse()) ? npcAtual.getClasse() : dado.getClasse()));

		return npcAtual;
	}

	@Override
	public void delete(Long id) {
		Optional<Npc> dado = repository.findById(id);
		
		if(dado.isEmpty()) {
			throw new AplicacaoException("Npc não encontrado!");
		}		
		repository.deleteById(id);
	}

	@Override
	public List<Npc> getNpcByNome(String nome) {
		List<Npc> dado = repository.findByNome(nome);

		if (dado == null) {
			throw new AplicacaoException("Npc não encontrado!");
		}

		return dado;
	}

}
