package com.example.ticket_booking.service.customerservice;

import com.example.ticket_booking.DTO.CustomerDTO;
import com.example.ticket_booking.model.Customer;

import java.util.List;

public interface СustomerService {
    Customer createCustomer(CustomerDTO customerDTO);

    List<Customer> findAll();
}
