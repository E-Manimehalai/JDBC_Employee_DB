# Java JDBC – Employee Database App

A simple Java console application that performs CRUD operations (Create, Read, Update, Delete) on an employee database using **JDBC** and **MySQL**.

---

## Features

- Connects to MySQL using JDBC
- Adds new employees to the database
- Views all employee records
- Updates existing employee details
- Deletes employees by ID
- CLI-based interactive interface


## Tech Stack

- Java
- JDBC (Java Database Connectivity)
- MySQL
- Eclipse
- MySQL JDBC Driver

## Database Schema

--sql

CREATE DATABASE company;

USE company;

CREATE TABLE employees_details (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(50),
  salary DOUBLE
);

## Program Architecture
- Main.java: Handles user input and interaction flow.
- Employee.java: Represents a single employee as an object.
- Employee_Details.java: Contains all the logic for interacting with the database (DAO class).
- DatabaseConnection.java: Manages the JDBC connection using MySQL credentials.
