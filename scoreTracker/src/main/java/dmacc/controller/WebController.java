package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Score;
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
	
	@GetMapping({"/", "viewAll"})
	public String viewAllScores(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewScore(model);
			}
	
		model.addAttribute("score", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputScore")
	public String addNewScore(Model model) {
		Score s = new Score();
		model.addAttribute("score", s);
		return "input";
				}
	
	@PostMapping("/inputScore")
	public String addNewScore(@ModelAttribute Score s, Model model) {
		System.out.println(s.toString());
		repo.save(s);
		return viewAllScores(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateScore(@PathVariable("id") long id, Model model) {
		Score s = repo.findById(id).orElse(null);
		model.addAttribute("score", s);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseContact(Score s, Model model) {
	repo.save(s);
	return viewAllScores(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	Score s = repo.findById(id).orElse(null);
	repo.delete(s);
	return viewAllScores(model);
	}

}
