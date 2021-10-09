package com.ensemble.rest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TranscriptControllerTest {

	@Autowired
	MockMvc mvc;

	@Autowired
	WebApplicationContext wac;

	@Test
	public void testTransScriptController_ok() {
		try {

			mvc.perform(MockMvcRequestBuilders.get("/transcripts/ENST00000387314/exons"))
					.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Junit failed");
		}
	}
	
	@Test
	public void testTransScriptController_startlessthan_0() {
		try {

			mvc.perform(MockMvcRequestBuilders.get("/transcripts/ENST00000387314/exons?startIndex=-2"))
					.andExpect(MockMvcResultMatchers.status().is(500));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Junit failed");
		}
	}
	
	@Test
	public void testTransScriptController_StableId_NotExist() {
		try {

			mvc.perform(MockMvcRequestBuilders.get("/transcripts/ENST00000387314_invalid/exons"))
					.andExpect(MockMvcResultMatchers.status().is(200));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Junit failed");
		}
	}

}
