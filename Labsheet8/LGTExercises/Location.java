public class Location {
	public float x;
	public float y;
	public float z;
	
	public Location(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public boolean equals(float x, float y, float z) {
		if (this.x == x && this.y == y && this.z == z) {
			return true;
		}
		return false;
	}
	public String toString() {
		return "[x: "+ x + " y: " + y + " z: " + z + "]";
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
}