package dmacc.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author Eric Grabe - egrabe
 * CIS175 - Fall 2023
 * Nov 12, 2023
 */
@Data
@Entity
public class Score {
	@Id
	@GeneratedValue
	private long id;
	private String type;
	private int points;

	
	@Autowired
	private Player player;
	
	public Score() {
		//super();
	}
	
	public Score(String type, Player player, int number, int points) {
		this.type= type;
		this.points = points;
		this.player = player;
	}
	
	
	
}
