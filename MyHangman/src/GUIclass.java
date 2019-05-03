
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.*;
public class GUIclass extends JFrame implements IVerbatim {

	public GUIclass() {
	//private JLabel Word;
	JButton CheckBtn;
	JTextField Input;
//	private hangman Man;
	Container pane = getContentPane();
	
	}
	GUIclass(String titel){
	//	Man = new hangman();
		setTitle("Hangman");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GUIclass GUIob = new GUIclass();
				GUIob.setVisible(true);
			}
		}
		);
	
		
	

	}
	

	public String MakeWord(String W) {
	//	Word = new JLabel(W);
		return null;
	}
	

}
