import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class hangman implements IVerbatim {

	boolean [] DiscoveredLetters;
	private char[] WordPr;
	int TriesLeft = 6;
	
	
	hangman() {
		try {
			IVerbatim MakeWord = new GUIclass();
			MakeWord(getWord());
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		DiscoveredLetters = new boolean [WordPr.length];
	}
	

	boolean CheckLetter(char Let) {
	
		int cnt = 0;
		boolean discovered = false;
		for(char C : WordPr) {
			if(C==Let)
				DiscoveredLetters[cnt] = true;
		}
		if(discovered==false)
			cnt--;
		return discovered;
	}
String getWord() throws IOException {

	try {
		FileReader Words = new FileReader("Words.CSV.txt");
		BufferedReader bReader = new BufferedReader(Words);
		String WordStr = bReader.toString();
		WordPr = WordStr.toCharArray();
		char[] ReturnChar =
				new char[WordStr.charAt(0)]; //gets first character from file
		for(int cnt = WordStr.length()-1;cnt>1;cnt--) {
			ReturnChar[cnt] = '_';
		}
		bReader.close();
		return (ReturnChar.toString());
	} catch(FileNotFoundException e) {
		JOptionPane.showMessageDialog(null,"Sorry, file not found");
		return null;
	}
	
}


@Override
public String MakeWord(String w) {
	// TODO Auto-generated method stub
	return null;
}



}
