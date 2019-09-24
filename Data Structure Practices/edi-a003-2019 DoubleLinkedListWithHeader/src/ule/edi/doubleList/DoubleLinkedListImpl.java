package ule.edi.doubleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.imageio.IIOException;
import javax.sound.midi.Soundbank;

public class DoubleLinkedListImpl<T> implements DoubleLinkedList<T> {
	/**
	 * Nodo doblemente enlazado.
	 * 
	 * Como es estÃ¡tica, no tiene en Ã¡mbito el numParÃ¡metro 'T' de la
	 * clase que la contiene. El numParÃ¡metro 'D' serÃ¡ sustituÃ­do por
	 * un tipo numParticular cuando se use el nodo, por ejemplo:
	 * 
	 * 		DoubleNode<T> cab;
	 * 
	 * en la lista.
	 *
	 * @numParam <D>
	 */
	static class DoubleNode<D> {

		DoubleNode(D element) {
			this.content = element;
			this.previous = null;
			this.next = null;

		}
		
		//	dato a almacenar en el nodo
		D content;
		
		DoubleNode<D> previous;
		
		DoubleNode<D> next;
	}

	/**
	 * Apunta al nodo cabecera; siempre habrÃ¡ un nodo vacÃ­o (sin elemento) que actua de cabecera
	 *  OJO!!! ESTE NODO CABECERA DEBERÃ� CREARSE EN CADA CONSTRUCTOR DE LA LISTA
	 */
	private DoubleNode<T> cab;
	
	
	
	//////////////////////
	/////  CONSTRUCTORES
	//////////////////////
	
	
	/**
	 * Construye una lista vacia.
	 */
	public DoubleLinkedListImpl() {
		cab = new DoubleNode<T>(null);	
		cab.next = cab;
		cab.previous = cab;
	}
	
	/**
	 * Construye una lista con los elementos dados.
	 * 
	 * Java crearÃ¡ un array 'elements' con los dados en la
	 * llamada al constructor; por ejemplo:
	 * 
	 * 	x = new DoubleLinkedList<String>("A", "B", "C");
	 * 
	 * ejecuta este mÃ©todo con un array [A, B, C] en 
	 * 'elements'.
	 * 
	 * @numParam elements
	 */
	public DoubleLinkedListImpl(T ... elements) {
		ArrayList<T> lista = new ArrayList<T>();
		
		cab = new DoubleNode<T>(null);	
		cab.next = cab;
		cab.previous = cab;
		
		for(int i = 0; i < elements.length; i++) {
			addLast(elements[i]);
		}
	}
	
	/**
	 * Construye una lista a numPartir de otra.
	 * 
	 * Las listas tienen nodos independientes, con los mismos
	 * contenidos.
	 */
	public DoubleLinkedListImpl(DoubleLinkedList<T> other) {
		Iterator<T> iterador = other.iterator();
		
		cab = new DoubleNode<T>(null);	
		cab.next = cab;
		cab.previous = cab;
		
		while(iterador.hasNext()) 
			addLast( iterador.next());
	}
	

	
	//////////////////////
	/////  ITERADORES
	//////////////////////
	
	private class ForwardIterator implements Iterator<T> {

		private DoubleNode<T> at = cab;
		
		@Override
		public boolean hasNext() {
			
			if(at.next == cab)
				return false;
			
			return true;
		}

		@Override
		public T next() {
			
			if(hasNext())
				at = at.next;
			else
				throw new NoSuchElementException();
			return at.content;

		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};
	
	
	private class ReverseIterator implements Iterator<T> {

		private DoubleNode<T> at = cab;
		
		@Override
		public boolean hasNext() {
			if(at.previous == cab)
				return false;
			return true;
			
		}

		@Override
		public T next() {
			if(hasNext())
				at = at.previous;
			else
				throw new NoSuchElementException();
			
			return at.content;
			
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};
		// Definir los atributos necesarios numPara implementar el iterador
		private class OddAndEvenIterator implements Iterator<T> {
			private DoubleNode<T> at = cab;
			boolean primero = true;
			boolean introFirst = false;
			boolean numPar = true;

		
		public OddAndEvenIterator(){
			
		}
		
