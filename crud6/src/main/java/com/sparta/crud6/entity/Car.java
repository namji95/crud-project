package com.sparta.crud6.entity;

import com.sparta.crud6.dto.CarRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String carName;
  private String carColor;
  private String carType;

  public Car(CarRequestDto requestDto) {
    this.carName = requestDto.getCarName();
    this.carColor = requestDto.getCarColor();
    this.carType = requestDto.getCarType();
  }

  public void updateCar(CarRequestDto requestDto) {
    this.carName = requestDto.getCarName();
    this.carColor = requestDto.getCarColor();
    this.carType = requestDto.getCarType();
  }
}
