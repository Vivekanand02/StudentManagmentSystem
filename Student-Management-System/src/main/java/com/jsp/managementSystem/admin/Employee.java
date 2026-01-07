package com.jsp.managementSystem.admin;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_seq")
    @SequenceGenerator(name = "emp_id_seq", initialValue = 100000, allocationSize = 1)
    private Long employeeId;
    @Size(min = 2)
    private String name;
    @Column
    @Email(message = "invalid email")
    private String email;
    @Size(min = 10, max = 10, message = "valid phone number")
    private String phone;
    private String role;
    private String password;
    private LocalDate dateOfBirth;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}