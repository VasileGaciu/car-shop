package com.car.shop.service;

import com.car.shop.entity.Cars;
import com.car.shop.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }
    public List<Cars> getAllCars(){
        return carsRepository.findAll();
    }
    public Cars findByPlateNumber(String plateNumber){
       return carsRepository.findByPlateNumber(plateNumber);
    }

    public String addCar(Cars car){
      carsRepository.save(car);
      return "Saved";
    }
    public boolean uodateCar(Cars car){
       boolean existCar = carsRepository.existsByPlateNumber(car.getPlateNumber());
       if(existCar){
         carsRepository.save(car);
         return true;
       }
       return false;
    }

    public boolean deleteCar(Cars car){
      boolean existCar = carsRepository.existsByPlateNumber(car.getPlateNumber());
      if(existCar){
       carsRepository.delete(car);
       return true;
      }
      return false;
    }
}
