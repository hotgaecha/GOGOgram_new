package com.example.nonogram.service;

import com.example.nonogram.model.UserRecord;
import com.example.nonogram.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRecordService {

	@Autowired
	private UserRecordRepository userRecordRepository;

	public List<UserRecord> getTopRecordsForPuzzle(int puzzleId) {
		return userRecordRepository.findByPuzzleIdOrderByTimeTakenAsc(puzzleId);
	}

	public void saveUserRecord(UserRecord userRecord) {
		userRecordRepository.save(userRecord);
	}
}
