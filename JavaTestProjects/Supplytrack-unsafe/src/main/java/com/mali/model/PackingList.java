package com.mali.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class PackingList {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pl_generator")
	@SequenceGenerator(name = "pl_generator", allocationSize = 1, sequenceName = "pl_gen")
	@Id
	private Long id;
	
	private String bolNumber;
	
	private Long packagesNumber;
	
	private String shipmentType;
	
	private String exportInvoiceNumber;
	
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
	 * @return the packagesNumber
	 */
	public Long getPackagesNumber() {
		return packagesNumber;
	}

	/**
	 * @param packagesNumber the packagesNumber to set
	 */
	public void setPackagesNumber(Long packagesNumber) {
		this.packagesNumber = packagesNumber;
	}

	/**
	 * @return the shipmentType
	 */
	public String getShipmentType() {
		return shipmentType;
	}

	/**
	 * @param shipmentType the shipmentType to set
	 */
	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	/**
	 * @return the exportInvoiceNumber
	 */
	public String getExportInvoiceNumber() {
		return exportInvoiceNumber;
	}

	/**
	 * @param exportInvoiceNumber the exportInvoiceNumber to set
	 */
	public void setExportInvoiceNumber(String exportInvoiceNumber) {
		this.exportInvoiceNumber = exportInvoiceNumber;
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
