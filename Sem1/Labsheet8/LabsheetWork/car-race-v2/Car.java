
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
    private int currentFuelLevel;
    //The number of seconds a car is slower per lap when it is raining
    private int rainSlowDown;
    // The damage level of the car (also expressed as a whole number percentage, from 0% to 100%)
    private int damageLevel;
    
    /**
     * Constructor for objects of class Car
     */
    public Car(String name, int rainSlowDown, int currentFuelLevel, int damageLevel)
    {
       this.name = name;
       this.rainSlowDown = rainSlowDown;
       this.currentFuelLevel = currentFuelLevel;
       this.damageLevel = damageLevel;
    }

    /**
     * Make the car race a single lap. The time taken
     * to complete the lap is calculated by retrieving
     * the average lap time and altering it, based on
     * the state of the car.
     * 
     * @return the time taken to complete this lap
     */
    public int completeLap(Race currentRace, boolean isRaining){
        //retrieve averageLapTime from the currentRace
        int singleLapTime = currentRace.getAverageLapTime();
        
        //Determine if, and which, additions or subtractions
        //need to be made to the single lapTime
        
        //TASK: if the fuel level is more than 70%, the
        //lap time is increased by 5 seconds
        if (currentFuelLevel > 70) 
        {
            singleLapTime += 5;
        }
        //Otherwise, if the fuel level is less than 30%, the
        //lap time is decreased by 5 seconds
        else if (currentFuelLevel < 30)
        {
            singleLapTime -= 5;
        }
        
        //TASK: the lap time is increased by the rainSlowDown
        //when it is raining
        if (isRaining)
        {
            singleLapTime += rainSlowDown;
        }

        // Lap time is doubled if the damage level of this car is greater than 50%
        if (damageLevel > 50)
        {
            singleLapTime *= 2;
        }
        return singleLapTime;
    }
    
    public String getName(){
        return name;
    }
    
    public void refuel(){
        currentFuelLevel = 100;
    }   
}