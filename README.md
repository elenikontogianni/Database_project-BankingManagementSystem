Banking Management System
A simple console-based Java application for managing bank accounts using MySQL and JDBC. This project demonstrates CRUD (Create, Read, Update, Delete) operations and basic banking transactions like deposits and withdrawals.
Features

Create bank accounts with customer name, initial balance, and email.
View all account details.
Update account information.
Delete accounts.
Perform deposits and withdrawals (with balance validation).
MySQL database integration via JDBC.

Prerequisites

Java JDK: Version 8 or higher (Oracle JDK or OpenJDK).
MySQL: Server and Workbench (MySQL Downloads) or XAMPP.
MySQL JDBC Driver: mysql-connector-j-8.0.x.jar (Download).
IDE: Eclipse or IntelliJ Community Edition (optional).
Basic knowledge of Java and SQL.

Setup Instructions

Clone the Repository:
git clone https://github.com/yourusername/BankingManagementSystem.git
cd BankingManagementSystem


Set Up MySQL Database:

Install and start MySQL Server.
In MySQL Workbench, execute the database.sql script to create the database and table:CREATE DATABASE IF NOT EXISTS bank_db;
USE bank_db;

CREATE TABLE IF NOT EXISTS accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Sample data
INSERT INTO accounts (customer_name, balance, email) VALUES
('John Doe', 1000.00, 'john@example.com'),
('Jane Smith', 2500.50, 'jane@example.com');




Add JDBC Driver:

Download mysql-connector-j-8.0.x.jar and place it in the lib folder.
In Eclipse: Right-click project → Properties → Java Build Path → Libraries → Add External JARs → Select JAR.


Configure Database Connection:

Edit src/dao/AccountDAO.java to match your MySQL credentials:private static final String URL = "jdbc:mysql://localhost:3306/bank_db?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = ""; // Update with your password




Run the Application:

In Eclipse: Right-click src/main/Main.java → Run As → Java Application.
Or via terminal:javac -cp "lib/mysql-connector-j-8.0.x.jar" src/main/*.java src/dao/*.java src/model/*.java
java -cp ".:lib/mysql-connector-j-8.0.x.jar" main.Main

(Use ; instead of : on Windows.)



Usage
Run the app to access a console menu with these options:

Create Account: Enter customer name, initial balance, and email.
View All Accounts: Display all accounts.
Update Account: Modify details by account ID.
Delete Account: Remove an account by ID.
Deposit: Add funds to an account.
Withdraw: Withdraw funds (checks for sufficient balance).
Exit: Close the application.

Sample Output:
=== Banking Management System ===
1. Create Account
...
Choose: 2
Account{ID=1, Name='John Doe', Balance=$1000.0, Email='john@example.com'}
Account{ID=2, Name='Jane Smith', Balance=$2500.5, Email='jane@example.com'}

Project Structure
BankingManagementSystem/
├── src/
│   ├── model/          # Account.java (data model)
│   ├── dao/            # AccountDAO.java (database operations)
│   └── main/           # Main.java (console interface)
├── lib/                # mysql-connector-j-8.0.x.jar
└── database.sql        # SQL script for database setup

Troubleshooting

Connection Error: Verify MySQL is running and credentials in AccountDAO.java are correct.
Duplicate Email: Ensure unique emails (database constraint).
JDBC Driver Issue: Confirm JAR is in lib and added to build path.
Timezone Error: Keep serverTimezone=UTC in the connection URL.

Future Improvements

Add a Swing or JavaFX GUI.
Implement user authentication with a login system.
Create a transaction history table.
Use Hibernate or Spring Data JPA for advanced database handling.
Add Maven or Gradle for dependency management.

Contributing
Contributions are welcome! Fork the repo, create a branch, and submit a pull request with your changes.


