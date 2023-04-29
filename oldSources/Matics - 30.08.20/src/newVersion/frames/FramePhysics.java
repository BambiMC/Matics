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

public class FramePhysics {

	/**
	 * Create the panel.
	 */
	public static void Physics(JFrame f, String[] settings, LanguageInterface language, LookAndFeel laf, Font font, Font titleFont) {

		// init-Stuff
		JPanel p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));
		f.setContentPane(p);
		String[] lang = language.FramePhysics();
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

		JButton buttonConversions = new JButton(lang[1]);
		buttonConversions.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});
		buttonConversions.setFont(font);
		p.add(buttonConversions, "cell 0 1 2 1, width 200!");

		/*
		 * JButton buttonChem = new JButton(lang[2]); buttonChem.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * 
		 * } }); buttonChem.setFont(font); p.add(buttonChem, "cell 0 2 2 1, width 200!");
		 * 
		 * 
		 * 
		 * JButton buttonPhys = new JButton(lang[3]); buttonPhys.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * 
		 * } }); buttonPhys.setFont(font); p.add(buttonPhys, "cell 0 3 2 1, width 200!");
		 * 
		 * 
		 * 
		 * JButton buttonText = new JButton(lang[4]); buttonText.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * 
		 * } }); buttonText.setFont(font); p.add(buttonText, "cell 0 4 2 1, width 200!");
		 * 
		 * 
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
