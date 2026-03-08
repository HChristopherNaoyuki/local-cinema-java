package Solution;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit 4 test class for the MovieTickets application.
 * This class contains unit tests to verify the functionality of the
 * TotalMovieSales and TopMovie methods as required by the examination.
 *
 * @version 1.0
 */
public class MovieTicketsTest
{
    
    public MovieTicketsTest()
    {
        // Default constructor for JUnit test class
    }

    /**
     * Test 1: CalculateTotalSales_ReturnsExpectedTotalSales
     * Purpose: To verify that the TotalMovieSales method correctly sums the values
     *          in a given array. This test corresponds to the first required test
     *          in the examination paper.
     */
    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales()
    {
        // --- Arrange (Set up the test data) ---
        // Create an instance of the class we want to test.
        IMovieTickets calculator = new MovieTickets();

        // Define the input data: monthly sales for a movie.
        // For this test, we'll use Napoleon's sales from the main assignment.
        int[] napoleonSales = {3000, 1500, 1700};

        // Define the expected result. 3000 + 1500 + 1700 = 6200
        int expectedTotal = 6200;

        // --- Act (Execute the method being tested) ---
        int actualTotal = calculator.TotalMovieSales(napoleonSales);

        // --- Assert (Verify the result is as expected) ---
        assertEquals("The total sales calculated for Napoleon should be 6200.",
                     expectedTotal, actualTotal);
    }

    /**
     * Test 2: TopMovieSales_ReturnsTopMovie
     * Purpose: To verify that the TopMovie method correctly identifies the movie
     *          with the highest total sales. This test corresponds to the second
     *          required test in the examination paper.
     */
    @Test
    public void TopMovieSales_ReturnsTopMovie()
    {
        // --- Arrange (Set up the test data) ---
        IMovieTickets calculator = new MovieTickets();

        // Define the movie names.
        String[] movieNames = {"Napoleon", "Oppenheimer"};

        // Define the total sales for each movie, calculated as per the main application.
        // Napoleon total: 6200, Oppenheimer total: 3500+1200+1600 = 6300
        int[] totalSales = {6200, 6300};

        // Define the expected top movie.
        String expectedTopMovie = "Oppenheimer";

        // --- Act (Execute the method being tested) ---
        String actualTopMovie = calculator.TopMovie(movieNames, totalSales);

        // --- Assert (Verify the result is as expected) ---
        assertEquals("The top-performing movie should be Oppenheimer with 6300 total sales.",
                     expectedTopMovie, actualTopMovie);
    }

    /**
     * Additional Test 3: TopMovieSales_HandlesNullInput
     * Purpose: To verify that the TopMovie method handles null input gracefully
     *          without throwing a NullPointerException. This demonstrates robust
     *          error handling.
     */
    @Test
    public void TopMovieSales_HandlesNullInput()
    {
        // --- Arrange ---
        IMovieTickets calculator = new MovieTickets();

        // --- Act ---
        String result = calculator.TopMovie(null, null);

        // --- Assert ---
        // Verify that the result is not null and contains an error message
        assertNotNull("Result should not be null even with null input.", result);
        assertTrue("Result should contain an error message for null input.",
                   result.contains("Error") || result.contains("null"));
    }

    /**
     * Additional Test 4: TopMovieSales_HandlesMismatchedArrayLengths
     * Purpose: To verify that the TopMovie method handles arrays of different lengths
     *          appropriately, returning an error message rather than crashing.
     */
    @Test
    public void TopMovieSales_HandlesMismatchedArrayLengths()
    {
        // --- Arrange ---
        IMovieTickets calculator = new MovieTickets();
        String[] movieNames = {"Napoleon", "Oppenheimer", "Damsel"};
        int[] totalSales = {6200, 6300};

        // --- Act ---
        String result = calculator.TopMovie(movieNames, totalSales);

        // --- Assert ---
        assertNotNull("Result should not be null with mismatched array lengths.", result);
        assertTrue("Result should contain an error message about mismatched lengths.",
                   result.contains("Error") || result.contains("mismatch"));
    }

    /**
     * Additional Test 5: TotalMovieSales_HandlesNullInput
     * Purpose: To verify that the TotalMovieSales method handles null input gracefully
     *          by returning 0 instead of throwing a NullPointerException.
     */
    @Test
    public void TotalMovieSales_HandlesNullInput()
    {
        // --- Arrange ---
        IMovieTickets calculator = new MovieTickets();

        // --- Act ---
        int result = calculator.TotalMovieSales(null);

        // --- Assert ---
        assertEquals("Total sales for null input should return 0.", 0, result);
    }

    /**
     * Additional Test 6: TotalMovieSales_ReturnsZeroForEmptyArray
     * Purpose: To verify that the TotalMovieSales method returns 0 for an empty array,
     *          which is the correct mathematical sum of an empty set.
     */
    @Test
    public void TotalMovieSales_ReturnsZeroForEmptyArray()
    {
        // --- Arrange ---
        IMovieTickets calculator = new MovieTickets();
        int[] emptySales = {};

        // --- Act ---
        int result = calculator.TotalMovieSales(emptySales);

        // --- Assert ---
        assertEquals("Total sales for an empty array should return 0.", 0, result);
    }

    /**
     * Additional Test 7: TopMovieSales_HandlesEmptyArrays
     * Purpose: To verify that the TopMovie method handles empty arrays appropriately.
     */
    @Test
    public void TopMovieSales_HandlesEmptyArrays()
    {
        // --- Arrange ---
        IMovieTickets calculator = new MovieTickets();
        String[] emptyMovies = {};
        int[] emptySales = {};

        // --- Act ---
        String result = calculator.TopMovie(emptyMovies, emptySales);

        // --- Assert ---
        assertNotNull("Result should not be null with empty arrays.", result);
        assertTrue("Result should contain an error message about empty arrays.",
                   result.contains("Error") || result.contains("empty"));
    }

    /**
     * Additional Test 8: TotalMovieSales_CalculatesCorrectlyForSingleElement
     * Purpose: To verify that the TotalMovieSales method works correctly for
     *          an array with a single element.
     */
    @Test
    public void TotalMovieSales_CalculatesCorrectlyForSingleElement()
    {
        // --- Arrange ---
        IMovieTickets calculator = new MovieTickets();
        int[] singleSale = {5000};

        // --- Act ---
        int result = calculator.TotalMovieSales(singleSale);

        // --- Assert ---
        assertEquals("Total sales for a single element array should return that element.",
                     5000, result);
    }
}