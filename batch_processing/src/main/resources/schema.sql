DROP TABLE humans IF EXISTS;
CREATE TABLE humans(
  human_id BIGINT IDENTITY NOt NULL PRIMARY KEY ,
  first_name VARCHAR (30),
  last_name VARCHAR (30)
);