/**
 * 
 */
package hish.spring.cloud.domains;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author shisham
 *
 */
@Data
@ConfigurationProperties("leaderboard.lb")
@Component
public class LeaderboardConfig {
	private volatile String url;
}
