package com.example.ticket_booking.controller;

import com.example.ticket_booking.DTO.CustomerDTO;
import com.example.ticket_booking.DTO.EventCreationDTO;
import com.example.ticket_booking.model.Customer;
import com.example.ticket_booking.model.Event;
import com.example.ticket_booking.service.customerservice.CustomerServiceImpl;
import com.example.ticket_booking.service.eventservice.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/v1")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping(value = "/customer/create")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.createCustomer(customerDTO);
        return ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/customers/get")
    public String getCustomers(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }
}
