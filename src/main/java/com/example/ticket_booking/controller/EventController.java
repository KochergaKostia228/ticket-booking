package com.example.ticket_booking.controller;

import com.example.ticket_booking.DTO.EventCreationDTO;
import com.example.ticket_booking.DTO.PlaceDTO;
import com.example.ticket_booking.DTO.TicketPackDTO;
import com.example.ticket_booking.model.Event;
import com.example.ticket_booking.model.Ticket;
import com.example.ticket_booking.service.eventservice.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping(value = "/events/get")
    public String getEvents(Model model){
        model.addAttribute("events", eventService.findAll());
        return "events";
    }

    @PostMapping(value = "/event/create")
    public String createEvent(@ModelAttribute EventCreationDTO eventCreationDTO)
    {
        eventService.createEvent(eventCreationDTO);
        return "events";
    }

    @GetMapping(value = "/createEvent")
    public String createEventPage(Model model) {
        model.addAttribute("eventCreationDTO", new EventCreationDTO());
        model.addAttribute("ticketPackDTO", new TicketPackDTO());
        return "createEvent";
    }

    @PostMapping("/createTicketPack")
    public String createTicketPack(@ModelAttribute("eventCreationDTO") EventCreationDTO eventCreationDTO,
                                   @ModelAttribute("ticketPackDTO") TicketPackDTO ticketPackDTO,
                                   Model model) {
        // Логика для создания события и добавления билетов в базу данных
        // например, eventService.createEvent(eventCreationDTO);
        //eventService.createEvent(eventCreationDTO);

        eventCreationDTO.getTicketPacks().add(ticketPackDTO);

        model.addAttribute("eventCreationDTO", eventCreationDTO);
        return "createEvent";
    }

    @GetMapping(value = "/createEvent")
    public String createTicketPackPage(Model model) {
        model.addAttribute("eventCreationDTO", new EventCreationDTO());
        model.addAttribute("ticketPackDTO", new TicketPackDTO());
        return "createEvent";
    }

//    @PostMapping(value = "/event/buying?eventname/{eventname}/customername/{customername}")
//    public ResponseEntity<?> buyingTicketForEvent(@RequestParam(value = "eventId") String eventName,
//                                                  @PathVariable(name = "customername") String customerName){
//
//        return ResponseEntity.ok(eventName);
//    }
}
