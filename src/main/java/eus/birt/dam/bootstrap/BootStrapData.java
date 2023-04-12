package eus.birt.dam.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Student;
import eus.birt.dam.domain.University;
import eus.birt.dam.repository.StudentRepository;
import eus.birt.dam.repository.UniversityRepository;
import jakarta.transaction.Transactional;

@Component
public class BootStrapData implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private UniversityRepository universityRepository;
	
	@Transactional
	@Override
	public void run (String... arg0) throws Exception {
		
		Student student1 = new Student("Alex", "Pérez", "alex.perez@gmail.com");
		University university1 = new University("UPV");
		
		student1.setUniversity(university1);
		university1.getStudents().add(student1);
		
		universityRepository.save(university1);
		studentRepository.save(student1);
	}
}
