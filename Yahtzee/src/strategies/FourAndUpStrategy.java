/**
 * @author Austin Wadlow
 */

package strategies;

import yahtzee.CombinationChecker;
import yahtzee.Dice;
import yahtzee.Scorecard;

public class FourAndUpStrategy implements PlayerStrategy{
	
	private final CombinationChecker check = CombinationChecker.getInstance();

	@Override
	public Scorecard operation(Dice[] dice, Scorecard scorecard) {
	
		int[] diceValues = new int[dice.length];

		
		for(int turn = 2; turn < 4; turn++){
						
			
			for (int counter = 0; counter < dice.length; counter ++){
				
				if(dice[counter].getValue() >= 4)
					dice[counter].setHold(true);
				dice[counter].roll();
				diceValues[counter] = dice[counter].getValue();
			}
			
			System.out.println("Dice Values after roll " + turn + " : " + dice[0].getValue() + 
					" " + dice[1].getValue() + " "
					 + dice[2].getValue() + " "  + dice[3].getValue() + " "  + dice[4].getValue() + " ");
			System.out.println("End of roll " + turn);
		}
		
		if(!scorecard.getTaken(12)){
			scorecard.setScore(12, check.getChance(diceValues));
			System.out.println("Taking chance for:" + check.getChance(diceValues));
		}		
		
		return scorecard;
	}
	

}
