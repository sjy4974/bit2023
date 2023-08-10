package day01;

import static org.junit.Assert.*;

import org.junit.Test;

import app.cust.CustServiceImpl;
import app.dto.Cust;

public class CustSelect {

	@Test
	public void test() {
		CustServiceImpl service = new CustServiceImpl();
		
		Cust cust = new Cust("id12", "pwd12", "james");
		
		try {
			service.register(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cust = null;
		try {
			cust = service.get("id12");
			System.out.println(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
