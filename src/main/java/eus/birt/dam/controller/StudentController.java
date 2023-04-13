package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.birt.dam.domain.Student;
import eus.birt.dam.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public String getStudents(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "student/list";
	}
	
	@GetMapping("/students/new")
	public String initCreationForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student/studentForm";
	}
	
	@PostMapping("/students/new/submit")
	public String submitCreationForm(@ModelAttribute Student student) {
		studentRepository.save(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentRepository.findById(id));
		return "student/studentForm";
	}
	
	@GetMapping("/students/delete/{id}")
	public String initDelete(@PathVariable("id") int id) {
		studentRepository.deleteById(id);
		return "redirect:/students";
	}
}
