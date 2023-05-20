package in.ineuron.main;

public class MainClass {

	public static void main(String[] args) {
		Shape circle = new Circle(5);
		Shape triangle = new Triangle(4,5,6);
		
		
		
		System.out.println("Area of Circle : "+triangle.calculateArea());
		System.out.println("Parameter of Circle : "+triangle.calculatePerameter());
		System.out.println("----------------------------------------");
		System.out.println("Area of Triangle : "+triangle.calculateArea());
		System.out.println("Parameter of Triangle : "+triangle.calculatePerameter());
		
	}

}
