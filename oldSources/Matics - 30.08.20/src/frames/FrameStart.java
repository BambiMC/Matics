package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.pushingpixels.substance.api.skin.SubstanceGraphiteChalkLookAndFeel;


public class FrameStart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel(new SubstanceGraphiteChalkLookAndFeel());
					FrameStart frame = new FrameStart();
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
	public FrameStart() {
		
		//Nur kommentiert, damit Error weg ist 220820
		//String[] lang = LangMaster.master(0);
		String lang[] = new String[20];
		
		//Möglichkeit um im WindowBuilder zu testen
		//LanguageInterface language = new EN();
		//lang = language.FrameStart();
		
		//contentPane.setBackground(new Color(0,0,0));
		
		setTitle(lang[0]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 270);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(32,32,32));
		//contentPane.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelchesFach = new JLabel(lang[0]);
		lblWelchesFach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnMathematik = new JButton(lang[1]);
		btnMathematik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//FrameMathematik frameMathematik = new FrameMathematik();
				//frameMathematik.setVisible(true); 
				
				
				//Nur kommentiert, damit Error weg ist 220820
				//contentPane = FrameTemplate.getPanel();
				contentPane.revalidate();
				contentPane.setVisible(true);
				System.out.println("asdfohi");
				
				
			}
		});
		//btnMathematik.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnChemie = new JButton(lang[2]);
		btnChemie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameChemie frameChemie = new FrameChemie();
				frameChemie.setVisible(true);
				
			}
		});
		btnChemie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnPhysik = new JButton(lang[3]);
		btnPhysik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				FramePhysik framePhysik = new FramePhysik();
				framePhysik.setVisible(true);
				
			}
		});
		btnPhysik.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnMoreComingSoon = new JButton(lang[4]);
		btnMoreComingSoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Dieser schöne kleine Knopf wird bald durch etwas viel besseres ersetzt :D\nDu kannst gespannt sein!");
				FrameInformatikSkripten frameInformatikSkripten = new FrameInformatikSkripten();
				frameInformatikSkripten.setVisible(true);
			}
		});
		btnMoreComingSoon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton(lang[5]);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameDeutsch frameDeutsch = new FrameDeutsch();
				frameDeutsch.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton_1 = new JButton(lang[6]);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameSupport frameSupport = new FrameSupport();
				frameSupport.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnChemie, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(btnPhysik, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(btnMathematik, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnMoreComingSoon, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(115, Short.MAX_VALUE)
					.addComponent(lblWelchesFach, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblWelchesFach, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMathematik, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnMoreComingSoon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnChemie, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPhysik, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
