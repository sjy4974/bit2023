package app.main;

import app.dto.Cust;
import app.service.CustService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustService service = new CustService();
		Cust cust = Cust.builder()
				.id("id01")
				.pwd("pwd01")
				.name("jun")
				.build();
		service.register(cust);
		
//		service.get(cust.getId());

	}

}
