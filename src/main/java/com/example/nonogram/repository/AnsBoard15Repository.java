package com.example.nonogram.repository;

import com.example.nonogram.model.AnsBoard15;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnsBoard15Repository extends JpaRepository<AnsBoard15, Integer> {
	AnsBoard15 findByIdAnsBoard15(int idAnsBoard15);
}
