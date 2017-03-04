/**
 * 
 */
package hish.spring.cloud.api;

import java.net.URI;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import hish.spring.cloud.domains.Lift;
import hish.spring.cloud.domains.Lifter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shisham
 *
 */
@Slf4j
public abstract class AbstractLeaderBoardApi implements LeaderBoardApi {
	
	private final RestTemplate restTemplate;
	
	public AbstractLeaderBoardApi() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		this.restTemplate = restTemplate;
	}
	
	abstract protected String getLeaderBoardAddress();

	/* (non-Javadoc)
	 * @see hish.spring.cloud.api.LeaderBoardApi#recordLift(hish.spring.cloud.domains.Lift)
	 */
	@Override
	public void recordLift(Lifter lifter, Lift lift) {
		URI url = URI.create(String.format("%s/lifts", getLeaderBoardAddress()));
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.set("exerciseName", lift.getDescription());
        params.set("lifterName", lifter.getFullName());
        params.set("reps", Integer.toString(lift.getReps()));
        params.set("weight", Double.toString(lift.getWeight()));
        
        restTemplate.postForLocation(url, params);
        
        log.debug("Posted : {}", url, params);
	}

}
