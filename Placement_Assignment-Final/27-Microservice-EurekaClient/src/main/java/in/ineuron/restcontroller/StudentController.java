package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;

@RestController
@RequestMapping("/stud")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> getStudent(@RequestBody Student student){
		 
		String status = service.saveStudent(student);
		
		System.out.println(status);
		
		return new ResponseEntity<>(status , HttpStatus.OK);
	}
	
	

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Student>> get(){

		List<Student> allStudent = service.getAllStudent();
		
		return new ResponseEntity<>(allStudent, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Student> getSingle(@PathVariable Integer id){
		
		Optional<Student> student = service.getStudentById(id);
		
		if(student.isPresent())
			return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
		else 
		    return null;
		
		
	}

}
