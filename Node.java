package application;

public class Node<T> {
	Node<T> prev, next;
	T data;
	
	public Node(T dataStored, Node<T> Previous, Node<T> Forward) {
		this.data = dataStored;
		this.prev = Previous;
		this.next = Forward;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public String toString() {
		return (String) data;
	}
}
