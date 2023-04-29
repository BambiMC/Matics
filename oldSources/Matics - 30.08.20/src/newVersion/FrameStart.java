package newVersion;

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
import newVersion.frames.FrameChemistry;
import newVersion.frames.FrameComputerScience;
import newVersion.frames.FrameMathematics;
import newVersion.frames.FramePhysics;
import newVersion.frames.FrameText;

public class FrameStart {

	/**
	 * Create the frame.
	 */
	public static void Start(JFrame f, String[] settings, LanguageInterface language, LookAndFeel laf, Font font, Font titleFont) {

		// init-Stuff
		JPanel p = new JPanel(new MigLayout("", "[][]", "[][][][][][]"));
		f.setContentPane(p);
		String[] lang = language.FrameStart();
		String[] misc = language.FrameMisc();
		f.setVisible(true);

		// Content

		JButton buttonHier = new JButton(misc[0]);
		buttonHier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});
		buttonHier.setVisible(false);
		p.add(buttonHier, "cell 0 0,width 30!,height 30!,gapy 4, aligny center");

		JLabel title = new JLabel(lang[0]);
		title.setFont(titleFont);
		p.add(title, "cell 1 0 2 1,gapy 0");

		JButton buttonMath = new JButton(lang[1]);
		buttonMath.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameMathematics.Mathematics(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonMath.setFont(font);
		p.add(buttonMath, "cell 0 1 2 1, width 200!");

		JButton buttonChem = new JButton(lang[2]);
		buttonChem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameChemistry.Chemistry(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonChem.setFont(font);
		p.add(buttonChem, "cell 0 2 2 1, width 200!");

		JButton buttonPhys = new JButton(lang[3]);
		buttonPhys.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FramePhysics.Physics(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonPhys.setFont(font);
		p.add(buttonPhys, "cell 0 3 2 1, width 200!");

		JButton buttonText = new JButton(lang[4]);
		buttonText.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameText.Text(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonText.setFont(font);
		p.add(buttonText, "cell 0 4 2 1, width 200!");

		JButton buttonComputerScience = new JButton(lang[5]);
		buttonComputerScience.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FrameComputerScience.ComputerScience(f, settings, language, laf, font, titleFont);
				f.revalidate();

			}

		});
		buttonComputerScience.setFont(font);
		p.add(buttonComputerScience, "cell 0 5 2 1, width 200!");

		JButton buttonSettings = new JButton(lang[6]);
		buttonSettings.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// FrameSettings.Settings(f, settings, language, laf, font, titleFont);
				// f.setVisible(false);
				ProgramTemplate programTemplate = new ProgramTemplate(f, settings, language, laf, font, titleFont);
				programTemplate.setVisible(true);

				// f.revalidate();

			}

		});
		buttonSettings.setFont(font);
		p.add(buttonSettings, "cell 0 6 2 1, width 200!");

		
		
	}

}
