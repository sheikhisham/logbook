/**
 * 
 */
package hish.spring.cloud.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Service Discovery Client via Eureka Service Discovery
 * @author shisham
 *
 */
//@Component
//@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DiscoveryLeaderBoardApi extends AbstractLeaderBoardApi {
	
	@Value("${spring.application.name}")
	private String instanceName;

	@NonNull
	private final DiscoveryClient discoveryClient;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hish.spring.cloud.api.AbstractLeaderBoardApi#getLeaderBoardAddress()
	 */
	@Override
	protected String getLeaderBoardAddress() {
		List<ServiceInstance> instances = discoveryClient.getInstances(instanceName);
		if (null != instances && !instances.isEmpty()) {
			ServiceInstance instance = instances.get(0);
			return String.format("http://%s:%d", instance.getHost(), instance.getPort());
		}
		throw new IllegalStateException("Unable to locate a leaderboard service");
	}

}
