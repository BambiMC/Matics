package oldStuff;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import libs.LibraryChemie;


public class FrameChemiePSEAusgabeFensterNextTo extends JFrame {



//Own Variables
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String XnameX = null, XshortsymbolX = null, XspecialcategoryX = null, XmaincategoryX = null, XlookX = null, XaggregateX = null, XstructureX = null, XlicenseX = null, XflameX = null;
	public static int XprotonX = 0, XneutronX = 0;
	public static byte XmaingroupX = 0, XperiodX = 0;
	public static double XmassonearthX = 0, XmassuX = 0, XionizationX = 0, XdensityX = 0, XhardnessX = 0, XsmeltpointX = 0, XboilingpointX = 0, XvolumeX = 0, XelectronegativityX = 0;
	public static boolean XsyntheticalX, XradioactivX;	
	public static int XXX;




	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemiePSEAusgabeFensterNextTo frame = new FrameChemiePSEAusgabeFensterNextTo();
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
	public FrameChemiePSEAusgabeFensterNextTo() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setBounds(FrameChemiePSE.xges+16, FrameChemiePSE.yges, 370, FrameChemiePSE.h + FrameChemiePSEDatenblattSuchen.h - 9);
		
		System.out.println("Location: " + getLocation().x + "," + getLocation().y);
		System.out.println("Sizeh: " + getSize().height + "," + getSize().width);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDatenblatt = new JLabel("Datenblatt");
		lblDatenblatt.setFont(new Font("Tahoma", Font.PLAIN, 18));		
		
		//XXX = FrameChemiePSE.b;
		
		if (XXX < 118 && XXX != 999) {
			
		
		XnameX = LibraryChemie.s[XXX][0];
		XshortsymbolX = LibraryChemie.s[XXX][1];
		XspecialcategoryX = LibraryChemie.s[XXX][2];
		XmaincategoryX = LibraryChemie.s[XXX][3];
		XlookX = LibraryChemie.s[XXX][4];
		XaggregateX = LibraryChemie.s[XXX][5];
		XstructureX = LibraryChemie.s[XXX][6];
		XlicenseX = LibraryChemie.s[XXX][7];
		XflameX = LibraryChemie.s[XXX][8];
		XprotonX = LibraryChemie.i[XXX][0];
		XneutronX = LibraryChemie.i[XXX][1];
		XmaingroupX = LibraryChemie.b[XXX][0];
		XperiodX = LibraryChemie.b[XXX][1];
		XmassonearthX = LibraryChemie.d[XXX][2];
		XmassuX = LibraryChemie.d[XXX][3];
		XionizationX = LibraryChemie.d[XXX][4];
		XdensityX = LibraryChemie.d[XXX][5];
		XhardnessX = LibraryChemie.d[XXX][0];
		XsmeltpointX = LibraryChemie.d[XXX][6];
		XboilingpointX = LibraryChemie.d[XXX][7];
		XvolumeX = LibraryChemie.d[XXX][1];
		XelectronegativityX = LibraryChemie.d[XXX][8];
		XsyntheticalX = LibraryChemie.boo[XXX][0];
		XradioactivX = LibraryChemie.boo[XXX][1];
		
		}
		
		
				
		JLabel lblName = new JLabel("\u2022 Name: " +XnameX);
		
		JLabel lblKurzsymbol = new JLabel("\u2022 Kurzsymbol: " + XshortsymbolX);
		
		JLabel lblProtonen = new JLabel("\u2022 Protonen: " + XprotonX);
			
		JLabel lblElektronen = new JLabel("\u2022 Elektronen: " + XprotonX);
		
		JLabel lblNeutronen = new JLabel("\u2022 Neutronen: " + XneutronX + " **");
		
		JLabel lblOberkategorie = new JLabel("\u2022 Oberkategorie: " + XmaincategoryX);
		
		JLabel lblUnterkategorie = new JLabel("\u2022 Unterkategorie: " + XspecialcategoryX);
		
		JLabel lblHauptgruppe = new JLabel("\u2022 Hauptgruppe: " + XmaingroupX);
		
		JLabel lblPeriode = new JLabel("\u2022 Periode: " + XperiodX);
		
		JLabel lblAllgemein = new JLabel("Allgemein");
		lblAllgemein.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPhysikalischeEigenschaften = new JLabel("Physikalische Eigenschaften");
		lblPhysikalischeEigenschaften.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAussehen = new JLabel("\u2022 Aussehen: " + XlookX);
		
		JLabel lblAggregatszustand = new JLabel("\u2022 Aggregatszustand: " + XaggregateX + " *");
		
		JLabel lblStruktur = new JLabel("\u2022 Struktur: " + XstructureX + " *");
		
		JLabel lblHrte = new JLabel("\u2022 H\u00E4rte: " + XhardnessX + " Mohs");
		
		JLabel lblVolumen = new JLabel("\u2022 Volumen: " + XvolumeX + " m³/mol *");
		
		JLabel lblRadioaktiv = new JLabel("\u2022 Radioaktiv?: " + XradioactivX);
		if (XradioactivX == true) {
			lblRadioaktiv.setText("\u2022 Radioaktiv?: Ja");
		}else{
			lblRadioaktiv.setText("\u2022 Radioaktiv?: Nein");
		}
		
		JLabel lblNewasLabel = new JLabel("Chemische Eigenschaften");
		lblNewasLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblSynthetischHergestellt = new JLabel("\u2022 Synthetisch hergestellt?: " + XsyntheticalX);
		
		if(XsyntheticalX == true) {
			lblSynthetischHergestellt.setText("\u2022 Nur Synthetische Herstellung?: Ja");
		}else{
			lblSynthetischHergestellt.setText("\u2022 Nur Synthetische Herstellung?: Nein");
		}
		
		JLabel lblProzentsatzAnDerErdhülle = new JLabel("\u2022 Prozentsatz an der Erdh\u00FClle: " + XmassonearthX + " %");
		
		JLabel lblAtommasse = new JLabel("\u2022 Atommasse: " + XmassuX + " u");
		
		JLabel lblIonisierungsenergie = new JLabel("\u2022 Ionisierungsenergie: " + XionizationX + " eV");
		
		JLabel lblDichte = new JLabel("\u2022 Dichte: " + XdensityX + " g/cm³ *");
		
		JLabel lblSchmelzpunkt = new JLabel("\u2022 Schmelzpunkt: " + XsmeltpointX + " ° C");
		
		JLabel lblSiedepunkt = new JLabel("\u2022 Siedepunkt: " + XboilingpointX + " ° C");
		
		JLabel lblElektronegativitt = new JLabel("\u2022 Elektronegativit\u00E4t: " + XelectronegativityX + " ***");
		
		JLabel lblFlammenfarbe = new JLabel("\u2022 Flammenfarbe: " + XflameX);
		
		JLabel lblWikipedia = new JLabel("\u2022 Wikipedia: " + XlicenseX);
		
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
