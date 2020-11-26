package com.quanli.controller;

import com.quanli.exception.NotFoundException;
import com.quanli.model.Customer;
import com.quanli.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.CustomerService;
import service.province.IProvinceService;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView showInputNotAcceptable(){
        return new ModelAndView("notfound");
    }

    @ModelAttribute("provinces")
    private Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView getAll(@RequestParam("s") Optional<String> s,@PageableDefault(size = 10) Pageable pageable){
        Page<Customer> customers ;
        if(s.isPresent()){
            customers=customerService.findAllByFirstNameContaining(s.get(),pageable);
        }else{
            customers = customerService.findAll(pageable);}

        ModelAndView modelAndView= new ModelAndView("customer/list");
        modelAndView.addObject("customers" , customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createCustomer(){
        ModelAndView modelAndView= new ModelAndView("customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView= new ModelAndView("customer/create");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) throws NotFoundException {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        customerService.save(customer);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) throws NotFoundException {
        ModelAndView modelAndView= new ModelAndView("customer/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("customer/list");
        customerService.delete(id);
        modelAndView.addObject("customers",customerService.findAll());
        return modelAndView;
    }


}

