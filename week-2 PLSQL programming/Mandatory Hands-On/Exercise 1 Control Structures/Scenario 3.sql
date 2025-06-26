create database db0;
use db0;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    DOB DATE,
    Balance DECIMAL(10,2),
    LastModified DATETIME
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance DECIMAL(10,2),
    LastModified DATETIME,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATETIME,
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
INSERT INTO Customers VALUES (1, 'John Doe', '1985-05-15', 1000.00, NOW());
INSERT INTO Customers VALUES (2, 'Jane Smith', '1990-07-20', 1500.00, NOW());

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000.00, NOW());
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500.00, NOW());

INSERT INTO Transactions VALUES (1, 1, NOW(), 200.00, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, NOW(), 300.00, 'Withdrawal');

INSERT INTO Loans VALUES (1, 1, 5000.00, 5.00, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 60 MONTH));

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000.00, 'HR', '2015-06-15');
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000.00, 'IT', '2017-03-20');

ALTER TABLE Customers ADD COLUMN IsVIP BOOLEAN DEFAULT FALSE;
-- Drop old procedure if exists
DROP PROCEDURE IF EXISTS LoanDueReminders;

-- Create procedure
DELIMITER $$

CREATE PROCEDURE LoanDueReminders()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE l_id INT;
    DECLARE due_date DATE;

    DECLARE cur CURSOR FOR
        SELECT LoanID, DueDate FROM Loans 
        WHERE DueDate <= CURDATE() + INTERVAL 30 DAY;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    reminder_loop: LOOP
        FETCH cur INTO l_id, due_date;
        IF done THEN
            LEAVE reminder_loop;
        END IF;

        SELECT CONCAT('Reminder: Loan ', l_id, ' is due on ', due_date) AS Reminder;
    END LOOP;
    CLOSE cur;
END $$

DELIMITER ;

-- Call procedure
CALL LoanDueReminders();
