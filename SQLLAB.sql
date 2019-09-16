/*SQL LAB*/
/* 2.1
Task – Select all records from the Employee table. */
SELECT * FROM "ADMIN"."Employee";
/*Task – Select all records from the Employee table where last name is King. */
SELECT * FROM "ADMIN"."Employee" WHERE "LastName" = 'King';
/*Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL*/
SELECT* FROM "ADMIN"."Employee" WHERE "FirstName" = Andrew and REPORTSTO IS NULL;
/*2.2
Task – Select all albums in Album table and sort result set in descending order by title. */
SELECT * FROM ALBUMS ORDER BY title desc;
/*Task – Select first name from Customer and sort result set in ascending order by city*/
SELECT FirstName FROM Customer ORDER BY city asc;

2.3---
/*Task – Insert two new records into Genre table*/
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Lo-fi');

INSERT INTO Genre (GenreId, Name) VALUES (27, 'KPOP');
/*Task – Insert two new records into Employee table*/
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (112, 'Soyer', 'Djourn', 'CEO', TO_DATE('1993-1-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '12345 Mansion Lane', 'Manhattan', 'NY', 'USA', 'T5K 2N1', '+1 (555) 555-555', '+1 (777) 777-7777', 'CEO@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (1213, 'CHEN', 'EMILIE', 'Co-CEO', TO_DATE('1993-12-13 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '12345 Mansion Lane', 'Manhattan', 'NY', 'USA', 'T5K 2N1', '+1 (555) 555-555', '+1 (777) 777-7777', 'CEO@chinookcorp.com');
/*Task – Insert two new records into Customer table*/
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (555, 'addition', 'new', 'Ordynacka 10', 'Warsaw', 'Poland', '00-358', '+48 22 828 37 39', 'idc@wp.pl', 4);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (556, 'addition', 'new2', 'Ordynacka 10', 'Warsaw', 'Poland', '00-358', '+48 22 828 37 39', 'idc@wp.pl', 4);

/*2.4
Task – Update Aaron Mitchell in Customer table to Robert Walter*/
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

/*Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” */	
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
2.5 
/*Task – Select all invoices with a billing address like “T%”'*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
/*2.6
Task – Select all invoices that have a total between 15 and 50*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
/*Task – Select all employees hired between 1st of June 2003 and 1st of March 2004*/
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('2003-6-1', 'yyyy-mm-dd') AND TO_DATE('2004-3-1', 'yyyy-mm-dd');





/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). */
DELETE 
FROM CUSTOMER
WHERE (FIRSTNAME='ROBERT') AND (LASTNAME='WALTER');
/*SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
3.1 System Defined Functions
Task – Create a function that returns the current time. */
CREATE OR REPLACE FUNCTION CURR_TIME
RETURN TIMESTAMP C IS TIMESTAMP;
BEGIN
    C := SYSDATE;
    RETURN(C);
END;
/*Task – create a function that returns the length of name in MEDIATYPE table */
CREATE OR REPLACE TYPELENGTH
    RETURN NUMBER T IS NUMBER;
    BEGIN
    SELECT LENGTH(NAME) INTO T FROM MEDIATYPE WHERE MEDIATYPEID=M_ID;
    RETURN T
END;
SELECT TYPELENGTH(4) FROM DUAL;
/*3.2 System Defined Aggregate Functions
Task – Create a function that returns the most expensive track
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoice line items in the invoiceline table*/
CREATE OR REPLACE FUNCTION AVGINVOICE
    RETURN NUMBER 
    IS A NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO A FROM INVOICELINE;
    RETURN A;     
END;
/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who were born after 1968. */
CREATE OR REPLACE FUNCTION AFTER68
    RETURN SYS_REFCURSOR
    IS
    BORN SYS_REFCURSOR; 
BEGIN
    OPEN BORN FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE (( TO_DATE('1968-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss')) < BIRTHDATE);
    RETURN BORN;
END;
/*4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees. */
CREATE OR REPLACE PROCEDURE FULLNAME
AS
FULLNM SYS_REFCURSOR;  
BEGIN
  OPEN FULLNM FOR
  SELECT (FIRSTNAME||' '|| LASTNAME)
  FROM EMPLOYEE;
  DBMS_SQL.RETURN_RESULT(FULLNM);
END;
/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee. */
CREATE OR REPLACE PROCEDURE EMPLOYEE_UPDATE(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_LASTNAME IN EMPLOYEE.LASTNAME%TYPE,
    E_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE,
    E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    E_CITY IN EMPLOYEE.CITY%TYPE,
    E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    E_PHONE IN EMPLOYEE.PHONE%TYPE,
    E_FAX IN EMPLOYEE.FAX%TYPE,
    E_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = E_LASTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FIRSTNAME = E_FIRSTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET ADDRESS = E_ADDRESS WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET CITY = E_CITY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET COUNTRY = E_COUNTRY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET POSTALCODE = E_POSTALCODE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET PHONE = E_PHONE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FAX = E_FAX WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET EMAIL = E_EMAIL WHERE EMPLOYEEID = E_EMPLOYEEID;
    COMMIT;
END;
/*Task – Create a stored procedure that returns the managers of an employee.
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.

5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them). */
 

/*6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. */
 CREATE OR REPLACE TRIGGER AFTER_EMPLOYEE_INSERT
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('NEW EMPLOYEE ADDED’);
END;

/*Task – Create an after update trigger on the album table that fires after a row is inserted in the table*/
CREATE OR REPLACE TRIGGER AFTER_ALBUM_INSERT
AFTER INSERT ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('NEW ALBUM INSERTED’);
END;

/*Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. */
CREATE OR REPLACE TRIGGER AFTER_CUSTOMER_DELETE
AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETED’);
END;


/*7.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins. */
/*7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. */
SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CUSTOMER A
INNER JOIN INVOICE B ON A.CUSTOMERID = B.CUSTOMERID
ORDER BY A.LASTNAME;
/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. */
SELECT FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM CUSTOMER A
LEFT OUTER JOIN INVOICE B ON A.CUSTOMERID = B.CUSTOMERID
ORDER BY A.LASTNAME;
/*7.3 RIGHT*/
Task – Create a right join that joins album and artist specifying artist name and title.
SELECT NAME AS "Artist Name", TITLE AS "Album Title" FROM ALBUM A
RIGHT JOIN ARTIST B ON A.ARTISTID = B.ARTISTID
ORDER BY NAME;
/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.*/

SELECT NAME AS "Artist Name", TITLE AS "Album Title" FROM ALBUM 
CROSS JOIN ARTIST 
ORDER BY NAME ASC;
/* 7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.*/

SELECT
    (A.FIRSTNAME  ||' '||  B.LASTNAME) AS EMPLOYEE,
    (B.FIRSTNAME  ||' '||  B.LASTNAME)AS MANAGER
FROM EMPLOYEE A
LEFT JOIN EMPLOYEE B
ON A.REPORTSTO = B.EMPLOYEEID
ORDER BY MANAGER;
