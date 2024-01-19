public class FoodPack {
    private static final int MAX_EFFECT = 100;
    private Location location;

    private int effect;

    public static void main(String[] args) {

        float x = 9;
        float y = 5;
        float z = 2;
        Location location = new Location(x, y, z);
        FoodPack myFoodPack = new FoodPack(location, 50);

        System.out.println(myFoodPack.getEffect());
        
        myFoodPack.setEffect(20023020);
        System.out.println(myFoodPack.getEffect());

        myFoodPack.setEffect(2);
        System.out.println(myFoodPack.getEffect());
        
        myFoodPack.setLegendary();
        System.out.println(myFoodPack.getEffect());

        System.out.println(myFoodPack.getLocation().toString());
    }

    public FoodPack(Location loc, int eff) {
        this.location = loc;
        this.effect = eff;
    }

    public Location getLocation() {
        return location;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        if (effect < MAX_EFFECT)
        {
            this.effect = effect;
        }
        else
        {
            this.effect = MAX_EFFECT;
        }
    }

    public void setLegendary() {
        effect = MAX_EFFECT;
    }
}