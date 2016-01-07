
public class Box extends Rectangle  {
	private double height, area;
	
	public Box(double l, double w, double h) {
		super(l, w);
		height = h;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea()
	{
		area =(length * width)* 2  + (height * width) * 2 + (length * height* 2);
		return area;
	}
}

