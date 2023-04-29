package oldStuff;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;

public class ThemeObject {

	JFrame f;
	JPanel p;
	
	
	String[] settings;
	String[] lang;
	
	LookAndFeel laf;
	
	public ThemeObject(JFrame f, JPanel p, String[] settings, String[] lang, LookAndFeel laf) {
		
		this.f = f;
		this.p = p;
		this.settings = settings;
		this.lang = lang;
		this.laf = laf;
		
	}
	
}
