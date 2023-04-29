package xSort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algorithms.Algs;

import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Display extends JFrame {

	private JPanel contentPane;
	Random rand = new Random();
	static int NumberArray[];
	static Color ColorArray[];
	static Display frame;
	static int graphX, graphY;
	String algorithm;
	int timeDelay;
	
	
	//objects
	Foundations foundations;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new Display();
					frame.setVisible(true);
					frame.setSize(new Dimension(2000, 800));
					
					Input inp = new Input(frame);
					inp.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				frame.newSetup(15, 500, 100, 10, "InsertionSort");

				
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

	}
	
	
	/**
	 * Draw
	 */
	
	public void paint(Graphics g) {
		
		
		BufferedImage  bf = new BufferedImage( this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		
        animation(bf.getGraphics()); //BufferedImage object
        g.drawImage(bf,0,0,null);
		
		
		
		}
		
		
	
	private void animation(Graphics g) {
		
		super.paint(g);

		
		
		
		Dimension d = getContentPane().getSize();
		
		
		
		
		int x = 0;
		int y = 0;
		int width = graphX;
		int height = 0;
		
		for (int i = 0; i < NumberArray.length; i++) {
			
		height = NumberArray[i];
		x = x + width;
		y = d.height - height +31;


		g.setColor(ColorArray[i]);
		g.fillRect(x, y, width, height);
		
		
	}
	
	
}
	

public void newSetup(int newGraphX, int newGraphY, int newPolygons, int newTimeDelay, String newAlgorithm) {
	
	
	graphX = newGraphX;
	graphY = newGraphY;
	
	timeDelay = newTimeDelay;
	algorithm = newAlgorithm;
	
	//Create New Setup
	
	foundations = new Foundations(newPolygons, graphY);
	
	NumberArray = foundations.CreateNumberArray();
	ColorArray = foundations.CreateColorArray();
	
	frame.repaint();
	
	
}

public int Start() {
	

	
	
	long startTime = System.nanoTime();
	long elapsedTime = 0;

	
		
		
		
		//Algorithm call
	Thread separateAlgorithmThread = new Thread(new Algs(NumberArray, ColorArray, frame, timeDelay));
	separateAlgorithmThread.start();
		//Algs.InsertionSort(NumberArray, ColorArray, frame);

		
	    elapsedTime = (System.nanoTime() - startTime)/1000;
	    
	    
	System.out.println(elapsedTime);
	
	
	return (int) elapsedTime;

	
	
	
}





}
