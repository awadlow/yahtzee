/**
 * @author CaseyO'Kelly
 * @author Austin Wadlow
 */


package yahtzee;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	CombinationChecker check = CombinationChecker.getInstance();
	
	Dice[] dice = new Dice[5];
	int[] diceValues = new int[5];
	
	
	public PlayPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 10, 10, 10, 10, 10, 10, 45, 10, 10};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblYahtzee = new JLabel("Yahtzee!");
		GridBagConstraints gbc_lblYahtzee = new GridBagConstraints();
		gbc_lblYahtzee.gridwidth = 8;
		gbc_lblYahtzee.insets = new Insets(0, 0, 5, 5);
		gbc_lblYahtzee.gridx = 2;
		gbc_lblYahtzee.gridy = 1;
		add(lblYahtzee, gbc_lblYahtzee);
		
		
		JLabel lblDieRollOne = new JLabel("1");
		GridBagConstraints gbc_lblDieRollOne = new GridBagConstraints();
		gbc_lblDieRollOne.gridwidth = 2;
		gbc_lblDieRollOne.gridheight = 2;
		gbc_lblDieRollOne.insets = new Insets(0, 0, 5, 5);
		gbc_lblDieRollOne.gridx = 1;
		gbc_lblDieRollOne.gridy = 3;
		add(lblDieRollOne, gbc_lblDieRollOne);
		
		JLabel lblDieRollTwo = new JLabel("2");
		GridBagConstraints gbc_lblDieRollTwo = new GridBagConstraints();
		gbc_lblDieRollTwo.gridwidth = 2;
		gbc_lblDieRollTwo.gridheight = 2;
		gbc_lblDieRollTwo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDieRollTwo.gridx = 3;
		gbc_lblDieRollTwo.gridy = 3;
		add(lblDieRollTwo, gbc_lblDieRollTwo);
		
		JLabel lblDieRollThree = new JLabel("3");
		GridBagConstraints gbc_lblDieRollThree = new GridBagConstraints();
		gbc_lblDieRollThree.gridwidth = 2;
		gbc_lblDieRollThree.gridheight = 2;
		gbc_lblDieRollThree.insets = new Insets(0, 0, 5, 5);
		gbc_lblDieRollThree.gridx = 5;
		gbc_lblDieRollThree.gridy = 3;
		add(lblDieRollThree, gbc_lblDieRollThree);
		
		JLabel lblDieRollFour = new JLabel("4");
		GridBagConstraints gbc_lblDieRollFour = new GridBagConstraints();
		gbc_lblDieRollFour.gridwidth = 2;
		gbc_lblDieRollFour.gridheight = 2;
		gbc_lblDieRollFour.insets = new Insets(0, 0, 5, 5);
		gbc_lblDieRollFour.gridx = 7;
		gbc_lblDieRollFour.gridy = 3;
		add(lblDieRollFour, gbc_lblDieRollFour);
		
		JLabel lblDieRollFive = new JLabel("5");
		GridBagConstraints gbc_lblDieRollFive = new GridBagConstraints();
		gbc_lblDieRollFive.gridwidth = 2;
		gbc_lblDieRollFive.gridheight = 2;
		gbc_lblDieRollFive.insets = new Insets(0, 0, 5, 0);
		gbc_lblDieRollFive.gridx = 9;
		gbc_lblDieRollFive.gridy = 3;
		add(lblDieRollFive, gbc_lblDieRollFive);
		
		JCheckBox chckbxHoldDieOne = new JCheckBox("HoldDieOne");
		GridBagConstraints gbc_chckbxHoldDieOne = new GridBagConstraints();
		gbc_chckbxHoldDieOne.gridwidth = 2;
		gbc_chckbxHoldDieOne.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHoldDieOne.gridx = 1;
		gbc_chckbxHoldDieOne.gridy = 5;
		add(chckbxHoldDieOne, gbc_chckbxHoldDieOne);

		JCheckBox chckbxHoldDieTwo = new JCheckBox("HoldDieTwo");
		GridBagConstraints gbc_chckbxHoldDieTwo = new GridBagConstraints();
		gbc_chckbxHoldDieTwo.gridwidth = 2;
		gbc_chckbxHoldDieTwo.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHoldDieTwo.gridx = 3;
		gbc_chckbxHoldDieTwo.gridy = 5;
		add(chckbxHoldDieTwo, gbc_chckbxHoldDieTwo);
		
		JCheckBox chckbxHoldDieThree = new JCheckBox("HoldDieThree");
		GridBagConstraints gbc_chckbxHoldDieThree = new GridBagConstraints();
		gbc_chckbxHoldDieThree.gridwidth = 2;
		gbc_chckbxHoldDieThree.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHoldDieThree.gridx = 5;
		gbc_chckbxHoldDieThree.gridy = 5;
		add(chckbxHoldDieThree, gbc_chckbxHoldDieThree);
		
		JCheckBox chckbxHoldDieFour = new JCheckBox("HoldDieFour");
		GridBagConstraints gbc_chckbxHoldDieFour = new GridBagConstraints();
		gbc_chckbxHoldDieFour.gridwidth = 2;
		gbc_chckbxHoldDieFour.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHoldDieFour.gridx = 7;
		gbc_chckbxHoldDieFour.gridy = 5;
		add(chckbxHoldDieFour, gbc_chckbxHoldDieFour);
		
		JCheckBox chckbxHoldDieFive = new JCheckBox("HoldDieFive\r\n");
		GridBagConstraints gbc_chckbxHoldDieFive = new GridBagConstraints();
		gbc_chckbxHoldDieFive.gridwidth = 2;
		gbc_chckbxHoldDieFive.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxHoldDieFive.gridx = 9;
		gbc_chckbxHoldDieFive.gridy = 5;
		add(chckbxHoldDieFive, gbc_chckbxHoldDieFive);
		
		JButton btnRoll = new JButton("ROLL");
		btnRoll.setEnabled(false);
		btnRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				
				if(chckbxHoldDieOne.isSelected())
					dice[0].setHold(true);
				if(chckbxHoldDieTwo.isSelected())
					dice[1].setHold(true);
				if(chckbxHoldDieThree.isSelected())
					dice[2].setHold(true);
				if(chckbxHoldDieFour.isSelected())
					dice[3].setHold(true);
				if(chckbxHoldDieFive.isSelected())
					dice[4].setHold(true);
				
				for(int i = 0; i < 5; i++)
				{
					dice[i].roll();
					diceValues[i] = dice[i].getValue();
				}
				
				lblDieRollOne.setText(Integer.toString(diceValues[0]));
				lblDieRollTwo.setText(Integer.toString(diceValues[1]));
				lblDieRollThree.setText(Integer.toString(diceValues[2]));
				lblDieRollFour.setText(Integer.toString(diceValues[3]));
				lblDieRollFive.setText(Integer.toString(diceValues[4]));
				
			}
		});
		
		JButton btnPlayGame = new JButton("Play Game");
		btnPlayGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnRoll.setEnabled(true);
				
				for(int i = 0; i < 5; i++)
				{
					dice[i] = new Dice();
				}
				
			
			}
		});
	
		
		GridBagConstraints gbc_btnPlayGame = new GridBagConstraints();
		gbc_btnPlayGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlayGame.gridx = 5;
		gbc_btnPlayGame.gridy = 2;
		add(btnPlayGame, gbc_btnPlayGame);
		
		JLabel lblOnesScore = new JLabel("Ones Score");
		GridBagConstraints gbc_lblOnesScore = new GridBagConstraints();
		gbc_lblOnesScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnesScore.gridx = 3;
		gbc_lblOnesScore.gridy = 6;
		add(lblOnesScore, gbc_lblOnesScore);
