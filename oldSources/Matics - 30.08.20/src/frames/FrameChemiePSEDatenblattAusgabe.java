package frames;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import libs.ChemieUsefulMethods;
import libs.LibraryChemie;

public class FrameChemiePSEDatenblattAusgabe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	LibraryChemie libraryChemie = new LibraryChemie();


	/**
	 * Create the frame.
	 */
	public FrameChemiePSEDatenblattAusgabe(String eingabeString, int xAusgabe, int yAusgabe) {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(xAusgabe, yAusgabe, 400, 852);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDatenblatt = new JLabel("Datenblatt");
		lblDatenblatt.setFont(new Font("Tahoma", Font.PLAIN, 18));	
		
		
		//Start meines Codes
		
		int elementZahl = 0;
		
		try {
			elementZahl = ChemieUsefulMethods.getElementZahl(eingabeString);
			//Konvertierung von Ordnungszahl zu Arrayplatzzahl
		} catch (Exception e) {
			//System.out.println("Tut mir leid, das Programm konnte deine Eingabe leider nicht in ein gültiges Element umwandeln :-(\nVersuche es einfach nochmal :-)");
			//e.printStackTrace();
		}
		
		//Konvertierung von Elementzahl zur Arrayzahl(geht natürlich von 0-117)
		elementZahl--;
		
		JLabel lblName = new JLabel("\u2022 Name: " + LibraryChemie.s[elementZahl][0]);
		
		JLabel lblKurzsymbol = new JLabel("\u2022 Kurzsymbol: " + LibraryChemie.s[elementZahl][1]);
		
		JLabel lblProtonen = new JLabel("\u2022 Protonen: " + LibraryChemie.i[elementZahl][0]);
			
		JLabel lblElektronen = new JLabel("\u2022 Elektronen: " + LibraryChemie.i[elementZahl][0]);
		
		JLabel lblNeutronen = new JLabel("\u2022 Neutronen: " + LibraryChemie.i[elementZahl][1] + " **");
		
		JLabel lblOberkategorie = new JLabel("\u2022 Oberkategorie: " + LibraryChemie.s[elementZahl][3]);
		
		JLabel lblUnterkategorie = new JLabel("\u2022 Unterkategorie: " + LibraryChemie.s[elementZahl][2]);
		
		JLabel lblHauptgruppe = new JLabel("\u2022 Hauptgruppe: " + LibraryChemie.b[elementZahl][0]);
		
		JLabel lblPeriode = new JLabel("\u2022 Periode: " + LibraryChemie.b[elementZahl][1]);
		
		JLabel lblAllgemein = new JLabel("Allgemein");
		lblAllgemein.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPhysikalischeEigenschaften = new JLabel("Physikalische Eigenschaften");
		lblPhysikalischeEigenschaften.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAussehen = new JLabel("\u2022 Aussehen: " + LibraryChemie.s[elementZahl][4]);
		
		JLabel lblAggregatszustand = new JLabel("\u2022 Aggregatszustand: " + LibraryChemie.s[elementZahl][5] + " *");
		
		JLabel lblStruktur = new JLabel("\u2022 Struktur: " + LibraryChemie.s[elementZahl][6] + " *");
		
		JLabel lblHrte = new JLabel("\u2022 H\u00E4rte: " + LibraryChemie.d[elementZahl][0] + " Mohs");
		
		JLabel lblVolumen = new JLabel("\u2022 Volumen: " + LibraryChemie.d[elementZahl][1] + " m³/mol *");
		
		JLabel lblRadioaktiv = new JLabel("\u2022 Radioaktiv?:");
		if (LibraryChemie.boo[elementZahl][1]) {
			lblRadioaktiv.setText("\u2022 Radioaktiv?: Ja");
		}else{
			lblRadioaktiv.setText("\u2022 Radioaktiv?: Nein");
		}
		
		JLabel lblNewasLabel = new JLabel("Chemische Eigenschaften");
		lblNewasLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblSynthetischHergestellt = new JLabel("\u2022 Nur Synthetische Herstellung?:");
		
		if(LibraryChemie.boo[elementZahl][0]) {
			lblSynthetischHergestellt.setText("\u2022 Nur Synthetische Herstellung?: Ja");
		}else{
			lblSynthetischHergestellt.setText("\u2022 Nur Synthetische Herstellung?: Nein");
		}
		
		JLabel lblProzentsatzAnDerErdhülle = new JLabel("\u2022 Prozentsatz an der Erdh\u00FClle: " + LibraryChemie.d[elementZahl][2] + " %");
		
		JLabel lblAtommasse = new JLabel("\u2022 Atommasse: " + LibraryChemie.d[elementZahl][3] + " u");
		
		JLabel lblIonisierungsenergie = new JLabel("\u2022 Ionisierungsenergie: " + LibraryChemie.d[elementZahl][4] + " eV");
		
		JLabel lblDichte = new JLabel("\u2022 Dichte: " + LibraryChemie.d[elementZahl][5] + " g/cm³ *");
		
		JLabel lblSchmelzpunkt = new JLabel("\u2022 Schmelzpunkt: " + LibraryChemie.d[elementZahl][6] + " ° C");
		
		JLabel lblSiedepunkt = new JLabel("\u2022 Siedepunkt: " + LibraryChemie.d[elementZahl][7] + " ° C");
		
		JLabel lblElektronegativitt = new JLabel("\u2022 Elektronegativit\u00E4t: " + LibraryChemie.d[elementZahl][8] + " ***");
		
		JLabel lblFlammenfarbe = new JLabel("\u2022 Flammenfarbe: " + LibraryChemie.s[elementZahl][8]);
		
		JLabel lblWikipedia = new JLabel("\u2022 Wikipedia: " + LibraryChemie.s[elementZahl][7]);
		
		JLabel lblSds = new JLabel("*=Unter Normalbedingungen 20 Grad Celsius");
		
		JLabel lblberechnetNach = new JLabel("**=Berechnet nach = Masse(gerundet) - Ordnungszahl");
		
		JLabel lblnachDerPaulingskala = new JLabel("***=Nach der Pauling-Skala, notfalls nach Allred-Rochow");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDatenblatt)
						.addComponent(lblAllgemein)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblKurzsymbol)
								.addComponent(lblName)
								.addComponent(lblOberkategorie)
								.addComponent(lblUnterkategorie)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPeriode)
										.addComponent(lblHauptgruppe)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblElektronen)
										.addComponent(lblNeutronen)
										.addComponent(lblProtonen)))))
						.addComponent(lblPhysikalischeEigenschaften)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAggregatszustand)
								.addComponent(lblAussehen)
								.addComponent(lblStruktur)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVolumen)
										.addComponent(lblHrte)))
								.addComponent(lblRadioaktiv)))
						.addComponent(lblNewasLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSynthetischHergestellt)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAtommasse)
										.addComponent(lblProzentsatzAnDerErdhülle)))
								.addComponent(lblIonisierungsenergie)
								.addComponent(lblDichte)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSiedepunkt)
										.addComponent(lblSchmelzpunkt)))
								.addComponent(lblElektronegativitt)
								.addComponent(lblFlammenfarbe)
								.addComponent(lblWikipedia)
								.addComponent(lblSds)
								.addComponent(lblberechnetNach)
								.addComponent(lblnachDerPaulingskala))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDatenblatt)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAllgemein)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblKurzsymbol)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblProtonen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblElektronen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNeutronen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOberkategorie)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUnterkategorie)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHauptgruppe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPeriode)
					.addGap(18)
					.addComponent(lblPhysikalischeEigenschaften)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAussehen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAggregatszustand)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStruktur)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHrte)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVolumen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRadioaktiv)
					.addGap(18)
					.addComponent(lblNewasLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSynthetischHergestellt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblProzentsatzAnDerErdhülle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAtommasse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIonisierungsenergie)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDichte)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSchmelzpunkt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSiedepunkt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblElektronegativitt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFlammenfarbe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWikipedia)
					.addGap(28)
					.addComponent(lblSds)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblberechnetNach)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblnachDerPaulingskala)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}











}
