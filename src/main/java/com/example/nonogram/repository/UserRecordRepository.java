package com.example.nonogram.repository;

import com.example.nonogram.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
	List<UserRecord> findByPuzzleIdOrderByTimeTakenAsc(int puzzleId);
}
