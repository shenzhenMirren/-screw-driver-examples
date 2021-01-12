package org.mirrentools.sd.example.entity;


/**
 * 班级表
 * @author 
 */ 
public class Classes {
	/** 班级的id */
	private Integer id; 
	/** 班级的名称 */
	private String name; 
	/**
	 * 获取班级的id
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置班级的id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取班级的名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置班级的名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + " , name=" + name + "  ]";
	}
}
