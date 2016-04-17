/**
 * @author Austin Wadlow
 */


package yahtzee;

public final class StraightStrategy implements PlayerStrategy {

	private final CombinationChecker check = CombinationChecker.getInstance();
	
	@Override
	public Scorecard operation(Dice[] dice, Scorecard scorecard) {
		
		 int[] numOfValues = new int[6];
		 int[] diceValues = new int[dice.length];
		 boolean[] takenValues = new boolean[6];
		 int value = 0;
		
		for(int turn = 2; turn < 4; turn++){
			
			
			 for (int counter = 0; counter < dice.length; counter ++){
					diceValues[counter] = dice[counter].getValue();
				}
			   for(int cnt = 0; cnt < 5; cnt ++)
			   {
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
			   
			   for(int inc = 0; inc < numOfValues.length; inc ++){
				     
					   for(int counter = 0; counter < dice.length; counter ++){
						  
						   if(dice[counter].getValue() == inc + 1 && takenValues[dice[counter].getValue() - 1] == false){
							   takenValues[dice[counter].getValue() - 1] = true;
							   dice[counter].setHold(true); 
						   }
					   }
				   
			   }
			   
			   
			   for(int cnt = 0; cnt < dice.length; cnt ++){
				   	dice[cnt].roll();
				   	diceValues[cnt] = dice[cnt].getValue();
			   }
			   
			   System.out.println("Dice Values after roll " + turn + " : " + dice[0].getValue() + 
						" " + dice[1].getValue() + " "
						 + dice[2].getValue() + " "  + dice[3].getValue() + " "  + dice[4].getValue() + " ");
				System.out.println("End of roll " + turn);
				
			
		}
		
		if(scorecard.getTaken(10) == false){
			value = 10;
		}
		
		if(value == 0 || (check.checkStraight(diceValues, 2) <= check.checkStraight(diceValues, 1) 
				&& scorecard.getTaken(9) == false)){
			value = 9;
		}
		
		
		scorecard.setScore(value, check.checkStraight(diceValues, (value-8)));
		System.out.println("Straight of type " + (value - 8) + " being used for " + check.checkStraight(diceValues, (value-8)));
		
		return scorecard;
	}

}
