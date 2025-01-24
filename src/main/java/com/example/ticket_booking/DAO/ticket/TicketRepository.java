package com.example.ticket_booking.DAO.ticket;

import com.example.ticket_booking.model.Event;
import com.example.ticket_booking.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
