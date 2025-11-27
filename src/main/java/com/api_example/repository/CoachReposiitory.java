package com.api_example.repository;

import com.api_example.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachReposiitory extends JpaRepository<Coach ,Long> {
}
