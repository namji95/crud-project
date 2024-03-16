package com.sparta.crud5.dto;

import lombok.Getter;

@Getter
public class MusicMachineResponseDto {
  private Long singNumber;
  private String singTitle;
  private String singer;

  public MusicMachineResponseDto(Long singNumber, String singTitle, String singer) {
    this.singNumber = singNumber;
    this.singTitle = singTitle;
    this.singer = singer;
  }
}
