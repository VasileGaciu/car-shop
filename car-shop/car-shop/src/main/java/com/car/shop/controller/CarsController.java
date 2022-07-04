package com.car.shop.controller;

import com.car.shop.entity.Cars;
import com.car.shop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Cars> getAllCars(){
      return carService.getAllCars();
    }
    @GetMapping("{plateNumber}")
    public Cars findByPlateNumber(@PathVariable String plateNumber){
        return carService.findByPlateNumber(plateNumber);
    }

    @PostMapping("add")
    public ResponseEntity<String> addCar(@RequestBody Cars car){
       String savedCarState = carService.addCar(car);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/" + car.getPlateNumber()).build().toUri();
       return ResponseEntity.created(uri).body(savedCarState);
    }
    @PutMapping("update")
    public ResponseEntity<String> updateCar(@RequestBody Cars car){
      boolean updatedCarState = carService.uodateCar(car);
      if(updatedCarState){
          return ResponseEntity.ok("Success updated");
      }
      return ResponseEntity.badRequest().body("Car not found");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCar(@RequestBody Cars car){
       boolean deletedCar = carService.deleteCar(car);
       if(deletedCar){
          return ResponseEntity.ok("Car deleted");
       }
       return ResponseEntity.badRequest().body("Car not found");
    }
}
