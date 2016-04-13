/**
 * @author AustinWadlow
 */

package yahtzee;

public class TestDrive {
	
	public static void main(String args[]){
//		String user = null;
//		
//		user = "Austin";
//		System.out.println(user + " checking in");
//		
//		user = "Casey";
//		System.out.println(user + " checking in");
//		
//		user = "Emanuel";
//		System.out.println(user + " checking in");
		
//		Dice dice = new Dice();
//		int value = 0;
//		int one = 0, two = 0, three = 0, four = 0, five = 0, six =0, error =0;
//		
//		for(int i = 0; i < 100000; i++)
//		{
//			value = dice.roll();
//			
//			if(value == 1)
//				one++;
//			else if(value == 2)
//				two++;
//			else if(value == 3)
//				three++;
//			else if(value == 4)
//				four++;
//			else if(value == 5)
//				five++;
//			else if(value == 6)
//				six++;
//			else
//				error++;
//		}
//		
//		System.out.println("Ones: " + one + " Twos: " + two + " Threes: " + 
//				three + " Fours: " + four + " Fives: " + five + " Sixes: " + six + " Errors: " + error);
		
		//CombinationChecker check = CombinationChecker.getInstance();
		Dice[] dice = new Dice[5];
		int[] diceValues = new int[5];
		boolean[] alreadyUsed = new boolean[13];
		
		for(int i = 0; i < 5; i++)
		{
			dice[i] = new Dice();
			dice[i].roll();
		
		}
		
		Scorecard scorecard = new Scorecard();
		
		PlayerStrategy strategy = new OfAKinderStrategy();
		
	
		for(int cnt = 0; cnt < 5; cnt ++){
			for(int i = 0; i < 5; i++)
			{
				dice[i] = new Dice();
				dice[i].roll();
				System.out.println(dice[i].getHold());
				System.out.println(dice[i].getValue());
			}
			strategy.operation(dice, scorecard);
		}
		System.out.println("Total score: " +scorecard.getTotalScore());
		//System.out.println(check.checkStraight(diceValues, 2));
	}
	
	
	
}