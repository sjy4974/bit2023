package app.cust;

import java.util.List;

import app.dto.Item;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class ItemServiceImpl implements ServiceFrame<Integer, Item> {

	DaoFrame<Integer, Item> dao;

	public ItemServiceImpl() {
		dao = new ItemDaoImpl();
	}
	
	@Override
	public boolean register(Item v) throws Exception {
		return dao.insert(v) == 1 ? true : false;
		
	}

	@Override
	public boolean modify(Item v) throws Exception {
		return dao.update(v) == 1 ? true : false;
		
	}

	@Override
	public boolean remove(Integer k) throws Exception {
		return dao.delete(k) == 1 ? true : false;
	}
	
	@Override
	public boolean removeAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.delete() >= 1 ? true : false;
		
	}

	@Override
	public Item get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(k);
	}

	@Override
	public List<Item> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.select();
	}

}
