package libs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import lang.EN;
import lang.LanguageInterface;

public class FileUsefulMethods {

	String settingsFileName;
	File settingsFile;
	int exp;
	String[] lang;
	Boolean recHelp;
	int themesInstalled;

	private FileUsefulMethods(String settingsFileName, Boolean recHelp) {

		this.settingsFileName = settingsFileName;
		settingsFile = new File(settingsFileName);
		this.recHelp = recHelp;
		LanguageInterface language = new EN();
		lang = language.FileUsefulMethods();
		themesInstalled = 35;

	}

	/**
	 * @param recHelp please always insert false, otherwise there could be errors,
	 *                if the settingsFile is wrongly configured
	 * @return settingsArray with all the cleaned values
	 */
	public static String[] masterHelp(String settingsFileName, Boolean recHelp) {

		FileUsefulMethods fsm = new FileUsefulMethods("settingsFile.txt", recHelp);

		return fsm.master();

	}

	/**
	 * @param settingsFileName The name of the file that has to be read from
	 * @return settingsArray with all the cleaned values
	 */
	public static String[] master(String settingsFileName) {

		return masterHelp(settingsFileName, false);

	}

	private String[] master() {

		exp = 15;

		// SettingsFile neu erstellen, falls nicht vorhanden
		if (settingsFile.exists() != true) {

			try {

				// Datei nicht gefunden, wird versucht neu zu erstellen
				settingsFile.createNewFile();

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, lang[0]);

			}

			try {

				newConfiguration();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, lang[1]);

			}

		}

		// Arrays mit Standardwerten laden[speichern, Name, Pfad, NOT USED][java, bat,
		// txt]

		String[] settingsFileArray = null;
		String[] ausgabeArray = null;

		try {

			// Die Rohdaten aus der Datei erlangen
			settingsFileArray = readSettingsIntoArray(settingsFile);

		} catch (Exception e) {

			// konnte vermutlich nicht aus File lesen, vermutlich wegen unzureichender
			// Berechtigungen
			JOptionPane.showMessageDialog(null, lang[2]);

		}

		try {

			ausgabeArray = ReadSettingsFromLinesArray(settingsFileArray);

		} catch (Exception e) {

			// scheint nicht gescheit konfiguriert zu sein

			JOptionPane.showMessageDialog(null, e.getMessage());

			JOptionPane.showMessageDialog(null, lang[3]);

			// schlage Neukonfiguration vor
			if (recHelp == false) {

				if (JOptionPane.showConfirmDialog(null, lang[4]) == 0) {

					newConfiguration();

					return FileUsefulMethods.masterHelp(settingsFileName, true);

					// benutze tempor�re Standardkonfiguration
				} else {

					JOptionPane.showMessageDialog(null, lang[16]);
					ausgabeArray = getArrayDefaultValues();

				}

			} else {

				// Beginnende Endlosschleife abbrechen und Programm schlie�en, weil das Zeug
				// echt nicht geht
				JOptionPane.showMessageDialog(null, lang[5]);
				System.exit(0);

			}

		}

		return ausgabeArray;

	}

	private String[] getArrayDefaultValues() {

		String[] array = new String[exp];

		String s = settingsFile.getAbsolutePath();
		s = s.replaceAll(settingsFile.getName(), "");

		array[0] = "no";
		array[1] = "no";
		array[2] = "no";
		array[3] = "yes";
		array[4] = "no";
		array[5] = "java_ScriptFile";
		array[6] = "bat_ScriptFile";
		array[7] = "txt_ScriptFile";
		array[8] = s;
		array[9] = s;
		array[10] = s;
		array[11] = "en";
		array[12] = "23";
		array[13] = "theme";
		array[14] = "";

		return array;

	}

	private String[] getArrayDefaultNames() {

		String[] array = new String[exp];

		array[0] = "javaFileSave?[Yes/No]";
		array[1] = "batFileSave?[Yes/No]";
		array[2] = "txtFileSave?[Yes/No]";
		array[3] = "ActiveAnalysis?[Yes/No]";
		array[4] = "classFileSave?[Yes/No]";
		array[5] = "javaFileName";
		array[6] = "batFileName";
		array[7] = "txtFileName";
		array[8] = "javaFilePath";
		array[9] = "batFilePath";
		array[10] = "txtFilePath";
		array[11] = "Language";
		array[12] = "Theme[-1 -> 33]//TOD";
		array[13] = "TitleBar[theme/windows]";
		array[14] = "";

		return array;

	}

	private String[] ReadSettingsFromLinesArray(String[] array) throws Exception {

		// Clean up each line to get raw values
		for (int i = 0; i < array.length; i++) {

			StringBuilder sb = new StringBuilder(array[i]);
			int start = 0, end = 0;

			for (int k = 0; k < sb.length(); k++) {

				if (sb.charAt(k) == '=') {

					start = k + 1;

				}

				if (sb.charAt(k) == ';') {

					end = k;

				}

			}

			sb = new StringBuilder(sb.substring(start, end));
			array[i] = new StringBuilder(sb.toString().trim()).toString();

		}

		// Clean up each value individually
		for (int i = 0; i < exp; i++) {

			switch (i) {

				// Yes or No
				case 0, 1, 2, 3, 4: {

					if (array[i].toLowerCase().contains("yes")) {

						array[i] = "yes";

					} else if (array[i].toLowerCase().contains("no")) {

						array[i] = "no";

					} else {

						array[i] = "no";
						throw new Exception(lang[6] + array[i] + "  " + i);

					}

					break;

				}

				// Filenames
				case 5, 6, 7: {

					if (array[i].isEmpty()) {

						array[i] = "defaultFilename";
						throw new Exception(lang[7]);

					}

					break;

				}

				// Paths
				case 8, 9, 10: {

					Path path = Paths.get(array[i]);

					if (!Files.exists(path)) {

						array[i] = settingsFile.getAbsolutePath().replaceAll(settingsFile.getName(), "");
						throw new Exception(lang[8] + path);

					}

					break;

				}

				// Language
				case 11: {

					if (array[i].toLowerCase().contains("en")) {

						array[i] = "en";

					} else if (array[i].toLowerCase().contains("de")) {

						array[i] = "de";

					} else {

						array[i] = "en";
						throw new Exception(lang[9] + array[i]);

					}

					break;

				}

				// Theme
				case 12: {

					int themeNumber = 0;

					try {

						themeNumber = Integer.valueOf(array[i]);

					} catch (Exception e) {

						JOptionPane.showMessageDialog(null, lang[10] + array[i]);
						themeNumber = -1;

					}

					if (themeNumber >= themesInstalled - 1 && themeNumber < -1) {

						themeNumber = -1;
						throw new Exception(lang[11] + array[i]);

					}

					break;

				}

				// Titlebar
				case 13: {

					if (array[i].toLowerCase().contains("theme")) {

						array[i] = "theme";

					} else if (array[i].toLowerCase().contains("windows")) {

						array[i] = "windows";

					} else {

						array[i] = "theme";
						throw new Exception(lang[12] + array[i]);

					}

					break;

				}

				case 14: {

					break;

				}

				default:

					throw new Exception(lang[13]);

			}

		}

		return array;

	}

	private String[] readSettingsIntoArray(File settingsFile) {

		String[] array = null;
		FileReader fileReader;
		BufferedReader buffReader;

		// From File to Array
		try {

			array = new String[exp * 2];
			fileReader = new FileReader(settingsFile);
			buffReader = new BufferedReader(fileReader);

			for (int i = 0; i < exp; i++) {

				array[i] = buffReader.readLine();

			} // end for

			buffReader.close();
			fileReader.close();

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, lang[14]);

		}

		// Clean Up Array Values
		// Null-Zeilencheck und Behebung
		for (int i = 0; i < array.length; i++) {

			if (array[i] == null) {

				array[i] = "";

			}

		}

		// Clean Up Array Values
		Boolean runAgain = true;
		int lastElementRollover = -1;

		while (runAgain) {

			runAgain = false;

			for (int i = 0; i < array.length; i++) {

				if (array[i].isEmpty() && i > lastElementRollover) {

					for (int j = i; j < array.length - 1; j++) {

						array[j] = array[j + 1];

					}

					runAgain = true;
					lastElementRollover = i;

				}

			}

		}

		String[] arrayFinally = new String[exp];

		for (int i = 0; i < arrayFinally.length; i++) {

			arrayFinally[i] = array[i];

		}

		return arrayFinally;

	}

	private void newConfiguration() {

		String[] arrayDefaultNames = getArrayDefaultNames();
		String[] arrayValues = getArrayDefaultValues();
		StringBuilder sb = new StringBuilder("");

		// NewConfiguration
		for (int i = 0; i < exp; i++) {

			if (arrayDefaultNames[i] != "" && arrayValues[i] != "") {

				sb.append(arrayDefaultNames[i] + " = " + arrayValues[i] + ";" + System.getProperty("line.separator"));

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

			JOptionPane.showMessageDialog(null, lang[15] + System.getProperty("user.dir"));

		}

	}

}