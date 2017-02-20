package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class MoveCommand implements RoverCommand {
	private Rover rover;

	public MoveCommand(Rover r) {
		this.rover = r;
	}
	
    @Override
    public void execute() {
    	this.rover.move();
    }
    
    @Override
    public String toString() {
    	return "Rover moved";
    }

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		
		if (other == this)
			return true;
		
		if (!(other instanceof MoveCommand))
			return false;
		
		MoveCommand cmd = (MoveCommand)other;
		return this.rover.equals(cmd.rover);
	}
}
