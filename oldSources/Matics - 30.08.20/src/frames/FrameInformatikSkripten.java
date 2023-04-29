package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FrameInformatikSkripten extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JPasswordField passwordField;
	//private String text;
	String AreaText;
	JTextArea txtrrfnfmal;
	//Übergabeparameter in den Compiler-ANFANG
	boolean ActiveAnalysis;
	String[][] array3 = new String[3][3];
	
	//Übergabeparameter in den Compiler-ENDE

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FrameInformatikSkripten frame = new FrameInformatikSkripten();
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
	public FrameInformatikSkripten() {
		
		FrameInformatikSkriptenSettings frameInformatikSkriptenSettings = new FrameInformatikSkriptenSettings();
		frameInformatikSkriptenSettings.setVisible(false);

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 440);
		contentPane = new JPanel();

		//Dateipfad wählen
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File("."));
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setDialogTitle("Dateipfad wählen");
		
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 65, 65, 65, 65, 65, 65, 150, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{22, 25, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton button = new JButton("\u2261");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frameInformatikSkriptenSettings.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		contentPane.add(button, gbc_button);
		
		JLabel lblSkriptend = new JLabel("Skripteditor");
		lblSkriptend.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSkriptend = new GridBagConstraints();
		gbc_lblSkriptend.gridwidth = 2;
		gbc_lblSkriptend.insets = new Insets(0, 0, 5, 5);
		gbc_lblSkriptend.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSkriptend.gridx = 1;
		gbc_lblSkriptend.gridy = 0;
		contentPane.add(lblSkriptend, gbc_lblSkriptend);
		
		JButton btnWiederholen = new JButton("Wiederholen");
		btnWiederholen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuilder sb = new StringBuilder(txtrrfnfmal.getText());
				sb.append(" #r(\"\") ");
				txtrrfnfmal.setText(sb.toString());
				
				
			}
		});
		GridBagConstraints gbc_btnWiederholen = new GridBagConstraints();
		gbc_btnWiederholen.insets = new Insets(0, 0, 5, 5);
		gbc_btnWiederholen.gridx = 1;
		gbc_btnWiederholen.gridy = 1;
		contentPane.add(btnWiederholen, gbc_btnWiederholen);
		
		JButton btnZeilensprung = new JButton("ZeilenSprung");
		btnZeilensprung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuilder sb = new StringBuilder(txtrrfnfmal.getText());
				sb.append(" #j ");
				txtrrfnfmal.setText(sb.toString());
				
			}
		});
		GridBagConstraints gbc_btnZeilensprung = new GridBagConstraints();
		gbc_btnZeilensprung.insets = new Insets(0, 0, 5, 5);
		gbc_btnZeilensprung.gridx = 2;
		gbc_btnZeilensprung.gridy = 1;
		contentPane.add(btnZeilensprung, gbc_btnZeilensprung);
		
		JLabel lblPlatzFrNeue = new JLabel("Platz f\u00FCr neue Engine-Elemente");
		GridBagConstraints gbc_lblPlatzFrNeue = new GridBagConstraints();
		gbc_lblPlatzFrNeue.gridwidth = 4;
		gbc_lblPlatzFrNeue.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlatzFrNeue.gridx = 7;
		gbc_lblPlatzFrNeue.gridy = 1;
		contentPane.add(lblPlatzFrNeue, gbc_lblPlatzFrNeue);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		txtrrfnfmal = new JTextArea();
		txtrrfnfmal.setText("#r(5\"f\u00FCnfmal\") \"hey\" #j #r(7\"\u00A7\")");
		scrollPane.setViewportView(txtrrfnfmal);
		
		JButton btnOutput = new JButton("OutPut");
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String[] arr = new String[12];
				//String s = null;
				
				//Nur kommentiert, damit Error weg ist 220820
				//FileUsefulMethods fileUsefulMethods = new FileUsefulMethods(settingsFile);
				//Nur kommentiert, damit Error weg ist 220820
				//arr = FileUsefulMethods.master();
				
				
				//Nur kommentiert, damit Error weg ist 220820
				/*
				try {
					
					UsefulMethods us = new UsefulMethods();
					
					us.ScriptCompiler(txtrrfnfmal.getText(), UsefulMethods.StringToBoolean(arr[0][0]), UsefulMethods.StringToBoolean(arr[0][1]), UsefulMethods.StringToBoolean(arr[3][1]), UsefulMethods.StringToBoolean(arr[0][2]), arr[1][0], arr[1][1], arr[1][2], arr[2][0], arr[2][1], arr[2][2]);
					s = us.getAusgabe();
				
				
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("S:" + s);
				JOptionPane.showMessageDialog(null, s);
				*/
				
				
			}
		});
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showMessageDialog(null, "Bug! Please report this!");
				JOptionPane.showMessageDialog(null, "\nDEFSHIT:\nASpeicherOrt der settingsFile angeben lassen\n(java wird zu class Verzeichnis gespeichert!)Dem Benutzer java bat txt erklären(wo wird der scheiss normalerwweise erstellt?)(txt sollte für backup gespeichert werden)!\nWo kann man die einstellungen ändern/saven der einstellugnen???\nMehrere Ausgabemögl, (z.b. als cmd-fenster, buffered reader scheiss etc.)\nJava Umgebungsvariablen-Fehlerbehandlung\nSoll eine Textdatei mit den QuellCode erzeuegt werden (Checkbox einfÃ¼gen)\nmax lï¿½nge vong 1 #r her is dreistellig\n\nDer Output darf nicht in Klammern gesetzt werden, der Rest schon!\nFunktionsweise:\nText, der genau so ausgegeben werden soll, in \"\" schreiben!\nVariablendeklaration:\n\nMethoden:\nFï¿½r Methoden dï¿½rfen keine \"\" verwendet werden, sie werden!\nZeilensprung = #j\nWiederholen = #r(5)");
				//Muss noch gemacht werden!
				
				
			}
		});
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.insets = new Insets(0, 0, 5, 5);
		gbc_btnHelp.gridx = 8;
		gbc_btnHelp.gridy = 0;
		contentPane.add(btnHelp, gbc_btnHelp);
		
		JButton btnAnalyse = new JButton("Analyse");
		GridBagConstraints gbc_btnAnalyse = new GridBagConstraints();
		gbc_btnAnalyse.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnalyse.gridx = 9;
		gbc_btnAnalyse.gridy = 0;
		contentPane.add(btnAnalyse, gbc_btnAnalyse);
		GridBagConstraints gbc_btnOutput = new GridBagConstraints();
		gbc_btnOutput.insets = new Insets(0, 0, 5, 0);
		gbc_btnOutput.gridx = 10;
		gbc_btnOutput.gridy = 0;
		contentPane.add(btnOutput, gbc_btnOutput);
		
		
	}
	
}


