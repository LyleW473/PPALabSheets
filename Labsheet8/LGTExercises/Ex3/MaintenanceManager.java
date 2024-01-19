package Ex3;

public interface MaintenanceManager {
    
    public enum WheelPosition {LR,LF,RR,RF};

	public int getOil();
    public boolean checkOil();
	public void addOil(int oil);

	public void addPetrol(int petrol);
	public int getPetrol();

	public void changeTyre(Tyre newTyre, WheelPosition pos);
	public Tyre getTyre(WheelPosition pos);

	public void wash();
	public void changeWasherLiquid();

	public void changeBrakeFluid();

	public void changeAirFilter();

	public void openBonnet();
	public void closeBonnet();
}
