package com.mali.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class CRIA {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cria_generator")
	@SequenceGenerator(name = "cria_generator", allocationSize = 1, sequenceName = "cria_gen")
	@Id
	private Long id;
	
	private String bolNumber;
	
	private String formMNumber;
	
	private String locNumber;
	
	private LocalDate issuanceDate;
	
	private LocalDate inspectionDate;
	
	private String fileName;

	@OneToOne
	@JoinColumn
	Project project;
	
	@Transient
	private Long projectId;

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
	 * @return the bolNumber
	 */
	public String getBolNumber() {
		return bolNumber;
	}

	/**
	 * @param bolNumber the bolNumber to set
	 */
	public void setBolNumber(String bolNumber) {
		this.bolNumber = bolNumber;
	}

	/**
	 * @return the formMNumber
	 */
	public String getFormMNumber() {
		return formMNumber;
	}

	/**
	 * @param formMNumber the formMNumber to set
	 */
	public void setFormMNumber(String formMNumber) {
		this.formMNumber = formMNumber;
	}

	/**
	 * @return the locNumber
	 */
	public String getLocNumber() {
		return locNumber;
	}

	/**
	 * @param locNumber the locNumber to set
	 */
	public void setLocNumber(String locNumber) {
		this.locNumber = locNumber;
	}

	/**
	 * @return the issuanceDate
	 */
	public LocalDate getIssuanceDate() {
		return issuanceDate;
	}

	/**
	 * @param issuanceDate the issuanceDate to set
	 */
	public void setIssuanceDate(LocalDate issuanceDate) {
		this.issuanceDate = issuanceDate;
	}

	/**
	 * @return the inspectionDate
	 */
	public LocalDate getInspectionDate() {
		return inspectionDate;
	}

	/**
	 * @param inspectionDate the inspectionDate to set
	 */
	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
}
