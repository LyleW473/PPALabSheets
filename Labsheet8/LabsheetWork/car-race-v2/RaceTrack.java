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
        Car car1 = new Car("A", 10, 100, 59);
        Car car2 = new Car("B", 0, 30, 0);
        Car car3 = new Car("C", 50, 68, 30);
        Car car4 = new Car("D", 30, 55, 40);
        Car car5 = new Car("E", 25, 40, 50);
        Car car6 = new Car("F", 5, 40, 50);
        Car car7 = new Car("G", 7, 30, 44);
        Car car8 = new Car("H", 99, 9, 100);
        
        ArrayList<Car> raceCars1 = new ArrayList<Car>(){{
                                                        add(car1);
                                                        add(car2);
                                                        add(car3);
                                                        add(car4);
                                                        add(car5);
                                                        add(car6);
                                                        add(car7);
                                                        add(car8);
                                                        }};

        Race race1 = new Race(raceCars1, 3, 5);
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
