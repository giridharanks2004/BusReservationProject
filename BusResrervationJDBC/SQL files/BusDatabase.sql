create database BusReserve;
use BusReserve;
create table bus(
	bus_id int primary key,
    ac boolean,
    capacity int
);

insert into bus values(1,1,2);
insert into bus values(2,1,50);
insert into bus values(3,0,60);

select * from bus;

update bus set avail = 2 where bus_id = 1;

alter table bus add avail int;

create table booking(
	p_name varchar(30),
    bus_id int,
    travel_date date
);

select * from booking;