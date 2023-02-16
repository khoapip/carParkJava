package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.sql.Time;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private int ticketId;

    @Column
    private Time bookingTime;

    @Column(length = 11)
    private String customerName;

    //Many to One Here
    @ManyToOne
    @JoinColumn(name="licensePlate", referencedColumnName = "licensePlate")
    private Car licensePlate;

    //Many to One here

    @ManyToOne
    @JoinColumn(name="tripId", referencedColumnName = "tripId")
    @JsonIgnoreProperties(value = "ticketList")
    private Trip tripId;


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Car getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Car licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }
}
