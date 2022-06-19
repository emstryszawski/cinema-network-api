package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query("select p from Purchase p where p.correlationId = ?1")
    public Purchase findByCorrelationId(Long correlationId);
}