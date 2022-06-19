package pl.edu.pjatk.cinemanetworkapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.cinemanetworkapi.model.dto.CustomerRequest;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Customer;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Purchase;
import pl.edu.pjatk.cinemanetworkapi.model.repository.CustomerRepository;
import pl.edu.pjatk.cinemanetworkapi.model.repository.PurchaseRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;

    public CustomerService(CustomerRepository customerRepository, PurchaseRepository purchaseRepository) {
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public void addCustomer(CustomerRequest customerRequest, Long correlationId) {
        Purchase purchase = purchaseRepository.findByCorrelationId(correlationId);
        Customer customer = new Customer();
        customer.setFirstname(customerRequest.getFirstname());
        customer.setLastname(customerRequest.getLastname());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());

        customerRepository.save(customer);
        purchase.setCustomer(customer);
        purchaseRepository.save(purchase);
    }
}
