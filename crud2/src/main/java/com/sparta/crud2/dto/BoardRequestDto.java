package com.sparta.crud2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BoardRequestDto {

  @NotBlank
  private String writer;
  @NotBlank
  private String title;
  @NotBlank
  private String content;

}
