package br.com.euphoriarpg.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ItemDTO;
import br.com.euphoriarpg.model.entity.Item;

@Service
public interface ItemService {
	
	List<Item> getAll();

	Item getItem(Long id);

	Item create(ItemDTO dtoInput);

	Item update(ItemDTO dtoInput);

	void delete(Long id);

}
