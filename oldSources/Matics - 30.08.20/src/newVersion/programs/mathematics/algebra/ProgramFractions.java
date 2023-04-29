package newVersion.programs.mathematics.algebra;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.*;

import lang.LanguageInterface;
import net.miginfocom.swing.MigLayout;
import newVersion.FrameStart;

public class ProgramFractions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProgramFractions(JFrame f, String[] settings, LanguageInterface language, LookAndFeel laf, Font font, Font titleFont) {

		// init-Stuff
		JPanel p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));
		setContentPane(p);
		String[] lang = language.FrameFractions();
		String[] misc = language.FrameMisc();
		int x = 650, y = 400;

		setBounds(f.getX() + f.getWidth(), f.getY(), x, y);
		setTitle(lang[0]);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContentPane(p);

		// Content
		JButton buttonMenu = new JButton(misc[1]);
		buttonMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameStart.Start(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		p.add(buttonMenu, "cell 0 0,width 30!,height 30!,gapy 4, aligny center");

		JLabel title = new JLabel(lang[0]);
		title.setFont(titleFont);
		p.add(title, "cell 1 0 2 1");
		
		
		//Eigener Content

		JTextField j = new JTextField("s");
		
		
		
	}

}
