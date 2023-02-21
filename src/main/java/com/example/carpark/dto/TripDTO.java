package com.example.carpark.dto;



import com.example.carpark.entities.BookingOffice;
import com.example.carpark.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class TripDTO {

    private int bookedTicketNumber;

    private String carType;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date departureDate;

    private Time departureTime;


    private String destination;


    private String driver;

    private int maximumOnlineTicketNumber;


    private String msg;

    private List<TicketDTO> ticketList;


    private List<BookingOfficeDTO> bookingList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public List<TicketDTO> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<TicketDTO> ticketList) {
        this.ticketList = ticketList;
    }

    public List<BookingOfficeDTO> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<BookingOfficeDTO> bookingList) {
        this.bookingList = bookingList;
    }
}
