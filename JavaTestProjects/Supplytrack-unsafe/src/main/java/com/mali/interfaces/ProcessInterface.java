package com.mali.interfaces;

import java.util.List;

import com.mali.model.BillOfLading;
import com.mali.model.CCVO;
import com.mali.model.CRIA;
import com.mali.model.Delivery;
import com.mali.model.COA;
import com.mali.model.FormM;
import com.mali.model.Insurance;
import com.mali.model.LetterOfCredit;
import com.mali.model.ManufacturerCertificate;
import com.mali.model.PackingList;
import com.mali.model.ProformalInvoice;
import com.mali.model.Project;
import com.mali.model.Reciept;
import com.mali.model.Regulatory;
import com.mali.model.Remark;

public interface ProcessInterface {

	Project saveProject(Project project);

	List<Project> findProjects();

	void deleteProject(Project project);

	Project findProjectById(Long id);

	Insurance saveInsurance(Insurance ins);

	LetterOfCredit saveLetterOfCredit(LetterOfCredit loc);

	ProformalInvoice saveProformalInvoice(ProformalInvoice pfi);

	Regulatory saveRegulatory(Regulatory reg);

	BillOfLading saveBol(BillOfLading bol);

	CCVO saveCcvo(CCVO ccvo);

	CRIA saveCFIA(CRIA cfia);

	COA saveCOA(COA coa);

	FormM saveFormM(FormM formM);

	ManufacturerCertificate saveManufacturerCertificate(ManufacturerCertificate mc);

	PackingList savePackingList(PackingList pl);

	Delivery saveDelivery(Delivery delivery);

	Reciept saveReciept(Reciept reciept);

	Remark saveRemark(Remark remark);

}
