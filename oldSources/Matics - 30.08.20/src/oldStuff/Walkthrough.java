package oldStuff;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class Walkthrough extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Walkthrough() {
    super("Sample app");
    this.setLayout(new FlowLayout());
    this.add(new JButton("button"));
    this.add(new JCheckBox("check"));
    this.add(new JLabel("label"));

    this.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
    this.setSize(new Dimension(250, 80));
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);

    SwingUtilities.invokeLater(() -> {
        Walkthrough w = new Walkthrough();
        w.setVisible(true);
    });
  }
}