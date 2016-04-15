package com.hibernate.model;

/* 方式二	annotation(注解)的方式映射类和表*/ 

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
@Table(name="teacher") //类名和表名不相同的时候才写
public class Teacher {
	private int id;
	private String name;
	private String title;
	private String yourWifeName;
	private Date birthday;
	private ZhiCheng zhicheng;
	
	@Id
	@GeneratedValue //annotation版的,id生成策略
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name") //属性名和字段名不同的时候才写
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
	@Transient //不需要存进数据库的属性
	public String getYourWifeName() {
		return yourWifeName;
	}
	public void setYourWifeName(String yourWifeName) {
		this.yourWifeName = yourWifeName;
	}
	@Temporal(TemporalType.DATE) //将默认的TimeStamp类型(即：日期和时间)转换为Date类型(即： 日期)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Enumerated(EnumType.STRING) //数据库中映射一个枚举类型
	public ZhiCheng getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(ZhiCheng zhicheng) {
		this.zhicheng = zhicheng;
	}
}
