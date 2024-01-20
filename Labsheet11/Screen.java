public class Screen 
{
    private int id;
    private int[][] seats; // 0 = Empty, 1 = Occupied, -2 = Excess
    private String movieTitle;
    private double movieCost;
    private int numAvailableSeats;
    private int numRows;
    private int numCols;

    public static void main(String[] args) {
        Screen screen1 = new Screen(0, "Lyle, Lyle, Crocodile", 3.25, 4, 16);
        System.out.println(screen1.book(0, 1));
        System.out.println(screen1.book(1, 3));
        System.out.println(screen1.book(1, 3));
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

    /**
     * Resets the seats of the screen to its initial starting state
     * @param rowNumber The row number on the Ticket
     * @param seatNumber The seat number on the Ticket
     * @return Boolean indicating whether the booking was successful or not
     */
    public boolean book(int rowNumber, int seatNumber)
    {
        // Row and seat number starts from 0, not 1
        int rowIndex = rowNumber - 1;
        int seatIndex = seatNumber - 1;

        // Check if row and seat indexes are valid and that the seat hasn't already been booked
        if ((0 <= rowIndex && rowIndex < numRows) && (0 <= seatIndex && seatIndex < numCols) && (seats[rowIndex][seatIndex] != 1))
        {
            seats[rowIndex][seatIndex] = 1; // Set as booked
            return true;
        }
        return false;
    }
}