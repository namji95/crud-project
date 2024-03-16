package com.sparta.crud1.dto;

import lombok.Getter;

@Getter
public class TodoResponseDto {

  private String content;

  public TodoResponseDto(String content) {
    this.content = content;
  }
}
