package lang;

public class LangMaster {

	public static LanguageInterface getLangFromArray(String[] settings) {

		String languageString = settings[11];

		LanguageInterface language = null;

		// Sprachzuteilung
		if(languageString == "en") {

			language = new EN();

		} else if(languageString == "de") {

			language = new DE();

		}

		return language;

	}

}
