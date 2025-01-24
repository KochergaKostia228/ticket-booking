package com.example.ticket_booking.service.placeservice;

import com.example.ticket_booking.model.Place;

public interface PlaceService {
    Place findByName(String name);
}
