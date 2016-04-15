package com.hibernate.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class StudentTest {
	//单例模式
	private static SessionFactory sf = null;
	
	@BeforeClass
	public static void beforeClass() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testStudentSave() {
		Student s = new Student();
		//使用了id自动生成，不需要再给id赋值
		s.setName("yangzhen");
		s.setAge(20);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit(); //提交事务，真正存进数据库
		session.close();
	}
	
	//自动生成sql语句(相当于在hibernate.cfg.xml中配置的ddl语句)
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	

}


