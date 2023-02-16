package com.example.carpark.servicesInterface;


import com.example.carpark.entities.Ticket;

import java.util.List;

public interface TicketService {

    public void add(Ticket ticket);

    public void deleteById(int id);

    public List<Ticket> findAll();


    public Ticket findById(int id);

    public List<Ticket> findCustomerName(String customerName);

    public List<Ticket> findByLicensePlate(String licensePlate);

    public void edit(Ticket ticket);

}
