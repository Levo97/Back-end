package com.avinty.hr.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@DynamicInsert
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int  department_id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Employee manager_id;

    @CreationTimestamp
    private LocalDateTime created_at;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private Employee created_by;

    @CreationTimestamp
    private LocalDateTime updated_at;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private Employee updated_by;


    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST }, mappedBy = "department")
    private List<Employee> employees;
    @PreRemove
    public void deleteConnections(){
        this.getEmployees().forEach(employee -> employee.setDepartment(null));
    }
}
