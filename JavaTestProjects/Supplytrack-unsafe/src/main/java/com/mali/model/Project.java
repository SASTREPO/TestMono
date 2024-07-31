package com.mali.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
	@SequenceGenerator(name = "project_generator", allocationSize = 10, sequenceName = "project_gen")
	@Id
	private Long id;

	private String projectId;

	private String projectName;

	private String projectManager;

	private String supplyCategory;

	private String supplierNumber;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectManager
	 */
	public String getProjectManager() {
		return projectManager;
	}

	/**
	 * @param projectManager the projectManager to set
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * @return the supplyCategory
	 */
	public String getSupplyCategory() {
		return supplyCategory;
	}

	/**
	 * @param supplyCategory the supplyCategory to set
	 */
	public void setSupplyCategory(String supplyCategory) {
		this.supplyCategory = supplyCategory;
	}

	/**
	 * @return the supplierNumber
	 */
	public String getSupplierNumber() {
		return supplierNumber;
	}

	/**
	 * @param supplierNumber the supplierNumber to set
	 */
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

}
