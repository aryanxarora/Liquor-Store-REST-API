package ca.vanier.liquorstoreapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {

    // DATA MEMBERS
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    private int age;
    private String email;
    private String address;

    // UPDATE ALL VALUES
    public  void setAll(Customer c){
        this.name = c.getName();
        this.lastname = c.getLastname();
        this.age = c.getAge();
        this.email = c.getEmail();
        this.address = c.getAddress();
    }

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
