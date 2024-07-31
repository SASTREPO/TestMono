package com.mali.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mali.model.PackingList;

public interface PackingListRepository extends JpaRepository<PackingList, Long> {

}
