package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;

    @BeforeEach
    public void setUp() throws Exception{
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer(){

        Customer customer = new Customer();
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(),customer);

    }

    @Test
    public void updateCustomer(){

        Customer customer = new Customer();
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Jane");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepo.save(customer);

        customer.setLastName("Smith");

        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(),customer);

    }

    @Test
    public void deleteCustomer() {

        Customer customer = new Customer();
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Jane");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepo.save(customer);

        customerRepo.deleteById(customer.getCustomerId());

        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertFalse(customer1.isPresent());
    }

    @Test
    public void getCustomerById() {
        Customer customer = new Customer();
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Stacy");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertTrue(customer1.isPresent());
    }

    @Test
    public void getCustomersByState() {
        Customer customer = new Customer();
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Stacy");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepo.save(customer);

        Customer customer1 = new Customer();
        customer1.setAddress1("123 Sesame Lane");
        customer1.setCity("Queens");
        customer1.setAddress2("Apartment 1");
        customer1.setCompany("Netflix");
        customer1.setCountry("USA");
        customer1.setEmail("johndoe@gmail.com");
        customer1.setPhone("123-456-7890");
        customer1.setFirstName("Alice");
        customer1.setLastName("Doe");
        customer1.setState("NY");
        customer1.setPostalCode("11111");

        customerRepo.save(customer1);

        List<Customer> customerList = customerRepo.findAllCustomersByState("NY");

        assertEquals(2,customerList.size());
    }

}