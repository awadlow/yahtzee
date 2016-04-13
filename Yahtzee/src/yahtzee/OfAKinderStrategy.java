/**
 * @author AustinWadlow
 */

package yahtzee;

public class OfAKinderStrategy implements PlayerStrategy{
	private final CombinationChecker check = CombinationChecker.getInstance();

	@Override
	public Scorecard operation(Dice[] dice, Scorecard scorecard) {
			
		int scorecardCategory = 0, value = 0;
		int[] diceValues = new int[dice.length];
		int[] numOfValues = new int[dice.length + 1];
		
		for(int turn = 1; turn < 3; turn++){
						
			for(int cnt = 0; cnt < dice.length; cnt ++){
				diceValues[cnt] = dice[cnt].getValue();
				
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
			
			
			System.out.println("Dice Values:" + dice[0].getValue() + " " + dice[1].getValue() + " "
					 + dice[2].getValue() + " "  + dice[3].getValue() + " "  + dice[4].getValue() + " ");
			System.out.println("End of turn" + turn);
			
			for(int counter = 0; counter < dice.length; counter ++){				
						dice[counter].roll();
					}
					for(int i = 0; i <6; i++){
						numOfValues[i] = 0;
					}
				
		
		}
		
		if(scorecard.getTaken(8) == false){
			value = check.checkOfaKind(diceValues, 3);
			scorecardCategory = 8;
			System.out.println("Value after 8 = " + value);
		}
		
		if(scorecard.getTaken(11) == false && check.checkOfaKind(diceValues, 4) >= value){
			value = check.checkOfaKind(diceValues, 4);
			scorecardCategory = 11;
			System.out.println("Value after 11 = " + value);
		}
		
		if(scorecard.getTaken(6) == false && check.checkOfaKind(diceValues, 1) >= value){
			value = check.checkOfaKind(diceValues, 1);
			scorecardCategory = 6;
			System.out.println("Value after 6 = " + value);
		}
		
		if(scorecard.getTaken(7) == false && check.checkOfaKind(diceValues, 2) >= value){
			value = check.checkOfaKind(diceValues, 2);
			scorecardCategory = 7;
			System.out.println("Value after 7 = " + value);
		}
		
		
		if(value == 0 && scorecard.getTaken(12) == false){
			value = check.getChance(diceValues);
			scorecardCategory = 12;
			System.out.println("Value after 12 = " + value);
		}
		
		System.out.println("Choosing " + scorecardCategory + " for " + value + " points.");
		
		scorecard.setScore(scorecardCategory, value);
		
		return scorecard;
	}
}