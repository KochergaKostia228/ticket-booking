package com.example.ticket_booking.DTO;

import com.example.ticket_booking.model.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    private String name;

    private String email;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
