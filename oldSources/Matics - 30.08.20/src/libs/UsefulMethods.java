package libs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class UsefulMethods {
	
	int ProgressBarAdv;
	String Ausgabe;
	JProgressBar jProgressBar;
	
	
	public UsefulMethods() {
		ProgressBarAdv = 0;
		Ausgabe = "";
	}
	

	public String getAusgabe() {
		return Ausgabe;
	}
	public void setAusgabe(String neu) {
		Ausgabe = neu;
	}
	
	
	public int getProgressBarAdv() {
		return ProgressBarAdv;
	}
	public void setProgressBarAdv(int neu) {
		ProgressBarAdv = neu;
	}
	
	
	
	
	
	public static void SpezialElementNOT(int a) {
		switch (a) {
		case 119:{
			JOptionPane.showMessageDialog(null, "Wenn du Nichts eingibst, kannst du auch von der besten Software nichts wirklich Hilfreiches erwarten.");
			break;
		}
		case 120:{
			JOptionPane.showMessageDialog(null, "M8, das Leben is doch nicht Minecraft, echt jetzt?!? \nOkay als Belohnung dass du dieses Easter-Egg gefunden hast, haste hier nen Link: \nhttp://minecraft-de.gamepedia.com/Steinkohle");	
			break;	
		}
		case 121:{
			JOptionPane.showMessageDialog(null, "Wichtigster Grundsatz:\nNimm Eisen immer mit, braucht man immer, egal ob fï¿½r Spitzhacke, Amboss etc.\nAlso lieber direkt mitnehmen wenn man es in ner Hï¿½hle rumgammeln sieht\n- Bambi - Minecraft");
			break;
		}
		case 122:{
			JOptionPane.showMessageDialog(null, "Eigentlich ganz lustig:\nGold spawnt nur unwesentlich mehr als Dia, zumindest auf Hï¿½he 5-12\nBeweis:\nhttp://minecraft-de.gamepedia.com/Erz");
			break;
		}
		case 123:{
			JOptionPane.showMessageDialog(null, "Der heilige Gral, Die Dragon Lore unter den AWP, der Bugatti unter den Autos, wenn man es hat, ist man einfach Gott,\nzumindest in Minecraft");
			break;
		}	
		case 124:{
			JOptionPane.showMessageDialog(null, "Schon jemals nach Bluestone geschaut, wenn ja, hahaha, wenn nicht, Schau nach(Easteregg incoming)");
			break;
		}
		case 125:{
			JOptionPane.showMessageDialog(null, "Hat erst seit kurzem ne richtig wichtige Funktion, da die Angebote der Villager, die ja sehr oft Smaragde beinhalten,\nnun deutlich attraktiver geworden sind");	
			break;	
		}
		case 126:{
			JOptionPane.showMessageDialog(null, "Bis vor einigen Versionen noch unnï¿½tig, doch seit der 1.8 unverzichtbar beim Verzaubern");
			break;	
		}
		case 127:{
			JOptionPane.showMessageDialog(null, "Auch wenn es nicht gerade selten ist, und auf allen Hï¿½hen vorkommt, ist es das Erz, das wohl am gefï¿½hrlichsten scheint");
			break;
		}
		default:
			break;
		}
	}
	
public static boolean isNumbersThere(String s) {
	boolean boo;
	if(		s.contains("1") == true ||
			s.contains("2") == true ||
			s.contains("3") == true ||
			s.contains("4") == true ||
			s.contains("5") == true ||
			s.contains("6") == true ||
			s.contains("7") == true ||
			s.contains("8") == true ||
			s.contains("9") == true ||
			s.contains("0") == true) {
		boo = true;
	} else {
		boo = false;
	}
	return boo;
}

public static boolean isNumbersThere(char s) {
	boolean boo;
	if(		s == '1' ||
			s == '2' ||
			s == '3' ||
			s == '4' ||
			s == '5' ||
			s == '6' ||
			s == '7' ||
			s == '8' ||
			s == '9' ||
			s == '0') {
		boo = true;
	} else {
		boo = false;
	}
	return boo;
}

		


public static int getStringNumbersToIntNumbers(String s) {
	int i = 0;
	
	if(s.contains("20") == true) {
		i = 20;
	} else if(s.contains("19") == true) {
		i = 19;
	} else if(s.contains("18") == true) {
		i = 18;
	} else if(s.contains("17") == true) {
		i = 17;
	} else if(s.contains("16") == true) {
		i = 16;
	} else if(s.contains("15") == true) {
		i = 15;
	} else if(s.contains("14") == true) {
		i = 14;
	} else if(s.contains("13") == true) {
		i = 13;
	} else if(s.contains("12") == true) {
		i = 12;
	} else if(s.contains("11") == true) {
		i = 11;
	} else if(s.contains("10") == true) {
		i = 10;
	} else if(s.contains("9") == true) {
		i = 9;
	} else if(s.contains("8") == true) {
		i = 8;
	} else if(s.contains("7") == true) {
		i = 7;
	} else if(s.contains("6") == true) {
		i = 6;
	} else if(s.contains("5") == true) {
		i = 5;
	} else if(s.contains("4") == true) {
		i = 4;
	} else if(s.contains("3") == true) {
		i = 3;
	} else if(s.contains("2") == true) {
		i = 2;
	} else if(s.contains("1") == true) {
		i = 1;
	}
	
	return i;
}

public static boolean StringToBoolean(String s) {
	
	boolean boo = false;
	
	if(s.equalsIgnoreCase("Yes") || s.equalsIgnoreCase("Ja") || s.equalsIgnoreCase("True")) {
		boo = true;
	}else if(s.equalsIgnoreCase("No") || s.equalsIgnoreCase("Nein") || s.equalsIgnoreCase("False")){
		boo = false;
	} else {
		JOptionPane.showMessageDialog(null, "UsefulMethods.StringToBooleanFehler");
	}
	
	
	return boo;
}

public void ScriptCompiler(String tex, boolean Java_speicher, boolean bat_speicher, boolean class_speicher, boolean txt_speicher, String Java_Nam, String bat_Nam, String txt_Nam, String Java_w, String bat_w, String txt_w) throws IOException   {

	
	
	Thread t1 = new Thread() {
		  public void run()   {
			  try {
				

		    //SkriptBearbeitung
				  
				  

			   //TempVariables
			   int zaehler1 = 0;
			   StringBuilder sb = new StringBuilder(tex);
				

			   
				 String text = tex;
				 boolean Java_speichern = Java_speicher;
				 boolean bat_speichern = bat_speicher;
				 boolean class_speichern = class_speicher;
				 boolean txt_speichern = txt_speicher;
				 String Java_Name = Java_Nam;
				 String bat_Name = bat_Nam;
				 String txt_Name = txt_Nam;
				 String Java_wo = Java_w;
				 String bat_wo = bat_w;
				 String txt_wo = txt_w;
			   
			   
			   
			   //Variables
				String  JavaFile1 = Java_wo + "\\" + Java_Nam + ".java",  JavaFile2 = Java_wo + "\\" + Java_Name, AusgabeFile1 = txt_wo + "\\" + txt_Name + ".txt", AusgabeFile2 = txt_wo + "\\" + txt_Name, BatchFile1 = bat_wo + "\\" + bat_Name + ".bat", BatchFile2 = bat_wo + "\\" + bat_Name;
				int zaehlerdesjavafiles = 0,zaehlerdesausgabefiles = 0,zaehlerdesbatchfiles = 0;
				//int rI = 0, rII = 0;
				//String rString = "";
				File Javafilefile, Ausgabefilefile = null, Batchfilefile = null;
				//String filedestination, filedestination2, filedestination3;
				String Java_NameENT = Java_Name; 
				//String bat_NameENT = bat_Name, txt_NameENT = txt_Name, rückgabeString;
				//File settingsFile = new File("settingsFile.txt");
				

				
				

/*
			    //JProgressBar
			    JFrame frame = new JFrame();
			    //JPanel panel = new JPanel();
			    frame.setSize(360, 75);
			    frame.setTitle("Fortschritt der Berechnung");
			    //JProgressBar jProgressBar = new JProgressBar();
			    jProgressBar.setStringPainted(true);
			    
			    //JProgressBar - Anzeige updaten
			    //ProgressBarAdv = 0;
			    jProgressBar.setString("0% - Initialisierung der Anwendung");
			    jProgressBar.setValue(0);

			    frame.setLocationRelativeTo(null);
			    frame.add(jProgressBar);
			    frame.setVisible(true);
			    
			    
			    
			    
			    
			    */
			    
			    
			    
				//if Input = null!!
			    
			    	if(text == null || text == "") {
			    		JOptionPane.showMessageDialog(null, "Es wurde kein Text eingegeben!");
			    		text = "\"test\"";
			    	}
			    	
			    	if(Java_wo == null || Java_wo == "") {
			    		JOptionPane.showMessageDialog(null, "Es wurde kein Dateipfad für die Speicherung der Java-Datei angegeben");
			    		Java_wo = "C:\\Users\\fabia\\Dropbox\\EntwicklungsOrdner\\SimpleMatics\\";
			    	}

			    	if(bat_wo == null || bat_wo == "") {
			    		JOptionPane.showMessageDialog(null, "Es wurde kein Dateipfad für die Speicherung der bat-Datei angegeben");
			    		bat_wo = "C:\\Users\\fabia\\Dropbox\\EntwicklungsOrdner\\SimpleMatics\\";
			    	}
			    	
			    	if(txt_wo == null || txt_Name == "") {
			    		JOptionPane.showMessageDialog(null, "Es wurde kein Dateipfad für die Speicherung der txt-Datei angegeben");
			    		txt_wo = "C:\\Users\\fabia\\Dropbox\\EntwicklungsOrdner\\SimpleMatics\\";
			    	}
			    	
			    	if(Java_Name == null || Java_Name == "") {
			    		JOptionPane.showMessageDialog(null, "Es wurde kein Name für die Speicherung der Java-Datei angegeben");
			    		Java_Name = "Java_SkriptDatei";
			    	}
			    	
			    	if(bat_Name == null || bat_Name == "") {
			    		JOptionPane.showMessageDialog(null, "Es wurde kein Name für die Speicherung der bat-Datei angegeben");
			    		bat_Name = "Bat_SkriptDatei";
			    	}
			    	
			    	if(txt_Name == null || txt_Name == "") {
			    		JOptionPane.showMessageDialog(null, "Es wurde kein Name für die Speicherung der txt-Datei angegeben");
			    		txt_Name = "txt_SkriptDatei";
			    	}
			    	
			 
			        //JProgressBar - Anzeige updaten
			    	ProgressBarAdv = 5;
			        jProgressBar.setString("5% - Erstellung benötigter Dateien");
			        jProgressBar.setValue(5);

			        
			        
			    	
				//Javadatei erstellen(Duplikationen von Dateien vermeiden), um den String am Ende darin zu speichern-ANFANG

			    Vector<File> v = new Vector<File>();
			    v.add(new File(Java_wo + "\\" + Java_Name + ".java"));
			    
			    
			   /* while(v.elementAt(zaehlerdesjavafiles).exists() == true) {
			    	zaehlerdesjavafiles++;  
			    	if(zaehlerdesjavafiles == 0) {
			    		JavaFile1 = Java_Name + ".java";
			    	} else {
			    		JavaFile1 = Java_Name  + zaehlerdesjavafiles + ".java";
			    	}
			    	
			    	v.add(new File(JavaFile1));
			    	
			    }*/
			    
			    while(v.elementAt(zaehlerdesjavafiles).exists() == true) {
			    	zaehlerdesjavafiles++;  
			    	if(zaehlerdesjavafiles == 0) {
			    		if(Java_wo != "") {
			    			JavaFile1 = Java_wo + "\\" + Java_Name + ".java";
			    		} else {
			    			JavaFile1 = Java_Name + ".java";
			    		}
			    		
			    	} else {
			    		if(Java_wo != "") {
			    			JavaFile1 = Java_wo + "\\" + Java_Name  + zaehlerdesjavafiles + ".java";
			    		} else {
			    			JavaFile1 = Java_Name  + zaehlerdesjavafiles + ".java";
			    		}
			    		JavaFile1 = Java_wo + "\\" + Java_Name  + zaehlerdesjavafiles + ".java";
			    		Java_NameENT = Java_Name + zaehlerdesjavafiles;
			    	}
			    	
			    	v.add(new File(JavaFile1));
			    	
			    }
			    
			    Javafilefile = v.elementAt(zaehlerdesjavafiles);

			    //filedestination = Javafilefile.getAbsolutePath().replace("\\" + Java_Name, "");
			    
			    
			    JavaFile2 = JavaFile1.replace(".java", "");

				
			    //Javadatei erstellen(Duplikationen von Dateien vermeiden), um den String am Ende darin zu speichern-ENDE
				
			  //In ein File writen-ANFANG
			    FileWriter fw = new FileWriter(Javafilefile);
			    BufferedWriter bw = new BufferedWriter(fw);

			    System.out.println("1111111real ist der Dateiname mit Typ-Endung(JavaDatei) = " + JavaFile1 + "\r\n" + 
			    		"real2 ist der Dateiname ohne Typ-Endung(JavaDatei) = " + JavaFile2 + "\r\n" + 
			    		"real3 ist der Dateiname mit Typ-Endung(AusgabeDatei) = " + AusgabeFile1 + "\r\n" + 
			    		"real4 ist der Dateiname ohne Typ-Endung(AusgabeDatei) = " + AusgabeFile2 + 
			    		"\r\nreal5 ist der Dateiname mit Typ-Endung(BatchFile) = " + "" + 
			    		"\r\nreal6 ist der Dateiname ohne Typ-Endung(BatchFile) = " + "" + 
			    		"\n\nfile ist: " + Javafilefile + "\nfile2 ist: " + Ausgabefilefile);
			    //In ein File writen-ENDE
			    
			    
			    
			    //AusgabeDatei erstellen(Duplikationen von Dateien vermeiden), um den String darin zu speichern-ANFANG

			    Vector<File> v2 = new Vector<File>();
			    v2.add(new File(AusgabeFile1));
			    
			    
			    while(v2.elementAt(zaehlerdesausgabefiles).exists() == true) {
			    	
			    	
			    	zaehlerdesausgabefiles++;  
			    	if(zaehlerdesausgabefiles == 0) {
			    		AusgabeFile1 = txt_wo + "\\" + txt_Name + ".txt";
			    	} else {
			    		AusgabeFile1 = txt_wo + "\\" + txt_Name + zaehlerdesausgabefiles + ".txt";
			    		//txt_NameENT = txt_Name + zaehlerdesausgabefiles;
			    	}
			    	
			    	v2.add(new File(AusgabeFile1));
			    	
			    }
			    Ausgabefilefile = v2.elementAt(zaehlerdesausgabefiles);
			    //filedestination2 = Ausgabefilefile.getAbsolutePath().replace(AusgabeFile1, "");
			    
			    AusgabeFile2 = AusgabeFile1.replace(".txt", "");
				
			    //AusgabeDatei erstellen(Duplikationen von Dateien vermeiden), um den String darin zu speichern-ENDE

				
			    
			    if(System.getProperty("os.name") == "MAC OS"  ||	System.getProperty("os.name") == "MAC OS X" ) {
					JOptionPane.showMessageDialog(null, "Dein Betriebssystem (" + System.getProperty("os.name") +  ") wird noch nicht unterstützt!");
			    } else if (System.getProperty("os.name").contains("windows")  || System.getProperty("os.name").contains("Windows")){
			    	
			    	//Batch-Skript-Datei erstellen-ANFANG
			    	BatchFile1 = bat_wo + "\\" + bat_Name + "BatchSkript.bat";
			    	
			        Vector<File> v3 = new Vector<File>();
			        v3.add(new File(bat_wo + "\\" + bat_Name + ".bat"));
			            
			        while(v3.elementAt(zaehlerdesbatchfiles).exists() == true) {
			        		
			        	zaehlerdesbatchfiles++;  
			        	if(zaehlerdesbatchfiles == 0) {
			        		BatchFile1 = bat_wo + "\\" + bat_Name + ".bat";
			        	} else {
			        		BatchFile1 = bat_wo + "\\" + bat_Name + zaehlerdesbatchfiles + ".bat";
			        		//bat_NameENT = bat_Name + zaehlerdesbatchfiles;
			        	}
			        	v3.add(new File(BatchFile1));
			        }

			        Batchfilefile = v3.elementAt(zaehlerdesbatchfiles);
			        //filedestination3 = Batchfilefile.getAbsolutePath().replace(BatchFile1, "");
			        
			        BatchFile2 = BatchFile1.replace(".bat", "");
			    		
			        //Batch-Skript-Datei erstellen-ENDE

			    	
			    	
			    }

			    
			    
			    //JProgressBar - Anzeige updaten
			    ProgressBarAdv = 20;
			    jProgressBar.setString("20% - Ausführen des Internen Compilers");
			    jProgressBar.setValue(20);
			    
			//COMPILER-COMPILER-ANFANG
			//COMPILER-COMPILER-ANFANG
			//COMPILER-COMPILER-ANFANG
			//COMPILER-COMPILER-ANFANG
			//COMPILER-COMPILER-ANFANG        
			//COMPILER-COMPILER-ANFANG
			    
			    
			        
			       	
			    	
			       	
			       	
			//Dateiname zu Klassenname machen-ANFANG
			       if(JavaFile1.endsWith(".java")) {
			    	   //ÄNDERUNG
			    	   sb.insert(0, "public class " + Java_NameENT + "{\npublic static void main(String[] args) {\n");
			       }
			//Dateiname zu Klassenname machen-ENDE
			       
			       
			       
			       
			       
			       
			//Wdh-Schleife einbauen-ANFANG

			       
			       
			       

			       int StartForSchleife = 0;
			       boolean gefunden = false;
			       
			       while(StartForSchleife < sb.length()) {

			    	   if(sb.charAt(StartForSchleife) == '#') {

			    		   if(sb.charAt(StartForSchleife+1) == 'r') {

			    			   
			    			   //Leerzeichen rauslöschen
			    			   while(sb.charAt(StartForSchleife) == ' ')  {
			    				   sb.deleteCharAt(StartForSchleife+2);
			    			   }
			    			   while(sb.charAt(StartForSchleife+1) == ' ')  {
			    				   sb.deleteCharAt(StartForSchleife+2);
			    			   }
			    			   while(sb.charAt(StartForSchleife) == ' ')  {
			    				   sb.deleteCharAt(StartForSchleife+2);
			    			   }
			    			   //Leerzeichen rauslöschen
			    			   if(sb.charAt(StartForSchleife+2) == '(') {
			    				   gefunden = true;
			    			   }	
			    			   System.out.println("gefunden" + gefunden);
			    			   if(gefunden == true) {
			    		    	   sb = ScriptCompilerFor(sb, StartForSchleife+1);
			    			   		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			    			   	//gefunden = false;
			    		       }
			    		   }
			    	   }StartForSchleife++;
			       }
			       System.out.println("gef:" + gefunden);
			       System.out.println("sb:" + sb);
			       System.out.println("StartForSchleife:" + StartForSchleife);
			       
			//Wdh-Schleife einbauen-ENDE
			       
			       
			//Systemoutbefehl einbauen-ANFANG
			       	for (int i = 0; i < sb.length(); i++) {
			    	   
			       		if(sb.charAt(i) == '"') {
			       			if(zaehler1 == 0) { 
			       				sb.insert(i, "System.out.print(");
			       				i += 18;
			       				zaehler1 = 1;
			       			} else if(zaehler1 == 1) {
			       				sb.insert(i+1, ");\n");
			       				i = i + 2;
			       				zaehler1 = 0;
			       			}
			       		}
			    	   
			       	}
			//Systemoutbefehl einbauen-ENDE    
			       
			       
			       
			       
			       
			//Zeilensprung einbauen-ANFANG
			       boolean innenDrin = false;
			       
			       for (int i = 0; i < sb.length(); i++) {
			    	   
			    	   if(sb.charAt(i) == '"') {
			    		   if(innenDrin = false) {
			    			   innenDrin = true;
			    		   } else {
			    			   innenDrin = false;
			    		   }
			    	   }
			    	   
			    	   if(sb.charAt(i) == '#' && sb.charAt(i+1) == 'j') {
			    		   if(innenDrin == false) {
			    			   sb.replace(i, i+2,"System.out.println(" +  "\"" + "\\" + "n" + "\"" + ");");
			    		   }
			    	   }
			    	   
			       }
			//Zeilensprung einbauen-ENDE
			       
			       //Weitere Compiler-Eingaben...
			       
			   
			       
			       
			       
			       
			       //End-Klammern(2 Stück) einfügen
			       sb.append("\n}\n}");
			       
			       
			       
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			//COMPILER-COMPILER-ENDE
			       
			       
			       //JProgressBar - Anzeige updaten
			       ProgressBarAdv = 50;
			       jProgressBar.setString("50% - Vorbereitung für Java-Compiler");
			       jProgressBar.setValue(50);
			       
			       
			       
			//DOC-ANFANG

			       
			       //Muster für Dateierstellung: test.txt, test1.txt, test2.txt
			       
			       //1 = Mit Dateiendung, 2 = Ohne Dateiendung(=Klassenname)
			       
			       //real ist der Dateiname mit Typ-Endung(JavaDatei)
			       //real2 ist der Dateiname ohne Typ-Endung(JavaDatei)
			       //real3 ist der Dateiname mit Typ-Endung(AusgabeDatei)
			       //real4 ist der Dateiname ohne Typ-Endung(AusgabeDatei)
			       //real5 ist der Dateiname mit Typ-Endung(BatchFile)
			       //real6 ist der Dateiname ohne Typ-Endung(BatchFile)
			       
			       
			//DOC-ENDE


			       //Code in Java-Datei schreiben-ANFANG
			       System.out.println("Der Java-Code:\n" + sb.toString());
			       bw.write(sb.toString());
			       bw.close();
			       
			       //Code in Java-Datei schreiben-ENDE  
			       

			//OS getten
			        
			        if(System.getProperty("os.name") == "MAC OS"  ||	System.getProperty("os.name") == "MAC OS X" ) {
			        		
			        } else if (System.getProperty("os.name").contains("windows")  || System.getProperty("os.name").contains("Windows")){
			        		
			        	//In Batch writen-ANFANG
			            FileWriter fw3 = new FileWriter(Batchfilefile);
			            BufferedWriter bw3 = new BufferedWriter(fw3);
			            bw3.write("javac " + Javafilefile.getAbsolutePath() + " & "+ "cd " + Javafilefile.getParentFile() + " & " + "java " + Javafilefile.getName().replaceAll(".java", "")  + " > " + Ausgabefilefile.getAbsolutePath());
			            bw3.close();
			            //In Batch writen-ENDE
			            
			            
			            //JProgressBar - Anzeige updaten
			            ProgressBarAdv = 70;
			            jProgressBar.setString("70% - Ausführen des Java Compilers");
			            jProgressBar.setValue(70);
			            
			            //Von .txt zu .bat-ANFANG
			            //File file4 = new File(Batchfilefile.getName().replace(".txt", ".bat"));
			            //Batchfilefile.renameTo(file4);
			        	//Von .txt zu .bat-ENDE
			        	//System.out.println("pc222222222222");
			            //System.out.println(Batchfilefile.getAbsolutePath());
			            Process pc2 = Runtime.getRuntime().exec(Batchfilefile.getAbsolutePath());
			            try {
							pc2.waitFor();
				        	pc2.destroy();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

			        	
			        } else {
			        		JOptionPane.showMessageDialog(null, "Dieses OS wird noch nicht unterstützt!\nSorry dafür!\n Schreib mir doch einfach, welches OS du hast :-)");
			        }
			        
			        
			        //JProgressBar - Anzeige updaten
			        ProgressBarAdv = 90;
			        jProgressBar.setString("90% - Verarbeitung des Ergebnisses des Java-Compilers");
			        jProgressBar.setValue(90);
			        
			        
			        //Read from txtFile-ANFANG
			        
					InputStream is = null;
					
					try {
						is = new FileInputStream(Ausgabefilefile.getAbsolutePath());
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					}
					BufferedReader buf = new BufferedReader(new InputStreamReader(is));
					        
					int len = (int) Ausgabefilefile.length();
					char[] charArr = new char[len];
					buf.read(charArr);
					
			        //JProgressBar - Anzeige updaten
					ProgressBarAdv = 95;
			        jProgressBar.setString("95% - Abschließende Arbeit sowie Beendigung der Anwendung");
			        jProgressBar.setValue(95);
					
					
						//Array zu String-Anfang
			        	String Ausgabe = "";
						for (int i = 0; i < charArr.length; i++) {
							Ausgabe = Ausgabe + charArr[i];
						}
						//Array zu String-Ende
					
					buf.close();
					bw.close();
					fw.close();
					is.close();
					
					//Read from txtFile-ENDE
			        //JOptionPane.showMessageDialog(null, "vorher");
			        if(Java_speichern == false) {
			        	Javafilefile.delete();
			        }
			        if(bat_speichern == false) {
			        	Batchfilefile.delete();
			        }
			        if(txt_speichern == false) {
			        	Ausgabefilefile.delete();
			        	Ausgabefilefile.delete();
			        }
			        if(class_speichern == false) {
			        	File ftemp = new File(JavaFile2 + ".class");
			        	ftemp.delete();
			        }
			        //JOptionPane.showMessageDialog(null, "nachher");
			        
			//OS getten-ENDE    
			        
			        //JProgressBar - Anzeige updaten
			        ProgressBarAdv = 100;
			        jProgressBar.setString("100% - Fertig!");
			        jProgressBar.setValue(100);
			        

			        System.out.println("1111111real ist der Dateiname mit Typ-Endung(JavaDatei) = " + JavaFile1 + "\r\n" + 
			        		"real2 ist der Dateiname ohne Typ-Endung(JavaDatei) = " + JavaFile2 + "\r\n" + 
			        		"real3 ist der Dateiname mit Typ-Endung(AusgabeDatei) = " + AusgabeFile1 + "\r\n" + 
			        		"real4 ist der Dateiname ohne Typ-Endung(AusgabeDatei) = " + AusgabeFile2 + 
			        		"\r\nreal5 ist der Dateiname mit Typ-Endung(BatchFile) = " + BatchFile1 + 
			        		"\r\nreal6 ist der Dateiname ohne Typ-Endung(BatchFile) = " + BatchFile2 + 
			        		"\n\nfile ist: " + Javafilefile + "\nfile2 ist: " + Ausgabefilefile);
			        
			        //JProgressBar - Anzeige Beenden
			        //frame.setVisible(false);
			  
			} catch (Exception e) {
				
			}  
		  }

		  @SuppressWarnings("unused")
		protected void updatePBar(final int val) {
			    SwingUtilities.invokeLater(new Runnable() {
			      public void run() {
			    	  jProgressBar.setValue(val);
			      }
			    });
			  }
		  
		};
		t1.start();
	

        
	
	
}



public static StringBuilder ScriptCompilerFor(StringBuilder sb, int StartForSchleife2) {
	
	
	int endeZahlenPunkt = 0;
	
	String textString = "";
   	int ForZahl = 0, ForZahlEnde = 0;
   	boolean innen = false;

   	
   	//Rekursive Methode zum Herausfinden der Länge der ForZahl
   	endeZahlenPunkt = ScriptCompilerForZahl(sb, StartForSchleife2+2);

   	
   	
   	//ForZahl herausfinden

   	ForZahl = Integer.parseInt(sb.substring(StartForSchleife2+2, StartForSchleife2+2+endeZahlenPunkt)); 
   	
   	
   	//ForZahl herauslöschen
   	sb.delete(StartForSchleife2+2, StartForSchleife2+2+endeZahlenPunkt);
   	
   	
   	

   	for (int j = StartForSchleife2; j < sb.length(); j++) {
   		//System.out.println("X." + j + sb.charAt(j));
	   if (sb.charAt(j) == '"') {
		   if(innen == true) {
			   ForZahlEnde = j;
			   j = sb.length();
		   } else {
			   innen = true;
		   }
	   }
   	}
   	
   	
   	textString = sb.substring(StartForSchleife2+2, ForZahlEnde+1);
   	sb.insert(ForZahlEnde+2, "}");
   	System.out.println("rString:" + textString);

   	sb.replace(StartForSchleife2-1, StartForSchleife2+2,"for(int i = 0; i" + " < " + ForZahl + "; i++) {\n");
   	int ix = StartForSchleife2;
   	while(!(sb.charAt(ix) == '+' && sb.charAt(ix+1) == '+' && sb.charAt(ix+2) == ')')) {
   		ix++;
   	}ix+=6;
   	ix += textString.length();
   	
   	
   	if(textString.length() <= 4) {
   		sb = sb.deleteCharAt(ix);
   	} else {
   		sb = sb.deleteCharAt(ix);
   	}
   	
   	
   	
   	
   	

	
	
	
	return sb;
}

public static int ScriptCompilerForZahl(StringBuilder sb, int ior) {
	int z = 0;
	System.out.println("ior:" + ior + sb.charAt(ior));
	if(UsefulMethods.isNumbersThere(sb.charAt(ior)) == true) {
		z = ScriptCompilerForZahlRec(sb, ++ior, 1);
	}
	System.out.println("ZahlenStellen gefunden: " + z + "!");
	
	
	return z;
}

public static int ScriptCompilerForZahlRec(StringBuilder sb, int iorec, int z2) {

	if(UsefulMethods.isNumbersThere(sb.charAt(iorec)) == true) {
		z2++;
		z2 = ScriptCompilerForZahlRec(sb, ++iorec, z2);
	} else {
		return z2;
	}
	return z2;
}

	//vermutet nicht mehr gebraucht 2020
/*
public static int Switch(String EINGABE) {
	LibraryChemie.LibraryChemie();
	//Variablen
	//BETA(Eine Zeile lang, da nicht benutzt)
	//int Normal = 999, Wissenschaftlich = 999;
	int AUSGABE = 999;
	String oldEINGABE, newEINGABE;
	
	//Leerzeichen weg, Eingabe modifizieren
	EINGABE = EINGABE.replace(" ", "");
	oldEINGABE = EINGABE;
	
	EINGABE = EINGABE.toLowerCase();
	String neu = EINGABE.substring(0, 1).toUpperCase() + EINGABE.substring(1);
	newEINGABE = neu;


	boolean PerfektesElement = false;
	

	

	for(int x = 117; x >= 0; x--) {
		
		
		if(LibraryChemie.s[x][1].matches(newEINGABE)) {
			AUSGABE = x;
			PerfektesElement = true;
		} else if(LibraryChemie.s[x][0].matches(newEINGABE)) {
			AUSGABE = x;
			PerfektesElement = true;
		} else if(LibraryChemie.s[x][9].matches(newEINGABE)) {
			AUSGABE = x;
			PerfektesElement = true;
		}
		
	}
		if(PerfektesElement == false) {
		for(int x = 117; x >= 0; x--) {

		if(LibraryChemie.s[x][1].contains(newEINGABE)) {
			AUSGABE = x;
	} else if(LibraryChemie.s[x][0].contains(newEINGABE)) {
			AUSGABE = x;
	} else if(LibraryChemie.s[x][9].contains(newEINGABE)) {
			AUSGABE = x;
	} else if(LibraryChemie.s[x][0].contains(oldEINGABE)) {
			AUSGABE = x;
	} else if(LibraryChemie.s[x][9].contains(oldEINGABE)) {
			AUSGABE = x;
	} else if(LibraryChemie.s[x][1].contains(oldEINGABE)) {
			AUSGABE = x;
	}
	}
}
	
	return AUSGABE;
}
*/

	
	
}
