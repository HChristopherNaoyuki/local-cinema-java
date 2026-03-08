# Local Cinema Movie Ticket System

A Java-based application for managing and reporting movie ticket sales. This project demonstrates object-oriented 
programming principles, interface-based design, array manipulation, and unit testing.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Code Examples](#code-examples)
- [Documentation](#documentation)

## Overview

This application processes movie ticket sales data for a local cinema. It generates formatted sales reports showing monthly 
ticket sales for movies, calculates total sales per movie, and identifies the top-performing movie. The project was developed 
as part of the PROG6112 examination.

## Features

- **Monthly Sales Reporting**: Displays ticket sales for January, February, and March 2024
- **Sales Calculations**: Automatically calculates total sales for each movie
- **Performance Analysis**: Identifies the top-performing movie based on total sales
- **Interface-Based Design**: Demonstrates clean separation of concerns through interface implementation
- **Comprehensive Validation**: Handles edge cases and invalid inputs gracefully
- **Unit Testing**: Includes JUnit 4 tests for all core functionality

## Technologies Used

- **Java**: Core programming language (JDK 8 or higher)
- **JUnit 4**: Unit testing framework
- **NetBeans IDE**: Recommended development environment

## Project Structure

```
local-cinema-java/
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

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- JUnit 4.12 or higher (for testing)
- An IDE such as NetBeans, Eclipse, or IntelliJ IDEA (recommended)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/HChristopherNaoyuki/local-cinema-java.git
   cd local-cinema-java
   ```

2. **Open in your IDE**
   - **NetBeans**: File → Open Project → Select the project folder
   - **Eclipse**: File → Import → Existing Projects into Workspace
   - **IntelliJ IDEA**: Open → Select the project folder

3. **Build the project**
   - Most IDEs will build automatically
   - For command line compilation:
     ```bash
     javac Solution/*.java
     ```

## Usage

### Running the Application

**Using Command Line:**
```bash
java Solution.MovieSalesReport
```

**Using NetBeans IDE:**
1. Navigate to `MovieSalesReport.java`
2. Right-click and select "Run File"

**Sample Output:**
```
MOVIE TICKET SALES REPORT - 2024
JAN	FEB	MAR
Napoleon	3000	1500	1700	
Oppenheimer	3500	1200	1600	

Total movie ticket sales for Napoleon £6200
Total movie ticket sales for Oppenheimer £6300

Top performing movie: Oppenheimer
```

## Testing

### Running Unit Tests

**Using Command Line with JUnit:**
```bash
# Compile tests with JUnit in classpath
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar Solution/tests/*.java

# Run tests
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore Solution.tests.MovieTicketsTest
```

**Using NetBeans IDE:**
1. Navigate to `MovieTicketsTest.java`
2. Right-click and select "Test File"

### Test Coverage

The test suite includes:

| Test | Purpose |
|------|---------|
| `CalculateTotalSales_ReturnsExpectedTotalSales` | Verifies total sales calculation |
| `TopMovieSales_ReturnsTopMovie` | Verifies top movie identification |
| `TopMovieSales_HandlesNullInput` | Tests null input handling |
| `TopMovieSales_HandlesMismatchedArrayLengths` | Tests array length validation |
| `TotalMovieSales_HandlesNullInput` | Tests null input for sales calculation |
| `TotalMovieSales_ReturnsZeroForEmptyArray` | Tests empty array handling |
| `TopMovieSales_HandlesEmptyArrays` | Tests empty array handling for top movie |
| `TotalMovieSales_CalculatesCorrectlyForSingleElement` | Tests single-element array |

## Code Examples

### Interface Definition

```java
public interface IMovieTickets
{
    int TotalMovieSales(int[] movieTicketSales);
    String TopMovie(String[] movies, int[] totalSales);
}
```

### Implementation Class

```java
public class MovieTickets implements IMovieTickets
{
    @Override
    public int TotalMovieSales(int[] movieTicketSales)
    {
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
    }
    
    @Override
    public String TopMovie(String[] movies, int[] totalSales)
    {
        // Validation and implementation
        // Returns top movie name or error message
    }
}
```

### Unit Test Example

```java
@Test
public void CalculateTotalSales_ReturnsExpectedTotalSales()
{
    IMovieTickets calculator = new MovieTickets();
    int[] napoleonSales = {3000, 1500, 1700};
    int expectedTotal = 6200;
    
    int actualTotal = calculator.TotalMovieSales(napoleonSales);
    
    assertEquals("The total sales calculated for Napoleon should be 6200.",
                 expectedTotal, actualTotal);
}
```

## Documentation

Comprehensive technical documentation is available in the `Documentation` folder:

- **documentation.md**: Complete technical documentation including:
  - Interface and class documentation
  - Method specifications
  - Unit test documentation
  - Installation and setup instructions
  - Coding standards

## License

This project is created for educational purposes as part of the PROG6112 examination.

---
