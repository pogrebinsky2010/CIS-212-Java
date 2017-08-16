package hw5;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI{
	public static void makeGui(int dimension1, int dimension2)
	{
		final JFrame f;
		final JPanel p;
		final JButton mergeButton, selectionButton;
		JTextField mergeLabel;
	    JTextField selectionLabel;
		
	    mergeLabel = new JTextField(15);
		selectionLabel  = new JTextField(15);
		f = new JFrame("test sorting algorithms");
		f.setSize(dimension1, dimension2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel(new GridBagLayout());
		p.setBackground(Color.GRAY);
		
		GridBagConstraints c = new GridBagConstraints();
		
		selectionButton = new JButton("Test select. sort time ");
		selectionButton.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e){
				
				
				if(reader.isSorted(reader.selectionSort(reader.readFile()))){
					
				selectionLabel.setText("time: " + reader.getSelectionNanoTime()/1000000000 + " Seconds");
				}
				else{
				selectionLabel.setText("error (array not sorted)!");
				}
			}
		});
		
		mergeButton = new JButton("Test merge sort time ");
		mergeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(reader.isSorted(reader.mergeSort(reader.readFile()))){
					mergeLabel.setText("time: " + reader.getMergeNanoTime()/1000000000 + " Seconds");
					}
					else{
						mergeLabel.setText("error (array not sorted)!");
					}
						
			}
		});
		
		
		
		c.insets = new Insets(10,10,10,10);//spacing between buttons
		c.gridx = 0;
		c.gridy = 1;
		p.add(selectionButton,c);
		c.gridx = 1;
		c.gridy = 1;
		p.add(selectionLabel, c);
		c.gridx = 0;
		c.gridy = 2;
		p.add(mergeButton, c);
		c.gridx = 1;
		c.gridy = 2;
		p.add(mergeLabel, c);
		f.setVisible(true);
		f.add(p);

	}

}
