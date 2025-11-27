package com.api_example.repository;

import com.api_example.entity.StudentAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAddressRepository extends JpaRepository<StudentAddress , Long> {
}
