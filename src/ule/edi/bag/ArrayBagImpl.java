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
			@SuppressWarnings("unchecked")
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
		if(element == null) {
			throw new NullPointerException();	
		}
		if(times < 0) {
			throw new IllegalArgumentException();
		}
		reserveMemory();
		int pos = findPositionOf(element);
		if(pos > -1) {
			arrayCounters[pos] += times;
		} else {
			array[elementCount] = element;
			arrayCounters[elementCount] += times;
			elementCount++;
		}
		
	}

	@Override
	public void add(T element) {
		if(element == null) {
			throw new NullPointerException();
		}
		this.add(element,1);
	}

	@Override
	public void remove(T element, int times) {
		if(element == null) {
			throw new NullPointerException();	
		}
		if(times < 0) {
			throw new IllegalArgumentException();
		}
		int position = findPositionOf(element);
		if(position >= 0) {
			arrayCounters[position] -= times;
			if(arrayCounters[position] <= 0) {
				array[position] = null;
				arrayCounters[position] = 0;
				elementCount--;
				for(int i=position; i<arraySize-1; i++) {
					array[i] = array[i+1];
					arrayCounters[i] = arrayCounters[i+1];
				}
				array[arraySize-1] = null;
				arrayCounters[arraySize-1] = 0;
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element == null) {
			throw new NullPointerException();
		}
		remove(element,1);
		
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
		if(element == null) {
			throw new NullPointerException();
		}
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
		if(element == null) {
			throw new NullPointerException();
		}
		int pos = findPositionOf(element);
		if(pos > -1) {
			return arrayCounters[pos];
		}
		return 0;
	}
	
	private class ArrayBagIterator implements Iterator<T> {
		private int position = 0;
		
		public boolean hasNext(){	
			return position < elementCount;
		}
		
		public T next() throws NoSuchElementException {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return array[position++];
		}
		
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	};

	@Override
	public Iterator<T> iterator() {
		 
		return new ArrayBagIterator();
	}
	
	@Override
	public String toString() {
		
		final StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");

		for(int i=0; i<elementCount; i++) {
			buffer.append("\"");
			buffer.append(array[i]);
			buffer.append("\"(x");
			buffer.append(arrayCounters[i]);
			buffer.append("), ");
		}
		
		buffer.append(")");
		
		return buffer.toString();
	}
	/*public static void main(String[] args) {
		ArrayBagImpl<Integer> a = new ArrayBagImpl<Integer>();
		a.add(123);
	}*/
}
