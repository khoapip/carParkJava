package com.example.carpark.services.impl;

import com.example.carpark.entities.BookingOffice;
import com.example.carpark.repositories.BookingOfficeRepo;
import com.example.carpark.services.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingOfficeServiceImpl implements BookingOfficeService {

    @Autowired
    BookingOfficeRepo repo;

    @Override
    public boolean idExist(int id) {
        return repo.existsById(id);
    }

    @Override
    public void add(BookingOffice office) {
        repo.save(office);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<BookingOffice> findAll() {
        List<BookingOffice> bookingOfficeList = new ArrayList<>();
        repo.findAll().forEach(bookingOfficeList::add);
        return bookingOfficeList;
    }

    @Override
    public List<BookingOffice> findByOfficeName(String name) {
        return repo.findByOfficeName(name);
    }

    @Override
    public BookingOffice findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void edit(BookingOffice office) {
        Optional<BookingOffice> optionalBookingOffice = repo.findById(office.getOfficeId());
        if (optionalBookingOffice.isPresent()){
            BookingOffice opOffice = optionalBookingOffice.get();
            opOffice.setOfficeName(office.getOfficeName());
            opOffice.setOfficePhone(office.getOfficePhone());
            opOffice.setOfficePlace(office.getOfficePlace());
            opOffice.setOfficePrice(office.getOfficePrice());
            opOffice.setTripId(office.getTripId());
            opOffice.setStartContractDeadline(opOffice.getStartContractDeadline());
            opOffice.setEndContractDeadline(opOffice.getEndContractDeadline());
        }
    }
}
