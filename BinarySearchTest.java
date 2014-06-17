package pr1beta;

import java.util.Arrays;

public class BinarySearchTest {
		 
		   public static void main(String[] args) {

		    // initializing unsorted int array
		    int A[] = {30,20,5,12,55};
		    BinarySearch bs = new BinarySearch();

		    // sorting array
		    Arrays.sort(A);

		    // let us print all the elements available in list
		    System.out.println("The sorted int array is:");
		    for (int number : A) {
		      System.out.println("Number = " + number);
		    }

		    // entering the value to be searched
		    int x = 12;

		    int index = bs.binarySearch(A,x);
			
		    System.out.println("The index of element 12 is : " + index);
		  }
		
}
