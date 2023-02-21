package com.example.carpark.services.impl;

import com.example.carpark.entities.ParkingLot;
import com.example.carpark.repositories.ParkingLotRepo;
import com.example.carpark.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepo repo;
    @Override
    public void add(ParkingLot lot) {
        repo.save(lot);
    }

    @Override
    public boolean idExist(int id) {
        return repo.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<ParkingLot> findAll() {
        List<ParkingLot> parkList = new ArrayList<>();
        repo.findAll().forEach(parkList::add);
        return parkList;
    }

    @Override
    public List<ParkingLot> findByParkArea(int area) {
        return repo.findByParkArea(area);
    }

    @Override
    public List<ParkingLot> findByParkPlace(String place) {
        return repo.findByParkPlace(place);
    }

    @Override
    public ParkingLot findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void edit(ParkingLot lot) {
        Optional<ParkingLot> optionalPark = repo.findById(lot.getParkId());
        if (optionalPark.isPresent()){
            ParkingLot opPark = optionalPark.get();
            opPark.setParkArea(lot.getParkArea());
            opPark.setParkName(lot.getParkName());
            opPark.setParkPlace(lot.getParkPlace());
            opPark.setParkPrice(lot.getParkPrice());
            opPark.setParkStatus(lot.getParkStatus());
        }
    }
}
