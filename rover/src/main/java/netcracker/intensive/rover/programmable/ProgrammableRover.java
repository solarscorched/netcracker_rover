package netcracker.intensive.rover.programmable;

import java.util.Map;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;
import netcracker.intensive.rover.programmable.RoverProgram;

public class ProgrammableRover extends Rover {
	private RoverCommandParser parser;
	private RoverProgram program;
	private SimpleRoverStatsModule statsModule;
	
	public ProgrammableRover(GroundVisor gV, SimpleRoverStatsModule sM) {
		super(gV);
		this.statsModule = sM;
	}
	
	public Map<String, Object> getSettings() {
		return this.program.getSettings();
	}
	
	public void executeProgramFile(String str) {
		this.parser = new RoverCommandParser(this, str);
		this.program = this.parser.getProgram();
		boolean stats = (boolean)this.program.getSettings().get(RoverProgram.STATS);
		
		for (RoverCommand command : this.program.getCommands()) {
			command.execute();
			if (stats)
				this.statsModule.registerPosition(this.getCurrentPosition());
		}
	}
}
