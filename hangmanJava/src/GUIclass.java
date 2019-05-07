import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class GUIclass extends JFrame implements IVerbatim {

	// private hangman Man;
	 

	

	
	
	
	GUIclass(){
		JFrame Frame = new JFrame("Hello World");
	//Man = new hangman();
		setTitle("Hangman");
		Frame.setSize(700, 1080);
		Frame.setLayout(new BorderLayout());;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton CheckBtn = new JButton();
		CheckBtn.setSize(20, 50);
		CheckBtn.setBorder(null);
		CheckBtn.setMargin(new Insets(5,5,5,5));
		JLabel Word = new JLabel("Hello Label");
		Border Lborder = BorderFactory.createLineBorder(Color.black,5);
		Word.setBorder(Lborder);
		Word.setSize(150, 100);
		JTextField Input = new JTextField();
		Input.setSize(50, 60);
		Input.setBorder(Lborder);
	
		Frame.add(CheckBtn);
		Frame.add(Box.createHorizontalStrut(100));
		Frame.getContentPane().add(Word);
		Frame.add(Box.createHorizontalStrut(100));
		Frame.add(Input);
		Frame.add(Box.createHorizontalStrut(100));
		Frame.setLayout(null);
	
		
		Frame.setVisible(true);
		Frame.setLocation(80, 80);
		
		
		
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
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
