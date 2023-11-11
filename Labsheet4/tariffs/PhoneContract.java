/**
 * Maintain details of a mobile phone contract in terms of
 * the rate charged for phone calls.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2017.10.15
 */
public class PhoneContract
{
    // The number for this contract.
    private String phoneNumber;
    // How calls are charged.
    private PhoneRate tariff;
    // Cheaper charge for calls
    private PhoneRate cheapTariff;
    // The billing amount (in cents) for this contract.
    private int bill;
    // The total duration of all calls for this contract  
    private int totalDuration;
    // Number of calls made
    private int numCheapCallsMade;
    private int numOrigCallsMade;

    /**
     * Constructor for objects of class PhoneContract.
     * @param phoneNumber The number of this contract.
     */
    public PhoneContract(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
        tariff = new PhoneRate(5, 10);
        cheapTariff = new PhoneRate(5, 5);
        bill = 0;
    }

    /**
     * Calculate the cost of a call of the given duration.
     * @param duration The length of the call in seconds.
     */
    public void makeCall(int duration)
    {
        int cost = 0;
        if (duration > 0)
        {   
            // Calls that lasted less than an hour
            if (duration < 3600)
            {
                cost += tariff.calculateCost(duration);
                this.numOrigCallsMade ++;
            }
            // Calls that lasted an hour or greater
            else
            {
                cost += cheapTariff.calculateCost(duration);
                this.numCheapCallsMade ++;
            }
            
        }
        bill = bill + cost;
        this.totalDuration += duration;
        System.out.println(phoneNumber + ": The call lasting " +
                           duration + " seconds costs " + cost +
                           " cents.");
    }
    
    /**
     * Return the current bill, in cents.
     * @return The current bill.
     */
    public int getBill()
    {
        return bill;
    }
       
    public int getTotalDuration()
    {
        return this.totalDuration;
    }
    
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    public int getTotalNumCallsMade()
    {
        return getNumOrigCallsMade() + getNumCheapCallsMade();
    }
    
    public int getAverageCallDuration()
    {
        if (getTotalNumCallsMade() > 0 )
        {
            return this.getTotalDuration() / this.getTotalNumCallsMade();
        }
        else
        {
            return 0;
        }
    }
    
    public int getNumCheapCallsMade()
    {
        return this.numCheapCallsMade;
    }
    
    public int getNumOrigCallsMade()
    {
        return this.numOrigCallsMade;
    }
    
    public void printBill()
    {
        System.out.println(
                            "number: " + getPhoneNumber() + 
                            " time: " + getTotalDuration() + 
                            " amount: " + getBill() +
                            " average duration of calls: " + getAverageCallDuration() + 
                            " number of calls charged at original rate: " + getNumOrigCallsMade() +
                            " number of calls charged at cheaper rate: " + getNumCheapCallsMade() + 
                            " number of total calls made: " + getTotalNumCallsMade()
                            );
    }
}
