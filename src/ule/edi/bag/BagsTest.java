package ule.edi.bag;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ule.edi.currency.Euro;

public class BagsTest {
	
	private Bag<String> empty;
	private Bag<String> deposit01;
	private Bag<String> deposit02;
	Bags a; 
	
	@Before
	public void setUp() throws Exception {
		empty = new ArrayBagImpl<String>();
		deposit01 = new LinkedBagImpl<String>();
		deposit02 = new LinkedBagImpl<String>();
		a= new Bags() {
		};
	}

	@Test
	public void testEquality() {
		Bags.equality(deposit01, deposit02);
	}
	
	@Test
	public void testEquality2() {
		deposit01.add("abc",2);
		deposit01.add("X1",3);
		
		deposit02.add("Y1");
		Bags.equality(deposit01, deposit02);
	}
	
	@Test
	public void testEquality3() {
		Bags.equality(null,null);
	}

	@Test
	public void testEquality4() {
		Bags.equality(deposit01,null);
	}
	
	@Test
	public void testEquality5() {
		Bags.equality(deposit01,empty);
	}
	

	@Test
	public void testEquality6() {
		deposit01.add("Y1");
		deposit02.add("Y1");
		Bags.equality(deposit01,deposit02);
	}
	
	@Test
	public void testEquality7() {
		Bag<String> a = null;
		deposit02.add("Y1");
		Bags.equality(a,deposit02);
	}
	
	@Test
	public void testEquality8() {
		deposit01.add("abc",2);
		deposit01.add("X1",3);
		deposit02.add("abc");
		deposit02.add("Y1");
		Bags.equality(deposit01, deposit02);
	}
	
	@Test
	public void testEquality9() {
		deposit01.add("abc",2);
		deposit01.add("X1",3);
		deposit02.add("abc",2);
		deposit02.add("Y1",3);
		Assert.assertFalse(Bags.equality(deposit01, deposit02));
	}
	
	@Test
	public void testEquality10() {
		Bag<String> a = new LinkedBagImpl<String>();
		a = null;
		Bag<String> b = new LinkedBagImpl<String>();
		b = null;
		Bags.equality(a, b);
	}
	
	@Test
	public void testEquality11() {
		deposit01.add("abc",2);
		deposit01.add("X1",3);
		deposit02.add("abc",2);
		deposit02.add("X1",3);
		deposit02.add("qw");
		
		Assert.assertFalse(Bags.equality(deposit01, deposit02));
		
	}
	
	@Test
	public void testUnion() {
		deposit01.add("abc",2);
		deposit01.add("X1",3);
		deposit02.add("abc");
		deposit02.add("Y1");
		Assert.assertEquals("(\"abc\"(x3), \"X1\"(x3), \"Y1\"(x1))", Bags.union(deposit01, deposit02).toString());
	}

	@Test
	public void testComplement() {
		deposit01.add("100", 1);
		deposit01.add("50", 2);

		deposit02.add("50", 1);
		
		//	Crea el "valor esperado" para la aserción
		Bag<String> expected = new LinkedBagImpl<String>();
		
		expected.add("100", 1);
		expected.add("50", 1);
		
		//	Compara el "valor esperado" con el resultado de la operación
		assertThat(Bags.equality(Bags.complement(deposit01, deposit02), expected), is(true));
	
	}

}
