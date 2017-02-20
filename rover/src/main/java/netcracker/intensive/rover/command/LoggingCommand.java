package netcracker.intensive.rover.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCommand implements RoverCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingCommand.class);

    private RoverCommand command;
    
    public LoggingCommand(RoverCommand c) {
    	this.command = c;
    }
    
    @Override
    public void execute() {
    	this.command.execute();
    	LOGGER.debug(this.command.toString());
    }
    
    @Override
    public String toString() {
    	return this.command.toString();
    }
}
