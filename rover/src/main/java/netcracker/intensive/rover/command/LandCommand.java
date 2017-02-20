package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.constants.Direction;

public class LandCommand implements RoverCommand {
	private Rover rover;
	private Point position;
	private Direction direction;
	
	public LandCommand(Rover r, Point p, Direction d) {
		this.rover = r;
		this.position = p;
		this.direction = d;
	}
	
	@Override
	public void execute() {
		this.rover.land(this.position, this.direction);
	}
	
	@Override
	public String toString() {
		switch (this.direction) {
		case NORTH:
			return "Land at (" + this.position.getX() + ", " + this.position.getY() + ") heading NORTH";
		case EAST:
			return "Land at (" + this.position.getX() + ", " + this.position.getY() + ") heading EAST";
		case SOUTH:
			return "Land at (" + this.position.getX() + ", " + this.position.getY() + ") heading SOUTH";
		case WEST:
			return "Land at (" + this.position.getX() + ", " + this.position.getY() + ") heading WEST";
		}
		
		return "Land at (" + this.position.getX() + ", " + this.position.getY() + ") heading in Unknown direction";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		
		if (other == this)
			return true;
		
		if (!(other instanceof LandCommand))
			return false;
		
		LandCommand cmd = (LandCommand)other;
		return this.rover.equals(cmd.rover);
	}
}
