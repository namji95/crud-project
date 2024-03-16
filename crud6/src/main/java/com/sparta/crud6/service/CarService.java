package com.sparta.crud6.service;

import com.sparta.crud6.dto.CarRequestDto;
import com.sparta.crud6.dto.CarResponseDto;
import com.sparta.crud6.entity.Car;
import com.sparta.crud6.repository.CarRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarService  {

  private final CarRepository carRepository;


  @Transactional
  public void createCar(CarRequestDto requestDto) {
    Car car = new Car(requestDto);

    carRepository.save(car);
  }

  @Transactional(readOnly = true)
  public List<CarResponseDto> getCarList() {
    List<Car> cars = carRepository.findAll();
    List<CarResponseDto> responseDtos = cars.stream().map(
        car ->new CarResponseDto(car.getCarName(), car.getCarColor(), car.getCarType())).toList();

    return responseDtos;
  }

  @Transactional(readOnly = true)
  public CarResponseDto getCar(Long carId) {
    Car car = carRepository.findById(carId).orElseThrow(() ->
        new IllegalArgumentException("존재하는 자동차가 아닙니다."));

    CarResponseDto responseDto = new CarResponseDto(
        car.getCarName(), car.getCarColor(), car.getCarType()
    );

    return responseDto;
  }

  @Transactional
  public void updateCar(CarRequestDto requestDto, Long carId) {
    Car car = carRepository.findById(carId).orElseThrow(() ->
        new IllegalArgumentException("존재하지 않는 자동차 정보입니다."));

    car.updateCar(requestDto);
  }

  @Transactional
  public void deleteCar(Long carId) {
    carRepository.deleteById(carId);
  }
}
