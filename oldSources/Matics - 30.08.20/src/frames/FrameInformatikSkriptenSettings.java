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
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import libs.FileUsefulMethods;

public class FrameInformatikSkriptenSettings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDateiname;
	private JTextField txtDateipfad;
	private JTextField txtDateiname_1;
	private JTextField txtDateiname_2;
	private JTextField txtDateipfad_1;
	private JTextField txtDateipfad_2;
	private JCheckBox chckbxSpeichern;
	private JCheckBox chckbxSpeichern_1;
	private JCheckBox chckbxSpeichern_2;
	private JCheckBox chckbxCodeanalyseKonstandLaufen;
	//private String[][] array = new String[4][3];
	//private String[][] array2 = new String[4][3];
	private String[][] array3 = new String[4][3];
	private String[][] array4 = new String[4][3];
	private BufferedWriter bufferedWriter;
	private JButton btnResetSettingsfile;
	private JButton btnAbbrechen;
	private JButton btnSpeichern;
	private JLabel lblClassDatei;
	private JCheckBox checkBox;
	
	File settingsFile;
	FileUsefulMethods fileUsefulMethods;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInformatikSkriptenSettings frame = new FrameInformatikSkriptenSettings();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
	public FrameInformatikSkriptenSettings() {
		
		//Neu geschrieben 2020 #CoronaTime		
		
		
		//fileUsefulMethods = new FileUsefulMethods();
		
		try {
			//String[] values = fileUsefulMethods.master();
		} catch (Exception e) {
			System.out.println("Irgendwas ist grundsätzlich schiefgelaufen, kann sein dass das Programm jetzt nicht funktioniert1");
		}
				
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 275, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSettings = new GridBagConstraints();
		gbc_lblSettings.insets = new Insets(0, 0, 5, 5);
		gbc_lblSettings.gridx = 0;
		gbc_lblSettings.gridy = 0;
		contentPane.add(lblSettings, gbc_lblSettings);
		
		JLabel label = new JLabel("    ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		contentPane.add(label, gbc_label);
		
		JLabel lblAllgemein = new JLabel("- Allgemein");
		lblAllgemein.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblAllgemein = new GridBagConstraints();
		gbc_lblAllgemein.anchor = GridBagConstraints.WEST;
		gbc_lblAllgemein.insets = new Insets(0, 0, 5, 5);
		gbc_lblAllgemein.gridx = 0;
		gbc_lblAllgemein.gridy = 2;
		contentPane.add(lblAllgemein, gbc_lblAllgemein);
		
		chckbxCodeanalyseKonstandLaufen = new JCheckBox("Code-Analyse konstand laufen lassen");
		chckbxCodeanalyseKonstandLaufen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxCodeanalyseKonstandLaufen = new GridBagConstraints();
		gbc_chckbxCodeanalyseKonstandLaufen.anchor = GridBagConstraints.WEST;
		gbc_chckbxCodeanalyseKonstandLaufen.gridwidth = 3;
		gbc_chckbxCodeanalyseKonstandLaufen.insets = new Insets(0, 20, 5, 5);
		gbc_chckbxCodeanalyseKonstandLaufen.gridx = 0;
		gbc_chckbxCodeanalyseKonstandLaufen.gridy = 3;
		contentPane.add(chckbxCodeanalyseKonstandLaufen, gbc_chckbxCodeanalyseKonstandLaufen);
		
		btnResetSettingsfile = new JButton("Reset settingsFile");
		btnResetSettingsfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Nur kommentiert, damit Error weg ist 220820
				//fileUsefulMethods.newConfiguration(fileUsefulMethods.getArrayDefaultValues());
				setSettingsInUI();
			}
		});
		GridBagConstraints gbc_btnResetSettingsfile = new GridBagConstraints();
		gbc_btnResetSettingsfile.insets = new Insets(0, 20, 5, 5);
		gbc_btnResetSettingsfile.gridx = 0;
		gbc_btnResetSettingsfile.gridy = 4;
		contentPane.add(btnResetSettingsfile, gbc_btnResetSettingsfile);
		
		JLabel lblDateiEinstellungen = new JLabel("- Datei Einstellungen");
		lblDateiEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDateiEinstellungen = new GridBagConstraints();
		gbc_lblDateiEinstellungen.anchor = GridBagConstraints.WEST;
		gbc_lblDateiEinstellungen.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateiEinstellungen.gridx = 0;
		gbc_lblDateiEinstellungen.gridy = 5;
		contentPane.add(lblDateiEinstellungen, gbc_lblDateiEinstellungen);
		
		JLabel lblJavaDatei = new JLabel(". java  Datei");
		GridBagConstraints gbc_lblJavaDatei = new GridBagConstraints();
		gbc_lblJavaDatei.insets = new Insets(0, 0, 5, 5);
		gbc_lblJavaDatei.gridx = 0;
		gbc_lblJavaDatei.gridy = 6;
		contentPane.add(lblJavaDatei, gbc_lblJavaDatei);
		
		chckbxSpeichern = new JCheckBox("Speichern?");
		GridBagConstraints gbc_chckbxSpeichern = new GridBagConstraints();
		gbc_chckbxSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSpeichern.gridx = 1;
		gbc_chckbxSpeichern.gridy = 6;
		contentPane.add(chckbxSpeichern, gbc_chckbxSpeichern);
		
		txtDateiname = new JTextField();
		txtDateiname.setText("Dateiname");
		GridBagConstraints gbc_txtDateiname = new GridBagConstraints();
		gbc_txtDateiname.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateiname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateiname.gridx = 2;
		gbc_txtDateiname.gridy = 6;
		contentPane.add(txtDateiname, gbc_txtDateiname);
		txtDateiname.setColumns(10);
		
		txtDateipfad = new JTextField();
		txtDateipfad.setText("Dateipfad");
		GridBagConstraints gbc_txtDateipfad = new GridBagConstraints();
		gbc_txtDateipfad.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateipfad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateipfad.gridx = 3;
		gbc_txtDateipfad.gridy = 6;
		contentPane.add(txtDateipfad, gbc_txtDateipfad);
		txtDateipfad.setColumns(10);
		
		JButton button = new JButton("..");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jFileChooser.showSaveDialog(null);
				array3[2][0] = jFileChooser.getSelectedFile().getAbsolutePath();
				txtDateipfad.setText(array3[2][0]);
				
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 4;
		gbc_button.gridy = 6;
		contentPane.add(button, gbc_button);
		
		JLabel lblBatDatei = new JLabel(". bat  Datei");
		GridBagConstraints gbc_lblBatDatei = new GridBagConstraints();
		gbc_lblBatDatei.insets = new Insets(0, 0, 5, 5);
		gbc_lblBatDatei.gridx = 0;
		gbc_lblBatDatei.gridy = 7;
		contentPane.add(lblBatDatei, gbc_lblBatDatei);
		
		chckbxSpeichern_1 = new JCheckBox("Speichern?");
		GridBagConstraints gbc_chckbxSpeichern_1 = new GridBagConstraints();
		gbc_chckbxSpeichern_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSpeichern_1.gridx = 1;
		gbc_chckbxSpeichern_1.gridy = 7;
		contentPane.add(chckbxSpeichern_1, gbc_chckbxSpeichern_1);
		
		txtDateiname_1 = new JTextField();
		txtDateiname_1.setText("Dateiname");
		GridBagConstraints gbc_txtDateiname_1 = new GridBagConstraints();
		gbc_txtDateiname_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateiname_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateiname_1.gridx = 2;
		gbc_txtDateiname_1.gridy = 7;
		contentPane.add(txtDateiname_1, gbc_txtDateiname_1);
		txtDateiname_1.setColumns(10);
		
		txtDateipfad_1 = new JTextField();
		txtDateipfad_1.setText("Dateipfad");
		GridBagConstraints gbc_txtDateipfad_1 = new GridBagConstraints();
		gbc_txtDateipfad_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateipfad_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateipfad_1.gridx = 3;
		gbc_txtDateipfad_1.gridy = 7;
		contentPane.add(txtDateipfad_1, gbc_txtDateipfad_1);
		txtDateipfad_1.setColumns(10);
		
		JButton button_1 = new JButton("..");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jFileChooser.showSaveDialog(null);
				array3[2][1] = jFileChooser.getSelectedFile().getAbsolutePath();
				txtDateipfad_1.setText(array3[2][1]);
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 7;
		contentPane.add(button_1, gbc_button_1);
		
		JLabel lblTxtDatei = new JLabel(". txt  Datei");
		GridBagConstraints gbc_lblTxtDatei = new GridBagConstraints();
		gbc_lblTxtDatei.insets = new Insets(0, 0, 5, 5);
		gbc_lblTxtDatei.gridx = 0;
		gbc_lblTxtDatei.gridy = 8;
		contentPane.add(lblTxtDatei, gbc_lblTxtDatei);
		
		chckbxSpeichern_2 = new JCheckBox("Speichern?");
		GridBagConstraints gbc_chckbxSpeichern_2 = new GridBagConstraints();
		gbc_chckbxSpeichern_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSpeichern_2.gridx = 1;
		gbc_chckbxSpeichern_2.gridy = 8;
		contentPane.add(chckbxSpeichern_2, gbc_chckbxSpeichern_2);
		
		txtDateiname_2 = new JTextField();
		txtDateiname_2.setText("Dateiname");
		GridBagConstraints gbc_txtDateiname_2 = new GridBagConstraints();
		gbc_txtDateiname_2.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateiname_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateiname_2.gridx = 2;
		gbc_txtDateiname_2.gridy = 8;
		contentPane.add(txtDateiname_2, gbc_txtDateiname_2);
		txtDateiname_2.setColumns(10);
		
		txtDateipfad_2 = new JTextField();
		txtDateipfad_2.setText("Dateipfad");
		GridBagConstraints gbc_txtDateipfad_2 = new GridBagConstraints();
		gbc_txtDateipfad_2.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateipfad_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateipfad_2.gridx = 3;
		gbc_txtDateipfad_2.gridy = 8;
		contentPane.add(txtDateipfad_2, gbc_txtDateipfad_2);
		txtDateipfad_2.setColumns(10);
		
		JButton button_2 = new JButton("..");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jFileChooser.showSaveDialog(null);
				array3[2][2] = jFileChooser.getSelectedFile().getAbsolutePath();
				txtDateipfad_2.setText(array3[2][2]);
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 8;
		contentPane.add(button_2, gbc_button_2);
		
		lblClassDatei = new JLabel(". class Datei");
		GridBagConstraints gbc_lblClassDatei = new GridBagConstraints();
		gbc_lblClassDatei.insets = new Insets(0, 0, 5, 5);
		gbc_lblClassDatei.gridx = 0;
		gbc_lblClassDatei.gridy = 9;
		contentPane.add(lblClassDatei, gbc_lblClassDatei);
		
		checkBox = new JCheckBox("Speichern?");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 9;
		contentPane.add(checkBox, gbc_checkBox);
		
		btnSpeichern = new JButton("\u00DCbernehmen");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//setVisible(false);
				
				//Settings in FrameInformatikSkripten übernehmen
				
				//array4 = againstNullPointerArray(array4);
				//array4 = arrayVervollständigen(array4);
				array4 = getInformationFromIO(array4);
				//array4 = againstNullPointerArray(array4);

				//Nur kommentiert, damit Error weg ist 220820
				//meth.newConfiguration(array4);
				
			}
		});
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				setSettingsInUI();
				
			}
		});
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.insets = new Insets(0, 0, 0, 5);
		gbc_btnAbbrechen.gridx = 1;
		gbc_btnAbbrechen.gridy = 11;
		contentPane.add(btnAbbrechen, gbc_btnAbbrechen);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.insets = new Insets(0, 0, 0, 5);
		gbc_btnSpeichern.gridx = 2;
		gbc_btnSpeichern.gridy = 11;
		contentPane.add(btnSpeichern, gbc_btnSpeichern);
		
		setSettingsInUI();

		
		
	//TestArea
		String[][] arr = new String[4][3];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = "";
			}
		}
		/*
		arr = getInformationFromIO(arr);
		
		System.out.println("409");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(arr[i][j]);
			}
		}*/
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				//Settings in FrameInformatikSkripten übernehmen
				//array4 = againstNullPointerArray(array4);
				//array4 = arrayVervollständigen(array4);
				array4 = getInformationFromIO(array4);
				//array4 = againstNullPointerArray(array4);
				
				//System.out.println("432");
				//for (int i = 0; i < 4; i++) {
				//for (int j = 0; j < 3; j++) {
				//System.out.println("lol" + array4[i][j]);
				//}
				//}
				
				//Nur kommentiert, damit Error weg ist 220820
				//meth.newConfiguration(array4);
				
				//Alle Objekte closen
				try {
					bufferedWriter.close();
					//bufferedReader.close();
					//fileReader.close();
					//fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				setVisible(false);
			}
		});
		

		
		
	}
	
	
	
	//externe Methode
	public String[][] getInformationFromIO(String[][] arr) {
		
		File f;

		if(chckbxSpeichern.isSelected() == true) {
			arr[0][0] = "Yes";
		} else {
			arr[0][0] = "No";
		}
		
		
		if(chckbxSpeichern_1.isSelected() == true) {
			arr[0][1] = "Yes";
		} else {
			arr[0][1] = "No";
		}
		if(chckbxSpeichern_2.isSelected() == true) {
			arr[0][2] = "Yes";
		} else {
			arr[0][2] = "No";
		}
		
		arr[1][0] = txtDateiname.getText();
		arr[1][1] = txtDateiname_1.getText();
		arr[1][2] = txtDateiname_2.getText();
		
		
		arr[2][0] = txtDateipfad.getText();
		f = new File(arr[2][0]);
		if(f.isDirectory() != true) {
			JOptionPane.showMessageDialog(null, "Fehler! -> getInformationIO = " + arr[2][0]);
		}
		arr[2][1] = txtDateipfad_1.getText();
		f = new File(arr[2][1]);
		if(f.isDirectory() != true) {
			JOptionPane.showMessageDialog(null, "Fehler! -> getInformationIO = " + arr[2][1]);
		}
		arr[2][2] = txtDateipfad_2.getText();
		f = new File(arr[2][2]);
		if(f.isDirectory() != true) {
			JOptionPane.showMessageDialog(null, "Fehler! -> getInformationIO = " + arr[2][2]);
		}
		
		
		if(chckbxCodeanalyseKonstandLaufen.isSelected() == true) {
			arr[3][0] = "Yes";
		} else {
			arr[3][0] = "No";
		}
		
		if(checkBox.isSelected() == true) {
			arr[3][1] = "Yes";
		} else {
			arr[3][1] = "No";
		}
		
		
		for(int i = 0; i > 4;i++) {
			for (int j = 0; j < 3; j++) {
				//System.out.println("896:" + arr[i][j]);
			}
		}

		
		return arr;
		
		
		
	}
	
	
	
	public void setSettingsInUI() {
		
		//Settings in das UI eintragen!
		String[][] array3 = new String[4][3];

		//array3 = arrayVervollständigen(array3);
		
		try {
			//Nur kommentiert, damit Error weg ist 220820
			//array3 = meth.readSettingsIntoArray(settingsFile);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Irgendwas ist grundsätzlich schiefgelaufen, kann sein dass das Programm jetzt nicht funktioniert2");
		}
		
		//array3 = ReadSettingsFromArrayXXX(array3);		
		//array3 = arrayVervollständigen(array3);
		
		
		txtDateiname.setText(array3[1][0]);
		txtDateiname_1.setText(array3[1][1]);
		txtDateiname_2.setText(array3[1][2]);
		txtDateipfad.setText(array3[2][0]);
		txtDateipfad_1.setText(array3[2][1]);
		txtDateipfad_2.setText(array3[2][2]);
		if(array3[0][0].contains("Yes")) {
			chckbxSpeichern.setSelected(true);
		} else if(array3[0][0].contains("No")){
			chckbxSpeichern.setSelected(false);
		} else {
			JOptionPane.showMessageDialog(null, "settingsFile falsch konfiguriert! array3[][] ist :" + array3[0][0] + ":");
		}
		if(array3[0][1].contains("Yes")) {
			chckbxSpeichern_1.setSelected(true);
		} else if(array3[0][1].contains("No")){
			chckbxSpeichern_1.setSelected(false);
		} else {
			JOptionPane.showMessageDialog(null, "settingsFile falsch konfiguriert! array3[][] ist :" + array3[0][1] + ":");
		}
		if(array3[0][2].contains("Yes")) {
			chckbxSpeichern_2.setSelected(true);
		} else if(array3[0][2].contains("No")){
			chckbxSpeichern_2.setSelected(false);
		} else {
			JOptionPane.showMessageDialog(null, "settingsFile falsch konfiguriert! array3[][] ist :" + array3[0][2] + ":");
		}
		
		if(array3[3][0].contains("Yes")) {
			chckbxCodeanalyseKonstandLaufen.setSelected(true);
		} else if(array3[3][0].contains("No")) {
			chckbxCodeanalyseKonstandLaufen.setSelected(false);
		} else {
			JOptionPane.showMessageDialog(null, "Interner Fehler");
		}

		if(array3[3][1].contains("Yes")) {
			checkBox.setSelected(true);
		} else if(array3[3][1].contains("No")) {
			checkBox.setSelected(false);
		} else {
			JOptionPane.showMessageDialog(null, "Interner Fehler2");
		}

		
		
	}
	

}


