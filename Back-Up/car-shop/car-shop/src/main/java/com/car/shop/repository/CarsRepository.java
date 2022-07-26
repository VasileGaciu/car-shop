package com.car.shop.repository;

import com.car.shop.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, String> {
    public Cars findByPlateNumber(String plateNumber);
    public Boolean existsByPlateNumber(String plateNumber);
}
