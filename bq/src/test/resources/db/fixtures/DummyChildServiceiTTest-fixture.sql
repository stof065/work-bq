--liquibase formatted sql
--changeset id:abourouh date:20032018 script:initschema

create  table IF NOT EXISTS  dummyChild (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY , name varchar(50) , dummy_id INT NOT NULL);

truncate table dummychild;

ALTER table dummyChild add constraint foreign_key(dummy_id) ;

insert into dummychild values (1,'dummy');