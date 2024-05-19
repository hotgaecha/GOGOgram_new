package com.example.nonogram.repository;

import com.example.nonogram.model.AnsBoard15;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnsBoard15Repository extends JpaRepository<AnsBoard15, Integer> {
	Optional<AnsBoard15> findById(int id);
}