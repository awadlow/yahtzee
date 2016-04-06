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
		
		Dice dice = new Dice();
		int value = 0;
		int one = 0, two = 0, three = 0, four = 0, five = 0, six =0, error =0;
		
		for(int i = 0; i < 100000; i++)
		{
			value = dice.roll();
			
			if(value == 1)
				one++;
			else if(value == 2)
				two++;
			else if(value == 3)
				three++;
			else if(value == 4)
				four++;
			else if(value == 5)
				five++;
			else if(value == 6)
				six++;
			else
				error++;
		}
		
		System.out.println("Ones: " + one + " Twos: " + two + " Threes: " + 
				three + " Fours: " + four + " Fives: " + five + " Sixes: " + six + " Errors: " + error);
	}

}