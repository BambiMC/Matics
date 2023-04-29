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

public class FrameBinomischeFormel extends JFrame {

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
					FrameBinomischeFormel frame = new FrameBinomischeFormel();
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
	public FrameBinomischeFormel() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMitOderOhne = new JLabel("Mit oder ohne X?");
		lblMitOderOhne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnMitX = new JButton("Mit X");
		btnMitX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameBinomischeFormelZweiInput frameBinomischeFormelZweiInput = new FrameBinomischeFormelZweiInput();
				frameBinomischeFormelZweiInput.setVisible(true); 
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnOhneX = new JButton("Ohne X");
		btnOhneX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FrameBinomischeFormelohnex frameBinomischeFormelohnex = new FrameBinomischeFormelohnex();
			frameBinomischeFormelohnex.setVisible(true);
			setVisible(false);
			dispose();
			}
		});
		
		JButton btnMitXUnd = new JButton("MIt X und Y");
		btnMitXUnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			FrameBinomischeFormelDreiInput frameBinomischeFormelDreiInput = new FrameBinomischeFormelDreiInput();
			frameBinomischeFormelDreiInput.setVisible(true);
			setVisible(false);
			dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnOhneX, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnMitX, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnMitXUnd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(lblMitOderOhne)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblMitOderOhne)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOhneX, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
						.addComponent(btnMitX, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMitXUnd, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(379))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
