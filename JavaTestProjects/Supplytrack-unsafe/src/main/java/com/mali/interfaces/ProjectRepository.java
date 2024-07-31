package com.mali.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mali.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
