package libs;

import javax.swing.LookAndFeel;

import org.pushingpixels.substance.api.skin.SubstanceAutumnLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCeruleanLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeCoffeeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCremeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceDustCoffeeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceDustLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteChalkLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteElectricLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGoldLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteSiennaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteSunsetLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMagellanLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMarinerLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMistSilverLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNebulaAmethystLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNebulaBrickWallLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNightShadeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceRavenLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceSaharaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceSentinelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceTwilightLookAndFeel;
import org.pushingpixels.substance.extras.api.skinpack.SubstanceOfficeBlack2007LookAndFeel;
import org.pushingpixels.substance.extras.api.skinpack.SubstanceOfficeBlue2007LookAndFeel;
import org.pushingpixels.substance.extras.api.skinpack.SubstanceOfficeSilver2007LookAndFeel;

public class ThemeMaster{
	
	
	
	public static LookAndFeel getTheme(String settings) {
		
		LookAndFeel laf;
		
		switch (settings) {
		case "0":
			laf = new SubstanceBusinessLookAndFeel();
			break;
			
		case "1":
			laf = new SubstanceBusinessBlueSteelLookAndFeel();
			break;
			
		case "2":
			laf = new SubstanceBusinessBlackSteelLookAndFeel();
			break;
			
		case "3":
			laf = new SubstanceCremeLookAndFeel();
			break;
			
		case "4":
			laf = new SubstanceCremeCoffeeLookAndFeel();
			break;
			
		case "5":
			laf = new SubstanceSaharaLookAndFeel();
			break;
			
		case "6":
			laf = new SubstanceModerateLookAndFeel();
			break;
			
		case "7":
			laf = new SubstanceNebulaLookAndFeel();
			break;
			
		case "8":
			laf = new SubstanceNebulaAmethystLookAndFeel();
			break;
			
		case "9":
			laf = new SubstanceNebulaBrickWallLookAndFeel();
			break;
			
		case "10":
			laf = new SubstanceAutumnLookAndFeel();
			break;
			
		case "11":
			laf = new SubstanceMistSilverLookAndFeel();
			break;
			
		case "12":
			laf = new SubstanceMistAquaLookAndFeel();
			break;
			
		case "13":
			laf = new SubstanceDustLookAndFeel();
			break;
			
		case "14":
			laf = new SubstanceDustCoffeeLookAndFeel();
			break;
			
		case "15":
			laf = new SubstanceGeminiLookAndFeel();
			break;
			
		case "16":
			laf = new SubstanceMarinerLookAndFeel();
			break;
			
		case "17":
			laf = new SubstanceSentinelLookAndFeel();
			break;
			
		case "18":
			laf = new SubstanceCeruleanLookAndFeel();
			break;
			
		case "19":
			laf = new SubstanceOfficeSilver2007LookAndFeel();
			break;
			
		case "20":
			laf = new SubstanceOfficeBlue2007LookAndFeel();
			break;
			
		case "21":
			laf = new SubstanceOfficeBlack2007LookAndFeel();
			break;
			
		case "22":
			laf = new SubstanceTwilightLookAndFeel();
			break;
			
		case "23":
			laf = new SubstanceNightShadeLookAndFeel();
			break;
			
		case "24":
			laf = new SubstanceMagellanLookAndFeel();
			break;
			
		case "25":
			laf = new SubstanceGraphiteLookAndFeel();
			break;
			
		case "26":
			laf = new SubstanceGraphiteChalkLookAndFeel();
			break;
			
		case "27":
			laf = new SubstanceGraphiteAquaLookAndFeel();
			break;
			
		case "28":
			laf = new SubstanceGraphiteElectricLookAndFeel();
			break;
			
		case "29":
			laf = new SubstanceGraphiteGoldLookAndFeel();
			break;
			
		case "30":
			laf = new SubstanceGraphiteSiennaLookAndFeel();
			break;
			
		case "31":
			laf = new SubstanceGraphiteSunsetLookAndFeel();
			break;
			
		case "32":
			laf = new SubstanceGraphiteGlassLookAndFeel();
			break;
			
		case "33":
			laf = new SubstanceRavenLookAndFeel();
			break;

			
			
			

		default:
			laf = null;
		}
		
		return laf;
	}
	

}
