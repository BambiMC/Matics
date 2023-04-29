package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class FrameChemieOrganischKWbilden extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField TF_doppelBindungen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemieOrganischKWbilden frame = new FrameChemieOrganischKWbilden();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrameChemieOrganischKWbilden() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblKohlenwasserstoffeBilden = new JLabel("Unverzweigte Kohlenwasserstoffe bilden");
		lblKohlenwasserstoffeBilden.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Alkan", "Alken", "Alkin"}));
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblEineEingabe = new JLabel("Eine Eingabe gen\u00FCgt, die andere wird automatisch erg\u00E4nzt!");
		lblEineEingabe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnErgnzen = new JButton("Erg\u00E4nzen");
		btnErgnzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Ausgabe = 0;
				String ComboBoxItem = (String) comboBox.getSelectedItem();
				String CeingabeString, HeingabeString;
				int Ceingabe = 999, Heingabe = 999;
				CeingabeString = textField.getText();
				HeingabeString = textField_1.getText();
				int Doppel = Integer.parseInt(TF_doppelBindungen.getText());
				
				//System.out.println(CeingabeString + "   " + HeingabeString);
				//System.out.println("1Ceingabe: " + Ceingabe + "    Heingabe: " + Heingabe);
				//System.out.println("1CeingabeString: " + CeingabeString + "    HeingabeString: " + HeingabeString);

				if(CeingabeString.isEmpty() == false) {
					Ceingabe = Integer.parseInt(CeingabeString);
				} else Ceingabe = 999;
				
				if(HeingabeString.isEmpty() == false) {
					Heingabe = Integer.parseInt(HeingabeString);
				} else Heingabe = 999;

				//System.out.println("2Ceingabe: " + Ceingabe + "    Heingabe: " + Heingabe);
				//System.out.println("2CeingabeString: " + CeingabeString + "    HeingabeString: " + HeingabeString);

				
				
				
				
				switch (ComboBoxItem) {
			case "Alkan":{
				if(Ceingabe != 999) {
					Ausgabe = Ceingabe*2;
					Ausgabe = Ausgabe + 2;
					textField_1.setText(Integer.toString(Ausgabe));
				}else if(Heingabe != 999) {					
					Ausgabe = Heingabe - 2;
					Ausgabe = (int) (0.5*Ausgabe);
					textField.setText(Integer.toString(Ausgabe));
				}else {
					JOptionPane.showMessageDialog(null, "Also es wäre schon wirklich vorteilhaft, \nwenn du zumindest irgendwas eingibst!");
				}
			break;	
			}
			case "Alken":{
				if(Ceingabe != 999) {
					Doppel = Doppel*2;
					Ausgabe = Ceingabe*2 + 2 - Doppel;
					textField_1.setText(Integer.toString(Ausgabe));
				}else if(Heingabe != 999) {					
					Ausgabe = Heingabe + 2*Doppel - 2;
					Ausgabe = (int) (0.5*Ausgabe);
					textField.setText(Integer.toString(Ausgabe));
				}else {
					JOptionPane.showMessageDialog(null, "Also es wäre schon wirklich vorteilhaft, \nwenn du zumindest irgendwas eingibst!");
				}
			break;	
			}
			case "Alkin":{
				if(Ceingabe != 999) {
					Doppel = Doppel*4;
					Ausgabe = Ceingabe*2 + 2 - Doppel;
					textField_1.setText(Integer.toString(Ausgabe));
				}else if(Heingabe != 999) {					
					Ausgabe = Heingabe + 4*Doppel - 2;
					Ausgabe = (int) (0.5*Ausgabe);
					textField.setText(Integer.toString(Ausgabe));
				}else {
					JOptionPane.showMessageDialog(null, "Also es wäre schon wirklich vorteilhaft, \nwenn du zumindest irgendwas eingibst!");
				}
			break;	
			}


			default:
				break;
				}
				
				
				
			}
		});
		
		JLabel lblNurBeiAlkenen = new JLabel("Nur bei Alkenen und Alkinen:");
		lblNurBeiAlkenen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAnzahlDerCdoppelbindungen = new JLabel("Anzahl der C-Doppelbindungen:");
		lblAnzahlDerCdoppelbindungen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TF_doppelBindungen = new JTextField();
		TF_doppelBindungen.setText("1");
		TF_doppelBindungen.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(119)
							.addComponent(lblKohlenwasserstoffeBilden))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblC)
							.addGap(4)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblH)
							.addGap(4)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnErgnzen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAnzahlDerCdoppelbindungen)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TF_doppelBindungen, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNurBeiAlkenen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEineEingabe)))
					.addContainerGap(337, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblKohlenwasserstoffeBilden)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblC)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblH)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(btnErgnzen)))
					.addGap(18)
					.addComponent(lblNurBeiAlkenen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnzahlDerCdoppelbindungen)
						.addComponent(TF_doppelBindungen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblEineEingabe)
					.addGap(238))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
