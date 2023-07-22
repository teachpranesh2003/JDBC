-- create database Jdbc;
use Jdbc;
-- create table employee (
-- id int,
-- name varchar(10),
-- salary int);

insert into employee values(152,"pranesh",40000);
insert into employee values(151,"ram",34533),
					        (189,"kavi",90898);
select * from employee;
update employee set salary =15 where id = 134;
delimiter ##
create  Procedure SB()
begin
select * from employee;
end ##
delimiter ;


delimiter ##
create procedure SBPara(
in ids int )
begin
 select * from employee where id = ids;
 end ##
 delimiter ;
 
 use jdbc;
delimiter $$
create procedure SBparaOut(in ids int , out ename varchar(20))
begin
select name from employee where id = ids into ename;
end $$
delimiter ;
-- truncate employee;


