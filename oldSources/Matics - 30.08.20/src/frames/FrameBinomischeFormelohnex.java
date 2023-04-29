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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FrameBinomischeFormelohnex extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField TFinKlammern2;
	private JTextField TFergebnis;
	public JTextField TFnInput;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBoxplusminus = new JComboBox();
	DecimalFormat f = new DecimalFormat("###");
	private JTextField TFinKlammern1;
	//Own Variables
	public long n = 0, k;
	public String zz;
	public double x, y, z;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FrameBinomischeFormelohnex frame = new FrameBinomischeFormelohnex();
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
	public FrameBinomischeFormelohnex() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBinomischeFormel = new JLabel("Binomische Formeln - Hoch n - ohne Variablen");
		lblBinomischeFormel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TFinKlammern2 = new JTextField();
		TFinKlammern2.setColumns(10);
		
		JLabel lblX = new JLabel("(");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label = new JLabel(")");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAusrechnen = new JButton("Umrechnen");
		btnAusrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				n = Integer.parseInt(TFnInput.getText());
				x = Double.parseDouble(TFinKlammern1.getText());
				y = Double.parseDouble(TFinKlammern2.getText());
				
				if (comboBoxplusminus.getSelectedItem() == "+") {
				
				z = x+y;

			}else if(comboBoxplusminus.getSelectedItem() == "-"){
				z = x-y;

			}else if(comboBoxplusminus.getSelectedItem() == "*") {
				z = x*y;

			}else if(comboBoxplusminus.getSelectedItem() == "/") {
				z = x/y;	
			}
			
			
			
			
			
			
			
			else {
				JOptionPane.showMessageDialog(null, "Ok, Mist, Fataler Fehler, Melde dies bitte dem Entwickler(also mir)\nFür mich:Bifo Ohne x -> combobox_bug");
			}
			
				z = Math.pow(z, n);
				
				TFergebnis.setText(f.format(z));	
				
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
		comboBoxplusminus.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "*", "/"}));
		
		JLabel lblN_1 = new JLabel("n =");
		lblN_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TFnInput = new JTextField();
		TFnInput.setColumns(10);
		
		TFinKlammern1 = new JTextField();
		TFinKlammern1.setColumns(10);
		
		JButton btnMitEinerVariablen = new JButton("Mit einer Variablen");
		btnMitEinerVariablen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrameBinomischeFormelZweiInput frameBinomischeFormelZweiInput = new FrameBinomischeFormelZweiInput();
				frameBinomischeFormelZweiInput.setVisible(true);
				setVisible(false);
				
				//Variablenübertragung
				
				frameBinomischeFormelZweiInput.comboBoxplusminus.setSelectedItem(FrameBinomischeFormelohnex.this.comboBoxplusminus.getSelectedItem());
				frameBinomischeFormelZweiInput.TFnInput.setText(FrameBinomischeFormelohnex.this.TFnInput.getText());
				
				
				
				if(frameBinomischeFormelZweiInput.TFinKlammern.getText() != "") {
				if(FrameBinomischeFormelohnex.this.comboBoxplusminus.getSelectedItem() == "+")  {
					if(FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == " " || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == " ") {
					frameBinomischeFormelZweiInput.TFinKlammern.setText(Integer.toString(Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern1.getText()) + Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern2.getText())));
					}
				} else if(FrameBinomischeFormelohnex.this.comboBoxplusminus.getSelectedItem() == "-"){
					if(FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == " " || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == " ") {
					frameBinomischeFormelZweiInput.TFinKlammern.setText(Integer.toString(Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern1.getText()) - Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern2.getText())));
					}
				} else if(FrameBinomischeFormelohnex.this.comboBoxplusminus.getSelectedItem() == "*") {
					if(FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == " " || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == " ") {
					frameBinomischeFormelZweiInput.TFinKlammern.setText(Integer.toString(Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern1.getText()) * Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern2.getText())));
					}
				} else if(FrameBinomischeFormelohnex.this.comboBoxplusminus.getSelectedItem() == "/") {
					if(FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern1.getText() == " " || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == "" || FrameBinomischeFormelohnex.this.TFinKlammern2.getText() == " ") {
					frameBinomischeFormelZweiInput.TFinKlammern.setText(Integer.toString(Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern1.getText()) / Integer.parseInt(FrameBinomischeFormelohnex.this.TFinKlammern2.getText())));
					}
				}
				}
				frameBinomischeFormelZweiInput.comboBoxplusminus.setSelectedItem(FrameBinomischeFormelohnex.this.comboBoxplusminus.getSelectedItem());
				
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
				frameBinomischeFormelDreiInput.TFnInput.setText(FrameBinomischeFormelohnex.this.TFnInput.getText());
				frameBinomischeFormelDreiInput.comboBoxplusminus.setSelectedItem(FrameBinomischeFormelohnex.this.comboBoxplusminus.getSelectedItem());
				
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
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMitEinerVariablen)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMitZweiVariablen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblN_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFnInput, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFergebnis, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblX)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFinKlammern1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxplusminus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TFinKlammern2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblN)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAusrechnen)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBinomischeFormel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMitEinerVariablen)
						.addComponent(btnMitZweiVariablen))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblN_1)
								.addComponent(TFnInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblX)
								.addComponent(TFinKlammern1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxplusminus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TFinKlammern2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(label_4)
								.addComponent(btnAusrechnen))
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(lblN)
							.addPreferredGap(ComponentPlacement.RELATED)))
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
