package hish.spring.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hish.spring.cloud.api.LeaderBoardApi;
import hish.spring.cloud.domains.Lift;
import hish.spring.cloud.domains.Lifter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogBookApplicationTests {
	
	@Autowired
	LeaderBoardApi leaderBoardApi;

//	@Test
	public void contextLoads() {
	}
	
	@Test
	public void leaderBoardApiTest() {
		Lifter lifter = new Lifter();
		lifter.setFullName("sheik");
		Lift lift = new Lift();
		lift.setExerciseName("test exercise");
		lift.setWeight(100);
		lift.setReps(3);
		
		leaderBoardApi.recordLift(lifter, lift);
	}

}
