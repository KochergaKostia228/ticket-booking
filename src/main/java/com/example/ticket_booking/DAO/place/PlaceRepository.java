package com.example.ticket_booking.DAO.place;

import com.example.ticket_booking.model.Event;
import com.example.ticket_booking.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT e FROM Place e WHERE LOWER(e.name) = LOWER(:name)")
    List<Place> findByNameIgnoreCase(@Param("name") String name);
}
