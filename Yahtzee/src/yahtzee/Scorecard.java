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
	
	
	public void setScore(int category, int value){
		scores[category] = value;
		taken[category] = true;
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
		return totalScore;
	}
	
}
