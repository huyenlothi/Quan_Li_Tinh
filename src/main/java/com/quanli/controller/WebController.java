package com.quanli.controller;

import com.quanli.exception.NotFoundException;
import com.quanli.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.customer.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class WebController {
    @Autowired
    private CustomerService customerService;
    @GetMapping()
    public ResponseEntity<Iterable<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> edit(@PathVariable Long id,@RequestBody Customer customer){
        customer.setId(id);
        customerService.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable Long id){
        Customer  customer;
        try {
             customer= customerService.findById(id);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
