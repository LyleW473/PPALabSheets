import java.util.Random;

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
     * @param rowIndex The row index.
     * @param seatIndex The seat index.
     * @return Boolean indicating whether the booking was successful or not.
     */
    public boolean bookSeat(int rowIndex, int seatIndex)
    {
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
     * Creates a ticket for a random available seat at this screen.
     * @return Ticket object containing the screen ID, row number, seat number and movie details if there is an available seat, otherwise null.
     */
    public Ticket getRandomTicket()
    {   
        // No seats left
        if (numAvailableSeats == 0)
        {
            return null;
        }

        // Keep generating random row and column indexes until an available seat is found
        int rowIndex = 0;
        int colIndex = 0;
        Random randomGen = new Random();
        while (!bookSeat(rowIndex, colIndex))
        {
            rowIndex = randomGen.nextInt(this.numRows);
            colIndex = randomGen.nextInt(this.numCols);
        }

        int rowNumber = rowIndex + 1;
        int seatNumber = colIndex + 1;
        return new Ticket(this.id, rowNumber, seatNumber, this.movie.getTitle(), this.movie.getCost());
    }

    /**
     * Creates a ticket for the best seat at this screen.
     * @return Ticket object containing the screen ID, row number, seat number and movie details if the best seat is available, otherwise null.
     */
    public Ticket getBestTicket()
    {
        int bestRowIndex = numRows / 2;
        int bestColIndex = numCols / 2;
        if (seats[bestRowIndex][bestColIndex] == 1) // Check if this seat is available
        {
            return null;
        }

        double movieCost = this.movie.getCost() * 1.2; // 20% extra cost
        int rowNumber = bestRowIndex + 1;
        int seatNumber = bestColIndex + 1;
        return new Ticket(this.id, rowNumber, seatNumber, this.movie.getTitle(), movieCost);
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