package ca.vanier.liquorstoreapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.vanier.liquorstoreapi.entity.Customer;
import ca.vanier.liquorstoreapi.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService cs;

    // THIS IS A GET REQUEST ON THE PATH CUSTOMERS TO RETURN ALL CUSTOMERS IN THE DATABASE
    @GetMapping("/")
    public Iterable<Customer> customers(){
        return cs.customers();
    }

    // THIS IS A POST REQUEST HANDLER THAT CHECKS IF CUSTOMER IS OF AGE, THEN SAVES THEM TO DATABASE
    @PostMapping("/save")
    public void save(@RequestBody Customer c){
        if(c.getAge() >= 18){
            cs.save(c);
        } else {
            System.out.println("UNDER AGE");
        }
    }

    // THIS IS A GET REQUEST HANDLER THAT USES ID TO RETURN INFORMATION ON CUSTOMER
    @GetMapping("/find")
    public Customer find(@RequestParam Long id){
        return cs.find(id).get();
    }

    // THIS IS A PUT REQUEST HANDLER THAT UPDATES THE INFO ON CUSTOMERS IN DATABASE
    @PutMapping("/update")
    public void update(@RequestBody Customer c){
        if(c.getAge() >= 18){
            cs.update(c);
        } else {
            System.out.println("CANNOT UPDATE TO UNDERAGE");
        }
    }

    // THIS IS A DELETE REQUEST HANDLER THAT USES ID TO DELETE CUSTOMER FROM DATABASE
    @DeleteMapping("/remove")
    public void remove(@RequestParam Long id){
        cs.remove(id);
    }

}
