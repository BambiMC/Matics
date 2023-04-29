package newVersion.frames.mathematics;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;

import lang.LanguageInterface;
import net.miginfocom.swing.MigLayout;
import newVersion.frames.FrameMathematics;
import newVersion.programs.mathematics.algebra.ProgramFractions;

public class FrameAlgebra {

	/**
	 * Create the panel.
	 */
	public static void Algebra(JFrame f, String[] settings, LanguageInterface language, LookAndFeel laf, Font font, Font titleFont) {

		// init-Stuff
		JPanel p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));
		f.setContentPane(p);
		String[] lang = language.FrameAlgebra();
		String[] misc = language.FrameMisc();
		f.setVisible(true);

		// Content

		JButton buttonHier = new JButton(misc[0]);
		buttonHier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameMathematics.Mathematics(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		p.add(buttonHier, "cell 0 0,width 30!,height 30!,gapy 4, aligny center");

		JLabel title = new JLabel(lang[0]);
		title.setFont(titleFont);
		p.add(title, "cell 1 0 2 1,gapy 0");

		JButton buttonBinom = new JButton(lang[1]);
		buttonBinom.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				f.revalidate();

			}

		});
		buttonBinom.setFont(font);
		p.add(buttonBinom, "cell 0 1 2 1, width 200!");

		JButton buttonCalc = new JButton(lang[2]);
		buttonCalc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				f.revalidate();

			}

		});
		buttonCalc.setFont(font);
		p.add(buttonCalc, "cell 0 2 2 1, width 200!");

		JButton buttonFrac = new JButton(lang[3]);
		buttonFrac.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ProgramFractions programFractions = new ProgramFractions(f, settings, language, laf, font, titleFont);
				programFractions.setVisible(true);

			}

		});
		buttonFrac.setFont(font);
		p.add(buttonFrac, "cell 0 3 2 1, width 200!");

	}

}
