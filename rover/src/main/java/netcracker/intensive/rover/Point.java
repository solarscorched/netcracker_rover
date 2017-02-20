package netcracker.intensive.rover;

public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }

    @Override
    public boolean equals(Object other) {
    	if (other == null)
    		return false;
    	
    	if (other == this)
    		return true;
    	
    	if (!(other instanceof Point))
    		return false;
    	
    	Point p = (Point)other;
    	if (Integer.compare(p.x, this.x) != 0)
    		return false;
    				
    	return Integer.compare(p.y, this.y) == 0;
    }
	
	
}
