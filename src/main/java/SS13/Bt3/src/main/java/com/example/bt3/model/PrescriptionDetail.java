package com.example.bt3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prescription_detail")
public class PrescriptionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "medicine_name")
    private String medicineName;
    @Column(name="quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}

