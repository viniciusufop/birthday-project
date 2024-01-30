-- create the table
CREATE TABLE FRIENDS(
  FIRST_NAME TEXT NOT NULL,
  LAST_NAME TEXT NOT NULL,
  EMAIL TEXT NOT NULL,
  BIRTHDAY TEXT NOT NULL,
  PRIMARY KEY (FIRST_NAME, LAST_NAME)
);

-- insert the initial data base records
INSERT INTO FRIENDS(first_name, last_name, email, birthday)
VALUES ('John', 'Doe', 'john.doe@foobar.com', '1982-10-08');
INSERT INTO FRIENDS(first_name, last_name, email, birthday)
VALUES ('Mary', 'Ann', 'mary.ann@foobar.com', '1975-09-11');
INSERT INTO FRIENDS(first_name, last_name, email, birthday)
VALUES ('Mike', 'Tire', 'mike.tire@foobar.com', '1986-05-06');

-- show all friends
select * from FRIENDS;