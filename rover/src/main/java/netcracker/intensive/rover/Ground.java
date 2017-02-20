package netcracker.intensive.rover;

public class Ground {
	private int x;						// width
	private int y;						// height
	private GroundCell[][] landscape; // matrix [X x Y] containing x*y ground cells

	public Ground(int x, int y) {
		this.x = x;
		this.y = y;
		this.landscape = new GroundCell[x][y];
	}
	
	public GroundCell getCell(int x, int y) throws OutOfGroundException {
		if (x < 0 || x > this.x || y < 0 || y > this.y) // if x or y are OOB
			throw new OutOfGroundException();
		
		return landscape[x][y];
	}

	public void initialize(GroundCell... cells) {
		if (cells.length < x * y)
			throw new IllegalArgumentException();		// if cells count is more then allocated in the matrix (x*y)
		
		int i = 0;
		for(int j = 0; j < y; j++)
			for(int k = 0; k < x; k++)
				landscape[k][j] = cells[i++];
	}
}
