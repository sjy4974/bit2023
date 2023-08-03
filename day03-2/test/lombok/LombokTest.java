package lombok;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import app.dto.Cust;

class LombokTest {
	
	Logger log = Logger.getLogger("LombokTest");
	@Test
	void test() {
		// given
		Cust cust = Cust.builder()
				.id("id01")
				.pwd("pwd01")
				.name("jun")
				.build();
		// when
		
		// then
		
		log.info(cust.toString());
		
		assertEquals("Error!",cust.getId(),"id01");
		
		
	}

}
