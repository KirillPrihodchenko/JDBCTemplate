package com.crud_simple.traine_crud.models;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Phone {

    @NotBlank
    private String name;
    @NotEmpty
    @Valid
    @DateTimeFormat
    private Date announcedDate;
    @NotEmpty
    @Size(min = 0, message = "price can not be a negative")
    private int price;

    public Phone() { }

    public Phone(String name, Date announcedDate, int price) {
        this.name = name;
        this.announcedDate = announcedDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAnnouncedDate() {
        return announcedDate;
    }

    public void setAnnouncedDate(Date announcedDate) {
        this.announcedDate = announcedDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
