# Local Cinema Movie Ticket System

A Java-based application for managing and reporting movie ticket sales.  
This project demonstrates object-oriented programming principles,  
interface-based design, array manipulation, and unit testing.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Installation and Cloning](#installation-and-cloning)
- [Usage](#usage)
- [Testing](#testing)
- [Code Examples](#code-examples)
- [Documentation](#documentation)

## Overview

This application processes movie ticket sales data for a local cinema.  
It generates formatted sales reports showing monthly ticket sales for  
movies, calculates total sales per movie, and identifies the top-  
performing movie. The project was developed as part of the PROG6112  
examination and follows clean coding practices.

## Features

- Monthly Sales Reporting: Displays ticket sales for January,  
  February, and March 2024.
- Sales Calculations: Automatically calculates total sales for each  
  movie.
- Performance Analysis: Identifies the top-performing movie based on  
  total sales.
- Interface-Based Design: Demonstrates clean separation of concerns  
  through interface implementation.
- Comprehensive Validation: Handles edge cases and invalid inputs  
  gracefully.
- Unit Testing: Includes JUnit 4 tests for all core functionality.

## Technologies Used

- Java: Core programming language (JDK 8 or higher).
- JUnit 4: Unit testing framework.
- NetBeans IDE: Recommended development environment.

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

## Installation and Cloning

Follow these steps to set up the project on your local machine.

Prerequisites:
- Java Development Kit (JDK) 8 or higher.
- JUnit 4.12 or higher for testing.
- An IDE such as NetBeans, Eclipse, or IntelliJ IDEA.

Steps:
1. Clone the repository using the command below:
   ```bash
   git clone https://github.com/HChristopherNaoyuki/local-cinema-java.git
   ```
2. Navigate into the project folder:
   ```bash
   cd local-cinema-java
   ```
3. Open the project in your preferred IDE.
4. Build the project using your IDE or command line.

## Usage

Run the application to generate the movie ticket sales report.

Using Command Line:
```bash
java Solution.MovieSalesReport
```

Using NetBeans IDE:
1. Open MovieSalesReport.java.
2. Right-click and select Run File.

Sample output includes monthly sales totals and the top movie.

## Testing

Run unit tests to verify all calculations and edge case handling.

Using Command Line with JUnit:
```bash
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar Solution/tests/*.java
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar \
     org.junit.runner.JUnitCore Solution.tests.MovieTicketsTest
```

Using NetBeans IDE:
1. Open MovieTicketsTest.java.
2. Right-click and select Test File.

The test suite includes validation for total sales, top movie,  
null inputs, mismatched array lengths, and empty arrays.

## Code Examples

Interface definition:
```java
public interface IMovieTickets {
    int TotalMovieSales(int[] movieTicketSales);
    String TopMovie(String[] movies, int[] totalSales);
}
```

Implementation class method example:
```java
@Override
public int TotalMovieSales(int[] movieTicketSales) {
    if (movieTicketSales == null) {
        return 0;
    }
    int total = 0;
    for (int sales : movieTicketSales) {
        total += sales;
    }
    return total;
}
```

Unit test example:
```java
@Test
public void CalculateTotalSales_ReturnsExpectedTotalSales() {
    IMovieTickets calculator = new MovieTickets();
    int[] sales = {3000, 1500, 1700};
    int expected = 6200;
    int actual = calculator.TotalMovieSales(sales);
    assertEquals(expected, actual);
}
```

## Documentation

Full technical documentation is located in the Documentation folder.
The documentation.md file includes interface specifications, method  
details, unit test descriptions, setup instructions, and coding  
standards. Refer to this guide for deeper technical insights.

---

End of Document

---
