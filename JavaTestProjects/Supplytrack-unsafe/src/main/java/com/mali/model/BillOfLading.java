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
public class BillOfLading {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bol_generator")
	@SequenceGenerator(name = "bol_generator", allocationSize = 1, sequenceName = "bol_gen")
	@Id
	private Long id;
	
	private String bolNumber;
	
	private String countryOfOrigin;
	
	private Long numberOfContainers;
	
	private LocalDate departureDate;
	
	@Transient
	private String departureDateStr;
	
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
	 * @return the numberOfContainers
	 */
	public Long getNumberOfContainers() {
		return numberOfContainers;
	}

	/**
	 * @param numberOfContainers the numberOfContainers to set
	 */
	public void setNumberOfContainers(Long numberOfContainers) {
		this.numberOfContainers = numberOfContainers;
	}

	/**
	 * @return the departureDate
	 */
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
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

	/**
	 * @return the departureDateStr
	 */
	public String getDepartureDateStr() {
		return departureDateStr;
	}

	/**
	 * @param departureDateStr the departureDateStr to set
	 */
	public void setDepartureDateStr(String departureDateStr) {
		this.departureDateStr = departureDateStr;
	}
}
