/**
 * @author Austin Wadlow
 */

package strategies;

import yahtzee.Dice;
import yahtzee.Scorecard;

public interface PlayerStrategy {

	public Scorecard operation(Dice[] dice, Scorecard scorecard);
}
