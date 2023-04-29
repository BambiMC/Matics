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

public class FrameAlgebra extends JFrame {

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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					System.out.println();
					FrameAlgebra frame = new FrameAlgebra();
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
	public FrameAlgebra() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAlgebra = new JLabel("Algebra");
		lblAlgebra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnBinomischeFormeln = new JButton("Binomische Formeln");
		btnBinomischeFormeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameBinomischeFormel frameBinomischeFormel = new FrameBinomischeFormel();
				frameBinomischeFormel.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		JButton btnRechner = new JButton("Rechner");
		btnRechner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			FrameAlgebraRechner frameAlgebraRechner = new FrameAlgebraRechner();
			frameAlgebraRechner.setVisible(true);
			setVisible(false);
			dispose();
			}
		});
		
		JButton btnBrche = new JButton("Br\u00FCche");
		btnBrche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameAlgebraBrueche frameAlgebraBrueche = new FrameAlgebraBrueche();
				frameAlgebraBrueche.setVisible(true);
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
							.addGap(172)
							.addComponent(lblAlgebra))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnBrche, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRechner, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBinomischeFormeln, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(204, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAlgebra)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBinomischeFormeln)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRechner)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBrche)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
