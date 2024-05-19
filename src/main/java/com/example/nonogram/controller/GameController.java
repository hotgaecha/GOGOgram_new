package com.example.nonogram.controller;

import com.example.nonogram.model.User;
import com.example.nonogram.model.UserRecord;
import com.example.nonogram.service.UserRecordService;
import com.example.nonogram.repository.UserRepository;
import com.example.nonogram.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class GameController {

	private static final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private UserRecordService userRecordService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRecordRepository userRecordRepository;

	@GetMapping("/game/{id}")
	public String game(@PathVariable("id") int id, Model model) {
		model.addAttribute("puzzleId", id);
		List<UserRecord> topRecords = userRecordService.getTopRecordsForPuzzle(id);
		model.addAttribute("topRecords", topRecords);
		return "game";
	}

	@PostMapping("/submit")
	@ResponseBody
	@Transactional
	public String submit(@RequestParam("puzzleId") int puzzleId, @RequestParam("username") String username, @RequestParam("timeTaken") long timeTaken, @RequestParam("solution") String[] solution, @RequestParam("is10x10") boolean is10x10) {
		logger.info("Received submission for puzzleId: {}, username: {}, timeTaken: {}", puzzleId, username, timeTaken);
		logger.info("Solution: {}", (Object)solution);

		try {
			if (userRecordService.checkSolution(puzzleId, solution, is10x10)) {
				User user = userRepository.findByUsername(username);
				if (user == null) {
					user = new User();
					user.setUsername(username);
					userRepository.saveAndFlush(user);
					logger.info("New user created: {}", user);
				} else {
					logger.info("Existing user found: {}", user);
				}

				UserRecord userRecord = new UserRecord();
				userRecord.setUserId(user.getId());
				userRecord.setPuzzleId(puzzleId);
				userRecord.setTimeTaken(timeTaken);
				userRecordService.saveUserRecord(userRecord);
				logger.info("New user record created: {}", userRecord);

				return "축하합니다! 정답입니다. 기록이 저장되었습니다.";
			} else {
				logger.warn("Incorrect solution for puzzleId: {}, username: {}", puzzleId, username);
				return "오답입니다.";
			}
		} catch (Exception e) {
			logger.error("Error processing submission", e);
			return "서버 오류가 발생했습니다. 다시 시도해 주세요.";
		}
	}
}
