
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.*;
public class GUIclass extends JFrame implements IVerbatim {

	 private hangman Man;
	 

	

	Container pane = getContentPane();
	
	
	GUIclass(){
		JFrame Frame = new JFrame();
	Man = new hangman();
		setTitle("Hangman");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton CheckBtn = new JButton();
		JLabel Word = new JLabel();
		JTextField Input = new JTextField();
		Frame.add(CheckBtn);
		Frame.add(Word);
		Frame.add(Input);
		Frame.setLayout(null);
		Frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GUIclass GUIob = new GUIclass();
				
			}
		}
		);
	
		
	

	}
	

	public String MakeWord(String W) {
	//	Word = new JLabel(W);
		return null;
	}
	

}
