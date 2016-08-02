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
-- Dumping data for table `employee`
-- Username/Password: admin/321@xebiA
--
INSERT INTO `employee` ( `DESIGNATION`, `EMAIL`, `EMP_ID`, `TYPE`, `GENDER`, `IS_ACTIVE`, 
						 `LAST_PASSWORD_RESET`, `NAME`, `PASSWORD`, `AUTHORITIES`) 
				VALUES ('administrator', 'administrator@xebia.com', 'admin', 'Full Time', 'MALE', '1',
						'2016-06-06', 'admin', '$2a$10$u/WVwnXwZBuKRJhOdf1lWebW754twR45CQjTrmYtyX4Ph0BW99mSC', 'admin');

--
-- Dumping data for table `choice`
--

LOCK TABLES `choice` WRITE;
/*!40000 ALTER TABLE `choice` DISABLE KEYS */;
INSERT INTO `choice` VALUES (1,'Yes',1),(2,'No',1),(3,'Physical unwanted contact',2),(4,'Verbal and non verbal communication, signals related to sexual orientation',2),(5,'Indirectly ensuring that the opposite person can see some material on video, picture, signal terms inappropriate',2),(6,'All of the above',2),(7,'Women Staff',3),(8,'Men Staff',3),(9,'Employees at all levels',3),(10,'All of the above',3),(11,'Discuss with your Friend ',4),(12,'Discuss with your Manager',4),(13,'Discuss with the Internal Complaint Committee',4),(14,'All of the above',4),(15,'Yes',5),(16,'No',5),(17,'Yes',6),(18,'No',6),(19,'Yes',7),(20,'No',7),(21,'No',8),(22,'Yes',8),(23,'Yes',9),(24,'No',9),(25,'Yes',10),(26,'No',10),(27,'Yes',11),(28,'No',11),(29,'Yes',12),(30,'No',12),(31,'Manager',13),(32,'HR Director',13),(33,'Internal Complaint Committee (ICC)',13),(34,'All of the above',13),(35,'Protection against sexual harassment of women at workplace',14),(36,'Prevention against sexual harassment of men at workplace',14),(37,'Redressal of complaints of sexual harassment',14),(38,'All of the above',14),(39,'Yes',15),(40,'No',15),(41,'Yes',16),(42,'No',16);
/*!40000 ALTER TABLE `choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Prevention of Sexual Harassment','POSH',NULL,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'1','Is there any law for Prevention of Sexual Harassment at workplace?',NULL,1),(2,'6','What results to be termed as a case of sexual harassment',NULL,1),(3,'10','Who all can be a victim of sexual harassment?',NULL,1),(4,'14','What should you do if you or any of your collogue experience a harassment of such kind?',NULL,1),(5,'15','Does taking extra interest in colleague’s personal life with the intention of making intimacy include Sexual Harassment?',NULL,1),(6,'17','Does flirting with a colleague against his/ her wishes constitute act of Sexual Harassment?',NULL,1),(7,'20','Will anonymous complaint on this topic be entertained?',NULL,1),(8,'22','Does display of object of sexual nature (picture, posters , screen savers)at workplace constitute sexual harassment?',NULL,1),(9,'23','Does badgering or consistently pursuing a colleague to go out on date constitute sexual harassment?',NULL,1),(10,'25','Does offering a promotion or any other financial benefit at work in return for an intimate relationship amount to sexual harassment?',NULL,1),(11,'27','Does Xebia has an Internal Complaints Committee to deal with Sexual harassment complaints?',NULL,1),(12,'29','Is there any law for Prevention of Sexual Harassment at workplace?',NULL,1),(13,'34','To whom can the complaint be made?',NULL,1),(14,'38','What are the basic objective of the Prevention of Sexual Harassment Act?',NULL,1),(15,'39','Can it be considered a case of Sexual Harassment if both the parties involved are of same gender?',NULL,1),(16,'42','If most people find a comment Amusing and Inoffensive, then the one person who is offended does not have a right to complain about Harassment?',NULL,1);
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

-- Dump completed on 2016-08-02 11:41:28