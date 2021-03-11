package com.test.selvakumar;

import org.bukkit.Location;
import org.bukkit.World;

public class SpawnPosition {
	
	Location location;
	boolean filled;
	
	public SpawnPosition(World world, int x, int y, int z, boolean filled) {
		this.location = new Location(world, x,y,z);
		this.filled = filled;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public boolean getFilled() {
		return filled;
	}
}
