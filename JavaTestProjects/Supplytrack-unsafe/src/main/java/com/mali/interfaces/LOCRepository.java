package com.mali.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mali.model.LetterOfCredit;

public interface LOCRepository extends JpaRepository<LetterOfCredit, Long> {

}
