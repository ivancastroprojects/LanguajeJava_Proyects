package ule.edi.SimpleList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.SimpleList.AbstractSingleLinkedListImpl.Node;



public class SingleLinkedListImpl<T> extends AbstractSingleLinkedListImpl<T> {

	@SafeVarargs
	public SingleLinkedListImpl(T ... elements) {
		
		// IMPLEMENTAR DE FORMA RECURSIVA 
		header = null;
		if(elements.length > 0) {
			Node<T> nodo = new Node<T>(elements[0]);
			header = nodo;
		}
		SingleLinkedListImplRec(header, elements, elements.length, 1);
    }
	
	private void SingleLinkedListImplRec(Node<T> actual, T[] elem, int tamaño, int cont) {
		if(tamaño != cont && cont < tamaño) {
			Node<T> nodo = new Node<T>(elem[cont]);
			actual.next = nodo;
			SingleLinkedListImplRec(actual.next, elem, tamaño, cont+1);
		}
	}
		
	@Override
	public void addLast(T element) {
		Node<T> nodo = new Node<T>(element);
		if(header == null) {
			header = nodo;
		} else addLastRec(header, nodo);
	}
	
	private void addLastRec(Node<T>actual, Node<T> nodo) {
		if(actual.next != null)
			addLastRec(actual.next, nodo);
		else actual.next = nodo;
	}
	
	
	public Iterator<T> iterator() {
		return new ForwardIterator();
	}
	private class ForwardIterator implements Iterator<T> {

		private Node<T> at = header ;
		
		@Override
		public boolean hasNext() {
			if(header == null)
				return false;
			else if(at.next == null)
				return false;
			else return true;
		}

		@Override
		public T next() {	
			if(hasNext())
				at = at.next;
			else throw new NoSuchElementException();
			return at.content;
		}
	};

	@Override
	public boolean isEmpty() {
		if(header == null)
			return true;
		return false;
	}

	@Override
	public int size() {
		return sizeRec(header);
	}
	
	private int sizeRec(Node<T> actual) {
		if(actual == null)
			return 0;
		else return 1+sizeRec(actual.next);
	}

	@Override
	public void addFirst(T element) {
		Node<T> nodo = new Node<T>(element);
		if(header == null)
			header = nodo;
		else {
			nodo.next = header;
			header = nodo;
		}
	}

	
	@Override
	public void addAtPos(T element, int p) {
		if(header == null || p == 1)
			addFirst(element);
		else if(p > size())
			addLast(element);
		else addAtPosRec(header, element, p, 1);
	}
	
	private void addAtPosRec(Node<T>actual, T element, int p, int indice) {
		Node<T> nodo = new Node<T>(element);
		if(p-1 != indice)
			addAtPosRec(actual.next, element, p, indice+1);
		else {
			nodo.next = actual.next;
			actual.next = nodo;
		}
	}

	@Override
	public void addNTimes(T element, int n) {
		addNTimesRec(element, n);
	}
	
	private void addNTimesRec(T element, int n) {
		if(n>0) {
			addLast(element);
			addNTimesRec(element, --n);
		}
	}

	@Override
	public int indexOf(T element) {
		return indexOfRec(header, element);
	}
	
	private int indexOfRec(Node<T> actual, T element) {
		if(actual == null) 
			throw new NoSuchElementException();
		if(actual.content.equals(element))
			return 1;
		else return 1+indexOfRec(actual.next, element);
	}

	@Override
	public T removeLast() throws EmptyCollectionException {
		if(header == null)
			throw new EmptyCollectionException("");
		else if(size() == 1) {
			Node<T> nodo = new Node<T>(header.content);
			header = null;
			return nodo.content;
		} else if(size() == 2) {
			Node<T> nodo = new Node<T>(header.next.content);
			header.next = null;
			return nodo.content;
		} else return removeLastRec(header);
	}
	
	private T removeLastRec(Node<T> actual) {
		if(actual.next.next != null)
			return removeLastRec(actual.next);
		else {
			Node<T> nodo = new Node<T>(actual.next.content);
			actual.next = null;
			return nodo.content;
		}
	}

	@Override
	public T removeLast(T element) throws EmptyCollectionException {
		if(header == null)
			throw new EmptyCollectionException("");
		int pos = removeLastRec(header, element, 1, 0);
		return removeLastIn(header, element, 2, pos);
	}
	
	private int removeLastRec(Node<T> actual, T element, int contador, int posicion) {
		if(contador >= size() && posicion == 0)
			throw new NoSuchElementException();
		if(actual == null)
			return posicion;
		if(actual.content.equals(element)) {
			posicion = contador;
			return removeLastRec(actual.next, element, contador+1, posicion);
		}
		else return removeLastRec(actual.next, element, contador+1, posicion);
	}
	
	private T removeLastIn(Node<T> actual, T element, int cont, int pos) {
		if(pos == 1) {
			T nodo = actual.content;
			header = header.next;	
			return nodo;
		}
		if(pos == 2) {
			T nodo = actual.next.content;
			actual.next = actual.next.next;
			return nodo;
		}
		if(pos == cont) {
			T nodo = actual.next.content;
			actual.next = actual.next.next;
			return nodo;
		} else return removeLastIn(actual.next, element, cont+1, pos);
	}
	@Override
	public AbstractSingleLinkedListImpl<T> reverse() {
		SingleLinkedListImpl<T> reverse = new SingleLinkedListImpl<T>();
		reverse = AbstractSingleLinkedListImplRec(header, reverse);
		return reverse;
	}
	
	private SingleLinkedListImpl<T> AbstractSingleLinkedListImplRec(Node<T> actual, SingleLinkedListImpl<T> reverse) {
		if(actual != null) {
			reverse.addFirst(actual.content); 
			return AbstractSingleLinkedListImplRec(actual.next, reverse);
		}
		return reverse;
	}

	@Override
	public int isSubList(AbstractSingleLinkedListImpl<T> part) {
		if(part.isEmpty())
			return 1;
		else if(isEmpty())
			return -1;
		else {
			Node<T> nodo = part.header;
			return 1+isSubListRec(part, header, nodo);
		}
	}
	
	private int isSubListRec(AbstractSingleLinkedListImpl<T> part, Node<T> actual, Node<T> nodo) {
		if(actual.content.equals(nodo.content)) {
			if(nodo.next == null)
				return 0;
			if(actual.next == null)
				return -1;
			else return isSubListRec(part, actual.next, nodo.next);
		} else {
			if(actual.next != null) {
				header = header.next;
				actual = header;
				nodo = part.header;
				return 1+ isSubListRec(part, actual, nodo);
		} else return -1;
		}
	}
	
}
