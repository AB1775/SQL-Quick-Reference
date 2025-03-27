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
### Logical Operations
 Operator             | Condition                                            | SQL Example                     |
|---------------------|------------------------------------------------------|---------------------------------|
| =, !=, <, <=, >, >= | Standard numerical operators                         | `col_name != 4`                 |
| BETWEEN … AND …     | Number is within range of two values (inclusive)     | `col_name BETWEEN 1.5 AND 10.5` |
| NOT BETWEEN … AND … | Number is not within range of two values (inclusive) | `col_name NOT BETWEEN 1 AND 10` |
| IN (…)              | Number exists in a list                              | `col_name IN (2, 4, 6)`         |
| NOT IN (…)          | Number does not exist in a list                      | `col_name NOT IN (1, 3, 5)`     |
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
### String Matching Operators
| Operator     | Condition                                                                  | Example                                                          |
|--------------|----------------------------------------------------------------------------|------------------------------------------------------------------|
| =            | Case sensitive exact string comparison                                     | `col_name = "abc"`                                               |
| != or <>     | Case sensitive exact string inequality comparison                          | `col_name != "abcd"`                                             |
| LIKE         | Case insensitive exact string comparison                                   | `col_name LIKE "ABC"`                                            |
| NOT LIKE     | Case insensitive exact string inequality comparison                        | `col_name NOT LIKE "ABCD"`                                       |
| %            | Matches a sequence of zero or more characters (used with LIKE or NOT LIKE) | `col_name LIKE "%AT%"` (matches "AT", "ATTIC", "CAT", or "BATS") |
| _            | Matches a single character (used with LIKE or NOT LIKE)                    | `col_name LIKE "AN_"` (matches "AND", but not "AN")              |
| IN (…)       | String exists in a list                                                    | `col_name IN ("A", "B", "C")`                                    |
| NOT IN (…)   | String does not exist in a list                                            | `col_name NOT IN ("D", "E", "F")`                                |
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
## SQL Lesson 6: Multi-Table Queries with JOINs
##### Table: Movies (Read-Only)
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
--------------------------------------------------------------------------
##### Table: Boxoffice (Read-Only)
------------------------------------------------------------
| movie_id | rating | domestic_sales | international_sales |
|----------|--------|----------------|---------------------|
| 5        | 8.2    | 380843261      | 555900000           |
| 14       | 7.4    | 268492764      | 475066843           |
| 8        | 8.0    | 206445654      | 417277164           |
| 12       | 6.4    | 191452396      | 368400000           |
| 3        | 7.9    | 245852179      | 239163000           |
| 6        | 8.0    | 261441092      | 370001000           |
| 9        | 8.5    | 223808164      | 297503696           |
| 11       | 8.4    | 415004880      | 648167031           |
| 1        | 8.3    | 191796233      | 170162503           |
| 7        | 7.2    | 244082982      | 217900167           |
| 10       | 8.3    | 293004164      | 438338580           |
| 4        | 8.1    | 289916256      | 272900000           |
| 2        | 7.2    | 162798565      | 200600000           |
| 13       | 7.2    | 237283207      | 301700000           |
------------------------------------------------------------
##### Tasks
1. Find the domestic and international sales for each movie 
```SQL
    SELECT title, Domestic_sales, International_sales FROM Movies
        INNER JOIN Boxoffice
            on id == Movie_id;
```
2. Show the sales numbers for each movie that did better internationally rather than domestically 
```SQL
    SELECT title, Domestic_sales, International_sales FROM Movies
        INNER JOIN Boxoffice
            on id == Movie_id
            WHERE International_sales > Domestic_sales;
```
3. List all the movies by their ratings in descending order 
```SQL
    SELECT title FROM Movies
        INNER JOIN Boxoffice
            on id == Movie_id
            ORDER BY Rating DESC;
```
## SQL Lesson 7: OUTER JOINs
##### Table: Buildings (Read-Only)
| building_name | capacity |
|---------------|----------|
| 1e            | 24       |
| 1w            | 32       |
| 2e            | 16       |
| 2w            | 20       |

