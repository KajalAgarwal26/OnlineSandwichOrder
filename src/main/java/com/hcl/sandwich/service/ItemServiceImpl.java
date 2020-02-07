package com.hcl.sandwich.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.sandwich.dto.ItemResponseDto;
import com.hcl.sandwich.entity.Items;
import com.hcl.sandwich.exception.NoItemsArePresentException;
import com.hcl.sandwich.repository.ItemRepository;
import com.hcl.sandwich.util.SANDUTIL;

@Service
public class ItemServiceImpl implements ItemsService{

	@Autowired
	ItemRepository itemRepository;
	
	ItemResponseDto itemResponseDto=new ItemResponseDto();
	@Override
	public ItemResponseDto getAllItems() {
		List<Items> items = itemRepository.findAll();
		if(items.isEmpty()) {
			throw new NoItemsArePresentException(SANDUTIL.ITEMS_NOT_FOUND);
		}
		itemResponseDto.setMessage("success");
		itemResponseDto.setStatusCode(HttpStatus.OK.value());
		itemResponseDto.setItems(items);
		return itemResponseDto;
	}
}
