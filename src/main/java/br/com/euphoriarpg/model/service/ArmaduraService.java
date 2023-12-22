package br.com.euphoriarpg.model.service;

import java.util.List;

import br.com.euphoriarpg.model.dto.ArmaduraDTO;
import br.com.euphoriarpg.model.entity.Armadura;

public interface ArmaduraService {
	
	List<Armadura> getAll();

	Armadura getArmadura(Long id);

	Armadura create(ArmaduraDTO dtoInput);

	Armadura update(ArmaduraDTO dtoInput);

	void delete(Long id);

}
