package com.example.bt3.controller;

import com.example.bt3.service.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HospitalController {
    private final HospitalService hospitalService = new HospitalService();

    @GetMapping
    public String hospital() {
        hospitalService.getAll().forEach(hospitalService::renderHospital);
        return "hospital";
    }


}
