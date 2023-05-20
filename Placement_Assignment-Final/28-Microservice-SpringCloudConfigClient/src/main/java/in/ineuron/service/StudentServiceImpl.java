package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao repo;

	@Override
	public String saveStudent(Student student) {
		Student save = repo.save(student);
		return save !=null ? "Save student ":" failed to save student";
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
