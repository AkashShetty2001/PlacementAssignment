package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.model.Student;

public interface IStudentService {
	public String saveStudent(Student student);

	public List<Student> getAllStudent();

	public Optional<Student> getStudentById(Integer id);

}
