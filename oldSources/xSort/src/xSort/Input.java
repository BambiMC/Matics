package xSort;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Input extends JFrame {

	private JPanel contentPane;
	private JTextField tFpolygons;
	private JTextField tF_graphX;
	private JTextField tF_graphY;

	String[] comboBoxArray = new String[] { "InsertionSort" };
	private JTextField tFdelay;
	private JTextField tFtimeRun;
	private JTextField tFnumberRuns;
	int timeTrackerTemp;
	Boolean solved = false;
	private JTextField tFaverageTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input frame = new Input(null);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Input(Display disp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 20, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 5, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(comboBoxArray));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		contentPane.add(comboBox, gbc_comboBox);

		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblGeneral = new GridBagConstraints();
		gbc_lblGeneral.anchor = GridBagConstraints.WEST;
		gbc_lblGeneral.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeneral.gridx = 0;
		gbc_lblGeneral.gridy = 0;
		contentPane.add(lblGeneral, gbc_lblGeneral);

		JLabel lblTimeDelay = new JLabel("Time Delay between each step:");
		GridBagConstraints gbc_lblTimeDelay = new GridBagConstraints();
		gbc_lblTimeDelay.anchor = GridBagConstraints.WEST;
		gbc_lblTimeDelay.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeDelay.gridx = 0;
		gbc_lblTimeDelay.gridy = 7;
		contentPane.add(lblTimeDelay, gbc_lblTimeDelay);

		tFdelay = new JTextField();
		tFdelay.setText("10");
		GridBagConstraints gbc_tFdelay = new GridBagConstraints();
		gbc_tFdelay.insets = new Insets(0, 0, 5, 5);
		gbc_tFdelay.fill = GridBagConstraints.HORIZONTAL;
		gbc_tFdelay.gridx = 1;
		gbc_tFdelay.gridy = 7;
		contentPane.add(tFdelay, gbc_tFdelay);
		tFdelay.setColumns(10);

		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Create New Setup

				try {
					disp.newSetup(Integer.valueOf(tF_graphX.getText()), Integer.valueOf(tF_graphY.getText()),
							Integer.valueOf(tFpolygons.getText()), Integer.valueOf(tFdelay.getText()),
							comboBox.getSelectedItem().toString());
				} catch (NumberFormatException e) {
					System.out.println("wrong value in input");
					e.printStackTrace();
				}

			}
		});

		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.fill = GridBagConstraints.BOTH;
		gbc_btnApply.insets = new Insets(0, 0, 5, 0);
		gbc_btnApply.gridx = 3;
		gbc_btnApply.gridy = 8;
		contentPane.add(btnApply, gbc_btnApply);

		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(0, 1));
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 4;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 9;
		contentPane.add(separator_1, gbc_separator_1);

		JLabel lblOutput = new JLabel("Output");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.anchor = GridBagConstraints.WEST;
		gbc_lblOutput.insets = new Insets(0, 0, 5, 5);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 10;
		contentPane.add(lblOutput, gbc_lblOutput);

		JLabel lblTimeNeeded = new JLabel("Time Needed for last run: (in mcs)");
		GridBagConstraints gbc_lblTimeNeeded = new GridBagConstraints();
		gbc_lblTimeNeeded.anchor = GridBagConstraints.WEST;
		gbc_lblTimeNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimeNeeded.gridx = 0;
		gbc_lblTimeNeeded.gridy = 11;
		contentPane.add(lblTimeNeeded, gbc_lblTimeNeeded);

		tFtimeRun = new JTextField();
		GridBagConstraints gbc_tFtimeRun = new GridBagConstraints();
		gbc_tFtimeRun.insets = new Insets(0, 0, 5, 5);
		gbc_tFtimeRun.fill = GridBagConstraints.HORIZONTAL;
		gbc_tFtimeRun.gridx = 1;
		gbc_tFtimeRun.gridy = 11;
		contentPane.add(tFtimeRun, gbc_tFtimeRun);
		tFtimeRun.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(0, 1));
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_2.gridwidth = 4;
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 12;
		contentPane.add(separator_2, gbc_separator_2);

		JLabel lblBatchRun = new JLabel("Batch run");
		lblBatchRun.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblBatchRun = new GridBagConstraints();
		gbc_lblBatchRun.anchor = GridBagConstraints.WEST;
		gbc_lblBatchRun.insets = new Insets(0, 0, 5, 5);
		gbc_lblBatchRun.gridx = 0;
		gbc_lblBatchRun.gridy = 13;
		contentPane.add(lblBatchRun, gbc_lblBatchRun);

		JCheckBox boxEnabled = new JCheckBox("Enabled?");
		GridBagConstraints gbc_boxEnabled = new GridBagConstraints();
		gbc_boxEnabled.insets = new Insets(0, 0, 5, 5);
		gbc_boxEnabled.gridx = 1;
		gbc_boxEnabled.gridy = 13;
		contentPane.add(boxEnabled, gbc_boxEnabled);

		JLabel lblNumberOfRuns = new JLabel("Number of Runs:");
		GridBagConstraints gbc_lblNumberOfRuns = new GridBagConstraints();
		gbc_lblNumberOfRuns.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfRuns.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfRuns.gridx = 0;
		gbc_lblNumberOfRuns.gridy = 14;
		contentPane.add(lblNumberOfRuns, gbc_lblNumberOfRuns);

		tFnumberRuns = new JTextField();
		tFnumberRuns.setText("10");
		GridBagConstraints gbc_tFnumberRuns = new GridBagConstraints();
		gbc_tFnumberRuns.insets = new Insets(0, 0, 5, 5);
		gbc_tFnumberRuns.fill = GridBagConstraints.HORIZONTAL;
		gbc_tFnumberRuns.gridx = 1;
		gbc_tFnumberRuns.gridy = 14;
		contentPane.add(tFnumberRuns, gbc_tFnumberRuns);
		tFnumberRuns.setColumns(10);

		JLabel lblAverageTimein = new JLabel("Average time: (in mcs)");
		GridBagConstraints gbc_lblAverageTimein = new GridBagConstraints();
		gbc_lblAverageTimein.anchor = GridBagConstraints.WEST;
		gbc_lblAverageTimein.insets = new Insets(0, 0, 5, 5);
		gbc_lblAverageTimein.gridx = 0;
		gbc_lblAverageTimein.gridy = 15;
		contentPane.add(lblAverageTimein, gbc_lblAverageTimein);

		tFaverageTime = new JTextField();
		GridBagConstraints gbc_tFaverageTime = new GridBagConstraints();
		gbc_tFaverageTime.insets = new Insets(0, 0, 5, 5);
		gbc_tFaverageTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_tFaverageTime.gridx = 1;
		gbc_tFaverageTime.gridy = 15;
		contentPane.add(tFaverageTime, gbc_tFaverageTime);
		tFaverageTime.setColumns(10);

		JLabel lblGetOutputdata = new JLabel("Get Output-Data: (in mcs)");
		GridBagConstraints gbc_lblGetOutputdata = new GridBagConstraints();
		gbc_lblGetOutputdata.anchor = GridBagConstraints.WEST;
		gbc_lblGetOutputdata.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetOutputdata.gridx = 0;
		gbc_lblGetOutputdata.gridy = 16;
		contentPane.add(lblGetOutputdata, gbc_lblGetOutputdata);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 16;
		contentPane.add(scrollPane, gbc_scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JButton btnStart = new JButton("Start Algorithm");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (boxEnabled.isSelected()) {

					// BATCH

					int everyRun = 0;

					for (int i = 0; i < Integer.valueOf(tFnumberRuns.getText()); i++) {

						if (i == 0) {

							if (solved) {
								disp.newSetup(Integer.valueOf(tF_graphX.getText()),
										Integer.valueOf(tF_graphY.getText()), Integer.valueOf(tFpolygons.getText()),
										Integer.valueOf(tFdelay.getText()), comboBox.getSelectedItem().toString());
							}

							// Start Algorithm and set the "Time needed"-tF
							timeTrackerTemp = disp.Start();
							tFtimeRun.setText(Integer.toString(timeTrackerTemp));
							textPane.setText(Integer.toString(timeTrackerTemp));
							everyRun = timeTrackerTemp;
							tFaverageTime.setText(Integer.toString(everyRun / (i + 1)));

						} else {

							// Basically Create New Setup with same parameter, but check it anyway! :-)

							try {
								disp.newSetup(Integer.valueOf(tF_graphX.getText()),
										Integer.valueOf(tF_graphY.getText()), Integer.valueOf(tFpolygons.getText()),
										Integer.valueOf(tFdelay.getText()), comboBox.getSelectedItem().toString());
							} catch (NumberFormatException e1) {
								System.out.println("wrong value in input");
								e1.printStackTrace();
							}

							// Start Algorithm and set the "Time needed"-tF
							timeTrackerTemp = disp.Start();
							tFtimeRun.setText(Integer.toString(timeTrackerTemp));
							textPane.setText(textPane.getText() + "\n" + timeTrackerTemp);
							everyRun = everyRun + timeTrackerTemp;
							tFaverageTime.setText(Integer.toString(everyRun / (i + 1)));

						}

					}

				} else {

					// NO-BATCH

					if (solved) {
						disp.newSetup(Integer.valueOf(tF_graphX.getText()), Integer.valueOf(tF_graphY.getText()),
								Integer.valueOf(tFpolygons.getText()), Integer.valueOf(tFdelay.getText()),
								comboBox.getSelectedItem().toString());
					}

					// Start Algorithm and set the "Time needed"-tF
					timeTrackerTemp = disp.Start();
					tFtimeRun.setText(Integer.toString(timeTrackerTemp));
					solved = true;

				}

			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 1;
		contentPane.add(btnStart, gbc_btnStart);

		JButton btnEnd = new JButton("End Session");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// End Session
				System.exit(0);

			}
		});

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 1));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 4;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;

		contentPane.add(separator, gbc_separator);

		JLabel lblAdvanced = new JLabel("Advanced");
		lblAdvanced.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblAdvanced = new GridBagConstraints();
		gbc_lblAdvanced.anchor = GridBagConstraints.WEST;
		gbc_lblAdvanced.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdvanced.gridx = 0;
		gbc_lblAdvanced.gridy = 3;
		contentPane.add(lblAdvanced, gbc_lblAdvanced);

		JLabel lblNumberOfPolygons = new JLabel("Number of Polygons:");
		GridBagConstraints gbc_lblNumberOfPolygons = new GridBagConstraints();
		gbc_lblNumberOfPolygons.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfPolygons.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfPolygons.gridx = 0;
		gbc_lblNumberOfPolygons.gridy = 4;
		contentPane.add(lblNumberOfPolygons, gbc_lblNumberOfPolygons);

		tFpolygons = new JTextField();
		tFpolygons.setText("100");
		GridBagConstraints gbc_tFpolygons = new GridBagConstraints();
		gbc_tFpolygons.insets = new Insets(0, 0, 5, 5);
		gbc_tFpolygons.fill = GridBagConstraints.HORIZONTAL;
		gbc_tFpolygons.gridx = 1;
		gbc_tFpolygons.gridy = 4;
		contentPane.add(tFpolygons, gbc_tFpolygons);
		tFpolygons.setColumns(10);

		JLabel lblSetAlgorithm = new JLabel("Set Algorithm:");
		GridBagConstraints gbc_lblSetAlgorithm = new GridBagConstraints();
		gbc_lblSetAlgorithm.anchor = GridBagConstraints.WEST;
		gbc_lblSetAlgorithm.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetAlgorithm.gridx = 0;
		gbc_lblSetAlgorithm.gridy = 5;
		contentPane.add(lblSetAlgorithm, gbc_lblSetAlgorithm);

		JLabel lblGraphx = new JLabel("Graph (x * y):");
		GridBagConstraints gbc_lblGraphx = new GridBagConstraints();
		gbc_lblGraphx.anchor = GridBagConstraints.WEST;
		gbc_lblGraphx.insets = new Insets(0, 0, 5, 5);
		gbc_lblGraphx.gridx = 0;
		gbc_lblGraphx.gridy = 6;
		contentPane.add(lblGraphx, gbc_lblGraphx);

		tF_graphX = new JTextField();
		tF_graphX.setText("15");
		GridBagConstraints gbc_tF_graphX = new GridBagConstraints();
		gbc_tF_graphX.insets = new Insets(0, 0, 5, 5);
		gbc_tF_graphX.fill = GridBagConstraints.HORIZONTAL;
		gbc_tF_graphX.gridx = 1;
		gbc_tF_graphX.gridy = 6;
		contentPane.add(tF_graphX, gbc_tF_graphX);
		tF_graphX.setColumns(10);

		tF_graphY = new JTextField();
		tF_graphY.setText("500");
		GridBagConstraints gbc_tF_graphY = new GridBagConstraints();
		gbc_tF_graphY.insets = new Insets(0, 0, 5, 5);
		gbc_tF_graphY.fill = GridBagConstraints.HORIZONTAL;
		gbc_tF_graphY.gridx = 2;
		gbc_tF_graphY.gridy = 6;
		contentPane.add(tF_graphY, gbc_tF_graphY);
		tF_graphY.setColumns(10);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Basically Create New Setup with same parameter, but check it anyway! :-)

				try {
					disp.newSetup(Integer.valueOf(tF_graphX.getText()), Integer.valueOf(tF_graphY.getText()),
							Integer.valueOf(tFpolygons.getText()), Integer.valueOf(tFdelay.getText()),
							comboBox.getSelectedItem().toString());
					solved = false;
				} catch (NumberFormatException e) {
					System.out.println("wrong value in input");
					e.printStackTrace();
				}

			}
		});

		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 1;
		contentPane.add(btnReset, gbc_btnReset);
		GridBagConstraints gbc_btnEnd = new GridBagConstraints();
		gbc_btnEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEnd.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnd.gridx = 2;
		gbc_btnEnd.gridy = 1;
		contentPane.add(btnEnd, gbc_btnEnd);

		JLabel lblonlyBatch = new JLabel("(only batch)");
		GridBagConstraints gbc_lblonlyBatch = new GridBagConstraints();
		gbc_lblonlyBatch.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblonlyBatch.insets = new Insets(0, 0, 0, 5);
		gbc_lblonlyBatch.gridx = 0;
		gbc_lblonlyBatch.gridy = 17;
		contentPane.add(lblonlyBatch, gbc_lblonlyBatch);

	}

}
