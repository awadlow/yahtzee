/**
 * @author AustinWadlow
 */

package yahtzee;

public class TestDrive {

	
	public static void main(String args[]){

		String message;
		Dice[] dice = new Dice[5];
		int[] diceValues = new int[5];
		Scorecard scorecard = new Scorecard();
		int[] numOfValues = new int[dice.length + 1];
		PlayerStrategy strategy;
		int straightChecker = 0;
	
		
		for(int turn = 0; turn < 13; turn ++)
		{
		
			for(int jnc = 0; jnc < numOfValues.length; jnc++){
				numOfValues[jnc] = 0;
			}
			
			System.out.println("This is turn number: " + (turn + 1));
			
			for(int i = 0; i < 5; i++)
			{
				dice[i] = new Dice();
				dice[i].roll();
				
			}
			System.out.println("Dice Values after roll 1: "  + dice[0].getValue() + " " + dice[1].getValue() + " "
					 + dice[2].getValue() + " "  + dice[3].getValue() + " "  + dice[4].getValue());
				
				strategy = new RandomStrategy();
				message = "Random Strategy being used.";
				
				for(int inc = 0; inc < dice.length; inc ++){
					diceValues[inc] = dice[inc].getValue();
					
					if(diceValues[inc] == 1)
						   numOfValues[0]++;
					   else if(diceValues[inc] == 2)
						   numOfValues[1]++;
					   else if(diceValues[inc] == 3)
						   numOfValues[2]++;
					   else if(diceValues[inc] == 4)
						   numOfValues[3]++;
					   else if(diceValues[inc] == 5)
						   numOfValues[4]++;
					   else if(diceValues[inc] == 6)
						   numOfValues[5]++;
				}
				
				if(numOfValues[2] >= 1 && numOfValues[3] >= 1 && !scorecard.straightTaken()){
					for(int i = 0; i < numOfValues.length; i++){
						if(numOfValues[i] == 1){
							straightChecker ++;
						}
					}
					if(straightChecker >= 3){
						strategy = new StraightStrategy();
						message = "Straight Strategy being used.";
					}
						
				}
				
				else{
					for(int i = 0; i < numOfValues.length; i++){
						if(numOfValues[i] >= 3 && !scorecard.ofAKinderTaken()){
							strategy = new OfAKinderStrategy();
							message = "Of A Kinder Strategy being used.";
						}
					}
				}
				
				if(strategy instanceof RandomStrategy)
					for(int i = 0; i < numOfValues.length; i++){
						if(numOfValues[i] >= 2 && !scorecard.upperSectionTaken()){
							strategy = new UpperSectionerStrategy();
							message = "Upper Sectioner Strategy being used.";
						}
					}
			
					System.out.println(message);
					scorecard = strategy.operation(dice, scorecard);
					
					System.out.println("End of turn: " + (turn + 1));
				
		
		
		
		System.out.println("Total score: " +scorecard.getTotalScore());
		//System.out.println(check.checkStraight(diceValues, 2));
	}
	
	
	}	
}