package com.example.carpark.services;


import com.example.carpark.entities.BookingOffice;

import java.util.List;

public interface BookingOfficeService {

    public boolean idExist(int id);

    public void add(BookingOffice office);

    public void deleteById(int id);

    public List<BookingOffice> findAll();

    public List<BookingOffice> findByOfficeName(String name);

    public BookingOffice findById(int id);

    public void edit(BookingOffice office);

}
