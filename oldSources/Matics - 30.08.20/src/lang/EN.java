package lang;

public class EN implements LanguageInterface {

	@Override
	public String[] FrameAlgebra() {

		String[] s = new String[10];

		s[0] = "Algebra";
		s[1] = "binomial formulas";
		s[2] = "calculator";
		s[3] = "fractions";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameChemistry() {

		String[] s = new String[10];

		s[0] = "Chemistry";
		s[1] = "organic chem.";
		s[2] = "periodic table";
		s[3] = "compare elements";
		s[4] = "salts";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameComputerScience() {

		String[] s = new String[10];

		s[0] = "Computer Science";
		s[1] = "maticscript";
		s[2] = "sorting alg.";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameGeometry() {

		String[] s = new String[10];

		s[0] = "Geometry";
		s[1] = "";
		s[2] = "";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameMathematics() {

		String[] s = new String[10];

		s[0] = "Mathematics";
		s[1] = "algebra";
		s[2] = "geometry";
		s[3] = "stochastics";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameMisc() {

		String[] s = new String[10];

		s[0] = "\u2191";
		s[1] = "\u2305";
		s[2] = "settingsFile.txt";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameOrganicChemistry() {

		String[] s = new String[10];

		s[0] = "Organic Chemistry";
		s[1] = "";
		s[2] = "";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FramePhysics() {

		String[] s = new String[10];

		s[0] = "Physics";
		s[1] = "conversions";
		s[2] = "";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameStart() {

		String[] s = new String[10];

		s[0] = "Matics";
		s[1] = "mathematics";
		s[2] = "chemistry";
		s[3] = "physics";
		s[4] = "text";
		s[5] = "computer science";
		s[6] = "settings / support";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameStochastics() {

		String[] s = new String[10];

		s[0] = "Stochastics";
		s[1] = "";
		s[2] = "";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameText() {

		String[] s = new String[10];

		s[0] = "Text";
		s[1] = "compare text";
		s[2] = "find/replace";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FrameSettings() {

		String[] s = new String[10];

		s[0] = "";
		s[1] = "";
		s[2] = "";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

	@Override
	public String[] FileUsefulMethods() {

		String[] s = new String[20];

		s[0] = "settingsFile not found, also a new Instance couldnt be created\nCheck permissions";
		s[1] = "program was started the first time, new configuration failed\nCheck permissions";
		s[2] = "Couldnt read from file\nCheck permissions";
		s[3] = "settingsFile is wrongly configured";
		s[4] = "Do you want to create / override the wrongly configured settingsFile?";
		s[5] = "Complete Reconfig failed, Program will exit, cant seem to write to/read from settingsFile";
		s[6] = "Following argument could not be recognized as \"yes\" or \"no\": ";
		s[7] = "One of the filenames read from the settingsFile was praktikally empty";
		s[8] = "Following argument is not a valid path on this machine: ";
		s[9] = "Following language argument could not be recognized as a language: ";
		s[10] = "Following themeNumber could not be converted into a number: ";
		s[11] = "Following themeNumber is not a recognizable theme number(-1 --> 34): ";
		s[12] = "Following Titlebar argument could not be recognized as \"theme\" or \"windows\": ";
		s[13] = "too many argument lines in settingsFile, will just be ignored for now";
		s[14] = "Couldnt read from file,\nCheck permissions";
		s[15] = "Creation & newConfiguration of settingsFile failed in folder: ";
		s[16] = "The program will use a standard temporary configuration in this case";
		s[17] = "";
		s[18] = "";
		s[19] = "";

		return s;

	}

	@Override
	public String[] FrameFractions() {

		String[] s = new String[10];

		s[0] = "Fractions";
		s[1] = "";
		s[2] = "";
		s[3] = "";
		s[4] = "";
		s[5] = "";
		s[6] = "";
		s[7] = "";
		s[8] = "";
		s[9] = "";

		return s;

	}

}
