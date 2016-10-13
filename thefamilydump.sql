
create database TheFamily;
use TheFamily;

create table Employee (
	Employee_id int not null auto_increment,
    Name varchar(20) not null,
    Address varchar(30) not null,
    Ni_num varchar(10) not null,
    Iban_num varchar(15) not null,
    Salary double,
    Bu_id int,
    Type_id int,
    primary key (Employee_id)
    );
    
    CREATE TABLE Employee_Type
(
Type_id int NOT NULL AUTO_INCREMENT,
Type_name varchar(30) NOT NULL,
PRIMARY KEY (Type_id)
);

CREATE TABLE Sales
(
Sales_id int NOT NULL AUTO_INCREMENT,
Commission_rate double NOT NULL,
Sales_total int NOT NULL,
Type_id int NOT NULL,
PRIMARY KEY (Sales_id),
FOREIGN KEY (Type_id) REFERENCES Employee_Type(Type_id)
);
select * from Employee_Type;

CREATE TABLE BU (
BU_id int not null PRIMARY KEY AUTO_INCREMENT,
BU_name varchar(20)
);
