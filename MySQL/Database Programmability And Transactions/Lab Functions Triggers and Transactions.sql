#1.	Count Employees by Town

DELIMITER $$
CREATE FUNCTION count_employees_by_town (town_name VARCHAR(50))
RETURNS INTEGER
DETERMINISTIC
READS SQL DATA
BEGIN

DECLARE e_count INT(11);

SET e_count := (SELECT COUNT(e.employee_id) AS count FROM employees AS e 
JOIN addresses AS a ON e.address_id=a.address_id
JOIN towns AS t ON a.town_id=t.town_id
WHERE t.`name` = town_name);

RETURN e_count;
END $$

#2.	Employees Promotion

DELIMITER $$
CREATE  PROCEDURE usp_raise_salaries(department_name VARCHAR(30))
BEGIN

UPDATE employees AS e
JOIN departments AS d ON e.department_id = d.department_id
SET e.salary = e.salary*1.05
WHERE d.`name` = department_name;

END $$

# Employees Promotion by ID

CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN

DECLARE does_exist INT;

START TRANSACTION;

SET does_exist := (SELECT e.employee_id FROM employees AS e
WHERE e.employee_id = id);

IF (id = does_exist)
THEN UPDATE employees AS e SET e.salary = e.salary*1.05 WHERE e.employee_id = id;
COMMIT;
ELSE
ROLLBACK;
END IF;

END


#   Employees Promotion by ID

CREATE TABLE deleted_employees(
employee_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20),
last_name VARCHAR(20),
middle_name VARCHAR(20),
job_title VARCHAR(50),
department_id INT,
salary DOUBLE
);

DELIMITER $$
CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
INSERT INTO deleted_employees (first_name,last_name
,middle_name,job_title,department_id,salary)
VALUES(OLD.first_name,OLD.last_name,OLD.middle_name,OLD
.job_title,OLD.department_id,OLD.salary);
END $$