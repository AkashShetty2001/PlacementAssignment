package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateRecordApp {

	public static void main(String[] args) throws IOException {
		
		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			Student student=session.get(Student.class, 18);

			if (session != null) {
				transaction=session.beginTransaction();
				if(transaction!=null) {
					if(student!=null) {
						System.out.println(student);
						System.out.println();
						
					
						student.setSaddress("IND");
						
						
						session.update(student);
						flag=true;
					}
					else {
						System.out.println("Record not available for updation...");
					}
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
			if(flag) 
				transaction.commit();
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}
