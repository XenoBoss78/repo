package application;

import java.util.EmptyStackException;

public final class ArrayStack<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
	private static final int DEFAULT_CAPACITY = 50;
  
   public ArrayStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public ArrayStack(int initialCapacity)
   {

      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;

  } // end constructor

   
   public void push(T newEntry)
   {
      stack[topIndex + 1] = newEntry;
      topIndex++;
   } // end push
   

   public T pop() {
	   if (topIndex < 0) {
		   throw new EmptyStackException();
	   } else {
		   T item = stack[topIndex];
		   stack[topIndex] = null;
		   topIndex--;
		   return item;
	   }
   }

public T peek() {
	if (topIndex < 0) {
		throw new EmptyStackException();
	} else {
		return stack[topIndex];
	}
}

public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

public void clear() {
	// TODO Auto-generated method stub
	
}

} // end ArrayStack