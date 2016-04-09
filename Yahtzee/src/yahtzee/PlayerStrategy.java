package yahtzee;

public interface PlayerStrategy {

	public Scorecard operation(Dice[] dice, Scorecard scorecard);
}