		@Override
		public boolean hasNext() {
			if(numPar) {
				if(at.next != cab && at.next.next != cab)
					return true;
				else if((at.next.next == cab &&at.next.next.next != cab) ||(at.next == cab) && at.next.next != cab) 
						numPar = false;
			}
			if(!numPar) {
				if(at.next != cab && at.next.next != cab)
					return true;
				if(primero) {
					introFirst = true;
					primero = false;
					if((at.next == cab && at.next.next != cab) || (at.next.next == cab && at.next.next.next != cab))
						return true;
				}
			}
				return false;
		}

		@Override
		public T next() {
			if(introFirst) {
				introFirst = false;
				at = cab;
				if(at.next != cab) {
					at = at.next;
					return at.content;
				}
			}	
			if(hasNext()) {
				at = at.next.next;
				return at.content;
			}
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};
		
	
	
	////// FIN DE ITERADORES ///////
	////////////////////////////////
	
	@Override
	public boolean isEmpty() {
		if(cab.next == cab)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		DoubleNode<T> cabAux = cab;
		int tam = 0;
		while(cabAux.next != cab) {
			tam++;
			cabAux = cabAux.next;
		}
		return tam;
	}
	
	@Override
	public void addFirst(T element) {
		DoubleNode<T> intro = new DoubleNode<T>(element);
		
		if(isEmpty()) {
			cab.next = intro;
			cab.previous = intro;
			intro.previous = cab;
			intro.next = cab;
		}
		else if(cab.next.next == cab) {
			cab.next = intro;
			cab.previous.previous = intro;
			intro.next = cab.previous;
			intro.previous = cab;
		}else {
			cab.next.previous = intro;
			intro.previous = cab;
			intro.next = cab.next;
			cab.next = intro;
		}
	}

	@Override
	public void addLast(T element) {
		DoubleNode<T> intro = new DoubleNode<T>(element);
		
		if(isEmpty()) {
			cab.next = intro;
			cab.previous = intro;
			intro.previous = cab;
			intro.next = cab;
		}
		else if(cab.next.next == cab) {
			cab.previous = intro;
			intro.next = cab;
			intro.previous = cab.next;
			cab.next.next = intro;
		}else {
			cab.previous.next = intro;
			intro.previous = cab.previous;
			intro.next = cab;
			cab.previous = intro;
		}
	}

	@Override
	public void addAtPos(T element, int p) {
		DoubleNode<T> aux = cab;
		DoubleNode<T> intro = new DoubleNode<T>(element);
		
		if(size() < p)
			addLast(element);
		else if(p == 1)
			addFirst(element);
		else {
			for(int i = 0; i <= p; i++) {
				if(i == p) {
					aux.previous.next = intro;
					intro.previous =aux.previous;
					aux.previous = intro;
					intro.next = aux;
				}else
					aux = aux.next;
			}
		}
	}

	@Override
	public void addNTimes(T element, int n) {
		for(int i=0; i<n; i++) {
			addLast(element);
		}
	}

