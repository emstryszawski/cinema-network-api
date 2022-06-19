package pl.edu.pjatk.cinemanetworkapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.cinemanetworkapi.model.dto.*;
import pl.edu.pjatk.cinemanetworkapi.model.entity.*;
import pl.edu.pjatk.cinemanetworkapi.model.repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {
    private PurchaseRepository purchaseRepository;
    private CinemaRepository cinemaRepository;
    private TicketRepository ticketRepository;
    private RepertoireRepository repertoireRepository;
    private TicketTypeDiscountRepository discountRepository;

    private ModelMapper mapper;

    private CorrelationService correlationService;

    public PurchaseService(PurchaseRepository purchaseRepository,
                           CinemaRepository cinemaRepository,
                           TicketRepository ticketRepository,
                           RepertoireRepository repertoireRepository,
                           TicketTypeDiscountRepository discountRepository,
                           CorrelationService correlationService) {
        this.purchaseRepository = purchaseRepository;
        this.cinemaRepository = cinemaRepository;
        this.ticketRepository = ticketRepository;
        this.repertoireRepository = repertoireRepository;
        this.discountRepository = discountRepository;
        this.correlationService = correlationService;

        this.mapper = new ModelMapper();
    }

    public Purchase createPurchase() {
        Purchase purchase = new Purchase();
        purchase.setCorrelationId(correlationService.getCorrelationId());
        purchase.setPurchasedate(LocalDateTime.now());
        purchase.setTickets(new ArrayList<>());
        purchaseRepository.save(purchase);
        return purchase;
    }

    public PurchaseTickets addTicket(DiscountTicket discountTicket, Long correlationId) {
        Purchase purchase = purchaseRepository.findByCorrelationId(correlationId);
        Cinema cinema = cinemaRepository.findById(discountTicket.getCinemaId()).orElse(null);
        Repertoire repertoire = repertoireRepository.findById(discountTicket.getRepertoireId()).orElse(null);
        TicketTypeDiscount discount = discountRepository.findById(discountTicket.getDiscountId()).orElse(null);
        List<Ticket> tickets = new ArrayList<>();

        List<TicketResponse> ticketResponses = new ArrayList<>();
        for (int i = 0; i < discountTicket.getNumberOfTickets(); i++) {
            // entity
            Ticket ticket = new Ticket();
            ticket.setCinema(cinema);
            ticket.setRepertoire(repertoire);
            ticket.setTicketTypeDiscount(discount);
            ticket.setCorrelationId(correlationId);
            ticket.setPurchase(purchase);
            ticketRepository.save(ticket);
            tickets.add(ticket);

            // dto
            ticketResponses.add(TicketResponse.builder()
                    .cinemaName(cinema.getName())
                    .movieTitle(repertoire.getMovie().getTitle())
                    .ticketTypeName(discount.getName())
                    .build());
        }
        purchase.setTickets(tickets);
        purchase.setPrice((purchase.getPrice() != null ? purchase.getPrice() : 0.0) + calculatePriceForTickets(tickets.size(), discount.getDiscountValue()));
        purchaseRepository.save(purchase);

        return PurchaseTickets.builder()
                .correlationId(correlationId)
                .purchaseDate(purchase.getPurchasedate())
                .price(purchase.getPrice())
                .tickets(ticketResponses)
                .build();
    }

    public Purchase getPurchaseByCorrelationId(Long correlationId) {
        return purchaseRepository.findByCorrelationId(correlationId);
    }

    public PurchaseTickets getPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElse(null);
        List<Ticket> tickets = purchase.getTickets();
        List<TicketResponse> ticketResponses = tickets.stream()
                .map(ticket -> TicketResponse.builder()
                        .cinemaName(ticket.getCinema().getName())
                        .movieTitle(ticket.getRepertoire().getMovie().getTitle())
                        .ticketTypeName(ticket.getTicketTypeDiscount().getName())
                        .seatNumber(ticket.getSeatBooking() != null  ?
                                ticket.getSeatBooking().getSeat().getSeatNumber() : null)
                        .rowNumber(ticket.getSeatBooking() != null ?
                                ticket.getSeatBooking().getSeat().getRowNumber() : null)
                        .build())
                .collect(Collectors.toList());

        Customer customer = purchase.getCustomer();
        CustomerResponse customerResponse = null;
        if (customer != null) {
             customerResponse = CustomerResponse.builder()
                    .firstname(customer.getFirstname())
                    .lastname(customer.getLastname())
                    .email(customer.getEmail())
                    .phoneNumber(customer.getPhoneNumber())
                    .build();
        }

        Buy buy = purchase.getBuy();
        BuyResponse buyResponse = null;
        if (buy != null) {
            buyResponse = BuyResponse.builder()
                    .deliveryMethod(buy.getDeliveryMethod().name())
                    .paymentMethod(buy.getPaymentMethod().name())
                    .paidDate(buy.getPaidDate())
                    .paid(buy.getPaid())
                    .build();
        }

        return PurchaseTickets.builder()
                .correlationId(purchase.getCorrelationId())
                .purchaseDate(purchase.getPurchasedate())
                .price(purchase.getPrice())
                .customerResponse(customerResponse)
                .buyResponse(buyResponse)
                .tickets(ticketResponses)
                .build();
    }

    private Double calculatePriceForTickets(int numberOfTickets, Integer discountValue) {
        if (discountValue == 0) return numberOfTickets * 25.0;
        return (25.0 * (discountValue / 100.0)) * numberOfTickets;
    }
}
