package pl.edu.pjatk.cinemanetworkapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.cinemanetworkapi.model.dto.TicketBuilderDTO;
import pl.edu.pjatk.cinemanetworkapi.model.entity.TicketTypeDiscount;
import pl.edu.pjatk.cinemanetworkapi.model.repository.TicketRepository;
import pl.edu.pjatk.cinemanetworkapi.model.repository.TicketTypeDiscountRepository;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketTypeDiscountRepository ticketTypeDiscountRepository;

    public TicketService(TicketRepository ticketRepository, TicketTypeDiscountRepository ticketTypeDiscountRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketTypeDiscountRepository = ticketTypeDiscountRepository;
    }

    public List<TicketTypeDiscount> getAllTypesOfDiscount() {
        return ticketTypeDiscountRepository.findAll();
    }

    public TicketBuilderDTO.TicketBuilderDTOBuilder getTicketBuilder() {
        return TicketBuilderDTO.builder();
    }
}
