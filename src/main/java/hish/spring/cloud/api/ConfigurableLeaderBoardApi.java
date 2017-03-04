/**
 * 
 */
package hish.spring.cloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hish.spring.cloud.domains.LeaderboardConfig;
import lombok.AllArgsConstructor;

/**
 * Spring Cloud Config Client - Find REST service with Spring Cloud Config
 * @author shisham
 *
 */
//@Component
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ConfigurableLeaderBoardApi extends AbstractLeaderBoardApi {
	private final LeaderboardConfig config;

//	@Autowired
//	public ConfigurableLeaderBoardApi(@Value("${leaderboard.lb.url}") String leaderBoardAddress) {
//		this.leaderBoardAddress = leaderBoardAddress;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hish.spring.cloud.api.AbstractLeaderBoardApi#getLeaderBoardAddress()
	 */
	@Override
	protected String getLeaderBoardAddress() {
		return this.config.getUrl();
	}

}
