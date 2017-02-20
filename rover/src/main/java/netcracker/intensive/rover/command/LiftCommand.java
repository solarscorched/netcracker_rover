package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class LiftCommand implements RoverCommand {
	private Rover rover;

	public LiftCommand(Rover r) {
		this.rover = r;
	}
	
	@Override
	public void execute() {
		this.rover.lift();
	}
	
	@Override
	public String toString() {
		return "Rover lifted";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		
		if (other == this)
			return true;
		
		if (!(other instanceof LiftCommand))
			return false;
		
		LiftCommand cmd = (LiftCommand)other;
		return this.rover.equals(cmd.rover);
	}
}
