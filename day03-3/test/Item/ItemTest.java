package Item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import app.cust.ItemServiceImpl;
import app.dto.Item;
import app.frame.ServiceFrame;

class ItemTest {

	Logger log = Logger.getLogger("ItemTest");
	
	ServiceFrame<Integer, Item> service;
	
	@BeforeEach
	public void before() {
		service = new ItemServiceImpl();
	}
	
	@After
	public void after() throws Exception{
		service.removeAll();
	}
	
	@DisplayName("Insert Test")
	@Test
	@Order(1)
	void insert() throws Exception {
		Item inputItem = Item.builder()
				.name("½ºÅ¸¹÷½ºÅÒºí·¯1")
				.price(15000)
				.build();
		
		boolean result = service.register(inputItem);

		assertTrue("Insert Error", result);
	}
	
	@DisplayName("Item Update Test")
	@Test
	@Order(2)
	void update() throws Exception {
		List<Item> list = service.get();
		Item inputItem = Item.builder()
				.id(list.get(0).getId())
				.name("update")
				.price(15000)
				.build();
		
		boolean result = service.modify(inputItem);
		assertTrue("update Error", result);

	}
	
	@DisplayName("Item select Test")
	@Test
	@Order(3)
	void select() throws Exception {
		List<Item> list = service.get();
		Item item = service.get(list.get(0).getId());
		assertEquals("select Error", list.get(0).getId(), item.getId());

	}
		
	@DisplayName("SelectAll Test")
	@Test
	@Order(4)
	void selectAll() throws Exception {
		
		List<Item> list = service.get();
		
		assertTrue("selectAll Error",list.size() != 0);
	}
	
	@DisplayName("delete Test")
	@Test
	@Order(5)
	void delete() throws Exception {
		List<Item> list = service.get();
		
		boolean result = service.remove(list.get(0).getId());
		
		assertTrue("deleteError", result);

	}

}
