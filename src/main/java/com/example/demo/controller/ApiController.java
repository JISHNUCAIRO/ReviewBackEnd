package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;

@CrossOrigin
@RestController
public class ApiController {
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/")
	public List<Student> getAllEmp(){
		return repo.findAll();
	}
	
	@PostMapping("/")
	public Student createEmployee(@RequestBody Student x) {
		return repo.save(x);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getEmpbyId(@PathVariable int id){
		Optional<Student> temp=repo.findById(id);
		return temp;
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Student upd) {
		if(repo.existsById(id)) {
			Student t=new Student();
			t.setId(id);
			t.setName(upd.getName());
			t.setDepartment(upd.getDepartment());
			t.setEmailId(upd.getEmailId());
			repo.save(t);
		}
		return " ";
	}
	@DeleteMapping("/{id}")
	public String removeEmp(@PathVariable int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
		return " ";
	}
	
}