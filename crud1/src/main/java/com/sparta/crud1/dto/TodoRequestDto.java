package com.sparta.crud1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TodoRequestDto {
  @NotBlank
  private String title;
  @NotBlank
  private String content;
}
