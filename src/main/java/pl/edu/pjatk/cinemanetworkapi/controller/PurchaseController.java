package pl.edu.pjatk.cinemanetworkapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.cinemanetworkapi.model.dto.*;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Purchase;
import pl.edu.pjatk.cinemanetworkapi.model.entity.TicketTypeDiscount;
import pl.edu.pjatk.cinemanetworkapi.service.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final SeatsService seatsService;
    private final TicketService ticketService;
    private final CustomerService customerService;
    private final BuyService buyService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, SeatsService seatsService, TicketService ticketService, CustomerService customerService, BuyService buyService) {
        this.purchaseService = purchaseService;
        this.seatsService = seatsService;
        this.ticketService = ticketService;
        this.customerService = customerService;
        this.buyService = buyService;
    }

    @PostMapping("/")
    public ResponseEntity<Purchase> createPurchase() {
        return ResponseEntity.ok(purchaseService.createPurchase());
    }


    @GetMapping("/discounts")
    public ResponseEntity<List<TicketTypeDiscount>> getAllDiscounts() {
        return ResponseEntity.ok(ticketService.getAllTypesOfDiscount());
    }

    @PostMapping("/tickets")
    public ResponseEntity<PurchaseTickets> addTickets(@RequestBody DiscountTicket discountTicket, @RequestParam Long correlationId) {
        return ResponseEntity.ok(purchaseService.addTicket(discountTicket, correlationId));
    }

    @PostMapping("/seats")
    public ResponseEntity<Void> addSeats(@RequestBody SeatRequest seatRequest, @RequestParam Long correlationId) {
        seatsService.addNewSeatBooking(seatRequest, correlationId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/customer")
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerRequest customerRequest, @RequestParam Long correlationId) {
        customerService.addCustomer(customerRequest, correlationId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/buy")
    public ResponseEntity<Void> addBuy(@RequestBody BuyRequest buyRequest, @RequestParam Long correlationId) {
        buyService.addBuy(buyRequest, correlationId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseTickets> getById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }
}