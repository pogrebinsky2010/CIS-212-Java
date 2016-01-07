import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	public static void main(String[] args)
	{
		int rectangleCount = 0;
		int sphereCount = 0;
		int boxCount = 0;
		int circleCount = 0;
		
		
		ArrayList<Measurable>shapes = new ArrayList<Measurable>();
	
		
		for(int i = 0; i < 1000; i++)
		{
			double randomDouble = nextDouble();
			if(randomDouble <= 1 && randomDouble >.75)
			{
				Rectangle shape = new Rectangle(nextDouble(), nextDouble());
				shapes.add(i, shape);
				rectangleCount += 1;
				
				
			}
			else if(randomDouble <= .75 && randomDouble > .50)
			{
				Circle shape = new Circle(nextDouble());
				shapes.add(shape);
				circleCount += 1;
				
			}
			else if(randomDouble <= .50 && randomDouble > .25)
			{
				Sphere shape = new Sphere(nextDouble());
				shapes.add(shape);
				sphereCount += 1;
			}
			else
			{
				Box shape = new Box(nextDouble(), nextDouble(), nextDouble() );
				shapes.add(shape);
				boxCount += 1;
			}
		}
		double sumOfAreas = getSumOfAreas(shapes);
		System.out.println("the total of the areas is : " + sumOfAreas + " and the breakdown"
				+ " of the sums come from as follows: ");
		System.out.println(" boxes: " + boxCount + " circles: " + circleCount + " rectangles: " + rectangleCount + " and spheres: "
				+ sphereCount);
				
				

	}
	private static double nextDouble()
	{
		double randomDouble = new Random().nextDouble();
				if( randomDouble == 0)
				{
					 randomDouble = 1;
				}
				return randomDouble;
	}
	public static double getSumOfAreas(ArrayList<Measurable>arrayList)
	{
		double arraySum=0;
		for(int i = 0; i < arrayList.size(); i++)
		{	
			double area = arrayList.get(i).getArea();
			arraySum += area;
		}
		
		return arraySum;
	}
}
