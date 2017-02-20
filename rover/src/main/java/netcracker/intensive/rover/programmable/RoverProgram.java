package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";
    
    private Collection<RoverCommand> commands = new LinkedList<>();
    private Map<String, Object> settings = new HashMap<>();
    
    public Collection<RoverCommand> getCommands() {
    	return this.commands;
    }
    
    public Map<String, Object> getSettings() {
    	return this.settings;
    }
    
    public void setCommands(Collection<RoverCommand> c) {
    	this.commands = c;
    }
    
    public void setSettings(Map<String, Object> s) {
    	this.settings = s;
    }
}
