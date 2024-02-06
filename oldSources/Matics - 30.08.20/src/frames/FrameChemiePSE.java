package frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import frames.FrameChemiePSE;

public class FrameChemiePSE extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChemiePSE frame = new FrameChemiePSE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame(s).
	 */

	public FrameChemiePSE() {
		setTitle("eZ.Matics");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1488, 641);

		JLabel lblPeriodensystemDerElemente = new JLabel("Periodensystem der Elemente");
		lblPeriodensystemDerElemente.setFont(new Font("Tahoma", Font.PLAIN, 22));

		// Launcht das NebenFrame
		FrameChemiePSEDatenblattSuchen frameChemiePSEDatenblattSuchen = new FrameChemiePSEDatenblattSuchen();
		frameChemiePSEDatenblattSuchen.setVisible(true);

		// Launcht die ganzen PSEButtons
		JButton btndH = new JButton("H");
		btndH.setBackground(Color.BLUE);
		btndH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"1", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btndH.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLi = new JButton("Li");
		btnLi.setBackground(Color.RED);
		btnLi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"3", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnLi.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNa = new JButton("Na");
		btnNa.setBackground(Color.RED);
		btnNa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"11", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnK = new JButton("K");
		btnK.setBackground(Color.RED);
		btnK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"19", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnK.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnRb = new JButton("Rb");
		btnRb.setBackground(Color.RED);
		btnRb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"37", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCs = new JButton("Cs");
		btnCs.setBackground(Color.RED);
		btnCs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"55", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCs.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnFr = new JButton("Fr");
		btnFr.setBackground(Color.RED);
		btnFr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"87", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnFr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnBe = new JButton("Be");
		btnBe.setBackground(new Color(255, 140, 0));
		btnBe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"4", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnBe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnMg = new JButton("Mg");
		btnMg.setBackground(new Color(255, 140, 0));
		btnMg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"12", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnMg.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCa = new JButton("Ca");
		btnCa.setBackground(new Color(255, 140, 0));
		btnCa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"20", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSc = new JButton("Sc");
		btnSc.setBackground(Color.YELLOW);
		btnSc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"21", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSc.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTi = new JButton("Ti");
		btnTi.setBackground(Color.YELLOW);
		btnTi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"22", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTi.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnV = new JButton("V");
		btnV.setBackground(Color.YELLOW);
		btnV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"23", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnV.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCr = new JButton("Cr");
		btnCr.setBackground(Color.YELLOW);
		btnCr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"24", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnMn = new JButton("Mn");
		btnMn.setBackground(Color.YELLOW);
		btnMn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"25", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnMn.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnFe = new JButton("Fe");
		btnFe.setBackground(Color.YELLOW);
		btnFe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"26", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnFe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCo = new JButton("Co");
		btnCo.setBackground(Color.YELLOW);
		btnCo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"27", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCo.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNi = new JButton("Ni");
		btnNi.setBackground(Color.YELLOW);
		btnNi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"28", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNi.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCu = new JButton("Cu");
		btnCu.setBackground(Color.YELLOW);
		btnCu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"29", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCu.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnZn = new JButton("Zn");
		btnZn.setBackground(Color.YELLOW);
		btnZn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"30", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnZn.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnGa = new JButton("Ga");
		btnGa.setBackground(new Color(238, 232, 170));
		btnGa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"31", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnGa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnGe = new JButton("Ge");
		btnGe.setBackground(Color.GRAY);
		btnGe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"32", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnGe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAl = new JButton("Al");
		btnAl.setBackground(new Color(238, 232, 170));
		btnAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"13", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAl.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnB = new JButton("B");
		btnB.setBackground(Color.GRAY);
		btnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"15", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnC = new JButton("C");
		btnC.setBackground(Color.BLUE);
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"6", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnN = new JButton("N");
		btnN.setBackground(Color.BLUE);
		btnN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"7", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnN.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnO = new JButton("O");
		btnO.setBackground(Color.BLUE);
		btnO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"8", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnO.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnF = new JButton("F");
		btnF.setBackground(Color.CYAN);
		btnF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"9", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnF.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNe = new JButton("Ne");
		btnNe.setBackground(Color.GREEN);
		btnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"10", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnHe = new JButton("He");
		btnHe.setBackground(Color.GREEN);
		btnHe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"2", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnHe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSr = new JButton("Sr");
		btnSr.setBackground(new Color(255, 140, 0));
		btnSr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"38", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnY = new JButton("Y");
		btnY.setBackground(Color.YELLOW);
		btnY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"39", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnY.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnZr = new JButton("Zr");
		btnZr.setBackground(Color.YELLOW);
		btnZr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"40", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnZr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNb = new JButton("Nb");
		btnNb.setBackground(Color.YELLOW);
		btnNb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"41", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnMo = new JButton("Mo");
		btnMo.setBackground(Color.YELLOW);
		btnMo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"42", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnMo.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTc = new JButton("Tc");
		btnTc.setBackground(Color.YELLOW);
		btnTc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"43", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTc.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnRu = new JButton("Ru");
		btnRu.setBackground(Color.YELLOW);
		btnRu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"44", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRu.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnRh = new JButton("Rh");
		btnRh.setBackground(Color.YELLOW);
		btnRh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"45", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRh.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPd = new JButton("Pd");
		btnPd.setBackground(Color.YELLOW);
		btnPd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"46", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPd.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAg = new JButton("Ag");
		btnAg.setBackground(Color.YELLOW);
		btnAg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"47", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAg.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCd = new JButton("Cd");
		btnCd.setBackground(Color.YELLOW);
		btnCd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"48", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCd.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnIn = new JButton("In");
		btnIn.setBackground(new Color(238, 232, 170));
		btnIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"49", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSn = new JButton("Sn");
		btnSn.setBackground(new Color(238, 232, 170));
		btnSn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"50", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSn.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSi = new JButton("Si");
		btnSi.setBackground(Color.GRAY);
		btnSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"14", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnP = new JButton("P");
		btnP.setBackground(Color.BLUE);
		btnP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"15", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnP.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnS = new JButton("S");
		btnS.setBackground(Color.BLUE);
		btnS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"16", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnS.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCl = new JButton("Cl");
		btnCl.setBackground(Color.CYAN);
		btnCl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"17", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCl.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAr = new JButton("Ar");
		btnAr.setBackground(Color.GREEN);
		btnAr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"18", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnKr = new JButton("Kr");
		btnKr.setBackground(Color.GREEN);
		btnKr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"36", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnKr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnXe = new JButton("Xe");
		btnXe.setBackground(Color.GREEN);
		btnXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"54", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnXe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnRn = new JButton("Rn");
		btnRn.setBackground(Color.GREEN);
		btnRn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"86", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRn.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAs = new JButton("As");
		btnAs.setBackground(Color.GRAY);
		btnAs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"33", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAs.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSe = new JButton("Se");
		btnSe.setBackground(Color.BLUE);
		btnSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"34", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnBr = new JButton("Br");
		btnBr.setBackground(Color.CYAN);
		btnBr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"35", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnBr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSb = new JButton("Sb");
		btnSb.setBackground(Color.GRAY);
		btnSb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"51", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTe = new JButton("Te");
		btnTe.setBackground(Color.GRAY);
		btnTe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"52", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnI = new JButton("I");
		btnI.setBackground(Color.CYAN);
		btnI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"53", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnI.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnBa = new JButton("Ba");
		btnBa.setBackground(new Color(255, 140, 0));
		btnBa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"56", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnBa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLalu = new JButton("La-Lu");
		btnLalu.setBackground(Color.PINK);
		btnLalu.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnRa = new JButton("Ra");
		btnRa.setBackground(new Color(255, 140, 0));
		btnRa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"88", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAclr = new JButton("Ac-Lr");
		btnAclr.setBackground(Color.MAGENTA);
		btnAclr.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnHf = new JButton("Hf");
		btnHf.setBackground(Color.YELLOW);
		btnHf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"72", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnHf.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnRf = new JButton("Rf");
		btnRf.setBackground(Color.YELLOW);
		btnRf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"104", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRf.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTa = new JButton("Ta");
		btnTa.setBackground(Color.YELLOW);
		btnTa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"73", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnDb = new JButton("Db");
		btnDb.setBackground(Color.YELLOW);
		btnDb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"105", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnDb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnW = new JButton("W");
		btnW.setBackground(Color.YELLOW);
		btnW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"74", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnW.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSg = new JButton("Sg");
		btnSg.setBackground(Color.YELLOW);
		btnSg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"106", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSg.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnRe = new JButton("Re");
		btnRe.setBackground(Color.YELLOW);
		btnRe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"75", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnBh = new JButton("Bh");
		btnBh.setBackground(Color.YELLOW);
		btnBh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"107", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnBh.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnOs = new JButton("Os");
		btnOs.setBackground(Color.YELLOW);
		btnOs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"76", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnOs.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnIr = new JButton("Ir");
		btnIr.setBackground(Color.YELLOW);
		btnIr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"77", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnIr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnHs = new JButton("Hs");
		btnHs.setBackground(Color.YELLOW);
		btnHs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"108", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnHs.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnMt = new JButton("Mt");
		btnMt.setBackground(Color.YELLOW);
		btnMt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"109", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnMt.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPt = new JButton("Pt");
		btnPt.setBackground(Color.YELLOW);
		btnPt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"78", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPt.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAu = new JButton("Au");
		btnAu.setBackground(Color.YELLOW);
		btnAu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"79", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAu.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnHg = new JButton("Hg");
		btnHg.setBackground(Color.YELLOW);
		btnHg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"80", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnHg.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTl = new JButton("Tl");
		btnTl.setBackground(new Color(238, 232, 170));
		btnTl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"81", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTl.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnDs = new JButton("Ds");
		btnDs.setBackground(Color.YELLOW);
		btnDs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"110", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnDs.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnRg = new JButton("Rg");
		btnRg.setBackground(Color.YELLOW);
		btnRg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"111", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnRg.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCn = new JButton("Cn");
		btnCn.setBackground(Color.YELLOW);
		btnCn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"112", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCn.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPb = new JButton("Pb");
		btnPb.setBackground(new Color(238, 232, 170));
		btnPb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"82", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnBi = new JButton("Bi");
		btnBi.setBackground(new Color(238, 232, 170));
		btnBi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"83", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnBi.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPo = new JButton("Po");
		btnPo.setBackground(Color.GRAY);
		btnPo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"84", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPo.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAt = new JButton("At");
		btnAt.setBackground(Color.CYAN);
		btnAt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"85", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAt.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnFl = new JButton("Fl");
		btnFl.setBackground(new Color(238, 232, 170));
		btnFl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"114", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnFl.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLv = new JButton("Lv");
		btnLv.setBackground(new Color(238, 232, 170));
		btnLv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"116", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnLv.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNh = new JButton("Nh");
		btnNh.setBackground(new Color(238, 232, 170));
		btnNh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"113", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNh.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnMc = new JButton("Mc");
		btnMc.setBackground(new Color(238, 232, 170));
		btnMc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"115", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnMc.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnOg = new JButton("Og");
		btnOg.setBackground(Color.GREEN);
		btnOg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"118", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnOg.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTs = new JButton("Ts");
		btnTs.setBackground(Color.CYAN);
		btnTs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"117", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTs.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLa = new JButton("La");
		btnLa.setBackground(Color.PINK);
		btnLa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"57", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnLa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAc = new JButton("Ac");
		btnAc.setBackground(Color.MAGENTA);
		btnAc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"89", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAc.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCe = new JButton("Ce");
		btnCe.setBackground(Color.PINK);
		btnCe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"58", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCe.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPr = new JButton("Pr");
		btnPr.setBackground(Color.PINK);
		btnPr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"59", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNd = new JButton("Nd");
		btnNd.setBackground(Color.PINK);
		btnNd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"60", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNd.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPm = new JButton("Pm");
		btnPm.setBackground(Color.PINK);
		btnPm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"61", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPm.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnSm = new JButton("Sm");
		btnSm.setBackground(Color.PINK);
		btnSm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"62", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnSm.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnEu = new JButton("Eu");
		btnEu.setBackground(Color.PINK);
		btnEu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"63", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnEu.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnGd = new JButton("Gd");
		btnGd.setBackground(Color.PINK);
		btnGd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"64", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnGd.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTb = new JButton("Tb");
		btnTb.setBackground(Color.PINK);
		btnTb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"65", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnDy = new JButton("Dy");
		btnDy.setBackground(Color.PINK);
		btnDy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"66", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnDy.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnHo = new JButton("Ho");
		btnHo.setBackground(Color.PINK);
		btnHo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"67", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnHo.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnEr = new JButton("Er");
		btnEr.setBackground(Color.PINK);
		btnEr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"68", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnEr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTm = new JButton("Tm");
		btnTm.setBackground(Color.PINK);
		btnTm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"69", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTm.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnYb = new JButton("Yb");
		btnYb.setBackground(Color.PINK);
		btnYb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"70", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnYb.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLu = new JButton("Lu");
		btnLu.setBackground(Color.PINK);
		btnLu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"71", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnTh = new JButton("Th");
		btnTh.setBackground(Color.MAGENTA);
		btnTh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"90", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnTh.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPa = new JButton("Pa");
		btnPa.setBackground(Color.MAGENTA);
		btnPa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"91", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPa.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnU = new JButton("U");
		btnU.setBackground(Color.MAGENTA);
		btnU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"92", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnU.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNp = new JButton("Np");
		btnNp.setBackground(Color.MAGENTA);
		btnNp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"93", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNp.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnPu = new JButton("Pu");
		btnPu.setBackground(Color.MAGENTA);
		btnPu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"94", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnPu.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnAm = new JButton("Am");
		btnAm.setBackground(Color.MAGENTA);
		btnAm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"95", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnAm.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCm = new JButton("Cm");
		btnCm.setBackground(Color.MAGENTA);
		btnCm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"96", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCm.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnBk = new JButton("Bk");
		btnBk.setBackground(Color.MAGENTA);
		btnBk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"97", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnBk.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCf = new JButton("Cf");
		btnCf.setBackground(Color.MAGENTA);
		btnCf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"98", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnCf.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnEs = new JButton("Es");
		btnEs.setBackground(Color.MAGENTA);
		btnEs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"99", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnEs.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLr = new JButton("Lr");
		btnLr.setBackground(Color.MAGENTA);
		btnLr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"103", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnLr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnMd = new JButton("Md");
		btnMd.setBackground(Color.MAGENTA);
		btnMd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"101", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnMd.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNo = new JButton("No");
		btnNo.setBackground(Color.MAGENTA);
		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"102", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnFm = new JButton("Fm");
		btnFm.setBackground(Color.MAGENTA);
		btnFm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameChemiePSEDatenblattAusgabe frameChemiePSEDatenblattAusgabe = new FrameChemiePSEDatenblattAusgabe(
						"100", getBounds().x + getBounds().width - 17, getBounds().y);
				frameChemiePSEDatenblattAusgabe.setVisible(true);
			}
		});
		btnFm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnFr, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnCs, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnRb, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnK, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnNa, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnLi, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
														.addComponent(btndH, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 74,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnRa, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnBa, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnSr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCa, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnMg, 0, 0, Short.MAX_VALUE)
														.addComponent(btnBe, GroupLayout.PREFERRED_SIZE, 74,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnAclr, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(btnLalu, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnY, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnSc, GroupLayout.PREFERRED_SIZE, 74,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(btnLa, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnAc, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnTh, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCe, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRf, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnHf, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnZr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnTi, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnPa, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(btnPr, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnDb, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnTa, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnNb, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnV, GroupLayout.DEFAULT_SIZE, 74,
																		Short.MAX_VALUE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnU, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnNd, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnSg, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnW, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(btnMo, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnCr, GroupLayout.DEFAULT_SIZE, 74,
																		Short.MAX_VALUE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnNp, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnPm, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnBh, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRe, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnTc, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnMn, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnPu, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnSm, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnHs, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnOs, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRu, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnFe, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnAm, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnEu, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnMt, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnIr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRh, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCo, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnCm, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnGd, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnDs, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnPt, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnPd, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnNi, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnBk, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnTb, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRg, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAu, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAg, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCu, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnCf, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnDy, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCn, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnHg, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCd, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnZn, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnEs, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnHo, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnNh, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnTl, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnIn, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnB, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAl, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnGa, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnFm, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnEr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnFl, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnPb, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnSi, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnSn, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnC, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnGe, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnMd, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnTm, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnMc, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnBi, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnSb, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAs, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnP, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnN, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnNo, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnYb, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnLv, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnPo, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addComponent(btnTe, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(btnSe, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnS, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnO, GroupLayout.DEFAULT_SIZE, 74,
																		Short.MAX_VALUE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnLr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnLu, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnTs, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAt, Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnI, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnBr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnCl, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnF, GroupLayout.DEFAULT_SIZE, 74,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnOg, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnRn, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnXe, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnKr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAr, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnHe, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnNe, GroupLayout.PREFERRED_SIZE, 74,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(469)
												.addComponent(lblPeriodensystemDerElemente, GroupLayout.PREFERRED_SIZE,
														303, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblPeriodensystemDerElemente, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnHe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btndH, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnO, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnN, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnB, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnBe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnLi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAr, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnCl, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnS, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnP, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnSi, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnMg, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
												.addComponent(btnAl, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
										.addComponent(btnNa, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBr, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnSe, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnAs, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnKr, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnGe, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnGa, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnZn, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnCu, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnNi, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnCo, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnFe, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnMn, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnCr, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnV, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnTi, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnSc, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 45,
												Short.MAX_VALUE)
										.addComponent(btnCa, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnK, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnI, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnTe, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnSb, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnXe, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnSn, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnIn, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnCd, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnAg, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnPd, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnRh, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnRu, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnTc, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnMo, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnNb, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnZr, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnY, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnSr, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnRb, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAt, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnPo, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnBi, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnPb, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnTl, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnHg, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnAu, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnPt, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnIr, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnOs, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnRe, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnW, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnTa, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnHf, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnLalu, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnBa, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnRn, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(btnCs, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnTs, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnOg, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnMc, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnNh, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnLv, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnFl, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnCn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnRg, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnDs, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnMt, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnHs, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnBh, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnSg, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnDb, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnRf, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnAclr, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnRa, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(btnFr, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
								.addGap(42)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnLu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnYb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnTm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnEr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnHo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnDy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnTb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnGd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnEu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnSm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnPm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnPr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnCe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnLa, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnFm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnMd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnLr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnEs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnCf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnBk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnCm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnAm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnPu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnU, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnPa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnTh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnAc, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
								.addGap(34)));
		getContentPane().setLayout(groupLayout);
	}
}
