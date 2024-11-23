package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Khoa;
import util.HibernateUtil;

public class TestKhoa {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
		
					
			
			        Khoa khoa = new Khoa();
					khoa.setMAKHOA("CSDL");
					khoa.setTENKHOA("Cơ Sở Dữ Liệu");
					khoa.setNAMTL("2011-012-12");//2015-05-12
					khoa.setPHONGLV("F206");//f205
					khoa.setTEL("0392645290");//39393939
					khoa.setMATRGKHOA("GV01");//GV04
		
		
		
       	session.save(khoa);
		
		
		long batDau = System.currentTimeMillis();
		long ketThuc = System.currentTimeMillis();
		System.out.println("Thời gian thực hiện câu lệnh là: "+ (ketThuc-batDau));
		
		tr.commit();
		session.close();
	}
   }
}

