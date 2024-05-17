package com.example.nonogram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {

	@GetMapping("/game/{id}")
	public String game(@PathVariable("id") int id, Model model) {
		model.addAttribute("puzzleId", id);
		return "game";
	}
}
