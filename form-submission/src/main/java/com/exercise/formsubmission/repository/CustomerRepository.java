package com.exercise.formsubmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.formsubmission.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
