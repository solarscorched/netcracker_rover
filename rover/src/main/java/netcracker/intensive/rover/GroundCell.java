package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundCell {
	private CellState cellState;
	
	public GroundCell(CellState cS) {
		this.cellState = cS;
	}
	
	public CellState getState() {
		return cellState;
	}
}
