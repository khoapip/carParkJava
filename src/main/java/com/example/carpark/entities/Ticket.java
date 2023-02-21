package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Time;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @Column(length = 20)
    @Size(max = 20)
    private int ticketId;

    @Column
    private Time bookingTime;

    @Column(length = 11)
    @Size(max = 11, message = "Customer Name should not exceed 11 characters")
    @NotBlank(message = "Customer Name should not be blank")
    private String customerName;

    //Many to One Here
    @ManyToOne
    @JoinColumn(name="licensePlate", referencedColumnName = "licensePlate")
    @NotNull(message = "License Plate should not be blank")
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
