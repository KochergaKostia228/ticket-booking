package com.example.ticket_booking.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDTO {
    private String address;
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
