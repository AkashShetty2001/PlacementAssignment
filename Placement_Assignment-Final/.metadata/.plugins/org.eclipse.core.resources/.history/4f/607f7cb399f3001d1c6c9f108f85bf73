package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class PersistApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				Student student=new Student();
				
				student.setSid(10);
				student.setSname("Sachin");
				student.setSaddress("MI");
				//student.setSage(41);
				
				session.persist(student);
				flag=true;
				
			}
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("data save to database");
			}
			else {
				transaction.rollback();
				System.out.println("data failed to save");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}
