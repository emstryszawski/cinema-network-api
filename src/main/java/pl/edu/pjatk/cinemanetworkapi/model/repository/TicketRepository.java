package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Purchase;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("select t from Ticket t where t.correlationId = ?1")
    public List<Ticket> findByCorrelationId(Long correlationId);
}