	@Override
	public T getElem(int p) {
		DoubleNode<T> aux = cab;
		
		for(int i=0; i <= size(); i++) {
			if(i==p)
				return aux.content;
			aux = aux.next;
		}
		
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void setElem(T elem, int p) {
		DoubleNode<T> aux = cab;
		
		if(p<=0 || p>size())
			throw new IndexOutOfBoundsException();
		
		for(int i=0; i<=p; i++) {
			if(i==p)
				aux.content = elem;
			aux = aux.next;
		}
		
	}

	@Override
	public int indexOf(T elem) {
		DoubleNode<T> aux = cab;
		
		for(int i = 0; i <= size(); i++) {
			if(aux.content == elem)
				return i;
			aux = aux.next;
		}
		throw new NoSuchElementException();
	}

	@Override
	public int indexOf(T elem, int p) {
		DoubleNode<T> aux = cab;
		
		if(p <= 0 || p > size())
			throw new IndexOutOfBoundsException();
		
		for(int i=0; i<=size(); i++) {
			if((aux.content == elem) && (i==p))
				return i;
			aux = aux.next;
		}
		throw new NoSuchElementException();
	}

	@Override
	public T removeFirst(T elem) throws EmptyCollectionException {
		DoubleNode<T> aux = cab;
		
		if(size() == 0)
			throw new EmptyCollectionException("");
		
		for(int i=0; i<=size(); i++) {
			if(aux.content == elem) {
				aux.previous.next = aux.next;
				aux.next.previous = aux.previous;
				return elem;
			}
			aux = aux.next;
		}
		throw new NoSuchElementException();
	}

	@Override
	public T removeAll(T elem) throws EmptyCollectionException {
		DoubleNode<T> aux = cab;
		boolean borrado = false;
		
		if(size() == 0)
			throw new EmptyCollectionException("");
		
		for(int i = 0; i <= size(); i++) {
			if(aux.content == elem) {
				aux.previous.next = aux.next;
				aux.next.previous = aux.previous;
				borrado = true;
				i--;
			}
			aux = aux.next;
		}
		if(borrado)
			return elem;
		throw new NoSuchElementException();
	}
	@Override
	public T removeLast() throws EmptyCollectionException {
		if(size() == 0)
			throw new EmptyCollectionException("");
		
		T borrado = cab.previous.content;
		cab.previous.previous.next = cab;
		cab.previous = cab.previous.previous;
		return borrado;
	}
	
	@Override
	public void reverse() {
		ArrayList<T> lista = new ArrayList<T>();
		DoubleNode<T> aux = cab;
		aux = aux.next;
		int j = 0;
		while(cab != aux) {
			lista.add(aux.content);
			aux = aux.next;
		}
		cab.next = cab;
		cab.previous = cab;
		
		for(int i= 0; i < lista.size(); i++){
			addFirst(lista.get(i));
		}
	}

	@Override
	public int isSubList(DoubleLinkedList<T> numPart) {
		DoubleNode<T> aux = cab.next;
		Iterator<T> iterador = numPart.iterator();
		ArrayList<T> lista = new ArrayList<T>();
		int inicio = 1, p = 0;
		boolean intro = false;

		if(!iterador.hasNext())
			return 1;
			
		while(!intro) {
			if(cab != aux){
				lista.add(aux.content);
				aux = aux.next;
			}
			if(cab == aux)
				intro = true; 
		}
		
		while(intro) {
			
			if(!iterador.hasNext())
				return inicio;
			if(lista.get(p) != iterador.next()) {
				p = 0;
				inicio++;
				if(lista.size() == 1)
					intro = false;
				else
					lista.remove(p);
				
				iterador = numPart.iterator();
			}else {
				p++;
			} 
		}
		
		return -1;
	}

	@Override
	public void interlace(DoubleLinkedList<T> other) {
		DoubleNode<T> aux = cab.next;
		Iterator<T> iterador = other.iterator();
		ArrayList<T> lista = new ArrayList<T>();
		boolean intro = false;
		
		while(!intro) {
			if(cab != aux){
				lista.add(aux.content);
				aux = aux.next;
			}
			if(iterador.hasNext()) {
				lista.add(iterador.next());
			}
			if(cab == aux && !iterador.hasNext())
				intro = true;
		}
		cab.next = cab;
		cab.previous = cab;
		
		for(int i=lista.size()-1; i>=0; i--) {
			addFirst(lista.get(i));
		}
	}	
	
	@Override
	public String toString() {
		
		if (cab != cab.next) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			DoubleNode<T> i = cab.next;
			while (i != cab) {
				rx.append(i.content);
				rx.append(", ");
				i = i.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			
			return rx.toString();
		} else {
			return "[]";
		}
	}

	
	@Override
	public Iterator<T> oddAndEvenIterator() {
		return new OddAndEvenIterator();
	}

	 @Override
		public Iterator<T> iterator() {
	    	return new ForwardIterator();
		}

		@Override
		public Iterator<T> reverseIterator() {
			return new ReverseIterator();
		}

}
