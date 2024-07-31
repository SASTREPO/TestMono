package com.mali.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mali.model.ProformalInvoice;

public interface PFIRepository extends JpaRepository<ProformalInvoice, Long> {

}
