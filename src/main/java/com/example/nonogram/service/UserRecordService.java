package com.example.nonogram.service;

import com.example.nonogram.model.UserRecord;
import com.example.nonogram.repository.AnsBoard10Repository;
import com.example.nonogram.repository.AnsBoard15Repository;
import com.example.nonogram.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserRecordService {

	private static final Logger logger = LoggerFactory.getLogger(UserRecordService.class);

	@Autowired
	private UserRecordRepository userRecordRepository;

	@Autowired
	private AnsBoard10Repository ansBoard10Repository;

	@Autowired
	private AnsBoard15Repository ansBoard15Repository;

	public List<UserRecord> getTopRecordsForPuzzle(int puzzleId) {
		return userRecordRepository.findByPuzzleIdOrderByTimeTakenAsc(puzzleId);
	}

	public void saveUserRecord(UserRecord userRecord) {
		logger.info("Saving UserRecord: {}", userRecord);
		userRecordRepository.save(userRecord);
	}

	public boolean checkSolution(int puzzleId, String[] solution, boolean is10x10) {
		if (is10x10) {
			var puzzleAnswer = ansBoard10Repository.findByIdAnsBoard10(puzzleId);
			if (puzzleAnswer == null) {
				logger.warn("No puzzle answer found for puzzleId: {}", puzzleId);
				return false;
			}
			boolean isCorrect = puzzleAnswer.getRow1().equals(solution[0])
					&& puzzleAnswer.getRow2().equals(solution[1])
					&& puzzleAnswer.getRow3().equals(solution[2])
					&& puzzleAnswer.getRow4().equals(solution[3])
					&& puzzleAnswer.getRow5().equals(solution[4])
					&& puzzleAnswer.getRow6().equals(solution[5])
					&& puzzleAnswer.getRow7().equals(solution[6])
					&& puzzleAnswer.getRow8().equals(solution[7])
					&& puzzleAnswer.getRow9().equals(solution[8])
					&& puzzleAnswer.getRow10().equals(solution[9]);
			logger.info("Puzzle check result for puzzleId: {} is {}", puzzleId, isCorrect);
			return isCorrect;
		} else {
			var puzzleAnswer = ansBoard15Repository.findByIdAnsBoard15(puzzleId);
			if (puzzleAnswer == null) {
				logger.warn("No puzzle answer found for puzzleId: {}", puzzleId);
				return false;
			}
			boolean isCorrect = puzzleAnswer.getRow1().equals(solution[0])
					&& puzzleAnswer.getRow2().equals(solution[1])
					&& puzzleAnswer.getRow3().equals(solution[2])
					&& puzzleAnswer.getRow4().equals(solution[3])
					&& puzzleAnswer.getRow5().equals(solution[4])
					&& puzzleAnswer.getRow6().equals(solution[5])
					&& puzzleAnswer.getRow7().equals(solution[6])
					&& puzzleAnswer.getRow8().equals(solution[7])
					&& puzzleAnswer.getRow9().equals(solution[8])
					&& puzzleAnswer.getRow10().equals(solution[9])
					&& puzzleAnswer.getRow11().equals(solution[10])
					&& puzzleAnswer.getRow12().equals(solution[11])
					&& puzzleAnswer.getRow13().equals(solution[12])
					&& puzzleAnswer.getRow14().equals(solution[13])
					&& puzzleAnswer.getRow15().equals(solution[14]);
			logger.info("Puzzle check result for puzzleId: {} is {}", puzzleId, isCorrect);
			return isCorrect;
		}
	}
}
