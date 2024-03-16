package com.sparta.crud7.entity;

import com.sparta.crud7.dto.ItemRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "items")
@NoArgsConstructor
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String itemName;
  private Long itemNum;

  public Item(ItemRequestDto requestDto) {
    this.itemName = requestDto.getItemName();
    this.itemNum = requestDto.getItemNum();
  }

  public void updateItem(ItemRequestDto requestDto) {
    this.itemName = requestDto.getItemName();
    this.itemNum = requestDto.getItemNum();
  }
}
