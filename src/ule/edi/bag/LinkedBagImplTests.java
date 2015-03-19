package ule.edi.bag;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.Test;

public class LinkedBagImplTests  {

	

	
	@Test
	public void testOnlyOnArrayBags() {
		
		Bag<BigDecimal> huge = new LinkedBagImpl<BigDecimal>();
		
		Logger.getLogger("ule.edi").info("Running on " + huge.getClass().getName() + " implementation of Bag<T>");
	}

	
	//	Métodos de prueba JUnit con 'expected' deben ir en las clases específicas
	//	para que Web-CAT no calcule su cobertura
	
	@Test(expected = NullPointerException.class)
	public void testNullCheckOnAdd() {
//		S1.add(null);
	}
	
}
