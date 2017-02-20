package netcracker.intensive.rover.stats;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

import netcracker.intensive.rover.Point;

public class SimpleRoverStatsModule implements RoverStatsModule {
	private Set<Point> coordinates = new HashSet<>();
	
	@Override
	public void registerPosition(Point p) {
		this.coordinates.add(p);
	}
	
	@Override
	public boolean isVisited(Point p) {
		return this.coordinates.contains(p);
	}
	
	@Override
	public Collection<Point> getVisitedPoints() {
		return this.coordinates;
	}
}
