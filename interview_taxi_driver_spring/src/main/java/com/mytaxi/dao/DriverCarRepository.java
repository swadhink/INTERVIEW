package com.mytaxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytaxi.dto.CarDTO;
import com.mytaxi.dto.DriverDTO;
import com.mytaxi.entity.DriverCar;

public interface DriverCarRepository extends CrudRepository<DriverCar, Long>
{
    DriverCar findByDriverIdAndCarId(final Long driverId, final Long carId);

}
