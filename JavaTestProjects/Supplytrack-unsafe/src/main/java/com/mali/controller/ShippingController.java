package com.mali.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mali.interfaces.ProcessInterface;
import com.mali.model.Project;

@Controller
public class ShippingController {
	ProcessInterface processInterface;

	public ShippingController(ProcessInterface processInterface) {
		this.processInterface = processInterface;
	}

	@GetMapping(value = "/")
	public String index(Model model) {

		return "index";
	}

	@GetMapping(value = "/login")
	public String loginPage(Model model) {

		return "signin";
	}

	@PostMapping(value = "/loginDetail")
	public String loginUser(Model model) {

		return "dashboard";
	}

	@GetMapping(value = "/createProject")
	public String createProject(Model model) {

		Project project = new Project();
		model.addAttribute("project", project);
		return "create_project";
	}

	@PostMapping(value = "/saveProject")
	public String saveProject(Model model, Project project) {

		processInterface.saveProject(project);
		List<Project> projects = processInterface.findProjects();
		model.addAttribute("projects", projects);
		return "project_page";
	}

	@GetMapping(value = "/updateProjectDetail")
	public String updateProjectDetail(Model model, @RequestParam Long id) {
		Project project = processInterface.findProjectById(id);
		model.addAttribute("project", project);
		return "create_project";
	}

	@GetMapping(value = "/deleteProjectDetail")
	public String deleteProjectDetail(Model model, @RequestParam Long id) {
		Project project = processInterface.findProjectById(id);
		processInterface.deleteProject(project);
		List<Project> projects = processInterface.findProjects();
		model.addAttribute("projects", projects);
		return "project_page";
	}

	@GetMapping(value = "/getProjects")
	public String getProjects(Model model) {
		List<Project> projects = processInterface.findProjects();
		model.addAttribute("projects", projects);
		return "project_page";
	}

}
