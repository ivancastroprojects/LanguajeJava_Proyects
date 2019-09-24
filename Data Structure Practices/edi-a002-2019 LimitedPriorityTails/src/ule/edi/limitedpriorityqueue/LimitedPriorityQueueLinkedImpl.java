 package ule.edi.limitedpriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.text.AbstractDocument.Content;


public class LimitedPriorityQueueLinkedImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;

	    private QueueNode<T> first;
	    private int count;
	

	private static class QueueNode<E> {
	
		public QueueNode(int priority, E content) {
			this.priority = priority;
			this.content = content;
			this.next = null;
		}
		
		
		public int priority;
		
		public E content;
		
		public QueueNode<E> next;
	};
	

	
	public LimitedPriorityQueueLinkedImpl(int capacity) {
		this.capacity = capacity;
   
	}
	
  
    @Override
    public int getCapacity() {
        return capacity;
    }
    
    @Override
    public int getSize() {
    	int aux = 0;
    	QueueNode<T> actual = first;
    
	   while(actual != null) { 
    		   aux++;
    	   actual = actual.next;
	   }
    	
    	return aux;
    }

    @Override
    public boolean isFull() {
    	if(getSize() < getCapacity()) 
    		return false;
    	return true;
    }

	@Override
	public T enqueue(int p, T element) {
		QueueNode<T> actual = first;
		QueueNode<T> minimo = first;
		QueueNode<T> aux = null;
		QueueNode<T> add = new QueueNode<T>(p, element);
		
		int prioMin = 0;
		
		if(p <= 0)
			throw new IllegalArgumentException("Inutil hazlo bien");
		if(element == null)
			throw new NullPointerException("Inutil hazlo bien");
		
		while(minimo != null) {
			if(minimo.next == null)
				prioMin = minimo.priority;
			minimo = minimo.next;
		}
		if(!isFull()) {

			if(isEmpty()) {
				first = add;
				add.next  = null;
				return null;
			}

			if(p < actual.priority) {
				add.next = first;
				first = add;
				return null;
			}
			
			while(actual != null) {
				if(p >= actual.priority && actual.next == null) {
					actual.next = add;
					add = null;
					return null;
				}
				if(p >= actual.priority && p < actual.next.priority) {
					add.next = actual.next;
					actual.next = add;
					return null;
				}
				actual = actual.next;
			}
		}
		if(prioMin <= p) {
			return element;
		}
		actual = first;
		while(actual != null) {
			if(actual.next.next == null) {
				aux = actual.next;
				actual.next = null;
			}
			actual = actual.next;
		}
		enqueue(p, element);
		
		return aux.content;
	}

	@Override
	public T first() throws EmptyCollectionException {
		if(first == null)
			throw new EmptyCollectionException("La cola esta vacia");
		else 
			return first.content;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		QueueNode<T> actual = first;
		QueueNode<T> aux;
		if(first == null)
			throw new EmptyCollectionException("");
		
			aux = actual;
			first = null;
			
		return aux.content;
	}

	@Override
	public boolean isEmpty() {
		if(first == null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		QueueNode<T> actual = first;
		boolean cond = true;
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
		      while(actual !=null) {
		    	  if(cond) {
		    		  rx.append("( Priority:"+(actual.priority)+" (");

		    		  cond = false;
		    	  }
		    	  rx.append(actual.content+", ");

		    	  if(actual.next == null||actual.priority != actual.next.priority) {
		    		  rx.delete(rx.length() - 2, rx.length());
		    		  cond = true;
		    		  rx.append(")), ");
		    	  }
		    	  actual = actual.next;
		      }
		      
		    rx.delete(rx.length() - 2, rx.length());
			rx.append("]");

			return rx.toString();
		} else {
			return "[]";
		}
	}

  
}
