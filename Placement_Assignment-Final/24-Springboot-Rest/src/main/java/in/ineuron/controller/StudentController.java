package in.ineuron.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;

@RestController
@RequestMapping("/stud")
public class StudentController {

	@Autowired
	private IStudentService service;

	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {

		String status = service.saveStudent(student);
		System.out.println(status);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudent() {

		List<Student> allStudent = service.getAllStudent();
		allStudent.forEach(System.out::println);

		return new ResponseEntity<List<Student>>(allStudent, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {

		Optional<Student> studentById = service.getStudentById(id);

		System.out.println(studentById);
		if (studentById.isPresent())
			return new ResponseEntity<Student>(studentById.get(), HttpStatus.OK);
		else
			return null;
	}

}