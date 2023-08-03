package app.cust;

import java.util.List;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class CustServiceImpl implements ServiceFrame<String, Cust> {

	DaoFrame<String, Cust> dao;

	public CustServiceImpl() {
		dao = new CustDaoImpl();
	}

	@Override
	public boolean register(Cust v) throws Exception {
		return dao.insert(v) == 1 ? true : false;
	}

	@Override
	public boolean modify(Cust v) throws Exception {
		return dao.update(v) == 1 ? true : false;

	}

	@Override
	public boolean remove(String k) throws Exception {
		return dao.delete(k) == 1 ? true : false;
	}
	
	@Override
	public boolean removeAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.delete() >= 1 ? true : false;
		
	}

	@Override
	public Cust get(String k) throws Exception {

		return dao.select(k);
	}

	@Override
	public List<Cust> get() throws Exception {

		return dao.select();
	}

}
