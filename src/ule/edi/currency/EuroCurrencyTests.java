package ule.edi.currency;


import org.junit.Test;

import ule.edi.bag.ArrayBagImpl;
import ule.edi.bag.Bag;
import ule.edi.bag.LinkedBagImpl;
import ule.edi.currency.Euro.Denomination;

public class EuroCurrencyTests {

		Euro a = new Euro();
		
		Denomination b = new Denomination(1);
	//	Calcula el valor en Euros de una bolsa
	
	private double totalValueInEuros(Bag<Denomination> b) {

		double result = 0.0;

		for (Denomination t : Euro.ALL_DENOMINATIONS) {
			result = result + (t.getValue() * b.count(t));
			t.hashCode();
			t.equals(null);
		}
		
		return result / 100.0;
	}
	
	@Test
	public void testBagOfEuros() {
		
		//	Crea una bolsa con elementos del tipo adecuado
		Bag<Euro.Denomination> B = new LinkedBagImpl<Euro.Denomination>();
		
		//	Añade contenido a la bolsa
		B.add(Euro.FIVE_HUNDRED_EUROS, 1);
		B.add(Euro.TWO_HUNDRED_EUROS, 1);
		B.add(Euro.TEN_EUROS, 1);
		B.add(Euro.FIFTY_CENTS, 1);
		
		//	Imprime el contenido de la bolsa; para todas las denominaciones legales...
		for (Euro.Denomination t : Euro.ALL_DENOMINATIONS) {
			//	Si la bolsa contiene esa denominación...
			if (B.contains(t)) {
				//	Mostrar cuántas veces
				System.out.println(t + " x " + B.count(t));
			}
		}
		
		//	Imprime el valor total
		System.out.println("Total: " + Euro.formatValue(totalValueInEuros(B)));
		
		//	Imprime mediante el iterador; para cada elemento en la bolsa que indique el iterador...
		for (Euro.Denomination x : B) {
			//	Mostrarlo
			System.out.println(x);
		}
	}
}
