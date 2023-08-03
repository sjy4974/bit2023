package app.cust;

import java.util.List;

import app.dto.Item;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class ItemService implements ServiceFrame<Integer, Item> {

	DaoFrame<Integer, Item> dao;

	public ItemService() {
		dao = new ItemDao();
	}
	
	@Override
	public void register(Item v) {
		dao.insert(v);
		
	}

	@Override
	public void modify(Item v) {
		dao.update(v);
		
	}

	@Override
	public void remove(Integer k) {
		dao.delete(k);
		
	}

	@Override
	public Item get(Integer k) {
		// TODO Auto-generated method stub
		return dao.select(k);
	}

	@Override
	public List<Item> get() {
		// TODO Auto-generated method stub
		return dao.select();
	}

}
