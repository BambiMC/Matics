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

public class FrameChemieOrganischKWvisualisieren extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHexansure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemieOrganischKWvisualisieren frame = new FrameChemieOrganischKWvisualisieren();
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
	public FrameChemieOrganischKWvisualisieren() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblKohlenwasserstoffeVisualisieren = new JLabel("Kohlenwasserstoffe visualisieren");
		lblKohlenwasserstoffeVisualisieren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblDerNameDes = new JLabel("Der Name des KW's :");
		lblDerNameDes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton btnAusgeben = new JButton("Ausgeben");
		btnAusgeben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String EINGABE = txtHexansure.getText();
				
				if(EINGABE == "") {
					JOptionPane.showMessageDialog(null, "Du musst schon was eingeben!!\n:-)");
				}
				
				
				
				//Eingabe modifizieren
				EINGABE = EINGABE.trim();
				EINGABE = EINGABE.toLowerCase();
				EINGABE = EINGABE.replace("ä", "ae");
				EINGABE = EINGABE.replace("ö", "oe");
				EINGABE = EINGABE.replace("ü", "ue");
				EINGABE = EINGABE.replace("-", "");
				//Eingabe modifizieren//hexahe
				//int LAENGE = EINGABE.length();
				String[] parts= EINGABE.split("/", 100);//Flaschenhals
				//int length = parts.length;
				
				
				
				
				//neues fenster machen und array bearbeiten
				
				FrameChemieOrganischKWvisualisierenAusgabe frameChemieOrganischKWvisualisierenAusgabe = new FrameChemieOrganischKWvisualisierenAusgabe(parts);
				frameChemieOrganischKWvisualisierenAusgabe.setVisible(true);
				
				/* 
				 * Carbonsäure	-säure	1
				 * Ester		-ester	2
				 * Aldehyd		-al		3
				 * Keton		-on		4
				 * Alkohol		-ol		5
				 * Alken		-en		6
				 * Alkin		-in		7
				 * Alkan		-an		8
				 * Halogenalkane----------
				 * http://www.seilnacht.com/Lexikon/nomenkl.html
				 */				
				
				/*ALT
				int LaengeHauptkette = 0;
				String s = textField.getText();
				s = s.replace(" ", "");
				s = s.toLowerCase();
				
				//Der Benutzer muss alle Teile mit einem Minus abtrennen!
				
				String[] parts = s.split("-");
				int ArrayLaenge = parts.length;
				
				ArrayList<String> teile = new ArrayList<String>();
				
				for (int i = 0; i < parts.length; i++) {
					teile.add(parts[i]);
				}
				
				
				
				for (int i = 0; i < teile.size(); i++) {
					if(UsefulMethods.KWhauptketteAlkan(parts[i]) != 0) {
						LaengeHauptkette = UsefulMethods.KWhauptketteAlkan(teile.get(i));
						teile.remove(i);
					}
				}

				
				for (int i = 0; i < parts.length; i++) {
					String string = parts[i];
					if(string.indexOf("fluor") != -1 || string.indexOf("chlor") != -1 || string.indexOf("brom") != -1 || string.indexOf("iod") != -1 || string.indexOf("astat") != -1 || string.indexOf("ununseptium") != -1 || string.indexOf("tennessine") != -1) {
						
					}
				}
				
			ALT*/	
			}
		});
		
		JLabel lblKeineTrivialnamenErlaubt = new JLabel("Keine Trivialnamen erlaubt!");
		lblKeineTrivialnamenErlaubt.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblAlleFormelnMssen = new JLabel("Alle Formeln m\u00FCssen durch \"/\" unterteilt werden, Bsp.:\r\n");
		
		JLabel lblAlleFormelnMssen_1 = new JLabel("2,3-Dihydroxybutandis\u00E4ure   ─>   2,3-Dihydroxy/butan/dis\u00E4ure");
		
		JLabel lblAlleFormelnMssen_2 = new JLabel("2-Hydroxypropan-1,2,3-tricarbons\u00E4ure   ─>   2-Hydroxy/propan/-1,2,3-tricarbons\u00E4ure");
		
		JLabel lblDabeiIstDie = new JLabel("Dabei ist die Benutzung von \"-\" irrelevant!");
		
		txtHexansure = new JTextField();
		txtHexansure.setText("hexan/säure");
		txtHexansure.setColumns(10);
		
		JLabel lblZahlenMssenMit = new JLabel("Zahlen müssen mit Kommas abgetrennt werden");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDerNameDes)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtHexansure, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
								.addComponent(lblKohlenwasserstoffeVisualisieren)
								.addComponent(btnAusgeben)))
						.addComponent(lblKeineTrivialnamenErlaubt)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAlleFormelnMssen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAlleFormelnMssen_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAlleFormelnMssen_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDabeiIstDie))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblZahlenMssenMit)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKohlenwasserstoffeVisualisieren)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDerNameDes)
						.addComponent(txtHexansure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAusgeben)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAlleFormelnMssen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAlleFormelnMssen_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAlleFormelnMssen_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDabeiIstDie)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblZahlenMssenMit)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblKeineTrivialnamenErlaubt))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
