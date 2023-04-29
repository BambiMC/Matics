package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class FrameAlgebraBruecheKürzenErweitern extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFzaehler1;
	private JTextField TFnenner1;
	private JTextField TFswitcher;
	private JTextField TFzaehler2;
	private JTextField TFnenner2;
	DecimalFormat f = new DecimalFormat("###");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAlgebraBruecheKürzenErweitern frame = new FrameAlgebraBruecheKürzenErweitern();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameAlgebraBruecheKürzenErweitern() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBrcheKrzenerweitern = new JLabel("Br\u00FCche k\u00FCrzen/erweitern ");
		lblBrcheKrzenerweitern.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TFzaehler1 = new JTextField();
		TFzaehler1.setColumns(10);
		
		JLabel label = new JLabel("______________");
		
		TFnenner1 = new JTextField();
		TFnenner1.setColumns(10);
		
		JLabel label_1 = new JLabel("=>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"*", "/"}));
		
		JLabel label_2 = new JLabel("=>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		TFswitcher = new JTextField();
		TFswitcher.setColumns(10);
		
		TFzaehler2 = new JTextField();
		TFzaehler2.setColumns(10);
		
		JLabel label_3 = new JLabel("______________");
		
		TFnenner2 = new JTextField();
		TFnenner2.setColumns(10);
		
		JButton btnUmrechnen = new JButton("Umrechnen");
		btnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double zaehler1, nenner1, multiplikator, NEWzaehler, NEWnenner;
				zaehler1 = Double.parseDouble(TFzaehler1.getText());
				nenner1 = Double.parseDouble(TFnenner1.getText());
				multiplikator = Double.parseDouble(TFswitcher.getText());
				String sign = (String) comboBox.getSelectedItem();
				switch (sign) {
				case "*": {
					NEWzaehler = multiplikator * zaehler1;
					NEWnenner = multiplikator * nenner1;
					f.format(NEWzaehler);
					f.format(NEWnenner);
					TFzaehler2.setText(Double.toString(NEWzaehler));
					TFnenner2.setText(Double.toString(NEWnenner));
					break;
				}
				case "/": {
					NEWzaehler = zaehler1/multiplikator;
					NEWnenner = nenner1/multiplikator;
					f.format(NEWzaehler);
					f.format(NEWnenner);
					TFzaehler2.setText(Double.toString(NEWzaehler));
					TFnenner2.setText(Double.toString(NEWnenner));
					break;					
				}
				}
				
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBrcheKrzenerweitern)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(TFzaehler1, Alignment.LEADING))
									.addGap(18)
									.addComponent(label_1))
								.addComponent(TFnenner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(TFswitcher, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnUmrechnen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(4)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(TFzaehler2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFnenner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBrcheKrzenerweitern)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFzaehler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFzaehler2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(TFnenner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFswitcher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUmrechnen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addGap(18)
							.addComponent(TFnenner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(117))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
