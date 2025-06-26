-- Create database and table
CREATE DATABASE IF NOT EXISTS CompanyDB4;
USE CompanyDB4;

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(50),
    emp_salary DECIMAL(10,2)
);

-- Stored Procedure
DELIMITER //
CREATE PROCEDURE insert_employee(
    IN name_in VARCHAR(50),
    IN salary_in DECIMAL(10,2)
)
BEGIN
    INSERT INTO Employee(emp_name, emp_salary) VALUES (name_in, salary_in);
    SELECT CONCAT('Inserted employee: ', name_in, ', Salary: ', salary_in) AS message;
END //
DELIMITER ;

-- Call the procedure multiple times
CALL insert_employee('Kalyani', 50000.00);
CALL insert_employee('sowmya', 60000.00);
CALL insert_employee('bhagya', 55000.00);
CALL insert_employee('eshwar', 62000.00);
CALL insert_employee('laxmi', 58000.00);

SELECT * FROM Employee;
-- Create log table
DROP TABLE IF EXISTS Employee_Log;
CREATE TABLE Employee_Log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
    old_salary DECIMAL(10,2),
    new_salary DECIMAL(10,2),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Trigger for update logging
DELIMITER //
CREATE TRIGGER log_salary_update
BEFORE UPDATE ON Employee
FOR EACH ROW
BEGIN
    INSERT INTO Employee_Log(emp_id, old_salary, new_salary)
    VALUES (OLD.emp_id, OLD.emp_salary, NEW.emp_salary);
END //
DELIMITER ;

-- Update salaries to fire trigger
UPDATE Employee SET emp_salary = emp_salary + 5000 WHERE emp_id > 0;

-- View log
SELECT * FROM Employee_Log;
