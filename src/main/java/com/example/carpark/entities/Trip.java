package com.example.carpark.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@JsonIgnoreProperties({"ticketList", "bookingList"})
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 20)
    @Max(20)
    private int tripId;

    @Column(length = 11)
    private int bookedTicketNumber;

    @Column(length = 11)
    @Size(max = 11, message = "Car Type should not exceed 11 characters")
    @NotBlank(message = "Car Type should not be blank")
    private String carType;

    @Column
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @NotNull(message = "Date should not be null")
    private Date departureDate;

    @Column
    @NotNull(message = "Time should not be null")
    private Time departureTime;

    @Column(length = 50)
    @Size(max = 50, message = "Destination should not exceed 50")
    @NotBlank(message = "Desitnation should not be blank")
    private String destination;

    @Column(length = 11)
    @Size(max = 11, message = "Driver should not exceed 11")
    @NotBlank(message = "Driver should not be blank")
    private String driver;

    @Column(length = 11)
    @NotNull(message = "Maximum Online Ticket should not be null")
    private int maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "tripId", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties("tripId")
    List<Ticket> ticketList;


    @OneToMany(mappedBy = "tripId", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties("tripId")
    List<BookingOffice> bookingList;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<BookingOffice> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<BookingOffice> bookingList) {
        this.bookingList = bookingList;
    }
}
