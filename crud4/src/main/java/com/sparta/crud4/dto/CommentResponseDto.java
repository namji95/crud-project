package com.sparta.crud4.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CommentResponseDto {

  private String content;
  private LocalDateTime createdAt;

  public CommentResponseDto(String content, LocalDateTime createdAt) {
    this.content = content;
    this.createdAt = createdAt;
  }
}
