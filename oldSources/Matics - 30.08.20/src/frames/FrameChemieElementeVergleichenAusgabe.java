package frames;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import libs.LibraryChemie;

public class FrameChemieElementeVergleichenAusgabe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemieElementeVergleichenAusgabe frame = new FrameChemieElementeVergleichenAusgabe();
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
	public FrameChemieElementeVergleichenAusgabe() {
		
		//SYSOUTS
		
			
		
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("eZ.Matics");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Vector<JLabel> PausenX = new Vector<JLabel>(5,5);
		Vector<GridBagConstraints> GBC_X = new Vector<GridBagConstraints>(5,5);
		
		Vector<JLabel> PausenY = new Vector<JLabel>(5,5);
		Vector<GridBagConstraints> GBC_Y = new Vector<GridBagConstraints>(5,5);

		for (int i = 0; i == FrameChemieElementeVergleichen.anzahlAuswahlkriterien; i++) {
			
			PausenX.addElement(new JLabel("     "));
			GBC_X.addElement(new GridBagConstraints());
			GBC_X.elementAt(i).insets = new Insets(0, 0, 5, 5);
			GBC_X.elementAt(i).gridx = i+1;
			GBC_X.elementAt(i).gridy = 0;
			contentPane.add(PausenX.elementAt(i), GBC_X.elementAt(i));
		}
		
		for (int i = 0; i == FrameChemieElementeVergleichen.anzahlElemente; i++) {
			
			PausenY.addElement(new JLabel("     "));
			GBC_Y.addElement(new GridBagConstraints());
			GBC_Y.elementAt(i).insets = new Insets(0, 0, 5, 5);
			GBC_Y.elementAt(i).gridx = 0;
			GBC_Y.elementAt(i).gridy = i+1;
			contentPane.add(PausenY.elementAt(i), GBC_Y.elementAt(i));
		}
		

		

		
		Vector<JLabel> AuswahlKriterien = new Vector<JLabel>(5,5);
		Vector<GridBagConstraints> GBC1 = new Vector<GridBagConstraints>(5,5);
		
			for (int i = 0; i < FrameChemieElementeVergleichen.anzahlAuswahlkriterien; i++) {
				AuswahlKriterien.addElement(new JLabel(FrameChemieElementeVergleichen.arrayAuswahl[i]));
				
					GBC1.addElement(new GridBagConstraints());
					GBC1.elementAt(i).insets = new Insets(0, 0, 0, 0);
					GBC1.elementAt(i).gridx = i+1;
					GBC1.elementAt(i).gridy = 0;
					contentPane.add(AuswahlKriterien.elementAt(i), GBC1.elementAt(i));
			}
		
			
		Vector<JLabel> Elemente = new Vector<JLabel>(5,5);
		Vector<GridBagConstraints> GBC2 = new Vector<GridBagConstraints>(5,5);

			for (int i = 0; i < FrameChemieElementeVergleichen.anzahlElemente; i++) {
				Elemente.addElement(new JLabel(LibraryChemie.s[FrameChemieElementeVergleichen.arrayBs[i]][0]));
					
					GBC2.addElement(new GridBagConstraints());
					GBC2.elementAt(i).insets = new Insets(0, 0, 0, 0);
					GBC2.elementAt(i).gridx = 0;
					GBC2.elementAt(i).gridy = i+1;
					contentPane.add(Elemente.elementAt(i), GBC2.elementAt(i));		
			}
			
			int helper = 0;
		Vector<JLabel> Ergebnis = new Vector<JLabel>(50,5);
		Vector<GridBagConstraints> GBC3 = new Vector<GridBagConstraints>(5,5);

			for (int i = 0; i < FrameChemieElementeVergleichen.anzahlElemente; i++) {
				for (int j = 0; j < FrameChemieElementeVergleichen.anzahlAuswahlkriterien; j++) {
					
				Ergebnis.addElement(new JLabel(FrameChemieElementeVergleichen.multi[i][j]));
			
					GBC3.addElement(new GridBagConstraints());
					GBC3.elementAt(helper).insets = new Insets(0, 0, 0, 0);
					GBC3.elementAt(helper).gridx = j + 1;
					GBC3.elementAt(helper).gridy = i + 1;
					contentPane.add(Ergebnis.elementAt(helper), GBC3.elementAt(helper));
					helper++;
			}	
		
			}
		
		/*JLabel lblK_4 = new JLabel("k_4");
		GridBagConstraints gbc_lblK_4 = new GridBagConstraints();
		gbc_lblK_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblK_4.gridx = 0;
		gbc_lblK_4.gridy = 5;
		contentPane.add(lblK_4, gbc_lblK_4);
		*/

		
	}

}
