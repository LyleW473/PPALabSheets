/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;

    // Where to calculate the daily access counts.
    private int[] dayCounts;
    
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    public static void main(String[] args)
    {   
        String desiredFileName = "lyle.txt";
        LogfileCreator myLogfileCreator = new LogfileCreator();
        myLogfileCreator.createFile(desiredFileName, 20);

        LogAnalyzer myLogAnalyzer = new LogAnalyzer(desiredFileName);
        myLogAnalyzer.printData();
        myLogAnalyzer.analyzeHourlyData();
        myLogAnalyzer.numberOfAccesses();
        myLogAnalyzer.busiestHour();
        myLogAnalyzer.quietestHour();
        myLogAnalyzer.busiestTwoHourPeriod();

        // Challenge methods
        myLogAnalyzer.analyzeDailyData();
    }
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the hourly access counts.
        hourCounts = new int[24];

        // Create the array object to hold the daily access counts.
        dayCounts = new int[29];

        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);
    }

    /**
     * Analyze the daily access data from the log file.
     */
    public void analyzeDailyData()
    {   
        while(reader.hasNext()) 
        {   
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dayCounts[day]++;
        }

        reader.reset(); // Reset reader for entries
        printDailyCounts();
    }

    /**
     * Print the daily counts.
     * These should have been set with a prior
     * call to analyzeDailyData.
     */
    public void printDailyCounts()
    {
        System.out.println("Day: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) 
        {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }

        reader.reset(); // Reset reader for entries
        printHourlyCounts();
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }

    /**
     * Prints the number of total number of accesses
     */
    public void numberOfAccesses()
    {
        int sum = 0;
        for (int count: hourCounts)
        {
            sum += count;
        }
        System.out.println("Number of accesses: " + sum);
    }
    
    /**
     * Prints the busiest hour and its access count
     * - If there are multiple hours with the same access count, the first one that appears will be selected.
     */
    public int busiestHour()
    {
        int indexHighest = 0;
        int valHighest = 0;

        for (int i = 0; i < hourCounts.length; i ++)
        {
            if (hourCounts[i] > valHighest)
            {
                valHighest = hourCounts[i];
                indexHighest = i;
            }
        }

        System.out.println("The busiest hour is '" + indexHighest + "' with a count of " + valHighest);
        return indexHighest;
    }

    /**
     * Prints the quietest hour and its access count
     * - If there are multiple hours with the same access count, the first one that appears will be selected.
     */
    public int quietestHour()
    {
        int indexLowest = 0;
        int valLowest = 0;

        for (int i = 0; i < hourCounts.length; i ++)
        {
            if (hourCounts[i] < valLowest)
            {
                valLowest = hourCounts[i];
                indexLowest = i;
            }
        }
        
        System.out.println("The quietest hour is '" + indexLowest + "' with a count of " + valLowest);
        return indexLowest;
    }

    /**
     * Prints the busiest two hour period and its access count
     * - If there are multiple hours with the same access count, the first one that appears will be selected.
     */
    public int busiestTwoHourPeriod()
    {
        int indexHighest = 0;
        int valHighest = 0;
        int currentCount = 0;

        for (int i = 0; i < hourCounts.length - 1; i ++)
        {
            currentCount = hourCounts[i] + hourCounts[i + 1];
            if (currentCount > valHighest)
            {
                valHighest = currentCount;
                indexHighest = i;
            }
        }

        System.out.println("The busiest two hour period starts from '" + indexHighest + "' with a count of " + valHighest);
        return indexHighest;
    }

}
