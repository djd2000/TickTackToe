package com.djd2000;

public class Grid {

	private static final int ROW_COUNT = 3;
	private static final int COL_COUNT = 3;

	private int markCount;

	private Cell[][] board = new Cell[COL_COUNT][ROW_COUNT];

	public Grid() {
		super();
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < COL_COUNT; col++) {
				board[row][col] = new Cell(row, col);
			}
		}
	}

	public void addMark(int row, int col) throws illegalMoveException {

		Cell selectedSquare;
		MARK currentMark;
		if ((row >= 0 && col >= 0) && (row <= ROW_COUNT - 1) && (col <= COL_COUNT - 1)) {
			selectedSquare = (Cell) board[row][col];
		} else {
			throw new illegalMoveException("Cannot make this move " + (row + 1) + "," + (col + 1));
		}

		if (selectedSquare.isEmpty()) {
			markCount++;
			currentMark = getCurrentMark();
			selectedSquare.setTheMark(currentMark);

		} else {
			throw new illegalMoveException("Cannot make this move " + (row + 1) + "," + (col + 1));
		}

	}

	public String checkResult(MARK currentMark, int row, int col) {
		String result = "N";

		if (((MARK) board[row][0].getTheMark() == currentMark && (MARK) board[row][1].getTheMark() == currentMark
				&& (MARK) board[row][2].getTheMark() == currentMark)
				// row
				|| ((MARK) board[0][col].getTheMark() == currentMark && (MARK) board[1][col].getTheMark() == currentMark
						&& (MARK) board[2][col].getTheMark() == currentMark)
				// column

				|| ((MARK) board[0][0].getTheMark() == currentMark && (MARK) board[1][1].getTheMark() == currentMark
						&& (MARK) board[2][2].getTheMark() == currentMark)
				// lr diag

				|| ((MARK) board[0][2].getTheMark() == currentMark && (MARK) board[1][1].getTheMark() == currentMark
						&& (MARK) board[2][0].getTheMark() == currentMark)) {
			// rl diag
			result = currentMark.toString();

		}

		return result;
	}

	public Boolean allMovesDone() {
		return markCount == (ROW_COUNT * COL_COUNT);
	}

	public MARK getCurrentMark() {

		if (markCount == 0 || markCount % 2 == 0) {
			return MARK.O;
		} else {
			return MARK.X;
		}

	}

	public MARK getNextMark() {

		if (markCount == 0 || markCount % 2 == 0) {
			return MARK.X;
		} else {
			return MARK.O;
		}

	}

	public int getMarkCount() {

		return markCount;
	}

	public void printGrid() {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int col = 0; col < ROW_COUNT; col++) {
				System.out.print((MARK) board[row][col].getTheMark() + " ");
			}
			System.out.println();
		}
	}

	/** Print the game board */
	public void printBoard() {
		for (int row = 0; row < ROW_COUNT; ++row) {
			for (int col = 0; col < COL_COUNT; ++col) {
				printCell((MARK) board[row][col].getTheMark()); // print each of the cells
				if (col != ROW_COUNT - 1) {
					System.out.print("|"); // print vertical partition
				}
			}
			System.out.println();
			if (row != ROW_COUNT - 1) {
				System.out.println("-----------"); // print horizontal partition
			}
		}
		System.out.println();
	}

	/** Print a cell with the specified "content" */
	public void printCell(MARK content) {
		if (content == MARK.X) {
			System.out.print(" X ");
		} else if (content == MARK.O) {
			System.out.print(" O ");
		} else {
			System.out.print("   ");
		}

	}

}
