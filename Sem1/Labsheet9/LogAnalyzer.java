import java.util.HashMap;

/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{


    // Where to calculate the minute access counts.
    private int[] minuteCounts;

    // Where to calculate the hourly access counts.
    private int[] hourCounts;

    // Where to calculate the daily access counts.
    private int[] dayCounts;

    // Where to calculate the monthly access counts.
    private int[] monthCounts;

    // Where to calculate the yearly access counts.
    private int[] yearCounts;


    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    public static void main(String[] args)
    {   
        String desiredFileName = "lyle.txt";
        LogfileCreator myLogfileCreator = new LogfileCreator();
        myLogfileCreator.createFile(desiredFileName, 20);

        LogAnalyzer myLogAnalyzer = new LogAnalyzer(desiredFileName);
        myLogAnalyzer.printData();

        myLogAnalyzer.analyzeData("minute");
        myLogAnalyzer.busiestX("minute");
        myLogAnalyzer.quietestX("minute");
        myLogAnalyzer.busiestTwoXPeriod("minute");

        myLogAnalyzer.analyzeData("hour");
        myLogAnalyzer.numberOfAccesses();
        myLogAnalyzer.busiestX("hour");
        myLogAnalyzer.quietestX("hour");
        myLogAnalyzer.busiestTwoXPeriod("hour");

        myLogAnalyzer.analyzeData("day");
        myLogAnalyzer.busiestX("day");
        myLogAnalyzer.quietestX("day");
        myLogAnalyzer.busiestTwoXPeriod("day");

        myLogAnalyzer.analyzeData("month");
        myLogAnalyzer.busiestX("month");
        myLogAnalyzer.quietestX("month");
        myLogAnalyzer.busiestTwoXPeriod("month");

        myLogAnalyzer.analyzeData("year");
        myLogAnalyzer.busiestX("year");
        myLogAnalyzer.quietestX("year");
        myLogAnalyzer.busiestTwoXPeriod("year");

    }
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the minute access counts.
        minuteCounts = new int[60];

        // Create the array object to hold the hourly access counts.
        hourCounts = new int[24];

        // Create the array object to hold the daily access counts.
        dayCounts = new int[29];

        // Create the array object to hold the monthly access counts.
        monthCounts = new int[13];

        // Create the array object to hold the yearly access counts.
        yearCounts = new int[2017];

        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);
    }
 
    /**
     * Analyze the daily access data from the log file.
     */
    public void analyzeData(String time)
    {   
        int[] countsArray = selectCorrectArray(time);
        while(reader.hasNext()) 
        {   
            LogEntry entry = reader.next();
            int i = entry.getTime(time);
            countsArray[i]++;
        }

        reader.reset(); // Reset reader for entries
        printCounts(time);
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printCounts(String time)
    {  
        int[] countsArray = selectCorrectArray(time);
        System.out.println(time + ": Count");
        for(int i = 0; i < countsArray.length; i++) {
            System.out.println(i + ": " + countsArray[i]);
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
     * Returns the dictionary for the correct time
     */
    public int[] selectCorrectArray(String time)
    {
        String lowerCaseTime = time.toLowerCase();
        
        if (lowerCaseTime.equals("year"))
        {
           return yearCounts;
        }
        else if (lowerCaseTime.equals("month"))
        {
           return monthCounts;
        }
        else if (lowerCaseTime.equals("day"))
        {
           return dayCounts;
        }
        else if (lowerCaseTime.equals("hour"))
        {
            return hourCounts;
        }
        else if (lowerCaseTime.equals("minute"))
        {
           return minuteCounts;
        }
        else
        {
            throw new IllegalArgumentException("Invalid time");
        }
    }

    /**
     * Prints the busiest hour and its access count
     * - If there are multiple hours with the same access count, the first one that appears will be selected.
     */
    public int busiestX(String time)
    {   
        int[] countsArray = selectCorrectArray(time);
        int indexHighest = 0;
        int valHighest = 0;

        for (int i = 0; i < countsArray.length; i ++)
        {
            if (countsArray[i] > valHighest)
            {
                valHighest = countsArray[i];
                indexHighest = i;
            }
        }

        System.out.println("The busiest " + time + " is '" + indexHighest + "' with a count of " + valHighest);
        return indexHighest;
    }

    /**
     * Prints the quietest X and its access count
     * - If there are multiple Xs with the same access count, the first one that appears will be selected.
     */
    public int quietestX(String time)
    {   
        int[] countsArray = selectCorrectArray(time);
        int indexLowest = 0;
        int valLowest = 0;

        for (int i = 0; i < countsArray.length; i ++)
        {
            if (countsArray[i] < valLowest)
            {
                valLowest = countsArray[i];
                indexLowest = i;
            }
        }
        
        System.out.println("The quietest " + time + " is '" + indexLowest + "' with a count of " + valLowest);
        return indexLowest;
    }

    /**
     * Prints the busiest two X period and its access count
     * - If there are multiple Xs with the same access count, the first one that appears will be selected.
     */
    public int busiestTwoXPeriod(String time)
    {
        int[] countsArray = selectCorrectArray(time);
        int indexHighest = 0;
        int valHighest = 0;
        int currentCount = 0;

        for (int i = 0; i < countsArray.length - 1; i ++)
        {
            currentCount = countsArray[i] + countsArray[i + 1];
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
