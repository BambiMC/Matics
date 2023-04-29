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
import newVersion.frames.chemistry.FrameOrganicChemistry;

public class FrameChemistry {

	/**
	 * Create the panel.
	 */
	public static void Chemistry(JFrame f, String[] settings, LanguageInterface language, LookAndFeel laf, Font font, Font titleFont) {

		// init-Stuff
		JPanel p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));
		f.setContentPane(p);
		String[] lang = language.FrameChemistry();
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

		JButton buttonOrganicChemistry = new JButton(lang[1]);
		buttonOrganicChemistry.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameOrganicChemistry.OrganicChemistry(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonOrganicChemistry.setFont(font);
		p.add(buttonOrganicChemistry, "cell 0 1 2 1, width 200!");

		JButton buttonPeriodicTable = new JButton(lang[2]);
		buttonPeriodicTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});
		buttonPeriodicTable.setFont(font);
		p.add(buttonPeriodicTable, "cell 0 2 2 1, width 200!");

		JButton buttonCompareElements = new JButton(lang[3]);
		buttonCompareElements.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});
		buttonCompareElements.setFont(font);
		p.add(buttonCompareElements, "cell 0 3 2 1, width 200!");

		JButton buttonSalts = new JButton(lang[4]);
		buttonSalts.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});
		buttonSalts.setFont(font);
		p.add(buttonSalts, "cell 0 4 2 1, width 200!");

		/*
		 * 
		 * JButton buttonInfo = new JButton(lang[5]); buttonInfo.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * 
		 * } }); buttonInfo.setFont(font); p.add(buttonInfo, "cell 0 5 2 1, width 200!");
		 * 
		 * 
		 * 
		 * JButton buttonSett = new JButton(lang[6]); buttonSett.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * 
		 * } }); buttonSett.setFont(font); p.add(buttonSett, "cell 0 6 2 1, width 200!");
		 */

	}

}
