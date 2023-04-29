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
import javax.swing.border.EmptyBorder;

public class FrameDeutsch extends JFrame {

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
					FrameDeutsch frame = new FrameDeutsch();
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
	public FrameDeutsch() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDeutsch = new JLabel("Deutsch / Texte");
		lblDeutsch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnTexteVergleichen = new JButton("Texte vergleichen");
		btnTexteVergleichen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameDeutschTexteAnalysieren frameDeutschTexteAnalysieren = new FrameDeutschTexteAnalysieren();
				frameDeutschTexteAnalysieren.setVisible(true);
				
				setVisible(false);
				dispose();
				
			}
		});
		
		JButton btnErsetzen = new JButton("Finden/Ersetzen");
		btnErsetzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameDeutschFindenErsetzen findenErsetzen = new FrameDeutschFindenErsetzen();
				findenErsetzen.setVisible(true);
				setVisible(false);
				dispose();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(135)
							.addComponent(lblDeutsch))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnErsetzen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTexteVergleichen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(163, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeutsch)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnTexteVergleichen)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnErsetzen)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
