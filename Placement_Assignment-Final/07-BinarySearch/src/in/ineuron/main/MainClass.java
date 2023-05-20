package in.ineuron.main;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        // create a sorted array of integers
	        int[] arr = {2, 9, 8, 12, 16, 23, 38, 56, 88, 91};

	        System.out.println("Enter value to search : ");
	        int target = scanner.nextInt();

	        int result = binarySearch(arr, target);

	        if (result == -1) {
	            System.out.println("Value not found in the array");
	        } else {
	            System.out.println("Value found at index " + result);
	        }
	}
	
	public static int binarySearch(int[] arr, int target) {
	    int left = 0;
	    int right = arr.length - 1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;

	        if (arr[mid] == target) {
	            return mid;
	        } else if (arr[mid] < target) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }

	    return -1;
	}
}


