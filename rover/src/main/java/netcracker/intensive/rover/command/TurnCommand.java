package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class TurnCommand implements RoverCommand {
	private Rover rover;

	private Direction direction;
	
	public TurnCommand(Rover r, Direction d) {
		this.rover = r;
		this.direction = d;
	}
	
	@Override
	public void execute() {
		this.rover.turnTo(this.direction);
	}
	
	@Override
	public String toString() {
		switch (this.direction) {
		case NORTH:
			return "Heading NORTH";
		case EAST:
			return "Heading EAST";
		case SOUTH:
			return "Heading SOUTH";
		case WEST:
			return "Heading WEST";
		}
		return "Unknown direction";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		
		if (other == this)
			return true;
		
		if (!(other instanceof TurnCommand))
			return false;
		
		TurnCommand cmd = (TurnCommand)other;
		return this.rover.equals(cmd.rover);
	}
}
