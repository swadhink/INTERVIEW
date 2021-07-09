package com.mytaxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.dto.CarDTO;
import com.mytaxi.entity.Car;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.CarService;

/**
 * All operations with a car will be routed by this controller.
 * @author swadhin
 * <p/>
 */
@RestController
@RequestMapping("/cars")
public class CarController
{
    private final CarService carService;


    @Autowired
    public CarController(final CarService carService)
    {
        this.carService = carService;
    }


    @GetMapping(value = "/{carId}")
    public CarDTO getCar(@PathVariable long carId) throws EntityNotFoundException
    {
        return new CarMapper().toDto(carService.find(carId));
    }


    @GetMapping()
    public List<CarDTO> getAllCars()
    {
        return new CarMapper().toDtos(carService.findAllCars());
    }


    @PostMapping()
    public CarDTO createCar(@Valid @RequestBody CarDTO carData) throws EntityNotFoundException
    {
        Car carDO = CarMapper.toEntity(carData);
        return new CarMapper().toDto(carService.create(carDO));
    }



}
