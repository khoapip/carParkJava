package com.example.carpark.servicesInterface;


import com.example.carpark.entities.BookingOffice;

import java.util.List;

public interface BookingOfficeService {

    public void add(BookingOffice office);

    public void deleteById(int id);

    public List<BookingOffice> findAll();

    public List<BookingOffice> findByOfficeName(String name);

    public BookingOffice findById(int id);

    public void edit(BookingOffice office);

}
