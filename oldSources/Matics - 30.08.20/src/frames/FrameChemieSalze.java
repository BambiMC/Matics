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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import libs.LibraryChemie;
import libs.UsefulMethods;

public class FrameChemieSalze extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String kationKS, anionKS;
	private JPanel contentPane;
	private JTextField TFkation;
	private JTextField TFanion;
	public static int kation = 999, anion = 999;
	
	String kationString, anionString;
	int kationMULTI = 1, anionMULTI = 1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemieSalze frame = new FrameChemieSalze();
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
	public FrameChemieSalze() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSalzigeAngelegenheiten = new JLabel("Salzige Angelegenheiten");
		lblSalzigeAngelegenheiten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblKation = new JLabel("Kation:");
		
		JLabel lblAnion = new JLabel("Anion:");
		
		TFkation = new JTextField();
		TFkation.setColumns(10);
		
		TFanion = new JTextField();
		TFanion.setColumns(10);
		
		JButton btnIndexeBerechnen = new JButton("Indexe berechnen");

		
		JLabel lblErgebnis = new JLabel("Ergebnis:");
		JLabel KATIONergebnis = new JLabel();
		KATIONergebnis.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel ANIONergebnis = new JLabel();
		ANIONergebnis.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel KATIONindex = new JLabel();
		
		JLabel ANIONindex = new JLabel();
		
		JLabel lblBindung = new JLabel();
		
		btnIndexeBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Nur kommentiert, damit Error weg ist 220820
				//LibraryChemie.LibraryChemie();

				//Werte auf die Variablen übergeben
				kationString = TFkation.getText();
				anionString = TFanion.getText();
				
				//Nur kommentiert, damit Error weg ist 220820
				//kation = ChemieElementSwitch.Switch(kationString);
				//anion = ChemieElementSwitch.Switch(anionString);
				UsefulMethods.SpezialElementNOT(kation);
				UsefulMethods.SpezialElementNOT(anion);

				if (LibraryChemie.s[kation][3] == "Metall" && (LibraryChemie.s[anion][3] == "Halbmetall" || (LibraryChemie.s[anion][3] == "Nichtmetall" && (LibraryChemie.s[anion][2] == "Halogen" || LibraryChemie.s[anion][2] == "-/-")))) {
					
					if(LibraryChemie.s[kation][3] == "Halbmetall"){
						JOptionPane.showMessageDialog(null, "Da dein ausgewähltes Kation nach gängiger Definition ein Halbmetall darstellt, kann es sein, dass die ausgegebene Ionenbindung nicht stimmt!");
					}
					if(LibraryChemie.s[anion][3] == "Halbmetall"){
						JOptionPane.showMessageDialog(null, "Da dein ausgewähltes Kation nach gängiger Definition ein Halbmetall darstellt, kann es sein, dass die ausgegebene Ionenbindung nicht stimmt!");
					}
					kationKS = LibraryChemie.s[kation][1];
					anionKS = LibraryChemie.s[anion][1];
					KATIONergebnis .setText(kationKS);
					ANIONergebnis.setText(anionKS);
					double Differrenz = LibraryChemie.d[anion][8] - LibraryChemie.d[kation][8];
					
					
				kation = LibraryChemie.i[kation][2];
				anion = LibraryChemie.i[anion][2];
				if (kation+anion == 8) {
				kationString = Integer.toString(kation);
				anionString = Integer.toString(anion);
				KATIONindex.setText("");
				ANIONindex.setText("");
				} else {

				while((kation*kationMULTI + anion*anionMULTI)%8 != 0) {
				if (((kation*kationMULTI + anion*anionMULTI)%8 > 0)) {
					anionMULTI++;break;
				} else {
					kationMULTI++;break;
				}
				}
					if(kationMULTI != 1) {
					KATIONindex.setText(Integer.toString(kationMULTI));
					}
					if(anionMULTI != 1)	 {
					ANIONindex.setText(Integer.toString(anionMULTI));
					}
				if (Differrenz <= 0.5) {
					lblBindung.setText("Es liegt eine unpolare Bindung vor!");
				} else if(Differrenz <= 0.5 && Differrenz >= 1.7){
					lblBindung.setText("Es liegt eine polare Bindung vor!");
				} else if (Differrenz >= 1.7) {
					lblBindung.setText("Es liegt eine ionische Bindung vor!");
				}
				
					
					
				}
						
				} else {
					if (LibraryChemie.s[kation][3] != "Metall" || LibraryChemie.s[kation][3] == "Halbmetall") {
						JOptionPane.showMessageDialog(null, "Dein ausgewähltes Element kann kein Kation werden, da es kein Metall ist!");
					} else if (LibraryChemie.s[anion][3] == "Metall") {
						JOptionPane.showMessageDialog(null, "Dein ausgewähltes Element kann kein Anion werden, da es ein Metall ist!");
					} else if (LibraryChemie.s[anion][2] == "Edelgas") {
						JOptionPane.showMessageDialog(null, "Dein ausgewähltes Element kann kein Anion werden, da es ein Edelgas ist und damit bereits die optimale Anzahl(nämlich 8) an Valenzelektronen besitzt!");
					}
				}		
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Gib die Namen der Elemente an, aus denen du ein Salz bilden m\u00F6chtest:");
		
		JLabel lblNewLabel_1 = new JLabel("Folgende Varianten sind unter anderem f\u00FCr z.B. Eisen zul\u00E4ssig:");
		
		JLabel lblNewLabel_2 = new JLabel(">>  eis  |  Eisen  |  EI  |  FERR  |  Ferrum  |  fer  |  fe  |  Fe  |  FE");
		
		
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(lblSalzigeAngelegenheiten))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblKation, Alignment.LEADING)
								.addComponent(TFkation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(TFanion, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnIndexeBerechnen))
								.addComponent(lblAnion)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblErgebnis))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(KATIONergebnis)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(KATIONindex)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ANIONergebnis)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ANIONindex))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBindung, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2)))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSalzigeAngelegenheiten)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKation)
						.addComponent(lblAnion))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFkation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFanion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIndexeBerechnen))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(KATIONindex)
								.addComponent(ANIONindex)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblErgebnis)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(ANIONergebnis)
								.addComponent(KATIONergebnis))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBindung, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(202, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
