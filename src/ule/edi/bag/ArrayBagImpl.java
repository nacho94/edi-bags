package ule.edi.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.EmptyCollectionException;

public class ArrayBagImpl<T> implements Bag<T> {
	
	private final int RESERVATION_SIZE = 5;
	private T[] array = null;
	private int[] arrayCounters = null;
	private int arraySize = 0;
	private int elementCount = 0;
	
	private void reserveMemory() {
		if(arraySize <= elementCount) {
			// no se pueden crear arrays de objetos sin tipo de ahi esto
			T[] tmp = (T[]) new Object[arraySize + RESERVATION_SIZE];
			arraySize += RESERVATION_SIZE;
			System.arraycopy(array, 0, tmp, 0, elementCount);
			array = tmp;
			for(int i=elementCount; i<arraySize; i++) {
				array[i] = null;
			}
			// TODO : evitar   doble bucle
			int[] tmpC = new int[arraySize];
			System.arraycopy(arrayCounters, 0, tmpC, 0, elementCount);
			arrayCounters = tmpC;
			for(int i=elementCount; i<arraySize; i++) {
				arrayCounters[i] = 0;
			}
			
		}
	}
	
	private int findPositionOf(T element) {
		for(int i=0;i<elementCount; i++) {
			if(array[i].equals(element)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public ArrayBagImpl() {
		
	}

	@Override
	public void add(T element, int times) {
		// TODO Auto-generated method stub
		reserveMemory();
		int pos = findPositionOf(element);
		if(pos > -1) {
			arrayCounters[pos] += times;
		} else {
			array[elementCount] = element;
			arrayCounters[elementCount] += times;
		}
		
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		this.add(element,1);
	}

	@Override
	public void remove(T element, int times) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// lo hago asi para no perder la memoria reservada
		for(int i=0;i<arraySize;i++) {
			array[i] = null;
			arrayCounters[i] = 0;
		}
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		
		return findPositionOf(element) != -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elementCount == 0;
	}

	@Override
	public long size() {
		int count = 0;
		for(int i=0; i<elementCount; i++) {
			count += arrayCounters[i];
		}
		
		return count;
	}

	@Override
	public int count(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		
		final StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");

		// TODO Ir añadiendo en buffer las cadenas para la representación de esta bolsa
		
		buffer.append(")");
		
		return buffer.toString();
	}
	public static void main(String[] args) {
		ArrayBagImpl<Integer> a = new ArrayBagImpl<Integer>();
	}
}
