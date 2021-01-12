package org.mirrentools.sd.example.service;

import org.mirrentools.sd.example.entity.Student;

import java.util.Map;

/**
 * Student数据服务接口
 * 
 * @author 
 *
 */
public interface StudentService {
	/**
	 * 获取所有数据
	 * 
	 * @return
	 */
	Map<String, Object> find();

	/**
	 * 获取分页
	 * 
	 * @param page    第几页
	 * @param rowSize 每页显示多少行
	 * @return
	 */
	Map<String, Object> limit(Integer page, Integer rowSize);

	/**
	 * 保存
	 * 
	 * @param data
	 * @return
	 */
	Map<String, Object> save(Student data);
	/**
	 * 获取指定数据
	 * 
	 * @param id
	 * @return
	 */
	Map<String, Object> findOne(Long id);
	
	/**
	 * 保存
	 * 
	 * @param data
	 * @return
	 */
	Map<String, Object> update(Student data);
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	Map<String, Object> delete(Long id);
}
