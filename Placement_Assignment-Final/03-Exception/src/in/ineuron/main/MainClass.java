package in.ineuron.main;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		try {
		System.out.println("Enter A Positive No : ");
		int number=sc.nextInt();
		if(number < 0) {
			throw new Exception("Negative Number Exception");
		}
		System.out.println("your number is : "+number);
		}	
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
