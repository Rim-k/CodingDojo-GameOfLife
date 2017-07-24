package dojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dojo.Cell.CELL_STATE;

public class Grid_Test {
	
       private Grid grid;
       private Cell cell;
       
       @BeforeClass
       public static void setUpBeforeClass() throws Exception {}
       
       @AfterClass
       public static void tearDownAfterClass() throws Exception {}
       
       @Before
       public void setUp() throws Exception {
              this.grid = new Grid(4, 8);
       }
       
       @After
       public void tearDown() throws Exception {}
       
       @Test
       public void any_live_cell_with_less_than_two_live_neighbours_dies() {
              // Arrange : On prepare les donnees de test
              CELL_STATE currentState = CELL_STATE.ALIVE;
              cell = new Cell(1, 1, currentState);
              int liveNeighbours = 1;
              
              // Act: On execute notre fonctionnalite a tester
              grid.setNewCellState(cell, liveNeighbours);
              
              // Assert: On compare le resultat avec la valeur attendue
              assertFalse(cell.isAlive());
       }
       
       @Test
       public void any_live_cell_with_more_than_three_live_neighbours_dies () {
    	   CELL_STATE currentState = CELL_STATE.ALIVE;
           cell = new Cell(1, 1, currentState);
           int liveNeighbours = 4;
           
           grid.setNewCellState(cell, liveNeighbours);
           
           assertFalse(cell.isAlive());
       }
       
       @Test
       public void any_live_cell_with_two_or_three_live_neighbours_lives () {
    	   CELL_STATE currentState = CELL_STATE.ALIVE;
           cell = new Cell(1, 1, currentState);
           int liveNeighbours = 2;
           
           grid.setNewCellState(cell, liveNeighbours);
           
           assertTrue(cell.isAlive());
       }
       
       @Test
       public void any_dead_cell_with_exactly_three_live_neighbours_lives () {
    	   CELL_STATE currentState = CELL_STATE.DEAD;
           cell = new Cell(1, 1, currentState);
           int liveNeighbours = 3;
           
           grid.setNewCellState(cell, liveNeighbours);
           
           assertTrue(cell.isAlive());
       }
       
       @Test
       public void cell_at_top_left_position_should_have_three_neighbours() {
    	   Cell cell = new Cell(0,0,CELL_STATE.DEAD);
    	   int expectedNeighboursCount = 3;
    	   
    	   int actualNeighboursCount = grid.getCellNeighboursCount(cell.getX(), cell.getY());
    	   
    	   assertEquals(expectedNeighboursCount, actualNeighboursCount);
    	   
       }
       
       @Test
       public void cell_at_top_right_position_should_have_three_neighbours() {
    	   Cell cell = new Cell(0,grid.getWidth()-1, CELL_STATE.DEAD);
    	   int expectedNeighboursCount = 3;
    	   
    	   int actualNeighboursCount = grid.getCellNeighboursCount(cell.getX(), cell.getY());
    	   
    	   assertEquals(expectedNeighboursCount, actualNeighboursCount);
    	   
       }
       
       @Test
       public void cell_at_bottom_right_position_should_have_three_neighbours() {
    	   Cell cell = new Cell(grid.getHeigh()-1, grid.getWidth()-1, CELL_STATE.DEAD);
    	   int expectedNeighboursCount = 3;
    	   
    	   int actualNeighboursCount = grid.getCellNeighboursCount(cell.getX(), cell.getY());
    	   
    	   assertEquals(expectedNeighboursCount, actualNeighboursCount);
    	   
       }
       
       @Test
       public void cell_at_bottom_left_position_should_have_three_neighbours() {
    	   Cell cell = new Cell(grid.getHeigh()-1, 0, CELL_STATE.DEAD);
    	   int expectedNeighboursCount = 3;
    	   
    	   int actualNeighboursCount = grid.getCellNeighboursCount(cell.getX(), cell.getY());
    	   
    	   assertEquals(expectedNeighboursCount, actualNeighboursCount);
    	   
       }
       
