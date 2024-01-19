package Ex3;

public interface Automobile {

	public enum WheelPosition {LR,LF,RR,RF};
	public enum SeatPosition {Forward, Back};

    // Main vehicle functionality
	public void drive();
	public void start();
	public void stop();
	public void brake();
    public void accelerate();
    public void changeGear(int gear);

    // Additional car-related functionality
	public void setSeatPosition(int seat, SeatPosition pos);
	public SeatPosition getSeatPosition(int seat);

	public void openBoot();
	public void closeBoot();

	public void setRadioStation(int station);
	public void powerRadio(boolean power);

    // Maintenance-related
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

    // External to automobile
	public void setTaxi(boolean isTaxi);
	public boolean isTaxi();

	public void setMOTCertificate(boolean mot);
	public boolean hasMOTCertificate();

    public float getEmissionsData();
}