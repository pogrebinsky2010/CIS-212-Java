
public class Circle implements Measurable{
	private double area;
	protected double radius;
	
	public Circle(double r)
	{
		radius = r;
	}
	@Override
	public double getArea()
	{
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}
	

}
