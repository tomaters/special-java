package ch07.problems;

public class Location {
	
	private int longitude, latitude;
	
	public Location(int longitude, int latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	@Override
	public String toString() {
		return String.format("Longitude: %d\tLatitude: %d", this.longitude, this.latitude);
	}
}
