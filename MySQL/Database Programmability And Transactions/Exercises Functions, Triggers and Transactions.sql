#1.	Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN

SELECT e.first_name, last_name FROM employees AS e
WHERE e.salary > 35000
ORDER BY e.first_name, last_name, e.employee_id;

END $$

#2.	Employees with Salary Above Number

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary DECIMAL(19,4))
BEGIN

SELECT e.first_name, e.last_name FROM employees AS e
WHERE e.salary >= salary
ORDER BY e.first_name, e.last_name, e.employee_id;

END $$

#3.	Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(start_with VARCHAR(15))
BEGIN

SELECT t.`name` FROM towns AS t
WHERE t.`name` LIKE (CONCAT(start_with,'%'))
ORDER BY t.`name`;

END $$


#4.	Employees from Town

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(name_town VARCHAR(20))
BEGIN

SELECT e.first_name, e.last_name FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
JOIN towns AS t ON a.town_id = t.town_id
WHERE t.`name` = name_town
ORDER BY e.first_name, e.last_name, e.employee_id;

END $$

#5.	Salary Level Function

DELIMITER $$
 CREATE FUNCTION ufn_get_salary_level (employee_salary DECIMAL(19,4))
 RETURNS VARCHAR(20)
 DETERMINISTIC
 BEGIN
 
 DECLARE result VARCHAR(10);
 
IF employee_salary < 30000 THEN SET result := 'Low';
ELSEIF employee_salary BETWEEN 30000 AND 50000 THEN SET result := 'Average';
ELSE SET result := 'High';
END IF;

RETURN result;
END $$

#6.	Define Function

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(15))
BEGIN

SELECT first_name, last_name FROM employees
WHERE ufn_get_salary_level(salary) = salary_level
ORDER BY first_name DESC, last_name DESC;

END $$

#8.	Find Full Name

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN

SELECT CONCAT(ah.first_name, ' ', ah.last_name) AS full_name FROM account_holders AS ah
ORDER BY full_name, ah.`id`;

END $$

#9.	People with Balance Higher Than

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than (salary DECIMAL(19,4))
BEGIN

SELECT ah.first_name, ah.last_name FROM account_holders AS ah
JOIN accounts AS ac ON ah.id = ac.account_holder_id
GROUP BY ac.account_holder_id
HAVING SUM(ac.balance) > salary
ORDER BY ah.id;

END $$

#10.	Future Value Function

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DOUBLE, yearly_interest_rate DOUBLE, years INT(11))
RETURNS DOUBLE
BEGIN
	DECLARE result DOUBLE;
	SET result := initial_sum * POW(1 + yearly_interest_rate, years);
	RETURN result;
END $$

#11.	Calculating Interest

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account
	(account_id INT, interest_rate DECIMAL(20,4))
BEGIN
	SELECT a.id, h.first_name, h.last_name, a.balance,
		ufn_calculate_future_value(a.balance, interest_rate, 5) AS balance_in_5_years
	FROM account_holders h
    JOIN accounts AS a ON a.account_holder_id = h.id 
    GROUP BY a.account_holder_id
    HAVING a.id = account_id;
END $$

#12.	Deposit Money

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(acc_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0) 
         THEN ROLLBACK;
    ELSE
       UPDATE accounts
       SET balance = balance + money_amount
       WHERE id = acc_id;
       END IF;

END $$

#13.	Withdraw Money

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(acc_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    
    IF (money_amount <= 0) THEN ROLLBACK;
    ELSEIF ((SELECT balance FROM accounts WHERE acc_id = id) - money_amount < 0) THEN ROLLBACK;
    ELSE
    UPDATE accounts
    SET balance = balance - money_amount
    WHERE acc_id = id;
    END IF;
    
    
END $$

#14.	Money Transfer

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, money_amount DECIMAL(19, 4)) 
BEGIN
    START TRANSACTION;
    
    IF (money_amount <= 0) THEN ROLLBACK;
    ELSEIF (from_account_id <= 0 OR to_account_id <= 0) THEN ROLLBACK;
    ELSEIF (from_account_id > (SELECT COUNT(id) FROM accounts) OR to_account_id > (SELECT COUNT(id) FROM accounts)) THEN ROLLBACK;
    ELSEIF ((SELECT balance FROM accounts WHERE from_account_id = id) - money_amount < 0) THEN ROLLBACK;
    ELSE
    UPDATE accounts
    SET balance = balance - money_amount
    WHERE from_account_id = id;
    UPDATE accounts
    SET balance = balance + money_amount
    WHERE to_account_id = id;
    END IF;
    
    
END $$

#15.	Log Accounts Trigger

CREATE TABLE `logs` (
log_id INT AUTO_INCREMENT PRIMARY KEY,
account_id INT NOT NULL,
old_sum DECIMAL(19, 4) NOT NULL,
new_sum DECIMAL(19, 4) NOT NULL
);

DELIMITER $$
CREATE TRIGGER tr_acc_balance_changes BEFORE UPDATE ON `accounts` FOR EACH ROW
BEGIN

INSERT INTO `logs` (account_id, old_sum, new_sum)
VALUES
(OLD.`id`, OLD.balance, NEW.balance);

END $$

#16.	Emails Trigger

CREATE TABLE notification_emails(
id INT AUTO_INCREMENT PRIMARY KEY, 
recipient INT NOT NULL, 
`subject` VARCHAR(50),
body TINYTEXT,
FOREIGN KEY (recipient) REFERENCES accounts(id)
);

DELIMITER $$
CREATE TRIGGER tr_logs_email_record AFTER INSERT ON `logs` FOR EACH ROW
BEGIN

INSERT INTO notification_emails (recipient, `subject`, body)
VALUES
(OLD.account_id, CONCAT('Balance change for account: ', OLD.account_id), CONCAT('On ',DATE_FORMAT(NOW(), '%b %d %Y at %H:%i:%S %p'), ' your balance was changed from ', OLD.old_sum, ' to ', OLD.new_sum));

END $$