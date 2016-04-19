/**
 * @author Austin Wadlow
 */

package yahtzee;

import java.util.Scanner;

import strategies.FourAndUpStrategy;
import strategies.OfAKinderStrategy;
import strategies.PlayerStrategy;
import strategies.RandomStrategy;
import strategies.StraightStrategy;
import strategies.UpperSectionerStrategy;

public class PlayGame {
	
	SavedScoreCards savedScores = new SavedScoreCards();
	
	public void play(){
		
		String message;
		Dice[] dice = new Dice[5];
		int[] diceValues = new int[5];
		int[] numOfValues = new int[dice.length + 1];
		PlayerStrategy strategy;
		int straightChecker = 0;
		int numInput = 0, totalGames = 0;
		boolean done = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("WELCOME TO YAHTZEE!");
		
		while(!done){
		
			
			System.out.println("MENU:");
			System.out.println("1. Watch AI play a game.");
			System.out.println("2. View previous game score.");
			System.out.println("3. View cumulative scores.");
			System.out.println("4. View average score.");
			System.out.println("5. Exit.");
			
			numInput = keyboard.nextInt();
			if(numInput == 1){
				System.out.println("How many games would you like the AI to play?");
				numInput = keyboard.nextInt();
				
				for(int numOfGames = 0; numOfGames < numInput; numOfGames++){
					
					Scorecard scorecard = new Scorecard();
					System.out.println("***************Game Number: " + (numOfGames + 1) +" *****************");
				
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
						System.out.println("Dice Values after roll 1 : "  + dice[0].getValue() + " " + dice[1].getValue() + " "
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
							if(strategy instanceof RandomStrategy)
								if(!scorecard.getTaken(12)){
									strategy = new FourAndUpStrategy();
									message = "Four And Up Strategy being used.";
								}
							
								System.out.println(message);
								scorecard = strategy.operation(dice, scorecard);
								
								System.out.println("End of turn: " + (turn + 1));
							
					
					
					
					System.out.println("Total score: " +scorecard.getTotalScore());
					//System.out.println(check.checkStraight(diceValues, 2));
					}
					totalGames ++;
					savedScores.addScorecard(scorecard);
				}
			}
			
			else if(numInput == 2){
				System.out.println("Which game score did you want to view?");
				numInput = keyboard.nextInt();
				if((numInput) > totalGames || (numInput) <=1)
					System.out.println("Invalid game.");
				else
					System.out.println("Game number " + numInput + " score: " + getGameScore(numInput - 1));
			}
			
			else if(numInput == 3){
				System.out.println("Cumulative score of " + totalGames + " games = " + getCumulativeScore());
			}
			
			else if(numInput == 4){
				System.out.println("Average score of " + totalGames + " games = " + getCumulativeScore()/totalGames);
			}
			
			else if(numInput == 5){
					done = true;
			}
			else
				System.out.println("Invalid menu selection. Please select a different option. ");
		}
	
	}
	
	public double getCumulativeScore(){
		double totalScore = 0;
		for(int i = 0; i < savedScores.getAllScorecards().size(); i++)
		{
			totalScore += savedScores.getScorecard(i).getTotalScore();
		}
		return totalScore;
	}
	
	public double getGameScore(int index){
		Scorecard card = new Scorecard();
		card = savedScores.getScorecard(index);
		
		return card.getTotalScore();
	
	}

}