##### Table: Employees (Read-Only)
------------------------------------------------------
| role      | name        | building | years_employed |
|-----------|-------------|----------|----------------|
| Engineer  | Becky A.    | 1e       | 4              |
| Engineer  | Dan B.      | 1e       | 2              |
| Engineer  | Sharon F.   | 1e       | 6              |
| Engineer  | Dan M.      | 1e       | 4              |
| Engineer  | Malcom S.   | 1e       | 1              |
| Artist    | Tylar S.    | 2w       | 2              |
| Artist    | Sherman D.  | 2w       | 8              |
| Artist    | Jakob J.    | 2w       | 6              |
| Artist    | Lillia A.   | 2w       | 7              |
| Artist    | Brandon J.  | 2w       | 7              |
| Manager   | Scott K.    | 1e       | 9              |
| Manager   | Shirlee M.  | 1e       | 3              |
| Manager   | Daria O.    | 2w       | 6              |
------------------------------------------------------
##### Tasks
1. Find the list of all buildings that have employees 
```SQL
    SELECT Building FROM Employees
        LEFT JOIN Buildings
            ON Building_name == Building
        GROUP BY Building_name;
```
2. Find the list of all buildings and their capacity 
```SQL
    SELECT Building_name, capacity from Buildings;
```
3. List all buildings and the distinct employee roles in each building (including empty buildings) 
```SQL
    SELECT DISTINCT building_name, role 
    FROM buildings 
    LEFT JOIN employees
        ON building_name = building;
```
## Lesson 8: A Short Note on NULLS
##### Table: Buildings (Read-Only)
| building_name | capacity |
|---------------|----------|
| 1e            | 24       |
| 1w            | 32       |
| 2e            | 16       |
| 2w            | 20       |
##### Table: Employees (Read-Only)
| role      | name        | building | years_employed |
|-----------|-------------|----------|----------------|
| Engineer  | Becky A.    | 1e       | 4              |
| Engineer  | Dan B.      | 1e       | 2              |
| Engineer  | Sharon F.   | 1e       | 6              |
| Engineer  | Dan M.      | 1e       | 4              |
| Engineer  | Malcom S.   | 1e       | 1              |
| Artist    | Tylar S.    | 2w       | 2              |
| Artist    | Sherman D.  | 2w       | 8              |
| Artist    | Jakob J.    | 2w       | 6              |
| Artist    | Lillia A.   | 2w       | 7              |
| Artist    | Brandon J.  | 2w       | 7              |
| Manager   | Scott K.    | 1e       | 9              |
| Manager   | Shirlee M.  | 1e       | 3              |
| Manager   | Daria O.    | 2w       | 6              |
| Engineer  | Yancy I.    |          | 0              |
| Artist    | Oliver P.   |          | 0              |
##### Tasks
1. Find the name and role of all employees who have not been assigned to a building 
```SQL
    SELECT Name FROM Employees
        WHERE Building IS NULL;
```
2. Find the names of the buildings that hold no employees
```SQL
    SELECT DISTINCT Building_name
    FROM Buildings 
    LEFT JOIN Employees
        ON Building_name = Building
    WHERE Role IS NULL;
```
## Lesson 9: Queries with Expressions
##### Table: Movies (Read-Only)
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

##### Table: Boxoffice (Read-Only)
| movie_id | rating | domestic_sales | international_sales |
|----------|--------|----------------|---------------------|
| 5        | 8.2    | 380843261      | 555900000           |
| 14       | 7.4    | 268492764      | 475066843           |
| 8        | 8.0    | 206445654      | 417277164           |
| 12       | 6.4    | 191452396      | 368400000           |
| 3        | 7.9    | 245852179      | 239163000           |
| 6        | 8.0    | 261441092      | 370001000           |
| 9        | 8.5    | 223808164      | 297503696           |
| 11       | 8.4    | 415004880      | 648167031           |
| 1        | 8.3    | 191796233      | 170162503           |
| 7        | 7.2    | 244082982      | 217900167           |
| 10       | 8.3    | 293004164      | 438338580           |
| 4        | 8.1    | 289916256      | 272900000           |
| 2        | 7.2    | 162798565      | 200600000           |
| 13       | 7.2    | 237283207      |                     |
###### Tasks
1. List all movies and their combined sales in millions of dollars
```SQL
    SELECT Title, (Domestic_sales + International_sales) / 1000000 AS Total_sales
    FROM Movies
    JOIN Boxoffice
        ON Id = Movie_id;
```
2. List all movies and their ratings in percent 
```SQL
    SELECT Title, (Rating * 10) as Rating_perc from Movies
    JOIN Boxoffice
        ON Id = Movie_id;
```
3. List all movies that were released on even number years
```SQL
    SELECT Title, (Year % 2) as Even_year FROM Movies
        WHERE Even_year = 0;
```
## Lesson 10: Queries with Aggregations (Pt 1)
### Common Aggregate Functions
| Function               |                                                                Description                                                                                             |
|------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| COUNT(*), COUNT(column)| Counts the number of rows in the group if no column name is specified. Otherwise, counts the number of rows in the group with non-NULL values in the specified column. |
| MIN(column)            | Finds the smallest numerical value in the specified column for all rows in the group.                                                                                  |
| MAX(column)            | Finds the largest numerical value in the specified column for all rows in the group.                                                                                   |
| AVG(column)            | Finds the average numerical value in the specified column for all rows in the group.                                                                                   |
| SUM(column)            | Finds the sum of all numerical values in the specified column for the rows in the group.                                                                               |

