-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: kbproject
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_number` bigint NOT NULL AUTO_INCREMENT,
  `account_type` varchar(255) DEFAULT NULL,
  `balance` bigint DEFAULT NULL,
  `user_number` bigint DEFAULT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benefit`
--

DROP TABLE IF EXISTS `benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefit`
--

INSERT INTO `custom_community` VALUES (1, 1,,'[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','민철이랑 놀아요',1),(7,1,'C2.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','용우랑',1),(8,0,'C3.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','소진이랑',1),(9,0,'C4.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','수대랑',1),(10,0,'C5.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','종수랑',1),(11,1,'C6.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','학민이랑',1);




LOCK TABLES `benefit` WRITE;
/*!40000 ALTER TABLE `benefit` DISABLE KEYS */;
/*!40000 ALTER TABLE `benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custom_community`
--

DROP TABLE IF EXISTS `custom_community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `custom_community` (
  `shared_id` bigint NOT NULL AUTO_INCREMENT,
  `heart` bigint DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `layout_data` varchar(255) DEFAULT NULL,
  `page_name` varchar(255) DEFAULT NULL,
  `user_number` bigint NOT NULL,
  PRIMARY KEY (`shared_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom_community`
--

LOCK TABLES `custom_community` WRITE;
/*!40000 ALTER TABLE `custom_community` DISABLE KEYS */;
INSERT INTO `custom_community` VALUES (5,10,'민철이랑 놀아요','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','C1.png',1),(7,1,'C2.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','용우랑',1),(8,0,'C3.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','소진이랑',1),(9,0,'C4.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','수대랑',1),(10,0,'C5.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','종수랑',1),(11,1,'C6.png','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]','학민이랑',1);
/*!40000 ALTER TABLE `custom_community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custom_page`
--

DROP TABLE IF EXISTS `custom_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `custom_page` (
  `page_id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `layout_data` varchar(255) DEFAULT NULL,
  `user_number` bigint NOT NULL,
  PRIMARY KEY (`page_id`),
  UNIQUE KEY `UK82jm1g4ushpubdnusfhapb55h` (`user_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom_page`
--

LOCK TABLES `custom_page` WRITE;
/*!40000 ALTER TABLE `custom_page` DISABLE KEYS */;
INSERT INTO `custom_page` VALUES (1,'null','[{\"x\":0,\"y\":100,\"id\":\"4\",\"name\":\"1x1\",\"component\":\"Exchange1x1\"},{\"h\":100,\"w\":90,\"x\":0,\"y\":0,\"id\":\"1\",\"name\":\"1x1\",\"component\":\"Account1x1\"}]',1);
/*!40000 ALTER TABLE `custom_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `benefit` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `product_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'국내 이용, \n해외 이용, \n쇼핑 멤버십/OTT/이동통신, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09122_img.png','09122','WE:SH All 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09122'),(2,'국내 가맹점, \n편의점/커피/올리브영 등, \n데일리 스탬프 연계 전월실적 채워드림, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09570_img.png','09570','WE:SH Daily 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09570'),(3,'국내가맹점, \n주말/공휴일, \n음식·교통, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09157_img.png','09157','가온올림카드(실속형)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09157'),(4,'기본 적립/할인, \n추가 적립, \n추가 할인, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09250_img.png','09250','The Easy카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09250'),(5,'간편결제, \n편의점/택시, \n쇼핑/배달, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09247_img.png','09247','마이핏카드(적립형)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09247'),(6,'KB Pay 3회당, \nKB Pay 매일 결제 시, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09113_img.png','09113','KB Pay 챌린지카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09113'),(7,'KB Pay 3회당, \nKB Pay 매일 결제 시, \n이용 리워드, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09114_img.png','09114','KB Pay 챌린지+카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09114'),(8,'전월실적 한도없이, \n스타벅스 이용 시, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04350_img.png','04350','toss KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04350'),(9,'KB Pay/음식/OTT, \n배달/커피/영화/미용실 등, \nHappy Birth Month / 전월실적 채워드림, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09123_img.png','09123','My WE:SH 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09123'),(10,'스타벅스, \n버거/패스트푸드, \n간편결제 Pay, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09174_img.png','09174','청춘대로 톡톡카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09174'),(11,'교통/통신/해외, \n생활/교육/쇼핑, \n연간리워드, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09169_img.png','09169','다담카드(비 OTP)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09169'),(12,'CU 최대, \n이동 통신 요금 자동납부, \nOTT 정기결제, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09060_img.png','09060','CU KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09060'),(13,'스타벅스, \n온라인 간편결제, \n구독, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09272_img.png','09272','톡톡 with카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09272'),(14,'푸드, \n특화서비스, \nPlus 서비스, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09244_img.png','09244','Easy on카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09244'),(15,'요기패스 멤버십, \n생활업종, \n구독서비스, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04284_img.png','04284','요기패스 신용카드(가로형)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04284'),(16,'랭킹닭컴, \n골프(연습)장, \n구독서비스, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04289_img.png','04289','랭킹닭컴 신용카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04289'),(17,'외식/커피, \n편의/생활, \n쇼핑/배달, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09248_img.png','09248','마이핏카드(할인형)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09248'),(18,'대중교통, \n생활서비스, \nKB Pay 이용 시 생활서비스, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09321_img.png','09321','K-패스카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09321'),(19,'전기/수소차 충전, \n주차, 세차, \nOTT, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/00230_img.png','00230','EV 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=00230'),(20,'온라인 쇼핑(KB Pay), \n주유, \n이동통신요금, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09115_img.png','09115','American Express Blue Card','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09115'),(21,'주유, \n통신/교통, \n대형마트, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09063_img.png','09063','굿데이올림카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09063'),(22,'주요 생활 영역, \n선호 영역(택1), \n일상 생활 영역, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09243_img.png','09243','Easy pick카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09243'),(23,'주유(SK,GS), \n정비,주차,세차, \n자동차보험, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09246_img.png','09246','Easy auto 티타늄카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09246'),(24,'티맵, \nOTT, \n주유, 식음료, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09389_img.png','09389','TMAP KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09389'),(25,'SK에너지, \n스피드메이트, \n대중교통, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02245_img.png','02245','SK에너지 러브유 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02245'),(26,'GS칼텍스, \n오토오아시스, \n대중교통, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04863_img.png','04863','GS행복가득카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04863'),(27,'E1 LPG 충전소, \n골프, 쇼핑, 외식, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04459_img.png','04459','E1 LPG KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04459'),(28,'쿠팡, 쿠팡이츠, 쿠팡플레이, \n국내·외 가맹점, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09292_img.png','09292','쿠팡 와우 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09292'),(29,'이마트/트레이더스, \n스타벅스&생활업종, \n구독서비스, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04361_img.png','04361','이마트II KB국민카드(옐로우)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04361'),(30,'온라인 쇼핑, \n커피, 편의점, \n오프라인 쇼핑, 온라인 항공/면세점, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09116_img.png','09116','American Express Rose Gold Card','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09116'),(31,'갤러리아 백화점, \n갤러리아 백화점, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04491_img.png','04491','갤러리아 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04491'),(32,'LFmall, \n국내외 가맹점, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09314_img.png','09314','LFmall 신용카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09314'),(33,'CJ푸드빌, \nCJ온스타일, \nCGV, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/01142_img.png','01142','The CJ KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=01142'),(34,'Shopping 서비스, \n선택서비스 (택1), \n+KB Pay 서비스, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09064_img.png','09064','Easy shopping카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09064'),(35,'간편결제(Pay), \n대중교통, \n편의점, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09231_img.png','09231','톡톡 Pay카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09231'),(36,'위메프, \n위메프오, \n생활영역/구독서비스, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04327_img.png','04327','위메프페이 신용카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04327'),(37,'롯데마트, \n택시/커피, \n놀이공원, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09180_img.png','09180','롯데마트 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09180'),(38,'11번가 OK캐쉬백, \n생활밀착업종 OK캐쉬백, \n전가맹점 OK캐쉬백, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04409_img.png','04409','CHALLENGE BAG KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04409'),(39,'GS SHOP, \n마트/통신, \n커피/편의점/택시, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04431_img.png','04431','GS SHOP KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04431'),(40,'AK 특화서비스, \n생활영역 할인, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04444_img.png','04444','AK KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04444'),(41,'H.Point, \n생활영역, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04415_img.png','04415','H.Point KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04415'),(42,'삼성 페이 간편결제, \n주요 생활영역, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04434_img.png','04434','삼성페이 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04434'),(43,'해외 이용 수수료, \n해외 이용 금액, \n쇼핑/커피/편의점/영화관, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09561_img.png','09561','WE:SH Travel','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09561'),(44,'국내가맹점 적립, \n해외이용 적립, \n적립한도 : 월별, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04285_img.png','04285','스카이패스 티타늄 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04285'),(45,'국내 이용금액 적립, \n해외 이용금액 적립, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09194_img.png','09194','아시아나 올림카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09194'),(46,'RefreshPoint, \n공항라운지, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04420_img.png','04420','제주항공 Refresh Point KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04420'),(47,'투어마일리지, \n외식/커피, \n놀이공원, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04422_img.png','04422','모두투어 투어마일리지 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04422'),(48,'\'우리\'를 위한, \n‘두리(소중한 당신)’을 위한, \n통신료, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09124_img.png','09124','Our WE:SH 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09124'),(49,'병원or마트, \n6대 영역, \n3대 영역, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04451_img.png','04451','골든라이프올림카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04451'),(50,'펫 보험료, \n동물병원&애완동물 업종, \n배달&간식, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09383_img.png','09383','KB손해보험 마이펫카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09383'),(51,'밀크T 학습비 자동이체, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/220608_04320_img.png','04320','밀크T 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04320'),(52,'웅진씽크빅 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02171_img.png','02171','웅진씽크빅 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02171'),(53,'학습비 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04334_img.png','04334','윙크Ⅱ카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04334'),(54,'비상온리원 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02210_img.png','02210','비상온리원 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02210'),(55,'반려동물, \n대형마트, \n온라인쇼핑몰, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04260_img.png','04260','반려愛카드(강아지)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04260'),(56,'반려동물 업종, \n대형마트, \n반려견 단체보험, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04404_img.png','04404','KB국민 펫코노미 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04404'),(57,'SKT 통신요금 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04288_img.png','04288','T-economy KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04288'),(58,'LG 헬로비전 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02170_img.png','02170','LG 헬로비전 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02170'),(59,'Liiv M 통신요금 자동이체, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04241_img.png','04241','Liiv M Ⅱ 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04241'),(60,'코웨이 렌탈료, \n코웨이 연간리워드, \n놀이공원, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04423_img.png','04423','코웨이Ⅱ 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04423'),(61,'SK매직 렌탈료, \n놀이공원, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04418_img.png','04418','SK매직 올림카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04418'),(62,'교원웰스 렌탈료, \n패밀리레스토랑, \n놀이공원, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04417_img.png','04417','교원 웰스 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04417'),(63,'렌탈료 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04336_img.png','04336','청호나이스Ⅱ카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04336'),(64,'토스모바일 통신요금 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04351_img.png','04351','토스모바일 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04351'),(65,'Wavve 월 이용권, \n식음료, \n멤버십 구독, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04287_img.png','04287','Wavve 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04287'),(66,'라이트할부, \n렌탈요금, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04425_img.png','04425','LG전자 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04425'),(67,'렌탈료 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04325_img.png','04325','쿠쿠렌탈Ⅱ카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04325'),(68,'렌탈료 자동납부, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04331_img.png','04331','세라젬 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04331'),(69,'예다함 상조부금, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04485_img.png','04485','예다함 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04485'),(70,'딜라이브 자동납부요금, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04345_img.png','04345','딜라이브 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04345'),(71,'알뜰폰 통신요금 자동이체, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04324_img.png','04324','알뜰폰 Hub Ⅱ 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04324'),(72,'KMVNO 알뜰폰 통신요금 자동이체, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04290_img.png','04290','KMVNO 알뜰폰 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04290'),(73,'보안·용역/사무기기/정수기렌탈, \n온라인광고/쇼핑, \n음식점/커피/편의점/다이소/슈퍼마켓/주유/골프, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09291_img.png','09291','사장님카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09291'),(74,'캐시노트 멤버십, \n국내외 가맹점, \n사업지원영역, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04291_img.png','04291','캐시노트 KB국민카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04291'),(75,'주유소(SK/GS), \n마트, 식자재매장, \n인터넷쇼핑몰, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09183_img.png','09183','탄탄대로 Biz카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09183'),(76,'국내 가맹점, \n주유/통신/전자상거래, \n건당 고액결제, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09176_img.png','09176','가온 Biz카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09176'),(77,'쇼핑/교육/자동납부, \n단체보험가입, \n단체보험가입, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02065_img.png','02065','국민행복카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02065'),(78,'5대 업종, \n군 복지시설, \n주유, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04131_img.png','04131','KB국민 군인연금증 신용카드(비사진)','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04131'),(79,'군휴양시설/체력단련장, \nGS칼텍스, \n모든가맹점, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/00996_img.png','00996','국방멤버쉽카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=00996'),(80,'영업용화물차, \nGS칼텍스 경유, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04095_img.png','04095','스타트럭Ⅱ GS칼텍스카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04095'),(81,'영업용화물차, \nS-OIL주유소(경유), \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04088_img.png','04088','스타트럭플러스 S-OIL카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04088'),(82,'영업용화물차, \nHD현대오일뱅크 경유, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04092_img.png','04092','스타트럭 플러스 HD현대오일뱅크카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04092'),(83,'영업용화물차, \nGS칼텍스(경유), \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/02076_img.png','02076','STARTLUCK 카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=02076'),(84,'영업용화물차, \nSK에너지(경유), \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/04550_img.png','04550','SK내트럭 유가보조금카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=04550'),(85,'카드사용알림서비스(SMS), \n연회비, \n클린카드 기능, \n','https://img1.kbcard.com/ST/img/cxc/kbcard/upload/img/product/09084_img.png','09084','보탬e전용카드','1','https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=09084'),(107,'사회초년생, 기간: 36개월, 이율: 연 2.75% ~ 3.25%',NULL,NULL,'KB국민첫재테크적금','2',NULL),(108,'사회초년생, 기간: 12개월, 이율: 연 3.5% ~ 5.5%',NULL,NULL,'KB국민행복적금','2',NULL),(109,'직장인, 기간: 36개월, 이율: 연 3.55% ~ 4.05%',NULL,NULL,'직장인우대적금','2',NULL),(110,'직장인, 기간: 60개월, 이율: 연 2.9% ~ 4.2%',NULL,NULL,'KB국민프리미엄적금 (자유적립식)','2',NULL),(111,'어린이, 청소년, 기간: 12개월, 이율: 연 2.1% ~ 3.4%',NULL,NULL,'KB Young Youth 적금','2',NULL),(112,'어린이, 청소년, 기간: 12개월, 이율: 연 2% ~ 10%',NULL,NULL,'KB아이사랑적금 NEW','2',NULL),(113,'특별, 맞춤형, 기간: 36개월, 이율: 연 3.15% ~ 3.75%',NULL,NULL,'KB내맘대로적금','2',NULL),(114,'특별, 맞춤형, 기간: 1개월, 이율: 연 2% ~ 6%',NULL,NULL,'KB특★한 적금','2',NULL),(115,'특별, 맞춤형, 기간: 60개월, 이율: 연 3% ~ 4.3%',NULL,NULL,'KB국민프리미엄적금 (정액적립식)','2',NULL),(116,'목돈, 기간: 36개월, 이율: 연 2.9% ~ 3.3%',NULL,NULL,'KB상호부금(자유적립식)','2',NULL),(117,'목돈, 기간: 36개월, 이율: 연 3% ~ 3.4%',NULL,NULL,'KB상호부금(정액적립식)','2',NULL),(118,'재테크, 기간: 12개월, 이율: 연 2% ~ 8%',NULL,NULL,'KB스타적금Ⅱ NEW','2',NULL),(119,'재테크, 기간: 12개월, 이율: 연 2.5% ~ 8%',NULL,NULL,'KB차차차 적금','2',NULL),(120,'미래, 기간: 24개월, 이율: 연 5% ~ 8%',NULL,NULL,'KB장병내일준비적금','2',NULL),(121,'미래, 기간: 60개월, 이율: 연 4.5% ~ 6%',NULL,NULL,'KB청년도약계좌','2',NULL),(122,'건강, 기간: 6개월, 이율: 연 2% ~ 8%',NULL,NULL,'온국민 건강적금','2',NULL),(123,'건강, 기간: 6개월, 이율: 연 2% ~ 10%',NULL,NULL,'온국민 건강적금-골든라이프','2',NULL),(124,'반려동물, 기간: 36개월, 이율: 연 3.25% ~ 4.75%',NULL,NULL,'KB반려행복적금','2',NULL),(125,'여행 노랑풍선 할인쿠폰, 기간: 6개월, 이율: 연 2.65% ~ 3.65%',NULL,NULL,'KB두근두근여행적금','2',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_number` bigint NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_number`),
  UNIQUE KEY `UKa3imlf41l37utmxiquukk8ajc` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user01','김민철','Password1!'),(2,'user02','김종수','Password1!');
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

-- Dump completed on 2024-11-22  5:41:24
