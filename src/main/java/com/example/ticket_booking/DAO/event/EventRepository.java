package com.example.ticket_booking.DAO.event;

import com.example.ticket_booking.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Long> {
}
