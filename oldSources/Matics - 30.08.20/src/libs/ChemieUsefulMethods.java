package libs;

public class ChemieUsefulMethods {
	
	public static int getElementZahl(String elementString) {
		
		boolean foundElement = false;
		int elementZahl = 118;
		LibraryChemie libraryChemie = new LibraryChemie();
		libraryChemie.initGerman();
		
		
		
		//Versuche direkt zur ElementZahl zu konvertieren
		
		try {
			
			elementZahl = Integer.parseInt(elementString);
			foundElement = true;
			
		} catch (Exception e) {
		}
		
		if(!foundElement) {
			
			//Suche nach perfektem Element
			
			//Eingabe modifizieren
			elementString = elementString.replace(" ", "");
			//zu UpperCamelCase modifizieren
			elementString = elementString.substring(0, 1).toUpperCase() + elementString.substring(1).toLowerCase();
			
			for(int i = 117; i >= 0; i--) {
				
				if(LibraryChemie.s[i][1].matches(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				} else if(LibraryChemie.s[i][0].matches(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				} else if(LibraryChemie.s[i][9].matches(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				}
				
			}
			
		}
		
		if(!foundElement) {
			
			//Suche nach nicht perfektem Element --> mit richtigem Anfang
			//bereits richtig konfiguriert von oben im UpperCamelCase
			
			for(int i = 117; i >= 0; i--) {
				
				if(LibraryChemie.s[i][1].contains(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				} else if(LibraryChemie.s[i][0].contains(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				} else if(LibraryChemie.s[i][9].contains(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				}
				
			}
			
		}
			
		if(!foundElement) {
			
			//Suche nach nicht perfektem Element --> ohne richtigen Anfang
			//Konfiguriere zu lowerCase
			elementString = elementString.toLowerCase();
			
			for(int i = 117; i >= 0; i--) {
				
				if(LibraryChemie.s[i][1].contains(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				} else if(LibraryChemie.s[i][0].contains(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				} else if(LibraryChemie.s[i][9].contains(elementString)) {
					elementZahl = i+1;
					foundElement = true;
				}
				
			}
		
		
		}
		return elementZahl;
	}	
	

	
	public static int getVorsilbenNumberToNumberSaeureAnzahl(String s) {
		
		//Mit Kommas den String in Arrays unterteilen
		    int counter = 0;
		    String strin;
		    
		    //Occurrence of Kommas in dem String
		    for (int i = 0; i < s.length(); i++) {
				strin = String.valueOf(s.charAt(i));
				//System.out.println("char :" + strin + "\ncounter :" + counter);
		    	if(strin.equals(",") == true) {
					counter++;
				}
			}
		if(counter != 0) {
			counter++;
		}
		return counter;
	}
		
	public static int[] getVorsilbenNumberToNumber(String s, int counter) {
		
		//Mit Kommas den String in Arrays unterteilen
		String eins = "test", zwei = "test";
		int einsINT = 0;
	
		
		//String[] ssSTR = new String[counter];
		int[] ssINT = new int[counter];
		
		//immer das      && i > 0    hinzufügen
		counter = 0;
		
		
		//String vorbereiten
		StringBuilder sb = new StringBuilder(s);
				sb.insert(0, "#");
				sb.insert(sb.length(), "##");
				//System.out.println("sb :" + sb);
		
		
		for (int i = 0; i < s.length(); i++) {
			
			
			String a = Character.toString(sb.charAt(i));
			
			if(a.equals(",") || a.equals("##") || (UsefulMethods.isNumbersThere(a) == false && i > 0)) {
				//System.out.println("Im ersten IF");
				if(UsefulMethods.isNumbersThere(sb.charAt(i-1)) == true && i > 1) {
					//System.out.println("Im zweiten IF");
					eins = String.valueOf(sb.charAt(i-1));
					if(UsefulMethods.isNumbersThere(sb.charAt(i-2)) == true) {
						//System.out.println("Im dritten IF");
						zwei = String.valueOf(sb.charAt(i-2));
						eins = zwei + eins;
						sb.deleteCharAt(i-2);
						sb.deleteCharAt(i-1);
						einsINT = Integer.parseInt(eins)-1;
						//System.out.println("zweistellig-einsINT :" + einsINT);
						ssINT[einsINT] = 1;			
					}else {
						sb.deleteCharAt(i-1);
						einsINT = Integer.parseInt(eins)-1;
						//System.out.println("einstellig-einsINT :" + einsINT);
						ssINT[einsINT] = 1;			
					}
				}
	
			}
		}
		return ssINT;
	}
	 	
	public static int getVorsilbenWordToNumber(String s) {
		
		int i = 0;
		
		if(s.contains("icos")) {
			i = 20;
		} else if(s.contains("nonadec")) {
			i = 19;
		} else if(s.contains("octadec")) {
			i = 18;
		} else if(s.contains("heptadec")) {
			i = 17;
		} else if(s.contains("hexadec")) {
			i = 16;
		} else if(s.contains("pentadec")) {
			i = 15;
		} else if(s.contains("tetradec")) {
			i = 14;
		} else if(s.contains("tridec")) {
			i = 13;
		} else if(s.contains("dodec")) {
			i = 12;
		} else if(s.contains("undec")) {
			i = 11;
		} else if(s.contains("dec")) {
			i = 10;
		} else if(s.contains("non")) {
			i = 9;
		} else if(s.contains("oct")) {
			i = 8;
		} else if(s.contains("hept")) {
			i = 7;
		} else if(s.contains("hex")) {
			i = 6;
		} else if(s.contains("pent")) {
			i = 5;
		} else if(s.contains("tetr")) {
			i = 4;
		} else if(s.contains("tri")) {
			i = 3;
		} else if(s.contains("di")) {
			i = 2;
		} else if(s.contains("mono") || s.contains("")) {
			//Still noch ein Flaschenhals, wenn mehr als 20 Säuren
			i = 1;
		}
		
		return i;
	}
	
	public static int AVcAnzahlFIND(String s) {
		int i = 0;
		
		if(s.contains("eicos")) {
			i = 20;
		}else if(s.contains("nonadec")) {
			i = 19;
		}else if(s.contains("octadec")) {
			i = 18;
		}else if(s.contains("heptadec")) {
			i = 17;
		}else if(s.contains("hexadec")) {
			i = 16;
		}else if(s.contains("pentadec")) {
			i = 15;
		}else if(s.contains("tetradec")) {
			i = 14;
		}else if(s.contains("tridec")) {
			i = 13;
		}else if(s.contains("dodec")) {
			i = 12;
		}else if(s.contains("undec")) {
			i = 11;
		}else if(s.contains("dec")) {
			i = 10;
		}else if(s.contains("non")) {
			i = 9;
		}else if(s.contains("oct")) {
			i = 8;
		}else if(s.contains("hept")) {
			i = 7;
		}else if(s.contains("hex")) {
			i = 6;
		}else if(s.contains("pent")) {
			i = 5;
		}else if(s.contains("but")) {
			i = 4;
		}else if(s.contains("prop")) {
			i = 3;
		}else if(s.contains("meth")) {
			i = 1;
		}else if(s.contains("eth")) {
			i = 2;
		}
		return i;
	}
	
		
	
}