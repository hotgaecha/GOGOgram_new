package com.example.nonogram.controller;

import com.example.nonogram.model.User;
import com.example.nonogram.model.UserRecord;
import com.example.nonogram.service.UserRecordService;
import com.example.nonogram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

	@Autowired
	private UserRecordService userRecordService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/game/{id}")
	public String game(@PathVariable("id") int id, Model model) {
		model.addAttribute("puzzleId", id);
		List<UserRecord> topRecords = userRecordService.getTopRecordsForPuzzle(id);
		model.addAttribute("topRecords", topRecords);
		return "game";
	}

	@PostMapping("/submit")
	@ResponseBody
	public String submit(@RequestParam("puzzleId") int puzzleId, @RequestParam("username") String username, @RequestParam("timeTaken") long timeTaken, @RequestParam("solution") String[] solution, @RequestParam("is10x10") boolean is10x10) {
		if (userRecordService.checkSolution(puzzleId, solution, is10x10)) {
			User user = userRepository.findByUsername(username);
			if (user == null) {
				user = new User();
				user.setUsername(username);
				userRepository.save(user);
			}

			UserRecord userRecord = new UserRecord();
			userRecord.setUserId(user.getId());
			userRecord.setPuzzleId(puzzleId);
			userRecord.setTimeTaken(timeTaken);
			userRecordService.saveUserRecord(userRecord);
			return "정답입니다!";
		} else {
			return "오답입니다.";
		}
	}
}
