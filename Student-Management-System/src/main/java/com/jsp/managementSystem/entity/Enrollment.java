package com.jsp.managementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;
    private double amountPaid;
}
