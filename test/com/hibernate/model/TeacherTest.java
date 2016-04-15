package com.hibernate.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//SessionFactory是与某一个数据库的连接，主要维护连接池
//Session是介于数据连接与事务管理之间的一种接口，相当于一个持久对象的缓冲区（每个session都有着与数据库的连接）
//hibernate中构建sql语句也是通过Session完成
public class TeacherTest {
	//单例模式
	private static SessionFactory sf = null;
	
	@BeforeClass
	public static void beforeClass() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testTeacherSave() {
									/*transient状态。 内存中有一个对象，缓存(也是内存)中没有，没id*/
		Teacher t = new Teacher();
		//使用了id自动生成，不需要再给id赋值
		t.setName("t1");
		t.setTitle("中级");
		t.setBirthday(new Date());
		t.setZhicheng(ZhiCheng.B);
		
		//使用sf.openSession()时，最后要session.close()
		//使用sf.getCurrentSession()时，commit()后会自动关闭session，可以实现如操作和日志在同一个事务里
		Session session = sf.getCurrentSession();
		session.beginTransaction();
									/*persistence状态。 内存中有，缓存中有和数据库有，有id*/
		session.save(t);
									/*detached状态。 内存中有，缓存中没有，数据库中有记录，有id*/
		session.getTransaction().commit(); //提交事务，真正存进数据库
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
