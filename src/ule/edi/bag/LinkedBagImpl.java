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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
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

}
