package com.hibernate.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class StudentTest {
	//����ģʽ
	private static SessionFactory sf = null;
	
	@BeforeClass
	public static void beforeClass() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testStudentSave() {
		Student s = new Student();
		//ʹ����id�Զ����ɣ�����Ҫ�ٸ�id��ֵ
		s.setName("yangzhen");
		s.setAge(20);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit(); //�ύ��������������ݿ�
		session.close();
	}
	
	//�Զ�����sql���(�൱����hibernate.cfg.xml�����õ�ddl���)
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	

}


