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

import libs.LibraryChemie;
import libs.UsefulMethods;

public class FrameChemieElementeVergleichen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	public static String[] arrayElemente;
	
	public static String[] arrayAuswahl;
	
	public static Integer[] arrayBs;
	
	public static String[][] multi;
	
	public static int anzahlElemente, anzahlAuswahlkriterien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemieElementeVergleichen frame = new FrameChemieElementeVergleichen();
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
	public FrameChemieElementeVergleichen() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblElementeVergleichen = new JLabel("Elemente Vergleichen");
		lblElementeVergleichen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblZuVergleichendeElemente = new JLabel("Zu vergleichende Elemente:");
		
		JLabel label = new JLabel("\u2022");
		
		JLabel label_1 = new JLabel("\u2022");
		
		JLabel label_2 = new JLabel("\u2022");
		
		JLabel label_3 = new JLabel("\u2022");
		
		JLabel label_4 = new JLabel("\u2022");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblAuswahlkriterien = new JLabel("Auswahlkriterien:");
		
		JLabel label_5 = new JLabel("\u2022");
		
		JLabel label_6 = new JLabel("\u2022");
		
		JLabel label_7 = new JLabel("\u2022");
		
		JLabel label_8 = new JLabel("\u2022");
		
		JLabel label_9 = new JLabel("\u2022");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"W\u00E4hle aus...", "Name", "Kurzsymbol", "Protonen", "Elektronen", "Spezielle Kategorie", "Haupt Kategorie", "Periode", "Aussehen", "Masse auf der Erde", "Atommasse", "Ionisierungsenergie", "Aggregatszustand", "Struktur", "Dichte", "H\u00E4rte", "Schmelzpunkt", "Siedepunkt", "Volumen", "Elektronegativit\u00E4t", "Lizenz", "Neutronen", "in der Natur vorhanden?", "Radioaktiv?", "Flammenfarbe(beta)"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"W\u00E4hle aus...", "Name", "Kurzsymbol", "Protonen", "Elektronen", "Spezielle Kategorie", "Haupt Kategorie", "Periode", "Aussehen", "Masse auf der Erde", "Atommasse", "Ionisierungsenergie", "Aggregatszustand", "Struktur", "Dichte", "H\u00E4rte", "Schmelzpunkt", "Siedepunkt", "Volumen", "Elektronegativit\u00E4t", "Lizenz", "Neutronen", "in der Natur vorhanden?", "Radioaktiv?", "Flammenfarbe(beta)"}));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"W\u00E4hle aus...", "Name", "Kurzsymbol", "Protonen", "Elektronen", "Spezielle Kategorie", "Haupt Kategorie", "Periode", "Aussehen", "Masse auf der Erde", "Atommasse", "Ionisierungsenergie", "Aggregatszustand", "Struktur", "Dichte", "H\u00E4rte", "Schmelzpunkt", "Siedepunkt", "Volumen", "Elektronegativit\u00E4t", "Lizenz", "Neutronen", "in der Natur vorhanden?", "Radioaktiv?", "Flammenfarbe(beta)"}));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"W\u00E4hle aus...", "Name", "Kurzsymbol", "Protonen", "Elektronen", "Spezielle Kategorie", "Haupt Kategorie", "Periode", "Aussehen", "Masse auf der Erde", "Atommasse", "Ionisierungsenergie", "Aggregatszustand", "Struktur", "Dichte", "H\u00E4rte", "Schmelzpunkt", "Siedepunkt", "Volumen", "Elektronegativit\u00E4t", "Lizenz", "Neutronen", "in der Natur vorhanden?", "Radioaktiv?", "Flammenfarbe(beta)"}));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"W\u00E4hle aus...", "Name", "Kurzsymbol", "Protonen", "Elektronen", "Spezielle Kategorie", "Haupt Kategorie", "Periode", "Aussehen", "Masse auf der Erde", "Atommasse", "Ionisierungsenergie", "Aggregatszustand", "Struktur", "Dichte", "H\u00E4rte", "Schmelzpunkt", "Siedepunkt", "Volumen", "Elektronegativit\u00E4t", "Lizenz", "Neutronen", "in der Natur vorhanden?", "Radioaktiv?", "Flammenfarbe(beta)"}));
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				anzahlAuswahlkriterien = 0;
				
				
				if(comboBox.getSelectedItem() != "W\u00E4hle aus...") {
					anzahlAuswahlkriterien++;
				}
				if(comboBox_1.getSelectedItem() != "W\u00E4hle aus...") {
					anzahlAuswahlkriterien++;
				}
				if(comboBox_2.getSelectedItem() != "W\u00E4hle aus...") {
					anzahlAuswahlkriterien++;
				}
				if(comboBox_3.getSelectedItem() != "W\u00E4hle aus...") {
					anzahlAuswahlkriterien++;
				}
				if(comboBox_4.getSelectedItem() != "W\u00E4hle aus...") {
					anzahlAuswahlkriterien++;
				}
				
				arrayAuswahl = new String[anzahlAuswahlkriterien];
				
				anzahlAuswahlkriterien = 0;
				
				if(comboBox.getSelectedItem() != "W\u00E4hle aus...") {
					arrayAuswahl[anzahlAuswahlkriterien] = (String) comboBox.getSelectedItem();
					anzahlAuswahlkriterien++;
				}
				if(comboBox_1.getSelectedItem() != "W\u00E4hle aus...") {
					arrayAuswahl[anzahlAuswahlkriterien] = (String) comboBox_1.getSelectedItem();
					anzahlAuswahlkriterien++;
				}
				if(comboBox_2.getSelectedItem() != "W\u00E4hle aus...") {
					arrayAuswahl[anzahlAuswahlkriterien] = (String) comboBox_2.getSelectedItem();
					anzahlAuswahlkriterien++;
				}
				if(comboBox_3.getSelectedItem() != "W\u00E4hle aus...") {
					arrayAuswahl[anzahlAuswahlkriterien] = (String) comboBox_3.getSelectedItem();
					anzahlAuswahlkriterien++;
				}
				if(comboBox_4.getSelectedItem() != "W\u00E4hle aus...") {
					arrayAuswahl[anzahlAuswahlkriterien] = (String) comboBox_4.getSelectedItem();
					anzahlAuswahlkriterien++;
				}
				
				anzahlElemente = 0;
				
				if(textField.getText().isEmpty() == false) {
					anzahlElemente++;
				}
				if(textField_1.getText().isEmpty() == false) {
					anzahlElemente++;
				}
				if(textField_2.getText().isEmpty() == false) {
					anzahlElemente++;
				}
				if(textField_3.getText().isEmpty() == false) {
					anzahlElemente++;
				}
				if(textField_4.getText().isEmpty() == false) {
					anzahlElemente++;
				}
				
				arrayElemente = new String[anzahlElemente];
				
				arrayBs = new Integer[anzahlElemente];
				
				anzahlElemente = 0;
				
				
				if(textField.getText().isEmpty() == false) {
					arrayElemente[anzahlElemente] = textField.getText();
					anzahlElemente++;
				}
				if(textField_1.getText().isEmpty() == false) {
					arrayElemente[anzahlElemente] = textField_1.getText();
					anzahlElemente++;
				}
				if(textField_2.getText().isEmpty() == false) {
					arrayElemente[anzahlElemente] = textField_2.getText();
					anzahlElemente++;
				}
				if(textField_3.getText().isEmpty() == false) {
					arrayElemente[anzahlElemente] = textField_3.getText();
					anzahlElemente++;
				}
				if(textField_4.getText().isEmpty() == false) {
					arrayElemente[anzahlElemente] = textField_4.getText();
					anzahlElemente++;
				}
				
				//Die 3 Arrays stehen zur Bearbeitung bereit
				
				//System.out.println(anzahlElemente);
				
				
				for (int i = 0; i < arrayBs.length; i++) {
					//Nur kommentiert, damit Error weg ist 220820
					//arrayBs[i] = UsefulMethods.Switch(arrayElemente[i]);	
					UsefulMethods.SpezialElementNOT(arrayBs[i]);
				}
				
				
				
				multi = new String[anzahlElemente][anzahlAuswahlkriterien];
				
			
				
				for (int i = 0; i < anzahlElemente; i++) {
					for (int j = 0; j < anzahlAuswahlkriterien; j++) {
						
						//Benutzte Arrays:
						// s i b d boo
						
						if (arrayBs[i] < 118) {
						//Nur kommentiert, damit Error weg ist 220820
						//LibraryChemie.LibraryChemie();
						if(arrayAuswahl[j] == "Name") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][0];	
						}
						if(arrayAuswahl[j] == "Kurzsymbol") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][1];	
						}
						if(arrayAuswahl[j] == "Spezielle Kategorie") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][2];
						}
						if(arrayAuswahl[j] == "Haupt Kategorie") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][3];
						}
						if(arrayAuswahl[j] == "Aussehen") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][4];
						}
						if(arrayAuswahl[j] == "Aggregatszustand") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][5];
						}
						if(arrayAuswahl[j] == "Struktur") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][6];
						}
						if(arrayAuswahl[j] == "Lizenz") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][7];
						}
						if(arrayAuswahl[j] == "Flammenfarbe(beta)") {
							multi[i][j] = LibraryChemie.s[arrayBs[i]][8];
						}
						if(arrayAuswahl[j] == "Protonen") {
							multi[i][j] = Integer.toString(LibraryChemie.i[arrayBs[i]][0]);
						}
						if(arrayAuswahl[j] == "Elektronen") {
							multi[i][j] = Integer.toString(LibraryChemie.i[arrayBs[i]][0]);
						}
						if(arrayAuswahl[j] == "Neutronen") {
							multi[i][j] = Integer.toString(LibraryChemie.i[arrayBs[i]][1]);
						}
						if(arrayAuswahl[j] == "Haupt Kategorie") {
							multi[i][j] = Byte.toString(LibraryChemie.b[arrayBs[i]][0]);
						}
						if(arrayAuswahl[j] == "Periode") {
							multi[i][j] = Byte.toString(LibraryChemie.b[arrayBs[i]][1]);
						}
						if(arrayAuswahl[j] == "Masse auf der Erde") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][2]);
							multi[i][j] = multi[i][j] + " °C";
						}
						if(arrayAuswahl[j] == "Atommasse") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][3]);
							multi[i][j] = multi[i][j] + " u";
						}
						if(arrayAuswahl[j] == "Ionisierungsenergie") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][4]);
							multi[i][j] = multi[i][j] + " eV";
						}
						if(arrayAuswahl[j] == "Dichte") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][5]);
							multi[i][j] = multi[i][j] + " m³/mol";
						}
						if(arrayAuswahl[j] == "Härte") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][0]);
							multi[i][j] = multi[i][j] + " Mohs";
						}
						if(arrayAuswahl[j] == "Schmelzpunkt") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][6]);
							multi[i][j] = multi[i][j] + " °C";
						}
						if(arrayAuswahl[j] == "Siedepunkt") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][7]);
							multi[i][j] = multi[i][j] + " °C";
						}
						if(arrayAuswahl[j] == "Volumen") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][1]);
							multi[i][j] = multi[i][j] + " m³/mol *";
						}
						if(arrayAuswahl[j] == "Elektronegativität") {
							multi[i][j] = Double.toString(LibraryChemie.d[arrayBs[i]][8]);
						}
						if(arrayAuswahl[j] == "in der Natur vorhanden?") {
							multi[i][j] = Boolean.toString(LibraryChemie.boo[arrayBs[i]][0]);
						}
						if(arrayAuswahl[j] == "Radioaktiv?") {
							multi[i][j] = Boolean.toString(LibraryChemie.boo[arrayBs[i]][1]);
						}						
						}
					
						else{
							JOptionPane.showMessageDialog(null, "Dieses Element gibt es nicht!\nFür den/die Entwickler: " + arrayBs[i]);
							}
						
							

						
						}
					}
				System.out.println("ARRAYTEST = NO BUG");				
				for (int k = 0; k < anzahlElemente; k++) {
					for (int l = 0; l < anzahlAuswahlkriterien; l++) {

						System.out.println(multi[k][l]);
					}
				}

				FrameChemieElementeVergleichenAusgabe frameChemieElementeVergleichenAusgabe = new FrameChemieElementeVergleichenAusgabe();
				frameChemieElementeVergleichenAusgabe.setVisible(true);
			
				
				//Tests

				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(126)
							.addComponent(lblElementeVergleichen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblZuVergleichendeElemente))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_2)
										.addComponent(textField_1))))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(78)
									.addComponent(lblAuswahlkriterien))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(70)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_7)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_9)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_4, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_6)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addComponent(btnBerechnen)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblElementeVergleichen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZuVergleichendeElemente)
						.addComponent(lblAuswahlkriterien))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_9)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(btnBerechnen)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
