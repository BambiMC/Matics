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
import javax.swing.border.EmptyBorder;

public class FrameChemie extends JFrame {

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
					FrameChemie frame = new FrameChemie();
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
	public FrameChemie() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblChemie = new JLabel("Chemie");
		lblChemie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnSalze = new JButton("PSE");
		btnSalze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameChemiePSE frameChemiePSE = new FrameChemiePSE();
				frameChemiePSE.setVisible(true);
				
				setVisible(false);
				dispose();
				
			}
		});
		
		JButton btnSalze_1 = new JButton("Salze");
		btnSalze_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameChemieSalze frameChemieSalze = new FrameChemieSalze();
				frameChemieSalze.setVisible(true);
				
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnOrganischeChemie = new JButton("Organische Chemie");
		btnOrganischeChemie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameChemieOrganisch frameChemieOrganisch = new FrameChemieOrganisch();
				frameChemieOrganisch.setVisible(true);
				
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnElementeVergleichen = new JButton("Elemente vergleichen");
		btnElementeVergleichen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				FrameChemieElementeVergleichen frameChemieElementeVergleichen = new FrameChemieElementeVergleichen();
				frameChemieElementeVergleichen.setVisible(true);
				
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
							.addGap(157)
							.addComponent(lblChemie))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnOrganischeChemie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnElementeVergleichen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSalze_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSalze, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(219, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChemie)
					.addGap(18)
					.addComponent(btnSalze)
					.addGap(18)
					.addComponent(btnSalze_1)
					.addGap(18)
					.addComponent(btnOrganischeChemie)
					.addGap(18)
					.addComponent(btnElementeVergleichen)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
