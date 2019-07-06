package com.djd2000;

public class Cell {

	private MARK theMark = MARK.S;
	private int row, col;

	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public MARK getTheMark() {
		return theMark;
	}

	public void setTheMark(MARK theMark) {
		this.theMark = theMark;
	}

	public boolean isEmpty() {
		return theMark == MARK.S;
	}
}
