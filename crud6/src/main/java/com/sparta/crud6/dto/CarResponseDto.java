package com.sparta.crud6.dto;

import java.text.CollationElementIterator;
import lombok.Getter;

@Getter
public class CarResponseDto {
  private String carName;
  private String carColor;
  private String carType;

  public CarResponseDto(String carName, String carColor, String carType) {
    this.carName = carName;
    this.carColor = carColor;
    this.carType = carType;
  }
}
