package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;

public class Rover implements Moveable, Turnable, Liftable, Landable {
	private Point position = new Point(0, 0);
	private Direction direction = Direction.SOUTH;
	private boolean airborne;
	private GroundVisor groundVisor;
	
	public Rover(GroundVisor gV) {
		this.groundVisor = gV;
	}
	
	public Point getCurrentPosition() {
		return this.position;
	}
	
	public boolean isAirborne() {
		return this.airborne;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public void turnTo(Direction d) {
		this.direction = d;
	}
	
	@Override
	public void move() {
		if (this.isAirborne())
			return;
		
		Point p = null;
		switch (direction) {
		case NORTH:
			p = new Point(this.position.getX(), this.position.getY() - 1);
			break;
		case EAST:
			p = new Point(this.position.getX() + 1, this.position.getY());
			break;
		case SOUTH:
			p = new Point(this.position.getX(), this.position.getY() + 1);
			break;
		case WEST:
			p = new Point(this.position.getX() - 1, this.position.getY());
		}
		
		try {
			if (!this.groundVisor.hasObstacles(p))
				this.position = p;
		} catch (OutOfGroundException e) {
			this.lift();
		}
	}
	
	@Override
	public void lift() {
		this.airborne = true;
		this.direction = null;
		this.position = null;
	}
	
	@Override
	public void land(Point p, Direction d) {
		try {
			if (!this.groundVisor.hasObstacles(p)) {
				this.position = p;
				this.direction = d;
				this.airborne = false;
			}
		} catch (OutOfGroundException e) {
			this.lift();
		}
	}
}