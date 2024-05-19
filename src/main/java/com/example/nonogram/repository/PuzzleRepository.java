package com.example.nonogram.repository;

import com.example.nonogram.model.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuzzleRepository extends JpaRepository<Puzzle, Integer> {
	Puzzle findById(int id);
}
