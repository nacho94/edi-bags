package ule.edi.bag;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayBagImplTest {
	ArrayBagImpl<String> a;
	@Before
	public void setUp() throws Exception {
		a = new ArrayBagImpl<String>();
	}
	
	@Test
	public void testLinkedBagImpl() {
		a = new ArrayBagImpl<String>();
	}

	@Test
	public void testAddTInt() {
		a.add("av",8);
		a.add("av",1);
		Assert.assertEquals(9, a.count("av"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddTIntExecption() {
		a.add(null,8);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddTIntExecption2() {
		a.add("av",-1);
	}
	
	@Test
	public void testAddT() {
		a.add("v");
		Assert.assertEquals(1, a.count("v"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddException() {
		a.add(null);
	}

	@Test(expected=NullPointerException.class)
	public void testRemoveTIntException() {
		a.remove(null,3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveTIntException2() {
		a.remove("av",-1);
	}
	
	@Test
	public void testRemoveTInt() {
		a.add("av",5);
		a.remove("av",2);
		Assert.assertEquals(3, a.count("av"));
	}
	@Test
	public void testRemoveTInt2() {
		a.add("abc", 8);
		a.add("AFR",3);
		a.add("we",5);
		a.add("r");
		a.remove("we", 8);
		Assert.assertEquals("(\"abc\"(x8), \"AFR\"(x3), \"r\"(x1))", a.toString());
	}
	
	@Test
	public void testRemoveT() {
		a.add("av",5);
		a.remove("av");
		Assert.assertEquals(4, a.count("av"));
	}
	
	@Test
	public void testRemoveTEmpty() {
		a.remove("av");
	}
	
	@Test(expected=NullPointerException.class)
	public void testRemoveTException() {
		a.remove(null);
		
	}
	@Test
	public void testClear() {
		a.add("av",5);
		a.clear();
	}

	@Test(expected=NullPointerException.class)
	public void testContainsException() {
		a.contains(null);
	}
	
	@Test
	public void testContains() {
		a.add("abc",8);
		Assert.assertTrue(a.contains("abc"));
	}
	@Test
	public void testContains2() {
		
		Assert.assertFalse(a.contains("abc"));
	}

	@Test
	public void testIsEmpty() {
		a.add("abc", 8);
		Assert.assertFalse(a.isEmpty());
	}
	
	@Test
	public void testIsEmpty2() {
		Assert.assertTrue(a.isEmpty());
	}
	
	@Test
	public void testSize() {
		a.add("abc", 8);
		a.add("AFR",3);
		Assert.assertEquals(11, a.size());
	}

	@Test
	public void testCount() {
		a.add("abc", 8);
		Assert.assertEquals(8, a.count("abc"));
	}
	
	@Test
	public void testCount2() {	
		Assert.assertEquals(0, a.count("abc"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testCountException() {
		a.count(null);
	}

	@Test
	public void testIterator() {
		a.add("abc", 8);
		a.add("AFR",3);
		Iterator<String> it = a.iterator();
		while(it.hasNext()) {
			it.next();
		}
		
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testIteratorException() {
		a.add("abc", 8);
		a.add("AFR",3);
		Iterator<String> it = a.iterator();
		while(true) {
			it.next();
		}
		
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testIteratorException2() {
		Iterator<String> it = a.iterator();
		it.remove();
	}
		
	@Test
	public void testToString() {
		a.add("abc", 8);
		a.add("AFR",3);
		Assert.assertEquals("(\"abc\"(x8), \"AFR\"(x3))", a.toString(),"(\"abc\"(x8), \"AFR\"(x3))");
	}

}
