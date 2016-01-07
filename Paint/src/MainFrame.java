import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private final PaintPanel _paintPanel;
	private final JButton _circleButton;
	private final JButton _squareButton;
	private final JButton _colorButton;
	private final JButton _clearButton;
	private final JButton _penButton;
	private final JButton _markerButton;
	private final JButton _mediumButton;
	private final JButton _resize;
	
	public MainFrame() {
		super("Paint Panel!!!!");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Use BorderLayout so that the panel is stretched to fill the window.
		setLayout(new BorderLayout());
		
		_paintPanel = new PaintPanel();
		add(_paintPanel, BorderLayout.CENTER);

		_circleButton = new JButton("Circle!");
		_circleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setShape(PaintPoint.Shape.CIRCLE);
			}			
		});
		
		_squareButton = new JButton("Square!");
		_squareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setShape(PaintPoint.Shape.SQUARE);
			}			
		});
	
		_clearButton = new JButton("Clear");
		_clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			_paintPanel.clearPanel();
			}			
		});
		_penButton = new JButton("Pen");
		_penButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentColor(Color.BLACK);
			    _paintPanel.sizePen(7);
			}			
		});
		_markerButton = new JButton("Marker");
		_markerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentColor(Color.BLUE);
			    _paintPanel.sizePen(50);
			}			
		});
		_resize = new JButton("resize");
		_markerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				_paintPanel.sizePen(5);
				}
				
				
					
						
		});
		
		
			_mediumButton = new JButton("Medium");
			_mediumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentColor(Color.RED);
			    _paintPanel.sizePen(120);
			}			
		});

		JPanel shapeButtonPanel = new JPanel(new GridLayout(1, 2));
		shapeButtonPanel.add(_circleButton);
		shapeButtonPanel.add(_squareButton);
		shapeButtonPanel.add(_clearButton);
		shapeButtonPanel.add(_penButton);
		shapeButtonPanel.add(_markerButton);
		shapeButtonPanel.add(_mediumButton);
		shapeButtonPanel.add(_resize);
		
		_colorButton = new JButton("Change Color!");
		_colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Use MainFrame.this because this is a reference to the enclosing
				// ActionListener instance.
				Color color = JColorChooser.showDialog(MainFrame.this, "Choose a color!",
						PaintPanel.DEFAULT_COLOR);
				
				// A user cancel from JColorChooser returns null.
				if (color != null) {
					_paintPanel.setCurrentColor(color);
				}}	});	
		JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
		buttonPanel.add(shapeButtonPanel);
		buttonPanel.add(_colorButton);

		add(buttonPanel, BorderLayout.SOUTH);
		setSize(600, 600);
	}
}