package com.sparta.crud6.repository;

import com.sparta.crud6.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
