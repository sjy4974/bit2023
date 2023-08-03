package app.cust;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.dto.Item;
import app.frame.DaoFrame;

public class ItemDao implements DaoFrame<Integer, Item> {

	Logger log = Logger.getLogger("ItemDao");
	
	@Override
	public void insert(Item v) {
		log.info("Inserted: "+ v.toString());
		
	}

	@Override
	public void update(Item v) {
		log.info("Updated: "+ v.toString());
		
	}

	@Override
	public void delete(Integer k) {
		log.info("Deleted: "+ k);
		
	}

	@Override
	public Item select(Integer k) {
		// TODO Auto-generated method stub
		return Item.builder()
				.id(1)
				.name("½ºÅ¸¹÷½ºÅÒºí·¯")
				.price(15000)
				.build();
	}

	@Override
	public List<Item> select() {
		List<Item> list = new ArrayList<>();
		
		list.add(Item.builder()
				.id(1)
				.name("½ºÅ¸¹÷½ºÅÒºí·¯1")
				.price(15000)
				.build());
		
		list.add(Item.builder()
				.id(2)
				.name("½ºÅ¸¹÷½ºÅÒºí·¯2")
				.price(15000)
				.build());
		
		list.add(Item.builder()
				.id(3)
				.name("½ºÅ¸¹÷½ºÅÒºí·¯3")
				.price(15000)
				.build());
		
		list.add(Item.builder()
				.id(4)
				.name("½ºÅ¸¹÷½ºÅÒºí·¯4")
				.price(15000)
				.build());
		
		return list;
	}

}
