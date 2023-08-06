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
class CustInsertTest2 {

	Logger log = Logger.getLogger("CustTest");
	
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void before() throws Exception{
		service = new CustServiceImpl();
	}
	
	@AfterEach
	void after() throws Exception {
		service.removeAll();
	}

	
	@DisplayName("Cust Insert Test2 (중복계정 생성시 아이디 중복에러가 발생한다.)")
	@Test
	@Order(1)
	void insert() throws Exception {
		
		Exception exception = assertThrows(Exception.class, ()->{
			Cust inputCust = Cust.builder()
					.id("id77")
					.pwd("pwd77")
					.name("jun77")
					.build();
			boolean result = service.register(inputCust);
		});
		
		assertEquals("Test Error", exception.getMessage(), "아이디중복에러");

	}
	
	

}
