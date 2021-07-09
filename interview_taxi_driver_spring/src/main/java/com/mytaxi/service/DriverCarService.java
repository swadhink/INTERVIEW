package com.mytaxi.service;

import com.mytaxi.entity.DriverCar;

public interface DriverCarService
{


    DriverCar save(DriverCar driverCar);


    DriverCar findByDriverIdAndCarId(final Long driverId, final Long carId);

}
