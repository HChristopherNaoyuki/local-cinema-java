# Solution Package Documentation

## Table of Contents

1. [Introduction](#1-introduction)
   - 1.1 [Purpose](#11-purpose)
   - 1.2 [Scope](#12-scope)
   - 1.3 [System Overview](#13-system-overview)

2. [Interface Documentation: IMovieTickets.java](#2-interface-documentation-imovieticketsjava)
   - 2.1 [Interface Overview](#21-interface-overview)
   - 2.2 [Method: TotalMovieSales](#22-method-totalmoviesales)
   - 2.3 [Method: TopMovie](#23-method-topmovie)

3. [Class Documentation: MovieTickets.java](#3-class-documentation-movieticketsjava)
   - 3.1 [Class Overview](#31-class-overview)
   - 3.2 [Method: TotalMovieSales (Implementation)](#32-method-totalmoviesales-implementation)
   - 3.3 [Method: TopMovie (Implementation)](#33-method-topmovie-implementation)

4. [Class Documentation: MovieSalesReport.java](#4-class-documentation-moviesalesreportjava)
   - 4.1 [Class Overview](#41-class-overview)
   - 4.2 [Method: main](#42-method-main)
   - 4.3 [Method: displayReport](#43-method-displayreport)

5. [Unit Test Documentation: MovieTicketsTest.java](#5-unit-test-documentation-movieticketstestjava)
   - 5.1 [Test Class Overview](#51-test-class-overview)
   - 5.2 [Test: CalculateTotalSales_ReturnsExpectedTotalSales](#52-test-calculatetotalsales_returnsexpectedtotalsales)
   - 5.3 [Test: TopMovieSales_ReturnsTopMovie](#53-test-topmoviesales_returnstopmovie)
   - 5.4 [Test: TopMovieSales_HandlesNullInput](#54-test-topmoviesales_handlesnullinput)
   - 5.5 [Test: TopMovieSales_HandlesMismatchedArrayLengths](#55-test-topmoviesales_handlesmismatchedarraylengths)
   - 5.6 [Test: TotalMovieSales_HandlesNullInput](#56-test-totalmoviesales_handlesnullinput)
   - 5.7 [Test: TotalMovieSales_ReturnsZeroForEmptyArray](#57-test-totalmoviesales_returnszeroforemptyarray)
   - 5.8 [Test: TopMovieSales_HandlesEmptyArrays](#58-test-topmoviesales_handlesemptyarrays)
   - 5.9 [Test: TotalMovieSales_CalculatesCorrectlyForSingleElement](#59-test-totalmoviesales_calculatescorrectlyforsingleelement)

6. [Installation and Setup](#6-installation-and-setup)
   - 6.1 [Prerequisites](#61-prerequisites)
   - 6.2 [Project Structure](#62-project-structure)
   - 6.3 [Running the Application](#63-running-the-application)
   - 6.4 [Running Unit Tests](#64-running-unit-tests)

7. [Appendix: Coding Standards](#7-appendix-coding-standards)
   - 7.1 [Naming Conventions](#71-naming-conventions)
   - 7.2 [Code Formatting](#72-code-formatting)
   - 7.3 [Commenting Standards](#73-commenting-standards)

## 1. Introduction

### 1.1 Purpose

This document provides comprehensive technical documentation for the Solution package, 
a Java application developed for the PROG6112 Examination. The application processes movie 
ticket sales data and generates formatted sales reports. The documentation is intended for 
developers, testers, and maintainers who need to understand, use, or extend the functionality 
of this system.

### 1.2 Scope

The Solution package implements a complete solution for Question 1 of the PROG6112 examination. 
It demonstrates the following key programming concepts:

- Single and two-dimensional array manipulation
- Interface-based design
- Separation of concerns through class responsibility
- Unit testing with JUnit 4
- Defensive programming and input validation
- Formatted console output

### 1.3 System Overview

The system processes movie ticket sales data for two movies (Napoleon and Oppenheimer) across 
three months (January, February, and March 2024). It calculates total sales for each movie, 
identifies the top-performing movie, and displays a formatted report. The architecture follows 
an interface-based design pattern, with the `IMovieTickets` interface defining the contract for 
movie ticket operations and the `MovieTickets` class providing the concrete implementation.

## 2. Interface Documentation: IMovieTickets.java

### 2.1 Interface Overview

The `IMovieTickets` interface defines the core operations required for movie ticket sales 
analysis. It establishes a contract that any implementing class must fulfill, ensuring consistent 
behavior across different implementations. This design pattern promotes code reusability and 
maintainability.

**Package:** `Solution`

**Signature:**
```java
public interface IMovieTickets
```

### 2.2 Method: TotalMovieSales

**Purpose:** Calculates the total number of tickets sold for a single movie by summing its monthly sales figures.

**Signature:**
```java
int TotalMovieSales(int[] movieTicketSales)
```

**Parameters:**
| Parameter | Type | Description |
|-----------|------|-------------|
| `movieTicketSales` | `int[]` | An integer array containing the ticket sales for a movie for each month (January, February, March). |

**Return Value:**
| Type | Description |
|------|-------------|
| `int` | The total number of tickets sold for the movie. Returns 0 if the input array is null. |

**Example Usage:**
```java
IMovieTickets calculator = new MovieTickets();
int[] napoleonSales = {3000, 1500, 1700};
int total = calculator.TotalMovieSales(napoleonSales); // Returns 6200
```

### 2.3 Method: TopMovie

**Purpose:** Identifies the movie with the highest total sales from a list of movies and their corresponding sales totals.

**Signature:**
```java
String TopMovie(String[] movies, int[] totalSales)
```

**Parameters:**
| Parameter | Type | Description |
|-----------|------|-------------|
| `movies` | `String[]` | An array containing the names of the movies. |
| `totalSales` | `int[]` | An array containing the total sales for each corresponding movie. The indices must align with the `movies` array. |

**Return Value:**
| Type | Description |
|------|-------------|
| `String` | The name of the movie with the highest total sales. Returns an error message if the input data is invalid (null, empty, or mismatched lengths). |

**Example Usage:**
```java
IMovieTickets calculator = new MovieTickets();
String[] movies = {"Napoleon", "Oppenheimer"};
int[] totals = {6200, 6300};
String topMovie = calculator.TopMovie(movies, totals); // Returns "Oppenheimer"
```

## 3. Class Documentation: MovieTickets.java

### 3.1 Class Overview

The `MovieTickets` class implements the `IMovieTickets` interface, providing the concrete 
business logic for calculating total sales and identifying the top-performing movie. The 
class incorporates defensive programming practices to handle edge cases and invalid inputs 
gracefully.

**Package:** `Solution`

**Signature:**
```java
public class MovieTickets implements IMovieTickets
```

### 3.2 Method: TotalMovieSales (Implementation)

**Purpose:** Implements the interface method to calculate total sales by summing all elements 
in the input array.

**Algorithm:**
1. Check if the input array is null; if so, return 0 to prevent NullPointerException
2. Initialize a total variable to 0
3. Iterate through each monthly sales figure in the array
4. Add each figure to the running total
5. Return the final total

**Signature:**
```java
@Override
public int TotalMovieSales(int[] movieTicketSales)
```

**Implementation Details:**
```java
if (movieTicketSales == null)
{
    return 0;
}

int total = 0;
for (int monthlySales : movieTicketSales)
{
    total += monthlySales;
}
return total;
```

**Complexity Analysis:**
- Time Complexity: O(n) where n is the number of months (always 3 in this application)
- Space Complexity: O(1) as only a single integer variable is used

### 3.3 Method: TopMovie (Implementation)

**Purpose:** Implements the interface method to identify the movie with the highest total sales, 
with comprehensive input validation.

**Algorithm:**
1. Validate input parameters (null checks, empty checks, length matching)
2. If validation fails, return an appropriate error message
3. Assume the first movie is the top performer (initialize maxIndex = 0, maxSales = totalSales[0])
4. Iterate through the remaining movies
5. If a movie has higher sales than the current maximum, update maxIndex and maxSales
6. Return the name of the movie at the index where the maximum sales were found

**Signature:**
```java
@Override
public String TopMovie(String[] movies, int[] totalSales)
```

**Validation Rules:**
| Condition | Handling |
|-----------|----------|
| `movies == null` or `totalSales == null` | Returns "Error: Movie names or sales data cannot be null." |
| `movies.length == 0` or `totalSales.length == 0` | Returns "Error: Movie names or sales data arrays are empty." |
| `movies.length != totalSales.length` | Returns "Error: Mismatch between number of movies and sales data entries." |

**Implementation Details:**
```java
if (movies == null || totalSales == null)
{
    return "Error: Movie names or sales data cannot be null.";
}

if (movies.length == 0 || totalSales.length == 0)
{
    return "Error: Movie names or sales data arrays are empty.";
}

if (movies.length != totalSales.length)
{
    return "Error: Mismatch between number of movies and sales data entries.";
}

int maxIndex = 0;
int maxSales = totalSales[0];

for (int i = 1; i < totalSales.length; i++)
{
    if (totalSales[i] > maxSales)
    {
        maxSales = totalSales[i];
        maxIndex = i;
    }
}

return movies[maxIndex];
```

**Complexity Analysis:**
- Time Complexity: O(n) where n is the number of movies
- Space Complexity: O(1) as only a few integer variables are used

## 4. Class Documentation: MovieSalesReport.java

### 4.1 Class Overview

The `MovieSalesReport` class is the main application class that orchestrates the entire movie ticket sales reporting process. It creates and populates data structures, invokes the `MovieTickets` methods for calculations, and displays formatted output to the console.

**Package:** `Solution`

**Signature:**
```java
public class MovieSalesReport
```

### 4.2 Method: main

**Purpose:** The entry point of the application. It coordinates the entire workflow: data definition, calculation, and report display.

**Signature:**
```java
public static void main(String[] args)
```

**Algorithm:**
1. Define the monthly sales data using a two-dimensional array
   - Row 0: Napoleon's sales [Jan, Feb, Mar] = [3000, 1500, 1700]
   - Row 1: Oppenheimer's sales [Jan, Feb, Mar] = [3500, 1200, 1600]
2. Define the movie names array
3. Create an instance of `MovieTickets` for calculations
4. Calculate total sales for each movie and store in a results array
5. Determine the top-performing movie
6. Call `displayReport` to output formatted results

**Implementation Details:**
```java
int[][] monthlySalesData =
        {
                {3000, 1500, 1700},
                {3500, 1200, 1600}
        };

String[] movieNames = {"Napoleon", "Oppenheimer"};

MovieTickets calculator = new MovieTickets();
int[] totalSalesForMovies = new int[movieNames.length];

for (int i = 0; i < movieNames.length; i++)
{
    int[] monthlySalesForThisMovie = monthlySalesData[i];
    totalSalesForMovies[i] = calculator.TotalMovieSales(monthlySalesForThisMovie);
}

String topMovie = calculator.TopMovie(movieNames, totalSalesForMovies);
displayReport(movieNames, monthlySalesData, totalSalesForMovies, topMovie);
```

### 4.3 Method: displayReport

**Purpose:** Formats and displays the movie ticket sales report to the console. This method is private and only called from within the `MovieSalesReport` class.

**Signature:**
```java
private static void displayReport(String[] movieNames, int[][] monthlySalesData, int[] totalSalesForMovies, String topMovie)
```

**Parameters:**
| Parameter | Type | Description |
|-----------|------|-------------|
| `movieNames` | `String[]` | Array of movie names |
| `monthlySalesData` | `int[][]` | 2D array of monthly sales data |
| `totalSalesForMovies` | `int[]` | Array of total sales for each movie |
| `topMovie` | `String` | Name of the top-performing movie |

**Output Format:**
```
MOVIE TICKET SALES REPORT - 2024
JAN	FEB	MAR
Napoleon	3000	1500	1700	
Oppenheimer	3500	1200	1600	

Total movie ticket sales for Napoleon £6200
Total movie ticket sales for Oppenheimer £6300

Top performing movie: Oppenheimer
```

**Implementation Details:**
```java
System.out.println("MOVIE TICKET SALES REPORT - 2024");
System.out.println("JAN\tFEB\tMAR");

for (int i = 0; i < movieNames.length; i++)
{
    System.out.print(movieNames[i] + "\t");
    for (int j = 0; j < monthlySalesData[i].length; j++)
    {
        System.out.print(monthlySalesData[i][j] + "\t");
    }
    System.out.println();
}

System.out.println();

for (int i = 0; i < movieNames.length; i++)
{
    System.out.println("Total movie ticket sales for " + movieNames[i] + " \u00A3" + totalSalesForMovies[i]);
}

System.out.println("\nTop performing movie: " + topMovie);
```

## 5. Unit Test Documentation: MovieTicketsTest.java

### 5.1 Test Class Overview

The `MovieTicketsTest` class contains JUnit 4 unit tests that verify the functionality 
of the `MovieTickets` class. These tests ensure that the `TotalMovieSales` and `TopMovie` 
methods behave correctly under various conditions, including normal operation and edge cases.

**Package:** `Solution`

**Signature:**
```java
public class MovieTicketsTest
```

**Testing Framework:** JUnit 4

### 5.2 Test: CalculateTotalSales_ReturnsExpectedTotalSales

**Purpose:** Verifies that the `TotalMovieSales` method correctly sums the values in a 
given array. This test corresponds to the first required test in the examination paper.

**Test Method:**
```java
@Test
public void CalculateTotalSales_ReturnsExpectedTotalSales()
```

**Test Data:**
| Input | Expected Output |
|-------|-----------------|
| `{3000, 1500, 1700}` | `6200` |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Define the input array with Napoleon's sales data
3. Call `TotalMovieSales` with the input array
4. Assert that the returned value equals the expected total (6200)

**Assertion Message:**
"The total sales calculated for Napoleon should be 6200."

### 5.3 Test: TopMovieSales_ReturnsTopMovie

**Purpose:** Verifies that the `TopMovie` method correctly identifies the movie with 
the highest total sales. This test corresponds to the second required test in the 
examination paper.

**Test Method:**
```java
@Test
public void TopMovieSales_ReturnsTopMovie()
```

**Test Data:**
| Movies Array | Total Sales Array | Expected Top Movie |
|--------------|-------------------|---------------------|
| `{"Napoleon", "Oppenheimer"}` | `{6200, 6300}` | `"Oppenheimer"` |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Define the movies array and total sales array
3. Call `TopMovie` with both arrays
4. Assert that the returned movie name equals "Oppenheimer"

**Assertion Message:**
"The top-performing movie should be Oppenheimer with 6300 total sales."

### 5.4 Test: TopMovieSales_HandlesNullInput

**Purpose:** Verifies that the `TopMovie` method handles null input gracefully without 
throwing a `NullPointerException`, returning an appropriate error message instead.

**Test Method:**
```java
@Test
public void TopMovieSales_HandlesNullInput()
```

**Test Data:**
| Input | Expected Behavior |
|-------|-------------------|
| `(null, null)` | Returns non-null error message |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Call `TopMovie` with null for both parameters
3. Assert that the result is not null
4. Assert that the result contains either "Error" or "null" in the message

### 5.5 Test: TopMovieSales_HandlesMismatchedArrayLengths

**Purpose:** Verifies that the `TopMovie` method handles arrays of different lengths 
appropriately, returning an error message rather than crashing or producing incorrect 
results.

**Test Method:**
```java
@Test
public void TopMovieSales_HandlesMismatchedArrayLengths()
```

**Test Data:**
| Movies Array | Total Sales Array | Expected Behavior |
|--------------|-------------------|-------------------|
| `{"Napoleon", "Oppenheimer", "Damsel"}` | `{6200, 6300}` | Returns error message |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Define movies array with 3 elements and total sales array with 2 elements
3. Call `TopMovie` with both arrays
4. Assert that the result is not null
5. Assert that the result contains either "Error" or "mismatch" in the message

### 5.6 Test: TotalMovieSales_HandlesNullInput

**Purpose:** Verifies that the `TotalMovieSales` method handles null input gracefully by 
returning 0 instead of throwing a `NullPointerException`.

**Test Method:**
```java
@Test
public void TotalMovieSales_HandlesNullInput()
```

**Test Data:**
| Input | Expected Output |
|-------|-----------------|
| `null` | `0` |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Call `TotalMovieSales` with null
3. Assert that the returned value equals 0

### 5.7 Test: TotalMovieSales_ReturnsZeroForEmptyArray

**Purpose:** Verifies that the `TotalMovieSales` method returns 0 for an empty array, 
which is the correct mathematical sum of an empty set.

**Test Method:**
```java
@Test
public void TotalMovieSales_ReturnsZeroForEmptyArray()
```

**Test Data:**
| Input | Expected Output |
|-------|-----------------|
| `{}` | `0` |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Define an empty integer array
3. Call `TotalMovieSales` with the empty array
4. Assert that the returned value equals 0

### 5.8 Test: TopMovieSales_HandlesEmptyArrays

**Purpose:** Verifies that the `TopMovie` method handles empty arrays appropriately, 
returning an error message rather than crashing.

**Test Method:**
```java
@Test
public void TopMovieSales_HandlesEmptyArrays()
```

**Test Data:**
| Movies Array | Total Sales Array | Expected Behavior |
|--------------|-------------------|-------------------|
| `{}` | `{}` | Returns error message |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Define empty arrays for both parameters
3. Call `TopMovie` with both empty arrays
4. Assert that the result is not null
5. Assert that the result contains either "Error" or "empty" in the message

### 5.9 Test: TotalMovieSales_CalculatesCorrectlyForSingleElement

**Purpose:** Verifies that the `TotalMovieSales` method works correctly for an array 
with a single element, returning that element's value as the total.

**Test Method:**
```java
@Test
public void TotalMovieSales_CalculatesCorrectlyForSingleElement()
```

**Test Data:**
| Input | Expected Output |
|-------|-----------------|
| `{5000}` | `5000` |

**Test Steps:**
1. Create an instance of `MovieTickets`
2. Define an array with a single element (5000)
3. Call `TotalMovieSales` with the array
4. Assert that the returned value equals 5000

## 6. Installation and Setup

### 6.1 Prerequisites

| Requirement | Version | Description |
|-------------|---------|-------------|
| Java Development Kit (JDK) | 8 or higher | Required to compile and run the application |
| JUnit | 4.12 or higher | Required to run unit tests |
| Integrated Development Environment (IDE) | Any | Recommended: NetBeans, Eclipse, or IntelliJ IDEA |

### 6.2 Project Structure

```
Solution/
├── Solution/
│   ├── IMovieTickets.java
│   ├── MovieTickets.java
│   ├── MovieSalesReport.java
│   └── tests/
│       └── MovieTicketsTest.java
└── Documentation/
    ├── disclaimer.md
    └── documentation.md
```

### 6.3 Running the Application

**Using Command Line:**
```bash
# Compile the Java files
javac Solution/*.java

# Run the main application
java Solution.MovieSalesReport
```

**Using NetBeans IDE:**
1. Open the project in NetBeans
2. Navigate to the `MovieSalesReport.java` file
3. Right-click on the file and select "Run File"

**Using Eclipse IDE:**
1. Import the project into Eclipse
2. Navigate to the `MovieSalesReport.java` file
3. Right-click on the file and select "Run As" → "Java Application"

### 6.4 Running Unit Tests

**Using Command Line with JUnit:**
```bash
# Compile the test with JUnit in the classpath
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar Solution/tests/*.java

# Run the tests
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore Solution.tests.MovieTicketsTest
```

**Using NetBeans IDE:**
1. Navigate to the `MovieTicketsTest.java` file
2. Right-click on the file and select "Test File"

**Using Eclipse IDE:**
1. Navigate to the `MovieTicketsTest.java` file
2. Right-click on the file and select "Run As" → "JUnit Test"

## 7. Appendix: Coding Standards

### 7.1 Naming Conventions

| Element | Convention | Example |
|---------|------------|---------|
| Interfaces | Prefix with 'I', PascalCase | `IMovieTickets` |
| Classes | PascalCase | `MovieTickets`, `MovieSalesReport` |
| Methods | PascalCase | `TotalMovieSales`, `TopMovie` |
| Variables | camelCase | `totalSales`, `movieNames` |
| Constants | UPPER_SNAKE_CASE | `FILE_NAME` (if defined) |
| Packages | lowercase | `solution` (though the code uses `Solution`) |

### 7.2 Code Formatting

The code follows the Allman style, where opening braces are placed on a new line:

```java
public void methodName()
{
    // Method body
    if (condition)
    {
        // Conditional block
    }
}
```

**Indentation:** 4 spaces per level (no tabs)

### 7.3 Commenting Standards

**Class Header Comments:**
```java
/**
 * Brief description of the class.
 * More detailed description if necessary.
 *
 * @author Author Name
 * @version Version Number
 */
```

**Method Header Comments:**
```java
/**
 * Brief description of the method.
 *
 * @param parameterName Description of the parameter
 * @return Description of the return value
 */
```

**Inline Comments:**
```java
// Brief explanation of complex logic or important implementation details
```

**Javadoc Tags Used:**
| Tag | Purpose |
|-----|---------|
| `@author` | Identifies the author of the code |
| `@version` | Specifies the version number |
| `@param` | Documents a method parameter |
| `@return` | Documents the return value of a method |
| `@throws` | Documents exceptions that may be thrown |

---
