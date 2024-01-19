public class FoodPack {
    private static final int MAX_EFFECT;
    private Location location;

    private int effect;

    public void FoodItem(){
        MAX_EFFECT = 100;
    }

    private FoodItem(Location loc, int eff) {
        MAX_EFFECT = 100;
        this.location = loc;
        this.effect = eff;
    }

    public int getEffect(int effect) {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public void setLegendary() {
        MAX_EFFECT = 200;
    }
}