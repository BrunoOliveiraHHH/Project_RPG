package br.com.euphoriarpg.model.service;

import org.springframework.stereotype.Service;

import br.com.euphoriarpg.model.dto.ItemDTO;
import br.com.euphoriarpg.model.entity.Item;

@Service
public interface ItemService extends GenericService<Item, ItemDTO>{
	

}
