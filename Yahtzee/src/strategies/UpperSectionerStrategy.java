/**
 * @author Austin Wadlow
 */


package strategies;

import yahtzee.CombinationChecker;
import yahtzee.Dice;
import yahtzee.Scorecard;

public class UpperSectionerStrategy implements PlayerStrategy{
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
				if(numOfValues[0] >= 2 && !scorecard.getTaken(0))
					if(dice[inc].getValue() == 1){
							  dice[inc].setHold(true);
						  }
				if(numOfValues[1] >= 2 && !scorecard.getTaken(1))
					if(dice[inc].getValue() == 2){
							  dice[inc].setHold(true);
						  }
					   
				if(numOfValues[2] >= 2 && !scorecard.getTaken(2))
					if(dice[inc].getValue() == 3){
							  dice[inc].setHold(true);
						  }
					   
				if(numOfValues[3] >= 2 && !scorecard.getTaken(3))
					if(dice[inc].getValue() == 4){
							  dice[inc].setHold(true);
						  }
					   
				if(numOfValues[4] >= 2 && !scorecard.getTaken(4))
					if(dice[inc].getValue() == 5){
							  dice[inc].setHold(true);
						  }
					   
				 if(numOfValues[5] >= 2 && !scorecard.getTaken(5))
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
		
		if(!scorecard.getTaken(11) && check.checkOfaKind(diceValues, 4) != 0){
			
			scorecard.setScore(11, check.checkOfaKind(diceValues, 4));
		}
		
		else{
			for( int jnc = 0; jnc < 6; jnc ++){
				if(!scorecard.getTaken(jnc))
					if(check.checkUpperSection(diceValues, jnc + 1) > value){
						value = check.checkUpperSection(diceValues, jnc + 1);
						scorecardCategory = jnc;
					}
				if(value == 0){
					for(int cnt = 0; cnt < 6; cnt ++){
						if(!scorecard.getTaken(cnt))
							scorecardCategory = cnt;
					}
				}
			}
			
			System.out.println("Choosing " + (scorecardCategory + 1) + "'s for " + value + " points");
			scorecard.setScore(scorecardCategory, value);
		}
		
		return scorecard;
	}
		

}
