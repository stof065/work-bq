--liquibase formatted sql
--changeset id:abourouh date:20032018 script:initschema


create  table IF NOT EXISTS  dummy (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY , name varchar(50));


create  table IF NOT EXISTS  dummyChild (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY , name varchar(50) , dummy_id INT NOT NULL);

truncate table dummychild;

ALTER table dummyChild add constraint FK_DUMMY FOREIGN KEY (dummy_id) REFERENCES dummy(id)

insert into dummy values(1,'dummy');
insert into dummychild values (1,'dummy child',1);