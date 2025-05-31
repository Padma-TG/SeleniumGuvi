CREATE DATABASE employee_database;
USE employee_database;
CREATE TABLE Emply(
	empno INT PRIMARY KEY,
    ename VARCHAR(30),
    job VARCHAR(30),
    mgr INT NULL,
    hire_date DATE,
    sal DECIMAL(6,2),    
    comm DECIMAL(6,2) NULL,
    deptno INT
    );
    DROP table Emply;
    INSERT INTO Emply VALUES 
(8369, 'SMITH', 'CLERK', 8902, '1990-12-18', 800.00, NULL, 20),
(8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, 300.00, 30),
(8521, 'SETH', 'SALESMAN', 8698, '1991-02-22', 1250.00, 500.00, 30),
(8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-02', 2985.00, NULL, 30),
(8654, 'MOMIN', 'SALESMAN', 8698, '1991-09-28', 1250.00, 1400.00, 30),
(8698, 'BINA', 'MANAGER', 8839, '1991-05-01', 2850.00, NULL, 10),
(8882, 'SHIVANSH', 'MANAGER', 8839, '1991-06-09', 2450.00, NULL, 20),
(8888, 'SCOTT', 'ANALYST', 8566, '1991-12-09', 3000.00, NULL, 20),
(8839, 'AMIR', 'PRESIDENT', NULL, '1991-11-18', 5000.00, NULL, 10),
(8844, 'KULDEEP', 'SALESMAN', 8698, '1991-09-08', 1500.00, 0.00, 30);
#1.Query to display ename and salary whose sal>=2200
Select ename,sal from Emply where sal>=2200;
#2.Query to display employe who are not getting commission
Select * from Emply where comm IS NULL;
#3.Query to display ename and sal who dont have btw 2500 and 4000
Select ename,sal from Emply where sal NOT BETWEEN 2500 And 4000;
#4.Query to display name,job title and salary of emp who dont have manager
Select ename,job,sal from Emply where mgr IS NULL;
#5.Query to display name of employee whose name contains A as third alphabet
Select ename from Emply where ename LIKE '__A%';
#6Query to display name of an employee whose name contains T as last alphabet
Select ename from Emply where ename LIKE '%T';

    

