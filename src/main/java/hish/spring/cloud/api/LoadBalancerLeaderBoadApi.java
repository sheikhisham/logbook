/**
 * 
 */
package hish.spring.cloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * @author shisham
 *
 */
@Component
@Configuration
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class LoadBalancerLeaderBoadApi extends AbstractLeaderBoardApi {
	
	@Value("${eureka.client.instaneid}")
	private String instanceName;
	
	private final LoadBalancerClient loadBalancerClient;

	/* (non-Javadoc)
	 * @see hish.spring.cloud.api.AbstractLeaderBoardApi#getLeaderBoardAddress()
	 */
	@Override
	protected String getLeaderBoardAddress() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose(instanceName);
		if(null != serviceInstance) {
			return String.format("http://%s:%d", serviceInstance.getHost(), serviceInstance.getPort());
		}
		throw new IllegalStateException("Unable to locate a leaderboard service");
	}

}
