package Solution;

/**
 * The main application class for the Movie Ticket Sales Report.
 * This class contains the entry point (`main` method) and orchestrates the
 * creation of data, calculation of results, and display of the report using
 * single and two-dimensional arrays.
 *
 * @author PROG6112 Examination
 * @version 1.0
 */
public class MovieSalesReport
{

    /**
     * The main entry point for the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args)
    {
        // --- 1. Define the raw data using a two-dimensional array ---
        // The outer array represents each movie. The inner arrays represent monthly sales.
        // Row 0: Napoleon's sales [Jan, Feb, Mar]
        // Row 1: Oppenheimer's sales [Jan, Feb, Mar]
        // (Lowe, 2005, Book IV, Chapter 2)
        int[][] monthlySalesData =
                {
                        {3000, 1500, 1700}, // Napoleon
                        {3500, 1200, 1600}  // Oppenheimer
                };

        // --- 2. Define the movie names using a single-dimensional array ---
        // The order of names must match the order of rows in the monthlySalesData array.
        String[] movieNames = {"Napoleon", "Oppenheimer"};

        // --- 3. Create an instance of MovieTickets to perform calculations ---
        MovieTickets calculator = new MovieTickets();

        // --- 4. Calculate total sales for each movie and store results ---
        // We need to store the totals to later find the top movie. We'll use a single-dimensional array.
        int[] totalSalesForMovies = new int[movieNames.length];

        for (int i = 0; i < movieNames.length; i++)
        {
            // Get the monthly sales data for the current movie.
            int[] monthlySalesForThisMovie = monthlySalesData[i];
            // Calculate the total using the method from our MovieTickets class.
            totalSalesForMovies[i] = calculator.TotalMovieSales(monthlySalesForThisMovie);
        }

        // --- 5. Determine the top-performing movie ---
        String topMovie = calculator.TopMovie(movieNames, totalSalesForMovies);

        // --- 6. Display the report ---
        displayReport(movieNames, monthlySalesData, totalSalesForMovies, topMovie);
    }

    /**
     * Displays the formatted movie ticket sales report to the console.
     *
     * @param movieNames An array of movie names.
     * @param monthlySalesData A 2D array of monthly sales data.
     * @param totalSalesForMovies An array of total sales for each movie.
     * @param topMovie The name of the top-performing movie.
     */
    private static void displayReport(String[] movieNames, int[][] monthlySalesData, int[] totalSalesForMovies, String topMovie)
    {
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        // Print the month headers.
        System.out.println("JAN\tFEB\tMAR");

        // Print the sales data for each movie row by row.
        for (int i = 0; i < movieNames.length; i++)
        {
            // Print the movie name first.
            System.out.print(movieNames[i] + "\t");
            // Print the monthly sales for that movie.
            for (int j = 0; j < monthlySalesData[i].length; j++)
            {
                System.out.print(monthlySalesData[i][j] + "\t");
            }
            // Move to the next line after printing all months for a movie.
            System.out.println();
        }

        // Print a blank line for separation.
        System.out.println();

        // Print the total sales for each movie.
        for (int i = 0; i < movieNames.length; i++)
        {
            System.out.println("Total movie ticket sales for " + movieNames[i] + " \u00A3" + totalSalesForMovies[i]);
        }

        // Print the top-performing movie.
        System.out.println("\nTop performing movie: " + topMovie);
    }
}