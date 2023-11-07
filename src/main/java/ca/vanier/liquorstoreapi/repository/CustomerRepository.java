package ca.vanier.liquorstoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.liquorstoreapi.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
