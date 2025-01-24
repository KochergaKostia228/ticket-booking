package com.example.ticket_booking.service.customerservice;

import com.example.ticket_booking.DAO.customer.CustomerRepository;
import com.example.ticket_booking.DTO.CustomerDTO;
import com.example.ticket_booking.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements СustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer : customers){
            if(customer.getEmail().equals(customerDTO.getEmail())){
                return customer;
            }
        }

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        customerRepository.save(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
