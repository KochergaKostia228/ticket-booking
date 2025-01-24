package com.example.ticket_booking.service.ticketservice;

import com.example.ticket_booking.DAO.ticket.TicketRepository;
import com.example.ticket_booking.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TickerServiceImpl implements TickerService{

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void createTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
