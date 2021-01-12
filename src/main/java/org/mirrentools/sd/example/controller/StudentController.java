package org.mirrentools.sd.example.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.mirrentools.sd.example.service.StudentService;
import org.mirrentools.sd.example.entity.Student;

/**
 * Student的接口服务
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {
	/***/
	@Autowired
	private StudentService service;

	@GetMapping(path = "/find", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> find() {
		return service.find();
	}

	@GetMapping(path = "/limit", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> limit(Integer page, Integer rowSize) {
		return service.limit(page, rowSize);
	}

	@PostMapping(path = "/save", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> save(Student data) {
		return service.save(data);
	}
	@GetMapping(path = "/get", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> get(Long id) {
		return service.findOne(id);
	}
	
	@PostMapping(path = "/update", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> update(Student data) {
		return service.update(data);
	}
	
	@PostMapping(path = "/delete", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> delete(Long id) {
		return service.delete(id);
	}

}
