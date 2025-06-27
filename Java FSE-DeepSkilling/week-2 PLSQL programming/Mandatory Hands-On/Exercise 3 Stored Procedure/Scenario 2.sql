CREATE DATABASE IF NOT EXISTS db18;
USE db18;

-- Drop tables if they exist
DROP TABLE IF EXISTS Transactions;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Employees;
DROP TABLE IF EXISTS Customers;

-- SCHEMA
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    DOB DATE,
    Balance DECIMAL(10,2),
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance DECIMAL(10,2),
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    TransactionDate DATE,
    Amount DECIMAL(10,2),
    TransactionType VARCHAR(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount DECIMAL(10,2),
    InterestRate DECIMAL(5,2),
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    Position VARCHAR(50),
    Salary DECIMAL(10,2),
    Department VARCHAR(50),
    HireDate DATE
);

-- SAMPLE DATA
INSERT INTO Customers VALUES
(1, 'John Doe', '1985-05-15', 1000, CURDATE()),
(2, 'Jane Smith', '1990-07-20', 1500, CURDATE());

INSERT INTO Accounts VALUES
(1, 1, 'Savings', 1000, CURDATE()),
(2, 2, 'Checking', 1500, CURDATE());

INSERT INTO Loans VALUES
(1, 1, 5000, 5, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 60 MONTH));

INSERT INTO Employees VALUES
(1, 'Alice Johnson', 'Manager', 70000, 'HR', '2015-06-15'),
(2, 'Bob Brown', 'Developer', 60000, 'IT', '2017-03-20');

DELIMITER $$

CREATE PROCEDURE UpdateEmployeeBonus(IN dept VARCHAR(50), IN bonus_percent DECIMAL(5,2))
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE empID INT;

  DECLARE empCursor CURSOR FOR
    SELECT EmployeeID FROM Employees WHERE Department = dept;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN empCursor;
  read_loop: LOOP
    FETCH empCursor INTO empID;
    IF done THEN
      LEAVE read_loop;
    END IF;

    UPDATE Employees
    SET Salary = Salary * (1 + bonus_percent/100)
    WHERE EmployeeID = empID;
  END LOOP;
  CLOSE empCursor;
END$$

DELIMITER ;

--  Example call: give 10% bonus to IT department
CALL UpdateEmployeeBonus('IT', 10);

-- Check updated salaries
SELECT * FROM Employees;
