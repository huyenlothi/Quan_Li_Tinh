package com.quanli.controller;

import com.quanli.exception.NotFoundException;
import com.quanli.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.province.IProvinceService;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("province/getAll");
        Iterable<Province> provinces = provinceService.findAll() ;
        modelAndView.addObject("province", provinces);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView= new ModelAndView("province/createProvince");
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Province province){
        ModelAndView modelAndView= new ModelAndView("province/createProvince");
        provinceService.save(province);
        modelAndView.addObject("province",province);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("province/edit");
        try {
            Province province= provinceService.findById(id);
            modelAndView.addObject("province",province);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Province province){
        ModelAndView modelAndView= new ModelAndView("province/edit");
        provinceService.save(province);
        modelAndView.addObject("province",province);
        return modelAndView;
    }

}
