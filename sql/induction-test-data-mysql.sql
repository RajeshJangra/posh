-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: induction
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `attempt`
--

LOCK TABLES `attempt` WRITE;
/*!40000 ALTER TABLE `attempt` DISABLE KEYS */;
/*!40000 ALTER TABLE `attempt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `choice`
--

LOCK TABLES `choice` WRITE;
/*!40000 ALTER TABLE `choice` DISABLE KEYS */;
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A1', '1');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A2', '1');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A11', '2');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A22', '2');
INSERT INTO `choice` (`DESCRIPTION`, `QUESTION_ID`) VALUES ('A33', '2');
/*!40000 ALTER TABLE `choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`DESCRIPTION`, `NAME`) VALUES ('Prevention Of Sexual harrassment','POSH');
INSERT INTO `course` (`DESCRIPTION`, `NAME`) VALUES ('Office manners desc','Office Etiquette');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`CONTACT_NUMBER`, `DOB`, `DOJ`, `DESIGNATION`, `EMAIL`, `EMP_ID`, `TYPE`, `GENDER`, `IS_ACTIVE`, `LAST_PASSWORD_RESET`, `NAME`, `PASSWORD`) 
VALUES ('8976547893', '2016-06-06', '2016-06-06', 'Consultant', 'd', 'XI1', 'd', 'Male', '1', '2016-06-06', 'ds', '$2a$10$LyKQ3koH2V/wIW1/mWe5fuZ371fCFvWA8ATj4bRBta8RCZ3fpnkU2');
INSERT INTO `employee` (`CONTACT_NUMBER`, `DOB`, `DOJ`, `DESIGNATION`, `EMAIL`, `EMP_ID`, `TYPE`, `GENDER`, `IS_ACTIVE`, `LAST_PASSWORD_RESET`, `NAME`, `PASSWORD`) 
VALUES ('8976547893', '2016-06-06', '2016-06-06', 'Consultant', 'ds', 'XI2', 'd', 'Male', '1', '2016-06-06', 'ds', '$2a$10$LyKQ3koH2V/wIW1/mWe5fuZ371fCFvWA8ATj4bRBta8RCZ3fpnkU2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee_course`
--

LOCK TABLES `employee_course` WRITE, `employee` WRITE,  `course` WRITE;
/*!40000 ALTER TABLE `employee_course` DISABLE KEYS */;
INSERT INTO employee_course (EMPLOYEE_ID, COURSE_ID)
SELECT employee.id, course.id FROM employee, course ;
/*!40000 ALTER TABLE `employee_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q1 desc', 'Q1', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q2 desc', 'Q2', 1);
INSERT INTO `question` (`ANSWER`, `DESCRIPTION`, `NAME`, `COURSE_ID`) VALUES ('1', 'Q3 desc', 'Q3', 1);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-16 11:23:11
