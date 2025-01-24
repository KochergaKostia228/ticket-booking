package com.example.ticket_booking.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EventCreationDTO {
    private Date eventDate;
    private String eventName;
    private List<TicketPackDTO> ticketPacks = new ArrayList<>();
    private PlaceDTO place;

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<TicketPackDTO> getTicketPacks() {
        return ticketPacks;
    }

    public void setTicketPacks(List<TicketPackDTO> ticketPacks) {
        this.ticketPacks = ticketPacks;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }
}
