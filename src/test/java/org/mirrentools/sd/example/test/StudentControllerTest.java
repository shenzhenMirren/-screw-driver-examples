package org.mirrentools.sd.example.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
	/** 状态码的key */
	public final static String CODE_KEY = "code";
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFind() throws Exception {
		String result = mockMvc.perform(get("/student/find"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testFind /student/find: " + result);
	}

	@Test
	public void testLimit() throws Exception {
		String result = mockMvc.perform(get("/student/limit")
					.param("page", "1")
					.param("rowSize", "15")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testLimit /student/limit: " + result);
	}

	@Test
	public void testSave() throws Exception {
		String result = mockMvc.perform(post("/student/save")
					.param("id", "1")
					.param("cid", "1")
					.param("name", "name")
					.param("age", "1")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn()
				.getResponse().getContentAsString();
		System.out.println("testSave /student/save: " + result);
	}
	
	@Test
	public void testUpdate() throws Exception {
		String result = mockMvc.perform(post("/student/update")
				.param("id", "1")
				.param("cid", "2")
				.param("name", "new_name")
				.param("age", "2")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn()
				.getResponse().getContentAsString();
		System.out.println("testSave /student/update: " + result);
	}
	
	@Test
	public void testGet() throws Exception {
		String result = mockMvc.perform(get("/student/get")
					.param("id", "1")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testGet /student/get: " + result);
	}

	@Test
	public void testDelete() throws Exception {
		String result = mockMvc.perform(post("/student/delete")
					.param("id", "1")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testDelete /student/delete: " + result);
	}

}
