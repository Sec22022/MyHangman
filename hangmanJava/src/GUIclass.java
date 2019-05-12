import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


public class GUIclass extends JFrame implements IUpdater {

	private hangman Man;
	
	private JFrame Frame;
	
	private JButton CheckBtn;
	
	public JLabel Word;
	public JLabel Tries;
	public JLabel UsedLetters;
	
	public JTextField Input;
	

	

	
	
	
	GUIclass(){
		Frame = new JFrame("Hello World");
		
		Man = new hangman();
		Man.AddListener(this);
		setTitle("Hangman");
		Frame.setSize(250,180 );
		Frame.setLayout(new BorderLayout());;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		CheckBtn = new JButton("Check letter");
		CheckHandler handler = new CheckHandler();
		CheckBtn.addActionListener(handler);
		
	
		
		Word = new JLabel(Man.getWord());
		Tries = new JLabel(Integer.toString(Man.getTries()));
		
		Input = new JTextField();
		UsedLetters = new JLabel("Letters Used:");
		
	
	
		Frame.add(CheckBtn);
	//	Frame.add(Box.createHorizontalStrut(100));
		Frame.getContentPane().add(Word);
		Frame.add(Tries);	
		Frame.add(Input);
		Frame.add(UsedLetters);
		Frame.setLayout(new GridLayout(3,2));
	
		
		Frame.setVisible(true);
		Frame.setLocation(80, 80);
		JFrame.setDefaultLookAndFeelDecorated(true);

		
		
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
	

	
	private class CheckHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
			
		
		
					
					Man.UpdatedWord();
					javax.swing.SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
					
							if(( Input.toString().isEmpty() == false )&&Input.getText().matches("[a-zA-Z]")) {
								if(Man.CheckLetter(Input.getText().charAt(0)))
									
									UsedLetters.setText(UsedLetters.getText()+Input.getText());
									UsedLetters.repaint();
									
									Input.setText("");
									Input.repaint();
									
						}
					}
					
			});
		}

		



	



}



	@Override
	public void WordDiscovered() {
		JOptionPane.showMessageDialog(this, "Congratulation! You have won!");
		
	}

	@Override
	public void ReduceTries() {
		
		Tries.setText(Integer.toString(Man.getTries()));
		Tries.repaint();
		
	}

	@Override
	public void Lost() {
		CheckBtn.setEnabled(false);
		JOptionPane.showMessageDialog(this, "Game Over");
	}}
	

	


