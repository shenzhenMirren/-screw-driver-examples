package org.mirrentools.sd.example.service;

import org.mirrentools.sd.example.entity.Classes;

import java.util.Map;

/**
 * Classes数据服务接口
 * 
 * @author 
 *
 */
public interface ClassesService {
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
	Map<String, Object> save(Classes data);
	/**
	 * 获取指定数据
	 * 
	 * @param id
	 * @return
	 */
	Map<String, Object> findOne(Integer id);
	
	/**
	 * 保存
	 * 
	 * @param data
	 * @return
	 */
	Map<String, Object> update(Classes data);
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	Map<String, Object> delete(Integer id);
}
