/**
 * 
 */
package hish.spring.cloud.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hish.spring.cloud.api.LeaderBoardApi;
import hish.spring.cloud.domains.Lift;
import hish.spring.cloud.domains.Lifter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shisham
 *
 */
@RestController
@Slf4j
public class LogBookResource {
	
	@Autowired
	LeaderBoardApi leaderBoardApi;
	
	@RequestMapping(value = "/sendlift", method = RequestMethod.POST)
	public String recordLift() {
		Lifter lifter = new Lifter();
		lifter.setFullName("sheik");
		Lift lift = new Lift();
		lift.setExerciseName("test exercise");
		lift.setWeight(100);
		lift.setReps(3);
		
		leaderBoardApi.recordLift(lifter, lift);
		return "success from logbook";
	}
	
	@RequestMapping(value = "/answerme", method = RequestMethod.GET)
	public String answerme() {
		return leaderBoardApi.answerme();
	}
}
