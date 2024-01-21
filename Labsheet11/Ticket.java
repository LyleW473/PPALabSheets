import java.util.Date;

public class Ticket 
{
    private static int totalTicketsCreated = 0;

    private int screenID;
    private int rowNumber;
    private int seatNumber;
    private String movieTitle;
    private double movieCost;
    private Date timeCreated;

    public Ticket(int screenID, int rowNumber, int seatNumber, String movieTitle, double movieCost)
    {
        this.screenID = screenID;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.movieTitle = movieTitle;
        this.movieCost = movieCost;
        this.timeCreated = new Date();

        // Increment number of total tickets created
        Ticket.totalTicketsCreated ++;
    }

    /**
     * @return The total number of tickets created.
     */
    public static int getNumTicketsCreated()
    {
        return Ticket.totalTicketsCreated;
    }

    /**
     * Print out the details of the ticket.
     */
    public void printDetails()
    {
        System.out.println("Screen ID: "  + screenID + " | Movie title: " + movieTitle + " | Movie cost: " + movieCost + " | Row: " + rowNumber + " | Seat: " + seatNumber);
    }
}
