import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	public static final Color DEFAULT_COLOR = Color.YELLOW;
	
	
	
	private static int POINT_SIZE = 50; 
	
	 ArrayList<PaintPoint> _points;
	
	private PaintPoint.Shape _currentShape;
	private Color _currentColor;
	public void sizePen(int size)
	{
		POINT_SIZE = size;
	}
	public void clearPanel()
	{
		_points = new ArrayList<>();
		repaint();
				
	}
	public PaintPanel() {
		_points = new ArrayList<>();
		_currentShape = PaintPoint.Shape.CIRCLE;
		_currentColor = DEFAULT_COLOR;
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent ev) {
				_points.add(new PaintPoint(ev.getX(), ev.getY(),
						_currentShape, _currentColor, POINT_SIZE));
				repaint();
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int halfPointSize = POINT_SIZE / 2;
		for (PaintPoint p : _points) {
			g.setColor(p.getColor());
			switch (p.getShape()) {
			case CIRCLE:
				g.fillOval(p.getX() - halfPointSize, p.getY() - halfPointSize,
						p.getSize(), p.getSize());	
				break;
			case SQUARE:
				g.fillRect(p.getX() - halfPointSize, p.getY() - halfPointSize,
						p.getSize(), p.getSize());	
				break;
			}
		}		
	}
	
	public void setShape(PaintPoint.Shape shape) {
		_currentShape = shape;
	}

	public void setCurrentColor(Color color) {
		_currentColor = color;
	}
}