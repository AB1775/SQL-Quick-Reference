# SQL-Quick-Reference
This repository contains a collection of SQL queries and examples based on the [SQLBolt](https://sqlbolt.com/) lesson plans. The goal of this project is to provide an easy-to-reference guide for learning and practicing SQL syntax. Each lesson includes tables, queries, and tasks that demonstrate key SQL concepts, such as:

- Basic SELECT queries
- Filtering and sorting results
- Using constraints
- Working with aggregate functions
- Joining tables

## Purpose
This project serves as:
1. A personal resource for learning SQL.
2. A quick reference for commonly used SQL syntax and patterns.

`While the questions and lessons are provided by SQLBolt, the answers provided are my own work, created as part of my learning process.`

## SQL Lesson 1: SELECT Queries 101
##### Table: Movies
--------------------------------------------------------------------
| id  | title           | director         | year | length_minutes |
|-----|-----------------|------------------|------|----------------|
| 1   | Toy Story       | John Lasseter    | 1995 | 81             |
| 2   | A Bug's Life    | John Lasseter    | 1998 | 95             |
| 3   | Toy Story 2     | John Lasseter    | 1999 | 93             |
| 4   | Monsters, Inc.  | Pete Docter      | 2001 | 92             |
| 5   | Finding Nemo    | Andrew Stanton   | 2003 | 107            |
| 6   | The Incredibles | Brad Bird        | 2004 | 116            |
| 7   | Cars            | John Lasseter    | 2006 | 117            |
| 8   | Ratatouille     | Brad Bird        | 2007 | 115            |
| 9   | WALL-E          | Andrew Stanton   | 2008 | 104            |
| 10  | Up              | Pete Docter      | 2009 | 10             |
--------------------------------------------------------------------
##### Tasks
1. Find the title of each film
```SQL
    SELECT title FROM movies;
```   
1. Find the director of each film
```SQL
    SELECT director FROM movies;
``` 
1. Find the title and director of each film
```SQL
    SELECT title, director FROM movies;
```
1. Find the title and year of each film
```SQL
    SELECT title, year FROM movies;
```
1. Find all the information about each film
```SQL
    SELECT * FROM movies;
```

## SQL Lesson 2: Queries with Constraints (Pt. 1)
##### Table: Movies
--------------------------------------------------------------------
| id  | title           | director         | year | length_minutes |
|-----|-----------------|------------------|------|----------------|
| 1   | Toy Story       | John Lasseter    | 1995 | 81             |
| 2   | A Bug's Life    | John Lasseter    | 1998 | 95             |
| 3   | Toy Story 2     | John Lasseter    | 1999 | 93             |
| 4   | Monsters, Inc.  | Pete Docter      | 2001 | 92             |
| 5   | Finding Nemo    | Andrew Stanton   | 2003 | 107            |
| 6   | The Incredibles | Brad Bird        | 2004 | 116            |
| 7   | Cars            | John Lasseter    | 2006 | 117            |
| 8   | Ratatouille     | Brad Bird        | 2007 | 115            |
| 9   | WALL-E          | Andrew Stanton   | 2008 | 104            |
| 10  | Up              | Pete Docter      | 2009 | 10             |
--------------------------------------------------------------------
##### Tasks
1. Find the movie with a row id of 6
```SQL
    SELECT title FROM movies
        WHERE id = 6;
```
2. Find the movies released in the years between 2000 and 2010
```SQL
    SELECT title FROM movies
        WHERE year BETWEEN 2000 AND 2010;
```
3. Find the movies not released in the years between 200 and 2010
```SQL
    SELECT title FROM movies
        WHERE year NOT BETWEEN 2000 AND 2010;
```
4. Find the first 5 Pixar movies and their release year
```SQL
    SELECT title FROM movies
        WHERE id BETWEEN 1 AND 5;
```
## SQL Lesson 3: Queries with Constraints (Pt. 2)
##### Table: Movies
--------------------------------------------------------------------------
| id  | title                 | director         | year | length_minutes |
|-----|-----------------------|------------------|------|----------------|
| 1   | Toy Story             | John Lasseter    | 1995 | 81             |
| 2   | A Bug's Life          | John Lasseter    | 1998 | 95             |
| 3   | Toy Story 2           | John Lasseter    | 1999 | 93             |
| 4   | Monsters, Inc.        | Pete Docter      | 2001 | 92             |
| 5   | Finding Nemo          | Andrew Stanton   | 2003 | 107            |
| 6   | The Incredibles       | Brad Bird        | 2004 | 116            |
| 7   | Cars                  | John Lasseter    | 2006 | 117            |
| 8   | Ratatouille           | Brad Bird        | 2007 | 115            |
| 9   | WALL-E                | Andrew Stanton   | 2008 | 104            |
| 10  | Up                    | Pete Docter      | 2009 | 101            |
| 11  | Toy Story 3           | Lee Unkrich      | 2010 | 103            |
| 12  | Cars 2                | John Lasseter    | 2011 | 120            |
| 13  | Brave                 | Brenda Chapman   | 2012 | 102            |
| 14  | Monsters University   | Dan Scanlon      | 2013 | 110            |
| 87  | WALL-G                | Brenda Chapman   | 2042 | 97             |
--------------------------------------------------------------------------
##### Tasks
1. Find all the Toy Story Movies
```SQL
    SELECT title FROM movies
        WHERE title LIKE "Toy Story%";
```
2. Find all the movies directed by John Lasseter
```SQL
    SELECT title FROM movies
        WHERE director = "John Lasseter";
```
3. Find all the movies (and director) not directed by John Lasseter
```SQL
    SELECT title, director FROM movies
        WHERE director != "John Lasseter";
```
4. Find all the WALL-* movies
```SQL
    SELECT title FROM movies
        WHERE title LIKE "WALL-%";
```
## SQL Lesson 4: Filtering and Sorting Query Results
##### Table: Movies
--------------------------------------------------------------------------
| id  | title                 | director         | year | length_minutes |
|-----|-----------------------|------------------|------|----------------|
| 1   | Cars 2                | John Lasseter    | 2011 | 120            |
| 2   | Monsters, Inc.        | Pete Docter      | 2001 | 92             |
| 3   | Up                    | Pete Docter      | 2009 | 101            |
| 4   | Ratatouille           | Brad Bird        | 2007 | 115            |
| 5   | Brave                 | Brenda Chapman   | 2012 | 102            |
| 6   | WALL-E                | Andrew Stanton   | 2008 | 104            |
| 7   | Monsters University   | Dan Scanlon      | 2013 | 110            |
| 8   | Finding Nemo          | Andrew Stanton   | 2003 | 107            |
| 9   | Cars                  | John Lasseter    | 2006 | 117            |
| 10  | Toy Story             | John Lasseter    | 1995 | 81             |
| 11  | A Bug's Life          | John Lasseter    | 1998 | 95             |
| 12  | Toy Story 2           | John Lasseter    | 1999 | 93             |
| 13  | Toy Story 3           | Lee Unkrich      | 2010 | 103            |
| 14  | The Incredibles       | Brad Bird        | 2004 | 116            |
--------------------------------------------------------------------------
##### Tasks
1. List all directors of Pixar movies (alphabetically), without duplicates
```SQL
    SELECT DISTINCT director FROM movies
        ORDER BY director ASC;
```
2. List the last four Pixar movies released (ordered from most recent to least)
```SQL
    SELECT Title from Movies
        ORDER BY year DESC
        LIMIT 4;
```
3. List the first five Pixar movies sorted alphabetically 
```SQL
    SELECT Title from Movies
        ORDER BY Title ASC
        LIMIT 5;
```
4. List the next five Pixar movies sorted alphabetically
```SQL
    SELECT Title from Movies
        ORDER BY Title ASC
        LIMIT 5 OFFSET 5;
```
## SQL Review: Simple SELECT Queries
##### Table: North_american_cities
------------------------------------------------------------------------------------
| city                  | country         | population | latitude   | longitude    |
|-----------------------|-----------------|------------|------------|--------------|
| Guadalajara           | Mexico          | 1500800    | 20.659699  | -103.349609  |
| Toronto               | Canada          | 2795060    | 43.653226  | -79.383184   |
| Houston               | United States   | 2195914    | 29.760427  | -95.369803   |
| New York              | United States   | 8405837    | 40.712784  | -74.005941   |
| Philadelphia          | United States   | 1553165    | 39.952584  | -75.165222   |
| Havana                | Cuba            | 2106146    | 23.05407   | -82.345189   |
| Mexico City           | Mexico          | 8555500    | 19.432608  | -99.133208   |
| Phoenix               | United States   | 1513367    | 33.448377  | -112.074037  |
| Los Angeles           | United States   | 3884307    | 34.052234  | -118.243685  |
| Ecatepec de Morelos   | Mexico          | 1742000    | 19.601841  | -99.050674   |
| Montreal              | Canada          | 1717767    | 45.501689  | -73.567256   |
| Chicago               | United States   | 2718782    | 41.878114  | -87.629798   |
------------------------------------------------------------------------------------
##### Tasks
1. List all the Canadian cities and their populations
```SQL
SELECT city, population FROM north_american_cities
    WHERE country = "Canada";
```
2. Order all the cities in the United States by their latitude from north to south
```SQL
    SELECT city FROM north_american_cities
        WHERE country = "United States"
        ORDER BY latitude DESC;
``` 
3. List all the cities west of Chicago, ordered from west to east
```SQL
    SELECT city FROM north_american_cities
        WHERE longitude < -87.63
        ORDER BY longitude ASC;
```
4. List the two largest cities in Mexico (by population)
```SQL
    SELECT city FROM north_american_cities
        WHERE country = "Mexico"
        ORDER BY population DESC
        LIMIT 2;
``` 
5. List the third and fourth largest cities (by population) in the United States and their population
```SQL
    SELECT city, population FROM north_american_cities
        WHERE country = "United States"
        ORDER BY population DESC
        LIMIT 2 OFFSET 2;
```
