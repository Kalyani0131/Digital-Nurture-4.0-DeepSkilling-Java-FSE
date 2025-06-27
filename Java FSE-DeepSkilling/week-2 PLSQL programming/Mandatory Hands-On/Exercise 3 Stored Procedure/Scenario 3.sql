-- ✅ Create database and use it
CREATE DATABASE IF NOT EXISTS db220300;
USE db220300;

-- ✅ Drop old tables if they exist
DROP TABLE IF EXISTS Transactions;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Employees;
DROP TABLE IF EXISTS Customers;

-- ✅ Create tables with correct schema
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
    TransactionType VARCHAR(20),
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

-- ✅ Insert sample data
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

-- ✅ Drop procedure if it exists
DROP PROCEDURE IF EXISTS TransferFunds;

-- ✅ Create the TransferFunds procedure (Safe Update Compatible)
DELIMITER $$

CREATE PROCEDURE TransferFunds(
  IN fromAccountId INT,
  IN toAccountId INT,
  IN amount DECIMAL(10,2)
)
BEGIN
  DECLARE fromBalance DECIMAL(10,2);
  DECLARE toBalance DECIMAL(10,2);

  -- Check sender exists
  SELECT Balance INTO fromBalance FROM Accounts WHERE AccountID = fromAccountId;
  IF fromBalance IS NULL THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Source account does not exist';
  END IF;

  -- Check receiver exists
  SELECT Balance INTO toBalance FROM Accounts WHERE AccountID = toAccountId;
  IF toBalance IS NULL THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Destination account does not exist';
  END IF;

  -- Check sufficient balance
  IF fromBalance < amount THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient Balance';
  END IF;

  -- Debit sender
  UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = fromAccountId;

  -- Credit receiver
  UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = toAccountId;

  -- Log outgoing transaction
  INSERT INTO Transactions (AccountID, TransactionDate, Amount, TransactionType)
  VALUES (fromAccountId, CURDATE(), amount, 'Transfer-Out');

  -- Log incoming transaction
  INSERT INTO Transactions (AccountID, TransactionDate, Amount, TransactionType)
  VALUES (toAccountId, CURDATE(), amount, 'Transfer-In');
END$$

DELIMITER ;

-- ✅ Call the procedure
CALL TransferFunds(1, 2, 200);

-- ✅ Check final balances and transactions
SELECT * FROM Accounts;
SELECT * FROM Transactions;
