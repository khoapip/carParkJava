package com.example.carpark.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@JsonIgnoreProperties({"ticketList", "bookingList"})
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int tripId;

    @Column(length = 11)
    private int bookedTicketNumber;

    @Column(length = 11)
    private String carType;

    @Column
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date departureDate;

    @Column
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    private Time departureTime;

    @Column(length = 50)
    private String destination;

    @Column(length = 11)
    private String driver;

    @Column(length = 11)
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
