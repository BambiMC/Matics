package oldStuff;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class FrameStartCopySAVE extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private static String[] lang;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					//get Array from settingsFile
					FileUsefulMethods fsm = new FileUsefulMethods();
					String[] settings = fsm.master();
					
					
					//WindowsTitleBar-Einstellung
					if(settings[13] == "windows") {
						JFrame.setDefaultLookAndFeelDecorated(false);
					} else {
						JFrame.setDefaultLookAndFeelDecorated(true);
					}
					
					//Theme-Einstellung
					
					LookAndFeel selected = ThemeMaster.getTheme(settings[12]);
					
					if(selected != null) {
						UIManager.setLookAndFeel(selected);
					} else {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					
					*/
					//Sprachen-Einstellung
					//lang = LangMaster.master(0);
					
					
					
					
					FrameStartCopySAVE frame = new FrameStartCopySAVE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameStartCopySAVE() {
		
		
		
		

		

		
		//setBounds and position of JFrame
		//to be determined
		int x = 300;
		int y = 400;
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		setBounds(gd.getDisplayMode().getWidth()/2-x/2, gd.getDisplayMode().getHeight()/2-y/2, x, y);
		p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));
		
		
		
		
		
		//Font and styling
		Font myFont = new Font("Segoe UI", Font.PLAIN, 20);
		Font myTitleFont = new Font("Segoe UI", Font.PLAIN, 38);
		
		
		
		setTitle(lang[0]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(p);
	    
		
		
		//Content
		
		JButton buttonHier = new JButton("⬆");
		buttonHier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UP");
				
			}
		});
		buttonHier.setVisible(false);
		p.add(buttonHier, "cell 0 0,width 30!,height 30!,aligny center,gapy 2");
		
		
		JLabel title = new JLabel(lang[0]);
		title.setFont(myTitleFont);
		p.add(title, "cell 1 0 2 1,gapy 0");
		
		
		
		JButton buttonMath = new JButton(lang[1]);
		buttonMath.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		buttonMath.setFont(myFont);
		p.add(buttonMath, "cell 0 1 2 1, width 200!");
		
		
		
		JButton buttonChem = new JButton(lang[2]);
		buttonChem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UP");
				
			}
		});
		buttonChem.setFont(myFont);
		p.add(buttonChem, "cell 0 2 2 1, width 200!");
		
		
		
		JButton buttonPhys = new JButton(lang[3]);
		buttonPhys.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UP");
				
			}
		});
		buttonPhys.setFont(myFont);
		p.add(buttonPhys, "cell 0 3 2 1, width 200!");
		
		
		
		JButton buttonText = new JButton(lang[4]);
		buttonText.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UP");
				
			}
		});
		buttonText.setFont(myFont);
		p.add(buttonText, "cell 0 4 2 1, width 200!");
		
		
		
		JButton buttonInfo = new JButton(lang[5]);
		buttonInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UP");
				
			}
		});
		buttonInfo.setFont(myFont);
		p.add(buttonInfo, "cell 0 5 2 1, width 200!");
		
		
		
		JButton buttonSett = new JButton(lang[6]);
		buttonSett.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "UP");
				
			}
		});
		buttonSett.setFont(myFont);
		p.add(buttonSett, "cell 0 6 2 1, width 200!");
		

		
		
	}
	
	
	
	
	
	
	
	
	
	
}
