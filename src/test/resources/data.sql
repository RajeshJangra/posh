INSERT INTO `course` (`ID`, `DESCRIPTION`, `NAME`) VALUES (1, 'Prevention Of Sexual harrassment','POSH-Test');
INSERT INTO `course` (`ID`, `DESCRIPTION`, `NAME`) VALUES (2, 'Office manners desc','Office Etiquette-Test');


INSERT INTO `employee` (`CONTACT_NUMBER`, `DOB`, `DOJ`, `DESIGNATION`, `EMAIL`, `EMP_ID`, `TYPE`, `GENDER`, `IS_ACTIVE`, `LAST_PASSWORD_RESET`, `NAME`, `PASSWORD`) 
VALUES ('8976547893', '2016-06-06', '2016-06-06', 'Consultant', 'd', 'XI1', 'd', 'Male', '1', '2016-06-06', 'ds', '$2a$10$LyKQ3koH2V/wIW1/mWe5fuZ371fCFvWA8ATj4bRBta8RCZ3fpnkU2');
INSERT INTO `employee` (`CONTACT_NUMBER`, `DOB`, `DOJ`, `DESIGNATION`, `EMAIL`, `EMP_ID`, `TYPE`, `GENDER`, `IS_ACTIVE`, `LAST_PASSWORD_RESET`, `NAME`, `PASSWORD`) 
VALUES ('8976547893', '2016-06-06', '2016-06-06', 'Consultant', 'ds', 'XI2', 'd', 'Male', '1', '2016-06-06', 'ds', '$2a$10$LyKQ3koH2V/wIW1/mWe5fuZ371fCFvWA8ATj4bRBta8RCZ3fpnkU2');


INSERT INTO employee_course (EMPLOYEE_ID, COURSE_ID)
SELECT employee.id, course.id FROM employee, course ;


INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q1 desc', 'Q1', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q2 desc', 'Q2', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q3 desc', 'Q3', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q4 desc', 'Q4', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q5 desc', 'Q5', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q6 desc', 'Q6', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q7 desc', 'Q7', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q8 desc', 'Q8', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q9 desc', 'Q9', 1);


INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A1', '1');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A2', '1');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A11', '2');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A22', '2');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A33', '2');