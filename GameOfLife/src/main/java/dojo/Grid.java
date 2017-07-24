package dojo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import dojo.Cell.CELL_STATE;

public class Grid {
	
    private Cell[][] cells;
    
    public Grid(int heigh, int width) {
       this.cells = new Cell[heigh][width];
       for(int i = 0; i < heigh; i++) {
              for(int j = 0; j < width; j++) {
                    cells[i][j] = new Cell(i, j, CELL_STATE.DEAD);
              }
       }
    }
    
    public void setNewCellState(Cell cell, int liveNegihbours) {
           
	   if (cell.isAlive() && (liveNegihbours < 2 || liveNegihbours > 3)) {
    	   cell.setState(CELL_STATE.DEAD);
       } else if (!cell.isAlive() && liveNegihbours == 3) {
    	   cell.setState(CELL_STATE.ALIVE);
       }
    }
    
    public int getHeigh() {
           return cells.length;
    }
    
    public int getWidth() {
           return cells[0].length;
    }

	public int getCellNeighboursCount(int x, int y) {
		return getCellNeighbours(x, y).size();
	}
	
	public Set<Cell> getCellNeighbours(int x, int y) {

		HashSet<Cell> neighbours = new HashSet<dojo.Cell>();
		
		if (this.cellExists(x-1, y-1)) {
			neighbours.add(this.cells[x-1][y-1]);
		}
		if (this.cellExists(x-1, y)) {
			neighbours.add(this.cells[x-1][y]);
		}
		if (this.cellExists(x-1, y+1)) {
			neighbours.add(this.cells[x-1][y+1]);
		}
		if (this.cellExists(x, y-1)) {
			neighbours.add(this.cells[x][y-1]);
		}
		if (this.cellExists(x, y+1)) {
			neighbours.add(this.cells[x][y+1]);
		}
		if (this.cellExists(x+1, y-1)) {
			neighbours.add(this.cells[x+1][y-1]);
		}
		if (this.cellExists(x+1, y)) {
			neighbours.add(this.cells[x+1][y]);
		}
		if (this.cellExists(x+1, y+1)) {
			neighbours.add(this.cells[x+1][y+1]);
		}

		return neighbours;
	}
	
	public boolean cellExists(int x, int y) {
		return x > -1 && x < this.getHeigh() &&
			   y > -1 && y < this.getWidth();
	}
	
	public boolean cellExists(Cell cell) {
		return cellExists(cell.getX(), cell.getY());
	}
	
	public void setCellState(int x, int y, CELL_STATE newState) {
		if (!cellExists(x, y)) {
			return;
		}
		
		cells[x][y].setState(newState);
	}

	public int getLiveNeighboursCount(int x, int y) {
		if (!cellExists(x, y)) {
			return 0;
		}
		
		return (int) getCellNeighbours(x, y).stream()
									  .filter(c -> c.isAlive())
									  .count();
	}
	
	public Grid getNextGenerationGrid() {
	   Grid nextGenerationGrid = new Grid(getHeigh(), getWidth());
 
	   for(int i = 0; i < getHeigh(); i++) {
           for(int j = 0; j < getWidth(); j++) {
        	   setNewCellState(nextGenerationGrid.getCell(i, j), getLiveNeighboursCount(i, j));
           }

		}
	   
 	   return nextGenerationGrid;
	}

	public Set<Cell> getLiveCells() {
		return Arrays.stream(cells)
					 .flatMap(c -> Arrays.stream(c))
					 .filter(cell -> cellExists(cell))
					 .collect(Collectors.toSet());
	}
	
	public void printGrid() {
		for(int i = 0; i < getHeigh(); i++) {
            for(int j = 0; j < getWidth(); j++) {
                  cells[i][j].print();
            }
            System.out.println();
		}
	}
	public Cell getCell(int x, int y) {
		if (!cellExists(x, y)) {
			return null;
		}
		
		return cells[x][y];
	}
	
}