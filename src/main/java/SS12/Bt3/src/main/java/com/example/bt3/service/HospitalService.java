package com.example.bt3.service;

import com.example.bt3.modal.Hospital;
import com.example.bt3.repository.HospitalRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    private final HospitalRepo hospitalRepo = new HospitalRepo();

    public List<Hospital> getAll() {
        return hospitalRepo.findAll();
    }

    public void renderHospital(Hospital hospital) {
        System.out.println("Chào mừng đến với " + hospital.getName());
        System.out.println("Hotline của bệnh viện là " + hospital.getHotline());
    }
}
