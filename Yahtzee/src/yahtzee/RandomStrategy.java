package yahtzee;

public class RandomStrategy implements PlayerStrategy {
	
	private final CombinationChecker check = CombinationChecker.getInstance();

	@Override
	public Scorecard operation(Dice[] dice, Scorecard scorecard) {
		
		boolean done = false;
		int value = 0;
		int[] diceValues = new int[dice.length];
		
		for(int turn = 1; turn < 3; turn ++){
			for(int i = 0; i < dice.length; i++){
				value = (int)(Math.random()*2) + 1;
				if(value == 1){
					dice[i].setHold(true);
				}
				else{
					dice[i].setHold(false);
				}
				dice[i].roll();
				diceValues[i] = dice[i].getValue();
				//System.out.println("Dice Held = " + dice[i].getHold());
				//System.out.println("Dice " + i + " value = " + dice[i].getValue());
				
			}
			System.out.println("End of turn " + turn);
		}
		
		
		while(done != true){
			value = (int)(Math.random()*13);				
			switch(value){
		
			case(0):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkUpperSection(diceValues, 1));
					System.out.println("Ones being used");
					done = true;
				}
				else
					System.out.println("Unable to use Ones, already taken");
				break; 
			case(1): 
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkUpperSection(diceValues, 2));
					System.out.println("Twos being used");
					done = true;
				}
				else
					System.out.println("Unable to use Twos, already taken");
				break; 
			case(2):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkUpperSection(diceValues, 3));
					System.out.println("Threes being used");
					done = true;
				}
				else
					System.out.println("Unable to use Threes, already taken");
				break; 
			case(3):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkUpperSection(diceValues, 4));
					System.out.println("Fours being used");
					done = true;
				}
				else
					System.out.println("Unable to use Fours, already taken");
				break; 
			case(4):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkUpperSection(diceValues, 5));
					System.out.println("Fives being used");
					done = true;
				}
				else
					System.out.println("Unable to use Fives, already taken");
				break; 
			case(5):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkUpperSection(diceValues, 6));
					System.out.println("Sixes being used");
					done = true;
				}
				else
					System.out.println("Unable to use Sixes, already taken");
				break; 
			case(6):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkStraight(diceValues, 1));
					System.out.println("Small Straight being used");
					done = true;
				}
				else
					System.out.println("Unable to use Small Straight, already taken");
				break; 
			case(7): 
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkStraight(diceValues, 2));
					System.out.println("Large Straight being used");
					done = true;
				}
				else
					System.out.println("Unable to use Large Straight, already taken");
				break;
			case(8): 
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkOfaKind(diceValues, 1));
					System.out.println("Three of a Kind being used");
					done = true;
				}
				else
					System.out.println("Unable to use Three of a Kind, already taken");
				break; 
			case(9): 
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkOfaKind(diceValues, 2));
					System.out.println("Four of a Kind being used");
					done = true;
				}
				else
					System.out.println("Unable to use Four of a Kind, already taken");
				break; 
			case(10):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkOfaKind(diceValues, 3));
					System.out.println("Full House being used");
					done = true;
				}
				else
					System.out.println("Unable to use Full House, already taken");
				break; 
			case(11):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.checkOfaKind(diceValues, 4));
					System.out.println("Yahtzee being used");
					done = true;
				}
				else
					System.out.println("Unable to use Yahtzee, already taken");
				break; 
			case(12):
				if(scorecard.getTaken(value) == false){
					scorecard.setScore(value, check.getChance(diceValues));
					System.out.println("Chance being used");
					done = true;
				}
				else
					System.out.println("Unable to use Chance, already taken");
				break; 
			default:
				System.out.println("Not possible value");
				}
			}
	
		return scorecard;
	}
}




//
//int value = 0;
//int diceValues[] = new int[5];
//
//for(int inc = 0; inc < dice.length; inc++){
//
//	diceValues[inc] = dice[inc].getValue();
//}
//
//if(turn <= 3){
//	for(int cnt = 0; cnt < dice.length; cnt++){
//		
//		value = (int)(Math.random()*2) + 1;
//		if(value == 1){
//			dice[cnt].setHold(true);
//		}
//		else{
//			dice[cnt].setHold(false);
//		}
//		
//		System.out.println(dice[cnt].getHold());
//	}
//}
//
//else{
//	value = (int)(Math.random()*13) + 1;
//	
//	switch(value){
//	
//	case(1):
//		if(alreadyUsed[0] == false)
//			alreadyUsed[0] = true;
//			System.out.println(check.checkUpperSection(diceValues, 1) + " : Ones being used");
//		break; 
//	case(2): 
//		if(alreadyUsed[1] == false)
//			alreadyUsed[1] = true;
//			System.out.println(check.checkUpperSection(diceValues, 2) + " : Twos being used");
//		break; 
//	case(3):
//		if(alreadyUsed[2] == false)
//			alreadyUsed[2] = true;
//			System.out.println(check.checkUpperSection(diceValues, 3) + " : Threes being used");
//		break; 
//	case(4):
//		if(alreadyUsed[3] == false)
//			alreadyUsed[3] = true;
//			System.out.println(check.checkUpperSection(diceValues, 4) + " : Fours being used");
//		break; 
//	case(5):
//		if(alreadyUsed[4] == false)
//			alreadyUsed[4] = true;
//			System.out.println(check.checkUpperSection(diceValues, 5) + " : Fives being used");
//		break; 
//	case(6):
//		if(alreadyUsed[5] == false)
//			alreadyUsed[5] = true;
//			System.out.println(check.checkUpperSection(diceValues, 6) + " : Sixes being used");
//		break; 
//	case(7):
//		if(alreadyUsed[6] == false)
//			alreadyUsed[6] = true;
//			System.out.println(check.checkStraight(diceValues, 1) + " : Small Straight being used");
//		break; 
//	case(8): 
//		if(alreadyUsed[7] == false)
//			alreadyUsed[7] = true;
//			System.out.println(check.checkStraight(diceValues, 2) + " : Large Straight being used");
//		break;
//	case(9): 
//		if(alreadyUsed[8] == false)
//			alreadyUsed[8] = true;
//			System.out.println(check.checkOfaKind(diceValues, 1) + " : Three of a Kind being used");
//		break; 
//	case(10): 
//		if(alreadyUsed[9] == false)
//			alreadyUsed[9] = true;
//			System.out.println(check.checkOfaKind(diceValues, 2)  + " : Four of a Kind being used");
//		break; 
//	case(11):
//		if(alreadyUsed[10] == false)
//			alreadyUsed[10] = true;
//			System.out.println(check.checkOfaKind(diceValues, 3) + " : Full House being used");
//		break; 
//	case(12):
//		if(alreadyUsed[11] == false)
//			alreadyUsed[11] = true;
//			System.out.println(check.checkOfaKind(diceValues, 4) + " : Yahtzee being used");
//		break; 
//	case(13):
//		if(alreadyUsed[12] == false){
//			alreadyUsed[12] = true;
//			System.out.println(check.getChance(diceValues) + " : Chance being used");
//		}
//		break; 
//	default:
//		System.out.println("Not possible value");
//	
//	}
//	
//}		
//
//
//return dice;
//}