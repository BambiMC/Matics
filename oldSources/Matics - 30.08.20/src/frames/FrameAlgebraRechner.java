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

public class FrameAlgebraRechner extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TF_1;
	private JTextField TF_2;
	private JTextField TF_ergebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAlgebraRechner frame = new FrameAlgebraRechner();
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
	public FrameAlgebraRechner() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRechner = new JLabel("Mini-Rechner");
		//Steht auf der Liste der verbesserungsbedürftigen Dinge
		lblRechner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		TF_1 = new JTextField();
		TF_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "*", "/"}));
		
		JLabel label = new JLabel("=");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnAusrechnen = new JButton("Ausrechnen");
		btnAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double Zahl_eins = Double.parseDouble(TF_1.getText());
				double Zahl_zwei = Double.parseDouble(TF_2.getText());
				String Rechenzeichen = (String) comboBox.getSelectedItem();
				double Ausgabe = 0;
				DecimalFormat f = new DecimalFormat("######.#####");
				String FormattedAusgabe;
				
				switch (Rechenzeichen) {
				case "+":{
					Ausgabe = Zahl_eins + Zahl_zwei;
					FormattedAusgabe = f.format(Ausgabe);
					TF_ergebnis.setText(FormattedAusgabe);
				break;	
				}
				case "-":{
					Ausgabe = Zahl_eins - Zahl_zwei;
					FormattedAusgabe = f.format(Ausgabe);
					TF_ergebnis.setText(FormattedAusgabe);	
				break;	
				}
				case "*":{
					Ausgabe = Zahl_eins * Zahl_zwei;
					FormattedAusgabe = f.format(Ausgabe);
					TF_ergebnis.setText(FormattedAusgabe);
				break;	
				}
				case "/":{
					Ausgabe = Zahl_eins / Zahl_zwei;
					FormattedAusgabe = f.format(Ausgabe);
					TF_ergebnis.setText(FormattedAusgabe);
				break;	
				}

				default:
					break;
				}
				
				
				
			}
		});
		
		TF_2 = new JTextField();
		TF_2.setColumns(10);
			
		TF_ergebnis = new JTextField();
		TF_ergebnis.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(TF_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TF_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnAusrechnen, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TF_ergebnis, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(199)
							.addComponent(lblRechner)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRechner)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(TF_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAusrechnen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(TF_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(TF_ergebnis, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
