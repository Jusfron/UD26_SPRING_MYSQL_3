DROP TABLE IF EXISTS `productos`;
SET character_set_client = utf8mb4 ;

CREATE TABLE `productos` (
  id int not null auto_increment,
  `nombre` varchar(100) DEFAULT NULL,
  precio int,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'producto 1',10),(2,'producto 2', 25),(3,'producto 3', 50),(4,'producto 4', 5);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `cajeros`;
SET character_set_client = utf8mb4 ;

CREATE TABLE `cajeros` (
  id int not null auto_increment,
  `nom_apels` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `cajeros` WRITE;
/*!40000 ALTER TABLE `cajeros` DISABLE KEYS */;
INSERT INTO `cajeros` VALUES (1,'cajero 1'),(2,'cajero 2'),(3,'cajero 3'),(4,'cajero 4');
/*!40000 ALTER TABLE `cajeros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maquinas_registradoras`
--

DROP TABLE IF EXISTS `maquinas_registradoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `maquinas_registradoras` (
	id int not null auto_increment,
    piso int,
    primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquinas_registradoras`
--

LOCK TABLES `maquinas_registradoras` WRITE;
/*!40000 ALTER TABLE `maquinas_registradoras` DISABLE KEYS */;
INSERT INTO `maquinas_registradoras` VALUES (1,1),(2,1),(3,2),(4,2);
/*!40000 ALTER TABLE `maquinas_registradoras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `venta` (
	id int not null auto_increment,
	cajero int,
	maquina int,
	producto int,
    primary key(id),
	CONSTRAINT cajeros_fk FOREIGN KEY (cajero) REFERENCES productos (id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT maquinas_registradoras_fk FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT productos_fk FOREIGN KEY (producto) REFERENCES productos (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,1,1,1),(2,4,2,1),(3,3,2,4),(4,1,3,4);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;