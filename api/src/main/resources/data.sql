CREATE TABLE USERS(ID INT NOT NULL, FIRST_NAME VARCHAR(20) NOT NULL,MIDDLE_NAME VARCHAR(20),LAST_NAME VARCHAR(20) NOT NULL,ROLE VARCHAR(10) NOT NULL,EMAIL VARCHAR(35) NOT NULL,PHONE_NUMBER VARCHAR(13) NOT NULL,PASSWORD VARCHAR(15) NOT NULL,LAST_UPDATED_DATE VARCHAR NOT NULL,IS_ACTIVE VARCHAR(5) NOT NULL,PRIMARY KEY(ID));
CREATE TABLE BOOKS(ISBN INT NOT NULL, BOOK_NAME VARCHAR(50) NOT NULL,AUTHOR VARCHAR(30) NOT NULL,ORIGINAL_STOCK INT NOT NULL,IN_STOCK INT NOT NULL,PRIMARY KEY(ISBN),LAST_UPDATED_DATE VARCHAR NOT NULL);
CREATE TABLE ORDERDETAILS(ISBN INT NOT NULL, STUDENT_ID INT NOT NULL,ISSUED_BY VARCHAR(30) NOT NULL,ISSUED_DATE VARCHAR NOT NULL,PENALTY INT NOT NULL,STATUS VARCHAR(10) NOT NULL,LAST_UPDATED_DATE VARCHAR NOT NULL);
INSERT INTO USERS (ID,FIRST_NAME,LAST_NAME,ROLE,EMAIL,PHONE_NUMBER,PASSWORD,LAST_UPDATED_DATE,IS_ACTIVE) VALUES (123,'JOHN','SMITH','STUDENT','JOHNSMITH@GMAIL.COM','9848022338','John@2338','29-07-2022','Y');
INSERT INTO BOOKS (ISBN,BOOK_NAME,AUTHOR,ORIGINAL_STOCK,IN_STOCK,LAST_UPDATED_DATE) VALUES (5785,'JAVA','SMITH',15,15,'29-07-2022');
INSERT INTO BOOKS (ISBN,BOOK_NAME,AUTHOR,ORIGINAL_STOCK,IN_STOCK,LAST_UPDATED_DATE) VALUES (1234,'sql','SMITH',15,15,'29-07-2022');