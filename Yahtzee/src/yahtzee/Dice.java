/**
 * @author AustinWadlow
 */

package yahtzee;

public class Dice {
	
	private int value;
	private boolean hold = false;
	
	public int roll(){
		
		value = (int)(Math.random()*6) + 1;	
		System.out.println(value);
		return value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setHold(boolean hold){
		this.hold = hold;
	}
	
	public boolean getHold(){
		return this.hold;
	}

}
