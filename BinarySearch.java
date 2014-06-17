package pr1beta;

public class BinarySearch {
	
	
	public int binarySearch(int [] A, int x) {
		int first = A[0];
		int last = A[A.length-1];

		 while (first <= last) {
	            int middle =first+(( first - last )/2) ; 
	            if ( A[middle] < x) {
	            	first = middle + 1; // rechts weitersuchen
	            } else if (A[middle] > x) {
	            	last = middle - 1; // links weitersuchen
	            } 
	                return middle; // Zeichen gefunden
	            }
	       
	        return -1;

	}
	}