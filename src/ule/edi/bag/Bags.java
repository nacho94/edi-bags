package ule.edi.bag;

import org.junit.Assert;

/**
 * Operaciones con bolsas de tipo <code>Bag&lt;T&gt;</code>
 * 
 * Para simplificar el trabajo con genéricos, se definirá una operación
 * {@link #equality(Bag, Bag)} entre bolsas del mismo tipo de elemento, en
 * lugar de implementar el método {@link Object#equals(Object)}.
 * 
 * En las aserciones de JUnit habrá que tener cuidado de comparar instancias
 * de bolsas con esta operación, en lugar de {@link Assert#assertEquals(Object, Object)} y
 * similares que en realidad están invocando al método {@link Object#equals(Object)}.
 */
public abstract class Bags {

	/**
	 * Indica si las dos bolsas dadas son iguales.
	 * 
	 * Diremos que dos bolsas de elementos del mismo tipo T son iguales
	 * cuando se cumpla cualquiera de las condiciones:
	 * 
	 * 	(1) son la misma referencia en memoria
	 * 
	 * 	(2) ambas son referencias <code>null</code>
	 * 
	 * 	(3) contienen los mismos elementos y en igual número
	 * 
	 * Por ejemplo, dos bolsas
	 * 
	 * 	B1 = (("ABC"(x2)), ("123"(x1)))
	 * 	B2 = (("123"(x1)), ("ABC"(x3)))
	 * 
	 * son diferentes, porque aunque contienen los mismos elementos
	 * no es en igual número.
	 * 
	 * 
	 * (pistas)
	 * 
	 * Se puede usar otra bolsa auxiliar C para calcular primero qué
	 * elementos hay en ambas bolsas, con independencia de cuántos.
	 * 
	 * Para el ejemplo anterior se calcularía
	 * 
	 * 	C = (("ABC"(x1)), ("123"(x1)))
	 * 
	 * A continuación se comprueba que cada elemento en C está en
	 * las bolsas B1 y B2 con la misma multiplicidad.
	 * 
	 * 
	 * Si se tuviera
	 * 
	 * 	B1 = ("ABC"(x2), "123"(x1), "foo"(x1))
	 * 	B2 = ("ABC"(x2), "123"(x1))
	 * 
	 * entonces
	 * 
	 * 	C = ("ABC"(x1), "123"(x1), "foo"(x1))
	 * 
	 * y la última comprobación dirá que B1 y B2 son diferentes.
	 * 
	 * @param B1 primera bolsa a comparar
	 * @param B2 segunda bolsa a comparar
	 * @return resultado de la comparación de igualdad
	 */
	public static <T> boolean equality(Bag<T> B1, Bag<T> B2) {
		
		return false;
	}
	
	/**
	 * Calcula la unión de dos bolsas de elementos del mismo tipo
	 * 
	 * La unión se define como una nueva bolsa donde están todos
	 * los elementos de las dadas como parámetro.
	 * 
	 * En este caso se tiene garantía de que ninguna de las bolsas
	 * dadas como parámetro serán <code>null</code>.
	 * 
	 * Por ejemplo
	 * 
	 * 	B1 = ("ABC"(x2), "X1"(x3))
	 * 	B2 = ("ABC"(x1), "Y1"(x1))
	 * 
	 * 	B1 U B2 = ("ABC"(x3), "X1"(x3), "Y1"(x1))
	 * 
	 * @param B1
	 * @param B2
	 * @return
	 */
	public static <T> Bag<T> union(Bag<T> B1, Bag<T> B2) {
		
		return null;
	}
	
	/**
	 * Devuelve una bolsa con A \ B, los elementos de B eliminados de A
	 * 
	 * Aquí también se tiene garantía de que ninguna de las bolsas
	 * dadas como parámetro serán <code>null</code>.

	 * Por ejemplo
	 * 
	 * 	A = ("ABC"(x3), "123"(x2), "GX"(x1))
	 * 	B = ("ABC"(x1), "foo"(x2), "123"(x100))
	 * 
	 * 	A \ B = ("ABC"(x2), "GX"(x1))
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static <T> Bag<T> complement(Bag<T> A, Bag<T> B) {
		
		return null;
	}
	
}
