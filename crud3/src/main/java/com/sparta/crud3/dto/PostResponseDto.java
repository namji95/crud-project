package com.sparta.crud3.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostResponseDto {

  private String writer;
  private String content;
  private LocalDateTime createdAt;

  public PostResponseDto(String writer, String content, LocalDateTime createdAt) {
    this.writer = writer;
    this.content = content;
    this.createdAt = createdAt;
  }
}