       @Test
       public void cell_at_position_1_1_in_4x8_grid_should_have_8_neighbours() {
    	   Cell cell = new Cell(1, 1, CELL_STATE.DEAD);
    	   int expectedNeighboursCount = 8;
    	   
    	   int actualNeighboursCount = grid.getCellNeighboursCount(cell.getX(), cell.getY());
    	   
    	   assertEquals(expectedNeighboursCount, actualNeighboursCount);
       }
       
       @Test
       public void cell_at_position_0_1_in_4x8_grid_should_have_5_neighbours() {
    	   Cell cell = new Cell(0, 1, CELL_STATE.DEAD);
    	   int expectedNeighboursCount = 5;
    	   
    	   int actualNeighboursCount = grid.getCellNeighboursCount(cell.getX(), cell.getY());
    	   
    	   assertEquals(expectedNeighboursCount, actualNeighboursCount);
       }
       
       @Test
       public void cell_at_position_1_0_in_4x8_grid_should_have_5_neighbours() {
    	   Cell cell = new Cell(1, 0, CELL_STATE.DEAD);
    	   int expectedNeighboursCount = 5;
    	   
    	   int actualNeighboursCount = grid.getCellNeighboursCount(cell.getX(), cell.getY());
    	   
    	   assertEquals(expectedNeighboursCount, actualNeighboursCount);
       }
       
       @Test
       public void should_return_cell_live_neighbours_count() {
    	   grid.setCellState(1, 4, CELL_STATE.ALIVE);
    	   grid.setCellState(2, 4, CELL_STATE.ALIVE);
    	   grid.setCellState(2, 3, CELL_STATE.ALIVE);
    	   int expectedNeighboursCount = 3;
    	   
    	   int actualLiveNeighboursCount = grid.getLiveNeighboursCount(1,3);
    	    
    	   assertEquals(expectedNeighboursCount, actualLiveNeighboursCount);
       }
       
       @Test
       public void should_return_new_grid_of_next_cells_generation() {
    	   grid.setCellState(1, 4, CELL_STATE.ALIVE);
    	   grid.setCellState(2, 4, CELL_STATE.ALIVE);
    	   grid.setCellState(2, 3, CELL_STATE.ALIVE);
    	   
    	   Grid expectedNextGenerationGrid = new Grid(grid.getHeigh(), grid.getWidth());
    	   expectedNextGenerationGrid.setCellState(1, 3, CELL_STATE.ALIVE);
    	   expectedNextGenerationGrid.setCellState(1, 4, CELL_STATE.ALIVE);
    	   expectedNextGenerationGrid.setCellState(2, 4, CELL_STATE.ALIVE);
    	   expectedNextGenerationGrid.setCellState(2, 3, CELL_STATE.ALIVE);
    	   
    	   Grid actualNextGenerationGrid = grid.getNextGenerationGrid();
    	   grid.printGrid();
    	   assertEquals(expectedNextGenerationGrid, actualNextGenerationGrid);
    	   
    	 }
       
       @Test
       public void should_return_grid_live_cells () {
    	   
    	   grid.setCellState(1, 4, CELL_STATE.ALIVE);
    	   grid.setCellState(2, 4, CELL_STATE.ALIVE);
    	   grid.setCellState(2, 3, CELL_STATE.ALIVE);    	   
    	   Set<Cell> expectedLiveCells = new HashSet<Cell>();
    	   expectedLiveCells.add(new Cell(1,4));
    	   expectedLiveCells.add(new Cell(2,4));
    	   expectedLiveCells.add(new Cell(2,3));
    	   
    	   Set<Cell> actualLiveCells = grid.getLiveCells();
    	   
    	   assertTrue(expectedLiveCells.containsAll(actualLiveCells));
    	   assertTrue(actualLiveCells.containsAll(expectedLiveCells));
    	   
    	}
       
}