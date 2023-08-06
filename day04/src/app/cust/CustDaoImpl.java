package app.cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import app.dto.Cust;
import app.frame.ConnectionPool;
import app.frame.DaoFrame;
import app.frame.SQL;
import app.util.DBUtil;

public class CustDaoImpl implements DaoFrame<String, Cust> {

	Logger log = Logger.getLogger("CustDao");

	ConnectionPool cp;

	public CustDaoImpl() {
		try {
			cp = ConnectionPool.create();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Cust v) throws Exception {
		log.info("Inserted: " + v.toString());
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.custInsert);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("아이디중복에러");
		} finally {
			cp.releaseConnection(con);
			DBUtil.close(pstmt);
		}
		return result;
	}

	@Override
	public int update(Cust v) throws Exception {
		log.info("Updated: " + v.toString());
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.custUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("업데이트에러.");
		} finally {
			cp.releaseConnection(con);
			DBUtil.close(pstmt);
		}
		return result;
	}

	@Override
	public int delete(String k) throws Exception {
		log.info("Deleted: " + k);
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.custDelete);
			pstmt.setString(1, k);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("삭제에러.");
		} finally {
			cp.releaseConnection(con);
			DBUtil.close(pstmt);
		}
		return result;
	}

	@Override
	public int delete() throws Exception {
		log.info("DeletedAll: ");
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.custDeleteAll);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("삭제에러.");
		} finally {
			cp.releaseConnection(con);
			DBUtil.close(pstmt);
		}
		return result;
	}

	@Override
	public Optional<Cust> select(String k) throws Exception {

		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Cust cust = null;
		try {
			pstmt = con.prepareStatement(SQL.custSelect);
			pstmt.setString(1, k);

			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				cust = Cust.builder()
						.id(rSet.getString("id"))
						.pwd(rSet.getString("pwd"))
						.name(rSet.getString("name"))
						.build();
			}
			;
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("조회에러.");
		} finally {
			DBUtil.close(pstmt, rSet);
			cp.releaseConnection(con);
		}

		return Optional.ofNullable(cust);
	}

	@Override
	public List<Cust> select() throws Exception {
		List<Cust> list = new ArrayList<>();

		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			pstmt = con.prepareStatement(SQL.custSelectAll);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				list.add(
						Cust.builder()
						.id(rSet.getString("id"))
						.pwd(rSet.getString("pwd"))
						.name(rSet.getString("name"))
						.build());
			}

		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("조회에러.");
		} finally {
			DBUtil.close(pstmt, rSet);
			cp.releaseConnection(con);
		}

		return list;
	}

}
