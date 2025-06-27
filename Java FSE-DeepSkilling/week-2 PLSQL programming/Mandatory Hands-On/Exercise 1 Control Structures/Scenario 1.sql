create database db52;
use db52;
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

DELIMITER //

CREATE PROCEDURE ApplySeniorCitizenDiscount()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE cid INT;
    DECLARE age INT;
    DECLARE c CURSOR FOR SELECT CustomerID, TIMESTAMPDIFF(YEAR, DOB, CURDATE()) FROM Customers;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN c;
    fetch_loop: LOOP
        FETCH c INTO cid, age;
        IF done THEN
            LEAVE fetch_loop;
        END IF;

        IF age > 60 THEN
            UPDATE Loans SET InterestRate = InterestRate * 0.99 WHERE CustomerID = cid;
        END IF;
    END LOOP;
    CLOSE c;
END //

DELIMITER ;

-- Disable safe update temporarily
SET SQL_SAFE_UPDATES = 0;

-- Call the procedure

CALL ApplySeniorCitizenDiscount();

-- Re-enable safe update
SET SQL_SAFE_UPDATES = 1;

-- View updated loan data
SELECT * FROM Loans;
