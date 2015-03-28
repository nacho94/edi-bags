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
 		if(element == null) {
			throw new NullPointerException();	
		}
		if(times < 0) {
			throw new IllegalArgumentException();
		}
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
		if(element == null) {
			throw new NullPointerException();	
		}
		add(element,1);	
	}
	
	private Node findPreviousNode(Node n) {
		Node r = list;
		Node p = null;
		while(r != null && r.next != n) {
			p = r;
			r = r.next;
		}
		return p;
	}

	@Override
	public void remove(T element, int times) {
		if(element == null) {
			throw new NullPointerException();	
		}
		if(times < 0) {
			throw new IllegalArgumentException();
		}
		Node r = findNode(element);
		if(r != null) {
			r.counter -= times;
			if(r.counter <= 0) {
				Node aux = findPreviousNode(r);
				aux.next = r.next;
			}
		}
		
	}

	@Override
	public void remove(T element) {
		if(element == null) {
			throw new NullPointerException();	
		}
		remove(element, 1);
		
	}

	@Override
	public void clear() {
		list = null;
		elementCount = 0;
		
	}

	@Override
	public boolean contains(T element) {
		if(element == null) {
			throw new NullPointerException();	
		}
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
		if(element == null) {
			throw new NullPointerException();	
		}
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
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
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
		
		Node r = list;
		while(r != null) {
			buffer.append("\"");
			buffer.append(r.obj);
			buffer.append("\"(x");
			buffer.append(r.counter);
			if(r.next == null) {
				buffer.append(")");
			} else {
				buffer.append("), ");
			}
			
			r = r.next;
		}

		// TODO Ir añadiendo en buffer las cadenas para la representación de esta bolsa
		
		buffer.append(")");
		
		return buffer.toString();
	}
	public static void main(String[] args) {
		LinkedBagImpl<String> a = new LinkedBagImpl<String>();
		
		a.add("abc", 8);
		a.add("AFR",3);
		System.out.println(a.isEmpty());
		System.out.println(a.contains("AFR"));
		System.out.println(a.size());
		System.out.println(a.count("abc"));
		a.remove("AFR", 2);
		System.out.print(a.toString());
	}

}
