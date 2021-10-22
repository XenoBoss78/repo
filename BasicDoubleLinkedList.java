package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import application.DoubleLinkedListDriver.StringComparator;

public class BasicDoubleLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T>{
	Node<T> headNode = null;
	Node<T> tailNode = null;
	int size = 0;
	
	public class ArrayListIterator<T> implements ListIterator<T>{
		Node<T> currentNode;
		
		public ArrayListIterator(BasicDoubleLinkedList<T> list)
	    {
	        currentNode = list.headNode;
	    }
		
		@Override
		public boolean hasNext() {
			return currentNode.getNext() != null;
		}

		@Override
		public T next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			currentNode = currentNode.getNext();
			return (T) currentNode.getData();
		}
		
		public T getNextLink() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			currentNode = currentNode.getNext();
			return (T) currentNode;
		}
		
		@Override
		public boolean hasPrevious() {
			return currentNode.getPrev() != null;
		}

		@Override
		public T previous() throws NoSuchElementException {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			currentNode = currentNode.getPrev();
			return (T) currentNode.getData();
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}

	public int getSize() {
		return size;
	}
	
	public  BasicDoubleLinkedList<T> addToFront(T newElement) {
			size++;
			Node<T>  newNode = new Node<T>(newElement, null, headNode);
			if (headNode != null) {
				headNode.setPrev(newNode);
			}
			headNode = newNode;
			if (size == 1) {
				tailNode = newNode;
			} 
			return this;
	}
	
	public  BasicDoubleLinkedList<T> addToEnd(T newElement) {
		size++;
		Node<T>  newNode = new Node<T>(newElement, tailNode, null);
		if (tailNode != null) {
			tailNode.setNext(newNode);
		}
		tailNode = newNode;
		if (size == 1) {
			headNode = newNode;
		}
		return this;
	}

	public ArrayList<T> toArrayList() {
		ArrayList<String> List = new ArrayList<String>(size + 1);
		
		ArrayListIterator<T> iterate = iterator();
		if(size == 1) {
			List.add((String) headNode.getData());
		
		} else if (size != 0){
			List.add((String) headNode.getData());
			
			while ((iterate.hasNext())) {
				T current = (T) iterate.next();
				List.add((String) current);
			}
			
		}
		return (ArrayList<T>) List;
	}

	public T retrieveFirstElement() {
		Node<T> temp = headNode;
		if (size != 1) {
			temp.getNext().setPrev(null);
		}
		headNode = temp.getNext();
		size--;
		if (size == 0) {
			tailNode = null;
		}
		return temp.getData();
	}

	public T retrieveLastElement() {
		Node<T> temp = tailNode;
		if (size != 1) {
			temp.getPrev().setNext(null);
		}
		tailNode = temp.getPrev();
		size--;
		if (size == 0) {
			headNode = null;
		}
		return temp.getData();
	}

	public T getLast() {
		return tailNode.getData();
	}

	public T getFirst() {
		return headNode.getData();
	}

	public void remove(T newElement, java.util.Comparator<T> sComp) {
		ArrayListIterator<T> iterate = iterator();
		while (iterate.hasNext()) {
			
			Node<T> current = (Node<T>) iterate.getNextLink();
			
			if (sComp.compare(newElement,current.getData()) == 0) {
			
				if (iterate.hasPrevious()) {
					Node<T> temp1 = current.getPrev();
					current.getNext().setPrev(temp1);
				} else {
					headNode = current.getNext();
				}
				
				if (iterate.hasNext()) {
					Node<T> temp2 = current.getNext();
					current.getPrev().setNext(temp2);
				} else {
					tailNode = current.getPrev();
				}
				break;
			}
		}
		size--;
	}

	@Override
	public ArrayListIterator<T> iterator() {
        return new ArrayListIterator<T>(this);
	}

}
