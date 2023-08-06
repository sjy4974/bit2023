package cust;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import app.frame.ServiceFrame;

class CustInsertTest {

	Logger log = Logger.getLogger("CustTest");
	
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void before() throws Exception{
		service = new CustServiceImpl();
		service.removeAll();
	}
	
	@AfterEach
	void after() throws Exception {
		Cust cust = service.get("id88");
		assertEquals("Select Error", cust.getId(), "id88");
	}
	
	@DisplayName("Cust Insert Test")
	@Test
	@Order(1)
	void insert() throws Exception {
		
		Cust inputCust = Cust.builder()
				.id("id88")
				.pwd("pwd88")
				.name("jun88")
				.build();
		boolean result = service.register(inputCust);
	
		assertTrue("insert Error", result);

	}
	
	

}
