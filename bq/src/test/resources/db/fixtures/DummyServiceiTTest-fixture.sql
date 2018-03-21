--liquibase formatted sql
--changeset id:abourouh date:20032018 script:initschema

create  table IF NOT EXISTS  dummy (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY , name varchar(50));

truncate table dummy;

insert into dummy values (1,'dummy');