/**
 * @author Austin Wadlow
 */
package yahtzee;

public class Scorecard {

	//Holds the scores assigned for each category
	//[0] = ones
	//[1] = twos
	//[2] = threes
	//[3] = fours
	//[4] = fives
	//[5] = sixes
	//[6] = three of a kind
	//[7] = four of a kind
	//[8] = full house
	//[9] = small straight
	//[10] = large straight
	//[11] = yahtzee
	//[12] = chance
	private int[] scores = new int[13];
	
	//Tells whether or not a score has been used assigned for each category
	//[0] = ones
	//[1] = twos
	//[2] = threes
	//[3] = fours
	//[4] = fives
	//[5] = sixes
	//[6] = three of a kind
	//[7] = four of a kind
	//[8] = full house
	//[9] = small straight
	//[10] = large straight
	//[11] = yahtzee
	//[12] = chance
	private boolean[] taken = new boolean[13];
	
	private final int bonus = 35;
	
	public void setScore(int category, int value){
		if(taken[category] == false){
			scores[category] = value;
			taken[category] = true;
		}
	}
	
	public boolean getTaken(int category){
		if(taken[category] == true){
			return true;
		}
		else
			return false;
	}
	
	public int getTotalScore(){
		
		int totalScore = 0;
		for(int cnt = 0; cnt < scores.length; cnt++)
		{
			totalScore += scores[cnt];
		}
		if(checkBonus() == true){
			totalScore += 35;
		}
		return totalScore;
	}
	
	public boolean ofAKinderTaken(){
		if(taken[6] && taken[7] && taken[8] && taken[11])
			return true;
		else
			return false;
	}
	
	public boolean straightTaken(){
		if(taken[9] && taken[10])
			return true;
		else
			return false;
	}
	
	public boolean upperSectionTaken(){
		if(taken[0] && taken[1] && taken[2] && taken[3] && taken[4] && taken[5])
			return true;
		else
			return false;
		
	}
	
	public boolean checkBonus(){
		int sum = 0;
		for(int cnt = 0; cnt < 6; cnt ++){
			sum += scores[cnt];
		}
		if(sum >= 63)
			return true;
		else
			return false;
	}
	
	
}
