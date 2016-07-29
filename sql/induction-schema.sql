CREATE DATABASE  IF NOT EXISTS `induction` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `induction`;
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
-- Table structure for table `attempt`
--

DROP TABLE IF EXISTS `attempt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attempt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `FINISH_TIME` datetime DEFAULT NULL,
  `MAX_SCORE` int(3) DEFAULT NULL,
  `RESULT` varchar(6) DEFAULT NULL,
  `SCORE` int(3) DEFAULT NULL,
  `START_TIME` datetime NOT NULL,
  `COURSE_ID` bigint(20) NOT NULL,
  `EMPLOYEE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5cx4havmq0v1hqxaxoxjrtgcq` (`COURSE_ID`),
  KEY `FK_b808u3ynlaaa04apae24ixcgd` (`EMPLOYEE_ID`),
  CONSTRAINT `FK_5cx4havmq0v1hqxaxoxjrtgcq` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`ID`),
  CONSTRAINT `FK_b808u3ynlaaa04apae24ixcgd` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `choice`
--

DROP TABLE IF EXISTS `choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choice` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(1000) NOT NULL,
  `QUESTION_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_5lvgee9xbmwsial7cqccsjue0` (`QUESTION_ID`),
  CONSTRAINT `FK_5lvgee9xbmwsial7cqccsjue0` FOREIGN KEY (`QUESTION_ID`) REFERENCES `question` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(100) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `PDF_FILE_PATH` varchar(200) NOT NULL,
  `VIDEO_FILE_PATH` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_58r0wv0malwrmw2dfj5ud69f` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AUTHORITIES` varchar(60) DEFAULT 'user',
  `CONTACT_NUMBER` varchar(15) DEFAULT NULL,
  `DOJ` date DEFAULT NULL,
  `DESIGNATION` varchar(100) NOT NULL,
  `DOB` date DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `EMP_ID` varchar(7) NOT NULL,
  `TYPE` varchar(30) NOT NULL,
  `GENDER` varchar(6) NOT NULL,
  `IS_ACTIVE` tinyint(1) DEFAULT '0',
  `LAST_PASSWORD_RESET` date DEFAULT NULL,
  `NAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_m30joy0i68j6kajwwne0tf9of` (`EMAIL`),
  UNIQUE KEY `UK_2v3s04062qfuas8c5ops15w1k` (`EMP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_course`
--

DROP TABLE IF EXISTS `employee_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_course` (
  `EMPLOYEE_ID` bigint(20) NOT NULL,
  `COURSE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`,`COURSE_ID`),
  KEY `FK_nhtdo9yp9uy8hkjgoxs5100or` (`COURSE_ID`),
  CONSTRAINT `FK_1yscktvf0mkdv3lkb1nemm6is` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`ID`),
  CONSTRAINT `FK_nhtdo9yp9uy8hkjgoxs5100or` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWER` varchar(1) NOT NULL,
  `DESCRIPTION` varchar(1000) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `COURSE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_84npujpjr090ii424a130asgl` (`NAME`),
  KEY `FK_nc35b7aoollxpxjre4hrx0wty` (`COURSE_ID`),
  CONSTRAINT `FK_nc35b7aoollxpxjre4hrx0wty` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-16 11:05:23
