/**
 * @author CaseyO'Kelly
 */

package yahtzee;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InGameGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InGameGUI frame = new InGameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InGameGUI() {
		setResizable(true);
		setBounds(new Rectangle(0, 23, 675, 480));
		setPreferredSize(new Dimension(675, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 675, 480);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		PlayPanel play = new PlayPanel();
		
		contentPane.add(play, "PlayYahtzee");
		
		// sets starting layout 
		CardLayout cl = (CardLayout)(contentPane.getLayout());
		cl.show(contentPane, "PlayYahtzee");
		
	}
	
	public void exitProgram() // terminates program
	{
		System.exit(0);
	}
	
	public void changeCards(String nextJFrame){ // will 

		if (nextJFrame == "PlayYahtzee")
		{
			CardLayout cl = (CardLayout)(contentPane.getLayout());
			cl.show(contentPane, "PlayYahtzee");
		}
		
	}


}
