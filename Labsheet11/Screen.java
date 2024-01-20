public class Screen 
{
    private int id;
    private int[][] seats; // 0 = Empty, 1 = Occupied, -2 = 
    private String movieTitle;
    private double movieCost;
    private int numAvailableSeats;
    private int numRows;
    private int numCols;

    public static void main(String[] args) {
        Screen screen1 = new Screen(0, "Lyle, Lyle, Crocodile", 3.25, 4, 16);
    }

    public Screen(int id, String movieTitle, double movieCost, int numRows, int numAvailableSeats)
    {      
        // Exception for invalid arguments
        if (numRows == 0 || numAvailableSeats == 0)
        {
            throw new IllegalArgumentException("Enter a valid number of rows and available seats when creating a new'Screen' object!");
        }

        this.id = id;
        this.movieTitle = movieTitle;
        this.movieCost = movieCost;
        this.numRows = numRows;
        this.numAvailableSeats = numAvailableSeats;

        // Initialise all seats
        this.numCols = (numAvailableSeats + numRows - 1) / numRows; // Find the number of columns for each row
        seats = new int[numRows][numCols];
        emptyScreen();
    }
    
    /**
     * Resets the seats of the screen to its initial starting state
     */
    public void emptyScreen()
    {
        // If there are an "excess" amount of seats that were created, remove them
        int seatsToRemoveStart = (numRows * numCols) - numAvailableSeats;
        if (seatsToRemoveStart > 0)
        {
            // Mark the seats that aren't available with the special value (-1)
            for (int i = numCols - seatsToRemoveStart; i < numCols; i++)
            {
                seats[numRows - 1][i] = -1;
            }
        }
        
        for (int i = 0; i < numRows; i ++)
        {
            for (int j = 0; j < numCols; j++)
            {
                System.out.println(i + " " + j + " " + seats[i][j]);
            }
        }
    }
}
