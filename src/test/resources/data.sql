INSERT INTO `course` (`DESCRIPTION`, `NAME`) VALUES ('Prevention Of Sexual harrassment','POSH');
INSERT INTO `course` (`DESCRIPTION`, `NAME`) VALUES ('Office manners desc','Office Etiquette');


INSERT INTO `employee` (`CONTACT_NUMBER`, `DOB`, `DOJ`, `DESIGNATION`, `EMAIL`, `EMP_ID`, `TYPE`, `GENDER`, `IS_ACTIVE`, `LAST_PASSWORD_RESET`, `NAME`, `PASSWORD`) 
VALUES ('8976547893', '2016-06-06', '2016-06-06', 'Consultant', 'd', 'XI1', 'd', 'Male', '1', '2016-06-06', 'ds', '$2a$10$LyKQ3koH2V/wIW1/mWe5fuZ371fCFvWA8ATj4bRBta8RCZ3fpnkU2');
INSERT INTO `employee` (`CONTACT_NUMBER`, `DOB`, `DOJ`, `DESIGNATION`, `EMAIL`, `EMP_ID`, `TYPE`, `GENDER`, `IS_ACTIVE`, `LAST_PASSWORD_RESET`, `NAME`, `PASSWORD`) 
VALUES ('8976547893', '2016-06-06', '2016-06-06', 'Consultant', 'ds', 'XI2', 'd', 'Male', '1', '2016-06-06', 'ds', '$2a$10$LyKQ3koH2V/wIW1/mWe5fuZ371fCFvWA8ATj4bRBta8RCZ3fpnkU2');


INSERT INTO employee_course (EMPLOYEE_ID, COURSE_ID)
SELECT employee.id, course.id FROM employee, course ;


INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q1 desc', 'Q1', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q2 desc', 'Q2', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q3 desc', 'Q3', 1);


INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A1', '1');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A2', '1');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A11', '2');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A22', '2');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A33', '2');