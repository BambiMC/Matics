package oldStuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileUsefulMethods {

	String settingsFileName;
	File settingsFile;
	int one, two;
	String[] lang;

	private FileUsefulMethods() {

		settingsFileName = "settingsFile.txt";
		settingsFile = new File(settingsFileName);
		// lang =

	}

	private FileUsefulMethods(String settingsFileName) {

		this.settingsFileName = settingsFileName;
		settingsFile = new File(settingsFileName);

	}

	public static String[] masterHelp() {

		FileUsefulMethods fsm = new FileUsefulMethods();

		return fsm.master();

	}

	public static String[] masterHelp(String settingsFileName) {

		FileUsefulMethods fsm = new FileUsefulMethods(settingsFileName);

		return fsm.master();

	}

	private String[] master() {

		one = 5;
		two = 3;

		// SettingsFile neu erstellen, falls nicht vorhanden
		if (settingsFile.exists() != true) {

			try {

				// Datei nicht gefunden, wird versucht neu zu erstellen
				settingsFile.createNewFile();

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null,
						"settingsFile wurde nicht gefunden, konnte aber auch nicht neu erstellt werden,\nvermutlich wegen unzureichender Berechtigungen");

			}

			try {

				newConfiguration();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "MORITZCHRIS_5"
						+ "Das Programm wurde seemingly das erste mal gestartet, file wurde erstellt, neukonfig fehlgeschlagen");

			}

		}

		// Arrays mit Standardwerten laden[speichern, Name, Pfad, NOT USED][java, bat,
		// txt]

		String[][] settingsFileArray = null;
		String[] ausgabeArray = null;

		try {

			// Die Rohdaten aus der Datei erlangen
			settingsFileArray = readSettingsIntoArray(settingsFile);

		} catch (Exception e) {

			// konnte vermutlich nicht aus File lesen, vermutlich wegen unzureichender
			// Berechtigungen
			JOptionPane.showMessageDialog(null,
					"konnte vermutlich nicht aus File lesen, vermutlich wegen unzureichender Berechtigungen");
			e.printStackTrace();

		}

		try {

			ausgabeArray = ReadSettingsFromLinesArray(settingsFileArray);

		} catch (Exception e) {

			// scheint nicht gescheit konfiguriert zu sein
			JOptionPane.showMessageDialog(null,
					"settingsFile ist falsch konfiguriert" /*
															 * , manuell fixen,\noder settingsFile neu konfigurieren\nUm
															 * das SettingsFile neu zu konfigurieren, einfach die Datei
															 * im Speicherort umbennen, l�schen, oder in einen anderen
															 * Ordner verschieben, \ndann wird automatisch ein neues
															 * Exemplar der Datei generiert, dass in jedem Fall
															 * funktionieren muss!"
															 */);

			e.printStackTrace();

			newConfiguration();
			JOptionPane.showMessageDialog(null, "MORITZCHRIS_4"
					+ "Programm hat hoffentlich ein neues settingsFile erstellt, schlie�t jetzt!\nBitte Programm nochmal starten, sollte jetzt funktionieren!");

		}

		return ausgabeArray;

	}

	private String[][] getArrayDefaultValues() {

		String[][] array = new String[one][two];

		String s = settingsFile.getAbsolutePath();
		s = s.replaceAll(settingsFile.getName(), "");

		array[0][0] = "No";
		array[0][1] = "No";
		array[0][2] = "No";
		array[1][0] = "java_SkriptDatei";
		array[1][1] = "bat_SkriptDatei";
		array[1][2] = "txt_SkriptDatei";
		array[2][0] = s;
		array[2][1] = s;
		array[2][2] = s;
		array[3][0] = "Yes";
		array[3][1] = "No";
		array[3][2] = "en";
		array[4][0] = "27";
		array[4][1] = "theme";
		array[4][2] = "";

		return array;

	}

	private String[][] getArrayDefaultNames() {

		String[][] array = new String[one][two];

		array[0][0] = "javaFileSave?[Yes/No]";
		array[0][1] = "batFileSave?[Yes/No]";
		array[0][2] = "txtFileSave?[Yes/No]";
		array[1][0] = "javaFileName";
		array[1][1] = "batFileName";
		array[1][2] = "txtFileName";
		array[2][0] = "javaFilePath";
		array[2][1] = "batFilePath";
		array[2][2] = "txtFilePath";
		array[3][0] = "ActiveAnalysis?[Yes/No]";
		array[3][1] = "classFileSave?[Yes/No]";
		array[3][2] = "Language";
		array[4][0] = "Theme[-1 -> 33]//TOD";
		array[4][1] = "TitleBar[theme/windows]";
		array[4][2] = "";

		return array;

	}

	private String[] ReadSettingsFromLinesArray(String[][] arr) throws Exception {

		String s = null;

		if (arr[0][0] == "") {

			JOptionPane.showMessageDialog(null, "MORITZCHRIS_14" + "Leeres File wird versucht zu bef�llen");
			throw new IllegalArgumentException("Leeres File wird vielleicht versucht zu bef�llen");

		}

		for (int i = 0; i < one; i++) {

			for (int j = 0; j < two; j++) {

				s = arr[i][j];

				if (s == null) {

					JOptionPane.showMessageDialog(null,
							"MORITZCHRIS" + "Zeile scheint zu fehlen, daher Neukonfiguration?");
					throw new IllegalArgumentException("Zeile scheint zu fehlen, daher Neukonfiguration?");

				}

				StringBuilder sb = new StringBuilder(s);

				int start = 0, ende = 0;

				for (int k = 0; k < sb.length(); k++) {

					if (sb.charAt(k) == '=') {

						start = k + 1;

					}

					if (sb.charAt(k) == ';') {

						ende = k;

					}

				}

				sb = new StringBuilder(sb.substring(start, ende));

				s = new StringBuilder(sb.toString().trim()).toString();

				if (i == 0) {// Soll das File gespeichert werden?

					if (s.contains("Yes") || s.contains("No")) {

						arr[i][j] = s;

					} else {

						JOptionPane.showMessageDialog(null, "MORITZCHRIS_6"
								+ "Ob die Datei gespeichert werden soll, muss im SettingsFile mit Yes oder No angegeben werden!");
						throw new IllegalArgumentException(
								"Ob die Datei gespeichert werden soll, muss im SettingsFile mit Yes oder No angegeben werden!");

					}

				} else if (i == 1) {// Das FileName

					arr[i][j] = s;

				} else if (i == 2) {// Der Path f�r das File

					File f = new File(s);

					if (f.isDirectory() == true) {

						arr[i][j] = s;

					} else {

						JOptionPane.showMessageDialog(null,
								"MORITZCHRIS_7" + "Angegebener Pfad(Nr. " + j + ") ist kein g�ltiger Pfad!=" + s);
						throw new IllegalArgumentException(
								"Angegebener Pfad(Nr. " + j + ") ist kein g�ltiger Pfad!=" + s);

					}

				} else if (i == 3) {

					switch (j) {

						case 0:
							arr[i][j] = s;
							break;

						case 1:
							if (s.contains("Yes") || s.contains("No")) {

								arr[i][j] = s;

							} else {

								JOptionPane.showMessageDialog(null, "MORITZCHRIS_8"
										+ "Ob die Datei gespeichert werden soll, muss im SettingsFile mit Yes oder No angegeben werden!(i = 3)");
								throw new IllegalArgumentException(
										"Ob die Datei gespeichert werden soll, muss im SettingsFile mit Yes oder No angegeben werden!(i = 3)");

							}
							break;

						case 2:
							if (s.contains("en")) {

								arr[i][j] = "en";

							} else if (s.contains("de")) {

								arr[i][j] = "de";

							} else {

								JOptionPane.showMessageDialog(null, "MORITZCHRIS_9"
										+ "Die Spracheinstellung kann nicht �bernommen werden, scheint falsch zu sein, bitte �berpr�fen");
								throw new IllegalArgumentException(
										"Die Spracheinstellung kann nicht �bernommen werden, scheint falsch zu sein, bitte �berpr�fen");

							}
							;
							break;

						default:
							JOptionPane.showMessageDialog(null, "MORITZCHRIS_10" + "DefaultFehler616");
							throw new IllegalArgumentException("DefaultFehler616");

					}

				} else if (i == 4) {

					switch (j) {

						case 0:

							arr[i][j] = Integer.toString(-1);
							int themeNumber = 0;

							try {

								themeNumber = Integer.valueOf(s);

							} catch (Exception e) {

								JOptionPane.showMessageDialog(null, "MORITZCHRIS_11"
										+ "Kann die Einstellung, welches Theme benutzt werden soll, nicht anwenden");
								throw new IllegalArgumentException(
										"Kann die Einstellung, welches Theme benutzt werden soll, nicht anwenden");

							}

							arr[i][j] = Integer.toString(themeNumber);
							break;

						case 1:

							if (s.contains("theme")) {

								arr[i][j] = "theme";

							} else if (s.contains("windows")) {

								arr[i][j] = "windows";

							} else {

								JOptionPane.showMessageDialog(null, "MORITZCHRIS_12"
										+ "Kann die Einstellung zur TitleBar nicht anwenden, bitte settingsFile checken");
								throw new IllegalArgumentException(
										"Kann die Einstellung zur TitleBar nicht anwenden, bitte settingsFile checken");

							}

							break;

						default:
							// throw new IllegalArgumentException("[4][2] ist nicht benutzt, kein Fehler");
							arr[i][j] = "";
							break;

					}

					arr[i][j] = s;

				} else {

					JOptionPane.showMessageDialog(null,
							"MORITZCHRIS_13" + "Interner Fehler, bitte melden(587 - FrameInformatikSkriptenSettings)");
					throw new IllegalArgumentException(
							"Interner Fehler, bitte melden(587 - FrameInformatikSkriptenSettings)");

				}

			}

		}

		// Fertig rausextrahiert, nun noch aus 2-dimensionalem Array ein 1-dimensionales
		// Array machen
		String[] ausgabeArray = new String[one * two];
		int EinsDimArrayZaehler = 0;

		for (int i = 0; i < one; i++) {

			for (int j = 0; j < two; j++) {

				ausgabeArray[EinsDimArrayZaehler] = arr[i][j];
				EinsDimArrayZaehler++;

			}

		}

		return ausgabeArray;

	}

	private String[][] readSettingsIntoArray(File settingsFile) throws Exception {

		String[][] array = null;

		try {

			array = new String[one][two];

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null,
					"MORITZCHRIS_2" + "kann kein BufferedReader oder String[][] array erstellen");

		}

		FileReader fileReader = new FileReader(settingsFile);
		BufferedReader buffReader = new BufferedReader(fileReader);

		// Open the file for reading
		try {

			// br = new BufferedReader(new FileReader(settingsFile));

			// Loop across the arguments
			for (int i = 0; i < one; i++) {

				for (int j = 0; j < two; j++) {

					array[i][j] = buffReader.readLine();

					// Null-Zeilencheck und Behebung
					if (array[i][j] == null) {

						array[i][j] = "";

					}

				} // end for

			} // end for

			buffReader.close();
			fileReader.close();

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Fehler beim Einlesen der Werte innerhalb der Datei");
			e.printStackTrace();

		}

		return array;

	}

	private void newConfiguration() {

		String[][] arrayDefaultNames = getArrayDefaultNames();

		String[][] arrayValues = getArrayDefaultValues();

		StringBuilder sb = new StringBuilder("");

		// File settingsFile = new File("settingsFile.txt");

		// NewConfiguration
		for (int i = 0; i < one; i++) {

			for (int j = 0; j < two; j++) {

				if (arrayDefaultNames[i][j] != "" && arrayValues[i][j] != "") {

					sb.append(arrayDefaultNames[i][j] + " = " + arrayValues[i][j] + ";"
							+ System.getProperty("line.separator"));

				}

			}

		}

		FileWriter fileWriter;

		try {

			fileWriter = new FileWriter(settingsFile, false);// 2. Parameter, damit �berschrieben wird
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(sb.toString());
			bufferedWriter.close();
			fileWriter.close();

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null,
					"Creation of settingsFile failed in folder: " + System.getProperty("user.dir") + " failed");

		}

	}

}