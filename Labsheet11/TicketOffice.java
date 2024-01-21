import java.util.HashMap;

public class TicketOffice 
{
    private HashMap<Integer, Screen> screenIDHashMap = new HashMap<Integer, Screen>();

    public TicketOffice()
    {
    }

    public static void main(String[] args) {
        TicketOffice ticketOffice1 = new TicketOffice();
        ticketOffice1.addScreen(0, 4, 5);

        Screen screen1 = new Screen(0, "Lyle, Lyle, Crocodile", 3.25, 4, 5);
        System.out.println(screen1.bookSeat(0, 1));
        System.out.println(screen1.bookSeat(1, 3));
        System.out.println(screen1.bookSeat(1, 3));
        screen1.changeMovie("Kung Fu Panda 4", 10);

    }

    /**
     * Adds a new screen using a provided ID, number of rows and number of columns.
     * @param screenID The ID to assign to the screen.
     * @param numRows Number of rows in this screen.
     * @param numCols Number of columns in this screen.
     */
    public void addScreen(int screenID, int numRows, int numCols)
    {      
        Screen newScreen = new Screen(screenID, "", Double.parseDouble("0"), numRows, numCols); // Create a new screen that shows no movie
        this.screenIDHashMap.put(screenID, newScreen); // Create new mapping
    }

    public void findScreen(int screenID)
    {
    }

    public void showNewMovie(int screenID, String movieTitle, double movieCost)
    {
    }
    
    public void showMovies()
    {
    }

    public Screen bookRandomTicket(String movieTitle)
    {
        return null;
    }
}
