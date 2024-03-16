package com.sparta.crud6.controller;

import com.sparta.crud6.dto.CarRequestDto;
import com.sparta.crud6.dto.CarResponseDto;
import com.sparta.crud6.service.CarService;
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
@RequestMapping("/api/v1/cars")
public class CarController {

  private final CarService carService;

  @PostMapping
  public String createCar (
      @RequestBody CarRequestDto requestDto) {
    carService.createCar(requestDto);

    return "자동차가 생성되었습니다.";
  }

  @GetMapping
  public ResponseEntity<List<CarResponseDto>> getCarList() {
    List<CarResponseDto> responseDtos = carService.getCarList();

    return new ResponseEntity<>(responseDtos, HttpStatus.OK);
  }

  @GetMapping("/{carId}")
  public ResponseEntity<CarResponseDto> getCar(
      @PathVariable Long carId) {
    CarResponseDto responseDto = carService.getCar(carId);

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  @PutMapping("/{carId}")
  public String updateCar (
      @RequestBody CarRequestDto requestDto,
      @PathVariable Long carId) {
    carService.updateCar(requestDto, carId);

    return "자동차 정보가 수정되었습니다:";
  }

  @DeleteMapping("/{carId}")
  public String deleteCar (
      @PathVariable Long carId) {
    carService.deleteCar(carId);

    return "자동차 정보가 삭제되었습니다.";
  }
}
