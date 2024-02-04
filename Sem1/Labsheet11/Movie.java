public class Movie 
{
    private String movieTitle;
    private double movieCost;

    public Movie(String movieTitle, double movieCost)
    {
        this.movieTitle = movieTitle;
        this.movieCost = movieCost;
    }

    /**
     * @return The title of the movie.
     */
    public String getTitle()
    {
        return this.movieTitle;
    }

    /**
     * @return The cost of the movie.
     */
    public double getCost()
    {
        return this.movieCost;
    }
}
