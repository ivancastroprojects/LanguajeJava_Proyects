package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import ule.edi.limitedpriorityqueue.LinkedQueue.Node;


public class LimitedPriorityQueueArrayImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;
	    private int npriorities;
	    private int count;

	    private ArrayList<LinkedQueue<T>> tails = new ArrayList<LinkedQueue<T>>();
	
	

	public LimitedPriorityQueueArrayImpl(int capacity, int npriorities) {
		this.capacity = capacity;
		this.npriorities = npriorities;
		for(int i = 0; i < npriorities; i++) {
			LinkedQueue<T> tail = new LinkedQueue<T>();
			tails.add(tail);
		}
	}
	



    @Override
    public int getCapacity() {
		return capacity;
    }

    @Override
    public int getSize() {
    	count = 0;
    	for(int i=0; i<tails.size(); i++) {
			count += tails.get(i).size();
    	}
    	return count;
    }

    @Override
    public boolean isFull() {
		if(capacity == getSize()) 
    		return true;
    	return false;
    }

	@Override
	public T enqueue(int p, T element) {
		int prio = 1;
		int prioMin = 0;
		T select = null;
		
		if(p<=0 || p>npriorities)
			throw new IllegalArgumentException("Error. La prioridad está fuera del rango posible.");
		if(element == null)
			throw new NullPointerException("Error. El elemento es null.");
		
		for(int i=0; i<npriorities; i++) {
			if(!tails.get(i).isEmpty())
				prioMin = i+1;
		}
		
		for(int i=0; i<npriorities; i++) {
			if(prio == p) {
				if(capacity > this.getSize()) {
					tails.get(i).enqueue(element);
					return null;
				}else {
					for(int j=npriorities-1; j>=0 ; j--) {
						if(!tails.get(j).isEmpty()) {
							try {
								if(prioMin <= p) {
									return element;
								}else {
									select = tails.get(j).dequeueLast();
									enqueue(p, element);
									return select;
								}
							
							} catch (EmptyCollectionException e) {	//Si está vacía
								e.printStackTrace();
							}
						}
					}
				}
			}
			prio++;
		}
		return element;
	}


	@Override
	public T first() throws EmptyCollectionException {
		if(isEmpty())
			throw new EmptyCollectionException("");
		for(int j = 0; j < npriorities ; j++) {
			if(!tails.get(j).isEmpty()) {
				return tails.get(j).first();
			}
		}
      return null;
	}



	@Override
	public T dequeue() throws EmptyCollectionException {
		T aux = null;
		if(isEmpty())
			throw new EmptyCollectionException("");
		for(int j = 0; j < npriorities; j++) {
			if(!tails.get(j).isEmpty()) {
				aux = tails.get(j).first();
				tails.get(j).dequeue();
				return aux;
			}
		}
		return aux;
	}

	@Override
	public boolean isEmpty() {
		if(getSize() == 0)
			return true;
		return false;
	}

	
	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			for (int n = 0; n < this.npriorities; n++) {
				rx.append("( Priority:"+(n+1)+" (");
				rx.append(tails.get(n).toString());
				rx.append(")), ");
			}
			rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}

};
  

