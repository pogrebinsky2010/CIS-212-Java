
public class Rectangle implements Measurable {
	
	private double area;
	protected double length;
	protected double width;
	public Rectangle(double l, double w)
	{
		length = l;
		width = w;
	}
	
	@Override
	public double getArea()
	{
		area = length * width;
		return area;
	}
	
}
