package com.api_example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile", unique = true)
    private String mobile;

}