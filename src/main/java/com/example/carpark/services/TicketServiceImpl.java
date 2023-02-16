package com.example.carpark.services;

import com.example.carpark.entities.Car;
import com.example.carpark.entities.Ticket;
import com.example.carpark.entities.Trip;
import com.example.carpark.repositories.CarRepo;
import com.example.carpark.repositories.TicketRepo;
import com.example.carpark.servicesInterface.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo repo;

    @Autowired
    CarRepo carRepo;

    @Override
    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> ticketList = new ArrayList<>();
        repo.findAll().forEach(ticketList::add);
        return ticketList;
    }

    @Override
    public Ticket findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> findCustomerName(String customerName) {
        return repo.findByCustomerName(customerName);
    }

    @Override
    public List<Ticket> findByLicensePlate(String licensePlate) {
        Car car =  carRepo.findById(licensePlate).orElse(null);

        return repo.findByLicensePlate(car);

    }

    @Override
    public void edit(Ticket ticket) {
        Optional<Ticket> optionalTicket = repo.findById(ticket.getTicketId());
        if (optionalTicket.isPresent()){
            Ticket opTicket = optionalTicket.get();
            opTicket.setBookingTime(ticket.getBookingTime());
            opTicket.setCustomerName(ticket.getCustomerName());
            opTicket.setLicensePlate(ticket.getLicensePlate());
            opTicket.setTripId(ticket.getTripId());
        }
    }
}
