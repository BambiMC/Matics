public class LibraryChemie {

	public static String[][] s = new String[118][10];
	public static int[][] i = new int[118][3];
	public static byte[][] b = new byte[118][2];
	public static double[][] d = new double[118][9];
	public static boolean[][] boo = new boolean[118][2];

	void initGerman() {
		s[0][0] = "Wasserstoff";
		s[0][1] = "H";
		s[0][2] = "-/-";
		s[0][3] = "Nichtmetall";
		s[0][4] = "farbloses Gas";
		s[0][5] = "gasf�rmig";
		s[0][6] = "-/-";
		s[0][7] = "https://de.wikipedia.org/wiki/Wasserstoff";
		s[0][8] = "-/-";
		s[0][9] = "Hydrogenium";
		s[1][0] = "Helium";
		s[1][1] = "He";
		s[1][2] = "Edelgas";
		s[1][3] = "Nichtmetall";
		s[1][4] = "Farbloses Gas";
		s[1][5] = "gasf�rmig";
		s[1][6] = "-/-";
		s[1][7] = "https://de.wikipedia.org/wiki/Helium";
		s[1][8] = "-/-";
		s[1][9] = "-/-";
		s[2][0] = "Lithium";
		s[2][1] = "Li";
		s[2][2] = "Alkalimetall";
		s[2][3] = "Metall";
		s[2][4] = "silbrig wei�/grau";
		s[2][5] = "fest";
		s[2][6] = "kubisch fl�chenzentriert";
		s[2][7] = "https://de.wikipedia.org/wiki/Lithium";
		s[2][8] = "-/-";
		s[2][9] = "Litium";
		s[3][0] = "Beryllium";
		s[3][1] = "Be";
		s[3][2] = "Erdalkalimetall";
		s[3][3] = "Metall";
		s[3][4] = "wei�-grau metallisch";
		s[3][5] = "fest";
		s[3][6] = "hexagonal";
		s[3][7] = "https://de.wikipedia.org/wiki/Beryllium";
		s[3][8] = "-/-";
		s[3][9] = "Berillium";
		s[4][0] = "Bor";
		s[4][1] = "B";
		s[4][2] = "-/-";
		s[4][3] = "Halbmetall";
		s[4][4] = "schwarz";
		s[4][5] = "fest";
		s[4][6] = "rhomboedrisch";
		s[4][7] = "https://de.wikipedia.org/wiki/Bor";
		s[4][8] = "-/-";
		s[4][9] = "-/-";
		s[5][0] = "Kohlenstoff";
		s[5][1] = "C";
		s[5][2] = "-/-";
		s[5][3] = "Nichtmetall";
		s[5][4] = "Schwarz (Graphit), farblos (Diamant), gelbbraun (Lonsdaleit)";
		s[5][5] = "fest";
		s[5][6] = "2 verschiedene Modifikationen";
		s[5][7] = "https://de.wikipedia.org/wiki/Kohlenstoff";
		s[5][8] = "-/-";
		s[5][9] = "Carboneum";

		// int i [118][2]:
		i[0][0] = 1;
		i[0][1] = 0;
		i[0][2] = 1;
		i[1][0] = 2;
		i[1][1] = 2;
		i[1][2] = 2;
		i[2][0] = 3;
		i[2][1] = 4;
		i[2][2] = 1;
		i[3][0] = 4;
		i[3][1] = 5;
		i[3][2] = 2;
		i[4][0] = 5;
		i[4][1] = 6;
		i[4][2] = 3;
		i[5][0] = 6;
		i[5][1] = 6;
		i[5][2] = 4;

		// byte b [118][2]:
		b[0][0] = 1;
		b[0][1] = 1;
		b[1][0] = 18;
		b[1][1] = 1;
		b[2][0] = 1;
		b[2][1] = 2;
		b[3][0] = 2;
		b[3][1] = 2;
		b[4][0] = 13;
		b[4][1] = 2;
		b[5][0] = 14;
		b[5][1] = 2;

		// double d [118][9]:
		d[0][0] = 0;
		d[0][1] = 0;
		d[0][2] = 0.88;
		d[0][3] = 1.00794;
		d[0][4] = 13.5984;
		d[0][5] = 0.0736;
		d[0][6] = -259.14;
		d[0][7] = -252.87;
		d[0][8] = 2.2;
		d[1][0] = 0;
		d[1][1] = 0;
		d[1][2] = 0.0000004;
		d[1][3] = 4.002602;
		d[1][4] = 24.5874;
		d[1][5] = 0.176;
		d[1][6] = -273;
		d[1][7] = -268.93;
		d[1][8] = 5.2;
		d[2][0] = 0.6;
		d[2][1] = 0;
		d[2][2] = 0.006;
		d[2][3] = 6.941;
		d[2][4] = 5.3917;
		d[2][5] = 0.535;
		d[2][6] = 180.54;
		d[2][7] = 1347;
		d[2][8] = 0.98;
		d[3][0] = 5.5;
		d[3][1] = 0.00000485;
		d[3][2] = 0.0005;
		d[3][3] = 9.012182;
		d[3][4] = 9.3227;
		d[3][5] = 1.848;
		d[3][6] = 1278;
		d[3][7] = 2970;
		d[3][8] = 1.57;
		d[4][0] = 9.3;
		d[4][1] = 0.00000439;
		d[4][2] = 0.001;
		d[4][3] = 10.811;
		d[4][4] = 8.298;
		d[4][5] = 2.46;
		d[4][6] = 2079;
		d[4][7] = 2550;
		d[4][8] = 2.04;
		d[5][0] = 0.5;
		d[5][1] = 0.00000531;
		d[5][2] = 0.087;
		d[5][3] = 12.0107;
		d[5][4] = 11.2603;
		d[5][5] = 2.267;
		d[5][6] = 3550;
		d[5][7] = 4827;
		d[5][8] = 2.55;

		// boolean boo [118][2]:
		boo[0][0] = false;
		boo[0][1] = false;
		boo[1][0] = false;
		boo[1][1] = false;
		boo[2][0] = false;
		boo[2][1] = false;
		boo[3][0] = false;
		boo[3][1] = false;
		boo[4][0] = false;
		boo[4][1] = false;
		boo[5][0] = false;
		boo[5][1] = false;
	}

}