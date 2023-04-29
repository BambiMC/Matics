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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class FrameChemiePSEDatenblattSuchen extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNameDesElements;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemiePSEDatenblattSuchen frame = new FrameChemiePSEDatenblattSuchen();
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
	public FrameChemiePSEDatenblattSuchen() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(1130-27, 682, 390 + 45, 200 + 20);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDatenblatt = new JLabel("Datenblatt");
		lblDatenblatt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtNameDesElements = new JTextField();
		txtNameDesElements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
			
		});
		txtNameDesElements.setName("");
		txtNameDesElements.setToolTipText("Name  des Elements");
		txtNameDesElements.setColumns(10);
		
		JLabel lblGibDenNamen = new JLabel("Gib den Namen des Elements an, dessen Daten du aufrufen m\u00F6chtest:");
		
		JLabel lblFolgendeVariantenSind = new JLabel("Folgende Varianten sind unter anderem f\u00FCr z.B. Eisen zul\u00E4ssig:");
		
		JLabel lblEiseEiFerrum = new JLabel(">>  eis  |  Eisen  |  EI  |  FERR  |  Ferrum  |  fer  | 26 |  ErRuM");
		
		JButton btnBerechnen = new JButton("Ausgeben");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String elementString = txtNameDesElements.getText();
				
				FrameChemiePSEDatenblattAusgabe ausgabeFenster = new FrameChemiePSEDatenblattAusgabe(elementString, getLocation().x + getSize().width - 17, getLocation().y - 632);
				ausgabeFenster.setVisible(true);
				
				
			}
		});
		
		JLabel label = new JLabel(">>");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblGibDenNamen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFolgendeVariantenSind))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEiseEiFerrum))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNameDesElements, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBerechnen))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(160)
							.addComponent(lblDatenblatt)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDatenblatt)
					.addGap(18)
					.addComponent(lblGibDenNamen)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFolgendeVariantenSind)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEiseEiFerrum)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNameDesElements, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBerechnen)
						.addComponent(label))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
