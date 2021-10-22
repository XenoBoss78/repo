package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

import application.DoubleLinkedListDriver.StringComparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	Comparator<T> comp;
	
	public SortedDoubleLinkedList(java.util.Comparator<T> sComp) {
		comp = sComp;
		
	}
	
	public  SortedDoubleLinkedList<T> add(T newElement) {
		Node<T> newNode = new Node(newElement, null, null);
		
		if (size == 0) {
			headNode = newNode;
			tailNode = newNode;
		} else {
			
			if (comp.compare(headNode.getData(), newElement) <= 0) {
				newNode.setNext(headNode);
				headNode.setPrev(newNode);
				headNode = newNode;
				
			} else if (comp.compare(tailNode.getData(), newElement) > 0) {
				Node<T> temp = tailNode;
				tailNode = newNode;
				temp.setNext(tailNode);
				tailNode.setPrev(temp);
			} else {
				
				Node<T> current = headNode;
				
				while (comp.compare(current.getData(), newElement) > 0) {
					if (comp.compare((T) current.getNext().getData(), newElement) <= 0) {
						newNode.setNext(current.getNext());
						current.getNext().setPrev(newNode);
						newNode.setPrev(current);
						current.setNext(newNode);
						break;
					}
				}
			}
		}
		size++;
		return this;
	}
	
	public BasicDoubleLinkedList<T> addToFront(T data) throws java.lang.UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	public BasicDoubleLinkedList<T> addToEnd(T data) throws java.lang.UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
