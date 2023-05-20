package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.factory.StudentDaoFactory;
import in.ineuron.model.Student;

public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao dao=StudentDaoFactory.getStudentDao();

	@Override
	public String addData(Student student) {
		
		return dao.addData(student);
	}

}
