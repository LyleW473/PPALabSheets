package Ex3;

public interface Automobile {

    // Main vehicle functionality
	public void drive();
	public void start();
	public void stop();
	public void brake();
    public void accelerate();
    public void changeGear(int gear);

    // Additional car-related functionality
    // Note: Car settings manager here

    // Maintenance-related
    // Note: Maintenance manager here

    // External to automobile
    // Note: External data manager here
}