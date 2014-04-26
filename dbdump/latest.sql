-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: timetabledb
-- ------------------------------------------------------
-- Server version	5.5.32-0ubuntu0.13.04.1

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
-- Table structure for table `BRANCH`
--

DROP TABLE IF EXISTS `BRANCH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BRANCH` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `SHORT_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BRANCH`
--

LOCK TABLES `BRANCH` WRITE;
/*!40000 ALTER TABLE `BRANCH` DISABLE KEYS */;
INSERT INTO `BRANCH` VALUES (1,'Computer Engineering','CE'),(2,'Electronics & Communication','EC'),(3,'Mechanical Engineering','ME'),(4,'Electrical Engineering','EE'),(5,'Civil Engineering','CVE');
/*!40000 ALTER TABLE `BRANCH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COLLEGE`
--

DROP TABLE IF EXISTS `COLLEGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COLLEGE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COLLEGE`
--

LOCK TABLES `COLLEGE` WRITE;
/*!40000 ALTER TABLE `COLLEGE` DISABLE KEYS */;
INSERT INTO `COLLEGE` VALUES (1,'BIT');
/*!40000 ALTER TABLE `COLLEGE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOGIN`
--

DROP TABLE IF EXISTS `LOGIN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOGIN` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK453F7496643CF3C` (`ROLE_ID`),
  CONSTRAINT `FK453F7496643CF3C` FOREIGN KEY (`ROLE_ID`) REFERENCES `USER_ROLE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOGIN`
--

LOCK TABLES `LOGIN` WRITE;
/*!40000 ALTER TABLE `LOGIN` DISABLE KEYS */;
INSERT INTO `LOGIN` VALUES (1,'admin@admin.com','12345','A','admin',1),(2,'mayur@teacher.com','12345','A','mayr',4),(3,'sanket@teacher.com','12345','B','snkt',4),(4,'hitesh@teacher.com','12345','B','htsh',4),(5,'arpit@teacher.com','12345','B','arpt',4),(6,'clerk@clerk.com','12345','A','clerk',5),(7,'principal@principal.com','12345','A','principal',2),(8,'hodce@hod.com','12345','A','hodce',3),(11,'hodec@hod.com','12345','A','hodec',3),(13,'pranav@teacher.com','12345','A','pranav',4),(14,'amit@teacher.com','12345','A','amit',4),(15,'nihar@teacher.com',NULL,NULL,'nihar',4);
/*!40000 ALTER TABLE `LOGIN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRINCIPAL`
--

DROP TABLE IF EXISTS `PRINCIPAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRINCIPAL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `COLLEGE_ID` bigint(20) DEFAULT NULL,
  `LOGIN_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK3A16800E5E8B88A3` (`COLLEGE_ID`),
  KEY `FK3A16800E13C5DDA3` (`LOGIN_ID`),
  CONSTRAINT `FK3A16800E13C5DDA3` FOREIGN KEY (`LOGIN_ID`) REFERENCES `LOGIN` (`ID`),
  CONSTRAINT `FK3A16800E5E8B88A3` FOREIGN KEY (`COLLEGE_ID`) REFERENCES `COLLEGE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRINCIPAL`
--

LOCK TABLES `PRINCIPAL` WRITE;
/*!40000 ALTER TABLE `PRINCIPAL` DISABLE KEYS */;
INSERT INTO `PRINCIPAL` VALUES (1,'M S Dhoni',1,7);
/*!40000 ALTER TABLE `PRINCIPAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SEMESTER`
--

DROP TABLE IF EXISTS `SEMESTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SEMESTER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DIVISION` int(11) DEFAULT NULL,
  `SEMESTER_NO` int(11) DEFAULT NULL,
  `COORDINATOR` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK77680138A752195B` (`COORDINATOR`),
  CONSTRAINT `FK77680138A752195B` FOREIGN KEY (`COORDINATOR`) REFERENCES `TEACHER` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEMESTER`
--

LOCK TABLES `SEMESTER` WRITE;
/*!40000 ALTER TABLE `SEMESTER` DISABLE KEYS */;
INSERT INTO `SEMESTER` VALUES (1,1,1,1),(2,2,1,1);
/*!40000 ALTER TABLE `SEMESTER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SUBJECT`
--

DROP TABLE IF EXISTS `SUBJECT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SUBJECT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUBJECT`
--

LOCK TABLES `SUBJECT` WRITE;
/*!40000 ALTER TABLE `SUBJECT` DISABLE KEYS */;
/*!40000 ALTER TABLE `SUBJECT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TEACHER`
--

DROP TABLE IF EXISTS `TEACHER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEACHER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COORDINATOR` tinyint(1) NOT NULL DEFAULT '0',
  `HOD` tinyint(1) NOT NULL DEFAULT '0',
  `NAME` varchar(255) DEFAULT NULL,
  `SHORT_NAME` varchar(255) DEFAULT NULL,
  `BRANCH_ID` bigint(20) DEFAULT NULL,
  `LOGIN_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKD4FD57C213C5DDA3` (`LOGIN_ID`),
  KEY `FKD4FD57C28B8FF711` (`BRANCH_ID`),
  CONSTRAINT `FKD4FD57C213C5DDA3` FOREIGN KEY (`LOGIN_ID`) REFERENCES `LOGIN` (`ID`),
  CONSTRAINT `FKD4FD57C28B8FF711` FOREIGN KEY (`BRANCH_ID`) REFERENCES `BRANCH` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TEACHER`
--

LOCK TABLES `TEACHER` WRITE;
/*!40000 ALTER TABLE `TEACHER` DISABLE KEYS */;
INSERT INTO `TEACHER` VALUES (1,0,0,'Mayur','MJP',1,2),(2,0,0,'Sanket','SJS',2,3),(3,0,0,'Hitesh','HNN',2,4),(4,0,0,'Arpit','ARP',3,5),(5,0,1,'Saurabh','SMS',3,8),(6,0,1,'Keyur','KAL',2,11),(7,0,0,'Pranav','PNR',5,13),(8,0,0,'Amit','ANR',4,14),(9,0,0,'Nihar','NHR',5,15);
/*!40000 ALTER TABLE `TEACHER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TEACHER_SCHEDULE`
--

DROP TABLE IF EXISTS `TEACHER_SCHEDULE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEACHER_SCHEDULE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRANCH` bigint(20) DEFAULT NULL,
  `SEMESTER` bigint(20) DEFAULT NULL,
  `SUBJECT` bigint(20) DEFAULT NULL,
  `TEACHER` bigint(20) DEFAULT NULL,
  `TIME_SLOT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK972DF674AEE1BCA1` (`SUBJECT`),
  KEY `FK972DF674B5995947` (`SEMESTER`),
  KEY `FK972DF674E1F0AA0D` (`TEACHER`),
  KEY `FK972DF674AA71C172` (`TIME_SLOT`),
  KEY `FK972DF67468314BDB` (`BRANCH`),
  CONSTRAINT `FK972DF67468314BDB` FOREIGN KEY (`BRANCH`) REFERENCES `BRANCH` (`ID`),
  CONSTRAINT `FK972DF674AA71C172` FOREIGN KEY (`TIME_SLOT`) REFERENCES `TIME_SLOT` (`ID`),
  CONSTRAINT `FK972DF674AEE1BCA1` FOREIGN KEY (`SUBJECT`) REFERENCES `SUBJECT` (`ID`),
  CONSTRAINT `FK972DF674B5995947` FOREIGN KEY (`SEMESTER`) REFERENCES `SEMESTER` (`ID`),
  CONSTRAINT `FK972DF674E1F0AA0D` FOREIGN KEY (`TEACHER`) REFERENCES `TEACHER` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TEACHER_SCHEDULE`
--

LOCK TABLES `TEACHER_SCHEDULE` WRITE;
/*!40000 ALTER TABLE `TEACHER_SCHEDULE` DISABLE KEYS */;
/*!40000 ALTER TABLE `TEACHER_SCHEDULE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIME_SLOT`
--

DROP TABLE IF EXISTS `TIME_SLOT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIME_SLOT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `END_TIME` varchar(255) DEFAULT NULL,
  `SLOT_NAME` varchar(255) DEFAULT NULL,
  `START_TIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIME_SLOT`
--

LOCK TABLES `TIME_SLOT` WRITE;
/*!40000 ALTER TABLE `TIME_SLOT` DISABLE KEYS */;
/*!40000 ALTER TABLE `TIME_SLOT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ROLE`
--

DROP TABLE IF EXISTS `USER_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ROLE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_DISPLAY_NAME` varchar(255) DEFAULT NULL,
  `ROLE_DISPLAY_ORDER` bigint(20) DEFAULT NULL,
  `ROLE_HIERARCHY_ORDER` bigint(20) DEFAULT NULL,
  `ROLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLE`
--

LOCK TABLES `USER_ROLE` WRITE;
/*!40000 ALTER TABLE `USER_ROLE` DISABLE KEYS */;
INSERT INTO `USER_ROLE` VALUES (1,'Admin',1,1,'ROLE_ADMIN'),(2,'Principal',2,2,'ROLE_PRINCIPAL'),(3,'Hod',3,3,'ROLE_HOD'),(4,'Teacher',4,4,'ROLE_TEACHER'),(5,'Clerk',5,5,'ROLE_CLERK');
/*!40000 ALTER TABLE `USER_ROLE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-07 16:07:23
