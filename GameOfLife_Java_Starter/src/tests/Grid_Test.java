package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import main.Cell;
import main.Grid;
import main.Cell.CELL_STATE;

public class Grid_Test {
	
	private Grid grid;
	private Cell cell;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.grid = new Grid(4,8);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void  any_live_cell_with_less_than_two_live_neighbours_dies() {
		//Arrange : On prepare les donnees de test
		CELL_STATE currentState = CELL_STATE.ALIVE;
		cell = new Cell(1,1, currentState);
		int liveNegihbours = 1;
		
		//Act: On execute notre fonctionnalite a tester
		CELL_STATE newState = grid.getNewCellState(currentState, liveNegihbours);
		
		//Assert: On compare le resultat avec la valeur attendue
		assertEquals(CELL_STATE.DEAD, newState);
		
	}
	
}
