import java.awt.Color;

public class PaintPoint {
	public enum Shape {
		CIRCLE,
		SQUARE
	}
	private final int pointSize;
	
	
	private final int _x;
	private final int _y;
	private final Shape _shape;
	private final Color _color;

	public PaintPoint(int x, int y, Shape shape, Color color, int size) {
		_x = x;
		_y = y;
		_shape = shape;
		_color = color;
		pointSize = size;
	}
	public int getSize()
	{
		return pointSize;
	}
	
	public int getX() {
		return _x;		
	}
	
	public int getY() {
		return _y;
	}
	
	public Shape getShape() {
		return _shape;
	}
	
	public Color getColor() {
		return _color;
	}
	
}
