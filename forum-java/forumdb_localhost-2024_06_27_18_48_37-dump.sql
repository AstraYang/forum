-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: forumdb
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `aID` int NOT NULL AUTO_INCREMENT,
  `aName` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `aPwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`aID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin'),(2,'ym','123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likereply`
--

DROP TABLE IF EXISTS `likereply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likereply` (
  `likeReply_ID` int NOT NULL AUTO_INCREMENT COMMENT '回复帖点赞ID',
  `mID` int NOT NULL COMMENT '主贴ID',
  `uID` int NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`likeReply_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likereply`
--

LOCK TABLES `likereply` WRITE;
/*!40000 ALTER TABLE `likereply` DISABLE KEYS */;
/*!40000 ALTER TABLE `likereply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likestick`
--

DROP TABLE IF EXISTS `likestick`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likestick` (
  `likeStick_ID` int NOT NULL AUTO_INCREMENT COMMENT '主帖点赞ID',
  `mID` int DEFAULT NULL COMMENT '帖子ID',
  `uID` int DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`likeStick_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likestick`
--

LOCK TABLES `likestick` WRITE;
/*!40000 ALTER TABLE `likestick` DISABLE KEYS */;
/*!40000 ALTER TABLE `likestick` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainstick`
--

DROP TABLE IF EXISTS `mainstick`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainstick` (
  `mID` int NOT NULL AUTO_INCREMENT,
  `cID` int DEFAULT NULL,
  `uID` int DEFAULT NULL,
  `mTitle` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '主贴内容',
  `mCreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '主帖发布时间',
  `mClicks` int unsigned DEFAULT '0' COMMENT '主贴点击次数',
  `mReplies` int unsigned DEFAULT '0' COMMENT '主贴回复次数',
  `mLike` int unsigned DEFAULT '0' COMMENT '主贴点赞次数',
  `mStars` int DEFAULT '0' COMMENT '主贴收藏次数',
  PRIMARY KEY (`mID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainstick`
--

LOCK TABLES `mainstick` WRITE;
/*!40000 ALTER TABLE `mainstick` DISABLE KEYS */;
INSERT INTO `mainstick` VALUES (88,NULL,1,'hello world','记录！！\n这是本项目的第一个帖子。\n','2024-06-23 22:30:17',0,1,1,0),(92,NULL,2,'求救！这个数组指针真是给我学蒙了。','数组指针是指向数组的指针，但是数组指针数组是一个数组里面包含若干个数组指针，但是疑问点来了，数组指针是一个地址指向数组，可数组指针数组里面一个数组包含若干个指针去指向那个数组，这个叫数组指针数组。但是数组里面包含指针，不应该是指针数组吗？为什么我看教学上都是叫数组指针数组？真的学蒙了。','2024-06-23 22:51:46',0,2,1,0),(94,NULL,1,'111','','2024-06-24 01:18:10',0,0,8,0);
/*!40000 ALTER TABLE `mainstick` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture` (
  `pID` int NOT NULL AUTO_INCREMENT,
  `mID` int DEFAULT NULL,
  `uID` int DEFAULT NULL,
  `pName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图片名称',
  PRIMARY KEY (`pID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (75,94,1,'/uploadFile/1/5dafb2aa-346d-4720-a1fe-d82c3acd3696.jpg'),(76,95,2,'/uploadFile/2/fa8a5406-3a2b-4b22-98cb-82df456c8a3a.jpg'),(77,96,2,'/uploadFile/2/86b7dd08-c4d8-4564-a71a-1da3b217748e.jpg'),(78,97,1,'/uploadFile/1/64474578-6ce2-4d0b-a271-e067e819e428.jpg');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `rID` int NOT NULL AUTO_INCREMENT COMMENT '回复贴ID',
  `mID` int DEFAULT NULL COMMENT '主贴ID',
  `uID` int DEFAULT NULL COMMENT '用户ID',
  `rContent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '回复贴内容',
  `rCreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '回复贴发布时间',
  `rLike` int DEFAULT '0' COMMENT '回复贴点赞次数',
  PRIMARY KEY (`rID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (21,47,1,'666','2024-06-10 22:50:48',0),(22,49,47,'666','2024-06-11 14:50:49',0),(23,82,1,'666','2024-06-13 11:03:09',0),(24,83,1,'111','2024-06-13 11:04:43',0),(25,72,1,'666','2024-06-13 11:05:11',0),(26,72,1,'666666','2024-06-13 11:05:15',0),(27,71,47,'111','2024-06-13 18:31:59',0),(28,88,2,'1','2024-06-23 22:40:44',0),(29,92,47,'数组指针，数组的指针，他是指针。 指针数组，指针的数组，他是数组。','2024-06-23 22:59:23',0),(30,92,1,'1','2024-06-25 22:45:37',0);
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `starstick`
--

DROP TABLE IF EXISTS `starstick`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `starstick` (
  `starStick_ID` int NOT NULL AUTO_INCREMENT COMMENT '主帖收藏ID',
  `mID` int DEFAULT NULL COMMENT '帖子ID',
  `uID` int DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`starStick_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `starstick`
--

LOCK TABLES `starstick` WRITE;
/*!40000 ALTER TABLE `starstick` DISABLE KEYS */;
INSERT INTO `starstick` VALUES (64,95,2),(65,94,2),(66,92,2),(67,94,1);
/*!40000 ALTER TABLE `starstick` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uID` int NOT NULL AUTO_INCREMENT,
  `uName` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `uSex` int DEFAULT NULL COMMENT '性别(0未知1男2女)',
  `grade` int unsigned DEFAULT '0' COMMENT '等级\r\n',
  `autograph` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '签名',
  `uPhone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话',
  `uEmail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `uPwd` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `uCreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uAvatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图片头像路径',
  PRIMARY KEY (`uID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'yangming',2,0,'This\'s demo','5232511166','ym@outlook.com','a','2023-08-09 17:27:17','/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg'),(2,'Mr.B',1,0,'This\'s demo too','12345678901','123@qq.com','123','2023-08-04 17:20:48','/uploadFile/2/a5533032-9b4d-422a-a8ab-a487c367da64.jpg'),(47,'demo',1,0,NULL,NULL,'demo@qq.com','d','2023-11-07 18:47:33','/uploadFile/47/1fd94663-b41d-4923-99ad-5b758294d3cf.jpeg'),(48,'abin',1,0,NULL,NULL,'222@163.com','222','2023-11-08 08:09:22','/uploadFile/48/6487c4f1-3f34-48d9-ada6-9a82d14ef9bb.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-27 18:48:37
