package Item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.cust.ItemService;
import app.dto.Item;
import app.frame.ServiceFrame;

class ItemTest {

	Logger log = Logger.getLogger("ItemTest");
	
	ServiceFrame<Integer, Item> service;
	
	@BeforeEach
	public void before() {
		service = new ItemService();
	}
	
	@DisplayName("Insert Test")
	@Test
	void test() {
		Item inputItem = Item.builder()
				.id(1)
				.name("½ºÅ¸¹÷½ºÅÒºí·¯1")
				.price(15000)
				.build();
		
		service.register(inputItem);
		log.info("Insert Cust OK ....");
		Item item = service.get(1);
		assertEquals("Insert Error", inputItem.getId(), item.getId());
	}
	
	@DisplayName("Select Test")
	@Test
	void selectAll() {
		
		List<Item> list = service.get();
		
		assertTrue("Select Error",list.size() == 4);
	}

}
