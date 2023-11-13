package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Player;
import dmacc.beans.Score;

/**
 * @author Eric Grabe - egrabe
 * CIS175 - Fall 2023
 * Nov 12, 2023
 */

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Score score() {
		Score bean = new Score();
		return bean;
	}
	
	@Bean
	public Player player() {
		Player bean = new Player("Brown", 11);
		return bean;
	}

}
