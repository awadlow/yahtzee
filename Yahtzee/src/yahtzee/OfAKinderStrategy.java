package yahtzee;

public class OfAKinderStrategy implements PlayerStrategy{
	private final CombinationChecker check = CombinationChecker.getInstance();

	@Override
	public Scorecard operation(Dice[] dice, Scorecard scorecard) {
			
		int value = 0;
		int[] diceValues = new int[dice.length];
		int[] numOfValues = new int[diceValues.length];
		
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
			
			if(numOfValues[0] >= 2)
				  for(int inc = 0; inc < dice.length; inc++)
					  if(dice[inc].getValue() == 1){
						  dice[inc].setHold(true);
					  }
			   else if(numOfValues[1] >= 2)
				   if(dice[inc].getValue() == 2){
						  dice[inc].setHold(true);
					  }
				   
			   else if(numOfValues[2] >= 2)
				   if(dice[inc].getValue() == 3){
						  dice[inc].setHold(true);
					  }
				   
			   else if(numOfValues[3] >= 2)
				   if(dice[inc].getValue() == 4){
						  dice[inc].setHold(true);
					  }
				   
			   else if(numOfValues[4] >= 2)
				   if(dice[inc].getValue() == 5){
						  dice[inc].setHold(true);
					  }
				   
			   else if(numOfValues[5] >= 2)
				   if(dice[inc].getValue() == 6){
						  dice[inc].setHold(true);
					  }
				
		
		
		
		return null;
	}
}
