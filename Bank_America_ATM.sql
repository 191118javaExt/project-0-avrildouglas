--DROP SCHEMA bankdb;
--CREATE SCHEMA bankdb;

DROP TABLE IF EXISTS bankdb.users CASCADE;

CREATE TABLE bankdb.users (
	user_id SERIAL PRIMARY KEY,
	user_name VARCHAR (50) UNIQUE NOT NULL,
	first_name VARCHAR (50),
	last_name VARCHAR (50),
--	street VARCHAR (100),
--	city VARCHAR (50),
--	state VARCHAR (4),
--	zip VARCHAR(5),
	password VARCHAR (50) UNIQUE NOT NULL,
	role_id INTEGER,
	user_role_id INTEGER,
	
	CONSTRAINT  fk_role_id FOREIGN KEY (role_id) REFERENCES bankdb.roles(role_id),
	CONSTRAINT  fk_user_role_id FOREIGN KEY (user_role_id) REFERENCES bankdb.user_roles(user_role_id)

	);


DROP TABLE IF EXISTS bankdb.employees CASCADE;

CREATE TABLE bankdb.employees (
	employee_id SERIAL PRIMARY KEY,
	first_name VARCHAR (50) NOT NULL,
	last_name VARCHAR (50) NOT NULL,
	job_title VARCHAR (100), 
	email varchar (100),
	salary NUMERIC (50, 2),
	supervisor INTEGER,
	role_id INTEGER,
	user_roles_id INTEGER
	--NOT NULL REFERENCES bankdb.employees (employee_id)
	);

ALTER TABLE bankdb.employees
	ADD CONSTRAINT supervisor_employees_fk
	FOREIGN KEY (supervisor) REFERENCES bankdb.employees (employee_id);

ALTER TABLE bankdb.employees
	ADD CONSTRAINT role_id_fk
	FOREIGN KEY (role_id) REFERENCES bankdb.roles (role_id);


INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Mary', 'Pemberton', 'Manager', 'mpemberton@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Tom', 'Sawyer', 'Manager Assistant', 'tsawyer@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Eric', 'Panera', 'Bank Teller', 'epanera@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Carol', 'Taylor', 'Bank Teller', 'ctaylor@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Keith', 'Johnson', 'Bank Teller', 'kjohnson@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Bobby', 'Peppermint', 'Bank Teller', 'bpeppermint@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Phyllis', 'Flower', 'Loan Officer', 'pflower@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Mike', 'Metro', 'Loan Officer', 'mmetro@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Penny', 'Davis', 'Adminstrator', 'pdavis@bof.com');
INSERT INTO bankdb.employees (first_name, last_name, job_title, email) VALUES ('Betty', 'Washington', 'Administrative Assistant', 'tsawyer@bof.com');



DROP TABLE IF EXISTS bankdb.roles CASCADE;

CREATE TABLE bankdb.roles (
	role_id SERIAL PRIMARY KEY,
	role_title VARCHAR (100) NOT NULL
--  role_permit INTEGER NOT NULL
--	employee_id INTEGER NOT NULL,
--	CONSTRAINT  fk_employee_id FOREIGN KEY (employee_id) REFERENCES bankdb.employees(employee_id)
	);


INSERT INTO bankdb.roles (role_title) VALUES ('Customer'); -- ADD, Edit Customer Accounts
INSERT INTO bankdb.roles (role_title) VALUES ('EmployeeAdmin');-- View Accounts
INSERT INTO bankdb.roles (role_title) VALUES ('EmployeeNonAdmin');-- View & Edit All Accounts


DROP TABLE IF EXISTS bankdb.accounts CASCADE;

CREATE TABLE bankdb.accounts (
	account_id SERIAL PRIMARY KEY,
	account_num VARCHAR (50) NOT NULL,
	account_descrip VARCHAR (50) NOT NULL

--	account_date DATE NOT NULL DEFAULT CURRENT_DATE,
--	user_id INTEGER NOT NULL
	--CONSTRAINT  fk_user_id FOREIGN KEY (user_id) REFERENCES bankdb.users(user_id),
	--CONSTRAINT  fk_account_id FOREIGN KEY (account_id) REFERENCES bankdb.transactions(account_id)
	);


DROP TABLE IF EXISTS bankdb.user_roles CASCADE;

CREATE TABLE bankdb.user_roles(
	user_role_id SERIAL PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR (50) NOT NULL,
	role_title VARCHAR (50),
	--role_permit INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	employee_id INTEGER NOT NULL,
	CONSTRAINT  fk_user_id FOREIGN KEY (user_id) REFERENCES bankdb.users(user_id),
	CONSTRAINT  fk_employee_id FOREIGN KEY (employee_id) REFERENCES bankdb.employees(employee_id)
	);


DROP TABLE IF EXISTS bankdb.transactions CASCADE;

CREATE TABLE bankdb.transactions (
	trans_id SERIAL PRIMARY KEY,
	trans_type VARCHAR (50) NOT NULL,
	trans_date DATE NOT NULL DEFAULT CURRENT_DATE,
	trans_amount NUMERIC (50, 2),
	user_id INTEGER NOT NULL,
	account_id INTEGER NOT NULL,
	CONSTRAINT  fk_user_id FOREIGN KEY (user_id) REFERENCES bankdb.users(user_id),
	CONSTRAINT  fk_account_id FOREIGN KEY (account_id) REFERENCES bankdb.accounts(account_id)
	);


SELECT * FROM bankdb.roles;
SELECT * FROM bankdb.employees;
SELECT * FROM bankdb.users;
SELECT * FROM bankdb.accounts;
SELECT * FROM bankdb.transactions;
