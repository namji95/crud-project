package com.sparta.crud7.service;

import com.sparta.crud7.dto.ItemRequestDto;
import com.sparta.crud7.dto.ItemResponseDto;
import com.sparta.crud7.entity.Item;
import com.sparta.crud7.repository.ItemRepository;
import java.awt.event.ItemEvent;
import java.util.List;
import jdk.jfr.StackTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.wiring.BeanWiringInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  @Transactional
  public void createItem(ItemRequestDto requestDto) {
    Item item = new Item(requestDto);

    itemRepository.save(item);
  }

  @Transactional(readOnly = true)
  public List<ItemResponseDto> getItemList() {
    List<Item> items = itemRepository.findAll();
    List<ItemResponseDto> responseDtos = items.stream().map(
        item -> new ItemResponseDto(item.getItemName(), item.getItemNum())).toList();

    return responseDtos;
  }

  @Transactional(readOnly = true)
  public ItemResponseDto getItem(Long itemId) {
    Item item = itemRepository.findById(itemId).orElseThrow(() ->
        new IllegalArgumentException("선택한 아이템이 존재하지 않습니다."));

    ItemResponseDto responseDto = new ItemResponseDto(
        item.getItemName(), item.getItemNum());

    return responseDto;
  }

  @Transactional
  public void updateItem(ItemRequestDto requestDto, Long itemId) {
    Item item = itemRepository.findById(itemId).orElseThrow(() ->
        new IllegalArgumentException("선택한 아이템이 존재하지 않습니다."));

    item.updateItem(requestDto);
  }

  @Transactional
  public void deleteItem(Long itemId) {
    itemRepository.deleteById(itemId);
  }
}
