package cust;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.logging.Logger;

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
class CustDeleteTest {

	Logger log = Logger.getLogger("CustTest");
	
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void before() throws Exception{
		service = new CustServiceImpl();
	}
	
	@DisplayName("Cust Delete Test")
	@Test
	@Order(1)
	void delete() throws Exception {
		
		Exception exception = assertThrows(Exception.class, ()->{
			service.remove("id66");
		});
		
		assertEquals("Test Error", exception.getMessage(), "삭제 내용이 업습니다.");

	}
	
	

}
