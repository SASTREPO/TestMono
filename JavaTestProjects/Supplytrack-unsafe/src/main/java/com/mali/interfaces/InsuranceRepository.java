package com.mali.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mali.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}