###### Table: Employees
| role      | name        | building | years_employed |
|-----------|-------------|----------|----------------|
| Engineer  | Becky A.    | 1e       | 4              |
| Engineer  | Dan B.      | 1e       | 2              |
| Engineer  | Sharon F.   | 1e       | 6              |
| Engineer  | Dan M.      | 1e       | 4              |
| Engineer  | Malcom S.   | 1e       | 1              |
| Artist    | Tylar S.    | 2w       | 2              |
| Artist    | Sherman D.  | 2w       | 8              |
| Artist    | Jakob J.    | 2w       | 6              |
| Artist    | Lillia A.   | 2w       | 7              |
| Artist    | Brandon J.  | 2w       | 7              |
| Manager   | Scott K.    | 1e       | 9              |
| Manager   | Shirlee M.  | 1e       | 3              |
| Manager   | Daria O.    | 2w       | 6              |
###### Tasks
1. Find the longest time that an employee has been at the studio 
```SQL
    SELECT MAX(years_employed) FROM Employees;
```
2. For each role, find the average number of years employed by employees in that role 
```SQL
    SELECT role, AVG(years_employed) as Average_years
    FROM Employees
    GROUP BY role;
```
3. Find the total number of employee years worked in each building 
```SQL
    SELECT Building, SUM(years_employed) as Total_years
    FROM Employees
    GROUP BY Building;
```
## Lesson 11: Queries with Aggregations (Pt 2)
##### Table: Employees
| role      | name        | building | years_employed |
|-----------|-------------|----------|----------------|
| Engineer  | Becky A.    | 1e       | 4              |
| Engineer  | Dan B.      | 1e       | 2              |
| Engineer  | Sharon F.   | 1e       | 6              |
| Engineer  | Dan M.      | 1e       | 4              |
| Engineer  | Malcom S.   | 1e       | 1              |
| Artist    | Tylar S.    | 2w       | 2              |
| Artist    | Sherman D.  | 2w       | 8              |
| Artist    | Jakob J.    | 2w       | 6              |
| Artist    | Lillia A.   | 2w       | 7              |
| Artist    | Brandon J.  | 2w       | 7              |
| Manager   | Scott K.    | 1e       | 9              |
| Manager   | Shirlee M.  | 1e       | 3              |
| Manager   | Daria O.    | 2w       | 6              |
##### Tasks:
1. Find the number of Artists in the studio (without a HAVING clause) 
```SQL
    SELECT COUNT(Name) FROM Employees
        WHERE Role = "Artist";
```
2. Find the number of Employees of each role in the studio 
```SQL
    SELECT Role, COUNT(*)FROM Employees
    GROUP BY Role;
```
3. Find the total number of years employed by all Engineers 
```SQL
    SELECT Role, SUM(years_employed) FROM Employees
        WHERE Role = "Engineer";
```
## Lesson 12: Order of Execution of a Query
## Lesson 13: Inserting Rows
## Lesson 14: Updating Rows
## Lesson 15: Deleting Rows
## Lesson 16: Creating Tables
## Lesson 17: Altering Tables
## Lesson 18: Dropping Tables
