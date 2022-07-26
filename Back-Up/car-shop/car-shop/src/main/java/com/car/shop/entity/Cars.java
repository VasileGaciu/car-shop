package com.car.shop.entity;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Log4j2
public class Cars {

   @Id
   @Column(name = "vehicle_identification_number", nullable = false)
   private String vehicleIdentificationNumber;

   @Column(name = "marca", nullable = false)
   private String marca;

   @Column(name = "plate_number", nullable = false, unique = true)
    private String plateNumber;

   @Column(name = "fabrication_date", nullable = false)
   private Date fabricationDate;

   @Column(name = "price", nullable = false)
    private Integer price;
}
