package org.mirrentools.sd.example.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.mirrentools.sd.example.common.SqlAssist;
import org.mirrentools.sd.example.common.SqlAssist.LimitResult;

import org.mirrentools.sd.example.service.ClassesService;
import org.mirrentools.sd.example.mapper.ClassesMapper;
import org.mirrentools.sd.example.entity.Classes;

/**
 * Classes数据服务接口的默认实现
 * 
 * @author 
 *
 */
@Service
public class ClassesServiceImpl implements ClassesService {
	private final Log LOG = LogFactory.getLog(this.getClass());

	@Autowired
	private ClassesMapper classesMapper;

	@Override
	public Map<String, Object> find() {
		List<Classes> data = classesMapper.selectAll(null);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[ClassesServiceImpl.find]-->成功:" + data);
		}
		return formatSucceed(data);
	}

	@Override
	public Map<String, Object> limit(Integer page, Integer rowSize) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format("执行获取数据[ClassesServiceImpl.limit]-->请求数据:\npage:%d \nrowSize: %d", page, rowSize));
		}
		SqlAssist assist = new SqlAssist();
		assist.setPage(page).setRowSize(rowSize);

		LimitResult<Classes> data =  classesMapper.limitAll(assist);
		Map<String, Object> result = new HashMap<>();
		result.put("pages", data.getPages());
		result.put("page", data.getPage());
		result.put("total", data.getTotals());
		result.put("size", data.getSize());
		result.put("data", data.getData());
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[ClassesServiceImpl.limit]-->成功:" + result);
		}
		return formatSucceed(result);
	}

	@Override
	public Map<String, Object> save(Classes data) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行更新数据[ClassesServiceImpl.save]-->请求数据:" + data);
		}
		if (data.getId() == null  && data.getName() == null ) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行更新数据[ClassesServiceImpl.save]-->失败:缺少必填参数");
			}
			return formatFailed(412, "操作失败,缺少必填的数据!", "缺少必填项参数", data);
		}
		int result = classesMapper.insertNotNull(data);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行更新数据[ClassesServiceImpl.save]-->结果:" + result);
		}
		return formatSucceed(result);
	}
	@Override
	public Map<String, Object> findOne(Integer id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[ClassesServiceImpl.findOne]-->请求数据:\nid:" + id);
		}
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行获取数据[ClassesServiceImpl.findOne]-->失败:id为空");
			}
			return formatFailed(412, "获取数据失败,请求中缺少必填的参数!", "id不能为空", null);
		}
		Classes result = classesMapper.selectById(id);;
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取数据[ClassesServiceImpl.findOne]-->结果:" + result);
		}
		return formatSucceed(result);
	}
	
	@Override
	public Map<String, Object> update(Classes data) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行更新数据[ClassesServiceImpl.update]-->请求数据:" + data);
		}
		if (data == null || (data.getName() == null )) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行更新数据[ClassesServiceImpl.update]-->失败:缺少必填参数");
			}
			return formatFailed(412, "操作失败,缺少必填的数据!", "缺少必填项参数", 0);
		}
		int result = classesMapper.updateNotNullById(data);
		return formatSucceed(result);
	}

	@Override
	public Map<String, Object> delete(Integer id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行删除数据[ClassesServiceImpl.delete]-->请求数据:" + id);
		}
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行删除数据[ClassesServiceImpl.delete]-->失败:id为空");
			}
			return formatFailed(412, "操作失败,缺少必填的数据!", "缺少必填项参数", 0);
		}
		int result = classesMapper.deleteById(id);
		return formatSucceed(result);
	}

	// TODO 当你看到以下的方法后你应该将其抽为工具并修改模板
	/**
	 * 格式化返回结果为失败
	 * 
	 * @param code    错误码
	 * @param msg     提示信息(给用户看的)
	 * @param explain 错误提示(给前端看)
	 * @param data    数据
	 * @return
	 */
	public Map<String, Object> formatFailed(int code, String msg, String explain, Object data) {
		Map<String, Object> result = new HashMap<>();
		result.put("code", code);
		result.put("msg", msg);
		result.put("explain", explain);
		result.put("data", data);
		return result;
	}

	public Map<String, Object> formatSucceed(Object data) {
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("msg", "成功!");
		result.put("explain", "成功!");
		result.put("data", data);
		return result;
	}

}
