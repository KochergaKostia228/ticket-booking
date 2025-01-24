package com.example.ticket_booking.controller;

import com.example.ticket_booking.DTO.EventCreationDTO;
import com.example.ticket_booking.DTO.PlaceDTO;
import com.example.ticket_booking.DTO.TicketPackDTO;
import com.example.ticket_booking.service.ticketservice.TickerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1")
public class TicketController {

    @Autowired
    private TickerServiceImpl tickerService;

    @PostMapping(value = "/ticketPack/create")
    public String createTicketPack(@RequestParam("ticketCost") BigDecimal ticketCost,
                              @RequestParam("ticketCount") int ticketCount
    )
    {
        TicketPackDTO ticketPackDTO = new TicketPackDTO();


        ticketPackDTO.setCost(ticketCost);
        ticketPackDTO.setCount(ticketCount);

        List<TicketPackDTO> ticketPackDTOList = new ArrayList<>();
        ticketPackDTOList.add(ticketPackDTO);



        //tickerService.(ticketPackDTO);
        return "createEvent";
    }

    @GetMapping(value = "/createTicketPack")
    public String createEventPage() {
        return "createTicketPack";
    }
}
