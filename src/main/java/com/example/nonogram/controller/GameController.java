package com.example.nonogram.controller;

import com.example.nonogram.model.UserRecord;
import com.example.nonogram.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

	@Autowired
	private UserRecordService userRecordService;

	@GetMapping("/game/{id}")
	public String game(@PathVariable("id") int id, Model model) {
		model.addAttribute("puzzleId", id);
		List<UserRecord> topRecords = userRecordService.getTopRecordsForPuzzle(id);
		model.addAttribute("topRecords", topRecords);
		return "game";
	}

	@PostMapping("/submit")
	@ResponseBody
	public String submit(@RequestParam("puzzleId") int puzzleId, @RequestParam("username") String username, @RequestParam("timeTaken") long timeTaken, @RequestParam("solution") String solution) {
		// 정답 검증 로직 (예시)
		String correctSolution = "정답"; // 실제 정답 로직을 구현해야 합니다.
		if (solution.equals(correctSolution)) {
			UserRecord userRecord = new UserRecord();
			userRecord.setUsername(username);
			userRecord.setPuzzleId(puzzleId);
			userRecord.setTimeTaken(timeTaken);
			userRecordService.saveUserRecord(userRecord);
			return "정답입니다!";
		} else {
			return "오답입니다.";
		}
	}
}
