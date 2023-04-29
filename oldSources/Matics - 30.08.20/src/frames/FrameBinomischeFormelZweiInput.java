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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FrameBinomischeFormelZweiInput extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField TFinKlammern;
	private JTextField TFergebnis;
	public JTextField TFnInput;
	public static String s = "Well, that's an error!";
	@SuppressWarnings("rawtypes")
	public JComboBox comboBoxplusminus = new JComboBox();
	DecimalFormat f = new DecimalFormat("###");

	//Own Variables
	public static String xExponentwert = null,  ZAHLstring;
	public static double y,  ZAHL = 0;
	public static String[] array;
	public static long Nenner1, Nenner2, NennerENT, Vorfaktor, Zaehler, xExponent, n = 0, k = 0;  
	public static String ENT =null; 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FrameBinomischeFormelZweiInput frame = new FrameBinomischeFormelZweiInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
									  }
							 }
			 }					 
							);}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameBinomischeFormelZweiInput() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBinomischeFormel = new JLabel("Binomische Formeln - Hoch n - mit einer Variablen");
		lblBinomischeFormel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TFinKlammern = new JTextField();
		TFinKlammern.setColumns(10);
		
		JLabel lblX = new JLabel("( x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label = new JLabel(")");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAusrechnen = new JButton("Umrechnen");
		btnAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxplusminus.getSelectedItem() == "+") {
					
 
					y = Double.parseDouble(TFinKlammern.getText());
					n = Integer.parseInt(TFnInput.getText());
					Zaehler = n;
					array = new String[(int) (n+1)]; 

				
				
				//Diese for-Schleife bestimmt die Zahl(y * Vorfaktor)

								for (int iarray = 0; iarray < array.length; iarray++) {
									y = Double.parseDouble(TFinKlammern.getText());
					//n = n!
					//k = (n-k)! * k!
									
							
		 /*Zaehler*/						if (k == 0) {
											long a = Zaehler;while (a >1) {Zaehler = Zaehler * (a-1);a--;}
		 									}
									
											
											
		/*Nenner1*/							Nenner1 = n-k;	
											long b = Nenner1;while (b >1) {Nenner1 = Nenner1 * (b-1);b--;}
											
									
		/*Nenner2*/							Nenner2 = k;
											long c = Nenner2;while (c >1) {Nenner2 = Nenner2 * (c-1);c--;}
											
									if (Nenner1 == 0) {Nenner1 = 1;}
									if (Nenner2 == 0) {Nenner2 = 1;}
									
									NennerENT = Nenner1 * Nenner2;
									Vorfaktor = Zaehler / NennerENT;
									
								y = Math.pow(y, k);
									
									ZAHL = (y*Vorfaktor);
									
									//x-Exponenten berechnen
									xExponent = n - k;
									if (xExponent == 0) {
										xExponentwert = "";
									} else if(xExponent == 1){
										xExponentwert = "x";
									}else if(xExponent > 0) {
										xExponentwert = "x^" + xExponent;
									}
									//x-Exponenten berechnen
									
									ZAHLstring = f.format(ZAHL);
									
									array[iarray] = ZAHLstring + xExponentwert;
									
									k++;
								}				
									
								
								//+ richtigstellen
								ENT = "";
									for (int i = 0; i < array.length; i++) {
										if (i == (array.length - 1)) {
											ENT = ENT + array[i];	
										} else  if (i != (array.length - 1)) {
											ENT = ENT + array[i] + " + ";
										}	
									}
	
								TFergebnis.setText(ENT);
				
			}
			else{

				y = Double.parseDouble(TFinKlammern.getText());
				n = Integer.parseInt(TFnInput.getText());
				Zaehler = n;
				array = new String[(int) (n+1)]; 
				//Diese for-Schleife bestimmt die Zahl(y * Vorfaktor)

								for (int iarray = 0; iarray < array.length; iarray++) {
									y = Double.parseDouble(TFinKlammern.getText());
					//n = n!
					//k = (n-k)! * k!
									
							
		 /*Zaehler*/						if (k == 0) {
											long a = Zaehler;while (a >1) {Zaehler = Zaehler * (a-1);a--;}
		 									}
									
											
											
		/*Nenner1*/							Nenner1 = n-k;	
											long b = Nenner1;while (b >1) {Nenner1 = Nenner1 * (b-1);b--;}
											
									
		/*Nenner2*/							Nenner2 = k;
											long c = Nenner2;while (c >1) {Nenner2 = Nenner2 * (c-1);c--;}
											
									if (Nenner1 == 0) {Nenner1 = 1;}
									if (Nenner2 == 0) {Nenner2 = 1;}
									
									NennerENT = Nenner1 * Nenner2;
									Vorfaktor = Zaehler / NennerENT;
									
								y = Math.pow(y, k);
									
									ZAHL = (y*Vorfaktor);
									
									//x-Exponenten berechnen
									xExponent = n - k;
									if (xExponent == 0) {
										xExponentwert = "";
									} else if(xExponent == 1){
										xExponentwert = "x";
									}else if(xExponent > 0) {
										xExponentwert = "x^" + xExponent;
									}
									//x-Exponenten berechnen
									
									ZAHLstring = f.format(ZAHL);
									
									array[iarray] = ZAHLstring + xExponentwert;
									
									k++;
								}				
									
								boolean hilfsVar = false;
								//+ richtigstellen
								ENT = "";
									for (int i = 0; i < array.length; i++) {
										if (i == (array.length - 1)) {
											ENT = ENT + array[i];	
										} else  if (i != (array.length - 1)) {
											if (hilfsVar == true) {
												ENT = ENT + array[i] + " + ";	
												
												hilfsVar = false;
											} else if(hilfsVar ==false) {
												ENT = ENT + array[i] + " - ";	
												
												hilfsVar = true;
											}
											
											
										}	
									}
	
								TFergebnis.setText(ENT);

			}
				
			}}
			);
		
		TFergebnis = new JTextField();
		TFergebnis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TFergebnis.setColumns(10);
		
		JLabel lblKommazahlenMitPunkt = new JLabel("Kommazahlen mit Punkt statt Komma angeben!");
		lblKommazahlenMitPunkt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblN = new JLabel("n");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_4 = new JLabel("=");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_7 = new JLabel("=");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		comboBoxplusminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			} 
			
		});
		comboBoxplusminus.setModel(new DefaultComboBoxModel(new String[] {"+", "-"}));
		
		JLabel lblN_1 = new JLabel("n =");
		lblN_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TFnInput = new JTextField();
		TFnInput.setColumns(10);
		
		JButton btnOhneVariable = new JButton("Ohne Variable");
		btnOhneVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameBinomischeFormelohnex frameBinomischeFormelohnex = new FrameBinomischeFormelohnex();
				frameBinomischeFormelohnex.setVisible(true);
				setVisible(false);
				
				//Variablenübertragung
				
				frameBinomischeFormelohnex.TFnInput.setText(FrameBinomischeFormelZweiInput.this.TFnInput.getText());
				frameBinomischeFormelohnex.TFinKlammern2.setText(FrameBinomischeFormelZweiInput.this.TFinKlammern.getText());
				frameBinomischeFormelohnex.comboBoxplusminus.setSelectedItem(FrameBinomischeFormelZweiInput.this.comboBoxplusminus.getSelectedItem());
				
				dispose();
			}
		});
		
		JButton btnMitZweiVariablen = new JButton("Mit zwei Variablen");
		btnMitZweiVariablen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameBinomischeFormelDreiInput frameBinomischeFormelDreiInput = new FrameBinomischeFormelDreiInput();
				frameBinomischeFormelDreiInput.setVisible(true);
	
				setVisible(false);
				
				//Variablenübertragung

				frameBinomischeFormelDreiInput.TFnInput.setText(FrameBinomischeFormelZweiInput.this.TFnInput.getText());
				frameBinomischeFormelDreiInput.comboBoxplusminus.setSelectedItem(FrameBinomischeFormelZweiInput.this.comboBoxplusminus.getSelectedItem());
				
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKommazahlenMitPunkt, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBinomischeFormel, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnOhneVariable)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMitZweiVariablen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblN_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFnInput, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblX)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxplusminus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFinKlammern, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addGap(2)
							.addComponent(lblN)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAusrechnen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFergebnis, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBinomischeFormel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMitZweiVariablen)
						.addComponent(btnOhneVariable))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(TFnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblN_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblX)
								.addComponent(comboBoxplusminus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFinKlammern, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(label_4)
								.addComponent(btnAusrechnen))
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblN)
							.addGap(31)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(TFergebnis, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblKommazahlenMitPunkt)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		}}
