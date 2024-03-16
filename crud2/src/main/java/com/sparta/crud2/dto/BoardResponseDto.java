package com.sparta.crud2.dto;

import lombok.Getter;

@Getter
public class BoardResponseDto {

  private String writer;
  private String content;

  public BoardResponseDto(String writer, String content) {
    this.writer = writer;
    this.content = content;
  }
}
