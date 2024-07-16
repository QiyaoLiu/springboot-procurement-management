-- MySQL dump 10.13  Distrib 8.0.37, for macos14 (arm64)
--
-- Host: localhost    Database: db01
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `tb_order`
--

DROP TABLE IF EXISTS `tb_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'only for one material from one supplier',
  `supplier_id` int NOT NULL COMMENT 'connected with the table supplier',
  `material_name` varchar(100) NOT NULL COMMENT 'name of the material',
  `material_quantity` int NOT NULL,
  `unit` varchar(25) NOT NULL,
  `single_price` decimal(24,2) NOT NULL COMMENT 'price of single unit',
  `total_price` decimal(24,2) NOT NULL,
  `create_time` datetime NOT NULL COMMENT 'time of creation of the material',
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_order___fk_supplier_id` (`supplier_id`),
  CONSTRAINT `tb_order___fk_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `tb_supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_order`
--

LOCK TABLES `tb_order` WRITE;
/*!40000 ALTER TABLE `tb_order` DISABLE KEYS */;
INSERT INTO `tb_order` VALUES (1,4,'Quantum Fiber',50,'meter',25.00,1250.00,'2024-06-28 11:34:41','late delivery '),(2,1,'NanoSteel Sheets',200,'sheet',45.00,9000.00,'2024-06-28 11:35:22',NULL),(3,10,'HyperAlloy Rods',75,'rod',80.00,6000.00,'2024-06-28 11:35:59',NULL),(4,3,'Crystal Polymer',100,'kg',30.00,3000.00,'2024-06-28 11:36:35',''),(5,1,'BioCeramic Tiles',300,'tile',15.00,4500.00,'2024-06-28 11:37:04',NULL),(6,2,'Graphene Sheets',150,'sheet',70.00,10500.00,'2024-06-28 11:37:31',NULL),(7,3,'Superconductive Wire',200,'meter',40.00,8000.00,'2024-06-28 11:38:30','test'),(8,9,'AeroGel Panels',59,'panel',120.00,6000.00,'2024-06-28 11:39:04',NULL),(9,3,'SmartGlass',90,'square meter',32.00,4950.00,'2024-06-28 11:40:02',NULL),(10,7,'Carbon Nanotubes',500,'gram',150.00,75000.00,'2024-06-28 11:40:46',NULL),(11,1,'BioPlastic Pellets',500,'kg',3.00,1500.00,'2024-07-11 13:15:09',NULL),(12,3,'Titanium Alloy Sheets',100,'sheet',150.00,15000.00,'2024-07-12 11:47:05',NULL);
/*!40000 ALTER TABLE `tb_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_supplier`
--

DROP TABLE IF EXISTS `tb_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_supplier` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'supplier ID, primary key',
  `supplier_name` varchar(50) NOT NULL COMMENT 'supplier name， connected with the table order',
  `address` varchar(100) NOT NULL COMMENT 'registered dddress of the supplier',
  `contact_person` varchar(20) DEFAULT NULL COMMENT 'contact person of the supplier',
  `email` varchar(50) DEFAULT NULL COMMENT 'e-mail address of the company',
  `comment` varchar(100) DEFAULT NULL COMMENT 'short comment about the supplier',
  `create_time` datetime NOT NULL COMMENT 'time of creation of the supplier',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_supplier_pk` (`supplier_name`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='supplier basic information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_supplier`
--

LOCK TABLES `tb_supplier` WRITE;
/*!40000 ALTER TABLE `tb_supplier` DISABLE KEYS */;
INSERT INTO `tb_supplier` VALUES (1,'VirtuSphere Solutions GmbH','Alexanderplatz 4, 10178 Berlin, Germany','Hans Müller','hans.mueller@virtusphere.de','test','2024-06-28 11:13:49'),(2,'CyberNet Dynamics GmbH','Königsallee 2a, 40212 Düsseldorf, Germany','Anna Schmidt','anna.schmidt@cybernetdynamics.de','','2024-06-28 11:14:57'),(3,'NeoWave Technologies GmbH','Ludwigstraße 12, 80539 München, Germany','Markus Fischer','markus.fischer@neowave.de',NULL,'2024-06-28 11:14:58'),(4,'Digital Nexus Corp GmbH','Mönckebergstraße 7, 20095 Hamburg, Germany','Laura Weber','laura.weber@digitalnexus.de','test3','2024-06-28 11:15:42'),(5,'TechVision GmbH','Breite Straße 80, 50667 Köln, Germany','Sabrina Neumann','sabrina.neumann@techvision.de','','2024-07-04 16:24:53'),(6,'Quantum Leap Solutions GmbH','Friedrichstraße 68, 10117 Berlin, Germany','Lisa Wagner','lisa.wagner@quantumleap.de',NULL,'2024-06-28 11:16:59'),(7,'NextGen Systems GmbH','Zeil 106, 60313 Frankfurt am Main, Germany','Tobias Meier','tobias.meier@nextgensystems.de',NULL,'2024-06-28 11:23:16'),(8,'FutureTech Innovations GmbH','Hohe Straße 52, 44139 Dortmund, Germany','Julia Hoffmann','julia.hoffmann@futuretech.de',NULL,'2024-06-28 11:23:49'),(9,'InnoWave Solutions GmbH','Karlsplatz 1, 80335 München, Germany','Daniel Braun','daniel.braun@innowave.de',NULL,'2024-06-28 11:24:44'),(10,'Skyline Technologies GmbH','Jungfernstieg 12, 20354 Hamburg, Germany','Michael Becker','michael.becker@skylinetech.de',NULL,'2024-07-04 16:28:26'),(11,'InnovateX GmbH','Königstraße 26, 70173 Stuttgart, Germany','Nicole Fischer','nicole.fischer@innovatex.de',NULL,'2024-07-12 11:48:02'),(12,'TechWave Solutions GmbH','Leopoldstraße 23, 80802 München, Germany','Thomas Krüger','thomas.krueger@techwave.de',NULL,'2024-07-12 11:48:44'),(13,'EvoTech Dynamics GmbH','Bahnhofstraße 25, 90402 Nürnberg, Germany','Katrin Schmidt','katrin.schmidt@evotech.de',NULL,'2024-07-12 11:49:25'),(14,'AlphaNet Innovations GmbH','Hohenzollernring 80, 50672 Köln, Germany','Stefan Richter','stefan.richter@alphanet.de',NULL,'2024-07-12 11:50:02'),(15,'TechFusion GmbH','Friedrichstraße 44, 10117 Berlin, Germany','Alexander Schulz','alexander.schulz@techfusion.de',NULL,'2024-07-12 11:51:17'),(16,'InnoTech Solutions GmbH','Rosenstraße 12, 80331 München, Germany','Julia Richter','julia.becker@innotech.de',NULL,'2024-07-12 11:52:16');
/*!40000 ALTER TABLE `tb_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `username` varchar(50) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  UNIQUE KEY `tb_user_pk` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('admin',1,'admin',NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-16  9:18:35
