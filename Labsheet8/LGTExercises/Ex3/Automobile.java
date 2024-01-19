package Ex3;

public interface Automobile {

	public enum WheelPosition {LR,LF,RR,RF};
	public enum SeatPosition {Forward, Back};
	
	public void drive();
	public void start();
	public void stop();
	public void changeTyre(Tyre newTyre, WheelPosition pos);
	public Tyre getTyre(WheelPosition pos);
	public void wash();
	public boolean checkOil();
	public int getOil();
	public void changeGear(int gear);
	public void accelerate();
	public void addOil(int oil);
	public void changeWasherLiquid();
	public void changeBrakeFluid();
	public void brake();
	public void addPetrol(int petrol);
	public int getPetrol();
	public void setSeatPosition(int seat, SeatPosition pos);
	public SeatPosition getSeatPosition(int seat);
	public void openBoot();
	public void closeBoot();
	public void openBonnet();
	public void closeBonnet();
	public void setRadioStation(int station);
	public void powerRadio(boolean power);
	public void changeAirFilter();
	public float getEmissionsData();
	public void setTaxi(boolean isTaxi);
	public boolean isTaxi();
	public void setMOTCertificate(boolean mot);
	public boolean hasMOTCertificate();
}