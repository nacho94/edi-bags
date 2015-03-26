package ule.edi.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.EmptyCollectionException;

public class LinkedBagImpl<T> implements Bag<T> {
	
	private class Node {
		public T obj = null;
		public int counter = 0;
		public Node next = null;
		
		public Node(T element , int times) {
			obj = element;
			counter = times;
		}
	}
	
	int elementCount = 0;
	Node list = null;
	
	public LinkedBagImpl() {
		
	}
	
	private Node getLastNode() {
		Node r = list;
		while(r.next != null) {
			r = r.next;
		}
		return r;
	}
	
	private Node findNode(T element) {
		Node r = list;
		while(r != null && !r.obj.equals(element)) {
			r = r.next;
		}
		return r;
	}
	
 	@Override
	public void add(T element, int times) {
		if(list == null) {
			list = new Node(element,times);
			elementCount++;
		} else {
			Node aux = findNode(element);
			if(aux != null) {
				aux.counter += times;
			} else {
				Node last = getLastNode();
				last.next = new Node(element,times);
				elementCount++;
			}
		}
	}

	@Override
	public void add(T element) {
		add(element,1);	
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
		list = null;
		elementCount = 0;
		
	}

	@Override
	public boolean contains(T element) {
		
		return findNode(element) != null;
	}

	@Override
	public boolean isEmpty() {
		
		return list == null;
	}

	@Override
	public long size() {
		int result = 0;
		Node r = list;
		while(r != null) {
			result += r.counter;
			r = r.next;
		}
		return result;
	}

	@Override
	public int count(T element) {
		Node a = findNode(element);
		return a == null ? 0 : a.counter;
	}
	
	private class LinkedBagIterator implements Iterator<T> {
		private Node r = list;
		public boolean hasNext(){	
			return r != null && r.next != null;
		}
		
		public T next() throws NoSuchElementException {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			Node aux = r;
			r = r.next;
			return aux.obj;	
		}
	};

	@Override
	public Iterator<T> iterator() {
		
		return new LinkedBagIterator();
	}
	
	@Override
	public String toString() {
		
		final StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");

		// TODO Ir añadiendo en buffer las cadenas para la representación de esta bolsa
		
		buffer.append(")");
		
		return buffer.toString();
	}

}
