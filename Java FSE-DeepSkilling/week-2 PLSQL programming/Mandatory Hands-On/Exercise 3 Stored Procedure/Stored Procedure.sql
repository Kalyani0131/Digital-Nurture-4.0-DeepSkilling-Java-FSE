-- Create database and table
CREATE DATABASE IF NOT EXISTS CompanyDB1;
USE CompanyDB1;

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
