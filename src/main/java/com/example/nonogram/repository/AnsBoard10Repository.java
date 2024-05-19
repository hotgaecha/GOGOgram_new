package com.example.nonogram.repository;

import com.example.nonogram.model.AnsBoard10;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnsBoard10Repository extends JpaRepository<AnsBoard10, Integer> {
	Optional<AnsBoard10> findById(int id);
}