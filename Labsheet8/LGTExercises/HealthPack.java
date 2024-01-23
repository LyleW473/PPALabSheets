public class HealthPack {
    
    public static void main(String[] args)
    {   
        float x = 0;
        float y = 1;
        float z = 1;
        Location location = new Location(x, y, z);
        HealthPack healthPack1 = new HealthPack(location, 100, HealthPack.PackType.MEDIC_PACK);
		HealthPack healthPack2 = new HealthPack(location, 100, HealthPack.PackType.TRAUMA_PACK);
		HealthPack healthPack3 = new HealthPack(location, 100, HealthPack.PackType.EMERGENCY_PACK);
        System.out.println(healthPack1.getPackType());
		System.out.println(healthPack2.getPackType());
		System.out.println(healthPack3.getPackType());
    }

	public enum PackType {MEDIC_PACK, TRAUMA_PACK, EMERGENCY_PACK};

	// Set to one of the three constants above.
	public PackType packType;

	// Ranges from 0 to 100.
	public int healthLevel;
	
	public Location location;
	
	public HealthPack(Location loc, int level, PackType pt) {
		this.location = loc;
		healthLevel = level;
		packType = pt;
	}
	
	Location getLocation() {
		return location;
	}
	
	int getHealthLevel() {
		return healthLevel;
	}
	
	public String toString()  {
		return location.toString();
	}

	public PackType getPackType() {
		return packType;
	}

	public void setPackType(PackType packType) {
		this.packType = packType;
	}

	public void setHealthLevel(int healthLevel) {
		if (healthLevel <= 0 && healthLevel <= 100)
		{
			this.healthLevel = healthLevel;
		}
	}
}