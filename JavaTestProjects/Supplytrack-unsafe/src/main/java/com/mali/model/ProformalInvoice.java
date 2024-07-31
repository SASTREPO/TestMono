package com.mali.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class ProformalInvoice {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pfi_generator")
	@SequenceGenerator(name = "pfi_generator", allocationSize = 1, sequenceName = "pfi_gen")
	@Id
	private Long id;

	@OneToOne
	@JoinColumn
	Project project;

	private Long quantity;

	private BigDecimal price;

	private String itemDetails;

	private String hsCode;

	private Long pfiNumber;

	private String fileName;

	@Transient
	private Long projectId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the itemDetails
	 */
	public String getItemDetails() {
		return itemDetails;
	}

	/**
	 * @param itemDetails
	 *            the itemDetails to set
	 */
	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	/**
	 * @return the hsCode
	 */
	public String getHsCode() {
		return hsCode;
	}

	/**
	 * @param hsCode
	 *            the hsCode to set
	 */
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	/**
	 * @return the pfiNumber
	 */
	public Long getPfiNumber() {
		return pfiNumber;
	}

	/**
	 * @param pfiNumber
	 *            the pfiNumber to set
	 */
	public void setPfiNumber(Long pfiNumber) {
		this.pfiNumber = pfiNumber;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}
