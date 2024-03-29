import java.util.HashMap;

public class TicketOffice 
{
    private HashMap<Integer, Screen> screenIDHashMap = new HashMap<Integer, Screen>();

    public TicketOffice()
    {
    }

    public static void main(String[] args) {
        TicketOffice ticketOffice = new TicketOffice();
        ticketOffice.addScreen(0, 4, 5);
        ticketOffice.addScreen(3, 4, 3);
        ticketOffice.showNewMovie(0, "Lyle, Lyle, Crocodile", 3.25);
        ticketOffice.showNewMovie(3, "Kung Fu Panda 4", 10.00);

        ticketOffice.showMovies();

        // Ticket ticket1 = ticketOffice.bookRandomTicket("Kung Fu Panda 4");
        // ticket1.printDetails();

        Ticket ticket2 = ticketOffice.bookBestTicket("Kung Fu Panda 4");
        ticket2.printDetails();

        for (int i = 0; i < 3; i ++)
        {
            Ticket[] tickets = ticketOffice.bookTickets(3, "Kung Fu Panda 4");
            if (tickets != null)
            {
                for (Ticket t: tickets)
                {
                    t.printDetails();
                }
            }
        }

        System.out.println(ticketOffice.bookSpecificTicket("Kung Fu Panda 4", 2, 2));
        System.out.println(ticketOffice.bookSpecificTicket("Kung Fu Panda 4", 3, 2));
        System.out.println(ticketOffice.bookSpecificTicket("Kung Fu Panda 4", 4, 0));
        System.out.println(ticketOffice.bookSpecificTicket("Kung Fu Panda 4", 3, 1));

    }

    /**
     * Adds a new screen using a provided ID, number of rows and number of columns.
     * @param screenID The ID to assign to the screen.
     * @param numRows Number of rows in this screen.
     * @param numCols Number of columns in this screen.
     */
    public void addScreen(int screenID, int numRows, int numCols)
    {      
        if (!screenIDHashMap.containsKey(screenID)) // Screen doesn't already exist
        {
            Screen newScreen = new Screen(screenID, "", Double.parseDouble("0"), numRows, numCols); // Create a new screen that shows no movie
            this.screenIDHashMap.put(screenID, newScreen); // Create new mapping
        }
    }

    /**
     * Finds the screen with the corresponding ID.
     * @param screenID The ID of the screen to find.
     * @return The screen with the corresponding ID, or null if not found.
     */
    public Screen findScreen(int screenID)
    {   
        if (this.screenIDHashMap.containsKey(screenID))
        {
            return this.screenIDHashMap.get(screenID);
        }
        return null;
    }

    /**
     * Finds the screen with the corresponding ID, and displays the new movie with the provided title and cost.
     * @param screenID The ID of the screen to display the new movie.
     * @param movieTitle The new movie's title.
     * @param movieCost The new movie's cost.
     */
    public void showNewMovie(int screenID, String movieTitle, double movieCost)
    {   
        Screen movieScreen = findScreen(screenID);
        if (movieScreen != null)
        {
            movieScreen.changeMovie(movieTitle, movieCost);
        }
    }

    /**
     * Displays the title and cost of all movies on all screens.
     */
    public void showMovies()
    {   
        for (Screen s: screenIDHashMap.values())
        {   
            Movie screenMovie = s.getMovie();
            if (screenMovie == null)
            {
                continue;
            }
            int screenID = s.getID();
            String movieTitle = screenMovie.getTitle();
            double movieCost = screenMovie.getCost();
            System.out.println("Screen ID: " + screenID + " | Movie title: " + movieTitle + " | Movie cost: " + movieCost);
        }
    }

    /**
     * Finds the movie with the the provided movie title.
     * @return The screen displaying the movie with the provided movie title, if not found, return null.
     */
    public Screen findMovie(String movieTitle)
    {
        for (Screen screen: screenIDHashMap.values())
        {
            if (screen.getMovie().getTitle().equals(movieTitle))
            {
                return screen;
            }
        }
        return null;
    }

    /**
     * Returns a random ticket at the movie with the provided movie title.
     * @return A random ticket at the movie with the provided movie title. Returns null if no seats were available.
     */
    public Ticket bookRandomTicket(String movieTitle)
    {
        Screen screen = findMovie(movieTitle);
        if (screen == null)
        {
            return null;
        }
        return screen.getRandomTicket();
    }

    /**
     * Returns a ticket to the best seat at the movie with the provided movie title.
     * @return Aticket to the best seat at the movie with the provided movie title. Returns null if the best seat is not available.
     */
    public Ticket bookBestTicket(String movieTitle)
    {
        Screen screen = findMovie(movieTitle);
        if (screen == null)
        {
            return null;
        }
        return screen.getBestTicket();
    }

    public Ticket bookSpecificTicket(String movieTitle, int rowNumber, int seatNumber)
    {
        Screen screen = findMovie(movieTitle);
        if (screen == null)
        {
            return null;
        }

        int rowIndex = rowNumber - 1;
        int colIndex = seatNumber - 1;

        return screen.getSpecificTicket(rowIndex, colIndex);
    }

    /**
     * Returns a random ticket at the movie with the provided movie title.
     * @return A random ticket at the movie with the provided movie title. Returns null if no seats were available.
     */
    public Ticket[] bookTickets(int n, String movieTitle)
    {   
        Screen screen = findMovie(movieTitle);
        if (screen == null)
        {
            return null;
        }
        return screen.getNeighbouringTickets(n);
    }
}
