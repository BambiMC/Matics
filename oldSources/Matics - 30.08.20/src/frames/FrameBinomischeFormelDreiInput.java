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

public class FrameBinomischeFormelDreiInput extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFergebnis;
	public JTextField TFnInput;
	public static String s = "Well, that's an error!";
	@SuppressWarnings("rawtypes")
	JComboBox comboBoxplusminus = new JComboBox();
	DecimalFormat f = new DecimalFormat("###");

	//Own Variables
	public static long Zaehler, Nenner1, Nenner2, NennerENT, Vorfaktor;
	public static long n = 0, k = 0, xExponent;
	public static String nString, xExponentwert = null, ENT = null;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FrameBinomischeFormelDreiInput frame = new FrameBinomischeFormelDreiInput();
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
	public FrameBinomischeFormelDreiInput() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBinomischeFormel = new JLabel("Binomische Formeln - Hoch n - mit zwei Variablen");
		lblBinomischeFormel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblX = new JLabel("( x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblY = new JLabel("y )");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAusrechnen = new JButton("Umrechnen");
		btnAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxplusminus.getSelectedItem() == "+") {
					
					String[] array;
					nString = TFnInput.getText();
					n = Integer.parseInt(nString);
					array = new String[(int) (n+1)]; 
					Zaehler = n; 
				System.out.println(nString + "  " + n + "  " + array + "  " + Zaehler);
				
				
				//Diese for-Schleife bestimmt die Zahl(y * Vorfaktor)

								for (int iarray = 0; iarray < array.length; iarray++) {
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
									String VorfaktorString;
									NennerENT = Nenner1 * Nenner2;
									Vorfaktor = Zaehler / NennerENT;

									String yExponentwert = null;
									long yExponent;
									
									//x-Exponenten berechnen
									xExponent = n - k;
									if (xExponent == 0) {
										xExponentwert = "";
									} else if(xExponent == 1){
										xExponentwert = " x";
									}else if(xExponent > 0) {
										xExponentwert = " x^" + xExponent;
									}
									//x-Exponenten berechnen
									//y-Exponent berechnen
									yExponent = k;
									if (yExponent == 0) {
										yExponentwert = "";
									} else if(yExponent == 1){
										yExponentwert = " y";
									}else if(yExponent > 0) {
										yExponentwert = " y^" + yExponent;
									}
									VorfaktorString = f.format(Vorfaktor);
									array[iarray] =VorfaktorString + xExponentwert + yExponentwert;
									
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

				String[] array;
				nString = TFnInput.getText();
				n = Integer.parseInt(nString);
				array = new String[(int) (n+1)]; 
				Zaehler = n; 
				
				
				
				//Diese for-Schleife bestimmt die Zahl(y * Vorfaktor)

								for (int iarray = 0; iarray < array.length; iarray++) {
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
									String VorfaktorString;
									NennerENT = Nenner1 * Nenner2;
									Vorfaktor = Zaehler / NennerENT;

									String yExponentwert = null;
									long yExponent;
									
									//x-Exponenten berechnen
									xExponent = n - k;
									if (xExponent == 0) {
										xExponentwert = "";
									} else if(xExponent == 1){
										xExponentwert = " x";
									}else if(xExponent > 0) {
										xExponentwert = " x^" + xExponent;
									}
									//x-Exponenten berechnen
									//y-Exponent berechnen
									yExponent = k;
									if (yExponent == 0) {
										yExponentwert = "";
									} else if(yExponent == 1){
										yExponentwert = " y";
									}else if(yExponent > 0) {
										yExponentwert = " y^" + yExponent;
									}
									VorfaktorString = f.format(Vorfaktor);
									array[iarray] =VorfaktorString + xExponentwert + yExponentwert;
									
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
				frameBinomischeFormelohnex.TFnInput.setText(FrameBinomischeFormelDreiInput.this.TFnInput.getText());
				frameBinomischeFormelohnex.comboBoxplusminus.setSelectedItem(FrameBinomischeFormelDreiInput.this.comboBoxplusminus.getSelectedItem());
				
				dispose();
			}
		});
		
		JButton btnMitEinerVariable = new JButton("Mit einer Variable");
		btnMitEinerVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameBinomischeFormelZweiInput frameBinomischeFormelZweiInput = new FrameBinomischeFormelZweiInput();
				frameBinomischeFormelZweiInput.setVisible(true);
				setVisible(false);
				
				//Variablenübertragung
				frameBinomischeFormelZweiInput.TFnInput.setText(FrameBinomischeFormelDreiInput.this.TFnInput.getText());
				frameBinomischeFormelZweiInput.comboBoxplusminus.setSelectedItem(FrameBinomischeFormelDreiInput.this.comboBoxplusminus.getSelectedItem());
				
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
							.addGap(31)
							.addComponent(btnOhneVariable)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMitEinerVariable))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblX)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxplusminus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblY)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblN)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAusrechnen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFergebnis, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblN_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFnInput, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBinomischeFormel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOhneVariable)
						.addComponent(btnMitEinerVariable))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblN_1)
								.addComponent(TFnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblX)
								.addComponent(comboBoxplusminus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblY)
								.addComponent(label_4)
								.addComponent(btnAusrechnen))
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblN)
							.addGap(32)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(TFergebnis, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblKommazahlenMitPunkt)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		}
}
