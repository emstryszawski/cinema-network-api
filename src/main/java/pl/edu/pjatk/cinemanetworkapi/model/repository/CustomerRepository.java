package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}