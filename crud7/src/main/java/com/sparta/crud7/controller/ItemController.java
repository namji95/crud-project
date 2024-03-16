package com.sparta.crud7.controller;

import com.sparta.crud7.dto.ItemRequestDto;
import com.sparta.crud7.dto.ItemResponseDto;
import com.sparta.crud7.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemController {

  private final ItemService itemService;

  @PostMapping
  public String createItem (
      @RequestBody ItemRequestDto requestDto) {
    itemService.createItem(requestDto);

    return "아이템 생성";
  }

  @GetMapping
  public ResponseEntity<List<ItemResponseDto>> getItemList () {
    List<ItemResponseDto> responseDtos = itemService.getItemList();

    return new ResponseEntity<>(responseDtos, HttpStatus.OK);
  }

  @GetMapping("/{itemId}")
  public ResponseEntity<ItemResponseDto> getItem (
      @PathVariable Long itemId) {
    ItemResponseDto responseDto = itemService.getItem(itemId);

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  @PutMapping("/{itemId}")
  public String updateItem (
      @RequestBody ItemRequestDto requestDto,
      @PathVariable Long itemId) {
    itemService.updateItem(requestDto, itemId);

    return "아이템 정보가 수정되었스빈다.!!";
  }

  @DeleteMapping("/{itemId}")
  public String deleteItem (
      @PathVariable Long itemId) {
    itemService.deleteItem(itemId);

    return "선택한 아이템이 삭제되었습니다.";
  }
}
