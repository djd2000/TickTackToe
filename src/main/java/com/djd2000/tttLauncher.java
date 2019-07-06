package com.djd2000;

import java.util.Scanner;

public class tttLauncher {

	public static Scanner in = new Scanner(System.in); // the input Scanner
	private static int row, col;

	public static void main(String[] args) {

		Boolean playing = true;
		Grid theGrid = new Grid();
		String result = "N";

		while (playing) {

			MARK nextMark = theGrid.getNextMark();
			getUserInput(nextMark);

			try {
				theGrid.addMark(row, col);
				theGrid.printBoard();
				result = theGrid.checkResult(nextMark, row, col);

				if (!result.equals("N") || theGrid.allMovesDone()) {
					playing = false;
				}

			} catch (illegalMoveException e) {

				System.out.println(e.getMessage());

			}
		}

		if (result.equals("N")) {
			System.out.println("Result: Its a Draw!");
		} else {
			System.out.println("The winner is " + result + "!");
		}

		in.close();

	}

	private static void getUserInput(MARK nextMark) {
		if (nextMark == MARK.X) {
			System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
		} else {
			System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
		}

		row = in.nextInt() - 1; // array index starts at 0 instead of 1
		col = in.nextInt() - 1;

	}

}
