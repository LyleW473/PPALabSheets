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
        myLogAnalyzer.printHourlyCounts();
        myLogAnalyzer.numberOfAccesses();
        myLogAnalyzer.busiestHour();
    }
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
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
}
