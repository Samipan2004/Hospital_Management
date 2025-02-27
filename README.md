# Hospital Management System

## Overview

This project is a Hospital Management System implemented in Java. It allows users to manage various aspects of a hospital, including doctors, patients, medicines, diagnostics, and staff.

## Features

- **Doctor Management**: Add new doctors and view existing doctors.
- **Patient Management**: Add new patients and view existing patients.
- **Medicine Management**: Add new medicines and view existing medicines.
- **Diagnostic Management**: Add new diagnostic facilities and view existing facilities.
- **Staff Management**: Add new staff members and view existing staff.

## Requirements

- Java Development Kit (JDK) 8 or higher
- SQLite JDBC Driver
-  sqlite-tools-win-x64-3490100.zip
(6.12 MiB)  https://www.sqlite.org/download.html

## Setup

1. Navigate to the project directory:
    ```sh
    cd Hospital_Management
    ```
2. Compile the Java files:
    ```sh
    javac -cp ".;sqlite-jdbc-3.42.0.0.jar" DatabaseInitializer.java InventoryManagement.java
    ```
3. Run the application:
    ```sh
    java -cp ".;sqlite-jdbc-3.42.0.0.jar" DatabaseInitializer
    java -cp ".;sqlite-jdbc-3.42.0.0.jar" InventoryManagement
    ```

## Usage

1. When you run the application, you will be presented with the main menu.
2. Choose an option from the menu to manage doctors, patients, medicines, diagnostics, or staff.
3. Follow the prompts to add new entries or view existing entries.

## Database

The application uses an SQLite database named [Hospital.db] to store information about doctors, patients, medicines, diagnostics, and staff. The database schema is as follows:

- **Doctor Table**:
    - `did` (INTEGER PRIMARY KEY)
    - [dname] (TEXT)
    - [specialist] (TEXT)
    - [appoint] (TEXT)
    - [doc_qual] (TEXT)
    - [droom] (INTEGER)

- **Patient Table**:
    - `pid` (INTEGER PRIMARY KEY)
    - [pname] (TEXT)
    - [disease] (TEXT)
    - [sex] (TEXT)
    - [admit_status] (TEXT)
    - [age] (INTEGER)

- **Medicine Table**:
    - `medid` (INTEGER PRIMARY KEY)
    - [medname] (TEXT)
    - [medcomp] (TEXT)
    - [expdate] (TEXT)
    - [medcost] (INTEGER)
    - [count] (INTEGER)

- **Diagnostic Table**:
    - `fid` (INTEGER PRIMARY KEY)
    - [facility] (TEXT)
    - [cost] (INTEGER)

- **Staff Table**:
    - `sid` (INTEGER PRIMARY KEY)
    - [sname] (TEXT)
    - [desg] (TEXT)
    - [sex] (TEXT)
    - [salary] (INTEGER)
