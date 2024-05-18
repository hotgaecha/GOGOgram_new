package com.example.nonogram.repository;

import com.example.nonogram.model.AnsBoard10;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnsBoard10Repository extends JpaRepository<AnsBoard10, Integer> {
	AnsBoard10 findByIdAnsBoard10(int idAnsBoard10);
}
