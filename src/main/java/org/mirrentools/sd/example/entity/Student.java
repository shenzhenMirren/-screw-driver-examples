package org.mirrentools.sd.example.entity;


/**
 * 学生表
 * @author 
 */ 
public class Student {
	/** 学生的id */
	private Long id; 
	/** 外键-班级的id */
	private Integer cid; 
	/** 学生的名称 */
	private String name; 
	/** 学生的年龄 */
	private Integer age; 
	/**
	 * 获取学生的id
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置学生的id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取外键-班级的id
	 * 
	 * @return
	 */
	public Integer getCid() {
		return cid;
	}
	/**
	 * 设置外键-班级的id
	 * 
	 * @param cid
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * 获取学生的名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置学生的名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取学生的年龄
	 * 
	 * @return
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置学生的年龄
	 * 
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + " , cid=" + cid + " , name=" + name + " , age=" + age + "  ]";
	}
}
