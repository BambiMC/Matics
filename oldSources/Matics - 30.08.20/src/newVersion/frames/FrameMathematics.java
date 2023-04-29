package newVersion.frames;

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
import newVersion.FrameStart;
import newVersion.frames.mathematics.FrameAlgebra;
import newVersion.frames.mathematics.FrameGeometry;
import newVersion.frames.mathematics.FrameStochastics;

public class FrameMathematics {

	/**
	 * Create the panel.
	 */
	public static void Mathematics(JFrame f, String[] settings, LanguageInterface language, LookAndFeel laf, Font font, Font titleFont) {

		// init-Stuff
		JPanel p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));
		f.setContentPane(p);
		String[] lang = language.FrameMathematics();
		String[] misc = language.FrameMisc();
		f.setVisible(true);

		// Content
		JButton buttonHier = new JButton(misc[0]);
		buttonHier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameStart.Start(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		p.add(buttonHier, "cell 0 0,width 30!,height 30!,gapy 4, aligny center");

		JLabel title = new JLabel(lang[0]);
		title.setFont(titleFont);
		p.add(title, "cell 1 0 2 1,gapy 0");

		JButton buttonAlgebra = new JButton(lang[1]);
		buttonAlgebra.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameAlgebra.Algebra(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonAlgebra.setFont(font);
		p.add(buttonAlgebra, "cell 0 1 2 1, width 200!");

		JButton buttonGeometry = new JButton(lang[2]);
		buttonGeometry.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameGeometry.Geometry(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonGeometry.setFont(font);
		p.add(buttonGeometry, "cell 0 2 2 1, width 200!");

		JButton buttonStochastics = new JButton(lang[3]);
		buttonStochastics.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameStochastics.Stochastics(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonStochastics.setFont(font);
		p.add(buttonStochastics, "cell 0 3 2 1, width 200!");

	}

}
