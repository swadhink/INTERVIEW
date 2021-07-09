package com.mytaxi.service;

import java.util.List;

import com.mytaxi.entity.Car;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService
{

    Car find(final Long carId) throws EntityNotFoundException;


    List<Car> findAllCars();


    Car create(final Car car) throws EntityNotFoundException;





}
