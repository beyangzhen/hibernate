package com.hibernate.model;

/* ��ʽ��	annotation(ע��)�ķ�ʽӳ����ͱ�*/ 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="teacher") //�����ͱ�������ͬ��ʱ���д
public class Teacher {
	private int id;
	private String name;
	private String title;
	private String yourWifeName;
	private Date birthday;
	private ZhiCheng zhicheng;
	
	@Id
	@GeneratedValue //annotation���,id���ɲ���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name") //���������ֶ�����ͬ��ʱ���д
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Transient //����Ҫ������ݿ������
	public String getYourWifeName() {
		return yourWifeName;
	}
	public void setYourWifeName(String yourWifeName) {
		this.yourWifeName = yourWifeName;
	}
	@Temporal(TemporalType.DATE) //��Ĭ�ϵ�TimeStamp����(�������ں�ʱ��)ת��ΪDate����(���� ����)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Enumerated(EnumType.STRING) //���ݿ���ӳ��һ��ö������
	public ZhiCheng getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(ZhiCheng zhicheng) {
		this.zhicheng = zhicheng;
	}
}
