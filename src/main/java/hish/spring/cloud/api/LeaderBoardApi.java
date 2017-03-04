/**
 * 
 */
package hish.spring.cloud.api;

import hish.spring.cloud.domains.Lift;
import hish.spring.cloud.domains.Lifter;

/**
 * @author shisham
 *
 */
public interface LeaderBoardApi {
	public void recordLift(Lifter lifter, Lift lift);
	
	public String answerme();
}
