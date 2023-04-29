package oldStuff;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class directoryChoose extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private Vector<File> v = new Vector<File>();
	//private File root = new File("");
	//private int x = 0, y = 2;
	Vector<JCheckBox> jcb = new Vector<JCheckBox>();
	Vector<GridBagConstraints> gbc = new Vector<GridBagConstraints>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					directoryChoose frame = new directoryChoose();
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
	public directoryChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDateipfadWhlen = new JLabel("Dateipfad W\u00E4hlen");
		lblDateipfadWhlen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDateipfadWhlen = new GridBagConstraints();
		gbc_lblDateipfadWhlen.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDateipfadWhlen.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateipfadWhlen.gridx = 0;
		gbc_lblDateipfadWhlen.gridy = 0;
		contentPane.add(lblDateipfadWhlen, gbc_lblDateipfadWhlen);
		
		JButton btnAnwenden = new JButton("Anwenden");
		GridBagConstraints gbc_btnAnwenden = new GridBagConstraints();
		gbc_btnAnwenden.anchor = GridBagConstraints.NORTH;
		gbc_btnAnwenden.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnwenden.gridx = 9;
		gbc_btnAnwenden.gridy = 0;
		contentPane.add(btnAnwenden, gbc_btnAnwenden);
		
		
		//dirChoose();
		
	}
	
	
	
	/*public void dirChooseRec(File rootfolder) {
		
		File[] fileArr = rootfolder.listFiles();
		int x = 0, y = 2;
		System.out.println(fileArr.length);
		//if() {
			
		//}

		
		for (int i = 0; i < fileArr.length; i++) {
			jcb.add(new JCheckBox(fileArr[i].getAbsolutePath()));
			gbc.add(new GridBagConstraints());
			gbc.elementAt(i).insets = new Insets(0, 0, 0, 5);
			gbc.elementAt(i).gridx = x;
			gbc.elementAt(i).gridy = y; y++;
			contentPane.add(jcb.elementAt(i), gbc.elementAt(i));
		}
		
		
		
	}
	
	public void dirChoose() {
		File root = new File("/");
		dirChooseRec(root);
	}
	
	public void infCheckCheckbox() {
		for (int i = 0; i == -1; i++) {
			
		}
	}*/
	

}
