package org.mirrentools.sd.example.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.mirrentools.sd.example.service.ClassesService;
import org.mirrentools.sd.example.entity.Classes;

/**
 * Classes的接口服务
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/classes")
public class ClassesController {
	/***/
	@Autowired
	private ClassesService service;

	@GetMapping(path = "/find", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> find() {
		return service.find();
	}

	@GetMapping(path = "/limit", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> limit(Integer page, Integer rowSize) {
		return service.limit(page, rowSize);
	}

	@PostMapping(path = "/save", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> save(Classes data) {
		return service.save(data);
	}
	@GetMapping(path = "/get", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> get(Integer id) {
		return service.findOne(id);
	}
	
	@PostMapping(path = "/update", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> update(Classes data) {
		return service.update(data);
	}
	
	@PostMapping(path = "/delete", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> delete(Integer id) {
		return service.delete(id);
	}

}
