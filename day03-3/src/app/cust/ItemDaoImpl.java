package app.cust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.dto.Cust;
import app.dto.Item;
import app.frame.ConnectionPool;
import app.frame.DaoFrame;
import app.frame.SQL;
import app.util.DBUtil;

public class ItemDaoImpl implements DaoFrame<Integer, Item> {

	Logger log = Logger.getLogger("ItemDao");
	
	ConnectionPool cp;

	public ItemDaoImpl() {
		try {
			cp = ConnectionPool.create();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(Item v) throws Exception {
		log.info("Inserted: "+ v.toString());
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemInsert);
			pstmt.setLong(1, v.getPrice());
			pstmt.setString(2, v.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("아이디중복에러.");
		} finally {
			cp.releaseConnection(con);
			DBUtil.close(pstmt);
		}
		return result;
	}

	@Override
	public int update(Item v) throws Exception {
		log.info("Updated: "+ v.toString());
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemUpdate);
			pstmt.setLong(1, v.getPrice());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getId());
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
	public int delete(Integer k) throws Exception {
		log.info("Deleted: "+ k);
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemDelete);
			pstmt.setInt(1, k);
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
		// TODO Auto-generated method stub
		int result = 0;
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.itemDeleteAll);
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
	public Item select(Integer k) throws Exception {
		// TODO Auto-generated method stub
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Item item = null;
		try {
			pstmt = con.prepareStatement(SQL.itemSelect);
			pstmt.setInt(1, k);
			
			rSet = pstmt.executeQuery();
			rSet.next();
			item = Item.builder()
				.id(rSet.getInt("id"))
				.price(rSet.getLong("price"))
				.name(rSet.getString("name"))
				.build();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception("조회에러.");
		} finally {
			DBUtil.close(pstmt, rSet);
			cp.releaseConnection(con);
		}
		
		return item;

	}

	@Override
	public List<Item> select() throws Exception {
		List<Item> list = new ArrayList<>();

		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try {
			pstmt = con.prepareStatement(SQL.itemSelectAll);
			rSet = pstmt.executeQuery();
			while(rSet.next()) {
				list.add(
					Item.builder()
				.id(rSet.getInt("id"))
				.price(rSet.getLong("price"))
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
