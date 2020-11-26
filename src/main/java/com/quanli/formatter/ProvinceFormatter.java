package com.quanli.formatter;

import com.quanli.exception.NotFoundException;
import com.quanli.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.province.IProvinceService;
import service.province.ProvinceServiceImpl;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province> {
//        @Autowired
    private ProvinceServiceImpl provinceService;

    @Autowired
    public ProvinceFormatter(ProvinceServiceImpl provinceService){
        this.provinceService = provinceService;
    }


    @Override
    public Province parse(String text, Locale locale)  throws ParseException{
            return provinceService.findById(Long.parseLong(text));

    }

    @Override
    public String print(Province object, Locale locale) {
        return null;
    }
}
