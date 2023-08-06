package cust;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import app.frame.ServiceFrame;

@TestMethodOrder(OrderAnnotation.class)
class CustSelectTest {

	Logger log = Logger.getLogger("CustTest");
	
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void before() throws Exception{
		service = new CustServiceImpl();
		Cust inputCust = Cust.builder()
				.id("id55")
				.pwd("pwd55")
				.name("jun55")
				.build();
		service.register(inputCust);
	}
	
	@AfterEach
	void after() throws Exception {
		service.remove("id55");
	}
	
	@DisplayName("Cust Select Test")
	@Test
	@Order(1)
	void select() throws Exception {
		Cust cust = null;
		cust = service.get("id55");
		assertEquals("Test Error", cust.getId(), "id55");

	}

	
	@DisplayName("Cust Select Test")
	@Test
	@Order(2)
	void select2() throws Exception {
		
		Exception exception = assertThrows(Exception.class, ()->{
			Cust cust = null;
			cust = service.get("id44");
		});
		
		assertEquals("Test Error", exception.getMessage(), "조회에러");

	}
	
	

}
