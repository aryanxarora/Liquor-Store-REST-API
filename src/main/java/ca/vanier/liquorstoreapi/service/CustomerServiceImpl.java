package ca.vanier.liquorstoreapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.liquorstoreapi.entity.Customer;
import ca.vanier.liquorstoreapi.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository cr;

    // THIS METHOD FINDS ALL CUSTOMERS IN DATABASE AND RETURNS AS A ITERABLE LIST
    @Override
    public Iterable<Customer> customers() {
        return cr.findAll();
    }

    // THIS METHODS SAVES CUSTOMER PASSED INTO DATABASE
    @Override
    public Customer save(Customer c) {
        return cr.save(c);
    }

    // THIS METHOD FINDS CUSTOMER IN DATABASE USING ID
    @Override
    public Optional<Customer> find(Long id) {
        return cr.findById(id);
    }

    // THIS METHOD UPDATES CUSTOMER INFO IN THE DATABASE BY PASSING A NEW CUSTOMER OBJECT WITH ITS ID
    @Override
    public void update(Customer c) {
        Optional<Customer> customer = cr.findById(c.getId());
        if (customer.isPresent()) {
            System.out.println("UPDATING CUSTOMER");
            customer.get().setAll(c);
            cr.save(customer.get());
        }
    }

    // THIS METHOD REMOVES CUSTOMER FROM DATABASE USING ID
    @Override
    public void remove(Long id) {
        cr.deleteById(id);
    }
}
