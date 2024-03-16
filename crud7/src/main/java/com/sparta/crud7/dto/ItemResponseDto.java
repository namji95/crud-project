package com.sparta.crud7.dto;

import lombok.Getter;

@Getter
public class ItemResponseDto {
  private String itemName;
  private Long itemNum;

  public ItemResponseDto(String itemName, Long itemNum) {
    this.itemName = itemName;
    this.itemNum = itemNum;
  }
}
