package dojo;

import dojo.Cell.CELL_STATE;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
	
	   Grid grid = new Grid(4, 8);
		
	   grid.setCellState(1, 4, CELL_STATE.ALIVE);
 	   grid.setCellState(2, 4, CELL_STATE.ALIVE);
 	   grid.setCellState(2, 3, CELL_STATE.ALIVE);
 	   
 	   int i = 0;
 	   System.out.println("Generation " + i);
 	   grid.printGrid();
 	   
 	   while(true) {
 		   Thread.sleep(2000);
 		   System.out.println("Generation " + ++i);
 		   grid.getNextGenerationGrid().printGrid(); 		   
 	   }
	}

}
