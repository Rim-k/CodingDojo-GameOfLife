package main;

import main.Cell.CELL_STATE;

public class Grid {
	
	private Cell[][] cells;

	public Grid(int heigh, int width) {
		this.cells = new Cell[heigh][width];
		
		for (int i = 0; i<width; i++) {
			for (int j = 0; i<heigh; i++) {
				cells[i][j] = new Cell(i,j,CELL_STATE.DEAD);
			}
		}
	}
		
	public CELL_STATE getNewCellState(CELL_STATE currentState, int liveNegihbours) {
		
		if (currentState == CELL_STATE.ALIVE && liveNegihbours < 2) {
			return CELL_STATE.DEAD;			
		}
					
		return currentState;
	}


	public int getHeigh() {
		return cells.length;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return cells[0].length;
	}
	

}
