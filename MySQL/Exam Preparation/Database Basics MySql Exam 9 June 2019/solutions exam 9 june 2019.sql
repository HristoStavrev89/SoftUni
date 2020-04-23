/*********************************************************************
         1.	Section 1: Data Definition Language (DDL) – 40 pts
 *******************************************************************/

CREATE TABLE clients (
`id` INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
age INT NOT NULL
);

CREATE TABLE branches (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10, 2) NOT NULL,
started_on DATE NOT NULL,
branch_id INT NOT NULL,
CONSTRAINT fk_employees_branches
FOREIGN KEY employees(branch_id)
REFERENCES branches(id)
);

CREATE TABLE employees_clients (
employee_id INT,
client_id INT,
CONSTRAINT fk_employees_clients_employees
FOREIGN KEY (employee_id) REFERENCES employees(`id`),
CONSTRAINT fk_employees_clients_clients
FOREIGN KEY (client_id) REFERENCES clients(`id`)
);

CREATE TABLE bank_accounts (
id INT PRIMARY KEY AUTO_INCREMENT,
account_number VARCHAR(10) NOT NULL,
balance DECIMAL(10, 2) NOT NULL,
client_id INT NOT NULL UNIQUE,
CONSTRAINT fk_bank_accounts_clients
FOREIGN KEY (client_id)
REFERENCES  clients(`id`)
);

CREATE TABLE cards (
id INT PRIMARY KEY AUTO_INCREMENT,
card_number VARCHAR(19) NOT NULL,
card_status VARCHAR(7) NOT NULL,
bank_account_id INT NOT NULL,
CONSTRAINT fk_cards_bank_accounts
FOREIGN KEY (bank_account_id)
REFERENCES bank_accounts(`id`)
);

/********************************************************
		2.	Section 2: Data Manipulation Language (DML) – 30 pts
         02.	Insert
*********************************************************/

INSERT INTO cards (card_number, card_status, bank_account_id)
(
SELECT REVERSE(full_name), 'Active', id FROM clients
WHERE id BETWEEN 191 AND 200
);

/********************************************************
Section 2: 03.	Update
*********************************************************/

SELECT ecc.employee_id FROM employees_clients AS ecc
GROUP BY ecc.employee_id
ORDER BY COUNT(ecc.client_id), ecc.employee_id
LIMIT 1; /* return 10 */

UPDATE employees_clients AS ec
SET ec.employee_id = 10  /* hardcore value from the previous select query */
WHERE ec.employee_id = ec.client_id;


/***********************************************************
            03.	Update
************************************************************/


SELECT e.id, ec.client_id FROM employees AS e
LEFT JOIN employees_clients AS ec ON e.id = ec.employee_id
WHERE ec.client_id IS NULL; /* return employee with id 101 */

DELETE FROM employees
WHERE id = 101; /* return id value from the previous select above*/


/********************************
3.	Section 3: Querying – 50 pts
05.	Clients
********************************/

SELECT id, full_name FROM clients
ORDER BY id;

/*********************************** 
06.	Newbies 
**************************************/

SELECT id, CONCAT(first_name, ' ', last_name) AS full_name, CONCAT('$', salary), started_on FROM employees
WHERE salary >= 100000 AND started_on >= '2018-01-01'
ORDER BY salary DESC, id;

/***************************************
07.	Cards against Humanity
***************************************/

SELECT crd.id, CONCAT(crd.card_number, ' : ', cln.full_name) AS card_token FROM cards as crd
JOIN bank_accounts AS ba ON crd.bank_account_id = ba.id
JOIN clients AS cln ON ba.client_id = cln.id
ORDER BY crd.id DESC;

/*************************************
                     08.	Top 5 Employees
*************************************/

SELECT CONCAT(e.first_name, ' ', e.last_name) AS `name`, e.started_on, COUNT(ec.client_id) AS count_of_clients FROM employees AS e
JOIN employees_clients AS ec ON e.id = ec.employee_id
GROUP BY e.id
ORDER BY count_of_clients DESC, e.id
LIMIT 5;

/****************************************
09.	Branch cards
****************************************/

SELECT b.`name`, COUNT(crd.id) AS count_of_cards FROM branches AS b
LEFT JOIN employees AS e ON b.id = e.branch_id
LEFT JOIN employees_clients AS ec ON ec.employee_id = e.id
LEFT JOIN clients AS c ON ec.client_id = c.id
LEFT JOIN bank_accounts AS ba ON c.id = ba.client_id
LEFT JOIN cards AS crd ON ba.id = crd.bank_account_id
GROUP BY b.id
ORDER BY count_of_cards DESC, b.`name`;


/************************************
10.	Extract client cards count
*************************************/

DELIMITER $$
CREATE FUNCTION udf_client_cards_count(client_name VARCHAR(30))
RETURNS INT
BEGIN

RETURN (SELECT COUNT(crd.bank_account_id) FROM clients AS c
JOIN bank_accounts AS ba ON c.id = ba.client_id
JOIN cards AS crd ON ba.id = crd.bank_account_id
WHERE c.full_name = client_name);
END $$

/******************************************************
11.	Extract Client Info
********************************************************/

DELIMITER $$
CREATE PROCEDURE udp_clientinfo(full_name_client VARCHAR(20))
BEGIN

SELECT c.full_name, c.age, ba.account_number, CONCAT('$', ba.balance) AS balance FROM clients AS c
LEFT JOIN bank_accounts AS ba ON c.id = ba.client_id
WHERE c.full_name = full_name_client;

END $$

