package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 20)
    private int officeId;

    @Column
    private Date endContractDeadline;

    @Column(length = 50)
    @Size(max = 50, message = "Office Name should be within 50 characters")
    @NotBlank(message = "Office Name should not be blank")
    private String officeName;

    @Column(length = 11)
    @Size(max = 11, message = "Office Phone should be within 11 characters")
    @NotBlank(message = "Office Phone should not be blank")
    private String officePhone;

    @Column(length = 50)
    @Size(max = 50, message = "Office Phone should be within 50 characters")
    private String officePlace;

    @Column(length = 20)
    @NotNull(message = "Office Price should not be blank")
    private int officePrice;

    @Column
    private Date startContractDeadline;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "tripId")
    @JsonIgnoreProperties("bookingList")
    private Trip tripId;

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public int getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(int officePrice) {
        this.officePrice = officePrice;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public Trip getTripId() {
        return tripId;
    }

    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }

}
