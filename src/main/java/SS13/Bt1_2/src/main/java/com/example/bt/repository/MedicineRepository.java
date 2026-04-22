package com.example.bt.repository;

import com.example.bt.model.Medicine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MedicineRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Medicine> findExpiredMedicines(LocalDate today) {
        String hql = "FROM Medicine m WHERE m.expiryDate < :today";
        return entityManager.createQuery(hql, Medicine.class)
                .setParameter("today", today)
                .getResultList();
    }
}