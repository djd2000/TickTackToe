package com.djd2000;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.djd2000.Grid;
import com.djd2000.MARK;
import com.djd2000.illegalMoveException;

public class TicTacToeTest {

	private Grid theGrid;

	@Before
	public void setUp() {
		theGrid = new Grid();
	}

	@After
	public void tearDown() {
		theGrid = null;
	}

	@Test
	public void testAddOneMark() {

		try {
			addAMark(2, 2);
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, theGrid.getMarkCount());
	}

	@Test
	public void testFirstMarkIsX() {

		assertEquals(MARK.O, theGrid.getCurrentMark());
	}

//	@Test
	public void testSecondMarkIsO() {

		try {
			addAMark(2, 2);
		} catch (illegalMoveException e) {

			e.printStackTrace();
		}
		assertEquals(MARK.O, theGrid.getCurrentMark());
	}

	public void addAMark(int row, int col) throws illegalMoveException {

		theGrid.addMark(row, col);

	}

	@Test(expected = illegalMoveException.class)
	public void testMarkSameSquare() throws illegalMoveException {

		addAMark(2, 2);
		addAMark(2, 2);

	}
	
	@Test(expected = illegalMoveException.class)
	public void testMarkOutOfRangeSquare() throws illegalMoveException {

		addAMark(5, 5);

	}

	@Test
	public void topRowXWinner() {

		try {
			addAMark(0, 0);
			addAMark(1, 0);
			addAMark(0, 1);
			addAMark(1, 1);
			addAMark(0, 2);
			assertEquals("X", theGrid.checkResult(theGrid.getCurrentMark(),0,2));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void topRowOWinner() {

		try {
			addAMark(1, 0);
			addAMark(0, 0);
			addAMark(1, 1);
			addAMark(0, 1);
			addAMark(2, 2);
			addAMark(0, 2);
			assertEquals("O", theGrid.checkResult(theGrid.getCurrentMark(),0,2));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void bottomRowOWinner() {

		try {
			addAMark(1, 0);
			addAMark(2, 0);
			addAMark(1, 1);
			addAMark(2, 1);
			addAMark(0, 2);
			addAMark(2, 2);
			assertEquals("O", theGrid.checkResult(theGrid.getCurrentMark(),2,2));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void centerColXWinner() {

		try {
			addAMark(0, 1);
			addAMark(2, 0);
			addAMark(1, 1);
			addAMark(2, 2);
			addAMark(2, 1);
			assertEquals("X", theGrid.checkResult(theGrid.getCurrentMark(),2,1));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void diaganolLRXWinner() {

		try {
			addAMark(0, 0);
			addAMark(1, 0);
			addAMark(1, 1);
			addAMark(2, 1);
			addAMark(2, 2);
			assertEquals("X", theGrid.checkResult(theGrid.getCurrentMark(),2,2));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void diaganolRLXWinner() {

		try {
			addAMark(0, 2);
			addAMark(1, 0);
			addAMark(1, 1);
			addAMark(2, 1);
			addAMark(2, 0);
			assertEquals("X", theGrid.checkResult(theGrid.getCurrentMark(),0,0));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Test
	public void diaganolLROWinner() {

		try {
			addAMark(1, 0);
			addAMark(0, 0);
			addAMark(2, 1);
			addAMark(1, 1);
			addAMark(0, 2);
			addAMark(2, 2);
			assertEquals("O", theGrid.checkResult(theGrid.getCurrentMark(),2,2));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void shouldDraw() {

		try {
			addAMark(0, 0);
			addAMark(0, 1);
			addAMark(0, 2);
			addAMark(1, 0);
			addAMark(1, 2);
			addAMark(2, 0);
			addAMark(2, 1);
			addAMark(2, 2);
			addAMark(1, 1);
			assertEquals("N", theGrid.checkResult(theGrid.getCurrentMark(),2,2));
		} catch (illegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//	@Test
//	public void shouldAddMarkCenter() {
//		theGrid.addMark(MARK.X,2,2);
//	}

}
