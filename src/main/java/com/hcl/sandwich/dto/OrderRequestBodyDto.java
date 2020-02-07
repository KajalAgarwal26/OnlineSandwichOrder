package com.hcl.sandwich.dto;

import java.util.List;


public class OrderRequestBodyDto {

	private Long userId;
	private List<ItemsDto> itemDetail;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<ItemsDto> getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(List<ItemsDto> itemDetail) {
		this.itemDetail = itemDetail;
	}
}
