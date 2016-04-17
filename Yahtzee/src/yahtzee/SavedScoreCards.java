/**
 * @author Austin Wadlow
 */

package yahtzee;

import java.util.ArrayList;
import java.util.List;

public class SavedScoreCards {
	 private List<Scorecard> scorecardList = new ArrayList<Scorecard>();

	   public void addScorecard(Scorecard card){
	      scorecardList.add(card);
	   }

	   public Scorecard getScorecard(int index){
	      return scorecardList.get(index);
	   }
	   
	   public List<Scorecard> getAllScorecards(){
		   return scorecardList;
	   }

}
