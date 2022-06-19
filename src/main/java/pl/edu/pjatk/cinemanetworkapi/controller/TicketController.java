package pl.edu.pjatk.cinemanetworkapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.cinemanetworkapi.model.dto.DiscountTicket;
import pl.edu.pjatk.cinemanetworkapi.model.dto.TicketBuilderDTO;
import pl.edu.pjatk.cinemanetworkapi.model.entity.TicketTypeDiscount;
import pl.edu.pjatk.cinemanetworkapi.service.PurchaseService;
import pl.edu.pjatk.cinemanetworkapi.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final PurchaseService purchaseService;

    public TicketController(TicketService ticketService, PurchaseService purchaseService) {
        this.ticketService = ticketService;
        this.purchaseService = purchaseService;
    }

//    @GetMapping("")
//    public ResponseEntity<TicketBuilderDTO.TicketBuilderDTOBuilder> getTicketBuilder() {
//        return ResponseEntity.ok(ticketService.getTicketBuilder());
//    }

    @GetMapping("/discounts")
    public ResponseEntity<List<TicketTypeDiscount>> getAllDiscounts() {
        return ResponseEntity.ok(ticketService.getAllTypesOfDiscount());
    }
}
