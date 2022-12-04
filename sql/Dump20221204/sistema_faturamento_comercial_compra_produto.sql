CREATE DATABASE  IF NOT EXISTS `sistema_faturamento_comercial` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistema_faturamento_comercial`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_faturamento_comercial
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `compra_produto`
--

DROP TABLE IF EXISTS `compra_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `compra_id` int NOT NULL,
  `produto_id` int NOT NULL,
  `quantidade` int NOT NULL,
  `total` mediumtext,
  PRIMARY KEY (`id`),
  KEY `FK_CompraId` (`compra_id`),
  KEY `FK_ProdutoId` (`produto_id`),
  CONSTRAINT `FK_CompraId` FOREIGN KEY (`compra_id`) REFERENCES `compra` (`id`),
  CONSTRAINT `FK_ProdutoId` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_produto`
--

LOCK TABLES `compra_produto` WRITE;
/*!40000 ALTER TABLE `compra_produto` DISABLE KEYS */;
INSERT INTO `compra_produto` VALUES (31,4,2,5,'6000.0'),(32,4,2,5,'6000.0'),(33,4,2,1,'1200.0'),(34,4,2,1,'1200.0'),(35,5,2,1,'1200.0'),(36,4,2,1,'1200.0'),(37,4,2,1,'1200.0'),(38,4,2,1,'1200.0'),(39,4,2,1,'1200.0'),(40,4,2,1,'1200.0'),(41,4,2,1,'1200.0'),(42,4,2,1,'1200.0'),(43,4,2,2,'2400.0'),(44,4,3,2,'3600.0'),(45,4,3,1,'1800.0'),(46,4,3,1,'1800.0'),(47,13,3,1,'1800.0'),(48,12,3,4,'7200.0'),(49,4,3,1,'1800.0'),(50,13,3,1,'1800.0'),(51,13,3,1,'1800.0'),(52,12,3,1,'1800.0'),(53,12,3,1,'1800.0'),(54,12,3,1,'1800.0'),(55,4,2,4,'4800.0'),(56,4,2,1,'1200.0'),(57,4,2,2,'2400.0'),(58,4,2,1,'1200.0'),(59,4,3,1,'1800.0'),(60,4,2,-1,'-1200.0'),(61,13,2,1,'1200.0'),(62,8,3,1,'2000.0'),(63,4,3,1,'2000.0'),(64,4,2,1,'1200.0'),(65,4,3,1,'2000.0'),(66,4,2,2,'2400.0'),(67,4,2,1,'1200.0'),(68,4,2,1,'1200.0'),(70,4,4,1,'1000.0'),(71,15,4,1,'1000.0'),(72,16,2,5,'6000.0'),(73,4,2,5,'6000.0');
/*!40000 ALTER TABLE `compra_produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 15:18:25
