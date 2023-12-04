create database project_db;

use project_db;

create table Event (
    event_id int not null auto_increment,
    prize_pool int,
    event_name varchar(50) not null,
    constraint event_pk primary key(event_id)
);