package netcracker.intensive.rover.programmable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.net.URL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.command.*;

public class RoverCommandParser {
	private Rover rover;
	private String filename;
	
	public RoverCommandParser(Rover r, String str) {
		this.rover = r;
		this.filename = str;
	}
	
	public RoverProgram getProgram() {
		RoverProgram program = new RoverProgram();
		List<RoverCommand> commands = new LinkedList<>();
		Map<String, Object> settings = new HashMap<>();
		boolean log = false;
		
		try {
			URL fileURL = this.getClass().getResource(filename);
			if (fileURL == null)
				throw new RoverCommandParserException("Invalid filename");
			
			BufferedReader reader = new BufferedReader(new FileReader(fileURL.getFile()));
			String ln;
			while ((ln = reader.readLine()) != null) {
				if (ln.startsWith(RoverProgram.LOG)) {
					log = ln.endsWith("on");
					settings.put(RoverProgram.LOG, log);
				} else if (ln.startsWith(RoverProgram.STATS))
					settings.put(RoverProgram.STATS, ln.endsWith("on"));
				else if (ln.startsWith(RoverProgram.SEPARATOR))
					continue;
				else if (ln.startsWith("turn"))
					commands.add(log ? new LoggingCommand(new TurnCommand(this.rover, strToDirection(ln.substring("turn".length() + 1)))) : new TurnCommand(this.rover, strToDirection(ln.substring("turn".length() + 1))));
				else if (ln.startsWith("move"))
					commands.add(log ? new LoggingCommand(new MoveCommand(this.rover)) : new MoveCommand(this.rover));
				else if (ln.startsWith("lift"))
					commands.add(log ? new LoggingCommand(new LiftCommand(this.rover)) : new LiftCommand(this.rover));
				else if (ln.startsWith("land")) {
					String str = ln.substring("land".length() + 1);
					String strX = str.substring(0, str.indexOf(" "));
					String strY = str.substring(str.indexOf(" ")+strX.length(), str.indexOf(" ", str.indexOf(" ")+strX.length()));
					LandCommand command = new LandCommand(rover, new Point(Integer.parseInt(strX), Integer.parseInt(strY)), strToDirection(str.substring(str.lastIndexOf(" ") + 1)));
					commands.add(log ? new LoggingCommand(command) : command);
				}
					
			}
			reader.close();	// closing the BufferedReader here
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		program.setCommands(commands);
		program.setSettings(Collections.unmodifiableMap(settings));
		
		return program;
	}
	
	private Direction strToDirection(String str) {
		switch (str) {
		case "north":
			return Direction.NORTH;
		case "east":
			return Direction.EAST;
		case "south":
			return Direction.SOUTH;
		case "west":
			return Direction.WEST;
		}
		
		return null;
	}
}
