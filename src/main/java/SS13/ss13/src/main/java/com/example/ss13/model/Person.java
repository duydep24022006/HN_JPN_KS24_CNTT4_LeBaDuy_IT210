package com.example.ss13.modal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="full_name")
    private String fullName;

    @Column(name = "age")
    private Integer age;
}
