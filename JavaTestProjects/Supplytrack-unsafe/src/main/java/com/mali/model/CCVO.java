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
public class CCVO {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ccvo_generator")
	@SequenceGenerator(name = "ccvo_generator", allocationSize = 1, sequenceName = "ccvo_gen")
	@Id
	private Long id;
	
	private String formMNumber;
	
	private String destinationPort;
	
	private String shipmentId;
	
	private LocalDate shipmentDate;
	
	private String countryOfOrigin;
	
	private String countryOfSupply;
	
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
	 * @return the destinationPort
	 */
	public String getDestinationPort() {
		return destinationPort;
	}

	/**
	 * @param destinationPort the destinationPort to set
	 */
	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}

	/**
	 * @return the shipmentId
	 */
	public String getShipmentId() {
		return shipmentId;
	}

	/**
	 * @param shipmentId the shipmentId to set
	 */
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	/**
	 * @return the shipmentDate
	 */
	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * @param shipmentDate the shipmentDate to set
	 */
	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/**
	 * @return the countryOfOrigin
	 */
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	/**
	 * @param countryOfOrigin the countryOfOrigin to set
	 */
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	/**
	 * @return the countryOfSupply
	 */
	public String getCountryOfSupply() {
		return countryOfSupply;
	}

	/**
	 * @param countryOfSupply the countryOfSupply to set
	 */
	public void setCountryOfSupply(String countryOfSupply) {
		this.countryOfSupply = countryOfSupply;
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
