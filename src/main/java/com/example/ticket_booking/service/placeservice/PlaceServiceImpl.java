package com.example.ticket_booking.service.placeservice;

import com.example.ticket_booking.DAO.place.PlaceRepository;
import com.example.ticket_booking.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Place findByName(String name) {
        List<Place> placeList = placeRepository.findByNameIgnoreCase(name);
        if (placeList.size() != 0) {
            Place place = placeList.get(0);
            return place;
        }
        return new Place();
    }
}
