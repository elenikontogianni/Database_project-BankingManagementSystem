# Database_project-BankingManagementSystem
Banking Management System
A simple console-based Java application for managing bank accounts using MySQL and JDBC. This project demonstrates CRUD (Create, Read, Update, Delete) operations and basic banking transactions like deposits and withdrawals.
Features

Create new bank accounts with customer name, balance, and email.
View all accounts.
Update account details.
Delete accounts.
Perform deposit and withdrawal transactions.
Uses MySQL for data storage and JDBC for database connectivity.

Prerequisites

Java JDK: 8 or higher (Download).
MySQL: Server and Workbench (Download) or XAMPP.
MySQL JDBC Driver: mysql-connector-j-8.0.x.jar (Download).
IDE: Eclipse or IntelliJ (optional, but recommended).
Basic Java and SQL knowledge.

Setup Instructions

Clone the Repository:
git clone https://github.com/yourusername/BankingManagementSystem.git
cd BankingManagementSystem


Set Up MySQL Database:

Install and start MySQL Server.
Open MySQL Workbench and run the database.sql script to create the bank_db database and accounts table:CREATE DATABASE IF NOT EXISTS bank_db;
USE bank_db;

CREATE TABLE IF NOT EXISTS accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO accounts (customer_name, balance, email) VALUES
('John Doe', 1000.00, 'john@example.com'),
('Jane Smith', 2500.50, 'jane@example.com');




Add JDBC Driver:

Place mysql-connector-j-8.0.x.jar in the lib folder.
In Eclipse: Right-click project → Properties → Java Build Path → Libraries → Add External JARs → Select the JAR.


Configure Database Connection:

In src/dao/AccountDAO.java, update URL, USER, and PASSWORD if needed:private static final String URL = "jdbc:mysql://localhost:3306/bank_db?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = ""; // Set your MySQL password




Run the Application:

In Eclipse: Right-click src/main/Main.java → Run As → Java Application.
Or via terminal:javac -cp "lib/mysql-connector-j-8.0.x.jar" src/main/*.java src/dao/*.java src/model/*.java
java -cp ".:lib/mysql-connector-j-8.0.x.jar" main.Main

(Use ; instead of : on Windows.)



Usage

Launch the app to see a console menu.
Options:
Create Account: Enter customer name, initial balance, and email.
View All Accounts: List all accounts with details.
Update Account: Modify account details by ID.
Delete Account: Remove an account by ID.
Deposit: Add money to an account.
Withdraw: Withdraw money (checks for sufficient balance).
Exit: Close the app.



Project Structure
BankingManagementSystem/
├── src/
│   ├── model/          # Account.java (data model)
│   ├── dao/            # AccountDAO.java (database operations)
│   └── main/           # Main.java (console interface)
├── lib/                # mysql-connector-j-8.0.x.jar
└── database.sql        # SQL script for database setup

Future Improvements

Add a Swing-based GUI for better user interaction.
Implement user authentication (login system).
Add transaction history table.
Use Hibernate for ORM instead of raw JDBC.
Integrate Maven for dependency management.

Troubleshooting

Connection Error: Ensure MySQL is running and credentials in AccountDAO.java are correct.
Duplicate Email Error: Emails must be unique in the database.
JDBC Driver Issue: Verify the JAR is in the lib folder and added to the build path.

