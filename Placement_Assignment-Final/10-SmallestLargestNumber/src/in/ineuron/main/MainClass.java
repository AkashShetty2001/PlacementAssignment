package in.ineuron.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter set of Integer Value seperated by commma : ");
		String setOfInteger=sc.nextLine();
		
		String[] numbers = setOfInteger.split(" ");
		List<Integer> list = new ArrayList<Integer>();
		for(String number : numbers) {
			list.add(Integer.parseInt(number));
		}
		
		//to get the second largest element in the list , first sort the list
		
		Collections.sort(list);
		System.out.println(list);
		System.out.println("Second Largest Element is : "+list.get(list.size()-2));
		System.out.println("Second Smallest Element is : "+list.get(1));
		
		
	}

}
