
/** 
 * This class represents a Car, including its
 * main attributes that affect the time it takes
 * to complete a lap in a race
 * 
 * @author King's College London
 * @version 1.o
 */
public class Car
{
    private String name;
    //the amount of fuel currently in the car.
    //This is expressed as a whole number percentage, from 0% to 100%
    public int currentFuelLevel;
    //The number of seconds a car is slower per lap when it is raining
    private int rainSlowDown;
    //The total time take in a single race
    private int totalTime;
    //The race that the car is currently participating in
    private Race currentRace;
       
    /**
     * Constructor for objects of class Car
     */
    public Car(String name, int rainSlowDown, int currentFuelLevel)
    {
       this.name = name;
       this.rainSlowDown = rainSlowDown;
       this.currentFuelLevel = currentFuelLevel;
       totalTime = 0;
    }
    
    /**
     * Make the car race a single lap. The time taken
     * to complete the lap is calculated by retrieving
     * the average lap time and altering it, based on
     * the state of the car.
     * 
     * @return the time taken to complete this lap
     */
    public int completeLap(){
        //retrieve averageLapTime from the currentRace
        int singleLapTime = currentRace.getAverageLapTime();
        
        //Determine if, and which, additions or subtractions
        //need to be made to the single lapTime
        
        //TASK: if the fuel level is more than 70%, the
        //lap time is increased by 5 seconds
        //Otherwise, if the fuel level is less than 30%, the
        //lap time is decreased by 5 seconds
        
        //TASK: the lap time is increased by the rainSlowDown
        //when it is raining
        
        //now update the total time taken
        addToTotalTime(singleLapTime);
        
        return singleLapTime;
    }
    
    
    public void addToTotalTime(int lapTime){
        totalTime += lapTime;
    }
    
    public void refuel(){
        currentFuelLevel = 100;
    }
    
    public void setCurrentRace(Race currentRace)
    {
        this.currentRace = currentRace;
    }
}
