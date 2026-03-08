package Solution;

/**
 * Interface defining the core operations for movie ticket sales analysis.
 * This interface establishes a contract for any class that processes movie ticket data,
 * ensuring that methods for calculating total sales and identifying the top-performing
 * movie are implemented.
 *
 * @author PROG6112 Examination
 * @version 1.0
 */
public interface IMovieTickets
{
    /**
     * Calculates the total sales for a single movie based on its monthly ticket sales.
     *
     * @param movieTicketSales An integer array containing the ticket sales for a movie
     *                         for each month (January, February, March). The array
     *                         is expected to have at least three elements.
     * @return The total number of tickets sold for the movie as an integer.
     */
    int TotalMovieSales(int[] movieTicketSales);

    /**
     * Determines which movie from the provided list has the highest total sales.
     *
     * @param movies A String array containing the names of the movies.
     * @param totalSales An integer array containing the total sales for each corresponding movie
     *                   in the 'movies' array. The indices of both arrays must align.
     * @return The name of the movie with the highest total sales as a String.
     *         If the arrays are null, empty, or of mismatched lengths, an appropriate
     *         error message or a default value should be returned to prevent crashes.
     */
    String TopMovie(String[] movies, int[] totalSales);
}