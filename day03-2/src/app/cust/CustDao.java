package app.cust;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.dto.Cust;
import app.frame.DaoFrame;

public class CustDao implements DaoFrame<String, Cust> {

	Logger log = Logger.getLogger("CustDao");
	
	@Override
	public void insert(Cust v) {
		log.info("Inserted: "+ v.toString());
	}

	@Override
	public void update(Cust v) {
		log.info("Updated: "+ v.toString());
		
	}

	@Override
	public void delete(String k) {
		log.info("Deleted: "+ k);
		
	}

	@Override
	public Cust select(String k) {
		
		Cust cust = Cust.builder()
				.id("id01")
				.pwd("pwd01")
				.name("jun")
				.build();
		return cust;
	}

	@Override
	public List<Cust> select() {
		List<Cust> list = new ArrayList<>();
		
		list.add(Cust.builder()
				.id("id01")
				.pwd("pwd01")
				.name("jun1")
				.build());
		list.add(Cust.builder()
				.id("id02")
				.pwd("pwd02")
				.name("jun2")
				.build());
		list.add(Cust.builder()
				.id("id03")
				.pwd("pwd03")
				.name("jun3")
				.build());
		list.add(Cust.builder()
				.id("id04")
				.pwd("pwd04")
				.name("jun4")
				.build());
		
		return list;
	}

	

}