//Ones***********************************************************//
		JButton btnOnes = new JButton("ONES:");
		btnOnes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblOnesScore.setText(Integer.toString(check.checkUpperSection(diceValues, 1)));
				btnOnes.setEnabled(false);
			}
		});
		
		GridBagConstraints gbc_btnOnes = new GridBagConstraints();
		gbc_btnOnes.insets = new Insets(0, 0, 5, 5);
		gbc_btnOnes.gridx = 2;
		gbc_btnOnes.gridy = 6;
		add(btnOnes, gbc_btnOnes);
//Twos***********************************************************//		
		JLabel lblTwosScore = new JLabel("Twos Score");
		GridBagConstraints gbc_lblTwosScore = new GridBagConstraints();
		gbc_lblTwosScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblTwosScore.gridx = 3;
		gbc_lblTwosScore.gridy = 7;
		add(lblTwosScore, gbc_lblTwosScore);
		
		JButton btnTwos = new JButton("TWOS:");
		btnTwos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTwosScore.setText(Integer.toString(check.checkUpperSection(diceValues, 2)));
				btnTwos.setEnabled(false);
			}
		});
		
		GridBagConstraints gbc_btnTwos = new GridBagConstraints();
		gbc_btnTwos.insets = new Insets(0, 0, 5, 5);
		gbc_btnTwos.gridx = 2;
		gbc_btnTwos.gridy = 7;
		add(btnTwos, gbc_btnTwos);

