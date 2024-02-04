package Ex3;

public interface CarSettingsManager {

    public enum SeatPosition {Forward, Back};
    
	public void setSeatPosition(int seat, SeatPosition pos);
	public SeatPosition getSeatPosition(int seat);

	public void openBoot();
	public void closeBoot();

	public void setRadioStation(int station);
	public void powerRadio(boolean power);
}
