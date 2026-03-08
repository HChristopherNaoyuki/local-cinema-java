package Solution;

/**
 * This class implements the IMovieTickets interface and provides the concrete
 * logic for calculating total movie sales and determining the top-performing movie.
 *
 * @author PROG6112 Examination
 * @version 1.0
 */
public class MovieTickets implements IMovieTickets
{

    /**
     * Calculates the total sales for a single movie by summing the ticket sales
     * for each month.
     *
     * @param movieTicketSales An integer array of monthly ticket sales.
     * @return The sum of all elements in the input array. Returns 0 if the array is null.
     */
    @Override
    public int TotalMovieSales(int[] movieTicketSales)
    {
        // Defensive check: if the input array is null, return 0 to avoid a NullPointerException.
        if (movieTicketSales == null)
        {
            return 0;
        }

        int total = 0;
        // Iterate through each monthly sales figure and add it to the total.
        for (int monthlySales : movieTicketSales)
        {
            total += monthlySales;
        }
        return total;
    }

    /**
     * Determines the top-performing movie by comparing the total sales figures.
     *
     * @param movies A String array of movie names.
     * @param totalSales An integer array of total sales corresponding to each movie.
     * @return The name of the movie with the highest total sales. Returns an error message
     *         if the input data is invalid (null, empty, or length mismatch).
     */
    @Override
    public String TopMovie(String[] movies, int[] totalSales)
    {
        // --- Input Validation ---
        // Check if either array is null.
        if (movies == null || totalSales == null)
        {
            return "Error: Movie names or sales data cannot be null.";
        }

        // Check if arrays are empty.
        if (movies.length == 0 || totalSales.length == 0)
        {
            return "Error: Movie names or sales data arrays are empty.";
        }

        // Check if array lengths match. They must have the same number of elements.
        if (movies.length != totalSales.length)
        {
            return "Error: Mismatch between number of movies and sales data entries.";
        }

        // --- Find the movie with the maximum sales ---
        // Assume the first movie is the top performer initially.
        int maxIndex = 0;
        int maxSales = totalSales[0];

        // Loop through the rest of the movies to find a higher total.
        for (int i = 1; i < totalSales.length; i++)
        {
            if (totalSales[i] > maxSales)
            {
                maxSales = totalSales[i];
                maxIndex = i;
            }
        }

        // Return the name of the movie at the index where the maximum sales were found.
        return movies[maxIndex];
    }
}