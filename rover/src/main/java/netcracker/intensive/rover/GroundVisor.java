package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
	private Ground ground;
	
	public GroundVisor(Ground g) {
		this.ground = g;
	}
	
	public boolean hasObstacles(Point p) throws OutOfGroundException {
		return ground.getCell(p.getX(), p.getY()).getState().equals(CellState.OCCUPIED);	// is the cell at (Point) is "OCCUPIED"
	}
}
