-- Create database and table
CREATE DATABASE IF NOT EXISTS CompanyDB8;
USE CompanyDB8;

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(50),
    emp_salary DECIMAL(10,2)
);

-- Insert sample employees
INSERT INTO Employee (emp_name, emp_salary) VALUES ('Kalyani', 50000.00);
INSERT INTO Employee (emp_name, emp_salary) VALUES ('sowmya', 60000.00);
INSERT INTO Employee (emp_name, emp_salary) VALUES ('bhagya', 55000.00);
INSERT INTO Employee (emp_name, emp_salary) VALUES ('eshwar', 62000.00);
INSERT INTO Employee (emp_name, emp_salary) VALUES ('laxmi', 58000.00);

DELIMITER //
CREATE PROCEDURE show_employees_cursor()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE empName VARCHAR(50);
    DECLARE empSal DECIMAL(10,2);
    DECLARE cur CURSOR FOR SELECT emp_name, emp_salary FROM Employee;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    DROP TEMPORARY TABLE IF EXISTS EmpResults;
    CREATE TEMPORARY TABLE EmpResults (info VARCHAR(100));

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO empName, empSal;
        IF done THEN
            LEAVE read_loop;
        END IF;
        INSERT INTO EmpResults(info) VALUES (CONCAT('Employee: ', empName, ', Salary: ', empSal));
    END LOOP;

    CLOSE cur;

    SELECT * FROM EmpResults;
END //
DELIMITER ;


-- Call the procedure
CALL show_employees_cursor();
