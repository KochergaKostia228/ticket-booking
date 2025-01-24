package com.example.ticket_booking.service.eventservice;

import com.example.ticket_booking.DAO.customer.CustomerRepository;
import com.example.ticket_booking.DAO.event.EventRepository;
import com.example.ticket_booking.DAO.place.PlaceRepository;
import com.example.ticket_booking.DAO.ticket.TicketRepository;
import com.example.ticket_booking.DTO.EventCreationDTO;
import com.example.ticket_booking.DTO.TicketPackDTO;
import com.example.ticket_booking.model.*;
import com.example.ticket_booking.service.placeservice.PlaceService;
import com.example.ticket_booking.service.placeservice.PlaceServiceImpl;
import com.example.ticket_booking.service.ticketservice.TickerService;
import com.example.ticket_booking.service.ticketservice.TickerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private TickerService tickerService;

    @Override
    public Event createEvent(EventCreationDTO dto) {

        Place place = placeService.findByName(dto.getPlace().getName());

        if(place.getName() == "" && place.getAddress() == ""){
            place.setName(dto.getPlace().getName());
            place.setAddress(dto.getPlace().getAddress());
        }

        Event event = new Event();
        event.setName(dto.getEventName());
        event.setEvent_date(dto.getEventDate());
        event.setPlace(place);
        eventRepository.save(event);

        for (TicketPackDTO ticketPack : dto.getTicketPacks()) {
            for (int i = 0; i < ticketPack.getCount(); i++) {
                Ticket ticket = new Ticket();
                ticket.setCost(ticketPack.getCost());
                ticket.setNumber(i);
                if(ticket.getCost() == BigDecimal.ZERO){
                    ticket.setStatus(StatusTicket.FREE);
                }
                else{
                    ticket.setStatus(StatusTicket.SOLD);
                }
                ticket.setEvent(event);
                ticket.setCustomer(null);
                tickerService.createTicket(ticket);
                event.getTicketList().add(ticket);
            }
        }

        return event;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
