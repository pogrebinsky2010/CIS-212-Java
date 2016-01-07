
public class Sphere extends Circle {
	private double area;

	public Sphere(double r) {
		super(r);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea()
	{
		area = 4 * Math.PI * Math.pow(radius, 2);
		return area;
	}
	

}
