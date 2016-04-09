/**
 * @author AustinWadlow
 */

package yahtzee;

	public class CombinationChecker {

	   //Create CombinationChecker object
	   private static CombinationChecker SINGLEINSTANCE = new CombinationChecker();

	   //make the constructor private so it is singleton
	   private CombinationChecker(){}

	   //Get the single object
	   public static CombinationChecker getInstance(){
	      return SINGLEINSTANCE;
	   }

	   //Checks full house, three of a kind, four of a kind, yahtzee and returns score
	   //Type 1 = three of a kind, 2 = four of a kind, 3 = full house, 4 = yahtzee
	   public int checkOfaKind(int[] diceValues, int type){

		   int[] numOfValues = new int[6];
		   int returnValue = 0, sum = 0;
		   boolean fullHouseCheckThree = false, fullHouseCheckTwo = false;
		   
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
			   
			   sum += diceValues[cnt]; 
		   }
		   
		   for(int inc = 0; inc < 6; inc++)
		   {
			   if(type == 3 && numOfValues[inc] == 2){
				   fullHouseCheckTwo = true;
			   }
			   if((type == 1 && numOfValues[inc] >= 3) || (type == 3 && numOfValues[inc] == 3))
				   if(type == 3){
					   fullHouseCheckThree = true;
				   }
				   else
					   returnValue = sum;	
			   
			   else if(type == 2 && numOfValues[inc] >= 4)
				   returnValue = sum;
			   
			   else if(type == 4 && numOfValues[inc] == 5)
				   returnValue = 50;
				   
		   }
		   if(type == 3 && fullHouseCheckTwo == true && fullHouseCheckThree == true)
		   {
			   returnValue = 25;
			   return returnValue;
		   }
		   else if(type == 3)
			   return 0;
		   else
			   return returnValue;
	   }
	   
	   //Checks any of the upper sections and returns score
	   public int checkUpperSection(int[] diceValues, int number){
		   
		   int[] numOfValues = new int[6];
		   int returnValue = 0;
		   
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
		   
		   returnValue = numOfValues[number - 1] * number;
		   return returnValue;
		   
	   }
	   
	   //Checks small and large straight and returns score
	   public int checkStraight(int[] diceValues, int type){
		   
		   int[] numOfValues = new int[6];
		   int sum = 0;
		   
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
			   

			   if(numOfValues[cnt] >= 3)
				   return 0;
		   }
		   
		   if(numOfValues[2] == 0 || numOfValues[3] == 0)
			   return 0;
		   
		   else if(numOfValues[0] >= 1 && numOfValues[1] >= 1 || 
				   numOfValues[4] >= 1 && numOfValues[5] >= 1 || 
				   numOfValues[1] >= 1 && numOfValues[4] >= 1)
			   if(type == 1)
				   return 30;
			   else if(type == 2 && 
					   numOfValues[0] >= 1 && numOfValues[1] >= 1 && numOfValues[4] >= 1|| 
					   numOfValues[4] >= 1 && numOfValues[5] >= 1 && numOfValues[1] >= 1 )
				   return 40;
		   
		   return 0;
				     
	   }
	   
   public int getChance(int[] diceValues){
		   
		   int sum = 0;
		   
		   for(int cnt = 0; cnt < 5; cnt ++)
		   {
			   
			   sum += diceValues[cnt]; 
		   }
		   
		   return sum;
	   }
	   
	}
