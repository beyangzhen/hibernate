package com.hibernate.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//SessionFactory����ĳһ�����ݿ�����ӣ���Ҫά�����ӳ�
//Session�ǽ��������������������֮���һ�ֽӿڣ��൱��һ���־ö���Ļ�������ÿ��session�����������ݿ�����ӣ�
//hibernate�й���sql���Ҳ��ͨ��Session���
public class TeacherTest {
	//����ģʽ
	private static SessionFactory sf = null;
	
	@BeforeClass
	public static void beforeClass() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testTeacherSave() {
									/*transient״̬�� �ڴ�����һ�����󣬻���(Ҳ���ڴ�)��û�У�ûid*/
		Teacher t = new Teacher();
		//ʹ����id�Զ����ɣ�����Ҫ�ٸ�id��ֵ
		t.setName("t1");
		t.setTitle("�м�");
		t.setBirthday(new Date());
		t.setZhicheng(ZhiCheng.B);
		
		//ʹ��sf.openSession()ʱ�����Ҫsession.close()
		//ʹ��sf.getCurrentSession()ʱ��commit()����Զ��ر�session������ʵ�����������־��ͬһ��������
		Session session = sf.getCurrentSession();
		session.beginTransaction();
									/*persistence״̬�� �ڴ����У��������к����ݿ��У���id*/
		session.save(t);
									/*detached״̬�� �ڴ����У�������û�У����ݿ����м�¼����id*/
		session.getTransaction().commit(); //�ύ��������������ݿ�
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