//Threes***********************************************************//		
	
		JLabel lblThreesScore = new JLabel("Threes Score");
		GridBagConstraints gbc_lblThreesScore = new GridBagConstraints();
		gbc_lblThreesScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblThreesScore.gridx = 3;
		gbc_lblThreesScore.gridy = 8;
		add(lblThreesScore, gbc_lblThreesScore);
		
		JButton btnThrees = new JButton("THREES:");
		btnThrees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblThreesScore.setText(Integer.toString(check.checkUpperSection(diceValues, 3)));
				btnThrees.setEnabled(false);
				
			}
		});
		GridBagConstraints gbc_btnThrees = new GridBagConstraints();
		gbc_btnThrees.insets = new Insets(0, 0, 5, 5);
		gbc_btnThrees.gridx = 2;
		gbc_btnThrees.gridy = 8;
		add(btnThrees, gbc_btnThrees);
		
//Fours***********************************************************//			
		
		JLabel lblFoursScore = new JLabel("Fours Score");
		GridBagConstraints gbc_lblFoursScore = new GridBagConstraints();
		gbc_lblFoursScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoursScore.gridx = 3;
		gbc_lblFoursScore.gridy = 9;
		add(lblFoursScore, gbc_lblFoursScore);
		
		JButton btnFours = new JButton("FOURS:");
		btnFours.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblFoursScore.setText(Integer.toString(check.checkUpperSection(diceValues, 4)));
				btnFours.setEnabled(false);
				
			}
		});
		GridBagConstraints gbc_btnFours = new GridBagConstraints();
		gbc_btnFours.insets = new Insets(0, 0, 5, 5);
		gbc_btnFours.gridx = 2;
		gbc_btnFours.gridy = 9;
		add(btnFours, gbc_btnFours);
		
//Fives***********************************************************//			
			
		JLabel lblFivesScore = new JLabel("Fives Score");
		GridBagConstraints gbc_lblFivesScore = new GridBagConstraints();
		gbc_lblFivesScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblFivesScore.gridx = 6;
		gbc_lblFivesScore.gridy = 6;
		add(lblFivesScore, gbc_lblFivesScore);
		
		JButton btnFives = new JButton("FIVES:");
		btnFives.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblFivesScore.setText(Integer.toString(check.checkUpperSection(diceValues, 5)));
				btnFives.setEnabled(false);
				
			}
		});
		GridBagConstraints gbc_btnFives = new GridBagConstraints();
		gbc_btnFives.insets = new Insets(0, 0, 5, 5);
		gbc_btnFives.gridx = 5;
		gbc_btnFives.gridy = 6;
		add(btnFives, gbc_btnFives);
		
