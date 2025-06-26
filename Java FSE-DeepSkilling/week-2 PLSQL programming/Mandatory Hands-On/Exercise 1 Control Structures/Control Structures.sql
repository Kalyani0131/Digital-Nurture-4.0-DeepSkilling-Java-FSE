CREATE DATABASE IF NOT EXISTS CompanyDB9;
USE CompanyDB9;

DELIMITER //
CREATE PROCEDURE control_structures_demo(IN input_num INT)
BEGIN
    DECLARE i INT DEFAULT 1;

    DROP TEMPORARY TABLE IF EXISTS ControlResults;
    CREATE TEMPORARY TABLE ControlResults (msg VARCHAR(100));

    -- IF / ELSE
    IF input_num > 0 THEN
        INSERT INTO ControlResults VALUES (CONCAT('The number ', input_num, ' is positive.'));
    ELSEIF input_num < 0 THEN
        INSERT INTO ControlResults VALUES (CONCAT('The number ', input_num, ' is negative.'));
    ELSE
        INSERT INTO ControlResults VALUES ('The number is zero.');
    END IF;

    -- CASE statement
    CASE input_num
        WHEN 1 THEN INSERT INTO ControlResults VALUES ('Number is one');
        WHEN 2 THEN INSERT INTO ControlResults VALUES ('Number is two');
        WHEN 3 THEN INSERT INTO ControlResults VALUES ('Number is three');
        ELSE INSERT INTO ControlResults VALUES ('Number is something else');
    END CASE;

    -- WHILE loop
    SET i = 1;
    WHILE i <= 3 DO
        INSERT INTO ControlResults VALUES (CONCAT('WHILE loop iteration: ', i));
        SET i = i + 1;
    END WHILE;

    -- REPEAT loop
    SET i = 1;
    REPEAT
        INSERT INTO ControlResults VALUES (CONCAT('REPEAT loop iteration: ', i));
        SET i = i + 1;
    UNTIL i > 3
    END REPEAT;

    -- Simulated FOR loop (using WHILE)
    SET i = 1;
    WHILE i <= 3 DO
        INSERT INTO ControlResults VALUES (CONCAT('Simulated FOR loop iteration: ', i));
        SET i = i + 1;
    END WHILE;

    -- Final combined output
    SELECT * FROM ControlResults;
END //
DELIMITER ;

-- Call the procedure
CALL control_structures_demo(2);
