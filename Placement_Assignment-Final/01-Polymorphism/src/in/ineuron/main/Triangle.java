package in.ineuron.main;

public class Triangle implements Shape {
	
	private double base;
	private double height;
	private double side;

	
	public Triangle(double base, double height, double side) {
		this.base = base;
		this.height = height;
		this.side = side;
	}

	@Override
	public double calculateArea() {
		
		return 1/2 *base * height ;
	}

	@Override
	public double calculatePerameter() {
		
		return side+base+height;
	}

}
