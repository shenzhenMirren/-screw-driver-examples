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
class ClassesControllerTest {
	/** 状态码的key */
	public final static String CODE_KEY = "code";
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFind() throws Exception {
		String result = mockMvc.perform(get("/classes/find"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testFind /classes/find: " + result);
	}

	@Test
	public void testLimit() throws Exception {
		String result = mockMvc.perform(get("/classes/limit")
					.param("page", "1")
					.param("rowSize", "15")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testLimit /classes/limit: " + result);
	}

	@Test
	public void testSave() throws Exception {
		String result = mockMvc.perform(post("/classes/save")
					.param("id", "1")
					.param("name", "name")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn()
				.getResponse().getContentAsString();
		System.out.println("testSave /classes/save: " + result);
	}
	
	@Test
	public void testUpdate() throws Exception {
		String result = mockMvc.perform(post("/classes/update")
				.param("id", "1")
				.param("name", "new_name")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn()
				.getResponse().getContentAsString();
		System.out.println("testSave /classes/update: " + result);
	}
	
	@Test
	public void testGet() throws Exception {
		String result = mockMvc.perform(get("/classes/get")
					.param("id", "1")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testGet /classes/get: " + result);
	}

	@Test
	public void testDelete() throws Exception {
		String result = mockMvc.perform(post("/classes/delete")
					.param("id", "1")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$." + CODE_KEY).value(200))
				.andDo(print()).andReturn().getResponse()
				.getContentAsString();
		System.out.println("testDelete /classes/delete: " + result);
	}

}
