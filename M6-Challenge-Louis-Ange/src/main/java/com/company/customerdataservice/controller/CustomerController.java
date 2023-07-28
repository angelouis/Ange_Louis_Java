package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    //Create
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    //Update
    //In Insomnia, customerId you want to change needs to be sent in request body
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer){
        repo.save(customer);
    }

    //Delete
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id){
        repo.deleteById(id);
    }

    //Read (By Id)
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id){
        Optional<Customer> returnValue = repo.findById(id);

        if(returnValue.isPresent()){
            return returnValue.get();
        }
        else{
            return null;
        }
    }

    //Read By State
    @GetMapping("/customers/state/{state}")
    public List<Customer> getCustomersByState(@PathVariable String state){
        return repo.findAllCustomersByState(state);
    }

}
