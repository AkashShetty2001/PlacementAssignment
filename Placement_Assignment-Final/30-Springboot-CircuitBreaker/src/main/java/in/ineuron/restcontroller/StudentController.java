package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.StudentService;

@RestController
@RequestMapping(value = "/app")

public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping(value = "/get")
	public String gettAllStudents() {

		String response = service.getAllStudents();

		return response;

	}
}
