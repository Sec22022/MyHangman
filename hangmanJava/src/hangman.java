import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class hangman {

	boolean [] DiscoveredLetters;
	private String WordPr;
	private int TriesLeft = 6;
	IUpdater Listener;
	
	
	hangman() {
		try {
		
			MakeWord();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		DiscoveredLetters = new boolean [WordPr.length()];
	}
	
	public String getWord() {
		char [] letters = WordPr.toCharArray();
		String WordForGUI = ""+letters[0];
		for(int cnt = 1;cnt < letters.length;cnt++) {
			WordForGUI += "_ ";
		}
		return WordForGUI;
	}
	public int getTries() {
		return TriesLeft;
	}
	public void AddListener(IUpdater listener) {
		Listener = listener;
	}
	boolean CheckLetter(char Let) {
	
		int cnt = 0;
		boolean discovered = false;
		for(char C : WordPr.toCharArray()) {
			if(C==Let)
				DiscoveredLetters[cnt] = true;
			cnt++;
		}
		if(discovered==false) {
			TriesLeft--;
			Listener.ReduceTries();
		}
		return discovered;
	}
	public String UpdatedWord() {
		boolean finished = true;
		
		char[] TmpLetters = WordPr.toCharArray();
		String RetString = "" + TmpLetters[0];
		for(int cnt = 1; cnt <= WordPr.length(); cnt++ ) {
			if(DiscoveredLetters[cnt]) {
				RetString += TmpLetters[cnt];
			}
		}
		for(boolean val : DiscoveredLetters) {
			if(val == false) {
				finished = false;
				break;
			}
		}
		if(finished)
			Listener.WordDiscovered();
		return RetString;
	}



public String MakeWord() throws IOException, FileNotFoundException{
	try {
		String filePath = new File("").getAbsolutePath();
		FileReader reader = new FileReader(filePath+"/src/Words.txt");
		
	/*	String InputForFile = "Dog,Dat,Layout,Design,Skin,Operator,Airplane,Price,Music,Lamborghini,Science";
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath+"/hangmanJava/src/Words.txt"));
		writer.write(InputForFile);
		writer.close();*/
		
		BufferedReader bReader = new BufferedReader(reader);
		String InputOfFile = bReader.readLine();
		bReader.close();
		String [] WordsSplitted = InputOfFile.split(",");
		WordPr = WordsSplitted[0];
		return WordPr;
		}
	catch(FileNotFoundException e) {
		JOptionPane.showMessageDialog(null,"Sorry, file not found");
		return null;
	}
	catch(IOException e) {
		JOptionPane.showMessageDialog(null,"Sorry, could not read from file");
		return null;
	}
		
	
}



}
