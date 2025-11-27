package com.api_example.repository;

import com.api_example.entity.Railway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RailwayRepository extends JpaRepository<Railway,Long> {
}
