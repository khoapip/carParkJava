package com.example.carpark.mapper;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.Employee;
import com.example.carpark.services.ParkingLotService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public
class Mapper {

    @Autowired
    ParkingLotService parkingLotService;
    public CarDTO toCarDto(Car car) {
        int parkId = car.getParkId().getParkId();

        CarDTO carDTO = new CarDTO();

        carDTO.setCarType(car.getCarType());
        carDTO.setCompany(car.getCompany());
        carDTO.setLicensePlate(car.getLicensePlate());
        carDTO.setCarColor(car.getCarColor());
        carDTO.setParkId(parkId);
        return carDTO;
    }

    public Car toCar(CarDTO carDTO) {
        Car car = new Car();
        car.setCompany(carDTO.getCompany());
        car.setCarType(carDTO.getCarType());
        car.setCarColor(carDTO.getCarColor());
        car.setLicensePlate(carDTO.getLicensePlate());

        if (!parkingLotService.idExist(carDTO.getParkId())){
            throw new EntityNotFoundException("Parking Lot Not Found");
        }
        car.setParkId(parkingLotService.findById(carDTO.getParkId()));

        return car;
    }


}