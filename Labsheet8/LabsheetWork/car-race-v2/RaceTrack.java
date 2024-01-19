import java.util.ArrayList;

public class RaceTrack {

    //this tracks information that can affect the time taken to complete
    //a single lap
    private boolean isRaining;

    // List of all races
    private ArrayList<Race> races = new ArrayList<Race>();

    // List of all cars
    private ArrayList<Car> cars = new ArrayList<Car>();

    // Constructor
    public RaceTrack(boolean isRaining)
    {
        this.isRaining = isRaining;
    }

    public static void main(String[] args)
    {
        Car car1 = new Car("A", 10, 100);
        Car car2 = new Car("B", 0, 30);
        Car car3 = new Car("C", 50, 68);

        Race race1 = new Race(car1, car2, car3, 100, 5);

        RaceTrack raceTrack = new RaceTrack(true);

        race1.simulateRace(raceTrack.getIsRaining());
    }    

    public void addRace(Race newRace)
    {
        races.add(newRace);
    }

    public void addCar(Car newCar)
    {
        cars.add(newCar);
    }

    public boolean getIsRaining()
    {
        return isRaining;
    }
}
