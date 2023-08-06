package app.cust;

import java.util.List;
import java.util.Optional;

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
		int result = dao.delete(k);
		if (result == 0) {
			throw new Exception("삭제 내용이 업습니다.");
		}
		return true;
	}

	@Override
	public boolean removeAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.delete() >= 1 ? true : false;

	}

	@Override
	public Cust get(String k) throws Exception {
		return dao.select(k).orElseThrow(() -> new Exception("조회에러"));
	}

	@Override
	public List<Cust> get() throws Exception {

		return dao.select();
	}

}
