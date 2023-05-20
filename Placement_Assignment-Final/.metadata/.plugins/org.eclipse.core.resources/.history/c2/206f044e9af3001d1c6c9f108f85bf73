package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class LoadRecordApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		int id=18
				;
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				Student student=session.load(Student.class, id);
				
				if(student!=null) {
					System.out.println("Student id is :: "+id);
					
					System.in.read();
					
					System.out.println("Student Name is :: "+student.getSname());
					System.out.println("Student Age is :: "+student.getSage());
					System.out.println("Student Address is :: "+student.getSaddress());
				}
				else {
					System.out.println("Record not available for the given id is :: "+id);
				}
				
			}
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}
