package oldStuff;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel;

public class WalkthroughCopy extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public WalkthroughCopy() {
    super("Sample app");
    this.setLayout(new FlowLayout());
    this.add(new JButton("button"));
    this.add(new JCheckBox("check"));
    this.add(new JLabel("label"));

    this.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
    this.setSize(new Dimension(250, 80));
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    /*
     * try {
     * UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
     * } catch (UnsupportedLookAndFeelException e) {
     * e.printStackTrace();
     * }
     */
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    SwingUtilities.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(new SubstanceGraphiteAquaLookAndFeel());
      } catch (Exception e) {
        System.out.println("Substance Graphite failed to initialize");
      }
      WalkthroughCopy w = new WalkthroughCopy();
      w.setVisible(true);
    });
  }
}