/**
 * @author Austin Wadlow
 */

package strategies;

import yahtzee.CombinationChecker;
import yahtzee.Dice;
import yahtzee.Scorecard;

public final class OfAKinderStrategy implements PlayerStrategy{
	private final CombinationChecker check = CombinationChecker.getInstance();

	@Override
	public Scorecard operation(Dice[] dice, Scorecard scorecard) {
			
		int scorecardCategory = 0, value = 0;
		int[] diceValues = new int[dice.length];
		int[] numOfValues = new int[dice.length + 1];
		
		for(int turn = 2; turn < 4; turn++){
						
			for (int counter = 0; counter < dice.length; counter ++){
				diceValues[counter] = dice[counter].getValue();
			}
			for(int cnt = 0; cnt < dice.length; cnt ++){
			
				
				if(diceValues[cnt] == 1)
					   numOfValues[0]++;
				   else if(diceValues[cnt] == 2)
					   numOfValues[1]++;
				   else if(diceValues[cnt] == 3)
					   numOfValues[2]++;
				   else if(diceValues[cnt] == 4)
					   numOfValues[3]++;
				   else if(diceValues[cnt] == 5)
					   numOfValues[4]++;
				   else if(diceValues[cnt] == 6)
					   numOfValues[5]++;
			}
			for(int inc = 0; inc < dice.length; inc++){
				if(numOfValues[0] >= 2)
					if(dice[inc].getValue() == 1){
							  dice[inc].setHold(true);
						  }
				if(numOfValues[1] >= 2)
					if(dice[inc].getValue() == 2){
							  dice[inc].setHold(true);
						  }
					   
				if(numOfValues[2] >= 2)
					if(dice[inc].getValue() == 3){
							  dice[inc].setHold(true);
						  }
					   
				if(numOfValues[3] >= 2)
					if(dice[inc].getValue() == 4){
							  dice[inc].setHold(true);
						  }
					   
				if(numOfValues[4] >= 2)
					if(dice[inc].getValue() == 5){
							  dice[inc].setHold(true);
						  }
					   
				 if(numOfValues[5] >= 2)
					 if(dice[inc].getValue() == 6){
							  dice[inc].setHold(true);
						  }
					  }
			
			for(int counter = 0; counter < dice.length; counter ++){				
						dice[counter].roll();
						diceValues[counter] = dice[counter].getValue();
					}
					for(int i = 0; i <6; i++){
						numOfValues[i] = 0;
					}
					
					System.out.println("Dice Values after roll " + turn + " : " + dice[0].getValue() + 
							" " + dice[1].getValue() + " "
							 + dice[2].getValue() + " "  + dice[3].getValue() + " "  + dice[4].getValue() + " ");
					System.out.println("End of roll " + turn);
				
		
		}
		
		if(scorecard.getTaken(8) == false){
			value = check.checkOfaKind(diceValues, 3);
			scorecardCategory = 8;
		}
		
		if(scorecard.getTaken(11) == false && check.checkOfaKind(diceValues, 4) >= value){
			value = check.checkOfaKind(diceValues, 4);
			scorecardCategory = 11;
		}
		
		if(scorecard.getTaken(6) == false && check.checkOfaKind(diceValues, 1) >= value){
			value = check.checkOfaKind(diceValues, 1);
			scorecardCategory = 6;
		}
		
		if(scorecard.getTaken(7) == false && check.checkOfaKind(diceValues, 2) >= value){
			value = check.checkOfaKind(diceValues, 2);
			scorecardCategory = 7;
		}
		
		
		if(value == 0 && scorecard.getTaken(12) == false){
			value = check.getChance(diceValues);
			scorecardCategory = 12;
		}
		String category = "";
		
		if(scorecardCategory == 6){
			category = "Three of a Kind";
		}
		
		else if(scorecardCategory == 7){
			category = "Four of a Kind";
		}
		
		else if(scorecardCategory == 8){
			category = "Full House";
		}
		
		else if(scorecardCategory == 11){
			category = "YAHTZEE";
		}
		
		else if(scorecardCategory == 12){
			category = "Chance";
		}
		
		
		System.out.println("Choosing " + category + " for " + value + " points.");
		
		scorecard.setScore(scorecardCategory, value);
		
		return scorecard;
	}
}