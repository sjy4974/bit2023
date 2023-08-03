package cust;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import app.frame.ServiceFrame;

class CustTest {

	Logger log = Logger.getLogger("CustTest");
	
	ServiceFrame<String, Cust> service;
	
	@BeforeEach
	void before() {
		service = new CustServiceImpl();
	}
	
	@After
	void after() {
		try {
			service.removeAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DisplayName("Cust Insert Test")
	@Test
	@Order(1)
	void insert() throws Exception {
		
		Cust inputCust = Cust.builder()
				.id("id01")
				.pwd("pwd01")
				.name("jun5")
				.build();
		boolean result = service.register(inputCust);
	
		assertTrue("insert Error", result);

	}
	
	@DisplayName("Cust Update Test")
	@Test
	@Order(2)
	void update() throws Exception {
		Cust inputCust = Cust.builder()
				.id("id01")
				.pwd("update")
				.name("update")
				.build();
		
		boolean result = service.modify(inputCust);
		assertTrue("update Error", result);

		
	}
	
	@DisplayName("Cust select Test")
	@Test
	@Order(3)
	void select() throws Exception {
		Cust cust = null;
		
		cust = service.get("id01");
		assertEquals("select Error", cust.getId(), "id01");

		
	}
		
	@DisplayName("SelectAll Test")
	@Test
	@Order(4)
	void selectAll() throws Exception {
		
		List<Cust> list = new ArrayList<>();
		
		list = service.get();
		
		assertTrue("selectAll Error",list.size() == 1);
	}
	
	@DisplayName("delete Test")
	@Test
	@Order(5)
	void delete() throws Exception {
		String id = "id01";
		boolean result = service.remove(id);
		
		assertTrue("deleteError", result);

	}
	
	

}
