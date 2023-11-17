package dmacc.beans;

import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * @author Eric Grabe - egrabe
 * CIS175 - Fall 2023
 * Nov 12, 2023
 */
@Data
@Embeddable
public class Player {
	
	private String playerName;
	private int number;

	
	public Player() {
		//super();
	}
	
	public Player(String playerName, int number) {
		super();
		this.playerName = playerName;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", number=" + number + "]";
	}
	
	
}
