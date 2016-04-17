/**
 * @author Austin Wadlow
 */

package yahtzee;

public class TestDrive {

	
	public static void main(String args[]){
		
		PlayGame game = new PlayGame();
		
		for(int i = 0; i < 10; i ++){
			game.play();
			System.out.println("Game score " + game.getGameScore(i));
			System.out.println("Cumulative score: " + game.getCumulativeScore());
		}
		
	
	}	
}