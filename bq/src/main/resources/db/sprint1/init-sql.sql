--liquibase formatted sql
--changeset id:abourouh date:20032018 script:initschema

create table dummy (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY , name varchar(50));