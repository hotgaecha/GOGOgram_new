package com.example.nonogram.service;

import com.example.nonogram.model.AnsBoard10;
import com.example.nonogram.model.AnsBoard15;
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
		userRecordRepository.flush();
		logger.info("UserRecord saved and flushed: {}", userRecord);
	}

	public boolean checkSolution(int puzzleId, String[] solution, boolean is10x10) {
		logger.info("Checking solution for puzzleId: {}, is10x10: {}", puzzleId, is10x10);
		if (is10x10) {
			AnsBoard10 puzzleAnswer = ansBoard10Repository.findById(puzzleId).orElse(null);
			if (puzzleAnswer == null) {
				logger.warn("No puzzle answer found for puzzleId: {}", puzzleId);
				return false;
			}
			logger.info("Database answer for puzzleId {}: {}, {}, {}, {}, {}, {}, {}, {}, {}, {}",
					puzzleId,
					puzzleAnswer.getRow1(), puzzleAnswer.getRow2(), puzzleAnswer.getRow3(),
					puzzleAnswer.getRow4(), puzzleAnswer.getRow5(), puzzleAnswer.getRow6(),
					puzzleAnswer.getRow7(), puzzleAnswer.getRow8(), puzzleAnswer.getRow9(),
					puzzleAnswer.getRow10());
			boolean isCorrect = compareSolution(puzzleAnswer, solution);
			logger.info("Puzzle check result for puzzleId: {} is {}", puzzleId, isCorrect);
			return isCorrect;
		} else {
			AnsBoard15 puzzleAnswer = ansBoard15Repository.findById(puzzleId).orElse(null);
			if (puzzleAnswer == null) {
				logger.warn("No puzzle answer found for puzzleId: {}", puzzleId);
				return false;
			}
			logger.info("Database answer for puzzleId {}: {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}",
					puzzleId,
					puzzleAnswer.getRow1(), puzzleAnswer.getRow2(), puzzleAnswer.getRow3(),
					puzzleAnswer.getRow4(), puzzleAnswer.getRow5(), puzzleAnswer.getRow6(),
					puzzleAnswer.getRow7(), puzzleAnswer.getRow8(), puzzleAnswer.getRow9(),
					puzzleAnswer.getRow10(), puzzleAnswer.getRow11(), puzzleAnswer.getRow12(),
					puzzleAnswer.getRow13(), puzzleAnswer.getRow14(), puzzleAnswer.getRow15());
			boolean isCorrect = compareSolution(puzzleAnswer, solution);
			logger.info("Puzzle check result for puzzleId: {} is {}", puzzleId, isCorrect);
			return isCorrect;
		}
	}

	private boolean compareSolution(AnsBoard10 puzzleAnswer, String[] solution) {
		return puzzleAnswer.getRow1().trim().equals(solution[0].trim())
				&& puzzleAnswer.getRow2().trim().equals(solution[1].trim())
				&& puzzleAnswer.getRow3().trim().equals(solution[2].trim())
				&& puzzleAnswer.getRow4().trim().equals(solution[3].trim())
				&& puzzleAnswer.getRow5().trim().equals(solution[4].trim())
				&& puzzleAnswer.getRow6().trim().equals(solution[5].trim())
				&& puzzleAnswer.getRow7().trim().equals(solution[6].trim())
				&& puzzleAnswer.getRow8().trim().equals(solution[7].trim())
				&& puzzleAnswer.getRow9().trim().equals(solution[8].trim())
				&& puzzleAnswer.getRow10().trim().equals(solution[9].trim());
	}

	private boolean compareSolution(AnsBoard15 puzzleAnswer, String[] solution) {
		return puzzleAnswer.getRow1().trim().equals(solution[0].trim())
				&& puzzleAnswer.getRow2().trim().equals(solution[1].trim())
				&& puzzleAnswer.getRow3().trim().equals(solution[2].trim())
				&& puzzleAnswer.getRow4().trim().equals(solution[3].trim())
				&& puzzleAnswer.getRow5().trim().equals(solution[4].trim())
				&& puzzleAnswer.getRow6().trim().equals(solution[5].trim())
				&& puzzleAnswer.getRow7().trim().equals(solution[6].trim())
				&& puzzleAnswer.getRow8().trim().equals(solution[7].trim())
				&& puzzleAnswer.getRow9().trim().equals(solution[8].trim())
				&& puzzleAnswer.getRow10().trim().equals(solution[9].trim())
				&& puzzleAnswer.getRow11().trim().equals(solution[10].trim())
				&& puzzleAnswer.getRow12().trim().equals(solution[11].trim())
				&& puzzleAnswer.getRow13().trim().equals(solution[12].trim())
				&& puzzleAnswer.getRow14().trim().equals(solution[13].trim())
				&& puzzleAnswer.getRow15().trim().equals(solution[14].trim());
	}
}
