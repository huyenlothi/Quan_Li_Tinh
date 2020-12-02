package com.quanli.controller;

import com.quanli.model.Customer;
import com.quanli.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.CustomerService;
import service.province.IProvinceService;

import java.security.acl.LastOwnerException;

@Controller
@RequestMapping("/customers")
public class AjaxCustomerController {
@Autowired
    private CustomerService customerService;
    @Autowired
    private IProvinceService provinceService;
    @ModelAttribute("provinces")
    Iterable<Province> provinces(){
        return provinceService.findAll();
    }
@GetMapping("/list")
    public ModelAndView list(){
    ModelAndView modelAndView = new ModelAndView("customer/index");
    modelAndView.addObject("customer", customerService.findAll());
    return modelAndView;
}
@GetMapping()
    public ResponseEntity<Iterable<Customer>> getAll(){
    return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
}
@PostMapping("/")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
    customerService.save(customer);
    return new ResponseEntity<>(HttpStatus.OK);
}
@PutMapping("/{id}")
    public ResponseEntity<Customer> edit(@PathVariable Long id, @RequestBody Customer customer){
    customer.setId(id);
    customerService.save(customer);
    return new ResponseEntity<>(HttpStatus.OK);
}
@DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
    customerService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
}
}
