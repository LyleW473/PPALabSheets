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
        ticketOffice.addScreen(1, 5, 10);
        ticketOffice.showNewMovie(0, "Lyle, Lyle, Crocodile", 3.25);
        ticketOffice.showNewMovie(1, "Kung Fu Panda 4", 10.00);

        ticketOffice.showMovies();

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
        int i = 1;
        for (Screen s: screenIDHashMap.values())
        {
            String movieTitle = s.getMovie().getTitle();
            double movieCost = s.getMovie().getCost();
            System.out.println("Screen number: " + i + " | Movie title: " + movieTitle + " | Movie cost: " + movieCost);
            i += 1;
        }
    }

    public Screen bookRandomTicket(String movieTitle)
    {
        return null;
    }
}
