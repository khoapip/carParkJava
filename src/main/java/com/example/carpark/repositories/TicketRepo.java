package com.example.carpark.repositories;

import com.example.carpark.entities.Car;
import com.example.carpark.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer> {

//    public void deleteByTicketId(int ticketId);
    public List<Ticket> findByCustomerName(String name);
    public List<Ticket> findByLicensePlate(Car car);
}
