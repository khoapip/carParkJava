package com.example.carpark.repositories;

import com.example.carpark.entities.BookingOffice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingOfficeRepo extends CrudRepository<BookingOffice, Integer> {

    public List<BookingOffice> findByOfficeName(String officeName);

}
