
/**
 * This class provides the ability to simulate a number of
 * car objects racing around a race track. In particular,
 * it can determine which car is leading the race after
 * every lap.
 * 
 * @author King's College London
 * @version 1.0
 */
public class Race
{
    //the cars participating in the race
    private Car car1;
    private Car car2;
    private Car car3;
    
    //the total amount of laps the race will last for
    private int numberOfLaps;

    /*
     * The number of seconds it takes for a car to complete a single lap
     * in this race, on average. Each race can have a different
     * averageLapTime, since races take place on different race tracks
     */
    private int averageLapTime;

    /**
     * Constructor for objects of class Race
     */
    public Race(Car car1, Car car2, Car car3, int numberOfLaps,
    int averageLapTime)
    {
        this.car1 = car1;
        this.car2 = car2;
        this.car3 = car3;
        this.numberOfLaps = numberOfLaps;
        this.averageLapTime = averageLapTime;
    }
    
    /**
     * Identifies which of the cars is leading the race,
     * which is the one with the lowest total time
     * taken in the race so far.
     * 
     * @return the car that is leading the race
     */
    public Car getRaceLeader(int lapTime1, int lapTime2, int lapTime3)
    {
        //TASK: determine which car, out of the three
        //in the race, is the leader

        Car[] cars = new Car[] {car1, car2, car3};
        Integer[] times = new Integer[] {lapTime1, lapTime2, lapTime3};

        int minimumLapTime = lapTime1;
        Car minimumCar = null;

        for (int i = 0; i < times.length; i ++)
        {   
            // Car with the lowest lap time
            if (times[i] < minimumLapTime)
            {
                minimumLapTime = times[i];
                minimumCar = cars[i];
            }
        }

        return minimumCar;
    }
    
    /**
     * Simulates the race by making each car complete
     * laps around the track for the amount of laps
     * specified in numberOfLaps.
     */
    public void simulateRace(boolean isRaining)
    {
        //TASK: look at the following line of code. Explain
        //what is wrong with it, but why the program compiles
        //successfully with this left in.
        //Now remove it, as it is not needed in this method
        //anyway, and make changes in the other classes 
        //to prevent the program from compiling if it was left in.

        // Answer: The problem is that the attribute "currentCarLevel" is being altered erroneously as it is declared as a public
        // attribute. This is solved by adhering to data encapsulation and declaring it instead as a private attribute and declaring
        // a setter method to alter it, adding in validation to ensure that extreme values cannot be set.
        
        //TASK: make the cars race numberOfLaps amount of times
        for (int i = 0; i < numberOfLaps; i ++)
        {
            int lapTime1 = car1.completeLap(this, isRaining);
            int lapTime2 = car2.completeLap(this, isRaining);
            int lapTime3 = car3.completeLap(this, isRaining);
            
            //After each lap, print:
            //-the single lap time of each car
            //-the total time of each car
            //-name of the car that is leading the race
            System.out.println(car1.getName() + ": " + "Lap time: " + lapTime1 + " | Total time: " + car1.getTotalTime());
            System.out.println(car2.getName() + ": " + "Lap time: " + lapTime2 + " | Total time: " + car2.getTotalTime());
            System.out.println(car3.getName() + ": " + "Lap time: " + lapTime3 + " | Total time: " + car3.getTotalTime());
            System.out.println("Lap number: " + i + " | Leading car: " + getRaceLeader(lapTime1, lapTime2, lapTime3).getName() + "\n");
        }
    }
    
    public int getAverageLapTime()
    {
        return averageLapTime;
    }
}
