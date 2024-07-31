package com.mali.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mali.interfaces.BillOfLadingRepository;
import com.mali.interfaces.CCVORepository;
import com.mali.interfaces.CFIARepository;
import com.mali.interfaces.COARepository;
import com.mali.interfaces.DeliveryRepository;
import com.mali.interfaces.FormMRepository;
import com.mali.interfaces.InsuranceRepository;
import com.mali.interfaces.LOCRepository;
import com.mali.interfaces.ManufacturerCertificateRepository;
import com.mali.interfaces.PFIRepository;
import com.mali.interfaces.PackingListRepository;
import com.mali.interfaces.ProcessInterface;
import com.mali.interfaces.ProjectRepository;
import com.mali.interfaces.RecieptRepository;
import com.mali.interfaces.RegulatoryRepository;
import com.mali.interfaces.RemarkRepository;
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

@Service
public class ProcessService implements ProcessInterface {
	ProjectRepository projectRepo;
	InsuranceRepository insuranceRepo;
	LOCRepository locRepo;
	PFIRepository pfiRepo;
	RegulatoryRepository regulatoryRepo;

	BillOfLadingRepository bolRepo;
	CCVORepository ccvoRepo;
	CFIARepository cfiaRepo;
	COARepository coaRepo;
	FormMRepository formmRepo;
	ManufacturerCertificateRepository manufacturerCertRepo;
	PackingListRepository plRepo;
	DeliveryRepository deliveryRepo;
	RecieptRepository recieptRepo;
	RemarkRepository remarkRepo;

	public ProcessService(ProjectRepository projectRepo, InsuranceRepository insuranceRepo, LOCRepository locRepo,
			PFIRepository pfiRepo, RegulatoryRepository regulatoryRepo, BillOfLadingRepository bolRepo,
			CCVORepository ccvoRepo, CFIARepository cfiaRepo, COARepository coaRepo, FormMRepository formmRepo,
			ManufacturerCertificateRepository manufacturerCertRepo, PackingListRepository plRepo,
			DeliveryRepository deliveryRepo, RecieptRepository recieptRepo, RemarkRepository remarkRepo) {
		this.projectRepo = projectRepo;
		this.insuranceRepo = insuranceRepo;
		this.locRepo = locRepo;
		this.pfiRepo = pfiRepo;
		this.regulatoryRepo = regulatoryRepo;

		this.bolRepo = bolRepo;
		this.ccvoRepo = ccvoRepo;
		this.cfiaRepo = cfiaRepo;
		this.coaRepo = coaRepo;
		this.formmRepo = formmRepo;
		this.manufacturerCertRepo = manufacturerCertRepo;
		this.plRepo = plRepo;
		this.deliveryRepo = deliveryRepo;
		this.recieptRepo = recieptRepo;
		this.remarkRepo = remarkRepo;
	}

	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepo.save(project);
	}

	@Override
	public List<Project> findProjects() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	@Override
	public void deleteProject(Project project) {
		// TODO Auto-generated method stub
		projectRepo.delete(project);
	}

	@Override
	public Project findProjectById(Long id) {
		// TODO Auto-generated method stub
		Project project = new Project();
		Optional<Project> optProj = projectRepo.findById(id);
		if (optProj.isPresent()) {
			project = optProj.get();
		}
		return project;
	}

	@Override
	public Insurance saveInsurance(Insurance ins) {
		// TODO Auto-generated method stub
		return insuranceRepo.save(ins);
	}

	@Override
	public LetterOfCredit saveLetterOfCredit(LetterOfCredit loc) {
		// TODO Auto-generated method stub
		return locRepo.save(loc);
	}

	@Override
	public ProformalInvoice saveProformalInvoice(ProformalInvoice pfi) {
		// TODO Auto-generated method stub
		return pfiRepo.save(pfi);
	}

	@Override
	public Regulatory saveRegulatory(Regulatory reg) {
		// TODO Auto-generated method stub
		return regulatoryRepo.save(reg);
	}

	@Override
	public BillOfLading saveBol(BillOfLading bol) {
		// TODO Auto-generated method stub
		return bolRepo.save(bol);
	}

	@Override
	public CCVO saveCcvo(CCVO ccvo) {
		// TODO Auto-generated method stub
		return ccvoRepo.save(ccvo);
	}

	@Override
	public CRIA saveCFIA(CRIA cfia) {
		// TODO Auto-generated method stub
		return cfiaRepo.save(cfia);
	}

	@Override
	public COA saveCOA(COA coa) {
		// TODO Auto-generated method stub
		return coaRepo.save(coa);
	}

	@Override
	public FormM saveFormM(FormM formM) {
		// TODO Auto-generated method stub
		return formmRepo.save(formM);
	}

	@Override
	public ManufacturerCertificate saveManufacturerCertificate(ManufacturerCertificate mc) {
		// TODO Auto-generated method stub
		return manufacturerCertRepo.save(mc);
	}

	@Override
	public PackingList savePackingList(PackingList pl) {
		// TODO Auto-generated method stub
		return plRepo.save(pl);
	}

	@Override
	public Delivery saveDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return deliveryRepo.save(delivery);
	}

	@Override
	public Reciept saveReciept(Reciept reciept) {
		// TODO Auto-generated method stub
		return recieptRepo.save(reciept);
	}

	@Override
	public Remark saveRemark(Remark remark) {
		// TODO Auto-generated method stub
		return remarkRepo.save(remark);
	}

}
