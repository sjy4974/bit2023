package app.cust;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import app.dto.Cust;
import app.frame.DaoFrame;

public class CustDaoImpl implements DaoFrame<String, Cust> {

	@Override
	public int insert(Cust v, SqlSession session) throws Exception {
		return session.insert("cust.insert", v);
	}

	@Override
	public int update(Cust v, SqlSession session) throws Exception {
		// TODO Auto-generated method stub
		return session.update("cust.update", v);
	}

	@Override
	public int delete(String k, SqlSession session) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(k, session);
	}

	@Override
	public Optional<Cust> select(String k, SqlSession session) throws Exception {
		// TODO Auto-generated method stub
		Optional<Cust> result = null;
		try {
			result = Optional.ofNullable(session.selectOne("cust.select", k));
		} catch (Exception e) {
			throw new Exception("조회에러");
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Cust> select(SqlSession session) throws Exception {
		// TODO Auto-generated method stub
		List<Cust> list = new ArrayList<>();
		try {
			list = session.selectList("cust.selectAll", session);
		} catch (Exception e) {
			throw new Exception("조회에러");
		} finally {
			session.close();
		}
		return list;
	}

}
