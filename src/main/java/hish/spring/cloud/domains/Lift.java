/**
 * 
 */
package hish.spring.cloud.domains;

import lombok.Data;
import lombok.ToString;

/**
 * @author shisham
 *
 */
@Data
@ToString
public class Lift {
	private String description;
	private String exerciseName;
	private int reps;
	private double weight;
}
