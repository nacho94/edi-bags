package ule.edi.bag;

import org.junit.Before;
import org.junit.Test;

import ule.edi.currency.Euro;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BagsTests {

	private Bag<Euro.Denomination> empty;
	
	private Bag<Euro.Denomination> deposit01;
	
	private Bag<Euro.Denomination> deposit02;
	
	@Before
	public void setupInstances() {
	
		this.empty = new LinkedBagImpl<Euro.Denomination>();
		
		this.deposit01 = new ArrayBagImpl<Euro.Denomination>();
		
		this.deposit02 = new LinkedBagImpl<Euro.Denomination>();
	}
	
	//	Ejemplos
	
	@Test
	public void testEqualityOfNullReferences() {
		//	No se ha definido Object#equals() para el TAD Bag, sino
		//	una operación equality()
		assertThat(Bags.equality(null, null), is(true));
	}
	
	@Test
	public void testComplement() {
		//	Añade contenido a las bolsas
		deposit01.add(Euro.ONE_HUNDRED_EUROS, 1);
		deposit01.add(Euro.FIFTY_EUROS, 2);

		deposit02.add(Euro.FIFTY_EUROS, 1);
		
		//	Crea el "valor esperado" para la aserción
		Bag<Euro.Denomination> expected = new LinkedBagImpl<Euro.Denomination>();
		
		expected.add(Euro.ONE_HUNDRED_EUROS, 1);
		expected.add(Euro.FIFTY_EUROS, 1);
		
		//	Compara el "valor esperado" con el resultado de la operación
		assertThat(Bags.equality(Bags.complement(deposit01, deposit02), expected), is(true));
	}
	
}