//Sixes**********************************************************/
		
		JLabel lblSixesScore = new JLabel("Sixes Score");
		GridBagConstraints gbc_lblSixesScore = new GridBagConstraints();
		gbc_lblSixesScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblSixesScore.gridx = 6;
		gbc_lblSixesScore.gridy = 7;
		add(lblSixesScore, gbc_lblSixesScore);
		
		JButton btnSixes = new JButton("SIXES:");
		btnSixes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblSixesScore.setText(Integer.toString(check.checkUpperSection(diceValues, 6)));
				btnSixes.setEnabled(false);
				
			}
		});
		GridBagConstraints gbc_btnSixes = new GridBagConstraints();
		gbc_btnSixes.insets = new Insets(0, 0, 5, 5);
		gbc_btnSixes.gridx = 5;
		gbc_btnSixes.gridy = 7;
		add(btnSixes, gbc_btnSixes);

//Three of a kind***************************************************/
		
		
		JLabel lbl3OfAKindScore = new JLabel("3 Of a Kind Score");
		GridBagConstraints gbc_lbl3OfAKindScore = new GridBagConstraints();
		gbc_lbl3OfAKindScore.insets = new Insets(0, 0, 5, 5);
		gbc_lbl3OfAKindScore.gridx = 6;
		gbc_lbl3OfAKindScore.gridy = 8;
		add(lbl3OfAKindScore, gbc_lbl3OfAKindScore);
		
		JButton btn3OfAKind = new JButton("3 OF A KIND:");
		btn3OfAKind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl3OfAKindScore.setText(Integer.toString(check.checkOfaKind(diceValues, 1)));
				btn3OfAKind.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btn3OfAKind = new GridBagConstraints();
		gbc_btn3OfAKind.insets = new Insets(0, 0, 5, 5);
		gbc_btn3OfAKind.gridx = 5;
		gbc_btn3OfAKind.gridy = 8;
		add(btn3OfAKind, gbc_btn3OfAKind);
		
//Four of a kind***************************************************/		

		
		
		JLabel lbl4OfAKindScore = new JLabel("4 Of a Kind Score");
		GridBagConstraints gbc_lbl4OfAKindScore = new GridBagConstraints();
		gbc_lbl4OfAKindScore.insets = new Insets(0, 0, 5, 5);
		gbc_lbl4OfAKindScore.gridx = 6;
		gbc_lbl4OfAKindScore.gridy = 9;
		add(lbl4OfAKindScore, gbc_lbl4OfAKindScore);
		
		JButton btn4OfAKind = new JButton("4 OF A KIND:");
		btn4OfAKind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
			
				lbl4OfAKindScore.setText(Integer.toString(check.checkOfaKind(diceValues, 2)));
				btn4OfAKind.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btn4OfAKind = new GridBagConstraints();
		gbc_btn4OfAKind.insets = new Insets(0, 0, 5, 5);
		gbc_btn4OfAKind.gridx = 5;
		gbc_btn4OfAKind.gridy = 9;
		add(btn4OfAKind, gbc_btn4OfAKind);
		
		
//Full House*******************************************/		
	
		JLabel lblFullHouseScore = new JLabel("Full House Score");
		GridBagConstraints gbc_lblFullHouseScore = new GridBagConstraints();
		gbc_lblFullHouseScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullHouseScore.gridx = 9;
		gbc_lblFullHouseScore.gridy = 6;
		add(lblFullHouseScore, gbc_lblFullHouseScore);
		
		JButton btnFullHouse = new JButton("FULL HOUSE:");
		btnFullHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblFullHouseScore.setText(Integer.toString(check.checkOfaKind(diceValues, 3)));
				btnFullHouse.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnFullHouse = new GridBagConstraints();
		gbc_btnFullHouse.insets = new Insets(0, 0, 5, 5);
		gbc_btnFullHouse.gridx = 8;
		gbc_btnFullHouse.gridy = 6;
		add(btnFullHouse, gbc_btnFullHouse);
		
		
