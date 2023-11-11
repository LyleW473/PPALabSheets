/**
 * Details of a phone rate.
 * Rates are described in terms of a one-off connection cost applied
 * to all calls, and a per-minute rate in cents.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2017.10.15
 */
public class PhoneRate
{
    // The one-off connection cost for each call.
    private int connectionCost;
    // The cost in cents for each minute of the call.
    private int centsPerMinute;

    /**
     * Constructor for objects of class PhoneRate.
     * @param connectionCost A one off charge for each call.
     * @param centsPerMinute The cost in cents per whole minute.
     */
    public PhoneRate(int connectionCost, int centsPerMinute)
    {
        this.connectionCost = connectionCost;
        this.centsPerMinute = centsPerMinute;
    }

    /**
     * Calculate the cost of a call lasting the given length of time.
     * @param duration The length of the call in seconds.
     * @return The cost of the call in cents.
     */
    public int calculateCost(int duration)
    {
        return connectionCost + (duration * centsPerMinute) / 60;
    }
}
