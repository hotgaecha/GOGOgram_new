package com.example.nonogram.repository;

import com.example.nonogram.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
	List<UserRecord> findByPuzzleIdOrderByTimeTakenAsc(int puzzleId);
}
