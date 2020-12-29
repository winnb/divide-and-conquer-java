import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		// Question 1) Square Root function
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Hello, welcome to CECS 328 Programming Assignment 2 by Brandon Winn.\nQuestion 1) Let's calculate the square root of an integer using a divide and conquer method.\nEnter -1 to quit whenever you want.");
		int n = -2;
		while (n != -1) {
			System.out.println("Enter an integer: ");
			n = keyboard.nextInt(); // User chooses n
			if (n < -1)
				System.out.println("Undefined\nPlease enter a bigger number next time.");
			else if (n == -1)
				System.out.println("Goodbye!");
			else
				System.out.println(squareRoot(n));		
		}
		System.out.println("Question 2) Let's find the smallest missing number in a sorted array using a divide and conquer method.\nEnter m: ");
		int m = keyboard.nextInt();
		int[] a = {0,1,3,6,8,9}; // Here is a!
		System.out.println(smallestMissing(a, m));
		keyboard.close();
	}
	
	private static int squareRoot(int n) {
		if (n==0 || n==1) // Base case
			return n;
		int low = 1; // Start from low
		int high = n; // And Start from high
		int middle = 0;
		while (low <= high) { // Continue until you meet in middle
			middle = (low+high)/2;
			if (middle*middle == n) // Middle equals square root, so return
				return middle;
			else if (middle*middle < n) // Middle is too small to be square root, so try bigger number
				low = middle+1;
			else // Middle is too big to be square root, so try smaller number
				high = high-1;
		}
		return middle;
	}
	
	private static int smallestMissing(int[] a, int m) {
		int low = 0;
		int high = a.length-1;
		while (low <= high) {
			if (a[low] == low)
				low++;
			else
				return low;
			if (a[high] == high)
				high--;
		}
		return a.length;
	}
}

