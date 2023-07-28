package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing POST /customers
    @Test
    public void shouldCreateCustomer() throws Exception {

        // ACT
        Customer customer = new Customer();
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Phoebe");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        mockMvc.perform(post("/customers")               // Perform the POST request
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(customer))
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isCreated()); // ASSERT (status code is 201)

    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Phoebe");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepository.save(customer);

        customer.setCity("Brooklyn");

        mockMvc.perform(put("/customers")               // Perform the PUT request
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(customer))
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Phoebe");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepository.save(customer);

        mockMvc.perform(delete("/customers/1")               // Perform the DELETE request
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldGetCustomerById() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Phoebe");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepository.save(customer);

        mockMvc.perform(get("/customers/1")               // Perform the GET request
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isOk()); // ASSERT (status code is 200)
    }

    @Test
    public void shouldGetCustomerByState() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setAddress1("123 Sesame Lane");
        customer.setCity("Queens");
        customer.setAddress2("Apartment 1");
        customer.setCompany("Netflix");
        customer.setCountry("USA");
        customer.setEmail("johndoe@gmail.com");
        customer.setPhone("123-456-7890");
        customer.setFirstName("Phoebe");
        customer.setLastName("Doe");
        customer.setState("NY");
        customer.setPostalCode("11111");

        customerRepository.save(customer);

        mockMvc.perform(get("/customers/state/NY")               // Perform the GET request
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isOk()); // ASSERT (status code is 200)
    }
}