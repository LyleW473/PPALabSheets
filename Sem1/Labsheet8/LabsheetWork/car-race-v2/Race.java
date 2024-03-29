import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

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
    private ArrayList<Car> cars;
    
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
    public Race(ArrayList<Car> cars, int numberOfLaps,
    int averageLapTime)
    {
        this.cars = cars;
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
    public ArrayList<Car> getPositions(HashMap<Car, Integer> totalTimes)
    {
        // No cars in the race
        if (totalTimes.size() == 0)
        {
            return null;
        }

        int numCars = totalTimes.size();
        // Priority queue, ordering by the total time of each car in the race
        PriorityQueue<Car> priorityQueue = new PriorityQueue<Car>(numCars, Comparator.comparingInt(totalTimes::get));
        for (Car racecar: cars)
        {
            priorityQueue.add(racecar);
        }

        // Find the positions of the cars
        ArrayList<Car> positions = new ArrayList<Car>();
        for (int i = 0; i < numCars; i ++)
        {
            positions.add(priorityQueue.poll()); // Add the car with the minimum total time (front of the queue)
        }
        return positions;
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

        // Initialise HashMap that maps cars to the total times they've been in the current race
        HashMap<Car, Integer> totalTimes = new HashMap<Car, Integer>();
        for (Car racecar: cars)
        {
            totalTimes.put(racecar, 0);
        }
        
        //TASK: make the cars race numberOfLaps amount of times
        for (int i = 0; i < numberOfLaps; i ++)
        {   
            System.out.println("Lap number: " + (i + 1));

            // Get all laptimes
            ArrayList<Integer> lapTimes = new ArrayList<Integer>();
            for (Car racecar: cars)
            {   
                int lapTime = racecar.completeLap(this, isRaining);
                int newTotalTime = totalTimes.get(racecar) + lapTime;
                
                totalTimes.put(racecar, newTotalTime);
                lapTimes.add(lapTime);

                //After each lap, print:
                //-the single lap time of each car
                //-the total time of each car
                //-name of the car that is leading the race
                System.out.println(racecar.getName() + ": " + "Lap time: " + lapTime + " | Total time: " + totalTimes.get(racecar));
            }
            
            // Output positions of all cars in the race
            System.out.println();
            System.out.println("Current positions:");
            ArrayList<Car> carPositions = this.getPositions(totalTimes);
            for (int j = 0; j < carPositions.size(); j++)
            {
                Car currentCar = carPositions.get(j);
                System.out.println((j + 1) + ": " + currentCar.getName());
            }
            System.out.println();
        }
    }
    
    public int getAverageLapTime()
    {
        return averageLapTime;
    }
}