create table GENDERS
(
    ID NUMBER generated as identity
        constraint GENDERS_PK
        primary key,
    NAME VARCHAR2(255) not null
);
    /

create table JOBS
(
    ID     NUMBER generated as identity
        constraint JOBS_PK
        primary key,
    NAME   VARCHAR2(255) not null,
    SALARY NUMBER(9, 2)
);
    /

create table EMPLOYEES
(
    ID        NUMBER generated as identity
        constraint EMPLOYEES_PK
        primary key,
    GENDER_ID NUMBER     not null
        constraint EMPLOYEES_GENDERS_ID_FK
        references GENDERS (ID),
    JOB_ID    NUMBER    not null
        constraint EMPLOYEES_JOBS_ID_FK_2
        references JOBS (ID),
    NAME      VARCHAR2(255) not null,
    LAST_NAME VARCHAR2(255) not null,
    BIRTHDATE DATE          not null
);
    /



create table EMPLOYEE_WORKED_HOURS
(
    ID           NUMBER generated as identity
        constraint EMPLOYEE_WORKED_HOURS_PK
        primary key,
    EMPLOYEE_ID  NUMBER not null
        constraint EMPLOYEE_WORKED_HOURS_EMPLOYEES_ID_FK
        references EMPLOYEES (ID),
    WORKED_HOURS NUMBER not null,
    WORKED_DATE  DATE      not null
)
    /

insert into GENDERS (name) values ('male');
insert into GENDERS (name) values ('female');

insert into JOBS (name, salary) values ('fixit', 20000.00);
insert into JOBS (name, salary) values ('fleximax', 20000.00);
insert into JOBS (name, salary) values ('compumundo', 35000.00);
insert into JOBS (name, salary) values ('megared', 40000.00);
insert into JOBS (name, salary) values ('tesest', 30000.00);
insert into JOBS (name, salary) values ('colecomp', 80000.00);

insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,1,'JOHN', 'DOE','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,2,'JACK', 'DOR','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(2,3,'JAN', 'DER','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(2,4,'JEN', 'DIS','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(2,5,'JENN', 'DOE','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,1,'JER', 'DOOL','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,1,'GOEF', 'RALF','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(2,2,'GALE', 'DER','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,4,'MICH', 'TOR','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(2,5,'GAN', 'TER','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,3,'PROF', 'SIM','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,2,'TRACK', 'SUIT','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(2,1,'TEST', 'ING','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,4,'TIRE', 'ED','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,5,'SLE', 'PLES','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(2,3,'ELEN', 'JHONS','01/jan/1990');
insert into EMPLOYEES(gender_id, job_id, name, last_name, birthdate) values(1,1,'VLAD', 'TEPES','01/jan/1790');

insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (1,8,'10/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (1,8,'11/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (1,2,'12/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (2,2,'11/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (2,8,'12/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (3,8,'11/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (4,9,'12/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (4,8,'13/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (4,8,'14/OCt/2022');
insert into EMPLOYEE_WORKED_HOURS(employee_id, worked_hours, worked_date) values (4,8,'15/OCt/2022');




