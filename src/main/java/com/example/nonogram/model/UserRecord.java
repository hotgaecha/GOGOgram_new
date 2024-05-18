package com.example.nonogram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //이 클래스가 JPA(api) 엔티티임을 나타냅니다. JPA는 이를 기반으로 데이터베이스 테이블을 생성합니다.
public class UserRecord {

	@Id//이 필드가 기본 키(primary key)임을 나타냅니다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키가 데이터베이스에 의해 자동으로 생성되도록 합니다
	private Long id;
	private String username;
	private int puzzleId;  //기본적으로 JPA는 필드 이름을 카멜 케이스(camelCase)에서 스네이크 케이스(snake_case)로
	// 변환하여 데이터베이스 테이블의 칼럼 이름을 생성-> Hibernate와 같은 JPA 구현체에서 기본적으로 제공하는 기능
	private long timeTaken; // 시간 (밀리초 단위)

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPuzzleId() {
		return puzzleId;
	}

	public void setPuzzleId(int puzzleId) {
		this.puzzleId = puzzleId;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}
}
