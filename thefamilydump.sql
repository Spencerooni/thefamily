drop database if exists TheFamily;
create database TheFamily;
use TheFamily;

create table Employee (
    Employee_id int not null auto_increment,
    Name varchar(20) not null,
    Address varchar(30) not null,
    Ni_num varchar(15) not null unique,
    Iban_num varchar(30) not null unique,
    Salary decimal(8,2),
    Bu_id int,
    Type_id int,
    Sales_id int unique,
    primary key (Employee_id)
    );
    
    CREATE TABLE Employee_Type
(
Type_id int NOT NULL AUTO_INCREMENT,
Type_name varchar(30) NOT NULL unique,
PRIMARY KEY (Type_id)
);

CREATE TABLE Sales
(
Sales_id int NOT NULL AUTO_INCREMENT,
Commission_rate decimal(5,2) NOT NULL,
Sales_total int NOT NULL,
PRIMARY KEY (Sales_id)
);

CREATE TABLE BU (
BU_id int not null PRIMARY KEY AUTO_INCREMENT,
BU_name varchar(20) unique
);

Insert into Employee_Type (Type_Name)
values ('Sales');

Insert into Employee_Type (Type_Name)
values ('Consultant');

Insert into Employee_Type (Type_Name)
values ('Architect');

Insert into Sales (Commission_rate, Sales_total)
values (15, 500);

Insert into Sales (Commission_rate, Sales_total)
values (20, 1500);

Insert into Employee (Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id)
values ("A. Smith", "12 Glen Close", "QQ 12 34 56 C", "AL47212110090000000235698741", 12000, 1,1);

Insert into Employee (Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id)
values ("B. White", "13 Marley Park", "RR 12 34 55 B", "DE89370400440532013000", 24000, 2,1);

Insert into Employee (Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id)
values ("C. Black", "10 Rainey Street", "AL 22 36 55 K", "DZ4000400174401001050486", 25000, 3,2);

Insert into Employee (Name, Address, Ni_num, IBAN_num, Salary, Bu_id, Type_id)
values ("J. Rule", "15 Sunny Crescent", "RT 00 36 55 L", "BR9700360305000010009795493P1", 18000, 3,3);

Create view Emp_Per_Bu as
select a.Bu_name as BusinessUnit,
        b.Name as Employee
        from BU a
       JOIN Employee b
       on a.Bu_id = b.Bu_id
       order by BU_name;


ALTER TABLE Employee ADD FOREIGN KEY (Sales_id) REFERENCES Sales(sales_id);

