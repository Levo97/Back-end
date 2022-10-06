package com.avinty.hr.entity;


import java.time.LocalDateTime;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int  employee_id;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(255)", unique = true)
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(66)")
    private String password;

    @Column(name = "full_name", nullable = false, columnDefinition = "varchar(200)")
    private String full_name;

    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "id")
    private Department department;

    @CreationTimestamp
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private Employee created_by;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private Employee updated_by;
}