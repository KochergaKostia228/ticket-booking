package com.example.ticket_booking.service.eventservice;

import com.example.ticket_booking.DTO.EventCreationDTO;
import com.example.ticket_booking.model.Customer;
import com.example.ticket_booking.model.Event;

import java.util.List;

public interface EventService {
    Event createEvent(EventCreationDTO dto) ;

    List<Event> findAll();
}
