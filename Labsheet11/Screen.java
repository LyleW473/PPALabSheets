public class Screen 
{
    private int id;
    private int[][] seats; // 0 = Empty, 1 = Occupied, -2 = Excess
    private Movie movie;

    private int numAvailableSeats;
    private int numRows;
    private int numCols;

    public Screen(int id, String movieTitle, double movieCost, int numRows, int numCols)
    {      
        // Exception for invalid arguments
        if (numRows == 0 || numCols == 0)
        {
            throw new IllegalArgumentException("Enter a valid number of rows and columns when creating a new 'Screen' object!");
        }

        this.id = id;
        this.movie = null;

        // Initialise all seats
        this.numRows = numRows;
        this.numCols = numCols;
        this.numAvailableSeats = numRows * numCols;
        seats = new int[numRows][numCols];
        emptyScreen();
    }
    
    /**
     * Resets the seats of the screen to its initial starting state.
     */
    public void emptyScreen()
    {
        // Set all seats to 0
        for (int i = 0; i < numRows; i ++)
        {
            for (int j = 0; j < numCols; j++)
            {
                seats[i][j] = 0;
            }
        }

        // for (int i = 0; i < numRows; i ++)
        // {
        //     for (int j = 0; j < numCols; j++)
        //     {
        //         System.out.println(i + " " + j + " " + seats[i][j]);
        //     }
        // }

        // Reset the number of available seats in this screen
        this.numAvailableSeats = numRows * numCols;
    }

    /**
     * Resets the seats of the screen to its initial starting state
     * @param rowNumber The row number on the Ticket.
     * @param seatNumber The seat number on the Ticket.
     * @return Boolean indicating whether the booking was successful or not.
     */
    public boolean bookSeat(int rowNumber, int seatNumber)
    {
        // Row and seat number starts from 0, not 1
        int rowIndex = rowNumber - 1;
        int seatIndex = seatNumber - 1;

        // Check if row and seat indexes are valid and that the seat hasn't already been booked
        if ((0 <= rowIndex && rowIndex < numRows) && (0 <= seatIndex && seatIndex < numCols) && (seats[rowIndex][seatIndex] != 1))
        {
            seats[rowIndex][seatIndex] = 1; // Set as booked
            numAvailableSeats -= 1; // Take away one available seat
            return true;
        }
        return false;
    }

    /**
     * Changes the movie currently shown on this screen.
     * @param movieTitle The new movie's title.
     * @param movieCost The new movie's cost.
     */
    public void changeMovie(String movieTitle, double movieCost)
    {
        this.movie = new Movie(movieTitle, movieCost);
        emptyScreen();
    }

    /**
     * @return The movie displayed on this screen.
     */
    public Movie getMovie()
    {
        return this.movie;
    }

    /**
     * @return The ID of this screen.
     */
    public int getID()
    {
        return this.id;
    }
}