package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import libs.ChemieUsefulMethods;
import libs.UsefulMethods;

public class FrameChemieOrganischKWvisualisierenAusgabe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemieOrganischKWvisualisierenAusgabe frame = new FrameChemieOrganischKWvisualisierenAusgabe(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.Gridwight Gridheitght
	 */
	
	//Global Variables
		int z = 0;
		int[] saeuren;
		int cAnzahl = 0;
		int saeureAnzahl = 0;
		int Xc = 100, Yc = 100;
		int Xplus = 10, Yplus = 10;
	//Global Variables
	
	
	public FrameChemieOrganischKWvisualisierenAusgabe(String[] parts) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		
		JLabel label = new JLabel("New label");
		getContentPane().add(label, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 400, 450, 300);

		
				/*GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{207, 19, 0};
		gbl_contentPane.rowHeights = new int[]{123, 14, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);*/
		getContentPane().setLayout(null);
		
		
		
		//Mein Stuff
				
				Vector<JLabel> v = new Vector<JLabel>(5,5);
		
				/*GridBagConstraints konfigurieren
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridheight = 100;
				gbc.gridwidth = 100;
				GridBagConstraints konfigurieren
				*/

				//Anzahl der C-Atome der Hauptkette herausfinden
				for (int i = 0; i < parts.length; i++) {
					if(cAnzahl == 0) {
						cAnzahl = ChemieUsefulMethods.AVcAnzahlFIND(parts[i]);
					}
					
				}
				System.out.println("cAnzahl :"+cAnzahl);
				//Anzahl der C-Atome der Hauptkette herausfinden//																						
				
				//Hauptkette C's in den Frame einfügen
					
					
				for (int j = 0; j < cAnzahl; j++) {
					
					v.addElement(new JLabel("C"));
					v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 25, 25);			
					v.elementAt(z).setFont(new Font("Tahoma", 0, 18));
					getContentPane().add(v.elementAt(z));
					
					Xplus = Xplus + 30;
					z++;
			if(!(j+1 >= cAnzahl)) {		
					v.addElement(new JLabel("—"));
					v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 25, 25);
					v.elementAt(z).setFont(new Font("Tahoma", 0, 20));
					getContentPane().add(v.elementAt(z));
					
					Xplus = Xplus + 30;
					z++;
			}
					//Xc = Xc+2;
				}
				
				//Anzahl der Saeure-Teile der Hauptkette herausfinden
				saeuren = new int[cAnzahl];
				
					if(saeureAnzahl == 0) {
												
						for (int i = 0; i < parts.length; i++) {
							
							if(parts[i].contains("carbonsaeure") == true || parts[i].contains("saeure") == true) {
							if(UsefulMethods.isNumbersThere(parts[i]) == true) {
								
								//Wenn Zahlen vorhanden sind, dann...
								saeureAnzahl = ChemieUsefulMethods.getVorsilbenNumberToNumberSaeureAnzahl(parts[i]);
								System.out.println("SäureAnzahl :" + saeureAnzahl);
								saeuren = ChemieUsefulMethods.getVorsilbenNumberToNumber(parts[i], cAnzahl);
							
							} else {
								
								//Wenn keine Zahlen vorhanden sind...
								saeureAnzahl = ChemieUsefulMethods.getVorsilbenWordToNumber(parts[i]);			
								
								if(saeureAnzahl == 1) {
									saeuren[0] = 1;
								} else if(saeureAnzahl == 2) {
									saeuren[0] = 1;
									saeuren[cAnzahl-1] = 1;
								} if(saeureAnzahl == 3) {
									JOptionPane.showMessageDialog(null, "Muss noch gemacht werden, sag mir bitte Bescheid, dass du das hier gefunden hast!");
								}
								
							}
							//Wenn überhaupt Säuren vorhanden sind...
							
							
							for (int j = 0; j < cAnzahl; j++) {
								
								if(saeuren[j] == 1) {
								
									//Das ist der obere Teil
									
								v.addElement(new JLabel("∥")); 
								v.elementAt(z).setBounds(Xc+j*55, Yc-30, 25, 25);
								v.elementAt(z).setFont(new Font("Tahoma", 0, 18));
								getContentPane().add(v.elementAt(z));
								z++;
									
								v.addElement(new JLabel("O")); 
								v.elementAt(z).setBounds(Xc+j*55, Yc-60, 25, 25);
								v.elementAt(z).setFont(new Font("Tahoma", 0, 18));
								getContentPane().add(v.elementAt(z));
								z++;
								
								if(j == 0) {
									v.addElement(new JLabel("⳹"));
								} else {
									v.addElement(new JLabel("⳼")); 
								}
								if(j == 0) {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}else {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}
								

								getContentPane().add(v.elementAt(z));
								z++;
								
									//Das ist der untere Teil
								v.addElement(new JLabel("O")); 

								if(j == 0) {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}else {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}
								
								
								getContentPane().add(v.elementAt(z));
								z++;

								v.addElement(new JLabel("─")); 

								if(j == 0) {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}else {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}
								

								getContentPane().add(v.elementAt(z));
								z++;

								v.addElement(new JLabel("H"));

								if(j == 0) {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}else {
									v.elementAt(z).setBounds(Xc+Xplus, Yc+Yplus, 10, 10);
								}
								
								
								getContentPane().add(v.elementAt(z));
								z++;
								}
						}
						
						//MethodenBoden
						}
					
				}
				
					System.out.println("saeuren array length :" + saeuren.length);
					for (int k = 0; k < saeuren.length; k++) {
						System.out.println("Durchlauf :" + k + " mit Wert :" + saeuren[k]);
					
					}

				System.out.println("saeureAnzahl :"+saeureAnzahl);																						
	}

}}
//Fenstergröße an Molekül anpassen
//http://www.chemgapedia.de/vsengine/vlu/vsc/de/ch/12/oc/vlu_organik/c_acid/nomenklatur_und_strukt_carbons.vlu/Page/vsc/de/ch/12/oc/c_acid/nomenklatur/nomenklatur.vscml.html
//Am Ende checken, ob alle parts i's bearbeitet wurden und bei fehler den rest ausgeben
//insets fehlen
//if()......saeure etc.
//https://de.wikipedia.org/wiki/Unicodeblock_Rahmenzeichnung
//alle Kommentare durchforsten
//http://www.fileformat.info/info/unicode/char/




//v.elementAt(j).setFont(new Font("Tahoma", Font.PLAIN, 15));
//System.out.println("1. Teil\nDurchlauf(j) :" + j + "\nXc :" + Xc + "\nz :" + z + "\ncAnzahl :" + cAnzahl);
//System.out.println("-----\nC\nElement an der Stelle :" + z + "\ngridx =" + gbc.gridx + "\ngridy =" + gbc.gridy + "\n-----");	