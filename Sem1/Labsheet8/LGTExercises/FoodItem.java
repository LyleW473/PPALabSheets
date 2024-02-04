public class FoodItem{
    private static final int MAX_EFFECT = 100;
    private Location location;

    private int effect;

    public static void main(String[] args) {

        float x = 9;
        float y = 5;
        float z = 2;
        Location location = new Location(x, y, z);
        FoodItem myFoodItem = new FoodItem(location, 50);

        System.out.println(myFoodItem.getEffect());
        
        myFoodItem.setEffect(20023020);
        System.out.println(myFoodItem.getEffect());

        myFoodItem.setEffect(2);
        System.out.println(myFoodItem.getEffect());
        
        myFoodItem.setLegendary();
        System.out.println(myFoodItem.getEffect());

        System.out.println(myFoodItem.getLocation().toString());
    }

    public FoodItem(Location loc, int eff) {
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
        if (effect < FoodItem.MAX_EFFECT)
        {
            this.effect = effect;
        }
        else
        {
            this.effect = FoodItem.MAX_EFFECT;
        }
    }

    public void setLegendary() {
        effect = FoodItem.MAX_EFFECT;
    }
}