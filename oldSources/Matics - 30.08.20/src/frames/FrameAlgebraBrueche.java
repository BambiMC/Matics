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

public class FrameAlgebraBrueche extends JFrame {

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
					FrameAlgebraBrueche frame = new FrameAlgebraBrueche();
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
	public FrameAlgebraBrueche() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBrche = new JLabel("Br\u00FCche");
		lblBrche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnKrzenErweitern = new JButton("K\u00FCrzen / Erweitern");
		btnKrzenErweitern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameAlgebraBruecheKürzenErweitern frameAlgebraBruecheKürzenErweitern = new FrameAlgebraBruecheKürzenErweitern();
				frameAlgebraBruecheKürzenErweitern.setVisible(true);
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
							.addGap(95)
							.addComponent(lblBrche))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnKrzenErweitern)))
					.addContainerGap(281, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBrche)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnKrzenErweitern)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
