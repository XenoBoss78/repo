package gradebook;

public class ArraySum {
	public ArraySum() {
		
	}
	
	public int sumOfArray(Integer[] myArray, int i) {
		
		if (i == 0) {
			return myArray[i];
		} else {
			return myArray[i] + sumOfArray(myArray,i-1);
		}
	}
	
}
