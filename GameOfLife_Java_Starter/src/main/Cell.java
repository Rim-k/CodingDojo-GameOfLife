package main;

public class Cell {

	private int x;
	private int y;
	private CELL_STATE state;
	
	public enum CELL_STATE {
		ALIVE,
		DEAD;
	}

	public Cell(int i, int j, CELL_STATE state) {
		this.x = i;
		this.y = j;
		this.setState(state);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public CELL_STATE getState() {
		return state;
	}

	public void setState(CELL_STATE state) {
		this.state = state;
	}
	


}
