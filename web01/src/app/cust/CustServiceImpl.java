package app.cust;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.GetSessionFacroty;
import app.frame.ServiceFrame;

public class CustServiceImpl implements ServiceFrame<String, Cust> {

	DaoFrame<String, Cust> dao;
	SqlSessionFactory sessionFactory;

	public CustServiceImpl() {
		dao = new CustDaoImpl();
		sessionFactory = GetSessionFacroty.getInstance();
	}

	@Override
	public boolean register(Cust v) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession session = sessionFactory.openSession();
		try {
			result = dao.insert(v, session);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new Exception("ER0001");
		} finally {
			session.close();
		}
		return result == 1 ? true : false;
	}

	@Override
	public boolean modify(Cust v) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		SqlSession session = sessionFactory.openSession();
		try {
			result = dao.update(v, session);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new Exception("ER0002");
		} finally {
			session.close();
		}
		return result == 1 ? true : false;
	}

	@Override
	public boolean remove(String k) throws Exception {
		int result = 0;
		SqlSession session = sessionFactory.openSession();
		try {
			result = dao.delete(k, session);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new Exception("ER0002");
		} finally {
			session.close();
		}
		
		return result == 1 ? true : false;
	}

	@Override
	public boolean removeAll() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cust get(String k) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		return dao.select(k, session).orElseThrow(() ->
			new Exception("ER0003")
		);
	}

	@Override
	public List<Cust> get() throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();
		return dao.select(session);
	}

}
