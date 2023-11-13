package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dmacc.repository.ScoreRepository;

/**
 * @author Eric Grabe - egrabe
 * CIS175 - Fall 2023
 * Nov 12, 2023
 */

@Controller
public class WebController {
	@Autowired
	ScoreRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllScores(Model model) {
		model.addAttribute("scores", repo.findAll());
		return "results";
	}

}