//Yahtzee************************************************/	
		
		
		JLabel lblYahtzeeScore = new JLabel("Yahtzee Score");
		GridBagConstraints gbc_lblYahtzeeScore = new GridBagConstraints();
		gbc_lblYahtzeeScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblYahtzeeScore.gridx = 9;
		gbc_lblYahtzeeScore.gridy = 9;
		add(lblYahtzeeScore, gbc_lblYahtzeeScore);
		
		JButton btnYahtzee = new JButton("YAHTZEE");
		btnYahtzee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblYahtzeeScore.setText(Integer.toString(check.checkOfaKind(diceValues, 4)));
				btnYahtzee.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnYahtzee = new GridBagConstraints();
		gbc_btnYahtzee.insets = new Insets(0, 0, 5, 5);
		gbc_btnYahtzee.gridx = 8;
		gbc_btnYahtzee.gridy = 9;
		add(btnYahtzee, gbc_btnYahtzee);
	

//Small Straight*******************************************/
		
		JLabel lblSmallStraightScore = new JLabel("Small Straight Score");
		GridBagConstraints gbc_lblSmallStraightScore = new GridBagConstraints();
		gbc_lblSmallStraightScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblSmallStraightScore.gridx = 9;
		gbc_lblSmallStraightScore.gridy = 7;
		add(lblSmallStraightScore, gbc_lblSmallStraightScore);
		
		JButton btnSmallStraight = new JButton("SMALL STRAIGHT:");
		btnSmallStraight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblSmallStraightScore.setText(Integer.toString(check.checkStraight(diceValues, 1)));
				btnSmallStraight.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnSmallStraight = new GridBagConstraints();
		gbc_btnSmallStraight.insets = new Insets(0, 0, 5, 5);
		gbc_btnSmallStraight.gridx = 8;
		gbc_btnSmallStraight.gridy = 7;
		add(btnSmallStraight, gbc_btnSmallStraight);
		
		
//Large Straight*************************************************/	
	
		JLabel lblLargeStraightScore = new JLabel("Large Straight Score");
		GridBagConstraints gbc_lblLargeStraightScore = new GridBagConstraints();
		gbc_lblLargeStraightScore.insets = new Insets(0, 0, 5, 5);
		gbc_lblLargeStraightScore.gridx = 9;
		gbc_lblLargeStraightScore.gridy = 8;
		add(lblLargeStraightScore, gbc_lblLargeStraightScore);
		
	
		
		JButton btnLargeStraight = new JButton("LARGE STRAIGHT:");
		btnLargeStraight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblLargeStraightScore.setText(Integer.toString(check.checkStraight(diceValues, 2)));
				btnLargeStraight.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnLargeStraight = new GridBagConstraints();
		gbc_btnLargeStraight.insets = new Insets(0, 0, 5, 5);
		gbc_btnLargeStraight.gridx = 8;
		gbc_btnLargeStraight.gridy = 8;
		add(btnLargeStraight, gbc_btnLargeStraight);
		
	

		
		JLabel lblOfRerolls = new JLabel("# OF REROLLS LEFT: 2");
		GridBagConstraints gbc_lblOfRerolls = new GridBagConstraints();
		gbc_lblOfRerolls.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfRerolls.gridx = 6;
		gbc_lblOfRerolls.gridy = 10;
		add(lblOfRerolls, gbc_lblOfRerolls);
		
		GridBagConstraints gbc_btnRoll = new GridBagConstraints();
		gbc_btnRoll.insets = new Insets(0, 0, 0, 5);
		gbc_btnRoll.gridx = 6;
		gbc_btnRoll.gridy = 11;
		add(btnRoll, gbc_btnRoll);
		
	}
}
