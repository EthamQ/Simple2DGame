package raphael.game2d.frame;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Display {
	
	private Canvas canvas = new Canvas();
	
	private JFrame frame;
	private String title = "";
	private int WIDTH, HEIGHT;
	
	
	public Display(String title, int width, int height){
		this.title = title;
		WIDTH = width;
		HEIGHT = height;
		createDisplay();
	
	}
	
	public void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
	
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	public Canvas getCanvas(){
		return this.canvas;
	}
	
	public JFrame getFrame(){
		return this.frame;
	}

}
