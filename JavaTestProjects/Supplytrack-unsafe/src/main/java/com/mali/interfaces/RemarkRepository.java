package com.mali.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mali.model.Remark;

public interface RemarkRepository extends JpaRepository<Remark, Long> {

}
