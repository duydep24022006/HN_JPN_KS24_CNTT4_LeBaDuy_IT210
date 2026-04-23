package com.example.bt3.repository;

import com.example.bt3.modal.Hospital;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HospitalRepo {
    private final Map<Long, Hospital> storage = new HashMap();

    public HospitalRepo() {
        // Thêm 3 đối tượng dữ liệu mẫu
        storage.put(1L, new Hospital(1, "Bệnh viện Bạch Mai", "024-3869-3731"));
        storage.put(2L, new Hospital(2, "Bệnh viện Việt Đức", "024-3825-3531"));
        storage.put(3L, new Hospital(3, "Bệnh viện Nhi Trung Ương", "024-6273-8532"));
    }

    public List<Hospital> findAll() {
        return new ArrayList(storage.values());
    }
}
