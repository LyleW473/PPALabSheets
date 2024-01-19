public class HealthPack {
    
    public static void main(String[] args)
    {   
        float x = 0;
        float y = 1;
        float z = 1;
        Location location = new Location(x, y, z);
        HealthPack myHP = new HealthPack(location, 100, 1);
        System.out.println(myHP.getPackType());
    }

	public static final int MEDIC_PACK = 0;
	public static final int TRAUMA_PACK = 1;
	public static final int EMERGENCY_PACK = 2;

	// Set to one of the three constants above.
	public int packType;

	// Ranges from 0 to 100.
	public int healthLevel;
	
	public Location location;
	
	public HealthPack(Location loc, int level, int type) {
		this.location = loc;
		healthLevel = level;
		packType = type;
	}
	
	Location getLocation() {
		return location;
	}
	
	int getType() {
		return packType;
	}
	
	int getHealthLevel() {
		return healthLevel;
	}
	
	public String toString()  {
		return location.toString();
	}

	public int getPackType() {
		return packType;
	}

	public void setPackType(int packType) {
		this.packType = packType;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}
}