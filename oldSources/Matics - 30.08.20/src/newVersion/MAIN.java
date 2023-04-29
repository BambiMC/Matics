package newVersion;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import lang.EN;
import lang.LangMaster;
import lang.LanguageInterface;
import libs.FileUsefulMethods;
import libs.ThemeMaster;
import net.miginfocom.swing.MigLayout;

public class MAIN extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// System.out.println("Test: " + System.getProperty("java.version"));
		// JOptionPane.showMessageDialog(null, "Test: " +
		// System.getProperty("java.version"));

		// Check Java Version
		if(System.getProperty("java.version").startsWith("1.") && !System.getProperty("java.version").startsWith("1.9")) {

			JOptionPane.showMessageDialog(null, "Bitte installiere\ndie neuste Java-Version (zurzeit Java SE 14)\nIch empfehle für Windows den \"Windows x64 Installer\" herunterzuladen!\nOder verwende einfach die Portable exe-Version, die mit einer eigenen Java JRE ausgestattet ist.");

			if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

				try {

					Desktop.getDesktop().browse(new URI("https://www.oracle.com/java/technologies/javase-jdk14-downloads.html"));

				} catch(Exception e) {

					e.printStackTrace();

				}

			}

		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					// ThemeEinbindung aus Javatechnischen Gründen vor der Erstellung des Fensters einleiten und festsetzen
					// get Array from settingsFile
					String[] settings = FileUsefulMethods.master(new EN().FrameMisc()[2]);

					// Theme-Einstellung
					LookAndFeel selected = ThemeMaster.getTheme(settings[12]);

					if(selected != null) {

						UIManager.setLookAndFeel(selected);

					} else {

						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					}

					// WindowsTitleBar-Einstellung
					if(settings[13] == "windows") {

						JFrame.setDefaultLookAndFeelDecorated(false);

					} else {

						JFrame.setDefaultLookAndFeelDecorated(true);

					}

					// Erstellung des Fensters
					MAIN frame = new MAIN();
					frame.setVisible(true);

				} catch(Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	/**
	 * Create the frame.
	 */
	public MAIN() {

		JPanel p;
		LanguageInterface language;
		String[] lang;
		String[] settings;

		// get Array from settingsFile
		settings = FileUsefulMethods.master(new EN().FrameMisc()[2]);

		// Theme-Speicherung zum Übergeben ins nächste Fenster
		LookAndFeel laf = ThemeMaster.getTheme(settings[12]);

		if(laf == null) {

			laf = UIManager.getLookAndFeel();

		}

		// Sprachen-Einstellung
		language = LangMaster.getLangFromArray(settings);
		lang = language.FrameStart();

		// setBounds and position of JFrame
		// to be determined
		int x = 300;
		int y = 400;

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		setBounds(gd.getDisplayMode().getWidth() / 2 - x / 2, gd.getDisplayMode().getHeight() / 2 - y / 2, x, y);
		p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));

		// Font and styling
		Font myFont = new Font("Segoe UI", Font.PLAIN, 20);
		Font myTitleFont = new Font("Segoe UI", Font.BOLD, 38);

		setTitle(lang[0]);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContentPane(p);

		FrameStart.Start(this, settings, language, laf, myFont, myTitleFont);

	}

}
