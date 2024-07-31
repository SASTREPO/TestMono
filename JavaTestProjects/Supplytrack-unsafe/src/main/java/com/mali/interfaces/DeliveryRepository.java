package com.mali.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mali.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
