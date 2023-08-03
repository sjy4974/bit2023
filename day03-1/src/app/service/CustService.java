package app.service;

import java.util.logging.Logger;

import app.dao.CustMySQLDao;
import app.dto.Cust;

public class CustService {

	Logger log = Logger.getLogger("CustService");
	
	CustMySQLDao dao;

	public CustService() {
		dao = new CustMySQLDao();
	}

	public void register(Cust cust) {
		log.info("Security Check ...");
		dao.insert(cust);
		log.info("send Email ...");
	}

	public Cust get(String id) {
		return dao.select(id);

	}
}
