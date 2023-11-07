package ca.vanier.liquorstoreapi.service;

import java.util.Optional;
import ca.vanier.liquorstoreapi.entity.Customer;
public interface CustomerService {

Iterable<Customer> customers();
Customer save(Customer c);
Optional<Customer> find(Long id);
void update(Customer c);
void remove(Long id);
}
