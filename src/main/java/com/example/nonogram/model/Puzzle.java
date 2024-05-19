package com.example.nonogram.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Puzzle {

	@Id
	private int id;
	private String row1;
	private String row2;
	private String row3;
	private String row4;
	private String row5;
	private String row6;
	private String row7;
	private String row8;
	private String row9;
	private String row10;
	private String row11;
	private String row12;
	private String row13;
	private String row14;
	private String row15;

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRow1() {
		return row1;
	}

	public void setRow1(String row1) {
		this.row1 = row1;
	}

	public String getRow2() {
		return row2;
	}

	public void setRow2(String row2) {
		this.row2 = row2;
	}

	public String getRow3() {
		return row3;
	}

	public void setRow3(String row3) {
		this.row3 = row3;
	}

	public String getRow4() {
		return row4;
	}

	public void setRow4(String row4) {
		this.row4 = row4;
	}

	public String getRow5() {
		return row5;
	}

	public void setRow5(String row5) {
		this.row5 = row5;
	}

	public String getRow6() {
		return row6;
	}

	public void setRow6(String row6) {
		this.row6 = row6;
	}

	public String getRow7() {
		return row7;
	}

	public void setRow7(String row7) {
		this.row7 = row7;
	}

	public String getRow8() {
		return row8;
	}

	public void setRow8(String row8) {
		this.row8 = row8;
	}

	public String getRow9() {
		return row9;
	}

	public void setRow9(String row9) {
		this.row9 = row9;
	}

	public String getRow10() {
		return row10;
	}

	public void setRow10(String row10) {
		this.row10 = row10;
	}

	public String getRow11() {
		return row11;
	}

	public void setRow11(String row11) {
		this.row11 = row11;
	}

	public String getRow12() {
		return row12;
	}

	public void setRow12(String row12) {
		this.row12 = row12;
	}

	public String getRow13() {
		return row13;
	}

	public void setRow13(String row13) {
		this.row13 = row13;
	}

	public String getRow14() {
		return row14;
	}

	public void setRow14(String row14) {
		this.row14 = row14;
	}

	public String getRow15() {
		return row15;
	}

	public void setRow15(String row15) {
		this.row15 = row15;
	}
}
