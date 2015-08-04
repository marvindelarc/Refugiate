CREATE DATABASE  IF NOT EXISTS `servitec1_refugiate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `servitec1_refugiate`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 204.93.216.11    Database: servitec1_refugiate
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `bajaempresapersona`
--

DROP TABLE IF EXISTS `bajaempresapersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bajaempresapersona` (
  `idBajaEmpresaPersona` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` int(11) DEFAULT NULL,
  `idPersona` int(11) DEFAULT NULL,
  `comentario` varchar(250) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `fechaFinal` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBajaEmpresaPersona`),
  KEY `fk_BajaEmpresaPersona_Empresa1_idx` (`idEmpresa`),
  KEY `fk_BajaEmpresaPersona_Persona1_idx` (`idPersona`),
  CONSTRAINT `fk_BajaEmpresaPersona_Empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_BajaEmpresaPersona_Persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bajaempresapersona`
--

LOCK TABLES `bajaempresapersona` WRITE;
/*!40000 ALTER TABLE `bajaempresapersona` DISABLE KEYS */;
/*!40000 ALTER TABLE `bajaempresapersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idComentario` int(11) NOT NULL AUTO_INCREMENT,
  `idReserva` int(11) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idComentario`),
  KEY `fk_Comentario_Reserva1_idx` (`idReserva`),
  CONSTRAINT `fk_Comentario_Reserva1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costotipohabitacion`
--

DROP TABLE IF EXISTS `costotipohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costotipohabitacion` (
  `idCostoTipoHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoHabitacion` int(11) DEFAULT NULL,
  `idSucursal` int(11) DEFAULT NULL,
  `costo` decimal(10,2) DEFAULT NULL,
  `numeroPersonas` int(11) DEFAULT NULL,
  `totalHabitaicones` int(11) DEFAULT NULL,
  `habitacionesOcupadas` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idCostoTipoHabitacion`),
  KEY `fk_CostoTipoHabitacion_TipoHabitacion1_idx` (`idTipoHabitacion`),
  KEY `fk_CostoTipoHabitacion_Sucursal1_idx` (`idSucursal`),
  CONSTRAINT `fk_CostoTipoHabitacion_Sucursal1` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CostoTipoHabitacion_TipoHabitacion1` FOREIGN KEY (`idTipoHabitacion`) REFERENCES `tipohabitacion` (`idTipoHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costotipohabitacion`
--

LOCK TABLES `costotipohabitacion` WRITE;
/*!40000 ALTER TABLE `costotipohabitacion` DISABLE KEYS */;
INSERT INTO `costotipohabitacion` VALUES (1,1,4,125.00,2,2,0,1,'2015-05-19 19:19:32'),(2,4,4,102.50,1,5,0,1,'2015-05-19 19:19:32'),(3,1,5,25.00,1,1,0,1,'2015-05-19 19:19:32'),(4,1,4,100.00,2,1,0,1,'2015-05-19 19:19:32');
/*!40000 ALTER TABLE `costotipohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Amazonas'),(2,'Ancash'),(3,'Apurimac'),(4,'Arequipa'),(5,'Ayacucho'),(6,'Cajamarca'),(7,'Cusco'),(8,'Huancavelica'),(9,'Huanuco'),(10,'Ica'),(11,'JunÃ­'),(12,'La Libertad'),(13,'Lambayeque'),(14,'Lima'),(15,'Prov. Const. del   Callao'),(16,'Loreto'),(17,'Madre de Dios'),(18,'Moquegua'),(19,'Pasco'),(20,'Piura'),(21,'Puno'),(22,'San MartÃ­'),(23,'Tacna'),(24,'Tumbes'),(25,'Ucayali');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallereserva`
--

DROP TABLE IF EXISTS `detallereserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallereserva` (
  `idDetalleReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idReserva` int(11) DEFAULT NULL,
  `numeroHabitaciones` int(11) DEFAULT NULL,
  `fechaIngresp` datetime DEFAULT NULL,
  `dias` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `idHabitacion` int(11) NOT NULL,
  PRIMARY KEY (`idDetalleReserva`),
  KEY `fk_DetalleReserva_Reserva1_idx` (`idReserva`),
  KEY `fk_DetalleReserva_Habitacion1_idx` (`idHabitacion`),
  CONSTRAINT `fk_DetalleReserva_Habitacion1` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_DetalleReserva_Reserva1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallereserva`
--

LOCK TABLES `detallereserva` WRITE;
/*!40000 ALTER TABLE `detallereserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallereserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `idDistrito` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `idProvincia` int(11) NOT NULL,
  PRIMARY KEY (`idDistrito`),
  KEY `fk_Distrito_Provincia1_idx` (`idProvincia`),
  CONSTRAINT `fk_Distrito_Provincia1` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idProvincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES (1,'Bagua',1),(2,'La Peca',1),(3,'Aramango',1),(4,'Copalli',1),(5,'El Parco',1),(6,'Imaza',1),(7,'Corosha',2),(8,'Cuispes',2),(9,'Chisquilla',2),(10,'Churuja',2),(11,'Florida',2),(12,'JazÃ¡',2),(13,'Recta',2),(14,'San Carlos',2),(15,'Shipasbamba',2),(16,'Valera',2),(17,'Yambrasbamba',2),(18,'El Cenepa',3),(19,'Nieva',3),(20,'RÃ­o Santiago',3),(21,'Chachapoyas',4),(22,'AsunciÃ³',4),(23,'Balsas',4),(24,'Cheto',4),(25,'ChiliquÃ­',4),(26,'Chuquibamba',4),(27,'Granada',4),(28,'Huancas',4),(29,'La Jalca',4),(30,'Leymebamba',4),(31,'Levanto',4),(32,'Magdalena',4),(33,'Mariscal Castilla',4),(34,'Molinopampa',4),(35,'Montevideo',4),(36,'Olleros',4),(37,'Quinjalca',4),(38,'San Francisco de Daguas',4),(39,'San Isidro de Maino',4),(40,'Soloco',4),(41,'Sonche',4),(42,'Camporredondo',5),(43,'Cocabamba',5),(44,'Colcamar',5),(45,'Conila',5),(46,'Inguilpata',5),(47,'LÃ¡mud',5),(48,'Longuita',5),(49,'Lonya Chico',5),(50,'Luya',5),(51,'Luya Viejo',5),(52,'MarÃ­a',5),(53,'Ocalli',5),(54,'Ocumal',5),(55,'PisuquÃ­a',5),(56,'Providencia',5),(57,'San CristÃ³bal',5),(58,'San Francisco del Yeso',5),(59,'San JerÃ³nimo',5),(60,'San Juan de Lopecancha',5),(61,'Santa Catalina',5),(62,'Santo TomÃ¡s',5),(63,'Tingo',5),(64,'Trita',5),(65,'Chirimoto',6),(66,'Cochamal',6),(67,'Huambo',6),(68,'Limabamba',6),(69,'Longar',6),(70,'Mariscal Benavides',6),(71,'Milpuc',6),(72,'Omia',6),(73,'San NicolÃ¡s',6),(74,'Santa Rosa',6),(75,'Totora',6),(76,'Vista Alegre',6),(77,'Bagua Grande',7),(78,'Cajaruro',7),(79,'Cumba',7),(80,'El Milagro',7),(81,'Jamalca',7),(82,'Lonya Grande',7),(83,'YamÃ³',7),(84,'Aija',8),(85,'Coris',8),(86,'HuacllÃ¡',8),(87,'La Merced',8),(88,'Succha',8),(89,'LlamellÃ­',9),(90,'Aczo',9),(91,'Chaccho',9),(92,'Chingas',9),(93,'Mirgas',9),(94,'San Juan de Rontoy',9),(95,'Chacas',10),(96,'Acochaca',10),(97,'Abelardo Pardo Lezameta',11),(98,'Antonio Raymondi',11),(99,'Aquia',11),(100,'Canis',11),(101,'Colquioc',11),(102,'Cajacay',11),(103,'ChiquiÃ¡',11),(104,'Huallanca',11),(105,'Huasta',11),(106,'HuayllacayÃ¡',11),(107,'La Primavera',11),(108,'Mangas',11),(109,'PacllÃ³',11),(110,'San Miguel de Corpanqui',11),(111,'Ticllos',11),(112,'Casma',12),(113,'Buena Vista Alta',12),(114,'Comandante Noel',12),(115,'YautÃ¡',12),(116,'CarhuÃ¡s',13),(117,'Acopampa',13),(118,'Amashca',13),(119,'Anta',13),(120,'Ataquero',13),(121,'MarcarÃ¡',13),(122,'Pariahuanca',13),(123,'San Miguel de Aco',13),(124,'Shilla',13),(125,'Tinco',13),(126,'Yungar',13),(127,'San Luis',14),(128,'San NicolÃ¡s',14),(129,'Yauya',14),(130,'Aco',15),(131,'Bambas',15),(132,'Cusca',15),(133,'La Pampa',15),(134,'YÃ¡nac',15),(135,'YupÃ¡',15),(136,'Cochabamba',16),(137,'Colcabamba',16),(138,'Huanchay',16),(139,'Independencia',16),(140,'Jangas',16),(141,'La Libertad',16),(142,'Olleros',16),(143,'Pampas',16),(144,'Pariacoto',16),(145,'Pira',16),(146,'Tarica',16),(147,'Huari',17),(148,'Anra',17),(149,'Cajay',17),(150,'ChavÃ­n de Huantar',17),(151,'Huacachi',17),(152,'Huacchis',17),(153,'Huachis',17),(154,'Huantar',17),(155,'Masi',17),(156,'Paucas',17),(157,'PontÃ³',17),(158,'Rahuapampa',17),(159,'RapayÃ¡',17),(160,'San Marcos',17),(161,'San Pedro de ChanÃ¡',17),(162,'Uco',17),(163,'Huarmey',18),(164,'Cochapeti',18),(165,'Culebras',18),(166,'Huaya',18),(167,'Malvas',18),(168,'Caraz',19),(169,'Huallanca',19),(170,'Huata',19),(171,'Huaylas',19),(172,'Mato',19),(173,'PamparomÃ¡s',19),(174,'Pueblo Libre',19),(175,'Santa Cruz',19),(176,'Santo Toribio',19),(177,'Yuracmarca',19),(178,'Piscobamba',20),(179,'Casca',20),(180,'Eleazar GuzmÃ¡n BarrÃ³',20),(181,'Fidel OIivas Escudero',20),(182,'Llama',20),(183,'Llumpa',20),(184,'Musga',20),(185,'Lucma',20),(186,'Ocros',21),(187,'Acas',21),(188,'Cajamarquilla',21),(189,'Carhuapamga',21),(190,'Cochas',21),(191,'Congas',21),(192,'Llipa',21),(193,'San CristÃ³bal de RajÃ¡',21),(194,'San Pedro',21),(195,'Santiago de Chilcas',21),(196,'Cabana',22),(197,'Bolognesi',22),(198,'Conchucos',22),(199,'Huacaschuque',22),(200,'Huandoval',22),(201,'Lacabamba',22),(202,'Llapo',22),(203,'Pallasca',22),(204,'Pampas',22),(205,'Santa Rosa',22),(206,'Tauca',22),(207,'Pomabamba',23),(208,'HuayllÃ¡',23),(209,'Parobamba',23),(210,'Quinuabamba',23),(211,'Recuay',24),(212,'Catac',24),(213,'Cotaparaco',24),(214,'Huayllapampa',24),(215,'LlacllÃ­',24),(216,'Marca',24),(217,'Pampas Chico',24),(218,'PararÃ­',24),(219,'Tapacocha',24),(220,'Ticapampa',24),(221,'Chimbote (cercado)',25),(222,'CÃ¡ceres del PerÃº',25),(223,'Coishco',25),(224,'Macate',25),(225,'Moro',25),(226,'NepeÃ±a',25),(227,'Nuevo Chimbote',25),(228,'Samanco',25),(229,'Santa',25),(230,'Sihuas',26),(231,'Acobamba',26),(232,'Alfonso Ugarte',26),(233,'Cashapampa',26),(234,'Chingalpo',26),(235,'Huayllabamba',26),(236,'Quiches',26),(237,'Ragash',26),(238,'San Jua',26),(239,'Sicsibamba',26),(240,'Yungay',27),(241,'Cascapara',27),(242,'Mancos',27),(243,'Matacoto',27),(244,'Quillo',27),(245,'Ranrahirca',27),(246,'Shupluy',27),(247,'Yanama',27),(248,'Abancay',28),(249,'Chacoche',28),(250,'Circa',28),(251,'Curahuasi',28),(252,'Huanipaca',28),(253,'Lambrama',28),(254,'Pichirhua',28),(255,'San Pedro de Cachora',28),(256,'Tamburco',28),(257,'Andahuaylas',29),(258,'Andarapa',29),(259,'Chiara',29),(260,'Huancarama',29),(261,'Huancaray',29),(262,'Huayana',29),(263,'Kaquiabamba',29),(264,'Kishuara',29),(265,'Pacobamba',29),(266,'Pacucha',29),(267,'Pampachiri',29),(268,'Pomacocha',29),(269,'San Antonio de Cachi',29),(270,'San JerÃ³nimo',29),(271,'San Miguel de Chaccrapampa',29),(272,'Santa MarÃ­a de Chicmo',29),(273,'Talavera de la Reyna',29),(274,'Tumay Huaraca ',29),(275,'Turpo',29),(276,'Antabamba',30),(277,'El Oro',30),(278,'Huaquirca',30),(279,'Juan Espinoza Medrano',30),(280,'Oropesa',30),(281,'Pachaconas',30),(282,'Sabaino',30),(283,'Chalhuanca',31),(284,'Capaya',31),(285,'Caraybamba',31),(286,'Chapimarca',31),(287,'Colcabamba',31),(288,'Cotaruse',31),(289,'Huayllu',31),(290,'Justo Apu Sahuaraura',31),(291,'Lucre',31),(292,'Pocohuanca',31),(293,'San Juan de ChacÃ±a',31),(294,'SaÃ±ayca',31),(295,'Soraya',31),(296,'Tapairihua',31),(297,'Tintay',31),(298,'Toraya',31),(299,'Yanaca',31),(300,'Tambobamba',32),(301,'Cotabambas',32),(302,'Coyllurqui',32),(303,'Haquira',32),(304,'Mara',32),(305,'Chalhuahuacho',32),(306,'Chincheros',33),(307,'Anco-Huallo',33),(308,'Cocharcas',33),(309,'Huaccana',33),(310,'Ocobamba',33),(311,'Ongoy',33),(312,'Uranmarca',33),(313,'Ranracancha',33),(314,'Chuquibambilla',34),(315,'Curpahuasi',34),(316,'Gamarra',34),(317,'Huayllati',34),(318,'Mamara',34),(319,'Micaela Bastidas',34),(320,'Pataypampa',34),(321,'Progreso',34),(322,'San Antonio',34),(323,'Santa Rosa',34),(324,'Turpay',34),(325,'Vilcabamba',34),(326,'Virundo',34),(327,'Curasco',34),(328,'Alto Selva Alegre',35),(329,'Arequipa',35),(330,'Cayma',35),(331,'Cerro Colorado',35),(332,'Characato',35),(333,'Chiguata',35),(334,'Jacobo Hunter',35),(335,'JosÃ© Luis Bustamante y Rivero',35),(336,'La Joya',35),(337,'Mariano Melgar',35),(338,'Miraflores',35),(339,'Mollebaya',35),(340,'Paucarpata',35),(341,'Pocsi',35),(342,'Polobaya',35),(343,'QuequeÃ±a',35),(344,'SabandÃ­a',35),(345,'Sachaca',35),(346,'San Juan de Siguas',35),(347,'San Juan de Tarucani',35),(348,'Santa Isabel de Siguas',35),(349,'Santa Rita de Siguas',35),(350,'Socabaya',35),(351,'Tiabaya',35),(352,'Uchumayo',35),(353,'Vitor',35),(354,'Yanahuara',35),(355,'Yarabamba',35),(356,'Yura',35),(357,'Achoma',36),(358,'Cabanaconde',36),(359,'Callalli',36),(360,'Caylloma',36),(361,'Chivay',36),(362,'Coporaque',36),(363,'Huambo',36),(364,'Huanca',36),(365,'Ichupampa',36),(366,'Lari',36),(367,'Lluta',36),(368,'Maca',36),(369,'Madrigal',36),(370,'San Antonio de Chuca',36),(371,'Sibayo',36),(372,'Tapay',36),(373,'Tisco',36),(374,'Tuti',36),(375,'Yanque',36),(376,'CamanÃ¡',37),(377,'JosÃ© MarÃ­a Quimper',37),(378,'Mariano NicolÃ¡s Valcarcel',37),(379,'Mariscal CÃ¡ceres',37),(380,'NicolÃ¡s de PiÃ©rola',37),(381,'OcoÃ±a',37),(382,'Quilca',37),(383,'Samuel Pastor',37),(384,'CaravelÃ­',38),(385,'AcarÃ­',38),(386,'Atico',38),(387,'Atiquipa',38),(388,'Bella UniÃ³',38),(389,'Cahuacho',38),(390,'Chala',38),(391,'Chaparra',38),(392,'Huanuhuanu',38),(393,'Jaqui',38),(394,'Lomas',38),(395,'Quicacha',38),(396,'Yauca',38),(397,'Aplao',39),(398,'Andahua',39),(399,'Ayo',39),(400,'Chachas',39),(401,'Chilcaymarca',39),(402,'Choco',39),(403,'Huancarqui',39),(404,'Machaguay',39),(405,'Orcopampa',39),(406,'Pampacolca',39),(407,'TipÃ¡',39),(408,'UÃ±Ã³',39),(409,'Uraca',39),(410,'Viraco',39),(411,'Chuquibamba',40),(412,'Andaray',40),(413,'Cayarani',40),(414,'Chichas',40),(415,'Iray',40),(416,'RÃ­o Grande',40),(417,'Salamanca',40),(418,'Yanaquihua - Ispacas',40),(419,'Mollendo',41),(420,'Cocachacra',41),(421,'DeÃ¡n Valdivia',41),(422,'Islay',41),(423,'MejÃ­a',41),(424,'Punta de BombÃ³',41),(425,'Alca',42),(426,'Charcana',42),(427,'Huaynacotas',42),(428,'Pampamarca',42),(429,'Puyca',42),(430,'Quechualla',42),(431,'Sayla',42),(432,'TaurÃ­a',42),(433,'Tomepampa',42),(434,'Toro',42),(435,'Cangallo',43),(436,'Chuschi',43),(437,'Los Morochucos',43),(438,'MarÃ­a Parado de Bellido',43),(439,'Paras',43),(440,'Totos',43),(441,'Ayacucho',44),(442,'Acocro',44),(443,'Acos Vinchos',44),(444,'Carmen Alto',44),(445,'Chiara',44),(446,'JesÃºs Nazareno',44),(447,'Ocros',44),(448,'Pacaycasa',44),(449,'Quinua',44),(450,'San JosÃ© de Ticllas',44),(451,'San Juan Bautista',44),(452,'Santiago de Pischa',44),(453,'Socos',44),(454,'Tambillo',44),(455,'Vinchos',44),(456,'Carapo',45),(457,'Sacsamarca',45),(458,'Sancos',45),(459,'Santiago de Lucanamarca',45),(460,'Huanta',46),(461,'Ayahuanco',46),(462,'Huamanguilla',46),(463,'Iguai',46),(464,'Llochegua',46),(465,'Luricocha',46),(466,'Santillana',46),(467,'Sivia',46),(468,'San Miguel',47),(469,'Anco',47),(470,'Ayna',47),(471,'Chilcas',47),(472,'Chungui',47),(473,'Luis Carranza',47),(474,'San Francisco',47),(475,'Santa Rosa',47),(476,'Tambo',47),(477,'Samugari1',47),(478,'Puquio',48),(479,'Aucara',48),(480,'Cabana',48),(481,'Carmen Salcedo',48),(482,'ChaviÃ±a',48),(483,'Chipao',48),(484,'Huac-Huas',48),(485,'Laramate',48),(486,'Leoncio Prado',48),(487,'Llauta',48),(488,'Lucanas',48),(489,'OcaÃ±a',48),(490,'Otoca',48),(491,'Saisa',48),(492,'San CristÃ³bal',48),(493,'San Jua',48),(494,'San Pedro',48),(495,'San Pedro de Palco',48),(496,'Sancos',48),(497,'Santa Ana de Huaycahuacho',48),(498,'Santa LucÃ­a',48),(499,'Coracora',49),(500,'Chumpi',49),(501,'Coronel CastaÃ±eda',49),(502,'Pacapausa',49),(503,'Pullo',49),(504,'Puyusca',49),(505,'San Francisco de Ravacayco',49),(506,'Upahuacho',49),(507,'Pauza',50),(508,'Colta',50),(509,'Corculla',50),(510,'Lampa',50),(511,'Marcabamba',50),(512,'Oyolo',50),(513,'Pararca',50),(514,'San Javier de Alpabamba',50),(515,'San JosÃ© de Ushua',50),(516,'Sara Sara',50),(517,'Querobamba',51),(518,'BelÃ©',51),(519,'Chalcos',51),(520,'Chilcayoc',51),(521,'HuacaÃ±a',51),(522,'Morcolla',51),(523,'Paico',51),(524,'San Pedro de Larcay',51),(525,'San Salvador de Quije',51),(526,'Santiago de Paucaray',51),(527,'Soras',51),(528,'Huancapi',52),(529,'Alcamenca',52),(530,'Apongo',52),(531,'Asquipata',52),(532,'Canaria',52),(533,'Cayara',52),(534,'Colca',52),(535,'Huamanquiquia',52),(536,'Huaya',52),(537,'Sarhua',52),(538,'Vilcanchos',52),(539,'VilcashuamÃ¡',53),(540,'Accomarca',53),(541,'Carhuanca',53),(542,'ConcepciÃ³',53),(543,'Huambalpa',53),(544,'Independencia',53),(545,'Saurama',53),(546,'Vischongo',53),(547,'Cachachi',54),(548,'Cajabamba',54),(549,'Condebamba',54),(550,'Sitacocha',54),(551,'Cajamarca',55),(552,'AsunciÃ³',55),(553,'Chetilla',55),(554,'CospÃ¡',55),(555,'JesÃºs',55),(556,'Llacanora',55),(557,'La EncaÃ±ada',55),(558,'Los BaÃ±os del Inca',55),(559,'Magdalena',55),(560,'MatarÃ¡',55),(561,'Namora',55),(562,'San Jua',55),(563,'CelendÃ­',56),(564,'Chumuch',56),(565,'Cortegana',56),(566,'Huasmi',56),(567,'Jorge ChÃ¡vez',56),(568,'JosÃ© GÃ¡lvez',56),(569,'La Libertad de PallÃ¡',56),(570,'Miguel Iglesias',56),(571,'Oxamarca',56),(572,'Sorochuco',56),(573,'Sucre',56),(574,'Utco',56),(575,'ContumazÃ¡',57),(576,'Chilete',57),(577,'Cupisnique',57),(578,'Guzmango',57),(579,'San Benito',57),(580,'Santa Cruz de Toledo',57),(581,'Tantarica',57),(582,'YonÃ¡',57),(583,'Cutervo',58),(584,'Callayuc',58),(585,'Choros',58),(586,'Cujillo',58),(587,'La Ramada',58),(588,'Pimpingos',58),(589,'Querocotillo',58),(590,'San AndrÃ©s de Cutervo',58),(591,'San Juan de Cutervo',58),(592,'San Luis de Lucma',58),(593,'Santa Cruz',58),(594,'Santo Domingo de la Capilla',58),(595,'Santo TomÃ¡s',58),(596,'Socota',58),(597,'Toribio Casanova',58),(598,'Chota',59),(599,'AnguÃ­a',59),(600,'ChadÃ­',59),(601,'Chalamarca',59),(602,'Chiguirip',59),(603,'Chimba',59),(604,'Choropampa',59),(605,'Cochabamba',59),(606,'ConchÃ¡',59),(607,'Huambos',59),(608,'Lajas',59),(609,'Llama',59),(610,'Miracosta',59),(611,'Paccha',59),(612,'Pio',59),(613,'Querocoto',59),(614,'San Juan de Licupis',59),(615,'Tacabamba',59),(616,'Tocmoche',59),(617,'Bambamarca',60),(618,'Chugur',60),(619,'Hualgayoc',60),(620,'JaÃ©',61),(621,'Bellavista',61),(622,'ChontalÃ­',61),(623,'Colasay',61),(624,'Huabal',61),(625,'Las Pirias',61),(626,'Pomahuaca',61),(627,'PucarÃ¡',61),(628,'Sallique',61),(629,'San Felipe',61),(630,'San JosÃ© del Alto',61),(631,'Santa Rosa',61),(632,'San Ignacio',62),(633,'Chirinos',62),(634,'Huarango',62),(635,'La Coipa',62),(636,'Namballe',62),(637,'San JosÃ© de Lourdes',62),(638,'Tabaconas',62),(639,'Pedro GÃ¡lvez',63),(640,'Eduardo Villanueva',63),(641,'Gregorio Pita',63),(642,'IchocÃ¡',63),(643,'Jose Manuel Quiroz',63),(644,'JosÃ© Sabogal',63),(645,'Chancay',63),(646,'San Miguel',64),(647,'BolÃ­var',64),(648,'Calquis',64),(649,'Catilluc',64),(650,'El Prado',64),(651,'La Florida',64),(652,'Llapa',64),(653,'Nanchoc',64),(654,'Niepos',64),(655,'San Gregorio',64),(656,'San Silvestre de ConchÃ¡',64),(657,'Tongod',64),(658,'UniÃ³n Agua Blanca',64),(659,'San Pablo',65),(660,'San Bernardino',65),(661,'San Luis',65),(662,'Tumbade',65),(663,'Santa Cruz',66),(664,'Andabamba',66),(665,'Catache',66),(666,'ChancaybaÃ±os',66),(667,'La Esperanza',66),(668,'Ninabamba',66),(669,'PulÃ¡',66),(670,'Saucepampa',66),(671,'Sexi',66),(672,'Uticyacu',66),(673,'Yauyuca',66),(674,'Udima',66),(675,'Acomayo',67),(676,'Acopia',67),(677,'Acos',67),(678,'Mosoc Llacta',67),(679,'Pomacanchi',67),(680,'Rondoca',67),(681,'SangararÃ¡',67),(682,'Anta',68),(683,'Ancahuasi',68),(684,'Cachimayo',68),(685,'Chinchaypujio',68),(686,'Huarocondo',68),(687,'Limatambo',68),(688,'Mollepata',68),(689,'Pucyura',68),(690,'Zurite',68),(691,'Calca',69),(692,'Coya',69),(693,'Lamay',69),(694,'Lares',69),(695,'Pisac',69),(696,'San Salvador',69),(697,'Taray',69),(698,'Yanatile',69),(699,'Yanaoca',70),(700,'Checca',70),(701,'Kunturkanki',70),(702,'Langui',70),(703,'Layo',70),(704,'Pampamarca',70),(705,'Quehue',70),(706,'TÃºpac Amaru',70),(707,'Sicuani',71),(708,'Checacupe',71),(709,'Combapata',71),(710,'Marangani',71),(711,'Pitumarca',71),(712,'San Pablo',71),(713,'San Pedro',71),(714,'Tinta',71),(715,'Cuzco',72),(716,'Ccorca',72),(717,'Poroy',72),(718,'San JerÃ³nimo',72),(719,'San SebastiÃ¡',72),(720,'Santiago',72),(721,'Saylla',72),(722,'Wanchaq',72),(723,'Santo TomÃ¡s',73),(724,'Capacmarca',73),(725,'Chamaca',73),(726,'Colquemarca',73),(727,'Livitaca',73),(728,'Llusco',73),(729,'QuiÃ±ota',73),(730,'Velille',73),(731,'Yauri',74),(732,'Condoroma',74),(733,'Coporaque',74),(734,'Ocoruro',74),(735,'Pallpata',74),(736,'Pichigua',74),(737,'Suykutambo',74),(738,'Alto Pichigua',74),(739,'Santa Ana',75),(740,'Echarate',75),(741,'Huayopata',75),(742,'Kimbiri',75),(743,'Maranura',75),(744,'Ocobamba',75),(745,'Pichari',75),(746,'QuelloÃºno',75),(747,'Santa Teresa',75),(748,'Vilcabamba',75),(749,'Paruro',76),(750,'Accha',76),(751,'Ccapi',76),(752,'Colcha',76),(753,'Huanoquite',76),(754,'Omacha',76),(755,'Paccaritambo',76),(756,'Pillpinto',76),(757,'Yaurisque',76),(758,'Paucartambo',77),(759,'Caicay',77),(760,'Challabamba',77),(761,'Colquepata',77),(762,'Huancarani',77),(763,'KosÃ±ipata',77),(764,'Andahuaylillas',78),(765,'Camanti',78),(766,'Ccarhuayo',78),(767,'Ccatca',78),(768,'Cusipata',78),(769,'Huaro',78),(770,'Lucre',78),(771,'Marcapata',78),(772,'Ocongate',78),(773,'Oropesa',78),(774,'Quiquijana',78),(775,'Urcos',78),(776,'Urubamba',79),(777,'Chinchero',79),(778,'Huayllabamba',79),(779,'Machupicchu',79),(780,'Maras',79),(781,'Ollantaytambo',79),(782,'Yucay',79),(783,'Acobamba',80),(784,'Andabamba',80),(785,'Anta',80),(786,'Caja',80),(787,'Marcas',80),(788,'PaucarÃ¡',80),(789,'Pomacocha',80),(790,'Rosario',80),(791,'Lircay',81),(792,'Anchonga',81),(793,'Callanmarca',81),(794,'Ccochaccasa',81),(795,'Chincho',81),(796,'Congalla',81),(797,'Huanca-Huanca',81),(798,'Huayllay Grande',81),(799,'Julcamarca',81),(800,'San Antonio de Antaparco',81),(801,'Santo TomÃ¡s de Pata',81),(802,'Seclla',81),(803,'Castrovirreyna',82),(804,'Arma',82),(805,'AurahuÃ¡',82),(806,'Capillas',82),(807,'Chupamarca',82),(808,'Cocas',82),(809,'Huachos',82),(810,'Huamatambo',82),(811,'Mollepampa',82),(812,'San Jua',82),(813,'Santa Ana',82),(814,'Tantara',82),(815,'Ticrapo',82),(816,'Churcampa',83),(817,'Anco',83),(818,'Chinchihuasi',83),(819,'Cosme1',83),(820,'El Carme',83),(821,'La Merced',83),(822,'Locroja',83),(823,'Pachamarca',83),(824,'Paucarbamba',83),(825,'San Miguel de Mayocc',83),(826,'San Pedro de Coris',83),(827,'Acobambilla',84),(828,'Acoria',84),(829,'AscenciÃ³',84),(830,'Conayca',84),(831,'Cuenca',84),(832,'Huachocolpa',84),(833,'Huando',84),(834,'Huancavelica',84),(835,'Huayllahuara',84),(836,'Izcuchaca',84),(837,'Laria',84),(838,'Manta',84),(839,'Mariscal CÃ¡ceres',84),(840,'Moya',84),(841,'Nuevo Occoro',84),(842,'Palca',84),(843,'Pilchaca',84),(844,'Vilca',84),(845,'Yauli',84),(846,'HuaytarÃ¡',85),(847,'AyavÃ­',85),(848,'CÃ³rdova',85),(849,'Huayacundo Arma',85),(850,'Laramarca',85),(851,'Ocoyo',85),(852,'Pilpichaca',85),(853,'Querco',85),(854,'Quito-Arma',85),(855,'San Antonio de Cusicancha',85),(856,'San Francisco de Sangayaico',85),(857,'San Isidro',85),(858,'Santiago de Chocorvos',85),(859,'Santiago de Quirahuara',85),(860,'Santo Domingo de Capillas',85),(861,'Tambo',85),(862,'Pampas',86),(863,'Acostambo',86),(864,'AcraquÃ­a',86),(865,'Ahuaycha',86),(866,'Colcabamba',86),(867,'Daniel HernÃ¡ndez',86),(868,'Huachocolpa',86),(869,'Huaribamba',86),(870,'Ã‘ahuimpuquio',86),(871,'Pazos',86),(872,'Quishuar',86),(873,'Salcabamba',86),(874,'Salcahuasi',86),(875,'San Marcos de Rocchac',86),(876,'Surcubamba',86),(877,'Tintay Puncu',86),(878,'Ambo',87),(879,'Cayna',87),(880,'Colpas',87),(881,'Conchamarca',87),(882,'Huacar',87),(883,'San Francisco',87),(884,'San Rafael',87),(885,'Tomay Kichwa',87),(886,'La UniÃ³',88),(887,'Chuquis',88),(888,'MarÃ­as',88),(889,'Pachas',88),(890,'Quivilla',88),(891,'RipÃ¡',88),(892,'Shunqui',88),(893,'Sillapata',88),(894,'Yanas',88),(895,'Huacaybamba',89),(896,'Canchabamba',89),(897,'Cochabamba',89),(898,'Pinra',89),(899,'Llata',90),(900,'Arancay',90),(901,'ChavÃ­n de Pariarca',90),(902,'Jacas Grande',90),(903,'Jirca',90),(904,'Miraflores',90),(905,'MonzÃ³',90),(906,'Punchao',90),(907,'PuÃ±os',90),(908,'Singa',90),(909,'Tantamayo',90),(910,'Huanuquito',90),(911,'HuÃ¡nuco',91),(912,'Amarilis',91),(913,'Chinchao',91),(914,'Churumbamba',91),(915,'Margos',91),(916,'Pillco Marca',91),(917,'Quisqui (Kichki)',91),(918,'San Francisco de CayrÃ¡',91),(919,'San Pedro de ChaulÃ¡',91),(920,'Santa MarÃ­a del Valle',91),(921,'Yarumayo',91),(922,'Yacus',91),(923,'Rupa-Rupa',92),(924,'Daniel AlomÃ­a Robles',92),(925,'Hermilio ValdizÃ¡',92),(926,'JosÃ© Crespo y Castillo',92),(927,'Luyando',92),(928,'Mariano DÃ¡maso BeraÃº',92),(929,'Huacrachuco',93),(930,'CholÃ³',93),(931,'San Buenaventura',93),(932,'Panao',94),(933,'Chaglla',94),(934,'Molino',94),(935,'Umari',94),(936,'Puerto Inca',95),(937,'Codo del Pozuzo',95),(938,'Honoria',95),(939,'Tournavista',95),(940,'Yuyapichis',95),(941,'Chavinillo',96),(942,'Cahuac',96),(943,'Chacabamba',96),(944,'Aparicio Pomares',96),(945,'Jacas Chico',96),(946,'Obas',96),(947,'Pampamarca',96),(948,'Choras',96),(949,'BaÃ±os',97),(950,'JesÃºs',97),(951,'Jivia',97),(952,'Queropalca',97),(953,'Rondos',97),(954,'San Francisco de AsÃ­s',97),(955,'San Miguel de Cauri',97),(956,'Lichkacachka',97),(957,'Chincha Alta',98),(958,'Alto LarÃ¡',98),(959,'ChavÃ­',98),(960,'Chincha Baja',98),(961,'El Carme',98),(962,'Grocio Prado',98),(963,'Pueblo Nuevo',98),(964,'San Juan de Yanac',98),(965,'San Pedro de Huacarpana',98),(966,'Sunampe',98),(967,'Tambo de Mora',98),(968,'Ica',99),(969,'La TinguiÃ±a',99),(970,'Los Aquijes',99),(971,'Ocucaje',99),(972,'Pachacutec',99),(973,'Parcona',99),(974,'Pueblo Nuevo',99),(975,'Salas',99),(976,'San JosÃ© de los Molinos',99),(977,'San Juan Bautista',99),(978,'Santiago',99),(979,'Subtanjalla',99),(980,'Tate',99),(981,'Yauca del Rosario',99),(982,'Nazca',100),(983,'Changuillo',100),(984,'El Ingenio',100),(985,'Marcona',100),(986,'Vista Alegre',100),(987,'Palpa',101),(988,'Llipata',101),(989,'RÃ­o Grande',101),(990,'Santa Cruz',101),(991,'Tibillo',101),(992,'Pisco',102),(993,'Huancano',102),(994,'Humay',102),(995,'Independencia',102),(996,'Paracas',102),(997,'San AndrÃ©s',102),(998,'San Clemente',102),(999,'TÃºpac Amaru Inca',102),(1000,'ConcepciÃ³',103),(1001,'Aco',103),(1002,'Andamarca',103),(1003,'Chambara',103),(1004,'Cochas',103),(1005,'Comas',103),(1006,'HeroÃ­nas Toledo',103),(1007,'Manzanares',103),(1008,'Mariscal Castilla',103),(1009,'Matahuasi',103),(1010,'Mito',103),(1011,'Nueve de Julio',103),(1012,'Orcotuna',103),(1013,'San JosÃ© de Quero',103),(1014,'Santa Rosa de Ocopa',103),(1015,'Chanchamayo',104),(1016,'San Luis de Shuaro',104),(1017,'PerenÃ©',104),(1018,'Pichanaqui',104),(1019,'San RamÃ³',104),(1020,'Vitoc',104),(1021,'Chupaca',105),(1022,'Ahuac',105),(1023,'Chongos Bajo',105),(1024,'Huachac',105),(1025,'Huamancaca Chico',105),(1026,'San Juan de Yscos',105),(1027,'San Juan de Jarpa',105),(1028,'Tres de Diciembre',105),(1029,'Yanacancha',105),(1030,'Huancayo',106),(1031,'Carhuacallanga',106),(1032,'Chacapampa',106),(1033,'Chicche',106),(1034,'Chilca',106),(1035,'Chongos Alto',106),(1036,'Chupuro',106),(1037,'Colca',106),(1038,'Cullhuas',106),(1039,'El Tambo',106),(1040,'Huacrapuquio',106),(1041,'Hualhuas',106),(1042,'HuancÃ¡',106),(1043,'Huasicancha',106),(1044,'Huayucachi',106),(1045,'Ingenio',106),(1046,'Pariahuanca',106),(1047,'Pilcomayo',106),(1048,'PucarÃ¡',106),(1049,'Qhichuay',106),(1050,'Quilcas',106),(1051,'San AgustÃ­n de Cajas',106),(1052,'San JerÃ³nimo de TunÃ¡',106),(1053,'San Pedro de SaÃ±o',106),(1054,'Santo Domingo de Acobamba',106),(1055,'Sapallanga',106),(1056,'Sicaya',106),(1057,'Viques',106),(1058,'Jauja',107),(1059,'Acolla',107),(1060,'Apata',107),(1061,'Ataura',107),(1062,'Canchayllo',107),(1063,'Curicaca',107),(1064,'El Mantaro',107),(1065,'HuamalÃ­',107),(1066,'Huaripampa',107),(1067,'Huertas',107),(1068,'Janjaillo',107),(1069,'JulcÃ¡',107),(1070,'Leonor OrdÃ³Ã±ez',107),(1071,'Llocllapampa',107),(1072,'Marco',107),(1073,'Masma',107),(1074,'Masma Chicche',107),(1075,'Molinos',107),(1076,'Monobamba',107),(1077,'Muqui',107),(1078,'Muquiyauyo',107),(1079,'Paca',107),(1080,'Paccha',107),(1081,'PancÃ¡',107),(1082,'Parco',107),(1083,'Pomacancha',107),(1084,'RicrÃ¡',107),(1085,'San Lorenzo',107),(1086,'San Pedro de ChunÃ¡',107),(1087,'Sausa',107),(1088,'Sincos',107),(1089,'Tunan Marca',107),(1090,'Yauli',107),(1091,'Yauyos',107),(1092,'JunÃ­',108),(1093,'Carhuamayo',108),(1094,'Ondores',108),(1095,'Ulcumayo',108),(1096,'Satipo',109),(1097,'Coviriali',109),(1098,'Llaylla',109),(1099,'Mazamari',109),(1100,'Pampa Hermosa',109),(1101,'Pangoa',109),(1102,'RÃ­o Negro',109),(1103,'RÃ­o Tambo',109),(1104,'Tarma',110),(1105,'Acobamba',110),(1106,'Huaricolca',110),(1107,'Huasahuasi',110),(1108,'La UniÃ³',110),(1109,'Palca',110),(1110,'Palcamayo',110),(1111,'San Pedro de Cajas',110),(1112,'Tapo',110),(1113,'La Oroya',111),(1114,'Cacapalpa',111),(1115,'Huay-Huay',111),(1116,'Marcapomacocha',111),(1117,'Morococha',111),(1118,'Paccha',111),(1119,'Santa Barbara de CarhuacayÃ¡',111),(1120,'Santa Rosa de Sacco',111),(1121,'Suitucancha',111),(1122,'Yauli',111),(1123,'Ascope',112),(1124,'Chicama',112),(1125,'Chocope',112),(1126,'Magdalena de Cao',112),(1127,'PaijÃ¡',112),(1128,'RÃ¡zuri',112),(1129,'Santiago de Cao',112),(1130,'Casa Grande',112),(1131,'BolÃ­var',113),(1132,'Bambamarca',113),(1133,'Condormarca',113),(1134,'Longotea',113),(1135,'Uchumarca',113),(1136,'Ucuncha',113),(1137,'ChepÃ©',114),(1138,'Pacanga',114),(1139,'Pueblo Nuevo',114),(1140,'Cascas',115),(1141,'Lucma',115),(1142,'Marmot',115),(1143,'Sayapullo',115),(1144,'JulcÃ¡',116),(1145,'Calamarca',116),(1146,'Carabamba',116),(1147,'Huaso',116),(1148,'Otuzco',117),(1149,'Agallpampa',117),(1150,'Charat',117),(1151,'Huaranchal',117),(1152,'La Cuesta',117),(1153,'Mache',117),(1154,'Paranday',117),(1155,'Salpo',117),(1156,'Sinsicap',117),(1157,'Usquil',117),(1158,'San Pedro de Lloc',118),(1159,'Guadalupe',118),(1160,'Jequetepeque',118),(1161,'Pacasmayo',118),(1162,'San JosÃ©',118),(1163,'Tayabamba',119),(1164,'Buldibuyo',119),(1165,'Chillia',119),(1166,'Huancaspata',119),(1167,'Huaylillas',119),(1168,'Huayo',119),(1169,'OngÃ³',119),(1170,'Parcoy',119),(1171,'PatÃ¡z',119),(1172,'PÃ­as',119),(1173,'Challas',119),(1174,'Taurija',119),(1175,'Urpay',119),(1176,'Huamachuco',120),(1177,'Chugay',120),(1178,'Cochorco',120),(1179,'Curgos',120),(1180,'Marcabal',120),(1181,'SanagorÃ¡',120),(1182,'SarÃ­',120),(1183,'Sartimbamba',120),(1184,'Santiago de Chuco',121),(1185,'Angasmarca',121),(1186,'CachicadÃ¡',121),(1187,'Mollebamba',121),(1188,'Mollepata',121),(1189,'Quiruvilca',121),(1190,'Santa Cruz de Chuca',121),(1191,'Sitabamba',121),(1192,'Trujillo',122),(1193,'El Porvenir',122),(1194,'Florencia de Mora',122),(1195,'Huanchaco',122),(1196,'La Esperanza',122),(1197,'Laredo',122),(1198,'Moche',122),(1199,'Poroto',122),(1200,'Salaverry',122),(1201,'Simbal',122),(1202,'Victor Larco',122),(1203,'VirÃº',123),(1204,'Chao',123),(1205,'Guadalupito',123),(1206,'Chiclayo',124),(1207,'Cayalti',124),(1208,'Chongoyape',124),(1209,'EtÃ©',124),(1210,'Puerto EtÃ©',124),(1211,'JosÃ© Leonardo Ortiz',124),(1212,'La Victoria',124),(1213,'Lagunas',124),(1214,'Monsefu',124),(1215,'Nueva Arica',124),(1216,'OyotÃº',124),(1217,'Patapo',124),(1218,'Picsi',124),(1219,'Pimentel',124),(1220,'Pomalca',124),(1221,'PucalÃ¡',124),(1222,'Reque',124),(1223,'Santa Rosa',124),(1224,'TumÃ¡',124),(1225,'SaÃ±a',124),(1226,'FerreÃ±afe',125),(1227,'CaÃ±aris',125),(1228,'Incahuasi',125),(1229,'Manuel Antonio Mesones Muro',125),(1230,'PÃ­tipo',125),(1231,'Pueblo Nuevo',125),(1232,'Lambayeque',126),(1233,'ChÃ³chope',126),(1234,'Ãllimo',126),(1235,'Jayanca',126),(1236,'MochumÃ­',126),(1237,'MÃ³rrope',126),(1238,'Motupe',126),(1239,'Olmos',126),(1240,'Pacora',126),(1241,'Salas',126),(1242,'San JosÃ©',126),(1243,'TÃºcume',126),(1244,'Barranca',127),(1245,'Paramonga',127),(1246,'Pativilca',127),(1247,'Supe',127),(1248,'Supe Puerto',127),(1249,'ManÃ¡s',128),(1250,'Gorgor',128),(1251,'HuancapÃ³',128),(1252,'Cajatambo',128),(1253,'Copa',128),(1254,'Canta',129),(1255,'Arahuay',129),(1256,'Huamantanga',129),(1257,'Huaros',129),(1258,'Lachaqui',129),(1259,'San Buenaventura',129),(1260,'Santa Rosa de Quives',129),(1261,'Asia',130),(1262,'Calango',130),(1263,'Cerro Azul',130),(1264,'Chilca',130),(1265,'Coayllo',130),(1266,'Imperial',130),(1267,'LunahuanÃ¡',130),(1268,'Mala',130),(1269,'Nuevo Imperial',130),(1270,'PacarÃ¡',130),(1271,'QuilmanÃ¡',130),(1272,'San Antonio',130),(1273,'San Luis',130),(1274,'San Vicente de CaÃ±ete',130),(1275,'Santa Cruz de Flores',130),(1276,'ZÃºÃ±iga',130),(1277,'27 de noviembre',131),(1278,'Atavillos Alto',131),(1279,'Atavillos Bajo',131),(1280,'Aucallama',131),(1281,'Chancay',131),(1282,'Huaral',131),(1283,'IhuarÃ­',131),(1284,'LampÃ­a',131),(1285,'Pacaraos',131),(1286,'Santa Cruz de Andamarca',131),(1287,'Sumbilca',131),(1288,'San Miguel de Acos',131),(1289,'Matucana',132),(1290,'AntioquÃ­a',132),(1291,'Callahuanca',132),(1292,'Carampoma',132),(1293,'Chicla',132),(1294,'Cuenca',132),(1295,'Huachupampa',132),(1296,'Huanza',132),(1297,'HuarochirÃ­',132),(1298,'Lahuaytambo',132),(1299,'Langa',132),(1300,'Laraos',132),(1301,'Mariatana',132),(1302,'Ricardo Palma',132),(1303,'San AndrÃ©s de Tupicocha',132),(1304,'San Antonio de Chaclla',132),(1305,'San BartolomÃ©',132),(1306,'San DamiÃ¡',132),(1307,'San Juan de Iris',132),(1308,'San Juan de Tantaranche',132),(1309,'San Lorenzo de Quinti',132),(1310,'San Mateo',132),(1311,'San Mateo de Otao',132),(1312,'San Pedro de Casta',132),(1313,'San Pedro de Huancayre',132),(1314,'Sangallaya',132),(1315,'Santa Cruz de Cocachacra',132),(1316,'Santa Eulalia',132),(1317,'Santiago de Anchucaya',132),(1318,'Santiago de Tuna',132),(1319,'Santo Domingo de los Olleros',132),(1320,'San JerÃ³nimo de Surco',132),(1321,'Huacho',133),(1322,'Ãmbar',133),(1323,'Caleta de CarquÃ­',133),(1324,'Checras',133),(1325,'Hualmay',133),(1326,'Huaura',133),(1327,'Leoncio Prado',133),(1328,'Paccho',133),(1329,'Santa Leonor',133),(1330,'Santa MarÃ­a',133),(1331,'SayÃ¡',133),(1332,'Vegueta',133),(1333,'Lima',134),(1334,'AncÃ³',134),(1335,'Ate',134),(1336,'Barranco',134),(1337,'BreÃ±a',134),(1338,'Carabayllo',134),(1339,'Chaclacayo',134),(1340,'Chorrillos',134),(1341,'Cieneguilla',134),(1342,'Comas',134),(1343,'El Agustino',134),(1344,'Independencia',134),(1345,'JesÃºs MarÃ­a',134),(1346,'La Molina',134),(1347,'La Victoria',134),(1348,'Lince',134),(1349,'Los Olivos',134),(1350,'Lurigancho-Chosica',134),(1351,'Luri',134),(1352,'Magdalena del Mar',134),(1353,'Pueblo Libre',134),(1354,'Miraflores',134),(1355,'PachacÃ¡mac',134),(1356,'Pucusana',134),(1357,'Puente Piedra',134),(1358,'Punta Hermosa',134),(1359,'Punta Negra',134),(1360,'RÃ­mac',134),(1361,'San Bartolo',134),(1362,'San Borja',134),(1363,'San Isidro',134),(1364,'San Juan de Lurigancho',134),(1365,'San Juan de Mirafloresv',134),(1366,'San Luis',134),(1367,'San MartÃ­n de Porres',134),(1368,'San Miguel',134),(1369,'Santa Anita',134),(1370,'Santa MarÃ­a del Mar',134),(1371,'Santa Rosa',134),(1372,'Santiago de Surco',134),(1373,'Surquillo',134),(1374,'Villa El Salvador',134),(1375,'Villa MarÃ­a del Triunfo',134),(1376,'OyÃ³',135),(1377,'Andajes',135),(1378,'Caujul',135),(1379,'Cochamarca',135),(1380,'NavÃ¡',135),(1381,'Pachangara',135),(1382,'Yauyos',136),(1383,'Alis',136),(1384,'Ayauca',136),(1385,'Ayaviri',136),(1386,'AzÃ¡ngaro',136),(1387,'Cacra',136),(1388,'Carania',136),(1389,'Catahuasi',136),(1390,'Chocos',136),(1391,'Cochas',136),(1392,'Colonia',136),(1393,'Hongos',136),(1394,'Huampara',136),(1395,'Huancaya',136),(1396,'HuangÃ¡scar',136),(1397,'HuantÃ¡',136),(1398,'HuaÃ±ec',136),(1399,'Laraos',136),(1400,'Lincha',136),(1401,'Madea',136),(1402,'Miraflores',136),(1403,'Omas',136),(1404,'San Lorenzo de Putinza',136),(1405,'Quinches',136),(1406,'Quinocay',136),(1407,'San JoaquÃ­',136),(1408,'San Pedro de Pilas',136),(1409,'Tanta',136),(1410,'Tauripampa',136),(1411,'Tomas',136),(1412,'Tupe',136),(1413,'ViÃ±ac',136),(1414,'Vitis',136),(1415,'Prov. Const. Callao',137),(1416,'Yurimaguas',138),(1417,'Balsapuerto',138),(1418,'Jeberos',138),(1419,'Lagunas',138),(1420,'Santa Cruz',138),(1421,'Teniente CÃ©sar LÃ³pez Rojas',138),(1422,'Nauta',139),(1423,'Parinari',139),(1424,'Tigre',139),(1425,'Trompeteros',139),(1426,'Urarinas',139),(1427,'RamÃ³n Castilla',140),(1428,'Pebas',140),(1429,'Yavari',140),(1430,'San Pablo',140),(1431,'Iquitos',141),(1432,'Alto Nanay',141),(1433,'Fernando Lores',141),(1434,'Indiana',141),(1435,'Las Amazonas',141),(1436,'MazÃ¡',141),(1437,'Napo',141),(1438,'Punchana',141),(1439,'Putumayo',141),(1440,'Torres Causana',141),(1441,'Bele',141),(1442,'San Juan Bautista',141),(1443,'Teniente Manuel Clavero',141),(1444,'Requena',142),(1445,'Alto Tapiche',142),(1446,'Capelo',142),(1447,'Emilio San MartÃ­',142),(1448,'MaquÃ­a',142),(1449,'Puinahua',142),(1450,'Saquena',142),(1451,'Sopli',142),(1452,'Tapiche',142),(1453,'Jenaro Herrera',142),(1454,'Yaquerana',142),(1455,'Contamana',143),(1456,'Inahuaya',143),(1457,'Padre MÃ¡rquez',143),(1458,'Pampa Hermosa',143),(1459,'Sarayacu',143),(1460,'Alfredo Vargas Guerra',143),(1461,'Yanayacu',143),(1462,'Manu',144),(1463,'Fitzcarrald',144),(1464,'Madre de Dios',144),(1465,'Huepetuhe',144),(1466,'IÃ±apari',145),(1467,'Iberia',145),(1468,'Tahuamanu',145),(1469,'Tambopata',146),(1470,'Inambari',146),(1471,'Las Piedras',146),(1472,'Laberinto',146),(1473,'Ilo',147),(1474,'El Algarrobal',147),(1475,'Pacocha',147),(1476,'Moquegua',148),(1477,'Carumas',148),(1478,'Cuchumbaya',148),(1479,'Samegua',148),(1480,'San Cristobal de Calacoa',148),(1481,'Torata',148),(1482,'Omate',149),(1483,'Chojata',149),(1484,'Coalaque',149),(1485,'IchuÃ±a',149),(1486,'La Capilla',149),(1487,'Lloque',149),(1488,'Matalaque',149),(1489,'Puquina',149),(1490,'Quinistaquillas',149),(1491,'Ubinas',149),(1492,'Yunga',149),(1493,'Yanahuanca',150),(1494,'ChacayÃ¡',150),(1495,'Goyllarisquizga',150),(1496,'Paucar',150),(1497,'San Pedro de Pillao',150),(1498,'Santa Ana de Tusi',150),(1499,'Tapuc',150),(1500,'Vilcabamba',150),(1501,'Oxapampa',151),(1502,'Chontabamba',151),(1503,'Huancabamba',151),(1504,'PalcazÃº',151),(1505,'Pozuzo',151),(1506,'Puerto BermÃºdez',151),(1507,'Villa Rica',151),(1508,'Ciudad ConstituciÃ³',151),(1509,'Chaupimarca',152),(1510,'HuachÃ³',152),(1511,'Huariaca',152),(1512,'Huayllay',152),(1513,'Ninacaca',152),(1514,'Pallanchacra',152),(1515,'Paucartambo',152),(1516,'San Francisco de AsÃ­s de YarusyacÃ¡',152),(1517,'SimÃ³n BolÃ­var',152),(1518,'TiclacayÃ¡',152),(1519,'Tinyahuarco',152),(1520,'Vicco',152),(1521,'Yanacancha',152),(1522,'Ayabaca',153),(1523,'FrÃ­as',153),(1524,'JililÃ­',153),(1525,'Lagunas',153),(1526,'Montero',153),(1527,'Pacaipampa',153),(1528,'Paimas',153),(1529,'Sapillica',153),(1530,'Sicchez',153),(1531,'Suyo',153),(1532,'Huancabamba',154),(1533,'Canchaque',154),(1534,'El Carmen de la Frontera',154),(1535,'Huarmaca',154),(1536,'Lalaquiz',154),(1537,'San Miguel de El Faique',154),(1538,'Sondor',154),(1539,'Sondorillo',154),(1540,'Chulucanas',155),(1541,'Buenos Aires',155),(1542,'Chalaco',155),(1543,'La Matanza',155),(1544,'MorropÃ³',155),(1545,'Salitral',155),(1546,'San Juan de Bigote',155),(1547,'Santa Catalina de Mossa',155),(1548,'Santo Domingo',155),(1549,'Yamango',155),(1550,'Paita',156),(1551,'Amotape',156),(1552,'ColÃ¡',156),(1553,'El Arenal',156),(1554,'La Huaca',156),(1555,'Tamarindo',156),(1556,'Vichayal',156),(1557,'Piura',157),(1558,'Castilla',157),(1559,'Catacaos',157),(1560,'Cura Mori',157),(1561,'El TallÃ¡',157),(1562,'La Arena',157),(1563,'La UniÃ³',157),(1564,'Las Lomas',157),(1565,'Tambo Grande',157),(1566,'Sechura',158),(1567,'Bellavista de la UniÃ³',158),(1568,'Bernal',158),(1569,'Cristo nos Valga',158),(1570,'Rinconada Llicuar',158),(1571,'Vice',158),(1572,'Sullana',159),(1573,'Bellavista',159),(1574,'Ignacio Escudero',159),(1575,'Lancones',159),(1576,'Marcavelica',159),(1577,'Miguel Checa',159),(1578,'Querecotillo',159),(1579,'Salitral',159),(1580,'PariÃ±as',160),(1581,'El Alto',160),(1582,'La Brea',160),(1583,'Lobitos',160),(1584,'Los Ã“rganos',160),(1585,'MÃ¡ncora',160),(1586,'AzÃ¡ngaro',161),(1587,'Achaya',161),(1588,'Arapa',161),(1589,'Asillo',161),(1590,'Caminaca',161),(1591,'Chupa',161),(1592,'JosÃ© Domingo Choquehuanca',161),(1593,'MuÃ±ani',161),(1594,'Potoni',161),(1595,'SamÃ¡',161),(1596,'San AntÃ³',161),(1597,'San JosÃ©',161),(1598,'San Juan de Salinas',161),(1599,'Santiago de Pupuja',161),(1600,'Tirapata',161),(1601,'Ajoyani',162),(1602,'Ayapata',162),(1603,'Coasa',162),(1604,'Corani',162),(1605,'Crucero',162),(1606,'Ituata',162),(1607,'Macusani',162),(1608,'Ollachea',162),(1609,'San GabÃ¡',162),(1610,'Usicayos',162),(1611,'Desaguadero',163),(1612,'Huacullani',163),(1613,'Juli',163),(1614,'Kelluyo',163),(1615,'Pisacoma',163),(1616,'Pomata',163),(1617,'Zepita',163),(1618,'Capazo',164),(1619,'Conduriri',164),(1620,'Ilave',164),(1621,'Pilcuyo',164),(1622,'Santa Rosa',164),(1623,'Cojata',165),(1624,'HuancanÃ©',165),(1625,'Huatasani',165),(1626,'Inchupalla',165),(1627,'Pusi',165),(1628,'Rosaspata',165),(1629,'Taraco',165),(1630,'Vilque Chico',165),(1631,'Cabanilla',166),(1632,'Calapuja',166),(1633,'Lampa',166),(1634,'Nicasio',166),(1635,'Ocuviri',166),(1636,'Palca',166),(1637,'Paratia',166),(1638,'PucarÃ¡',166),(1639,'Santa LucÃ­a',166),(1640,'Vilavila',166),(1641,'Antauta',167),(1642,'Ayaviri',167),(1643,'Cupi',167),(1644,'Llalli',167),(1645,'Macari',167),(1646,'Ã‘uÃ±oa',167),(1647,'Orurillo',167),(1648,'Santa Rosa',167),(1649,'Umachiri',167),(1650,'Conina',168),(1651,'Huayrapata',168),(1652,'Moho',168),(1653,'Tilali',168),(1654,'Ananea',169),(1655,'Pedro Vilca Apaza',169),(1656,'Putina',169),(1657,'Quilcapuncu',169),(1658,'Sina',169),(1659,'Cabana',170),(1660,'Cabanillas',170),(1661,'Caracoto',170),(1662,'Juliaca',170),(1663,'Massiapo',171),(1664,'Cuyocuyo',171),(1665,'Limbani',171),(1666,'Patambuco',171),(1667,'Quiaca',171),(1668,'San Juan del Oro',171),(1669,'San Pedro de Putina Punco',171),(1670,'Sandia',171),(1671,'Yanahuaya',171),(1672,'Phara',171),(1673,'Ãcora',172),(1674,'AmantanÃ­',172),(1675,'Atuncolla',172),(1676,'Capachica',172),(1677,'Chucuito',172),(1678,'Coata',172),(1679,'Huata',172),(1680,'MaÃ±azo',172),(1681,'Paucarcolla',172),(1682,'Pichacani',172),(1683,'PlaterÃ­a',172),(1684,'Puno',172),(1685,'San Antonio',172),(1686,'Tiquillaca',172),(1687,'Vilque',172),(1688,'Yunguyo',173),(1689,'Anapia',173),(1690,'Copani',173),(1691,'Cuturapi',173),(1692,'Ollaraya',173),(1693,'Tinicachi',173),(1694,'Unicachi',173),(1695,'Bellavista',174),(1696,'Alto Biavo',174),(1697,'Bajo Biavo',174),(1698,'Huallaga',174),(1699,'San Pablo',174),(1700,'San Rafael',174),(1701,'San JosÃ© de Sisa',175),(1702,'Agua Blanca',175),(1703,'San MartÃ­',175),(1704,'Santa Rosa',175),(1705,'Shantoja',175),(1706,'Saposoa',176),(1707,'Alto Saposoa',176),(1708,'El EslabÃ³',176),(1709,'Piscoyacu',176),(1710,'Sacanche',176),(1711,'Tingo de Saposoa',176),(1712,'Lamas',177),(1713,'Alonso de Alvarado',177),(1714,'Barranquita',177),(1715,'Caynarachi',177),(1716,'CuÃ±umbuqui',177),(1717,'Pinto Recodo',177),(1718,'Rumisapa',177),(1719,'San Roque de Cumbaza',177),(1720,'Shanao',177),(1721,'Tabalosos',177),(1722,'Zapatero',177),(1723,'JuanjuÃ­',178),(1724,'Campanilla',178),(1725,'Huicungo',178),(1726,'Pachiza',178),(1727,'Pajarillo',178),(1728,'Juanjuicillo',178),(1729,'Moyobamba',179),(1730,'Calzada',179),(1731,'Habana',179),(1732,'Jepelacio',179),(1733,'Soritor',179),(1734,'Yantalo',179),(1735,'Picota',180),(1736,'Buenos Aires',180),(1737,'Caspisapa',180),(1738,'Pilluana',180),(1739,'Pucacaca',180),(1740,'San CristÃ³bal',180),(1741,'San HilariÃ³',180),(1742,'Shamboyacu',180),(1743,'Leoncio Prado',180),(1744,'Tingo de Ponazav',180),(1745,'Tres Unidos',180),(1746,'Rioja',181),(1747,'AwajÃº',181),(1748,'ElÃ­as SoplÃ­n Vargas',181),(1749,'Nueva Cajamarca',181),(1750,'Pardo Miguel',181),(1751,'Posic',181),(1752,'San Fernando',181),(1753,'Yorongos',181),(1754,'Yuracyacu',181),(1755,'Tarapoto',182),(1756,'Alberto Leveau',182),(1757,'Cacatachi',182),(1758,'Chazuta',182),(1759,'Chipurana',182),(1760,'El Porvenir',182),(1761,'Huimbayoc',182),(1762,'Juan Guerra',182),(1763,'La Banda de Shilcayo',182),(1764,'Morales',182),(1765,'Papaplaya',182),(1766,'San Antonio',182),(1767,'Sauce',182),(1768,'Shapaja',182),(1769,'Tocache',183),(1770,'Nuevo Progreso',183),(1771,'PÃ³lvora',183),(1772,'Shunte',183),(1773,'Uchiza',183),(1774,'Candarave',184),(1775,'Cairani',184),(1776,'Camilaca',184),(1777,'Curibaya',184),(1778,'Huanuara',184),(1779,'Quilahuani',184),(1780,'Ilabaya',185),(1781,'Ite',185),(1782,'Locumba',185),(1783,'Tacna',186),(1784,'Alto de la Alianza',186),(1785,'Calana',186),(1786,'Ciudad Nueva',186),(1787,'Coronel Gregorio AlbarracÃ­n Lanchipa',186),(1788,'InclÃ¡',186),(1789,'PachÃ­a',186),(1790,'Palca',186),(1791,'Pocollay',186),(1792,'Sama',186),(1793,'Tarata',187),(1794,'Chucatamani',187),(1795,'Estique',187),(1796,'Estique-Pampa',187),(1797,'Sitajara',187),(1798,'Susapaya',187),(1799,'Tarucachi',187),(1800,'Ticaco',187),(1801,'Canoas de Punta Sal',188),(1802,'Casitas',188),(1803,'Zorritos',188),(1804,'Tumbes',189),(1805,'Corrales',189),(1806,'La Cruz',189),(1807,'Pampas de Hospital',189),(1808,'San Jacinto',189),(1809,'San Juan de la Virge',189),(1810,'Zarumilla',190),(1811,'Aguas Verdes',190),(1812,'Matapalo',190),(1813,'Papayal',190),(1814,'Raimondi',191),(1815,'Sepahua',191),(1816,'TahuanÃ­a',191),(1817,'YurÃºa',191),(1818,'CallerÃ­a',192),(1819,'Campoverde',192),(1820,'IparÃ­a',192),(1821,'Manantay',192),(1822,'Masisea',192),(1823,'Yarinacocha',192),(1824,'Nueva Requena',192),(1825,'Padre Abad',193),(1826,'Irazola',193),(1827,'CurimanÃ¡',193),(1828,'PurÃºs',194);
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombreComercial` varchar(150) DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `slogan` varchar(150) DEFAULT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `logo` blob,
  `banner` blob,
  `estado` int(11) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (6,'telo XD','telo XD','telos asa','12123123122',0,'2015-05-19 19:19:32','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0d\0\0\0`\0\0\0ës×B\0\0 \0IDATx^íœ\\u¹÷Óëöl*] TéCD¤X@Q/Šï‹TñÊU®‚¯€ r>®€JRäR®ôiAz‘$$Ùl¶MŸ3gæ~Ÿ³Ùììf[Ê\Zpùë’-3gÎyÿÓ~Oùû$Uøúd}D(àû„!N¬¸OòÑâ‡>	@”2_+oÆµl¹’ıİå¿üÚû*£eMÏ†ºÿìıÎ^^²¿y)¯¼–ï¼W÷¼ÈÇox‘¿\\–àÅv¡òGGk¯W†ø *İÄõü|ı.dä4‚1+®*şŠ\Zë*úT)¦íÊ5jö•t2J8’·pÓè]äû\\Ğ¯Xo+­7‚Y-è¬ˆ·s%?ÿóÉnÀX\\QÂuù¹¢¢1>ÌïŠÆŞõ»Ö/CV<{%Èmx´*TqTËw[5Ôk`B›tå5¥PT¶!¤HÚQÈ)ğÒ2Œˆ)\0¡=‰0iáıö}!\0KYùıQ95MêÌ«5Õûõq-øtÏ’%Z³Óö¾_Æœ›\0fsÖ÷Z¯	úì~ŸÜRI›Eë5#æÓf°6ÊÉ¥U@bÊH}…J>$¡ŒZ²/)\nóz˜ad{R\0m!ªËÿ`—§ÌÚ0‘¿Dø»½Æô´Ô%4¿ìêonN¯fÓê@\n¾°\\×“•õºF!¦‚*¨%ŸéÛÉ¾€‚nD¹ˆ«HÙÑÎ‘zæ‹hr¦¯x¯óA¼B¥¨rÉ€òìBÀÕ@ß{ßÃ³;e^ˆRòÔRÏ»Kğ\"hÌ,—¼=_„…f\"¼¸’àJ^™xF]ı­˜Ö?D·ä Òx?g BM%†TBrÿkÔâm[V\r!ƒyÍ¬Mè”TB¹b§–\'+jÎUT*Gû<³1Òô~˜ÿ\"9¥<»¸ÀOŞm]‚ìxã7{südŸ\rås\\Ş„%åùo	éY¦üâ0;ÇÿBş„>HÆ5Û×®÷ÒHJ%Sì“J0îü“´Ù¨3Äêƒ0¦¡\níS[¯òIùòZ†:çK(^*ªÕÛÁ¶ç»WÙ¤\0±²;QD›†bZææåÄâŠÕÕy‡“Š%G–ÏAÖ|ZjÇ_@­å3*rJ#\Zï‹*Ìg§ùœ ¿W\nıHP\0‰u£eø¾ˆ4ù›ôJ\\úCe™dMıq_®ÃüsÖè0„g¶MÄ2Ò\r•´U4¬S*õjÌæQ9-“¯h»Ï‹Wö¢ü›ëCùUjhPí®Ûkêşû¨iætÕm°¡üMPA>EÍ€À—/Ó+~sgM=\Z3ÍÊ¤S*uv¨uîSZòÜ‹z÷/s•~}’ù,ŸÈëj(}2	Š”pxs h*®¨h0©Gbı)³\\­¦ar·ÿ=:$ëa÷¨\\İÜ{³¦ƒ#ñ€Nò5kzŞUg¹CqÌqÏ\n˜úÂ –¹£hÛÂ›·;ù›šòCÔ°ùr“5¨Œºyb=«Ê^·o;syùã!…±W¾®´æ?>OoÏ¾FÙûÄSó«û`›&Ãçá£ÙÏá!%WKã	ÍËçu§?­ŠÃ}ú°k¶	Fi\nCÂx,ÅhQÛä|ú^|Eœ2\\(¨T¥Ã+ø­Eâ‰ºè8evŞ\\ÇÜz³–M®5M¯‰nX‰1ò zJñHT±gHÒ\n8³SSAïßb\0Ã\rAƒñ¸Ò·İ¤›Oø&e}è¦Õ\\ùŞÕ*JùğÔÌñ,ğAÏ†cº¬k¹œ(Ò•7?otÖ¨0$Hpöåh“¾‚¨]Ë0Ä¸·<`0ˆ\n3fÅr#!5q€öÿí¥*Æj @T\"ó;\nâùX`èºv¼£ .ïšp$™fjÇ¾¸^£“à>º`t\"TjîczàôsTşÇìó<+*«yÈLãâ–µ¤6¢_gz¿˜npÕuÆB\nOMÅpa¿Ò×ºâèİv$ïoÅÜÎXÔ¯¬›RÔI(ü…Ú÷Ê‹T;iJÕÃõ\ZÜQ{âA.lİü;ïÓ+§­òÒùØ“°JbDó9Æ¯Ëî®=áÓlìÈËåÆŞÅsƒYëP`Ö	CºÅÜ§úPHß\ZW«éË²ÜdcèSŒ(9PÊÈ‡Ô8%|•	uğC·¨¼ñ§”H4âWcë“!8¥ŠÚ‹mzÿªëõê/TTÀ«n\ZÊ¤Ì‚Ë¶&‡§6§®¬¿¶ç”7é‡-ëj­†±f~™¬ÓíêHâ1¥xN	M*õA¥CõÑ˜¢‡¢iœ­ñå€:ó@$xY•Ú^ÖÚ­«Ç[ë@ì.¼½ZõFŸílÑS§£â0â<Kµi\ZÀ¼¹œ?¯ÆrL×ÖI´wªk5>f¸—®9CVxR+ÔE:+Ø¤ñù6à‰úÖ\"c,@¤V9$ ¨èğë®Tòs‡\0õ¢“ƒèæ,­\n¸\0,ñû°¹ËæÆw÷«ûw/˜´È\"äáˆâ êeÄ6º\0C¥„Úü-ZøİóõÎu·ãä±q`¯‚\ZA\ZZÂ5”\"ºc¢«9-)Oº<„z-È5¾„9KQrn§.ŠMĞ$»á\"Âëa0‰İöª“ÖÖl¢ƒ¸Uí›J½ˆ¹Ú8ÛÇ÷JˆŸ÷aHˆë8xU¡ş†|uĞïõ%‹äÄAÙ²\"á0wÒµ÷¿´ƒı+„k•Àİ~şæë5ÿ¸ò¬y6_æ°ÙVÄ=öïï£D¯Øéà^¯ÍZc†„¹QĞèœx“6+µ)ZŒyy‡<rİNhqa™ü‰Z}±íeÀÁFôqY‹çÜ¬y\'}¯÷~-zìöú½ğ%UpŠ^„¾Ç9§kÓ¹6Ï¶ê{±k·l¿—Š ¾É|Yù`zĞë•Ğñ^’Sß¨\\!­Ì[/è¡éŸ\'n©U¶¥š!Íå°Nm(é­¶µ¶ïkÌüğš¨m³<DPù\nh;0ÀWÏ#°ã¶:dŞıªÍ\'ˆ†]%qyİq‹:êÔ*\"˜·4S÷rÑÆq`õvâç.û™\Z¿sâ:eHUúèÔİ´dÁÛš¤z>­Ú~õı¨t4«£Zş!-‹q•‹Ê=ı’î>èÅS}ÒÎó÷õàıwÒkgQFÎ¢Ú›9C6(„¡Ş%ÖY¹°óX5•8º¿€] îHø5~÷iÚãî9¸Œ¨…è.¡Jjá]7ë™/W3¤/¿55^BB¶ºâ?´ó·Oó^`Œ^ËPâÛ·ÜEZğÒ“Ô¶ÜHQ‡µ.R®±CûTØQüµ×uû®{$GÁÒj”ÊÁ\0 á\Z•\'ë|º,WTç\r„Â6\\·ÕKzœ!vq\\>?Ò¤hP?4«©³Sin6I4ÛÎ+NÊ®8e¢}å1•ã\rj(‚ñ¶€ >Ş	`×ò¯QubÔóÏ¿¤gv?HT`B\rÊ\0«DÊØ¾(Ó¥•Eòå —¹É«¹“FÎ´K-‘tŠöÌºqÚ¶½m!W€¡6¯*P‡ú9*7_5h.\0QÈ¡Äû‚`óµ„\0w¢İÂìş\nZÀÌöwß ¾~ª\" sf;ã\"›5‚#r=ÄÃ0.\n$“-†X`T‰†ô¹dƒíÂ^©†şŒìI4ïÓAKŸR¤iS‚¥¼D¹Å‚j‰EäfU=]ô1UYZ ˆ”‡µd.&È˜úÆñjÅQ	\Z€\\r^¦¯8²N-¾RVÆ¬+<\"	1ÂR¦Å˜£+J5€…Øt¤†–Ü‰Cüm.=O[û$fÕ“ô€Yk$†|p\'^ÖÇĞ†C0¡+W;êO™ë›Òu» Ú·–xU,e‘¶©PIëÑ†¸®ië+uãS#´ƒ#fˆù#ÇO˜ /·»ê ™¬ n›ÆqÚ}\'íöØšè4ì‘K€A+×¿ C?8ú¸3—QŒ¸ëê†ÍÔ(š#Ù– J£ÖÁF\\¦%Ø«(ó…nV˜!QÁqYOÉß¦F\'ª2ù‚(¹ÅìŠcæ?¯hÓdábT{ôñ&ÿâ\'?S yAuåğß¸è½ö“€UÂJ£pÔ86ì“jô¤¤³\0¶gù¢ùáÖÄ8ƒz¢ª~§OS’c¢g_µü1‡4lrŞµË÷ş½Û¥hı2¤ÿcv¹ízp›ƒ\\¼H¢øêõ£ú¬ZÚÌ–\0@@m\r-!æ!¨%1à³#“TÎw­dH)dgHGg_C’ÛöŠÏXc€!~ÜûwçŞ§gE|R¥®!ÇÒº‘}¿<$C\"¸µVŠsR¤A3HÌ1Ö=ÂÊíwÃïÕøÕ/È¬^©*èÃ–±ÀàB¸¨Ë7ŞRS¦ú<~ÒÑ©á”ŞËÌÛ\Z’!aCEc®şT¨.w9A!6ÃÅËğM§™ï¾DN-YÙÀ k0„ø,\'u`Ï<©û÷<Â³¥yè„¥ÅĞK/Ô×éšT›²àtÃ­!bFjZSTç´‚å‹¶ÄLœÊ……9Ÿ¾è\"M=ãdÜ<ª7ğÁ+@æcUe¹Ä&,VãõûæO)n£Ü¨‘Ê•œ\n¨©L(®ÓœVåFPÔ=´\r	tEd¢\ZH:Y©rC^ÁßÎ&Ã:jñ›HFÈ=nyk+”›6Ä!6k•ºûN=øåYÀEhĞ,+Íøâº œÓs`\\Ã­!2‘üŠR;’W.\'™³€Â³×W_‹**ŒA+‡)B,*Ëqğ HõZüsºô§Æ\r€Wª…iÔWˆ»89AgvÌıŠ¬ Šª‹‘ió š&M¡X£eUâ|Èön—6z÷oš²áVÃ^Ü{Á`HB”‹º÷ë\'ªxÏTgÖ©+ØE! £p£N.t¢ò©á¤”È¤”¨„xeŸİİ\Zz:/:I;f–jv\"JêÄIÖté„Ò2^Ó×½”;cŒ!>Ê>¸ùp®c•ğÕÉ!x²¹K”³ş°Ö§(*·\Z…yÁ}ÒóƒıÛIhv°AÊ~wk\ZpñÒûéÈÛçP‘8ˆÍèÏ™1Æ7Kì/è[n/§#£$¾–xÅÇ†~´yœş«s!aEàOäsõ³!V#l?EÂO‘‚lÁÊ?k¼ò0£ıÿrŸ\ZvÛ;6‚(gª¬2ÄË£ŞÚaw-\'™•,\'p‰a¡A>>^ßÉ-ôêƒ+àVKÜõcH\0¯ÀÅ7ğkÒ³g¦z£ïŒr’gvıCcS`Ú“ùcLBŠ¿ÖõÒiß×[W]‰û[³’æA‚ìc¸BÔø‚\Z`O÷SYüHãEÅ\rêDª+ö#ÇÑ³¬1fI%£“òyâ“!ÒÑ}™>Ö‚æpu=ú9äk¸Ã5v/KW=şÀš<}µªˆôaˆWmO\\Å ®¨ÄÔX@++›OÖW(í/ø³²\"‡­1Æ3âàJû‡º¿y7ªpzóö…XJW’è}†Ş˜\0›tÖ0*^Ä `ö€Êu\nf\0óW,«BŸxæÿÓ^g+·ÆŠ¯iêó)c!Ê.…âQÔÖ-õãiêUûÁ`Q÷¸!ı,kÅ’xäGúÚ«càu.e=7úê¨Š,}èÆí.=W[ó$9TívF´Æ\ZCpg}ÊaŠ	®o¯H¶\nå£Hï/´Î]Eq¡ë%¬V­zé‡\0„Øıp÷¦\0…«/ôê?W{Ş|•69ô«²™AÁÄ±îöÚ¦6 	Oêª¦f5¤z)UBÕ¿Š§uIz	5#`ˆ28ÔE¯ĞAÔŞ½,÷áhÆİ7iÒşÀí ÀÖN6¢5Æ$¤By\na59¢€.§Õb|«UÆ[BÊ’Tók\'èg‹)1ol£nx­•I°k¯Æ.Ûİ,h^¸¹û>y¿&í´;>VuŞ|(ÎŒ1†”½njÀ¶îØ{•z^X¹Š\r	ê1¿Î¥¿œ2P±Ê\Z!şı1Ûze)\n‹…û¶0Ê“1Æ\nÍI%Ú·Ã ÷xÒ=1:1ÙÙç‰{5y×éÔ»Z¥÷­ÈcˆõÌ[}VˆÛ§ï#÷é¿¯9C|Xş\0º¯ÁçPåmC_z–PxÿíjØ{ª­Jkø\nŠæç_®.k(\r\rØK\n´%TtãÛ«æ½ö•/75õf²Y?O} ˆ/iÅaâşÌü<€’nª\0,VÅö%Âşı¨<lşì>ôXàÖUÁÒ¸5	ñÑfm ,ñÈ\rl¡šÖ^±CÖéÒÜRŒ:T\0}Z%AÍ*D\nº10<¿7ÃeÍş[_ıKm7ëh$ˆ$M#ZcŒ!–Â(îâ©ŞP¿b™^Õ\0VyÄÓUÚº»bpTWßCè¾bÔÅímR0]©3ãG§h¿óÎÆ}£)ã5¢5ÆbíÓy\nÏãĞè¶ÄF*÷’ŞÑÿPë|]e9Q¤ Ç¾*–e¢D2å7T«ÏôJˆ½ˆî½£>ÿàtÔvtÑ\Zcñ3dÇFD;éî	ÛSß‹ùUBiı:\\¯gHiTˆäWÌŒèCÆ~Â‹¬kutR¢NûØTœËæò,29%»”æã6\"vŒ¹®\"ŒÕ¨=ı”ØëPªG{7®JÏÓ)Á]Nm‚UªØ¨Âşk•|H†8¸´3éüVº·,Sş“ÕW³wA1Â„áXË©ûq„R´ï½AŸû{?»­Ô;Ä©}™¾Fë!ñj¹ØÓ«V¬Î§’1<¿@»I¤é´@Ò]š\"j?ú¹¹òm·£Ís™ˆŒ1•ezOë®=÷Vñé×½ifè½yz^D¥i]jÙ\Z7°ŠQ\'¢ñ:‚èÂké¡3÷­È¼¨…p.É«qßø’ö}¹Âì‚­1Æ2›ÖmïÒ5[l­æ.¢v µÑQÒK5º¤ø!ñ‡ıÆ¬òªk	ñcX·ªÍ¯:7Ö I.=9 e°-Æ¶h1>öw@+£áŞLØ\'qH/¬i§ãñ\'ôç™TÃ»	oúõ‡ØØÁKÈ3½’Z¾BWé‡ß»gÑP¿ËE¢Lb;Œ‘DŸ¡ˆxB\'bHn¸È\"nE}‚¯HxŞÃ5»Gëy[` õ1‘îaµ=€Ã¡ËÒi*¢p/ß›)Ù3[eşèÙ?Vç/Iö¢Î†ÒhCzMÇÑ	êCãX¾—\n¡e£Ş÷Ï›32é,€²&ÆLä	mğ°K¿à¦ÿv†v½ø,Eš\"Ò´ˆâºA—µ´¬-úzöK§ú²õÙmé™rjÄ\rÜŞ²P•$%¡$ì¨–rù	–óyjyIBİ>yWÕv¶Â²Iñ~\"!FÕR(wjêj˜µªQ¯zƒMk¸89Ew,S’“°qˆ_ª±FÇ-zï8Aš—ú¢8à\r	hñ=†Æg¾xòÇ‚!¤ütÔòÅbœ	Ù½°ç\r¶\\Æ4™”Ø<°E¯ÎÕË;­.Àp‡©ñFŒ}vCX÷.ïÅµ»Ö±	QGÆ§T^B#J\r“¤]eèQ“¦Üîš«ÔxÜaèGñ¾¡BÃOyEÓçÇ…!öLGw,EÕ˜Z0b\0@º*òşŸv–æ·3Î0¯ñÉå©d4	;%@Ï€Ím\\	±ñvF¸şw¦	é\0åêÍwÙPG<ö)ßú5‹À6fÉPÑùyOiîôCp\rıŠTö&¶õ¬2mq6ñÍŠöıÕ9j>áÅ˜Jg¶ªúuÃ=Ô`/CÔ»?½²o¼Ş]ˆ@uMÏê¯²œú€f1É!S².ãZâ‰Á{;JÅ«c2ê;Dç{ôùø›ñDƒÎóÓ×ÏHáÖÂÓb¢„.¨™¢MRí}¦D”\0¾ğÂ_¥m·Q†ªBëBïªR_¤zKD®Vè˜_ğ–ş¼Íg<Ñ×à8dV»æØ4X,¡t²¦|ÿ†_Rv	3{ôûp4äßQ;·nüiù—Ò«A\n5Zè½Ïş	o2AG¼:Ï›·èÒ?T:®ƒzµºíC”óÈS}n™Fº0QĞóà‚ŞÕµ‘ 6¤Œœ‚1ÿ™¿7®—Ã>—<Y_ûà)’UØ’>qgCØñyàœØ¹¹74N¦ŞÕF<t;}Õ–Çfºû‚xyü-8cš»÷¾1_ôç`-sÃ=aÕßËL”¸­iQ½­<3Š•àŸÑáT°W(ns˜‚–>\nã–/{SÏm¶»ÚûõÉ¼	ë\'LK²Ñ\\#™-?ŒQç~]†Ú\'òºÊ·¡’4îØNµla€ê`tßQOŞ§ğÖ;’²ÄU\\9t¬š!Ôk3)?I9L1Ñ;í¦_~Ësù‚€˜VR¹Rmpí\"»Èzß3;l¦/ıí!PYy‚Põ0‚Õ`‚wusKù&ÛÕ¡{&LõÄmI%§É´WôQYöƒQ„ÛŸyÓlÅûŠ’f›°¼z_ì\rÔ´kÚ:©¯zâK³”÷¹­İí}-øÜ9Íaİ×ÂØ&†¼U˜:Ü\Z’!Şqö‘ü;•AÈç3ËeJA¥çwÖÍî©kÒ±ï?OÒ*†zAm±›}ƒuär­—~¡Ş8÷Ì1B;<¢ïø×.ÆB:ô½¿*šÜ€‘*èúˆû@ëÍá…vKoİv‡æsrÕ >\n¦G‡F¸¤#—/R4Jf•¹ÊCjÃØFòE9 ğÈzü+ÿGşbÉ›†W°{…Î¸\Z}wùr°-îŒ\nÓ\0Ã­!ÒófcˆÕu˜ˆ-YÆŒá¸g[j€TüÉ¨\Z?J»üâ\"Åù}¹şU5›·ÿ\r´¼ı¦ßzš–!Íèô¾Î@õ«ËÚìâïk«3¾ëõ5Âíáeà¿3Ë¯‘RÑ.İ^»êS¹¨Á\"C÷Sõ#\n\n\0\"ªÑ1mï°·ºİY[†\\¬Ü,6Ó—dÉ	ê¦ÆM”Ìd½ôFœkvQÛwãº¬9¯¹ËRÌ„±Dë¼YGéÌ€6b¸åÏ‹ur‹ÖäYR$³©dÕÌ{oRd¯T˜-eîÓ «XéÏÓvóF¼{®Ô@ËJ‘\nHÆQK_W˜éÖ^IÒ\Z,;&ËŸE¿¹\\oıøÇÊæ˜Ù²b¸Ÿ=SÏ2£d²ªÍ÷İ¦š½÷¢~ÙlÙ@\'ªk™ó63¾H1ny´Ï=«B§\rØã€æ1ìës\ruúy{‹§şÊfÿÌ™”HB¼›¶İ@Än¤YßW+qE’Ş:»à0[±\\\në˜ÔˆÈL^$ÇtfÉ£5Œû3ø g•ë¾_;ìÛŠã™å9;¤gUÍâ÷N3hàî\nG¨C¯»\r/-ÍPÿ\\” 17Ş†‘\r´Jü¾ˆDŠTÂÍ-¨èxSwmÆh?\'ì©ÉµJÒ£øõÕö…ŠTM›é•\\oÀg^)\\áöË¯Õ«§iOzÛÅ]×ˆÏçÿ{¸SÅŒ#?ü|“êç9CxWCâŒ&LÑä¥iĞ’€ZK]š€ æug‹)úâ“{Ñm-Òc 3‡×ĞÛŞk¸­{;ïëĞoë7UÍô!ªµbU3ÄšëÒ†¥¡\n_œ©®ı-Åy6àßæ¸Û\0«zÃŠÈB\\›Ãã.{W÷ï¤bo¿Çd8_ŞËÈ>ñYÛşşBm÷Õo3Ë¥/ÃË6ígÅW…Í˜~õIıy¯ÃUA[Ä¨Xğf¨Âˆ\Z “k‘è{:8ÓÁ*<9†cuÖj1ÄûkÁÛ§ıI†\ZˆÒ„mChN‰‘ªôÒA„æCĞw\\-Ç@4z!¼CXª‚¿¢Éû«¶ºq£iİ.ğ\0±_YÙLº1sÿıtø¿RW\"Ş]/r:Ğ²Ç7™+QòŸ|o‰nÜÿ`…–uª…\r3™Ë]\r(!ö>ÿ¦“uÄ+EJè«Êw÷L¯0;âGÒ‹ŞÓ];VN¶]ãÒ @LfÅÓÆàñ(•‰­88å¬¯Î\Z1CL\ZlTŸƒH‡ÙÕ§Óa5­£;spk+À)şµWZU÷ãs´ï€Y±‹k^Ó=şÃîÌÇDˆ¬\Z*u0°M-ßı©ş>û:ït UÅwÖ±eÒà0¬?7æóßäns½š¾0“Ù*İŞßJÖûÖ.aèóûİÿ=A\r·> (µ\0{‚!üÕvÃº¼»êN§üÊ]Jl2Íû\\;èg…tIKXn£cù2]?ys5RZCÿyDóœôÛißäYƒ™ïÀ™¼97«yŒÒˆÒŸËI ã÷nÉ°C¨Z5‚x\'®\0òèÓ.¹X“N;^õÌúpõ(n_	fö¸Òv=‡Xîİó`_yQQæ©äªÊŒRUuz¸™ÖHTDw£šÚî³jƒCf(±Õ¨\"úZ»˜ÿøôzí¡‡ÕúÄóªM™!¨LØ³ŒøÕ>D\0”:\r$bİî¢³´í™?Pƒal…¢ø`v Œ©@C:lŒ4Íœ»«nyßy&–ó°ÿÿb\\Xó–1¦u-Ö\Z3çP‘Ú’~QlÒ$Fù™çÒ#Ú>ÔZ™Ö|Ü,Í¸ü?9oª¨š|/Ä¦°õzKV˜\\ Óè–­wW¬\r„ËÔ[õª‚(i²qV gécƒ>Âd}vOa\rúe\n™ƒƒêKÜd›l\"\rÆ›¥™\\â„¯i›+¥:Ükó¦ì+œ;bÅl!Ôn.…CÁ€¶Ÿ®ÔZúúUÜäPÉ¯ÓK—°WSGõcŞš3$ìgv;\"™ttq¹Iux?=1ƒèò\0â’ÆÏî©™7_«vrôæáªªæí$_†]ÊTì[6İ†¿UÓOBL…ÙØ{o²è\0\0°IDATëîÒ/ÄYFÑ\\bPã$†TÚéll¹ggqÂ`qèhªûüÚõ¦Ë4‰˜Á¨ÅQæÔ—]ÜX??ka‹fo¿+#F8Ş‚2Ú\\?ï¯Hş•x~ÄÏ[›µÆ©V=[’Y<‹YŒ~FşE9\rÁ¦sö,;Î(µíúÆÃÆş4¹ğÀ¨;ƒ²5Î,\"aÙlVwMİI¡.Nk#úÍ\rÓgaÇE¨Ìs\ZLzª	à©¥*)44I}@˜3¬–“lóÛ±(øÙ»â7OÔq—/?Râ¼ÃB\r–O+Ì±}.‡Yaí‹wşAK>Q)f¯\\fğyˆš4Î·Jİ‰§\r¹Şb¤Úˆ¸ã×•IZRbŒw•+kÆÅf¸wÀ„}ï¾B›î8˜ÅäîñÎ¬ıË]ÁÀXÓß<Cï¹ïÉ±Ó?Q+5ôé9v8Õ êl(†˜wœbÜE”ŒfœM7Ó1Şé7?Õæ³¾á!alÍœÛQ{ÈUÊ¢øLFüè,•~{³:ğìBÙŞxÉl¤ŸLàÒØç>\02é#¶6Ì°÷®	©@¸:ËÕøt©3¼q¯Ñ³Òü®±ƒ˜ºJv¸ö¹ú|¹LZ«µr˜0³jÇ B1z¢ã/èñ#OA§°Tafg3×f9®CìØ\"óö26*K—Üc\'vÓ5*o²…WÈsˆeŒI¢v~¡\'†ûî>ö¬îu¢â-dJ95Ô\\s_dÈó3õI@ZrÌ\\ÃqG0¾o$ÌZ\'1 -@_;c»4Ô÷™ŞfyüaoÜv¢Æ&wå\0ÛCn¿Uù/î«ñ`Má0ã\n,¦6DÄ‚qeŠËôâwÏVËì›ñ„²Ø£êköõÀ†’§°4ãw¿Š9åÎßÉåÈŒ÷cöÏÆå€‹wÑ‡êyì £Ô:o.÷’¢éµ±›Q>*o˜8Ú³ŞmnÔºŞÃ¯Å>ÙA¼4o„ø½f2Ô&À³NÅ†ìÂøs¸ ¶…xÄBôu„I+8VeÊÍ¼øÅ¿2Ÿ>éIIPÚš±y·F„œ”Şüİ-¹|¶Zæ3\'„€ÓNvs<Ÿ“İa&>*Dz­ú$6ÈÔ| ©A©=wĞŒ®Æ]¦«„;£à LP›C¢cœÒ\ZÉ(Ëüâe¿Ó—şZîN;¾Ï`O¼>‹¿ìÄPC°JQ]ØPĞã­dÿFi\nC‚0Ä^ßgJNû\08‘vÀEü#ğ#1.i™qªµ€wEØpcmõÿÿMÛy$Ä©¤ƒ5†Î0I»\ZPAúòìdG»–<;O¯=ò¨|/ÍWÇ‡2à…3}xHÑñŠO¯†ÏLÓfûî«Æ©Sq{¬™M#ìÍ±Ó\Zì°KgÁ;zéÂ+´ä†ÛÈr%D..Ú°6?p¶ë\'&vÔß‚º¨.ˆPLÛbõÖİGıù:J1©°êÇŠê9 l»û.H<\'ÃŞÈ¦{ÅxæÂú-*æ.j¬#•CÃÊ»í¨éäÓkwÙb\0›£2ê¨ tl’6N€ÍÊ-vğ!×`‡\r—9•Á7ãškl¥8\r¾Z´	ñ‰ÅFÀ=1ì„•0å`v½“Õ;Wß¤çÏ»T±eK= …ÄÕÔÖªÈ=Úæñz pBjq§ôš?Lbi#úäs;8\\`$ów×T€F…!}nÆKrùu0\'tÛ•Ã60](\ZW\'»ºg³œ3#™‰Ú¼ïz–%y¢[n¨ç¥ø¾{RbLz¾Œwc—,#YÆLã°çåÚğT——G¯W€t<Ogòò-xW‹o¸Us¯új9]§g…¹§áò£ÕöÛHä˜w\rË‚J;œ¯øsg¹æ›¬B¥×”Ø#yß¨3ÄÂ²\0v£ÀCMÂÛúz|²öhgï–™rJ<³C‹!C=*Â&é¬t¤®v$BpB²8,‚£Xk•ÜfKÕo±©‚ØŸ$»:QC®„_bH¡3%w5õö\"-õuåŞyŸ³m9&†ÉÒ!\nÙ¬\"\0H´—éØª\0ı^¹\'6(Àk]f¤÷ÄË½3ØæMb­`´K#`9‚÷šQgHÏ\rØ®É—yèM£Í„û´1¥œŠõ¤ØÄS;ma%C ’\rõÏ³‹\rÔ²#¿©¸Q¦¿£ò‘¡C2,À´ìµ)Şë­ËŞótq&J¼^Eğûlëı#Ş©T%Ïì4hUis)²0>Mê!`ÿN·ª)w™ÆZâ˜#êuG\\\ZØ#ùûè3\"YÁ@o;KÄ¢ß$qG:Ò8ˆ>‹¹3³uµ¸Y½p÷²j.k>Â\'ó |Â;v9A$8™ÙŒ:/	Ç—µªØ© æâš%EëÍÚá$Ï8º…^ë²Hıd,{–ƒÛë‡±m¨¨…Ä\"ÿ	fåX1RÛ›ÚØ6³„RÍáÓ¯#!øp¯}†u&6 HäÙ¯±V“ü°#0TÛG!¢MÒfĞ#6‚¢6v·kX_†Ò“‚ñŒçV,nzI @Æ˜şæ1:¤€IÃ¸æ2“ø‰Ö½†^1¨Ä¦O¯çµ^bjÆK{âã[&¯‚šáhZmCË.¨©x75dÜ’¿\0äÇ®ØdmŸå<àtíNVÁ\\Vzã‡ø98“ç«*Çë»œ6ëIr7/¢ßÅóBÉyU2v¤]bı³c- “u²‘LBlK[¡r(á4ÛxZË6\0R6\0ğ‡·Nv\00K1ÅxJsêx_c; !†—ÃB»t\\±Œ¹­€„‹ôÒÂHÂ‡9@ Ñ»¬…ŒkÖ`´»†2Rèe‘,_búÔ:@÷ë{­W	Y›‡¯F›«¯³®0¥µ¹·µyï\'YêÂ{?aÈ(um.ù	CÖ†z£ğŞ-CF‰Kş/şĞKAbê\0\0\0\0IEND®B`‚','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0\0?\0\0\0;P×¶\0\0 \0IDATx^ì½|UÅö=¾Ò;	¡÷ôŞ;ˆ‚ MP©Ò(6z}6D¥÷^E@¥JŞKèôz“ÿÚ{Î¹¹ÄõıßO?ïû8“Üœ23göš½×.ã–ÊG#ğ7€ÌºT$ÃÿGŠRİøİÍÁß“Ù~êĞ¹Á©)<Åpç9ü†ÔT7gkİÂsåwó™›Ş1mJëı­ß]Ï³oà:ùİxi—ÜÓæ¾\"\"núG78Ü“à–*­p‡;OKvwÀSÏ“Ï’øåa®ã¹nnÉ¼¯wóÔsá&ÿ³èÆ~IËí_åé(ïóûvZ\'ñïn¼‡ÜUÎó±‘\'hÛä:ŸéÁñ4Ï’6¤ÕßüŠÍ>˜bØ=Ó,k‘7ùO¥\\[äD„[~ \0©¬Èÿ\\`ÁF…ÁÅW!ãMåjWàqAGîÎ§< l@*×MÀƒø—âÉ¶)ávs§¸›¦›¶³İúhöÏÆ@+ëînÒ\'{}·ûëÚ·ßM¹±=œRÜ\nk2:~\nŠjwé‡\0ß?w<˜nìÿ·ŸLÁJ¢œ»Ø¸äÎæ‹<!ş\n‘Z7Ä¥zÀAY	¤yP˜Ìª,`dIšÀ(>Ù‹½œ™‹ÒøƒNƒÆÒÀÌÜÔ<Ê@ƒí¼“è@¨·;¼ô¹>m2ÿ~æÚ}$&9?{dô5 I\r$•P`4öÑ>«!Fç°u1Eço‹¢å¹«¦Â)Ä&¦àÂíh>\'eòe¿·h‚/ŸD@ıùÀüoÚÿhïEHîDÅcÀ˜Ù8rúú=ß¯´¯!ÜR“ä…Ñ3Vãêµ;Ù³%*Ï­’^éOQYuÚ\Zª>³F„Ë†‘4aÁÁs5lMÂ\\£Æ†­gèJ% ¤ĞNó$È%ò÷™«wbÙúıè÷BS´nPú<é•;Â\"âĞkÔ—¸x=ï÷k…ö«ğ\nš.¢¥ˆv¤ç\ZÉ´E€G~¤Jƒ¤ipgOşÛyì2Şùd5nß¾“û¡\\Ñ¼\n-Ú7ÛDúİhı½î‘ó÷÷£§Y# ÜÁ8Z\rƒ\'nã^Mñn—úğ¤LñJuàäÕ¼ğæÜº\Z†iï¾€vMªXÆ‹Y•EèUÛP°…ÓI)ZZÍ§`ŠÖÀûºég–¹a	¹«`ëùŠKÆäPÀÈáÏîÉD\'¥¢ïøo±fÍôy±Æ\rn/5ÃÍ\\HÆ“½§âÒDL}õ)ôhQ•à\"·\"Hñ¢ˆ4\0£ı6Àœô?Óœ\0CmÄ‰ˆbş¤âû—Ù5¸vûæEÅ¢Ùø1¯ãE)îÔ”TÛûg§Ü#€ùgÇÿöé07cĞúµ¯qøä-ŒèÕCÛÖ@dTü½‘Õßq7lüånŞ	G›å;ˆ¦¥.\"6	‰I\nğ‡Ÿ·˜P)ˆO¢†àáoş>8K\0’)lIú7wøz:ÖáHA\"Í1\'|}½ô÷¨^Cü	\n€Í±$IBB<}¼ùL7DDÆËŒA~\Z7ì9y?:–µË¢láP%qÃÙy^¼Ñfà\'¸p=\ZS‡·AÏ\'Ë+”DÇÄ#&>¾¼gö@?Ka{Øª¨Ø8ÄÄ%ÁŸí	ò÷U³Ë6‘äï±¼î~L<ÙÇlşğ&ÿ³ùàyô›¼nŞÇ¯{£R‘ìä„¨!±}ş\ZøÀüÏŠØÿvÇÅ$¹›„g†…}gï ]óÚ¦æä…ÛÈ™Í/>U•JæÀÄïvà~d<z·®€r%‹aî†}øaïqDÇ&£HÁJÅ35S¾ı¹òBÑây°jÍf$8|ğD\n¨X*\'fÌİ‚ìÙ³b,µ¤ lØwsÖıŒ‚91°{K|³b\'v¾€G*ª–.„­kâèÙ³˜½t/ê×¯‰dGv8¥¦ÇOVÆSõËà«e»ğóÉëxºF~tlVß®?„\r»O!‰(•¿X!lİq1·îbÒ°–èÔ¸2æl>ÀçAä½(¶!\0OÔ,‰.-+PcsÇ’í\'±jÛAP\"ÇÃ»7Gõ¹©¤\"–@9kí^lùå<Â#“áí•‚òÅr£?ÍÉ7n£ßÄõ¸¨\0Ó—\0“CU/ÑëÔTRæŸ=i0ÿìøÿï>ªüM‚D›a3°÷2WõÔD„úÆ 2Ş—«|*j—Åà^-1âãu¸ç&k³×ãñ¯/W¡`Ñ\\È—#7;\\¹ƒ0fPg¼9unF&\")á:}|‘à·$¼Ö÷	|·â ÂïDbõô®(GPz{ævÌ\\¾/u|BÁcÙšŸP­\\$\'%bÏÑëèÜ¼,Š”(Š÷?Z‹À¬4‹î!>ÕOµ²yı1íç0cé¬Úz/w¬Œj%òáÍ)›E0ÍšDp£Æ\0‚Á¸ÁO±ı×0eöÏHõò@1’±nÆ )2Cº6ÂcErbÔÇ«p/5ˆ}öCr\\&ë€Ê%\nĞİœŠ(¹=Şû\Z\'/…¡T‰\"8váÎŸFë\'K£kËj6u=.„İÅoú¡259-ZP–GéŸb\0æŸÿÿÙ§‹‰t#:	^›‰=çcÑ¨l>L{­%îE$¡Ë;K“¤CÛØB­ òN^êP¶CXlOˆìşÀkŸ®Çö-\'Ğ­K#ìŞ	g®„áµÑ¬fYŒ›¹[÷Aûåáá›KVìÂÈ^õĞ«U\rtµG®F¡k‡¦øjö|Ô¯Zïönz{{k’c¢Q§V5|·lrçÈ‚÷ú<ü¹³£ÇèÙˆ‹MÅˆ\r°ë×‹Ø°í<Ú<U±÷\"±qÏE<ûÄc˜Ğ¿5~<rÃ¦¯Ab\\2º´oŠŸvıŠ“§¯áƒş-Ğ·sMÌ^µ¯OÿùòeC¹ây±s×i”([³F6F¾  dõMelĞîŒ»IÅÅÛñHb|Ë]š†«w^Àg³÷\"0 £ú4ÂÇsöãì•›Øÿ`şgeéQÇ3Y`oÆ`†}½çnãÍ®Oàİ®u)R4›>X…-?BıFÕqúü\rDÜ\rCƒšU±çà9ÄPÓ©Q$\\İÑ4¸~ù6\ZÕ­ˆËÂğ;×±÷ÛW‘\'ÈÌùÍù\rjF‡æu1rÜT¯RC_j†¯}‰2eŠĞœ*‚™s7¢@¾¼(–ƒÄ²‡œ½OÅ:•*`ÓÏ»P¡P0–Nè†¼9CĞúõ9øùÈ-ëRÇÏÜÄ†Ï£Nİbˆ çèùk˜?¹7­”—¢SÑ¬ÿ4„İŠCÃzµ±÷ğYÄGßÁæÏz£vÑììï54è»Ä´jXÅ	j!Õ¨ÍtjVÏ5+ÜYÈÑñ½Ÿ˜€%[cõæƒ8Ëş&{úãÊ­dóˆÅ°¾\r0kñ¯ÖG\0óHÈÀ# \ZÌ-LÛ¡Ÿ“ƒ‰ÀkİšcT·jêmi3j	¶ï<ÇŸ¨_O]CtÄ-Ô®Rû\\B<ÍõŠ#$¬ƒ¤«¬ôÁ!X¹ıî…ßÄ±¯!Ø3o¦ÏÚŒ:5Šaü æ<v.ÜIÂÓÍëaéòŞóqÜ‹IÁ´YQªTq4,•Ásô_yøÃ‡$sd¼¾YıÊôÃ¢ñ/!_ÎPj>°î—kÔ¥6Î¿u[O£Nƒâˆ¼u¿½¯FwÃu\nã|8Ÿ3èS\\»M€©«\0u?Œ\0Ó\rKæÂSwPÀ·ÔV<1qÈ“ÈÎö/İ¸k~9‹„¸DŒéÓœœSUrÊl=x	İß[hwŒxŞ¨À`Œûr+<“0¬w|½ô Î]¾õHƒy$_FÀuÔD\"©Ù~ø,ì9E­$¦½Õa×ï£ßè%šDt{î	,Úğ+bÂoãùöµ±iÓo¸‰ßiÖÕ‹ •h™„›ü¬ç¨¥¸‰_ç½†lÔ`ÆÍİO¾Ş‚ªÕ‹aÑ˜Nxïó\r˜¹î²eGv÷(|ùV{ÜHÀó¯†ÒåËcÊV¨Q,IôÂ$1âñ‡0tÒjT)‚ùãº¡Hh\0Ú°›ö„aà‹µqúÔU¬ÿùyª4âoİÃ†=7H*Áøşíğı¾cóõVÃ¥ kÇ†ØñãAœ¸†WéÒ~µ{|1o/ŞåßËæÄ$š…•+@¯‘;>\\~“>[nÍªà«·Ú‘Kqà«åûğÖ\'›T(7¶Lí=¿Á‰›ê“Š×^jˆ¯—À¹+7Ì#ñz4L*®‘ƒi÷êL½‡œ¡ŞˆŠFT<µ’¥­–@×ö\r1lìRÜ½Ñ$y¯İŠÅ—váİÎ9CÄ=Œ,t)¿ÿz¼óIŞÌÜ7‘5À\rãçíÄ‡3¿Gê…±jj¬Ş~§’0NpÇÓµóá“¡m‘…®â¡S—aåO\'‘Ä˜“Áˆ£ñxÕ‚(Qº\">øp\r*–ğÇœ	=Q$G0}{¶ì¹Š/ÖÂ…óWHò^%7TuÊ$Q»œR\"}İL72¼qçæ5ŒÜî‰Ñ˜öõNÜIŠ\'§€»÷âÁæcø+­vé\nmÜĞ<9	®±æKÄ¸A-Ñµqõí8\Z†^£à\nƒæâ}ƒs-Ü¾^QúâS˜·|7İá7°sÖ`’¼ÙÔk”Lï‘‡é,\\¯å«~0Gëïñ/=\"yÉı?2»\ZŸŒ¹kwã5‰êUKâ—ghV$¢tá,h[¯4Bü0gÃÜ¥¦Ó®a)Ê—[é¢Ş}<w¢äã‰Òù‚Q¯fylŞq1$A_}¡CæS°åĞlÛw\ZEógÅ‹-k ünfo8ˆ{	©x¼R>4­\\B#kÃw³a×o4Ån#‚àäºerÓ$Êu?a¨¿?º¶¨†\0Æà,Ø|§.ŞFİj%pÿî]:º IâØH2ú‡Cã††UJ ™$ÓáãçğãwÊ•ÌŸöÁ–Ã7ØîäÉšOVÉ‡ª•‹aßáÓØ¼÷®tBƒ|Ğ°b!4­YY}¼ÔÕìÁX ãØºï$]ÔŞÔ¨\n“oŠAlt$\ZV+ƒCÇÏãşıHôëÜ…²újÀa2±Câ„%éB3Ÿ\\\0F“#õßß“Bğ`şñzôP‰•ÿÆH´ªsz’‘˜œ?_Oxk$ª;â©¥HÀ=¼¦MLF<]ÆŞğ£ Ê™	ädD¤ü=Åû’Ì…ÁfÀsgÈ¼ƒìRy-ñLƒë¼ËÓx•ÛQ)HñĞ|(G\nãL¼Aí@Ô<y~’‚¯ô$÷‡÷äğ ˆÈÓÄòâ½¼<l—\'\0MşO ƒå$×(™}ób?<%E€‘xâ~O¤ö%}õ÷¥ø\'y’GJadpûã6*Ÿ{H¢¤f,H~=Iü16YÜüçÇ`Á$¶EÆÏ‹÷e	(\"ôLV3Kr4™B“*­û¸DÃ¤¥\'<˜GRø~Lè¾$êJ+ÿÌôIMõV Cóš5¦Ã.m ÙÌò\n;ÿ”\"	„ŒîÈSË?x©ö —«I¡u‹J£§ Âš%vŒxM% ˜Sy?ITğÔò&ãÚ¤^šä¹¿4Ò}*	g-İÀ¶hı	Ëì°¿i¸ëÌç¢Ê½ù¹¯%ôi;¤õŒ\\Ñü)“I€“@-ß`¹©FéJ¦´\\¡($&øøñ÷>ÃdŸËµ½r¤»Gæòÿ—Ç#\ræÿåè>ºw¦# ªºæà¨€Ñlb\n™»S¥·rvÈS4Z‚\n‘æ	I±S+Æ‰(<G+Åˆ ÿx®€•&5;M‡´$I“ŞhÕ a·&$RûÕÚò™\0æ&I2‘À‚©ï\"!ùŠy\"Ü\Záf„[Ïåg’-umLÙ½¿©dÉ  T°kÑ˜®5Ä\0©æ™Ëw«ÿŒçÓş8AD“(vM¦4e0´œ„3GË€Ôßu<˜¿k¤=ç°ÅP…R¥^rh¬l>5\rDø(Llh\\kQ—ŒÎc×U²„Jš‚ª‘x^ZùÜƒ¦\\“\"÷R9—gZ d“*\rRó…€¢`§j•%Å¦ÎŠhª´‹ÁoÎQª5éİ­¶¹fkËç\"øÂ‡Èı¤ ƒ•p©ÚUZævZB£<Ó9É*æ`eX+¿bĞYQL:æ:èonn,Û …iŒå60i ò`	ãÿùĞU5u6Ñ4< ©6cŠ:™ße(¬e\\C4‘U\n“jò³+REx\n£=ŠÓJú“Ã\'ëV*›¶Uci\ZFø­¡wÊ£:“ÕcUs¾#àöÿ®dÌ\'£-PET\rÉ-’¿\'+€ñnÚA\0Ñ^¤‚•<…ÏPÇj¨UFÂÁs\r5c\Z/f•6X´Œ\0©â¥¤\n$ %9ñ…‡\'Çö¿`ÒWØ4ƒ+ƒ!m½ é· ¨æ¥s€u•²áèèk±Ö(ƒåª\"ša“¤«Ğ£ã¿f\\ç…³Ä¤®ævÉû½ÿñJú°*®b²¸“sI{Æß«òÿS/äÏT¶M+í)¼VÂo…Û­SÈÓ¸Ü¼L-Ê•»Ö°dÖ6ÓT†æöŸLÁşË&’tÂS‚¢‚‰:j&‘Ø„†½6,\0.iòª®Ù6 ÅËùj*\ZËÛ6$­Õ ÍµöO½ĞGÏık#`ÈÅ´úµ6ÙhÜ¤²ğ˜ìŞ?¶@¥‚zoğÏ×=ùk£õïí\n2\0­ÊpZFë1åGqkÿJÜX5ÁùŠ ´A/ø«EYˆFæDúD«âû1¥°,Íé?ÈÑü[\0cÔHÓ)­Å¥ïŞdp*h8ç‚\"!ÃCì¢9]€ÜY4ÙxL…/ÖQÿƒü÷^ç£«şÊd–‰`ñéï÷0.ÀX\\AI×5™;\0–Í¥ü•ÿ÷›^K¼uë¶oß†XÖ²í¤x±â¨U»ãeh.`îYğe#áwI¡ÅTù„ğË3WqN?£Ü\n®á¬ş“Eş\r€‘I#ä–—!è„dMÆÄ\"$±‘w™çq•¶\"X$\'‰Åt¤Ñ^L£bÆj^Ö)ÍÕtùë!U¸¤<TğR+÷Àü×Í~W¡×ÆÛ$‹pŒQ1<€é–\r,™Œ}/ç¹Z®Ò˜F²îˆ[[(õô˜Kf‘û¿{dd‚îûe/è°«×´ÀV‡g;`ü„IÒˆàû\'·áŞ’Š½ŒD&r:d·µµÑó*ıÇŒA?ä±œõ¬EıŸÑ3´T¡Í®›­âXşğäİì>x\n[vÆék»Ÿ€h01âÈ˜K>>dòBÃ©‹°G™¢ùĞ¶q9Ôcäd ¯·šXvˆóßÉtÿß–_Ïàh/\\¸ÿk:ƒÊ¼™Û“„^½{£[·—¬r•çM\\ÁJT÷_(Hï¾û.bcYU åçï/V Ó‘ßxã\rT¨P‘IŠ$9ÿé9¡öíÛ‡~ıúáVØ\rõ$µëĞãÆO‚ŸŸ¿.ÖQçwâÖ¢×áÎbYÌ\0õH+Hp«•`Õ}9ª·FjöÒ\\á½c¨\rãşÿÏ¡õ_×`TÃFÜ˜<,]¸ïôu,Ûò+Vÿr·Â™RNw 4Zø\nl“óZ—P7º‘À#æ}”ËŠO_íˆâ³-Æ²Ì—´<\0\n|Ù»víD×®/ òş}˜V­[ã³Ï¿ (d1„ÿC&ñ11cFcÊäÉ\n*Yk›IRÖ²H‘\"X¿a«Ùåÿï\Z°¿ØÚÆ€\0Lß¾}q›\0#^(˜	“D%À¸+qsÑkğ\r?Â³}L´e-ÄÁEª!k|¬	Üü$Éÿ{\0F!Ğv4 HNf–ŸSµ\n>[¼\r·Ç9æG¤Psó¤*&2ÅöİÛ›Q©§Éğ1ò?B—ÆE1µOæaˆİhù¤äRN$¥,7q_òïr¹ÆH˜Öiœ‚Ş’WÈ…ëQ¯”áÌ´O•5Œ–ÛNïd‘F7ª·l¡Ñ£zûĞ†™_¬{ÛX/›‰MÇX±‚¥Ö²İŠÊHquwÆièB²¥Í6%Çõ‰Ö³µê³1ôs3DÆ»i¿«_º!˜vGŞ•Š¬KvsGÇºœWÒ¬å½%¸K°r?\r|3^<0ó—ñ‘››;èÿõ\\ë#µZÌÓ¤]×¯‡a@ÿ~Ø»k—Ö´Í“\'/>Ÿ9UªTµÎÈÜ¬±	céLµ–VOµÀ©ãÇ©ıú°o£qY¤A¢wù¼è¨(lÙºUª“ÀÔáL{[Ú@Je×ñÖ«´Ÿ)\\üŒ¹e™]éîç\nŠ®¤¶´ÅõÈˆ˜Î¨]œ§¯üÁ¹`¥óŞjÚcÌ^ôëÓ·nÜĞSÚ*ÀL´\0†1Ñ·N\"lş ÜØG­%€gHœŒ½õ	‹«Ó›”èŸŞŸBö\Zíá“»_¹S¾Tæ4¶FÆÑŠVVï“5Œè<ôÈ\\ƒQY–\r\ZXôX:Å1th†ÙsïR0rÒlÜwÑn¬œãÉ°gG0g±ëäÂÕ˜(K‰kpó/R¸-E\0K\n¾ûb]n[[\'³—ì„§·Ó	o›™´¶¤åúN“ÊLë*P6<ˆY\'Ä±‚¤¾(Kv¬ùeÊú\\&UŒ´ÑÈ¼Qå¬?8%Ø¸İ5\ZS=i5ÎÓz˜rZ^6óXË-hÁŸ¹•É!1ñBv›÷gú/š? 1nZ/1!vGLü‡9ägJÛƒ#¦h\'½²ÀC>“ûåX\'ŠpiÚr¼ìÑ³»l=Õj®¹¿öSÆ#M+AŒ‹‹Ãô§bÆ\'ŸèóÜX¬úƒ1cñü/¤øvæ\0“F§`75¡íÚ2OÇ‹à’ˆz\rêã·ß~Ã-Ö`I¦S¨P!|¿…5wsÑ\rk‘Âé5&WgDdÄ=8p\0;wîÄ‹/¾ˆ›EÆr‡Û÷Í`ôİ¤ó¥˜4Àt6ñÌ>IæİÛÓÉÉ9Ùƒm&AÚÁöíÛ·Ç\0ÌÍ›:çÚvèH€™ \0#Gr8“(ç@àµHpó3S—ÿÜ™Z ÏJféD¦f¤ä¯„¼\r:Ã§ì3”qZü;K« é²¤¤º\r¼`L¿N°g\n0¦¿2áÌJn/³©†Ëá)xı_+±xëI¸„Š/\Z$™’%Ïƒ ¢bE0òau2¯DbAÇ‹™ŸÅ“«a¾˜«†lY|ğõ[­ñdÕâf¯”¬ğÔD4\Z1İj¤£fi/\nXV¬î#ÜÚAOr=¤Éê‰ÒsÄ…gØrÇF¸å0$š’%TÖK4¹*¶æ“öfSØ?]±ôŞ®oİ\0Tœ\rF’ìÌ¬Q¤	³&m‘­3Lş‹é“Œ™¹WªœY€.}0Dº¾NWIl“HP\"NAµæ¦‰µŸ#÷Js[*xØ ÈÛ!JÊ¤ÙH+!ñŠ=ÆH5 a¼zfÚÛ-´5Iãv¶ß‡óï2Ú7lŞ¼©Â‹Ö‘ÌÏ:<Û	ïğ‚ƒ³¦õ=ƒŸœ\0ÃÕóõ×_Ã7_ÍD€/„<Ëê5k˜=|3øYp–`\Z<¥Ë”V°ÓtÕFÓİ;£¿­Z±S§MÁÑ£ÇHà‡¶¢äc¥œp¤ÿÌù\n]–òç­K[Ìûµ<ª–Ğ§¢µÌXHcİ7çmşÀ¤F]Ãå¹áwq»‚‰,nê’Ö]¥áÉŸ½9ÎÑOÄø…\"kõ½N;¤fe¶9åZæš,Bö>Rf!²aĞˆÁƒÈ÷à g\n0\Z¨ò!+Ñ@dâ…ÇÅcÒ¼ñÙòıˆqÏbEÙúSœÑl´grKº³:{nÔ.W\0ÅòfEÎ¬Ağ\"ÀÈV·ïÇà|Ø=>q™c1ağ3$|Ct§<Í›·1m¢›‰£}³¦»YÒ&şİT qÉëD£2ã k.AÂC@ÂZÆDË0p ñ=2±Ìê¯÷´Vf(¡ëˆ Y\0”n IªÓ«†¥¦Š(¦F‹ÑHN™´æ-SŠÚvOÌS\r0mË^İL2ñ\r–9\'ŒAL‰I2à`ziOTcêÛ³ÁDÏwÑ	ñéÆEiÁ¢)&œÀ€‰Ğös®;Ö½\\„R\0æÂ…sx±Ë¬r^ÛUªLÌøòK+^2è?ø«Íç„…]ÅsŸÅÙ³§õ]U©^-VrW¶\Z‘§z0£úÎÆ8WÓ(3PëÆù\0SÉïøÒ\Z\ZÊ	Ö¢xÉÇ\\äØÒ‡´ØU³É\\\\5*\'pYÖà¾yWæ>iÂk®õ&Ó’uŠü±ƒ¸Û¸2(¼NoTÙ4Á¬0-¸£+sR£Úø¹,qŒˆö)X!µ_€©Æğğæûç5w§¦ê2Guy~HPl¦\0£‹®öÌL7™œâ~^òói¼úñjÜŠf£Hä¦Šº¥/™vqÂ}4«Z¯t¨ƒª%r±€¯µ¦aœÙZSö‰G\\|²‡é>4*tºŠŠàËD†ÅÙ3­°7&7[Œºªû2æ\"8\"ÜöK2  ÁÛÊ?ˆÔKYDÍ¾5 bw2MN9VdPì1Àa¿^•ITd<ŒmªçÊTWDÃ€Š†ªÛ+¼\0‚´Ë\nqÒWje»\Z=Êâ4¬17	j2âş·[5é‹1;•óQòÜ:WÊ€°­w©·ÏÚáO¡“ç˜­ñ±\0Ö`Zodw“öÏ‘³\0ÖÜ×˜~i×[ïMŞƒ.Úpk\\ãñækÃñİ·ßªçÇ××ÿúìS<Ùü)g[íó]¿KBŸôaÕòå<p€«¬ä¯¾şİ²ƒáÁÅ*£#½i’‘©ò _’ŠI\'àÃ)S8–nÈ’%Ö¯ßÈ’?\r\0\0 \0IDAT@ÛÄqu¯ÿ³\'=Ø¤7İì><ø¹ËœÓ…ÄŠZÖ}¦]?0©‰÷qcé8/¥—M\0ÆÈ¾CÑLè¦6raYb.sÎ%ËBæ›>¥YÎ³a7¸ç.£sÎ˜Jf¯%›ı·Æ¶÷ÅêûŠ†Ó;ôüˆï¸áÓ-)à¡Ÿ{Ğ–¸˜j#­«gÇ”‘/¡PQ½Däß¬\rÁíÉïÄ,Ek““a\ZÉiíp\'‚7î%àø¥[´³ïâvø=ÖĞà&[ÜK&w®ì(V ;Š³ˆP°ì	lA‹|Y„H\ng¢TÚ‘\Z´ÇšŞ²¼2!•…t½ÏNız*GNÇ½ûáZÙ¬Réb([$²ùÓÜÓ¸#FBrGS98w-š„]ÀÅk7¸Úy dáü¼¦\nf¥ë]Ä\\RæÅfç’ú\"7\"X	^ş\"@@\0u8’ƒ1@!>FÓpğEİ$6ÿvê:.^¾‰Ûwï#ĞÏ%ŠåCÙy‘“¤7D+O×ğ\'÷ÉmDÆ$Ó¥ïÃûò>ôÄ‰0ú°Á9Ù…d£mÈ{¼‹–lKt°6	h¼¥\'Q5gˆ7[iûå3]™‰lsØöù.ë½^Çí;wYoÄÙBƒQã_,nMòæ3MX!Êß7*c\nV,[†=º“ iÌ-8z¾Œ1ã&˜ø•aÂL^ápŞ5\n‹æÏçİÜ×(;¾ I\\½f-C”ËŠê¢ª»\n«ä\\æ˜ƒ\0uƒd¨hS(õXiøøú`29‹É‰9 m\\¿~Š–(¥c—BG5gKÛuãxkvµŒ.?Of­\Z!œÓ¶Æ”>­AbUÔì°®×ö+¤âŞ½{æ+ü.’hRfÉ\Z‚9r\"kÖlğ$ Ê½ìkÈü±“š»kßCÌoy/Î`lÍ_´^>_Ù;Ù•’‹oŠÖÆ4Jä.ÜM{\"¤bS†¾…ÓŞŞÛ’Û‡¯ÊœƒQá•Ï ˆüpò&Ú™8wº”eÉ—l-J·…¸R!¬ö\"rêÇºÚóË¸³­SÛNµí™‚|NT¼—nEcÍÏ‡±ƒûídÅö;w)}²²\nªÊKÖUÍ\0?7îÁ›šVD{V9ËG-ÉC¼%Ò>o>÷şàËHòËÎº ’ùš„’Õ+>‚Ü)X·÷<>]¶¿¸Â¦³àÂT\n‹\n% ^¹|èÿlC<Y£$ƒ\0éæãøÿz‘öş’°E¨ïÄX\Z“JF\nçôÇ‹­ê¢GËÊÈGA5Œ‡OZ€Ó7èfcxÑ$R£0°s}ïÜaw£°dÛaÌŞt§/\\×:°*âä·<)à\neE×æUÑúñ*ÈŸ1–V$çôûlÖlşî¾Y.ÃK“ããĞ¡Z.Lz³ÛmirOşwŸÃ8ñÛïµrüB1\'ï•“©naL~«;\n,duŠMvç†c×ñí¦cØ¼û7ôŠ\"±_BÊêuòBÈêƒz¥óâ%’ó\r+%9/³Ä˜*i.h³ß¤7©iãÆÊ›$`ÊV(uÔ¼tikBq#gNŸFÿ~}Õ{”LpnØ¨¦MÿÙsäÀ ¹_õ5ïÊUªhŒŒßVz“>œ6Uçm™2eñÚë¯C”şæ›¯±fõ\ZÜáKÁÁÁ([¶,4—/\\Äµ«—õ\Z/Æì”.]¾şú»˜y.İ_êÓlÏ¦ï7+ äÉ“£~ùòç×>§÷\"©ÜL$Òö\r¶!**ñÔÖÛ’¬îÑãem«ƒ‹æÕ«WIbïb4îvì\'É|óÆM«¹{²äÌÕkÔÄsÏ?Zµji\0ë±ÿHŞÔ”8Üß4á[>a¡*:k,M^6¥,’?k6No‘5ãmó=¼i·}	¬ØYÅlÊY„‹7cjœ‡ñ¸8­l¹RåÃhÉ\00¢:Ë‰\\•igõœÊ‰º~ÜıÈ½ØN	\ng°G>Òİš”`\0şğŞ[¶Ú\\Í’…o~²I«±K17ÏvBV¸$”€Í%Uñä¡Ì•ÈPŠ×S5ãõç£KÊÆâú–\0óÊä\rHğãËPbWH¬8,Ú¿=…-ù…%\Z9yü¸É• Ÿ¬QÿS“âP ‹ïôi‡\r‹cåß0ùÛ]øíZ8µIµCÕÙ«—ğœøT¯ğ|ÓRÛçq‚Ñ’]¹Ã½}ã×k	ê=Q†*!;ÔD¯µñŞ\'°‰;Æ9¨£xÉöBË\n¥»Œ(š²6ì»/7Bª’Úœğ½¦,Á×«O •cqµa»[ÖfíÙ1ÏB™k£!F±RÚˆ›0sÕa${ùªF#j.‰¨^4K&<‚!şô2¤Xáã…ûqêò}8¤ªÇÜœ®¶¡ÚÚ¢MHá$ßøp|Ğ¯	s¿¢TªŠ^™Øá¢Ñ\r2ó¾û–[Âúëp/¡éS«Vk\nş~–®_»\ZÃ‡\r¥ÀÅ«§ãÕ×^GÿÙ˜Ô®QçÏã4pàñfObñ’%Ho,_¾İ»vQ¨X¹2¾›;×®\\ÅÈ7ß$ÈUĞXâ\\<XS”_xúQpdSbXØ¡+½6/ºÆ\'Mš„}ûà»Ù_+.\\KW,GÑb%Òñ\'öåì™3xºE3Üâ¶&‰ô€õ&`Nò¡jÛÇ=ˆáÃ‡+øEÑÕ.m–vØ`•L\0’6‰æ•…€Øé¹ç0pĞ äÌ•ÇÒÖı¿üB/R/z‘Œ›º]‡g1vÂx§	Ônïîü\Z7V¾‡ì¢xÈìÍÑ²ÿP>­ä}$‰û:o„Ôyş=Îİ\r8\'G,€±Îµo­Ô„LYv\"ÃÇÉªksr“›,hÜä•Ïqú\'°‡™ÀÂÔ­U4sß}År=ˆ°Ôy´¬Â?üz	Ï²º|´o>*]ã²úª@‰Û[š!‹SUÉ‘ê]üÕSo\nÉÕ\nà_¯µg=R©‚æy›EßIëëÃÉZ–ÌAo¸¯Nq>z·£…ƒÓEÔ2y‰FQ7Å|H4;âP0Ø/?[ó×Ä©«|)r­ı!57,Ï“¥ß8¦ÜÃVŒÔ®&½Üq’$öKï/Å¾ËŒ\rbUå”’ãÑ¨B!1?b#ë³&{q2É\0U3“œZ…*AjÛ°‰qx¼||üz{”ÌªÂÙwúrÌZs’\0hH[¹€ç=U«Vîü{€¡i4’Å¯¿\\uˆ^>j\r¶GãW£X,ó<r‡úbéî³>q1÷*b˜\0Á4U=‚=6I¹0Q•Ôû íô@¨gæ¾×Í*æ¸³²›VftpîlÛ¶]¹\nË„‹ç~Ïİi2Mœ<Ezü»+ä½ÄS#7z4¾5S/ˆŞ¢™³f¡vºÔâ©Íp+K/ªéÜ°ÉãXÀ¨a‚áj]ë¤\ZB…J5l~ø!ôÕX1iBBB¨y {¶4u}q÷îmÜ§ibó+ù©•X)Äû¸sLOÕö·c>AR\0¦`ÁBX¸d)\n)úP€9Çíg;<ó4MÌ;\n0İ{öÄÄI“uÎ]8w©ÙÅ‘Z(Æ¢Š+¸\nÓ$ÊÊÒ¡	8Aà‘`Å;\'›‡Àv8Dù,ùì€\0Lß^Ô|2¾¯{{çàÚ’QÈáÅ²Â­pÄ=Äa“™}šÁ;TÒï*™ò•ÈÅß·Lsä¬ß^xÌŒ5|Ÿpi89³L}jæd}¶>‡çŞ]ÄÊèœØ\Z s›§[“’øpÀ“Èâïª:ı¼¨©+öZõÿ‡/J\\‡0QğËÈº©tusÕMf\rÖ;Ü=/Õ›š\r_¾f”+IÅ)ş>èÑ¯=W_cgmı\r/[89Q†” «ğBt×¥&JÈ9?—Ÿõ~bÒœ‘UX€Œ éEûÎAW¹hEn‹˜(&w¦:ú™·—¨dNlÑZªÑDœÍ­&Jq·¾SÜD«çØØyş“Nºdpå§‰àÁ	›$v®6+R5	‰!âÌåw~É²*9‚ä=¼cîcx§êx£Kc¦S¤ ×´ÕÜ«ø¸\r¡`]LË‡\0Ìˆ/7ãËÕÔ`ä9\n0òü$Ô(\Z„¥c»ÑDKæFaSƒäÄeÿ¸•¼äu\ZÀÏ=^ëÄÊd‘š¹Q¬\r+•¥\nycİGıQ8ˆ`Äš.b¦f|ğnäSš6nB­ãŒj#\nÂ–mÛ¸2‡dx‰}çgŸ¥SPhĞ°1¾ıFÀ4¨[‡\0sA¦ÑãO(ÀHlÍÏ?ıˆgÛ·Õd¿â%J &ÿ>ÿä_j\nÕ©S]_z	¹/ãMM!¾|Ê¹L›<	Ÿ}ö™z|æ-Xˆb¼VL>1sDE³6lù ïìG€)T/ùS\0Ó¾M+šûw4`&Mš¢&E25_1í\n.„giËbãÔ~	|B6‹8K¿<„‘#ŞÄÉ“\'´¹$X‘^¸jÕjè‚´oß/xEã`0×ßi0œd÷-Ãµy¯#7j“Ò¢ê?ú€I	Æ„51/²(&p¥KÈY¹\Z¾ÌÊ§ä¬2 YÜÊßè©ÚâC4-öÿ¿İt\0¯pÛ‡x¯l¼JuŒïÏ—ğ·qxµC-zƒşb\rE©dÄ±QcglÀªp›‰R¨ÉJí•KFvîìàÅ‚ÌÉÜ¼ê4ÕüıØ~â.¯ZÕ\n6£Ğ>–İïgD~V~_òã	¼øÁrÄûÉ\noª™‰;.•+¹ãar¸£rñğğÇqîó{æ\ZId\r‰2^¢G³¨2AÆß=Å„p£õ<¸Ï4ˆıg¸Ó`²¤AH‹à$Ğz$bÆ«-Ğ¹Q&y`Æ/ÇÏgÃ	`bªW¿&ïé•Â-(²ù¡vÙÈM³*ŒdöşÓa8ËŠú)ˆRB\\ƒ¡ÄòF)n9<ëív¨CÏ\\Ïé+	0\'É§`l°€©™¹3b&Æ2‘Ò4˜$Ô,šE÷üù~ç!ô°\ZîA¹]_z*JçñÂ«]\Z¡Qµâä<qƒûÿ:}ÛwgÕ}?¼ßï-²Mšà±cˆNàmš)³»\"\Zƒ•«V£Wp]ıô™Âgó¦\rèE2˜Î\rác0íÃğb÷:.B–7T€\r&QfŞ‚ä®¼°sÇO˜v\n¾¾¢­‘C †ĞŸ	½ûôE(‰bõ\rês¶M!É;uÊ$Cò’ãØ´ù{¦Fa6™;ŒæÚ<šH60i–¢©äê¢N–¢ÁtlÛZM$˜½z©c·!½wÊŒºŒƒ†Éè¼Y»zµrQâàGoŒ^}úÑÜóÂşı{`TƒÉ\0`ä^‘\'7ãÚ7ƒ‘5õ‰}áœñ2Ó0Ó##€1îtª”\riK2Ùb}r ¸Tm7ì\rŸ\\%iî›i®uˆ)o`Ì„>]¹—îé-ÎÁ;pò‹E67˜-Ğ¿z¶¨ÄI¦úıŸ?Œ\n£=~ñ&wÚ‹AynúíÏªìÆ%q#âú5±$›ã>6«pöír’³êéá¨û$İÀœ±/¡C­XÆ-G»¼·	şCpñ¤&“Ló£dnŒìÖÍi.	ºvo}¶\n?şv—}	P¢Sa@ûá@ I×~íª¡G«jô¶ø\"Š¬ïÜbü7[“B\rIÍ‘sv‚ZÏğg«`|¦¸tóºOX‰ŸÎğ¾n¢ÁÄ‘·Ÿâ4,›Ûk4 ÀbU|7VŒOÆs×1šû)ï:N³ŠÉj\"B¾±-^)‘x»[}¼M’¸×ôe`Dƒq1‘şÀØ\ZŒ¬Ôj\rÆwã»p¯¡­˜²è <˜$§æšÄ=·êòDILÔšæ©Ñ&/B~\nçÖ¨É‰±ÈCÓÊ•Ôde´6ıË7e\'	\ZÖ‘œÀÒÜrƒ\ZÍ°á¯áõ7GZÒf¶Û 3xà+XDĞ0­bı¦ïU¨åp$\'º˜HÀÌ\'ÀPàv3·CÛ6š³$ï1–YüÉ]Œ?Ä®Ñ–dÈĞô·L7Ó§OSğ\n	ÅÊÕ«P¢$½H\"\'ğ‰ $&’­ÁüY€Io\"M˜(\0“¹tÛ„…ÏT\\»†gÛµã†÷ç´=­Û¶Ã¤ÉS5HHŞWú\nÀ˜HŞô\ZŒ,O±wáêWıœxM5öd.²âÈ¤Ã6Ó##€1&é8&ÅDÀ[İ.œG‰y*!´fGd)ßAyÌ}hhadj\"\\á¡{=pîÀ[3¶ Ù?§’zRbARB)¼Ó×Óİè†æõÆ&åş^Z©qÉÊÖw/ÃM§’bqân*&³\r©y¤Š›\\b™Å\rs\rïômw:WÇŠgğü;‹ÀXn,Z8ğ¡\ZÿZ—êÖ¶SDXLnÎÜm\'Ñ{ü2µ-µÇzº$šVÈ…ÏG´Gî7£I¼,‚¤éóoÏÇ¦CôbøPÛ –$„³¸ÃÛÔ.€eïuÂ¥áè>q-~ä^;î©$qå[Â¡ÌÊ¿ù šW.o§ÂG·3ï²ûô}tù÷6&#§ä°ØÊl¼h(ÜËgå¤nè7m¾²FÚ+æ¼Õ`lÆ2‘,h^Ô,Œ¹ã»bú×ßãÓõGhšwN ‘r”•zcê€æ¨[*ÍU™‘Vúƒ€¿üÆ¶iÉÉX{5ÁYPó¨_¯8N¯˜ØµÈ§|üÉgÈMO‰ëqıúu4¢	7[3Äh»öíi|eùPµÃÁĞD¢™Ñø‰f˜GW¶p0¿ìİƒvm6A”<üı°bızº¤\r`üşHÁD‚ÏÇ\Z€ñ§	¶‰“ÅK˜@;£éHBŠò0çÎQÍÁÖ`\n)–©Ê\\9ÛDš(&’¼Y¼¬;8ca,¹³;™€*ÁŠ›7mÒÌt	6œıídË–íw©¿nsı\0®ÍèƒÀØœ*¤0¾”:ÿÚ¡È\':.†•PÙ!É7î%\Z {½îğcÚœ§a›™’¼²V)IjĞvú’­ùÉn$Ò\r­\ZùîğHòhBÿFèÕŒûæRxd­*)	!NåH—f^ \Z:2™­ê¢|Ùœ85»à§ã×©eD3-|9æ¢^CÃõ$vƒˆ\ZIïL=|Ò¿	ÖĞÜeÔ2ÄùÊ9º\\ñ,OLÆüÑíP­8]‹ÊËU9œüN¥.âZï-ˆtÊfÌ;4ı†´¯K›^Î•IaŞşø%,ğÕ68<ÅLS‘mHHAİ’¾øéÓ>¸x=/O^…m4ç”–sd£cĞºf(í©÷4‡0:òX±]9‘ÿµŸ¬9Î0»¢M¤ ·Ü³`=P+ñÅòãH\0Õô\0á``ÖŒéÈÏ,w²—)^¤/¿ÇÌ5‡è¢Iû\'$yªq«Ô¥º`.w|û›à˜S¹Í¼à¿”äXäJAû&Ğ³M]”+B½1QyèTF|Ú$³Ô˜}˜ö*¦@9¬ÑL˜K-À‡B\ZLÍä“Ï?çæñ\rÒJ8°í‹ÎGß½”“HâußÍ™‹\'š5s’ñªÁˆ‰tÉ¼b\"Í‰ïî—İ»Ğ¡İ3:ªâ}jödÌ]¸(sAâPL7F5ñŞÈ3W¯Û@\ræ±Kqé¥³`Îw\0Œ˜Hrd´°ÊÜ’˜›ƒ‰‹KÀË½{aÂÄI*¨2/eŒíh ñ”êl Yx=,L]Ü‘‘÷IBßÅ¬™_áğAj˜¼¦Û¶lÅ*ÆÈdW/’h0ÂÁÈóÒç\")—sÿ\Z.ÍxwHt+y-V„%˜çetd¨ÁpŞ(Ù¯Ñút@p®:t^­ß\Züí8æ‹jˆ2ß„O¡ÊÔ\\¢Á¨2loò%ã(†LÙM¤2áçBZúR3xã…šx£SM®Èk¶KĞ”Eu+[JèĞ¦#\"´Ü|ŠâæƒW1o#“ÎŸáxV=WŠ›¸rU`„h2Å®ì\\\"õ×ÇFâÅ650ƒ‰g0DÙÇ²¦bÑØ¨P\Z˜å™ ºW½Ç\'8Ë¨7	ÂS `“éa\Z×»1ú0ÆÅlÒ¥b¥ïãóM\'ğêGk¹»hòGÍœšÅ|°ë‹W¨ÁD¢Ç¤•ØNsGsª´ï¼–*{ï§Ká³¡­MT¤ı03Mõk69¤>äC’İ¥ÏÆ“\'€J²õçùğéœ­ø|ÙoHUÆŠàÆ]-é²_3ºƒ¾û^2‰#É!$À|¹Z¼H.\ZµZqñ\"uÃ•«·ÑñÍ9ü#¨1€Ñã²Ht¤fæÁ¼1OÔ¬TšU@]rGùÔg.($ª=œ38ì•Y„tñ¢…õÖHj£	”óÀÛï¼‹n/õĞbT2>IÔXúöé‰uägÄ[S‚š‡h\'yó0#Äş$³¯™Ì;`,Dcè÷J¼7f\\†íÒ3ÉEr=l€±5˜êE’7s\rÆ5‘„ƒáBÖ¼Ò„‰ulm(::\ZW/_Æîİ»ùµÇUPIfÂDBkpûãÅ¯$¡D/[¹š\0“¬lê›Éû{€acnáÂçt-ß<H9\"ÀXæMšûæ÷Ã“ÀèşO¼VvdHÑù!Œ¥‰ôvøfƒ{Şòx¬1BJÓÙ’­0Ï¡—ôá^$Yéôk9·æìşşjD‹)!Ù¼üPÃë¹v¡iú€ÇB/’æõ¨İ-MÊïÒ™´èdbvğœë,Lõåò½˜µšê\\4/”Ü\n¦ÉŸ‘FÒâáê)M#m`Ü	0]Ÿ®Š™Ü¿8#€‘U¾L¨eó19“ ˜Bî@ÚÅÛÔíËı‘/Ò£#q––’…şÙ	ıÇËOVPo–CVPHÅÜ]WÑoü\"ò0r¾1¸µ ½2^Ø5£?.ßˆB‰+°ı”¸?­M½ä¾¬î7øÙŠøğ•æ¦OÖÓºBéøt¹˜»Rµ#ùtï¸»\n0ß-ßƒÏ–MuS\'2&¨ †\ZŒš7ro£}F2lÈÖ`ÔM­A<|\"MªÅ‚±lì‹ÈìWìÆxnÈ~?EÎáÊ£{Ùc,-®Z$³ù¥¢Q¥‚Ø©>j•Í«	I2u“É	Àh?Ù¦ãŒEéÕ£Â®]U/I›ví1–&J¹ùû‰¿¡KçNêšAxéå—1òí·áo{ÌxŸÌ45‘(¤ÚµQ ójä[£0hØ«ÿ1€±5˜B…‹Ğ‹´øFx“ö­IÌ9ñ\"‰cHÜTò*0—ZÑFF_¼@“/Ş;17éM’ :_F\ZŸ”@Î*\ZY2­‚BÅK`ùÊUÈ™3§ÓñT^øüyx_Ù¥<•¾S|k±ÌlplqjgJ^)ÌkX’Ûe-Ÿ‚Pª	–‡[0ct$\\A•d³1ÜÃ³©íD¥rÃÑËáh9xÂâdÇ‰OSN]Ìr”Ïå%ã;£$77`b„Çe-Í˜Ÿ%6	£¿ã\n»âWÄz8•ëE–ÅeœIÆ;‘{û#oh²üYpñö=M%HQšİ2¿â¢Ğ­UU|9¬ùCfÑ¸Î([ ”m‘ªë’!J€aê÷ÿ\Z¿ÒããÆØ[ì`Æõi‚^-*rõ0\ZŒQS°`Ïuô3±ºU†é¯5˜êE½±ûKÌõHr0˜“Íš6WŠ3¨cL“Ø)Ãoº}…¾<wFK_B‡·W\"2NÔQ+âRà-æ6vÌï9+öâó¥Ç`L5FšH-jÂZr;f\n˜Êä€yÓ2‘œ\0c™HU‹eÅ²1]Q0Ô‹©IX¼ù£~À<º‰›_ËnXåT“UL4×8” Nòz4©BíBÀÚ®+‘nÆÊDµCæ¥¶Ë0š\Z+–/£×ÇEŠÃ\\š7bjÈyÈ&\ZH ¸°§MŸ\'l®¦¶}<`v¡=I^é·¬ü#ßz†ËL†ş¼C-NHŞ¿ÂÁdn\"\ræÜ©Z,J\\ĞÒß8î«]ªT)4iú8J–.Å”Œ‚aº€ÊSJ’õíÇ ÀBÅ‹ÓDZMwûŸ’õ—f¾Ï3›¹~šP\rSïÚÌ¿?{¤ò½K\ZOÍ+ÿB•\\¾)Š5€{h†nˆsÀp†¶B`\n‰?„ƒqfS[ÉuÜV­^ıÛE3K‚Ä„ä5“Î×‹z?‰!m+*Ãì¡Ix&5N¾dzd4ÿDÓÙ°ï#oWãJ¬¸é\"Ó­	\nDìÒùğr»úh[¿\nduÇ‚Ñë3~À‚M§\rIeÅ^¸“ƒéJSfæ«OeÂÁ¸£45˜Eã:¡\\şì\Z&[ŒÊÀ4|å+:Ïğ^Æ¨¤ó¿,<g<#U{5¯˜f\")¤`ŞÎkè3vb­\\#A7ºÒ«QƒÙ3s\0.`l\rFÌ9}hÑñú\\LéÓÔRÀ\\_´1‘Ö½ŠgGÌG<£ûì\Z?¢šói;æöÇç¶ã3ü³X¦˜\0óDÕ|ØH\rÍ€‹	r’I™˜Ê@»­ø’L²ÔùP`ãàÑDªN’wÉİ`„+“·¶‹nøÉsw`#É­#E£¶%›–wÖ@@áœ¸:1«¾uõ\\˜>¼]îf<38Œ×Æh0Ò®ïÈÁ¢é’%ˆ×ğ>3È/<Ù¢¥º“ß>Ë–.U“ |¥Êø”MQ‚¥ìı¡‰$L[’¼b\"I”ï¨Qïâ•Aƒÿ2À¸r0 NF>?…!ÛYäO˜HÂÁH ]||\"zöéÍ’–˜stÏ´lNÂûÃ%8|W/1FGJOdÏ™Ë\"Qe>˜|à€˜óİwÈâçûF´Õd\\Ÿ7É¿\n¨«$*‰ñ07uú“1HbÉÍTîJ\\¹BJÖƒƒIå¨,\0\0 \0IDAT©8²)Yäøe¿lM\"6•dÕ´‘ÌH^ÍsÑ7+\\ŒF¶aÂêıx{úz¤°Œ$N¥HPšäîÑõ*+Úìw; r©üğ¶rŒù`TçŒˆ0á]FÏı-=ˆ‹jE2W);¾z·;*¥}\'SŸ¼ÉıXz‚0ß*Àˆæ`&µ¼İ`26‘„D.Åö-&À”%À¸ÉNBªòˆæWšH‡&’È3kÉÁŒïk4§‰¤xàÀüİ×`¢ê¯( $/5˜½3âbX9c\"™6\nh	ÀÄâå§c¼y[œ•UÄ”¿PãØÎ±¥\nÊqcĞ¼¼‚ä@vÍ{c¿Ú`™HäÂt›P‰¦¹S4;I0Ë2%\'øïwŸäó›ôşÍZ{˜$¯ÍëğoŒ\'©^$\0KÆvgª\0İ—\\0¤ŸBäE$¦àğ©0¬ıù7ì8ÆÀÁHD¨R%ÁP\'ø9=P0(¿ñ4ZV)¬Óg0ªÁ±-4/œ§—¨=ƒ‘äíèÆø–‰§à<?ïÙã%œ=}JIõîÛoR›ñOuü#ÕóÚ3îD\0Fà·ß~‡\ZÌĞÿß\0#ZÜğW‡áÛY_Á—N©Î\'ŒkÙ‰ôó[úk›HwÃÃÉ	‰‰ô2]æ0‡)C^é£ÊbÚ\r2CÅ”Óâ;&&È¾Ÿ<{èàA˜={¶LašHKIòşi\r†×‡¯˜]ß­VòÊ$ª7c“6ãwHF6(²>=~º*7gí9_<$Qè^5?qÌ2/× TıCèq—¦â(‹z?7à_8Î•Ğ[ˆ^‘IÒPˆFm’œ#úµG½²ùEVu}†q9MÆ¬b:áØÁ›÷bÑgÊ\Z¬>FeD\"hÅãÂFÒõbu¼Õµ‘&úi#øü;óÂ<Å[Ïs~KÔ-;*\\	ÑèòT|%\0³ã4ºZ‚XÉE’giÜP6ÔÇ=K€aíQ5=iÃê÷!À\\\"#€)³	YÈÓŒïGïX‹Ê4‘¬—¡÷JÅ‚İ×Ğ{ì|µ-åøF¸Š‰¤\0C/’Mò:½Hˆq1¨W\"\0Ë¦ôAö\0Q eDdŒç\'\"ÉF|ÍGï\Zb[î+GR<ê•Ì†ï?í·˜È9mñA?]ÊŠÈœ0$Yó&aãÇ}Q&o°`ú^ä]¸…şnÂ÷û.2:ÀT”û’t¬Á8˜%ãº¢@ˆØæÂ£˜\"Z„ãË	t–ˆk÷œÂ”y[é`­WJ‹v\nä»\Zß¿!ú4—1Ê$’Wºà¢‹×O‚èÖ¬Z¥ÊP…Š•±vİz¢—¤G÷Áx0_ÌdPñ™ÅÉ¸LI^jg{wïD;šH¢%‘ãùö(œ1ÀØÃ¤ñã´òz‘ñ»†|Hq+&Íuœ‚·v_|ò1ù š.¡ø– Q¥juË5æ†i£™+ríoÇ©)Ú^<IçÙïQ£ŞÁĞAC°aİj]J1¹r³Ä¬tl],å9FƒEƒaÉ‹\0`„ä5\0#%3…ƒ¹©æí:>XÑÎíQ‹İ:á›¦3¡W¢É$å&‘^`ñğ˜ˆt}¤Ê»ülò71¥´„6ÿ%ó|¯RO Ïsä¼r¨¤ÁêÍµß½ÓÖ·‡á!h&¸Q‡²DÜN™½£çïb~$ÎQÀ´f¬Thó„\'YïÂY½ğ<ƒîº>]C=\r2èbØvŸL‰„¡5têò-¢;wÿÅhN*>ÁA‘ÌíxFonˆ!O×Ô‹)&nµS×¢Ğsâ*ì>uŸreìry§î<ÿ…–UHò6Çº§`bü„²\0†m,G3`á¸(£Œ¸·åB0\r0‡.`ä,ÍÔ\0LCLeğ`ÅæïºL\rf¢Sèu!—ƒ*°˜A4‘\"Ğİò\"i50Y˜Nˆ¸)±˜:´º=Q^\n»¾JÇù_‹÷`ì·ÛH<[\"½*mr^íXã{5ÂÔ%{ğÎ¬Ÿè,f¹C®Hš*%’îa\0³›Çôm†@1©QDSË˜»éFÍú÷ã¥´Ï•ä\"XfÁW-J\r¦#s‘<©Á°²<Ûç-eNe’Ğá_øÙ¦©wyk¾?x±?$¹©›#³!	c{ÖÅÖ5èvÏDƒ!ÑÆ’~[½zúĞe+^G)»ğÓO;tâšae*VÕ]	¤\0Tú#…šWƒ:µ-7u2İÔMÕM-šÀ>’¼ÏĞkcŒx©P˜3:l€™:y¢¦È!nê5k×¡Dé²N-Â…™Ì¢TF¿¯ç-ÑÅ:?ç</}T®¤‘ÌŸ7oªäjLl,z\rŒ~={ãÈÑÃJD7¡›]²Ä%…AóŸTë·ÇŠå,âğr÷îŒÏYF‹#\0“3gÈ¶%¯Ø\0C9içR2ÓÖå{Ì/³p}Å¸É;£ÇT9á\0M&µ¾r+ÃxlmmD¢DˆñFŞ–o °Vu´8í“‡hC%yUt,MÆ¨ñÂiF©ö™´;FĞ=%Ñ²’\rÇ3ÅÓÂIêF>&…¤kAÖiZ»4ªVÌ¥µC¼¨mÄ&º³¢]ë°„áĞñ‹ˆ §ÏàŸ°Ût[º\'hı	åU˜yÜ¸R,İY8q¥C5„Ésw2¢x3eLğš<WÔ¨ø(tiU³†>…µ;O¡Û¨¥ˆa%.cÃšU!3€‰%ĞÔïç\n0¼Güá\0s}Æ`R…\r‹Ë8‡j.\0#\ZÌ61‘,€1ë€Ú€(”Œ×»7GûúÅáGJÀâ-G1nöD¸±İô\"hR\'`™9’ğÍ(&VÈ‡¯¢ÛûK€HT•Wf…¸í“áÏ$Áj£Mc‰ªù­Óø‚’7¨ùyÀ6q2‰x\r	+a6õ˜Î¸v;ÎX‹ŸBİr…êçÁÀDÙ§ŠnaŞù*ù¥ÎCf1À1nôl¤HNµÖTH\"¼Ï$Â½2Q¹Åµ)ğê2	££\"Ğ ~}Üd”ª¬ì_2îG&.]º„«},Şzo^}õ÷Ş%oif0Ô`”ƒ¡‰ä\n0ı)Ğ˜ŸŠÑï½ëŒ(–Šyµê5°/«ü\'ÇlãÆèö\\gæ/ùké…OµÂWß|«5y\\Öm¾f£qGÜ¿‡V,¬u†ÂÛÄ‘S/Rš~¸ÕÈoG¨–U·^}|üé§ÈÍNíÇùS\n>Ìèä¶Z#F2¬m€\rÆ	0L iÇêvMŞ43‹ò‘E¸´`$yÅXİ6V\r1iİÖ)Ì9K&ºk\"«X#\"ËfABX:g\n›¹1ÉÁHş¢(Ñ÷3¸å¬ÈÏŒe’‰ÑŒafŒÊ¥jšxm™JR”ÛÛ_ÁÈVã@X‚‰¨áÑz¸BÈXYÏb1URÆEÙpg+d@å¾nŒÇULT¾‚Ìñ9sş6AD^Œ	×2Ô†šT(ˆÚ•Q¸ëÄü|ô\"M#	ãË6hqqªCî[ïÔ¼,¾!á¸–v/¾½1™û€1’†X¢\0snj®4fP¸š=DƒY°ë\n½H0¢Á˜€%7j0®\0c4á`,­H§¡œKæ8ø2ù¬(3¤øL)uùv4âeï\ZËa¢«ûæÅ`·—Z”Ä=ŸDÎ@jqáxiìrì;Çt	ojxk¥áÊäÁ{‡ú‹fÀZ,÷ÉÒzIÅuHUVLJËÌs£›ºB!škc»`=C_\nÿĞ¬(”\'e\nç@ş<Ù‘58Å­â°ãĞì?umÑäS/²{ã‹7Ÿ¡Iœ+Ó\\$›ßWKa~M?¬\\¶T§\\¹rÌOŠb‰ÍZUníÆïQœŞ’Œx»S$ĞÎEƒÙ³mŸI˜‘4Gş³aİ\Zô£6%s=–ZÆ¡C1œ)’im4\nÃ‰Hà[“õ´®ä-‰¦ñŞ£Ñ©sgæËqŒ-SNL¸3§Naü¸±\nJR¢B®€éÂº2ï¼Ã6õ€Ÿ¶|¯f†h.~ü1‹™¨™­\\-#W¯\\ÁÄ±c±‚¥!$‚ØÁw›¿ËrPËÊI2ø\0“ÕDºAÍR5–k ·U54}QL6=»¾ŒÔ•/	\r‘ù¥Å7ôy”M/jÍÔ^½˜ô+‹–ÑË\ra+á&\"âñLØ·jÏ#ÇÓ#èhÀL“s”Ùñ€ûM.“\'X³«‘ğñT)¶³ôÁ;,~´æ\r¼YYrm$&_:¥šQ‘Ë¨àŒFÜš7 ?3$A>^hP½$ö>‰‘üœ-UQÀMÌ\"\níÆdIÒ\"!ìÎ`®ÔÔx\n•FµÓ¾Qãiß´¾#á¸a×j04‘,\rFó™xÊÃ4˜À¤r¥‘Ã7|Àì\rf>¢,Iµˆt\ZŒ«‰$ÚÒf@-·.u¾L%›…¶bpTgPöæ\'eÅ˜1¢ª±ÊMŸ(Vì›0ÿ\'L_x±Ò^YiÌ½ÅGàš9ªŞ2Ó›nÊÜ¬÷Be‘f’è#²ğıp5¬X8ó>xÓænÁ×ëS^GV5IfNÂSÂÂ9©¥€¦ùYÜäZJ†\'µÆ­*à½#Xªïe’Mm¯¤®q©œÈ‹hà¦i’Ëb8ñâÇã©§Zâ«Ùß©»’övÙo©a:ÉUƒù3\0sáüY´}º•V““#\"»3’¸6³¯Å•ÍèëòÜØMªà}<}\nÆÇ`r?0|¶S\'Ô¨YyòæÓº.¿:„\rë×éfqR‚AÌ£“LHHHÄóİºaÊÔ©øœÙÛïI’—µ…)Õª1……\Z[åªUµ<…$xîçG’õH4 )P%ıÍÍrk×o\"0åâ9&ÙQ\"yenµ§‰4ÖÚUÀ	0|i	a{qéY“nr*JZ‰•Y”•øl¥³fDÜÇ¹½ZôÌzÙFv™ÒXç`\"q>ähõ&‚*>£Üi\Zó{˜yÉ+ä¨L\"ì†–©ll3\"?¿t/cXÌhÅ¶c4[˜“àeˆU7­âo¢ı¨â(jê==q%îlQÚ{¶©Îz7°hóq®ÈYå©!#ÉñpÊìóMˆ‚S¸HN–rŒ¢ºæ«iZ‘Ÿ¤p&:.~¿-6±®IWj0±06AÌv”#Ï°p<9˜ür0j\"	ÉK/Rª­Á°mA¶Ì9ËD€Ñ ¶:3ÆÊº\0`ÑB„Ğ»ÅÀ)ºJBíB)^Y5¤ì¦Vr7Äuá`şõÖhZ©ˆæ‰÷&…Yj¿]¿‡şôbı|â&s4évUU€Tb{dœh®Ğ‚WÓ¼ş‰Ø£6ì¹€mûÏP™1ÛŠÊ‹-•ÏŸ°–ÎÈi¬]sE´K©ÎfÈ{®Jü:\rmşÍØïä{b\"X§&¦¾Ù¥ór…æµ7DK?ÅlP-F¸,]=Z£¥/³‹¯^½bæï!±+Ÿ1­aU{€t¶½íEÊ¨\\ƒ+#|Ÿ¸©ÆÁH;åÑÇ—ÂV«V®TW<Xb*1%FæbVºŸ~ú9*U®DWzİàmppÿ>S<‹}’çHÙ\0‰Ì•4…låŸMbvÅ²åX0o.´m:¶Ç\'ÜÆE	[µh®ÁuRJB®n§H‘\"­`Ü¼u“Uö®1¢÷VŞkÇdÇéŒ	°ÏF`Y½v5ÿ‚Àˆ“–*0^\0ÆUƒáX;ÂOâìç/#Kôy}‡É¢•±oIÔr–C‘gŞ€{Á\ZHøm#n­xòtİœƒ¢PÈBnk(–R” A¶Eë#w[VÌñ˜!39²«€0¢”ĞĞÅËÍªÊœ‚It‚Öì=‡ÏVlÃ±ÓwÀí„€”[¿1làÆHr®W\0šúèûle<ß¶>Şûh%Ë4AmÂ$^ãK0‰w#ÇÁ{x‘øæE/µ«E´¯ˆ7\'ÎÃÕ[4¿¤†\nİÉîøjÅ³aÃô—ğ=Kböµ^$€á •%É;ol\'”&Ékö;²¼HìF“~3Hò>h\"e!ÀŒîÛ/“äõ¶jt˜^3fçEôg“¼b¤J9˜â¾øù‹ÁŒäµ½HÉË•XE³…*xŸçêh¹Ê%k÷#‚$¬¾<$kU‘¤Ê@_µLŒĞ\n5Ò+¤Ö×\"c.zÈ®Ó2a¡º–­:³\r„–1•‰yCşRStz¢†L\\¢<›¤Ô—A¡.šË“™ÌøÅÂ±óÈu$0‹›Şh5©RE“TĞ†ïË[´0Öş	ğóD‹zatŸÖÈÏÚËÎˆíLã`Ì$Us[ ĞÒbïp_£×÷²‘É…R¿EJ/HüÉÒ%Ëƒn`\0l’Ñ€!%\Z˜ì(Â)Â-&Ò<É¦f“¸©Û‘ƒ±ÁJ¢€eh—f¶¥¨7f8ë½œ;{Î©9©ïB\0&{6Ìœù5jÖ¨¡Já‘Ã¿âõá¯ ¨¶!12–/?KŠÃDVÁ+_¾<>xÿ=|ûÍl\rıoŞò)ÌúFÜÅŞ,J€e ”MIÚ#Z‘ÜOî+`[‘±@ï‘ğy’•ûÄ’‹–.×{Û©²/’h0Bò¥W,(ˆ;X¦fûE_ÄùÏzpÙºĞĞ/·Õ»Í[ğÊWÉä2iöşÜ^¸wvå/NwÌR·9_²ÍÇ\Zº©=ä\n³7Œ,úYµ€Ò´h\'Ö¨&në®™bĞïÖ$]qìªùš<ÅvHjü6–S8vö2¿ë÷I‚#‘¦ØyRcÔÇÇä\rrû d¡ÜÜ›:ê—ÊÍ‚Î!êJÅšmèN=‹·bù{<Ã¤=-À¥†¢eƒr¨[¾K¤`îÊ-cªN*™|9¹²øaX—&8uå.¾#Ø%I-\\+ŒßƒfHN*=:°¬¥x¶ÌUúwÙ:ûÓ¹kqÏ”2	¦)	Sö±U“*¨[¡…Õ€£œOÖ	ÇÎİÆ‚5[ÙHŒ«Ò|dûs¿í!]Z‘4\rg İJüxü>ZT}QÙx®nC;WÃÏ7À{2óû®Şà¦°Qr\'E¹ÍËãÕŠj]àìÁj\'›—j™©VAriå™ëQX±ı 	÷ËOd¾‹Ä²x Cÿ+10©MãŠ¨üX~UsWoİ‡~9ÉZ¾âj6flnotk__\'İ®#—±çÔ\\`ò;QIˆ¥)&#e&}½S‘-Øq{ß–Õ‹£j¹bÈÂ÷¨{1É\nÇ¶™tÕ?$S3ıè¶pÓ4;ò¶R¥Jx–…¦ü˜Ñ!Ú³\\\'Éï¡,]º4zQ ?Ç2š_|ñ…^*kÙ²%š6e±ê{ÚÛE¼E£šGMã(É×XÆèˆ‰æK°xÉ’À\ZÀ%ù]WsŞWÀm‹™ïÙ³Ç´ƒZ€dî¼yP“µså¹…©È36lØ¤5wå(ÁBV/3ıAøÑXO‘«YÁò¡öí×ZÁ‰$rıXÜ>ïS»vm½h*’›4…;HlÔ£y›×‰fs‘5qæÌ™ƒˆˆ(m[UšXÏ<óŒšp6€*ÁxWh\"y\\İ£¾Ÿ(ò˜î¥[ WÓ—¹›#“%¤A-Ö¸qçær?ë»ÇXÔ]8\Zá_(ªeŠr@ òŸS>>¤4\n¼ğ¼6Ö9.æ—H–ÙNH`«¬®+‹$¥‡øV¨‹ŠK¢ç\'‘+×[1øÂ¤:º/kùzÒåF¿ºĞ\Z®*!×ÂNH0]83ô¤fªx&‚ü¹_M‹ózvB.AØo^§ôª(–&ïGÎ@/NÌ*k[Fõ˜èÏ$§ø|)–£±%:R.›ÀÉ³EC0ŸÉòb¼È	yó-(ªflƒ¸ìâxh&¾GÎ×ºü¢)xéN,SV³\\Í.%¾…ÛaBlkØ–Çä~-¤Ú0¢9Fw#bµŒ¤Y(ğ!ÜŒÎŸ\ZC™½”ƒ%mX}AªKI†w\"Ûsù\0ÑqmáºÄqæ.	¡A~ôP™ëeu’ÌäÙKH°Î\Z7¹Ÿì2 ÆwÇ~EqGÙR&6–¸Zeuõá»\n` ¶Ï—Œ½¸¯eü¬m«mÊñC>4UÛd¥¶…]J>˜º¹ƒ•jA²­ÚÖh„+µé-Ir´M+	ù[f\0ãj†É5²“sLt¤¦ÕIÖ·˜1\Zn!š¬šxRšŸ$|µ˜9ç¸”Ra¹KáeT³±L<×>Ê= Tôã	˜¼VïCH®ñ¡ÓDÌ2¹¾(™–8È~Ù®~/jî¦f5‘‡=¶Æhú-ÁšQ›Õ)g6ĞBÈ¿z£î‹ğ)ÀG…!~ÙÌO2écupn­\Z¿$Ö&¢ãÁƒ&µ0ö#¢ÊÉŒ±ğ‡Gáj(ĞõÖ¸–Btb­MÓ„eü›\0c¿L»#N¼²°„Tûg=PGÔÀ›Vi„\n²¼Jª4¯Ôş§Š÷JKı@Ş©ğ]­]°^ ë$1İ¶›âkí¤¨¨İç‘ûZŸRH9\"óÖÍ7m¦E;i—4kÙ´™\"gNÕnXéöÒ>1%iV‰ççÒm+éø=f>˜ıŒtXPzhç*˜Ú·EÚX8ÇÊz†Z†X—¶ãTæ–Œõs«¥j~(Š9j5Şê‹½YM+§H€Ğzbjÿ“LQ…åYÂÅ¸NÙ#b“ç%3`øY¿üéo®ÊszaÏì&d¤JŞƒ ä:tß+¿IĞËè~öóõ=Z÷sm“§&îJ°¨Ë|ÓŞ[B`ƒ™}®}“oÊ¤#NÙ±îëzZú{g8×3¹îA“ÒøQYY	W¾îƒ¸3»‘£i?„4èÂW,ÜÙ^g†Ô¶4TnØvkÉ$XÇùÁZdJ–H#\\êU#—ÚâÉ	†´yÁu¸’DôªÜ™ˆğ?È¦~ø<ÉÈ²Òy®h`®Á²e×šóú¹	ŒU‰ÑÉieöaA¥î§d¹È-RÊ¸ÎŒP›ç±FcHØw2«¾,h6‹Rd•	£ÕñågK¨©¥¨£RëzOE`)ŸÙÆŠX¯†ğ6\n¡¼DùL4*¥ÅqîKfÒMıãñ}qrº–ï$3P²©û47Znx%ÑÈ2&f¬XU™2z‘ÁE]„ô6õiÌç¦\rÎYŸÚœŒnkİÃœo¾t—Yµ¤×\ZÇ${2.¦B‹:vòníKm2N‡Lkò:_l†?<°@¤Úô¸š5éÁ•¶Îˆì{şyfÀÖÒíyûğşØf”ˆ5ê]á\\Óœ‹òƒge*ú]€Åõg×«ıW*ƒ3Œ¯çìšÑæKÙkweÊ5™‚\Z\nÖfriŠ.g”«¸Ó›qk13Ùc¯j18S~V¾s/({¹’yÍõ(†Dqşç&Ã+O9c¶À1Ç¿¡Ádşbj™†\0¶qÄz–™ÖŠB¶hÚùNÖïªaÈYRdIÚg­üò™­]èwW@²´ñÂˆ÷Åş›%hFÚO¤WYÂBn?\ZsIËrêÀÊ½ÍÊè M*ÂgÛ­¡WóÊ~ºy®‚ UAaˆ?ë>zNXOĞ…Ï\00(i€\0LçŠ˜Ö¯™yªN#¹fj+\"VU\"ËµVc\'r[ƒaÀÒRÛ-óNÍE3f\n¢ü® ¨ısêt†‹ÑQšÀ¬hë|s–é6ÂX\0`×í5ïÚ\Z·¿FÁ8å!£ù”Ş{dŸœÙÜK¯ı< …˜•%Óãa@ck6®\Z…ÍÙèHZ÷~Ğ$ÉøQ¿çÜşıùGf`’ÑÓœíÑwË/fÇ„ŸO–Pag3Õ#-ËBŞ Ù†ÇZPÄ,çdHN¸»ë¦!âÀ<Mü5ÓB CŠ{›ic\"ìI‰¸À·ÎËÈùø\0Ö¯§9i$CÏÿË$oú—§·WEÍÈÕ9laXÚ*ï:±U“°FÆ‰ò\Zc#Z‚öRéú“ ¡¼T#x\n.â¢g\Z5$íÎºÒ›µÚ\0‰‹ïOW\0³z£aò²º«\\Z+µÜK…Ş¬$v?Œ¶!ãy|9X»Ë5lcJCªDå\n&6NŒ04‘Ôá£€j¦ñ¶b\0Y´w£ò;GËÆMí¯Qƒ-¶AÀ	´i×89&­­‰º«€®;qZá. ®ğj\r­S\\5~Á~W2&\raÒmF\ZHzáQàLg\ZüÎT±×º83°²ïÑ=õ½êsÒL#×óõ\r¹\0—+À¤¾õ\Z]:‘¦ÿ\\ÅÓ¹¨¤…Ì·ÇÂ6éTÊch2ºË \\09?M©ËCh9BÌ{5‹ƒj‰äÅ_û—æ¾ p–9eL›£ĞÔTœ#œº@‘‹J`\\šGÍÈóäx`dû [£şË\0£SêUÖ†\n•7\'°8ç°JÒVÎ´—åòT>¬ék©>.w6\'şí]¿kA(ò4ZÈS“Â &`!R¥€I!±O-“ÂÊÒJ„ˆvşbç¯ÆJx‚•¤±Ñ\"ÁtQŸ/!!‰`ôûfæîö.Gî…<AÈ¦—ËíŞììŞÌ7³3³¾ óÂßÚõ”&mrfDÖÖ>PÅ]*4ıZ{7J2ú%?N®?µ#K_×NñR\Z(¡óæœ¼<}áÑì5GhYªÉ|L	Àpfæ’5åµßp’¥oT”y6˜ sşÏŸOÖ;ç!09T …Œ[v®¡\"ŠØK(„¦CÊw™ğéDÀäû±Ñš®rtX$^Ù·¥còçs|+|áXŠı•)òŒ¶¤mQØ¦F•X²†ÿáêueaëÛêCSş†âiÏ?“o¯ÈHj\0\0IDATïK.İf>¢D.OD=‚¼¶m—­£§¤6yW.O ²÷¼\"eó£úÚQùï¸„™ñV52Dƒ4}”Ìœyğ\\\ZŸÛzœİh¬±³Ù’;8ĞíáíëŠÄè·	½ê·Ä\'\"ş-Ì/—¼¨y£)ÍWs²ıéôÂşgä1eKºöÊ¹±›Ò{a!ÌÔg¡o*+ôÂ\\\'URQÀteÆj»i×ü¾.Ÿ¾•K«º-®p‘1Hi˜\Z¿\"·PHœ³”öU\Z¶+ÄÅN\":ä\0\rdM|ts‰şÉ­/ïdùÅ=©ı\\„E„U~fPNßúÈ”Ã5²€QkkûŸ¾?L‡œ¯xÌ¶‘ÁVL“3—Û›Èÿaµ}3µ¨(ıë\'KŠG™©Ã˜İP»;Å^\"öÏ³glc€ş?õïıjÉÆYyªzı—äìØ´Ô†F´‰Ø_ÉæZàÖ´›˜Í#‚Ùÿ”· _h©ÇÒz2&¹ê×±Ğ4›“ĞßÔ-\"b?‘ä€›7tBYz\0Ë1 ¨neAZ‹dàòUùsšÅ±€Àµø7f™h¥±P¤Z\\†Á¥\\ä{¼v@:[s‹8°	1¡ÅØxTš³Ã%\'ıÙîoD0‡m­üÏãÕŒ1ìY™Zú\\ `Ôæá®ªl)ùz—ï‚ÚßuĞ?øËbÇş¬&JìqÉ >\0\0\0\0IEND®B`‚',1,'2015-05-19 19:19:32'),(7,'la cueva del  zorro','la cueva ','comodidad y discreciÃ³n ','12123123122',0,'2015-05-19 19:46:36','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0d\0\0\0!\0\0\0/w‹\0\02IDAThCíYPTUşwL\'|Eˆ‚/Ò°¡(JGfÈÑi°,-S|á,¦…Y8ƒ3>5_ãd¾Pò(6ê„S:N–*„Z8¦‰*+fÈCeÅİşÿrÏåìİ{a÷Æ6ŒsÏÌ7{ÿùÏÿİóŸsş5€Ú”mJ]Ğ	icNˆNH³@SGß!:!mË¹¹¹¶ÖÔÈh4\Z:tèY­2µìƒ8Y?qÂø»A\n¼&Öùáoâ\"ˆS,óaˆbÄ@®¾ó÷ı¹º?0ï‹è¡uaÎŒkm2ØœaaaZì*×2¾(~œ–³cE…X»¼_¶S_V?óİ‰-ŒsÆ¶šú4GÈÔLĞÓüÃ#\"¡‡¯$,™[Öl\0ooïfç³ÙlcÃÃÃiQª5ÙODÔ HSfpæ3D¥êñ·½˜¿Š¿\\?¦·\Z‘ZÖåÔ5BˆŒ;Àò…ÉàçÛfÍıjëj!35nÜº	¹§ó`ü˜qªsüß„˜QrIw#8ÃÊ\rê‰mƒäªÊ½DÂˆ8J_#Æs«âw”ëÓ8eY”™6k:ìÙ–ô›y`|Ÿu²sƒùvdlİ%Ì´33\rfÄLW5ó¦*»†ÊÚ\r³FtêĞ’ª®îXÑP¼\\fÈ·°òGÄv„IìP„¿t^°y.c~\0â)‘u‚ô+æ#UjišÚå„444Àc«Ú{y	„Tƒ:@;Øg\0\\+»é);¤yb?™	é[šÊ¼{nÔ„$´‡Ñ\0Íµõ÷ÓB—ƒ#»4ksW	yŒ2ÛÉVËìğ•ŸT^ƒX(áÛYŞÛè`\']X]oÌÿ… ]æ¶$\'dÉªdX˜,ÌWV^IX9*Ìf¸x©2RvJº[Ûûe†¢nå ²K(ì\rg^\Z ¿ül¾Nß!À7otSµ»«„´d2à#®}µ\\¹#æïseºY]‘	}Ë%r[nMrBfÎ‰ƒSæLÙ™\nùgO®Œ¥Õë×ÂÂ„ùŠú¥•Ö	„¤\r¶7¯éä}0¶oôZ‡¢|mßÚ„¸Õ€­-\\NÈ¢•Kaå¢e„ìØùçÎØgÂC^y‡ìºVæ.¯@jˆÅAV\\—TwäM_ûë„p&£3„|¦§İÎ›RâŠÅp³â–ËŠgw¦ğı·_­†ÛHˆ3é»Ñ~vè„È¬ÆnY|uL\\,ö„eóÕ‡wFVµwê•*§	±Ùà÷Æô”®dZ	¡Ãİˆ —z4‚nG9>AyêÃkc‡·|Aü¡ÎÚ.`æ%±À_«ÕÆRıY‹­®Ï&Ä^ÄT®ÔŞ!¦Ù3ìvOR)ö\'rOÂ”	“T	Ùzù.ÜîìÜ!!ÇÆH<h!D~“âSºE±ös˜¡/ŸSéV¦Ö.ïË?6)ôB—zñ€ÉR‡æ^êÓ>1¦@æş¯`÷¶]Pu¯\nâ$ÀêÅŸA€¿¿*Ôré˜] ä§÷zÿ\'BªqÎN*\Z±¶xl§ıı¬Â×­•ŸQ=D)ÑìŒ8,“¯ôq‘c¸¾NÂ:U×ÔÀÃúàÓÍ0pØ,¬qsQ%ò²]_Û£z0x6]ƒùÆì÷ûj&ä\n¢¥:ñ—®²$ğC½7ú \"è¡HéEÄ«ˆ=ˆrD\0§½ú)E©«8~×ÎvÅ)¬çêY˜†ªÈJäBy¢)_Š è\0%š—>k; ¶Cêş)‡äU¹é\0Ö­[gWn®°¡ĞŒ.«‘GÙè1/d7u÷í“VØ\r?>!P3!¢¤çeÊĞ{Œ¢æ®øs…†BPt˜È#¿NaJ\'¯#(I©¯XÎÉ¦6~.Š.ÿ‚xÓKÉ­:Ô)b³ÔÀÜKeKlœrıú/ê«æ¶£÷3`9…Ñ¡3\n1Æ^Áà5½•ñğØ_3!rcĞÃÜÁç2#±ÅÃúí–n`†¾V¹H½´(D/ŸÇ•³†ñ·  ı] —\')#\'%>¼-¾¬óó¥>C†ò›6mâ–¡M>Kàîî$UY“¥]bı-a”ıĞr¨Ó`ö¿‹ùoEÕØN¡\"»Ñ(}©,ü¢ÔF~‚,B1/~\'ÊC6tx“ÁY\"·É\\(…q(øIi$‚âkthŒ[´BCC…——\'õŒ†ÒÒR8ş¼KöR’5lØ0A®š,—&hi1OB{HHˆ@HRRDEE	KŠˆˆ~\n\n\\²“•““#]Z’åÒO‚ÁYCpp°üÜ£aU………tñp:¡Šå±¿¤qV«5²¨¨ˆŞmI\'DÅ¼AAA)ƒa_qqñd§™°ïè…²Èe\nÉb±ø•””ğgª]oVv×0wYV£\\†s×0wYV£\\†s×0wYV£ÜÙš3@LïÚÇ\0\0\0\0IEND®B`‚','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0\0P\0\0\0Âòj9\0\0 \0IDATx^ì]`Õ¶İs{¿é	„Ş;¤(R»RE@@EA‚Š `yŠJU±\"b#VTD±QMè\0{“ÛÛùkÏ%ÔÜ |ıï3>^ÚÜ™3gÎÙgíµ×ŞG¢ËÇå¸Ü—{àõ€t‰®{ù²—{àr\\îºl`.‚Ë=p¹.Yü¿30¥é_Í+İ¿!U±o3©ŠsIçr’#ºˆ¬7¨IM\n\n%	üW\"ÔÒÅi[“Şz™-Mç+c›L¼doâò…/÷Àaü¿00é÷)Üğ{ZìŸÉL%$ˆ‚¤ƒ!\n)|D>-í:’®„ÁiC¤öëIafDˆÏ  :@ò‘OU¼šd©ÛÇ©³Öª.I±%ÿ…câò#]î‹ÖÿÕ&oÍr“;ããÒ¨Â]¤ğ”Ğ˜‰üÒ†¹ÔJø‡‚TA5…Ÿ¤ŠÔNAÅæŠ»MKJ¿:ld`X$EÆFMJ%Î\rH(T*5 eÂ ²6¸1J’êÛ/Ú¹|¡Ë=ğ_Ôÿ•F¡<şÑ#¥bû·zK¨„0ğ~ˆL\nşI]øG!HÂü£FG•D\"›>@‰ıµDR1)‚zŸ …ĞS’<ùêƒ„¿+\n©D‘@Á¨Û(¾ÆğÆ’¥éŞÿ¢±qùQ.÷Àßîÿ:#ö¯i±gùÓÛj¸ö‘äÕÀ0(H)…ÂB¶2üŒ‹l`Nüş9\"•GKvbûÅPØ€rTø\0Ü%ÙHùÀ`	…ßëğkUˆ\\\ZùÌ“ÈZwÀ>yÑß~3—/p¹şzàÕÀø=y7ªu	ß]ª~+İ¹¢…ı“™Û¢<‡I²†…\rC”°i9uH’ãÂïAêÂ°(^¼ê yì6É8ÕTUD5naå¥Œ(IàgØ	†&ˆK+ÀæîWK“J´ÕHİd±Ó“bºTÏyùº—{àÿJ\\R#ü`µçÚrV½KQşÃd\núÈÑ}<%İœzIî{ìÅvÂhƒ[#»BìşÀ œçMÀœ8\'|n\0®’ E(üä™à&5\"SËÎä	FÕëÙM9¸ê°%°.JÜÀbÄ¹Zx\\AÜFHF(í0N0>RiR®éJj9üÌ—ù™ÿ+³ár;/z\\’‰^”±bkñWïµL*ÜOj	¤†RÀ%QG%H«ÒãúÇƒñ]‡Âï¸xÇá7Û‹ø¬\\\n`â3d	»?ì•ÿˆ8F1\'$ÎA;…F#\0·Šù\Z¿êAITU‹,ÉŞTj»K¬˜§-ı’ŒT4‹ëä\rYe·K¡ğ‚³QS@å¥u27šŸQ22^Òl¾xO{ùJ—{àÿF\\TS˜ş¡ğ}1—|Ò°Ë¡”H\rT„	Â]Ñúµ$©ıĞšÀ¶Üõ™›ŞtQîìı‘\"q×ŸäR:IÀµÙ+Âd/ÿßòl#¡M!DˆÂ¨> Íp£Ü\ZrêŠÉ<@EZá¥Ò@sÒÖç5U¨+ØóšĞå½Ljá”İ(Ò\0Í¨ğ<\r\"MÄ×T©¨4á¡Pl£ûáw]>.÷Àÿ¯¸(¼4ï/Q°èŠ±C$F·è@\0»¡’9\nÄüĞÂÁ!ò“!ábu™&¾³ĞßväßérÛº¥ÏI«yLá‚Q!\r·EÂÏ>Øà°Í)C-e&ÄQ$Fògğ=ŒqÔ	ş’„0µÈÆd7’s@	é¢¼¤vé) 4R©:Štµ&-ÔÄ7yË¶ÑzkŞ029Râ™âVHĞ€‚€d ¢¡‚˜!”ÔjÎEéï¿Ó_g6ã¯t±{÷n\Z<ä]Û.æs^¾Ö?ÓkP	‘©Ëúø%wtúp…LXô½äÇÄTÃµàèàx08\nÂÃ¥Ô›bI{Å5”põ6…ÙH’.9úï>öñY-EL¡ƒÜŒ–Àºáåœy9Ô”FV\Z|Îƒ€–\"øìÇÿ³6F	Ã(ÆOJšJp^ìP—ŒNB t2Vr«KÉ¦êA5\ZµJ±Jır³¨&vQ\0ÆUW‹CWA eH‡v¹(_Û™ªuX®‡‘ƒßøï8^[ğª(,,¤Ş½{Së6)k<ü;èr+şM=pÁJe~|èµQƒâJÀİ@|òXdRz°ÂC¦RPœÃK.•JZ^K–®w’ëÔrí\\÷@é®5u¥¬½¤ö”’²Ë]öê=ïºNÉÿåå¼¨ïæÇûaĞ‚Éa”·¦¢‡\n#™°ö%RVŠŠ%OrmR×I!…#–Jn\"MöZ²øóÈ0QHƒ(¾*]%¤h •äÄg0 P\0é•0nŠZdH¿SåKn[è[ä1¿Ojp8Å„z\n¥8d2TÃEšFT­ãoÜïÒO}fîì9¢¤¤„iÌØş5íºØÏyùzÿL\\Ğ€*>úëÊÀË#{™B.LR¦ˆ¸&<iUL”b²û$%9¯NÖ.ıÈöÃ2ÒlÿH!€3\0àv¨C~ù‰F3%MßzAí(˜ÚQC… TáÎğ}#<d~†	Ş	¤¨Ô$ù	\\9uùZ\\EIİï\"_Ñ*Zù6ÅÛ/Ç@ÚD7©:ûdM\r·?ªkgØ²™¦Q|›‡$×ñ_…Ø;4b\"›‚€U…}S„¾Š¡,SgRZ§ë\Z6lÿéŸ=Ş]ô®ÈÊÊ\"ÇCÏÍ|î‚ŞÃ?û—ïşoî*(oæ/¢àíqë+·¢B€†Bş¹— ¤¥Bk,YúÌ\"ÏçãHï,!cÈ‹u\\îÅ…P.BºŒ2˜û\0êÑ²†­ÿ3dH¹³Jm)ıóóîÁ/\'¯t““œ]l;\0hÂ(†í)ûYş{8ºÄÿ¯âÏB(\0o\"ğ,*\n	D­€ë\0B.S™z=¶ŞœÒ±GÖ\'ï9¾FÕn’\nD2«z•0jœB@!ùS*”¯¾\Z%M¾}ÁººÂà	P¡ˆ¥ƒƒèW\n¸›hR©uÔé‰nê\'JÒÁr€¤§§¯ûüóÏ;r¿ºöÚkû¶oßş‹²M—ïıßÓU›Ô‡Ö¿æ}oÈ½.	8äËa]IÉ\r<#—”ëˆvmÃêm#=ş±&…`tØ °0óÊù;p‹‘âİY¥¶|}¨qh=¸å‰H‡8úƒvñ•TÉah	­„ îDH:Lèò\r ˆ¤åc=+u™è•Ävl¨`8p£B\"š£©v;)Çx¡÷,&*_P)¬òeÃ\ZBhÛ§„å…†ÆPŸ”M_¼Òj½zİ´Ï>ŸZ:Pr ‡|j\r™}èğEnÜàjmf^}e•ûR½iÓ¦	—ËE:avFêÑ£uêÔéoÛ¥xŞË×üßë*\r ü®j{	©½ànVğŠ	Ê.R\0óÒİ˜´; wQ’‘f:ë_”˜ÜlŒ˜\'Qœ@\Ze¨!êÒMúÙ£i¢?ûÑÙéXòI¯•&ªÔ·ÉÀ$/ÏT¸ğŠRm)s/j \n !ğ>²ïÂø„İ½„ó0Š	H‚ù\"œå7ä\0r19@Qn´S‚\Zajü§—¤„N†ÃÔü±ğ3RVb7ª5fÁ•Û.•Èœò«1”#ç0±›Å&ƒ€ëäV§iÁ4ºõ¨¡¦8Íê×¾ÿ3g“Â£‹¶¡JB6LHv†Dè¾v­ªô.öğØ´iÓÕK—.ıU£ÑÈ—f#£Bx\rNß¾}çµhÑâ¡‹}ÏË×ûÿÑììÙ·‰˜¼ÍÈ&ÖaÂ-’#D @ÃóùiÊnÿ$ÁÆ…A…Œ€ Ø°È\'\"ˆŒßi0õ	äÀDhQ›ÁôWÏGiİál:äğF*„È“z\Z`Äv$º.Z¢û›·Å»Wúçöìp¤9@¸¦Zã„8Nå-Ü5ü¬4CnˆÛ6I¡sD‹¯ÇèÆ¡@®RbÒ_Ñƒ\\;×“zÿVdZƒÄ•AŒağh;Gƒğ)hèèËºWQ`àkŞ»ª›t¹û^Öœ98G‹ó}èA‡\rh¨çŠñÖ ÒçĞÜ””­cÌKgü¼Á»Î/®°ÛÆ÷ğÓÃíZ{{ÆÅ cÿÙcÕªU?ïÜ¹³[~~ş\"Ä‘#GÎ¬[·îÔ¶u—ïş±\"20Y?/ÑßÍeÅœz–]p4\0ß³Š5ì…À%á?ñrD‡‡ªÃèk½üXL\\&I•¤ñ;);h Ñı¾\"½ÏE\0àFp= \nP’ï¤ÑÓ£-j¹ÛGE\nşX$,+§’B¶  “+¶>Ùê´Mk6dN¿²—pìËW?§üC}¥£P¬7ó8w\n<‡åü#6l¸OÀ‡ß!ÒeH$ığäIßHbıR6ˆö ßQÂ}âjv†üJ: ®E#o™O]uj\Zß:¹S¼=ã%i×ÄjÅúJ9^(~„¢•@H:2@\rã9^èÖÆVÏ ‹~äÏb3P—dw\0% ä)&˜šÙ±MJ‹èè-ÿ†A”møùçŸ{öìA‰\n¨™€f¦N\ZÑXù7´ÿrş==Pé 	[?Ä6{ÄF„XYcÂ\\ÊC£ÈöãÄ÷ìjp\"¡—ÈÍ‘t~Òú¼2ÏáÅ9j˜7HQ.ö€\0Ã…s‹²iÀˆUDn\0ÑeÄ·\n|…„Ÿ˜Ïul“ÚL£y©ğµşà¬§tkc\nİöêç74mÚ¿².=°xl yë§J¿æJ„ƒùÍH‚Ib9Õ2{RNâ•d½gÕ¿ü¹\"sæf¥ÏàållÃ\0ŒÓq  »ú­ CÀM\rl6z kË¨v¢P|½ëEû%0.Pûèñ¾\ZÙ¡SÅWDÏtïŞ¥¹^ıÛ}?ş&yÀ©åd(ùÙŠ‘=ÙÅïKyáÆÿ\nSÖ—?­YíYûÓ\Z-ëƒFŒ¹§víºM*ëçË¿Ü§÷@¥æØ¼»„ùØ/@%€÷2Y‹Ëh¤Ìã	—B¶áKó÷Z¸/!¸*pu4µ¯\"ÃUIYP”¢i„’qÑQ¤Ñ$œL ^Îâ=-\nÍµ?*u…~9è°Y{p\r\"¡¨ƒ£U(`IŸtn£kãÏœÜX|_ëvZØa0mèÔ¢Òg8ı¬˜&4›—‘Y@4Çˆ#`LT³ñgÍˆ\"\0}zè¬=NcÂ&ß¢IC¹¦Œ\Z®˜S#kĞ€Áß“	¨Ë‡V™ñ™\';6ûµu´¾ëä?ş»Ü‚Ìğ\"9U‚¹(¿d¤¸ƒ¾¶ÓP¿ÒşÕ3+7Øs1àd læp>ŞJMÊ”.mÿU¦°0÷Ê³çÿ¡Ñk¨QãÆtÛ !UêëËSírT8`ûÖÍ,\Z*ùPt	¼‹“‘IR9:sÂÈ0·!s«Ì[\0ú£®PG4•¶¼Š¢{ \08•¢í¦ø0ìÈtË•R”r¤/b\"_tÊkrí/Ş7¤w2›NÖ¾=tMØUä™Ÿ±?M¹²ƒÜŞ·fŸt\Z‹ûzhõÕ­«<èÅï\'d}ıêüøcëa`–æj¼02¬êU\"=€Ñ—*¤Ü+î$s¿~õ¯?}@‘¿,A¥>İ~ûJ²x¡¡Áù8î“‚¦µ¬õA×¤ÄaÏlØ,61/äBáš u9’æ¢iöFÏîÒáï”Ôß›éP™€Ìdº[vã5²ñü·\rÉx\\ğ{ŠKŒ§ÑãÆW¹¯ÿmÏs¹=ÿ»=Pá€Ézi¤ˆ>·%\0©;øÎ,*ßÀ0™ `Åå\Z^A¨ê¤Ûòé=X¡Up ä#\r®bšüŒ0V˜ÄrÎGaÀW|]»7Í¿r%9í+9¨sõdJ4™úŞ˜œ|R—±ÕYĞç±ô¬4&»Ôïg×v¼àA_°úåı¾Şªo\n€k0Ê©a%0aè[TA7¯ŞêNüB*X2UhÒ—QÈå£[†~‡òˆ<½àh€‚ü¥8ßH]Õ”ºDGIÏ®Û$~,q“QhÈ>†ìùV:D©èém¥MÅEé/ü¶5ÅaĞĞÌ¶õm)Ñ‰;mâR¯?Y.ÖoıZ×kE·İ3ò‚ûúR´íò5ÿùğùwĞhªm8_KÎ;`üÎcé%ÏŞœ¢ÅJÍuO˜{	ëJ}„¥ö|Èîë@xİ×Fƒ-%=ŒHè„d_>S.KÉ¥Â¤ïé‡†˜¯Ùº!ª=}ÕëpÅ\\HŒDf2ëS€ü^jeÔÓ˜Nm¥wìë³$×™Æ—3ùƒ´üºvkĞö|ysáGO}mòÉÑ(%§ÈÄt˜ÂúÁ»$Ô§úcw.ZûÁObÕmŸACÏ‚¢™ÈUb¡\'W†@†J~µR¾N‰‰¾õéÛÄo¥85€Ù¨z5 s™Ş†±™X7‘nmP_úòp®ç÷£G´Ïwnÿ·áR3gÑñ›×şúã×mÛv±%Ö¬ó¯4‚÷ùÅòåJiàÀSõPÿÆ10MÎ&*«vA.ùŠkDÜœ¯\nåíö+Î3Rn„YiS$´‘Ç–Ï•“®Ş¹­;HBPø?ˆÌ))¾AÀ/mR…üQRLäu¥ƒŞcÈ	v‘Êk’¯sÚ‘oÖš;Ê~uŞ÷ãì vÕkğXtÖ»È±UN%<a`äœLHY¼Æa]¶U\"¬êaSK‡ba#p±äï9¬\r³ÛP‡íù6pS^õÙÅà‰®€bPxè½k®–ş³ö÷>ë„!Eu*\\;íš¿g`øşş’=W]8á×\ZÙ›‘;…bRLÈ0/Ã(K·èxL]ª3ıOiÏºebŒ§œ*=ô7¨t‡v*å(À¼>új‡Ö¿6¶º>õû:ñ‹šÕš!o&–5p›fµo»§‰E×$³¸¸NİèèCU‚wÌş:=cÏAòÃğjA\'\'ÄÓ÷3ï¹õßylxt HŞı¢‹ˆXj9²ÇHZÆ›áò\Z\'8@¼ªğ÷‚òàAYÙşY„G0Ş]ˆJU<\"Ê×hÚË1R«[‹7½<IÔü~	)4Àê ÷yì“ÒFÜü-ù:|#ìR‡‚¨$™‘\nÂî>ÒAÄë®Õˆj¶¿’´\r›\r•j^õaEoeCŸÂ¬sP´Ç\0¥;#ù¸>-Õşr_Ä‹N(ŸÈuÕ‘òH_¦FÁ.p¯¡:u|ıÛ4)ªn¿¢İß	ÛCwQÊŠøcU…b¼Íğ2Tt 6‘®xyñ¥º^¥$¾(Îê¾çÙ‰kâşE~¨òC*äí\"âªvy(ó»æ„ç(ªÇ©œ¶ó˜g;ƒzÌYÂÎ$Œ5X.‡ #\\áTİ¦¥Xs¢ “Œ˜H•_Ãœ\rƒBb„ÂÈ‡CÜÕqÓ~”›{ã§t6#n®7+\Zb¼%]»Hã×®í“íJq½ä}Ñ­eÄ/¢²éwğõá\"îà÷ÄĞÏ`…«Ü!qwĞ@OãŠ®CñS‘ŞßsH,=¤†ğ2˜˜p4}¢ä\\+<»\ZTÊÜ+;Î¯kÖMõób/¢IF?«ŸAsõ<¥â±Ê:_Ñ­–Z½¶²v•ı½ùˆÄR=îa‘UÑò“5=ÈØF[Í0Ìíë\'øöé¡\rø3íF=Ş7? ûüÈ¢Ç#ê£‡Wÿ!{53\"­ïGíSĞİLi×ÔjØ¯é½ÓÅ~W<‘D?&j2jï<ĞçÊ_¾¥c÷³Ûÿöª?Å3Ÿí G	g•Áa®y¬e4EÎãâ&±ëÌÆduJÚ¼xÒ9mİ3şZ‘˜ı+¢‘@:<˜û“‹¸ó¨ÄW~W2/(\'³rS„×åĞfXN!K°x1ä%LdÉƒ6¹ü¤OsÉ÷Ìœ=J˜ÿxT(šµ˜< BÂ*÷±\\€mk0x¼r¤“\rŞiˆ£ø»\n×\r`ÑQõºm<f¨MÕo¼ó@Â ‰òû(ïÈï™(()Ô\n#¢$\0£ 	%Z,Ad/­l|ˆ¼İ\"k¢Ÿ*”1â½aR*ÊÇÄ­½xušÓ¤Ÿ(İ—¾ÿé‡R’¶í ÑGv#D¦^.¬f\';ŞGôı3I{ã„JÇ‰sËGbç3¨‘ÒæDGJ®{€(õĞÑ¦©õü¯Î¸F¹,*Úd5<7ÔVVÓ–‘„¼Gœ?t¦ì^&xOä÷¨Ø`€´d½Œ_¡Â;[ÈJ0*–Ëaòù ©’ÉaÎeâ÷„ïƒÚjmF]3úğ+\'®É®—’Ãº\0­è|¥4qİº>YN]\Zî\"‡‚ÇÔON»¡VÒIıKe/£²¿ç¼u·ˆŞ¿\ZU­,ˆŒïRĞ¸ìôÛĞuÃ¦H¯lÚ%ÒÜ2º¡i‘u?<¨¸ä5Eã¥ıçú¶õnEÜØß~]_¢æ„UÆSRk)©ÿtîØ«¶J÷Uemêõô\nñå>\'&!¯¢Š§\\¨PšM cú:\\d—j£ÿV¥êÜ¬–õ¯¼b»\r‘*ï[U8p^¿iÈöã…›ô¤ç­Ydt	äC2¨^TÚê\rûEİ1SøUMÑ+B÷\r‡öÍ«ÑúI×qıá/~\"Ò¶Ùf9«Ü¯“UD¡1\rQWö ÜE>ƒcÁ	©&x»d)İBöo>§­Û»I4Üõ),`İt¬Å‚Á‚ÑÃº#`G~À]®£ìÇ³ûÙ•g%2£9©5<õ0`¾pÀP^ìX2T”xIÿY	2I$qü¥qÂ¸n9)Œ¸‡êmˆJıj;ÚÌEÌXdİüğÒ\'ïP¼àãq÷¯Å5•h“HK¸ñ¾ğ}‘Pÿ5Ã(nì‹å¾ƒœ>qBcÕ¢Ì*×{Æõ\\r\0±\'-?^éd/7!û^‘O2 -.hâˆ+X©âkı7Ö¤)b\ZÈóÃµJ”GÕ•‡Èk&](ìEº)_YŸ¢¿Km“óŞWØ³ntN¼õÛ I»Ì­êyÿ0äº\n(+ ¡ZS?Få„®-bµÚem+÷b®ß\nå»£ è@™^y¸´	w^ËI•\'¯Ÿ,C\"kPç<Ä\ZZPîCF•¹:ùêÃŠ7½™Tî#QTïZ·m÷ê¼ÂŸ_¶š²w’èJ¥òS1&‰Ùç Õ5n€ëğˆÌop-(,àbà˜0ğ—ui#=³Ñ«LÓôr•N&3Miß4â—QÙdæ¿ïZ4B4Øşùô\n,¬Xxœòâ‹™ÚíUjÖ ¥¶l)MXû“ØãA$Æ“9\'t|0ÊÓTËä§W®n/m*ÖéÚé‰U¡n¬èO6oBb+mw½³†ä–(?Pãú±\Z·íÀÒ©çåAÏùì¹şÚ÷˜Ga–¹!N&õé1øß>”õÃ;[·ù1óø~â@VWcààA‚x&5ĞJïsÚğn3|6èµa$xV³F—:@îû»Õ£—îéYé³ŒùhÏs‹VüşX¢2—|üX¥ç—µqç¤¢Î±İ$ŒZäsaJCº„Á×ûØ%E„.©\Z/Ü	gÄéjğáºÉX¤Ò3x	âoAôZ®Êã„sEÜûìG„2ãŒlè´4ò.ŸQXà\nğ5 %ŸdV}ÉhHsğ¶å+¼Ü-XaTX0’\ry1†HvE%Çè±O’µû=ç<snÿaŒ6cÑá#SâÃÖ€!Jú0;âş	–Å÷v\');fn\r¼ƒÒ…5­ûÊOiª¸ú\'àœ7¦ÕKàZm,¨Ö¾‹¤ßa å€¡dx®/{ÎßWû¼T²˜`|Á)Ê0iÈ%~û~TkÒ[ç´¹Ü‡ØÿÆı¢ÚşÂòx„0ÏÂ60áƒi[V§øäÜ\ZŞr•ıG%h\ZÀN›ÎD½ëDâ#Ø \0ªÀyj\"_éÖ‡2¬Í®oã[ÿqëâ£Û2|›¾ XÏAZÜd­hr¢/E¸>\"N¸7Ã\\æ6TXµævhº-÷ø¡wç§qå<I*¥xD{ö¼¸$)ër¾Ú\'˜|d@ƒ!Üxl¿ÓAnÿ8D5«•ÕÂÛiÂúµÇòAÒ™„Ød#÷‘Gm¦şVµıÁv­£Vçæï~jß‘ÆqpªÅxèÕNİ*@æ|2ùÛ­¹³<˜(½ê+¥=5by$²öğ×Å‘` r6ùa`Ä;ç/\\ù­8v*PjKA”ë×„Ñ	sƒk\'¦\rªQ³¿iğ!o0ï0\nÊ^îÙ»ÁØˆ%4ó¾®)£»´¨TÇ£¿ãSÑXÚJ ŸıŒ‡ÇwI%2Ã°ÀÊ^úZ\rtà\Zä”|#Æ‰.où-ÀÀjàîQ€wò\0y™‘CÇ!\Z\rJğÂÅõ`ìÆ&ûktä•ñ\"zóg„SI¢`õ€ìP$x´&&#ÉS¯ÎÇ¹eè-oàãçÑA<ª/ƒvr\ZŒÆé%‡ÏIN2ÕúxÇ9ï<¿¢ĞE£nù\"¸uÙĞöjKU:>Êú)TzPßÓ´f¸Š&”¦E[”0†]#˜º\'\rL°d«È|`(Õõ\'OŒ‰‚Ğ`ùT1ä+`õ÷ê×v)¾é9õ™¼EÇ>>4­ß øÒLÒÌae>úQYRLû°ƒGóÙ_’¢Ö¹9uå>DæôÎ\"Æ•#AÕ	·Œháú\'X×e±¿Rît-™KtÈZ“V7@›’Rh_Tmˆsù…wOd“¤´·xmÔ>İ´}%Õ,Î\"?ªÛÅŞøÈ|m¢ÿQû–=ŞÙYnÚ¥oo¬Ñ¢\0\0 \0IDAT.«}U@-€´ œß3¢FLj“¤j‡Ù¸.î¨ÍE®¾èñ÷‰Şò&îÁ{Š{`>»6~:&Ltg¯¯áşäá%è‰«Z¥ÂøZŸüeóS^.×H¹£ıÌp±ŞïzjÇ¦Ş®V‹îíôb™ÇG/µj8¦¹ÑøFeÆ\"îW„\rÄ{61ŒYõÔ]•úõâÏ6ìd@Æ¶x{L¹ïyÚŸéS÷ÙJu ñ“Ÿ1¤‚Ã[¹ÀĞ0ç¦Æ*>¨~õ´AÉÉıôg\n_(Y\'I79“Ë ¥+’ìôÉ£ƒª™Íù=—òîU¢a`íş`rÄhãœI\"nÇz<\rQ\0Œƒ\\’•Ÿ\Z(Å-Ùù¤Õa÷Nœ\0àr§¥(Ÿá1ÖÅ¬Fš6L\\œè˜-#4Ÿ‘\\AÕyg£Ü–=ïŒ‰¿…Z=8FV\0‰K0P6}= “xÒ»ñ~á\"ú™sa†k)°Øøùt7Ü>W.%Áº@Òe®\n¹/”ìùòß÷Ÿ·ã{=4êôş)¸-Ih‘ğ\ZÔ1OnÇ$\'ÆZÒ‘#SxO7Ò™±@ÀÀHp5 \r¨©şk?ƒä­uÒÀØDn=Åò÷¸V¼Dz3djÚÖÇ\r0QÔ×{0Å˜{Î»qü´X½5™bñ\\\nA¦J K!P¤tëpŠ½ã©rßg¹¿,ÖJ¨±Õj\0<ŠZ.‚KËÑ\"¸-ÜÁ—›ò0©²,Méİ£i—¥Ş+0\r2ÕğÇäO±‘“ïÀÄ\Z£æ´Ø¶l³7‹f¤Ñõ{>¢PÍ›H3b\"Úš¾ÉÊ^¶?§c>ü/&«… $´#„¬éÁqz\ZÒ¼¡ÔïçM\"›+Ò±¹»6ÊDÛ4–ïTRøÜ‡v—\"BOŠêsÈZ³wÄƒùô—ï,Şq¯ãÅÁMÁB$:jèıÆĞg-:ÁÏF¥;¬Ü‰ÁzïúnÒ×GrÄK2åÔ\0öIù¹™[’‡!8€(D×Niİ¬Qœy×G[vŠ;Z7‹¨=šAŠT|2.¢óÏØÊa@È`e}ûşr??á»ŸÅ…–Á¿åãÄÎà‰œ2 hÀ%Üİ¸VZ¿¤êı4·½€ `5L„0š•Q-¯`2šĞ’A§Õ³‡§vJ²¾T‘ÑÜı¥HTì§¬w\'^Ğ3ïÚ;ç5ö|N 0FÑ@0ó\'òÌzK‹ê;¥ŸğØJ:ë¾ŠÚ–÷Ê=Bû×7$Y`XxaE›d©ºß¤k¯G¬}Vxr¯§?ÕØúı¯«ï_Ef-jÅ+Õ¸•”ç‚OêLufI‚æHf³	î\nÏ1,Û@R‰E`„#S60¸.~##4 !§ŸrĞşz¯ş“|GéÏÏ»J‰¶¤ÓGcˆ29……¼M¶ßHu¤9íqMÅKR¶<{ó94yğÕ¼‡È¥ƒ[¬AJEîR”ŒÕÅP½Ù+J¤ØFåöO¹/Ù=±¶œëìb™?—•äUƒQ‡Œ¨i’+YéÅë¡ÆV2Ûù7ş,şÎ~)ÃC6H¶eC€aş\rÀêª\0Y²€°œşíSÔ¨(“æıˆîïÔøë:*Ó­ËdÒ(9ŒÈ‰z0ÕI/½rå•Ò¿ş,Jı¨ñ«Ğ?•’š÷¯ë\"?Ká†Â8\Zfı±+ ó/ÕŞDQmç¦HRJ!üÙƒÈeßêf\r0ºJ\néÖ+)Æ£¥Â÷àJ`<Çhø˜Ç~İ$¶¡_;FÙ‡pèš‹Ú —Q´cq÷ÊyŠ²ûwO}>}mnİ”N‰ùü1ÿÁa•¡òş®>G@.Ş]î{öİïÂ	d`=Ï‰è\nÌc8O’\rÌ(˜a`úÍ†ã˜\0BfS.h.¯8òâÁ$\Z.á’Go¤;ZÕ¨Ğp¨ïY!Ìê<*z«ü6]Èsòg¶¾p›¨½ÿOR€¨fï‡RşCôŸ˜İ{JDA€Ü9C…nÛ7pÅ„€( / 9Uê7ÎféóHB¤Jë©=DÏFrkkÈ¥du^7x€œÜÑ”ğñ©ºGâè®Øì‰İb˜J0cœ£µà„ŠİÀ\\Ë#70!\'#˜îh6¸OF0ğ˜û)Âê^ûõ¿ZK¦˜­§÷k¡(´Dÿõ£½pîxÒ2\"Ô *%d œÌ+¹ıTØ¦Õôkqd²)÷»9Bõæ›dµ¸Ékâ3à\':B”°Pòàa¤î=ı¼ï¼Ü?”LnÈ T7M3rá[1;^D?×îL/·›XˆH€\Z“™y¢È‹v£„¯ÅÉ…ÌÆ3´dãS˜Û7÷\'Zİ‹êû\nèæÆ–à5›©öûZ/Ü¹9c\'|Ã(·«môÑ5İ¥U9…âõ‡p®ñ ×ÒÈz1{z×©Ù$wCŠˆ¡c€¶áÂQüPæ\rœR#26w¨ÖĞ´B]ByM?¶ës±ëó÷if—é °­™äãÿÉÛÉúiVç¿Ztú‘©«7îqøáºqUÎÚæz8g\0‘uQ4º¦9õúÚu+\\áËî_gàSéG”ÕSBİwÁ+}QoˆèF¯Œ(÷\Z·ÿø\'6bÁû•]pÂj8ôÍ¨®\\’ÑÍj¤]—ÔOÛÌ	Ê‰Ê3S\ZF0ø¿r¸†\\‰×U§9÷Ü\\a{•#?	”CÇß)ßm»P³÷©Eâa¬ ‚j4\n:ä(¥P˜ÛˆÌÀÌ»Cè2~€ÑË$fïZ»IÜ6ÁÕïñˆE†Ëv{¤66\"l\\ŠOa4J¾öj¨úŠÃ\'û‡\rÌñ‰×ÄêÍä‡EKšÒ\0Àí¨ñq\\¤Æh‚ÆÈ\\¨©.C×7Ÿc`äµÁ•}ÛáÿÜÿ©iïdFä)¨o„™©uÛ©\0ˆ4îéÏI]³ƒä)Úığá‰½^ŒWdÃ5J$£ÏBÇL¹”œ]BÙQWSõW^MSëÂQªòrƒóá\ZĞ(ApÆ5%e±3!JÊ‡û]Ã±´¸ÙPŠ—à€?¦¢p7ÏqöÆ#˜\nrÉJFqrE(\\¥e\'xG9aÖ$zÌ5\r.…\Z:;¥6jÕ­Y‚yí7G³ÅGû‘,ù¤æ-~T„^Ø±ÙæF4€…Vª€.Q€ŞëšÔÍ{ğÙ_Ì…°!`ûyñßC˜ìwİ\Z+¶u}÷€Îrõyu	åu’YúÿlÏuıVÔ´Ìš\nãçöÂ}«‰´†§¯é–°éèñO–ì9ÖÍÍ†‡Ya®Ù+×ÆQQ=\rˆİn]#è¡p’=“£ˆK	~tá±ÇÄy?oÎ/éf_:£Üûö[³‹ô	³‚A)×¨9Qbƒ#xZL²1-j¥õŒ‚y/.‘|²ò´mad>„y\rïd¤wÇõ¯ÁŒùRÄúQÎ;Áì~â:‘|t`4BÌ\n I?Š™SÿIi–~Ó\"40ƒ…nË\Z9Z¥aà(\n¬‰ş©6k¿ñÃ›ÖÜ÷§Û¬ĞÌp×X,TSâ\'ßÀ„ yï½†ôĞ•	¿À<¯á1æÛñÃ_{ß¦q0¼æ”D;ˆÏøK<t EJ¿à—c?¼Û­ÚoS‘TˆÂ–Ê˜›n—j<0lWŞÚ\'^R­¬’ñM¬&œ*ük?& \"Ö9­å­n§÷êM$+\"ìPBÎ_¦‰‘-LÄ‡¬®äÚ·Ø@²$òº}ÔC^E³Mh´s>Å 7İEÃk%¬ï[·n§1÷™ô›!öşÈ-¥Qk7ˆLt&‚^&T\r4¼¦‘úVw¬wÿÕ¹#<E0ÅnXs¬®œÈ’Y‚›å…[%Õ}™tIİ¬’‹ù1pífáìR€ÜfaLòáşA$l®C½j×úc³Øí†á„úW[²»ˆur£j)=jDî¢%z<=Ÿê¤ø–]šüŸ—2v¬\\]ìéÂv¾ò>İ\'tG\\Èœ	^Œ°rvlëzi×Xbú©`H	‰fld?ŠŸ‘+ú¡ëA):úhbeæ˜#İÀd>u½ˆÏÜJD‚J b0Òpoì$ú<”f©\"ôé«e£Bd*íLPE¯‰6ëmU30YË³Y´P{kåBH?~›>Ë<…`vï6ç<Ş½Äj§gä-øšRAÅ@_Uq‘D)8˜{ÁÁ ‰×ÈÁÜm/@”¡îéå\"˜²Qğ¥ÑÂúÓGHHÄÂ^ŒyKìfzÜŠ|Àá/“}áóĞÇX€àÒ\0/\nÙës´?¥5Ÿ:ÿE¥®æ£Í ò9˜‡ê	ì±Ö v}boštŠx#æm¯ Œb||\"ÊTF\0G<]9Lˆë;1°+¿¢Ê7`ĞlPFZiƒâJzĞı,ÕÁ‰’FG]àò?Ô±¥ìÎ^ÿ»˜Ü±³´&++}Îşã)*d-;ƒñdVä´¸çÕ’£p³My »UÂŠ\'og\"oÆÆ*+t™©¢˜’8uµHs;éãûÒP[‹{ÈâÜò_æÏ{~ßTŒ#ÓË\\ÁŸÛc¢>Œ‚\\Õ6Õå	z,cgZ+h\0»(“»I<Ö±]ØŒğèûÔ›é_ï¥´1;Ó6,œÑ\ná¥åÓf¬ß˜îU¤ÈºH™Â»H‘ÈÊTF3QĞ“Œj];­«9¾Ÿ¹ÏóÂNA	\'Ëdw™éY#\"ÃÊÙ^­­´rrŸJÌw\"6pˆrÎÃUåN?÷àŒD¸7P¢ä^#Ê¡*€`Ì·M¨ÿòæ…ùInØ<P‡ç‚ñºl¤¹õq›iÀäˆŒgÛg_Ï»ï\rP£\Z‘N¯íÙÒµ	5\\ºıŒşÉï_]-\n;a•»Æ@ÆNÂò#£İ2c‚«ãÕÃ×7&uÁÀ(©N%&dß#¿‰‚ñTÍ_—JÍà®ÀÉ07üĞˆèà&2%‰ƒ6ˆ(—ß§!ëKËI•X¹<¤|iR2öãZ)X­=Z:¦ªNcú=\rØiD}xí²‹Ã*Ê0T>cçFˆLşÂEòÂww#ô·Ê|½}Ğø”À\"pyŞğŒ¥eŠ›áéøÖPM$\rN¹êŠ¡ÉZÕIeøª_Å1Hº».½%©¦ÅáÈK2™r¸	~ÇVwñ®ñ:½*¼	*ÙÉ[”ÀÄKèÀ SŠË~²Ô’sNşyiofjÔùİÅÊäZ÷œï1Ú¸E¬CFµ\ZRÂ…diF\0+x3=Üº©ôòÖıâÛÜByk¢a³»´kYK«…¶µj‡jèëBƒ•Ïõiä¢´Hï0û·ßÓ·Õ)~øé²\"a¥+Gë¸†±ï‡ÃÀÏ4­Ö8*¦Ÿ©ßLáĞ€àá.«I8á‡!éL¨Ã2õjf¡•SúUl`îÿFÄPîÂ‹ë\"x¢‡H8´ –œš€mX„ÛÌô}(Í8 2“=wˆ0eü$ÅœóğùIWİ€	6sÿ‡\"60{æµ¶ƒËKĞ‚ôw‚4vdÒ±ØÔà…{¨ÍÕÖ”½§¢~ÕÅ X»Èî´¦D\r‚Ì¤å‡\"60¬ƒ±Ëajä!jÈ%G€@>\"°u_Ï¨Á¾…ß/²kŞ~Š¨Ó¤ï&a@‡¥,\"ÄrÂ	®©DXZÊµÓ±½)qìô“¦^¥A“rÂ>¹äq4ˆòØQÂòÑ[R–>Æ„\"Ë±ø`Suã®üÏú•RD#hŞ¥!ê¡f¤Á\nHÖ~#‚ãnÇR²CÂlUØemAR¨”&]Ñn~3“n\"ßÿıƒûÄïGôF×6’=ëY_ o¹Z#\0‘“§y\rÕzŸ¬qëŞ<\nõ\\Ÿ1‘ (çR¡×äIÂé,3w‘#‚³C±js-Å\rœ_nßdz½}üù÷´|hL”•Ë	Ÿø<—\råd¸Y­›PD>›şËz[¸‰Ñµc©OíÚ–Ó\rD‹qÄ>è7D‰7kÉ”‹^³÷ÕÌİ¼Hi ´i\0ÿˆpép0ŒĞ7é\r4´Q}™”Ö÷#ÜP~*¹¸¹¼oİÂ»w²&#vİĞPG«fşGÌşi×ˆÄ¬]¤@Hğáz=N¸È y#50Ç`Œ@0*ìrAàq^hŒ·?d³ŞR¹bêà²?Vx«WbŒµ’	.³d+¥ÒŞã)ùî3óÂN70Œ´È<*ö@±ì”+UÙ¢ÁÆ6¼+Ò€`XyòEf`øÚ¶`¦ÜuõûÉˆ6Îùb7z@€Q#.p`Ëg)šj¾ñ¡[ajÂ•l+=Ê…“š	ûÖÿ.oÖ‹–6„¼Ş2­¬dCøº2!	³{²\'ô4 `1^P@ïÇ\rF\Z~#gË²º°r7€PğŞĞÕt—cÅÀ„²@“ÚÂ@LívÕÉv¿¸)C<\\ï»(Ç®Ù6Oå¶†.WïÕ¾Á`ùvŞ‘f€=Ùl2ñ‹è—mJWähg‡p]÷Vi÷²º1@%¦ê3tf}]í.çì[ôÓá<ñÂÁr•»îÇûZ‡‹hé©}” íÚHK÷¿åæĞÃE².ôH¼ëaX¡¹qSµšñ}×Ï¾÷‹½Ö…~njÚOCæ,9ğùÊ!/,!”C‹<dIA]’‰~}ax…Ï«ºï[+QîE\"íŸÚ]$İ-VÑ&\'à…z§¦E\rŒÁäÀÀè3V#ç‰Q8>¿¿„”)·’hÙâ5ŒM-sVá\ZÓ\na	!h	¤¨§(‡ò37“:ï8Ec|i°\0I@Ín.ï*\"›/Š\Z}z®ÛSĞ/I(¢!tÔ‡SÁµ%Á5KZ–ñ¸‘•¼÷vÉË.W!€ğ/S¡Î#˜²1‘óÇ×6ãK÷XCH–Ô\"Ù Ÿü\Z XÔ‚Rb´\0Â×î\r•G\ro‰\\$Yş*ıdg¡µ!Y+xŒnô\'% ©×z%—Õ?aXªf`˜«À\'¸D%o£\n)sw3cÇR\'ï_04œYÍp,lbBpY0n]>ÙÔÕÁ>ĞQ/—6ª­åìI²¥°ÀQ3sLr”çwWèpˆ‘í[¬¼4q½Èxl&E5ìWÔbj?aã-FŠ³‰Šò@Ê²\\”s[ÁÜ«%·[BÖ2De–qË¿VD·¹õìû>°úOq„•»,¬ã+°Â™£Z€×s:·±6”¤’ÅEÅÍ£c\"†Öç3\0q…ÚFpóP¶ÂSLMb\0ß%oÔæ·¦Àj^Ø1~ş§b\'à®iáBî\n2 SÙ\n÷‚·/±ÆFSİºµAjé±9Kï\ré0y¹x˜ŒúÂe:8ZÆÑ4€{jã -¯U¼ı¬âşU\".x„òŞ¹ğğ{yO¼÷ñ\"!kGØ8p^Ü*†’÷öÒbn{2\"†u0†Œ±0öYg53?\'E\"7N.‚ËcS2‚g‘!Ê«j¹„<H‹Õğ“Ğ‚ãƒ´‚3ÜÉKê\\0¦´Ş¨ùçŒß“†ñ)†‘\ZB»Rˆóâ?¬B²£c¯(Ñ“ôH\rÂ@ğÁÊb60•¹He})<ûÒ›ı|JóÃßC›v“üPmk^€pVWä¦ÍÑ5©Ãë¿DlødQŞËÊZ<Nh2¾ wÛŒ¥okßŒò	 Ë°b…OúH$¦¬‡ü1Ş-üøa\Z¢:ñºÌ_0Ë’sŞ4^bg¶Â~$OŠ“ÎzKKI›t^C½iušn3 ˜6oä&§ñ³æ\r0Õ™¸Vä‘SÓ‘¢Ú½	qbõ‚²g.Ş9X˜Š~’K^†”n*ıåÈíP6cr™H-%NŞuN?ıf+NŸ•±/%CÈI\r°hğUyâi©òf\\ä\"RÆÍi}ğpn†ËT«&\0H<Â?0ÙdÑ„D³ºu·|=c`›HÍMâ ù¢Ğˆ\Zûğ~İü0ğTÜwr\"Âël¨I‰2\0Llóª-_NñÕ<ÙT\\‚Ñº&í~§â”åèU y/¾Ùÿø\r\".kËI#ÁØ+\n]ä»ãA(y§Gf`f\r†­?È†KLÈò&òÁÅ@•\0Unˆ“SäÅ$<®9Á5¼CE”†\rT´^ôgÍYz0®êô ÚsÆ\"_õšpÁiGşmÕ„Îú\"vµ5İğÙäs#È&ïkÈ¡]Ğ„4®a’;v0RÃMrm\\!œ¯##P ³ıDƒ3¹…¬ÅaœIš.#Ô³Ÿ¯Ü‡pïOÎÙÃhÀlâŞCï…œ‹µœª^eƒ[âsLêú……°)$İBi4Yû~ÉÌY.oß†BƒĞ3 mÌ¤¬wïH£¦ŞÂH&MáÖE”ó\\ÖWì¾0|‡‘E£³Ô±İ9ıZ¢ô—y¾]½SU~Vhúy’w@C !SŞAÉåŒWQüß’¥øxY:]v<üÇ:±)J@a.¦å…Ô#ËÛ„˜¹];6¯¦ÕîŒ¤íU9çŞ×¾ª—_`ã¾*	¬A4?¬ÙçÈ–ÆY@W×3yœõÀy9›Qoş`}wÍn˜9g‡%ÿ¼ó%ç—@d.‡Ş¤²\\ıÇˆRŞş·bovvøGé8;«w]í¯bø¬¸ÿ; ˜¬‹`ØÀÄ\rG‘XÃCÈÿQbÕ\r—fé™Ğ.oöB¿å{ÙÀp$Š—_–\"pU1ÎÆfÒ«œèÇ}s\"£\\Şõ‚‹3y¸‹z òó²ÕVRuèq,yâRl’UşQf`ÀIÈ¢V­+œ‡ªS%“o2À=\nÁÀğ•THq8Puı7·VHò–µÊçÎ½sÛÜ)Kê\\Mj”qU0wÄïj]rïL@D‡; ÷ÍŒ¸]|írO~°¦}ş¡mAëI v‘‰ªB•}y7¡S«ŠĞç!qŠ€/´•|—R@h&BOï—ô°y†Ì»¨8íŸßV?!RA&©¢™[,ıMchÑ¥*Ï<îùëÖ+¶«•x¿lñŠ¼\n:¶ı2Ecêxë]²¹©Ğ{£¤%Éë!µŞ…	…Ôy%Ü6Ğ”ãä±˜ÈÓ´/U²àŒşZ—tŞs»Sn4/\\µw³4ÑĞš\ZÒ°Q•^DUõìsïóéçÛ÷î¿æ@‘d\rh­#òÊ\Z Ş­~<uÀÈ³Ï¿öÑåÖŸäØàŒ¸*[ÙÁ„ü£J®ùâCFÉAlŞş„xE…„üxø”Ç+;¹ºªãtpé#>·4ú{ë;D‹F]ÔşÉ„‰9a`¸ UH60¥6&2sœ£HĞÁ•I^ 7Sıˆß’˜oc;Â	XÏÊ†—³Ï%,Œ.D^İ^RSôd¨Ñ‰bÛuëe¹æî\nëı\"ÙQ¤Î)à!uPı`÷ä¥‘#˜ c(Ş[ş‚‚\rUÁ?eƒCjğú†TÉšT©zÜûçgÂıÊxR@¬\'–A\n“ØÏù‡Èğò)<RÍ?#sµpÎHó8âëßÄ~­VÓ©xKU¹„ä©T\060rU/enl±xàq0öÔÑñì±ú­)ÅçI?ÑHÃà\\…Õƒ\\å.ˆ§¥T`A	-ß¸ñg? ß·½¸0cLT\\dÇ\\\"t Ä®õ\'©éWh¢nØ|ögì›ë	£¯lö7Xé§ì§éSmCùÙxWÉöC4hË›Ô²\0\\Ñ¤OHWûÌ½¤§ş¶QüjÊi¶JÈ$t{E®Øä%Uõœø;Ÿ%BÊ(’Ñ­¾ôõw3î8ƒCj÷è›Ö­ÈÆ\nÜp¡~x²k$¿Py…Fô!/ŠFueu˜åÂw8š†{ÕT§¬+10÷}%bCYT°ğÂÊåõÇ\'n±G¶/\\$*\n‘Á<$oß…v³EÉK\\>ëÊğƒ\"‡ÌÀ~ã¨wTµZòá=Äyóˆe2C,R\'ğüĞ‹è}*ä×AH×á\nRYÑG×Çf?t3R,PÒ†‹XiQÎ£\0¼^r²©Cîı¢è„5JîÁ€ËÆ{iğaåz\Zá>Pëğƒ·µí\'e,uÑË	8øÍX’…Ç˜¤ƒ5ºP£ç^*tõO$¤U<:ËG0HkÛ·÷ÕàKY‚6K=Pîz\0ÖÕjP…£K—K^rz?¸\n\\…µ’\\\ZÆˆÁ)#ié¸\0×NsÍs¨ıˆi‹\\Zu$¼Ÿ4—5\"Âc«>›b’=¬T&Î®ê„:ı|.˜ìµm¸\0àÛÖ˜¨ÙÚs#yYjŸÉø‹¿É¼#ş¨²!M*~i—µèÏk\ZH×ÿ´UğŒnøá¼Šçê,d	äQêŸ‹©ÿä3‹êìÂ²vë^ûÚìcT+*–†¤4ªÛT¯?ôwáb|¶÷ãoï^•)5VB$éZ~f6v»QÏ[3\n¬6®;{b8±PpjEØÈÈFD.s\ZF™e‡\\½/l‘NıRFŒ:ª­*¤ÃK+Î’VúZÖÁä/º¸fß´\"$¯’•¼,oBÅN\nÜ11-*ÂTœÙw L½š$ ˜°É¹>ìqİhR·nšByN‚ì</ãĞWKP0í\0Å` ±\Z„ép‘Äç†Zw£:¾Q©‘ñæîn•;áê-Õ5¨dk\n4¤ƒ)¡\\•‚S!ÏQtww¸6XÎa\0Õ¼À#Ü¤‰•´=\0\0 \0IDAT)ıü%QúÉL2 ¨RÜb%€…(–¥)àX—t¢&¥åDS%Ñâú:ÑÑÕW6VÏÛ	ŞÒŒôĞöëSV+n¤…ıè¨æ\nˆˆ3±##v@GX6åÕŒÃËpp°‘»œ/\r`Â%™8ÄV­@\0£èkê³\0{\nÁHqQ’ri@ºL•¨ôÊïChòÄ…•¾Êæ|/Út¥Ğ»bš¿ò‹.¦Ww>ÏçßîÚøpÊ!À1¥/“FäZmI›\';´ÉèüçïÂŒZ j®Ç@ÅåT(„;»iµ´1¯Dç…>S$Ÿ«ÿà›?gæ[º5Ô{÷,9ÅÉ\\óûa²qÊ½r•IŞ°å`-ğc#ëïNº9Cæ|‚‡áDWìcI\r\r…´wQÅF¡]”7“\n­òûµrã¼ş™Ú¯U4}0õÎ3>¿ÿñk`¶‘Ú„ÊlX}ƒp‘6¼ƒ`\"40¹Œ`d	EÆ¦æÊw!‡¨ß›µïD9\Z˜)„®®$yÄ±]C2?ùAò¶Ÿ€d E‘*îÅ>ÏïRIÓ®TmÚÓzIªËuóÎ{¾#I$iP(†ñ¡u\\ì˜Ìñ¸ÁíJj”RÀÊ¯EÊÁ1\\¯ñÒŠŒ¿xûÊÜ{ûõR 5 \Z¥lƒˆ\Z†àÉh\nHÊ+à\"£¼«\\c:)·ÃIT6LX´‚ç†•¶ñ¼\'øıÇ»»şê¸Æè/„3Ğ^EZh›BÛ1ÉŠ´‰\rŸ”Eq\nÔ]‘ †åBÖ6¥¸MœÙÔ­úR\Zø\nÅ»½@1FìÇÌeQ-/Cq,…n”_˜ÿÛ½ôô¦!Tò~µ†:©æşH&NUÏq,Ô{FmÉ£i%¿ŠĞ”)Õ ‰%ïÁõÕQ-e-îvµÜ½Ö­Gš‡Ë‘9\r®Èp´U¿Jğìáv=ß¡s¥[Õ6^ªóµw„\nÅ”¿äTøxø»ktŸü°ÓíÅ{c^¡ì`#£d¡~ÁÌL™»[ö°l`x·J™C—Ia9 \"¯v\\¯£M’6Î«8wJ)\ZLá{V¹Ç¼½fŞ;k§6×äPÆâ)g|şàôëDTæÒ ª?ç\"!´SÚ±öš˜fA=˜Hú7ajæ`¢:Ü‚à–4.°ìó¸ÍØR¹rƒŒ1×ˆdçAÒA	.a›`.Åfz°A°è¸f Õ=§Âç<2¬–ˆåš<œç‚Ï\Z‘TäÿAÊ5 Šä¸»\'#$@0Œ%!:¯¢Å{§’+ÏîoÑÆû>Z¼­ÁšOÉ‹gÖb«`\\£Øğ>ƒ†”ŞÄÈEÔAşJ¤€ÚyÃƒPÜM÷-TijÃñ~Ÿó>¼ıÀ›Â;Æ\0ğ–ŒW(‹³±áÚ¦‡‚èP 1fƒŞ‚ÿm§ÆºdEş&V=	d)ªİËDsaáÌg¾!d2¨÷ö¤ïŒ@Êû½Õ)¥†æÒmş^´­‘0£JG‡‘\n\r´GêjT\r•ï¿èzjw‚	ë6ˆ½>ğO\ndŠÉ”àôMà-a1ğ>èö÷Äs‘ö‹uNõ{^ZÖĞ}cRæî’ä\Z4K”*%8s•w€8a`øë‰­ÇåwÆ¸“·ştk›äšÍˆ<1¨û·7Ò§¨pBI#VŠ¸ĞQÊ·b½LyÏ?fáªyoÿx8µµ±€6¿3õŒû@6uÌá­\'L!b…•ï‡ ©×£YÃÆÂ‰²xF”V”ìÖ\rl3õM-×Àø~\\øÒá·Ÿb¢p­ @‡›¡@16úU—CÎÇ[uõNç{Ÿ‡ï¨/b¡\Z¡P›-²™.¤V¡&o¨`—°?pŒ+Pˆ^.Æ&9¼píÍÔèÍ=ç}ÁM‹^+z~æÉR„tœ8ÊFİ%ÚV¤G[RÜÃS)wŞ8Ò¹™sBd¹XDÓ\n)Sæ£òÂeTİ>ª¾Ä*ÖòóŞ¼`s}”Í}ŒÕj!ÄÄÃ[E¨\0¿¸VŒ\n°‰÷häm)ü\\à[ÖÈğpC¼®\\³•ëRÀ¨°Å¨C©\"ãE¬.¤~×yn:™@ø\"Å~ÃÓ]©C5àÄKtøí¿ííïÛ˜•—Î[è1iÂnªŠuñÚ˜Œ<¯*…óIJµ€z°c[=Ãá~ıC\0¯„øø\"\r}ÓõÒ”è¼ŞzôËb«ÍDS)Ë¦>i`’<+r”uñnÂQ£p¹}\'á4°ÊƒçY8D®sÂ%â,(äs^‡\ZÎÚ^5kQjÿ3¤\0ç<Ó=i\"A:NyÀÁŒ}wÕ¼W¿ÏIm¥=N[ÏB0™_\'b³¶“ˆ/»yà1˜ƒ	İùpÄ¦pö0¡ÜÂ¹H\\Ñf7K\Z:fj´yI’Îu;ıÈ~nˆĞlYÅBj5R îÒ#Ltji[Luj¿`ÃyÇõ±¡­„VSDZD$,`~ÂÜ%rO~.%ºãˆJs}¸¡­?‰’çï$\r‚2~®j‡¨—Òå ]25|k[¹÷f~¼oî„A	‡w’^Ïı±‚°z]¤G‰\nİ=¯‘ææ;¥Â/æ‘6›,HëñrÆ7„–.x.Æ#ùt¨m/jùÄûp±‡sUŒË³G83Ra…	$Ò˜1±Âù6|È…®XÎ+\Z~f\\Âñ¢S„ayÏÄÙ¢Št„í¹_ï£Ùk{ †j!b÷>\ZÜ.Š>¾ïÖKf`¸İ…G&‹¨ã‹äÉr­wFx!B€M	<oM‘ò…¿^İöd[ŞÜtÀú™»ĞfÂŠV¦şİÖÍmõL†¿­Ğ=ßK©~Ç8äı$PñÂ\'şv´{pØ\\d¤[›èS¾š~ÊÀ´\Z;Wì°¡¶3´åeÑ¤³\rLxo!æhäİ‚ğŞYİ­Gˆ¾„–ŒïkxUM¬Jç?¤{WÂÀd_P²#˜×ÈNm¡Í¥­ïé\"eƒ±1„ä‚_00\n˜`LŒ*ãgÔä•w›ç\0â“=8h<Ê5œ¿àT0gÃ„ÃnŸŸ¤u â›.…\ZĞ¢€Ë°kÈŞıJ~pV¹ï2ë…±ä/¤\n€Äá ÒØ‚Fy{*éúùŒåõj¾½õß,øB³t:ùŒØ/!f?ö:× LŸÜšê¿øã9÷=ræY×-‹wÏ~\nÉpQ\"”…‚>ÌOs¶KoDÉs—ÌRêê=\"Šw÷Ù>ıî´úE;píh¹N3á@UÂP\"%Iº.çG­àü?{ ÌõNÈ¤e«\"û¥r–¥<&ÃÕîØè /\Z#„!×Í<ïÁÂ7J”P	ÂÁõ_@6NQ×#Á›[5%tğÍ»ê\'JÒ9¹?\rØªş-oû½Âã_K7ÙÖR2Âª:Äú¡Y”åò<i˜óA\Zİ»–Á:¾aC¹^Ìó›6YW»63ú¡Û,îØnU²^}cUïéùQC¦¢\\F5r¿aµxO¿O­áÏ‹#¾X\ZÔ.6eÙ¤S.ÒãŸÿ’>û“í)Áö¶9ä-ûl‚a\Z^TÂC¥,óºl3v}Yš¨) Ü÷+ŸŠ‘_Šxqì‚Ì˜…ßÍ{suvj+¤d,zôŒ±{ô‰ë….§jÈˆ‹Õ·67ù‡>„0ud¹H…sîÊô5²X±¹2¤Ê‰HÔíã``¨pAq~ôLaéÊWc´Z%™E]b@ùKLt]ô(HŞ™½p¢©ş­óÏùÏ”±¸c …AÖ?\\M\"Wªjğô+õ¥ÄssáN¿†(ÚõÜÁçS«ŸÒ#P\\³‹†Tà¤Ân·Qí_?g‡lÛÅ®‰wP=ìg$°×ïÄ ÀÀ÷yP«TCÑS^ó+;ÜÎ9ÀQ²v¹(z5•j Â\r­—äËE½bÌSsª1ë-§\"ª1|¨só\Z‡;{­#}tµ?…hÉ>7+;YÂjÅğ™íc×)…(ÓÅœ}›ğ`eğÍ–JI;×RÊÜ[kGDJƒ‚>\\}(â›	íè†æõşöª]ÑD7¶å—¯Ÿótƒ„¬„Ğ7(Q•\'3G¼³^5Û~§ç5r[îÿşw±u]¢|ì°¶?t=S©áˆô¼èaO	—2ûq»R7¾öH¥\"©Š®›p×\"ß‹Ô‚eçFm¢Íƒƒdßî/§œ\0©§.É’˜ÓnŞKXF²¿ï†[` 5ôûóÇºo…ˆCğ‚wªEºá7óŞş).RŞ9æĞ“×‹˜ÌmrÁ©°OPŒ(ÒĞ	iÑı\"SòCÉ+mù”ÌÁ0g,æ,¡`ÿq¶¨Û+/8õ×˜+DıÒ£¨†‡½“@øÊÏã µ#@™-{SÓiçêc<Ÿ¼*Š?›B}*‡`æ„]7&:ŠvÛÛõ¡äÉO‘ŞrÂ=óMcÎéJW>ï.ùd>Y¡Vk¡ìæ*ğ8ê<|dì¨¤Ç½iI\nõTÑÂB±z1ùà9¨`¹X}¹Sª¢bÊlÔZ<ûåsPY÷Ì\Zi«–õ3Ùcuç‹Æ,²ƒº×î4RÌİ©ØŠ¨ü­q*ÌÙoI¬ñ°ŒTÜïò&ìÉ32l`Â³VJñœQÏ[°Bõ	C2åÇ47ã&t((ÎãŠ† ÖZL…/W=ºéÄ-;÷=J]·=¸{8IÈÑ²<Ëäİà[¸@9ä ¤çâË¯@>–šEk\\´;LVõU9?zøÄ}LØyş>zø‚ï5xÎŠÉ+·:g™}pI>:sÅçö\\5é³¥›r†*®F~\'•è™Ä«èr„‚Õ«üÎ˜øÇ{WGc+M¼­QÊ3ı{TÊî|_$ª(³’pvyı5fáóŞş!\'µ¥>‡Òß=³_=y#Ì–“F Ô«,rÂÀŒE˜ú©ˆHŞ\"¸H\nä\")‘‹#wº,ùÇD˜j³ô¯¼&oÁOï.\rÍŸ6u¦ÈjQDéô&—‰K?ÁÚyĞË§?[àğv±?µmyOi {\'BŞ:ä±&Æ‰=’r›´¥wNªãjnShLoHšø7…ÈïN¹Gçe}µ,E¹æT(Ån¨aƒlw6šØÀ\rágâ+Ÿ‘-¾s÷xµôKÙ==Çÿ™ FŠÊ\n\"Ï¡iÌnòÚ4ùz2¿ø:ÊÊ[WÙµ÷O‘ûøP²à3J”5\0+\0òaß§ı@4­ç}AêØf’+˜;É LœSv¿\n¯Ç“{CñîYßiİ¿’%´OF\Zœ=+GáÌe–÷ËZİ¹D•M\"¹È\"K×Î@*\ZÂçD\ZÇ×‘hˆ87è%-~ Möğv‘øñ¶O,›÷×3ƒ&[ø H±@zïĞA±ôP	ˆL6œˆ–¹ä½œ¸b[Œ¹€Ñã²¡¼ùoKªC1Ÿ{ãb¶İÔ v«‹ßºSWŒ¹k†°Ã9U¢0V­hïˆı¯_t!÷‹\Z:|,]ßX=fåôaåî«TcÈqTYO.ë¨¢Ş[1U³æ‹L¡—ÑÀ/ÛTWĞú9‘eG«ïşD´)}É¹¯²gõöªyïüœŸÚÂ˜O[ß:Soshú\"ö»H<F1¬¸Š¿†“#Ì¦.˜3L¨QF|&Íq]_lÍAƒ¸&oå†Û¿ëÉa¢ú®ïH\r¬J@?aï!§)\0y´§ŞUÔê¬mK„mo½m^<PkçJT¿_cA=`–Q 0£S\n¢9„| s,ö‚F…F¸Aê;iíÇP¤Í†\Zçğ\r`ä…é,XüÈ…°r–‚²;´ zO¾—ªTV?ç¿8J¨ÒÓH1¡ïuMFÒ…„¨;]G–ûOUšjŸƒšı¼¿öğ·Õ6~MA¸Uä=©`”0djlw[ÜşVŠŸôò9ö¤ÒÕÆCs|Ã@o’#üRdˆ\"&Dh8..ÆòIÂ³Àœ¥àº¸Aì˜WãÙ)Th¨%WO“ë%0¡ÆQ@£(})¿~o¥íªl0–÷÷ê,Ù¯\r”¼ÓâE±®9†Më{0¦Ãñ·¶í[¿å¢±êqT„ù,ær&-oNâí[ğ}\nÈ°ÇÛ¥\\’¶ŞŞè»Ÿ¥.+\n\0a0!dÙ8ŠnÙöÎì§ùQ}ô<Qè%önÊ_z~T8í½Õf™±Ş§Šqƒğ®\0Á€)œèV\0ÃµD•ÁhE	å-‹eÅÜñ¡hªÜF¿/­ZÒ?ù¸…ŸÍ{ç[¼m\\rf•¿L¤\nÄÜ!#G<yWG§\nDn`ò`4­ÁŞÔ:¸}œÏ„Ò‘.ìLpûx[TÿŠ9˜²7ã;øG‡XßX\rm(\0 ú jªhíG©\0)3ñ÷¿’fè>ôDå9ºó«]\r¹¥©\'8lã«4Â†Ô“\0æ[<—2\n`wHÔ÷å,VÓ+à9xàŞ„°½1×%ÒxäBycárÇSôó³ÈĞè¦3Æªwÿ¢hò0²Ü¨GñZ”@.¢Ci–ì@2Õxû=„ºÏİ±ìÙÄ¡Mû=Ô¯~Ü1O4hŒƒãZ™´¡ú¼%¤¬¦ÊJ\'‹%±9û. û.ìyä†Õ;ˆŠH@Æ3<\rùAÃË°¾¥üTa&„õ4¨ÒQó—Ré ¢>È%VòŠ#Åd\"KÎá6õo`¤Ïî{r_–È§UÅgê‡!Ş\Zß2¥ßÊöì¬B­Ôàu÷Qì\r“¤L¯ë¯%Û¶ÙÆ«?ç³ {X¸j1H40¹F)¶E9§ÇÅjÛé×±Ÿ\"\\(ò:E2^ üèï›Ìëkw<9ğ¼5ƒù\ZíF½iİ]xÌ&,µÉŒ|î‡•»œC_şÆòÕú»*T—Èà04çqÂ*•ÓÎ¾Vc +ƒNŠ•°Çôò§ÊC.ÿ/xÑb4\n_¢ñu3ş­ÉØb«aöÑ\rW4ˆŠÆNü\'œâP›4I¬µ{wî‘bù¯áƒÿº+«pæ—ÓŞ˜EŞ;3Â¶gÊ­\")k+i äe¤L($•“ïŞI¿EßúxD‰³Çgß%›8L6R¼õ‰ÏYDŠÁ@0·M8j˜óŞL¡ûb.æÔ\0„¦*&^mÙ´#¦5uxgı™ÊVûf…İ½p&Åëì \" 5’ç…„”N†ûŠ}‹xw¶áár³¼]H@ŞœÍå<J=…ò÷}€j;ó½ˆ¢}éÓG¤ˆütŠQÇ!‡\nÑ èÚT0»Q ^İû>²©|;_Û¢1\"ôİZ”ø´c[b$gbÊºàb‡J)P§%Íùµjæì	äÌ[!4ûÇ†÷AÂO\'vÏNz<ÓàğFp5»j-ÜÓ–:œ*Óˆ²qÂ·,hıæ°º³­ù½©Æâ‹1‰«=øVz¾+6%°è6Éùx,Ş6$I©€¡1¦.±©ª·?9€öø­‹òl;{ê$$PÛèK\'\0,ïÙ,ÃÃ8J&×’»¥CŸ´d–T³‡]B=äX«š)cıË#Ï¨ıÒqø‹é;œ®Ÿ:áFEÁ§¶}9‘úÜÇ?6ZøÙO{Q] LTcƒÑ Œâgµ¯œK\r/å5%­+{u®k ßg—Ÿ=î¯Ä¢õÈÔÅ\nƒ¯vDÔ_fé=.¤å\r„hJHÓyƒ7€ld\"‡…|Ì2Ë¥8±ÉºÖRá÷(¤\nØÎØO-­™ÿÓŞµ\0GUásw7ûÈ’ì&$›\0 D‡b±–±´U (\"C•gTb§\n/+™Ñ´¥e‚ÀX…ˆCª`+±ƒÒ§<Kå%‚„tI²d¯Ùìûqúıw³@ ¯#rvÆôŞ»÷~{ïÏùÏ÷`G7å·¸‘?~2ï[¾,^°®ñf÷‘İ#V9ø´¥¥)“æµ«s±p6O<ğO¦ED‚šØK^9ww=¹LN}¬mËÌÈoÉÿwĞpúù§]é~+øbıW]ÜkhIF°`íÁÔìÜû®şí¶wúwm9İ°¥ˆ¥hªY}<2ˆ(›\nSvr< ¥Å9l­A³\\n\Zı“ÿ®ÏŒ#ü­cz‚æ<ëPKif2É§ï¨ö;ö%íÿûı‚ß°£uæÛÙ‰)±‚Ör|×÷ÿ¼qH›ó?ñë,Ó{±¼f¼€°ª½’\rõ:ŒftÏ-gI9W4m°µ ¦b)O²­QlˆvO#˜ÈÈ…*)}”N>Í…ñg%˜@Á¶Axßîõg¬‡¹Æ~`Ó‘Qm‰P&hƒìs³¶åŞ=hbWÌè‹õûª{ºõşÙgÊå›”’Æˆú-¤«RÍú«lüóv¿¡ºz>mí?ôé‚Å56ùåÚ÷şÔüû¤=µÖúµììCñ,ô(‘ò‰Ê¾£İsî:Ö—×ç—¿ûÇN­>å–¼±ãè—³«`FÂêyÌÆ6Fp:s³‘ƒSONûàãSîíÿÅ®cEÉ¾zÇY47k06\"?\Z¯I`OÂó˜“âW¹8\"iâÿ‘>Dæ$¯dŠUø6´Ù/ÀÂ€£õğ›ÙævªäÅ÷î%Sxæg(dZMÓä©] ÉÍZRš8ee»\nÌÑÂy¼Ïb´ÑYÎ…=˜ÀÌ¥râÔ‚İ—·¯>Zóûaj#ÄˆüP‘çÜáÜ Á]Ô%±…ëúØzt$\'\'£Éş¸\\ÖIÒé#ïV¼ú6 æHƒ°1@¬ŠÁŠŞŸ¢&©İ at—É.H‘µ*Óæ=Ç‚£Î‰×¤·°ˆz+ø¹IY,	¡j\Z4“9Šg\rè9:\\:–_È´<¡Å½DË¼m~.°ÆT‹‘]ùÈ}ZXÑz=2ÎĞT©MlĞ¦ÿºUfx–Phóh7Ø@>>İ %áÖSò”©RXÄù\\)0á¯¢XÚÀ`½—•0§M)¼‘)¹ùTšDwäL§BwzÌ÷BYÛM8ÜÙó¤ı4·ò@ƒše ™üÈÏ.¾lø÷šŠÉR8<Í?¥H–Ó¡¨+çÓ•}³—mØS^Y?ÊîÁ—2İÀË	aj©Õiwëm™ñQá´Ê®ÿVİ÷óÍ«¸¹òŠúX|à^¤ ¯7*§4eÄØv˜“ï¯÷Ä~¶O§C  -8H˜Öx0-‰+[FëğıqvıJr•³x,“p‹Dˆô†ìp]K?›õ\ZÑ²_ÁŞï´n—í[»oÓ—aI6:	Õ¨ÑaVµ¤µÃ\nvöŒLfÉÎeÉwŞSªJÚêu^øxw}õ7ŒÔT¸.â{‘“4â!²Lc™óZ\'Şè^àNë¡²uÈ2 S‹<\"ŒputiĞ›Ã\\b!|–¿×°‘Ê£Ó†v®ıt7ûö†3«} lÑgHS/æÚ~nèâPòØ“ÅsÙÛµhÅÖ€£‡BC*­°²Åu‘_L‚§ÖT_òL‡BÒ\"1ÌİŒ<yçR¬†9ïµÄMë{”ïÄû˜ßTØÃ)V‘lÊ| Ã7Ğ­ú0Šó¾5ğ5TŸË5™kµAªW—å’Ù\\Agïi<o—º:tå·èØC~;?]*0¾Æ²4|1çx‚§Œ¥\r\"aì*ZÖu\r_%âƒFË>fÕ÷bw¯XÆäxÌs÷´H½»æ”ˆtƒVM,ülXêŒ†YÅµ\0ç%ÒË ²¾1AjX™VŸ“ı!¦lD…Wå½)Çô»O˜€+¶´=°­Ëû\\®üm…¹~+ĞZÓê‹â~§Hš\ZwM;†3„hşˆ(h\ZŠ>àpÏd,_ÛA“&c#êßàßÍÓ$ªFh’·.¹.c¨”¢wUT­qÓléÌEoóŠ\Zê\Z h€Œ± •Éd`.#5®Hç!äöRp\n\'#k°xõË÷ä©[å‰´C±‰@@ pº\\`\"Ç­>ö(·8áêu2‰•8–¨9–Æ]ùPí ´8Æã ü”ÙèUùì¸üó&A‚D\rcZbŒìÒìšFÿ-¼d§Ø»ã 4ò ¤Dò2……€EÍ=5ù”CPcÓl#a„Øø¨dm¹ğ©²*Bó…\nK‚I+E\rq§	Wˆêƒe?>Ç{6ƒys©&ÇõH›§Åt	vRÑ©wªYFas„î\0Ùá2L¡héš*„bØÛ²2)Ë˜áCÆŞœ°ò’š@Ô­E:!|fıT\\W+ÒvàŸ\r¹ˆ§æRãRÚÑfJ^RÄ]!ôwêà<–1mSTq7˜@@ p¥éU,ªO.äG1\n\0ØèzÓH†”×Š©ÃU#\0MKˆˆl v¹ô=Ø—\n˜9Ó!Ğ¥•¢¡x?4V{ÑMü™Ã#úé£\"£ –¦÷2ëú©’u]Ëd=jĞà|üJÌŠ<0âz}·&í\'Fq0€@@A êonÛ©ùãêw•Jšúpa‚\\ñÈ•şê	¬ÀU¸ï‚,C\"W4ŸnH‡G2°iiòxH\\Gy<×idZ)0tE~F6è¯ÔÖ¸qºT¿u‘Iu¦DÊTÎ…Ÿ¢TÀƒ‘3~ÌúÍŞ\ZuÄ½%tÓÆ^µq¼éââRNTh)BPçÒRsØşúg™ˆT.¸ØÆ‡\\™å»ç³ÕŸü¢Ø•ålI\ru¨Ò¨\r\'è]W#\ra…ƒCLG|¦EÉ~0ßš*Õî.NMØµà+0\rüqdÅĞÚ\0:øÌwrŒi÷Ü~Hâ\0\0\0[IDAT4·FÜ(@çˆúÛÛë<3ŞUö‹ÒP 7|l¿b1€E‚š\"]‘ÑtÎ”D ¡gãWËèŸÀïMÙóê{YvQ³2ĞŒÅj–µiõ›\nUHéíD>4¢pØæ‘²Ij0$Ö}ñÔú™ıùùb½}C;Ç‚k£%ŸGZë2!Sø—«˜qpNÔ¯¿ó?…ØS ğİC êåù<‡t†AÃ‡ğ ÄYq0\'šb¸\r•*RüDÓEĞÂ)‡ZYÂVğ/D•¤òyf³…oŞÏÊ	` b4R4Ä(8F7pbƒÇ€/A‘³˜fh>²2MÿzvÂ:RÕKÃ¹Åm…x‘ø90w„F‡°ï±UÄa¿áâwï–W$h?Q/0×~µíÔ¯¸ºñ‹EØ–&hñĞ\rk?dù\\ˆ¡tGˆÓh:DæETdÙ\0şŒˆr¹ ¿°é³ÙáKÓYÑv/+«ñ0\'ÔÅ´@)\')sMş‘W§4koªß™Ï{ø\0eF:`ìê!;Pcô$ÃÊ0~ÌŠü?šĞ)Nûa[\n„@·Gİ¾mqÉ? c4#ÁqKÛ;ÿCêœW\\ÕÛæ¼T’ïƒ~$G.ÈÚ¥\0l\0à\"BÏE¥8§!2g@Q\"†÷}f\"Óèæ\ZûM¿y¢äºÜ×öŸ÷¾Ü¿»ÇÙƒ¸(’ÑÂ–05nĞ@|×ÖkòÍ3jÄ-!Dn/0‘Ó½Tù:Oí×ºëY}Õ[vvi«Ù<„©díhæs—“¸¼A$y•À‡l`#ü˜İ¸ëãôÀÍëÜ×Ìhw0üuUä\rLöƒ¡DÊ<=GûûŞµ ÙÀ8ºğ‰£	7Cà+0íıü¹³nØQlü•|²!ºÕN\rõ]ˆLV–Xâ&IV¦üÔË‰q¢³ÉxhüTG±ËÃ8“Î\"IÜ4¶³½ç$¶:‡À·®À´vDÜõÖï|&à­ÿÎÃ#òĞE¦¥JjÓ+5IYÛ:wùb/€@ ;¸%\nLw -t¢Àt¶âÈÛQ`nû[@\0 è>Dé>lÅ‘·=ÿ	ïéÇì²›\0\0\0\0IEND®B`‚',1,'2015-05-19 19:19:32');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encargado`
--

DROP TABLE IF EXISTS `encargado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encargado` (
  `idEncargado` int(11) NOT NULL AUTO_INCREMENT,
  `idSucursal` int(11) DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `apellido` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `celularPersonal` varchar(15) DEFAULT NULL,
  `usuario` varchar(150) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idEncargado`),
  KEY `fk_Encargado_Sucursal1_idx` (`idSucursal`),
  CONSTRAINT `fk_Encargado_Sucursal1` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encargado`
--

LOCK TABLES `encargado` WRITE;
/*!40000 ALTER TABLE `encargado` DISABLE KEYS */;
INSERT INTO `encargado` VALUES (17,4,'Eder','Haro','ed@gmail.com','942099015','ederm','123456',0),(18,5,'marvin','de la cruz ','marvindelarc@gmail.com','947454589','marvin','123456',0);
/*!40000 ALTER TABLE `encargado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `idCostoTipoHabitacion` int(11) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `vista` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idHabitacion`),
  KEY `fk_Habitacion_CostoTipoHabitacion1_idx` (`idCostoTipoHabitacion`),
  CONSTRAINT `fk_Habitacion_CostoTipoHabitacion1` FOREIGN KEY (`idCostoTipoHabitacion`) REFERENCES `costotipohabitacion` (`idCostoTipoHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES (1,1,2,4,1,''),(2,1,1,1,1,''),(3,1,1,2,1,'');
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalacion`
--

DROP TABLE IF EXISTS `instalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instalacion` (
  `idInstalacion` int(11) NOT NULL AUTO_INCREMENT,
  `idServicio` int(11) DEFAULT NULL,
  `idSucursal` int(11) DEFAULT NULL,
  `descripcion` text,
  `estado` int(11) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idInstalacion`),
  KEY `fk_Instalacion_Servicio1_idx` (`idServicio`),
  KEY `fk_Instalacion_Sucursal1_idx` (`idSucursal`),
  CONSTRAINT `fk_Instalacion_Servicio1` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`idServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instalacion_Sucursal1` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalacion`
--

LOCK TABLES `instalacion` WRITE;
/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` VALUES (1,3,4,'cancha futbol grande',1,'2015-05-19 19:19:32'),(2,2,5,'cancha tenis',1,'2015-05-19 19:19:32'),(3,1,4,'jajajjajajajjajjajajjajaja',1,'2015-05-19 19:19:32'),(4,1,5,'asdas',1,'2015-05-19 19:19:32');
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago_empresa`
--

DROP TABLE IF EXISTS `pago_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago_empresa` (
  `id_pago_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(11) DEFAULT NULL,
  `id_paquete` int(11) DEFAULT NULL,
  `monto` decimal(12,4) DEFAULT NULL,
  `baucher` blob,
  `fechaRegistro` datetime DEFAULT NULL,
  `fechaInicio` datetime DEFAULT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_pago_empresa`),
  KEY `fk_pago_paquete_idx` (`id_paquete`),
  KEY `fk_pago_empresa_idx` (`id_empresa`),
  CONSTRAINT `fk_pago_empresa` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_paquete` FOREIGN KEY (`id_paquete`) REFERENCES `paquete` (`id_paquete`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_empresa`
--

LOCK TABLES `pago_empresa` WRITE;
/*!40000 ALTER TABLE `pago_empresa` DISABLE KEYS */;
INSERT INTO `pago_empresa` VALUES (1,6,2,140.0200,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `pago_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquete` (
  `id_paquete` int(11) NOT NULL AUTO_INCREMENT,
  `monto` decimal(10,2) DEFAULT NULL,
  `meses` int(11) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_paquete`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES (1,50.00,4,1),(2,50.00,4,1),(3,50.22,2,1),(4,1254.00,4,1),(5,11.10,11,1),(6,50.00,2,1);
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(200) DEFAULT NULL,
  `apellidos` varchar(200) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `informacion` varchar(150) DEFAULT NULL,
  `puntualidad` int(11) DEFAULT NULL,
  `honrades` int(11) DEFAULT NULL,
  `educacion` int(11) DEFAULT NULL,
  `calificacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'eder','chupa pigas','745845412','asa@gmil.com','22554455','marica','soygay','2',5,5,2,4);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promociones`
--

DROP TABLE IF EXISTS `promociones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promociones` (
  `idPromociones` int(11) NOT NULL AUTO_INCREMENT,
  `dato` varchar(45) DEFAULT NULL,
  `fechaInicio` datetime DEFAULT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idSucursal` int(11) NOT NULL,
  PRIMARY KEY (`idPromociones`),
  KEY `fk_Promociones_Sucursal1_idx` (`idSucursal`),
  CONSTRAINT `fk_Promociones_Sucursal1` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promociones`
--

LOCK TABLES `promociones` WRITE;
/*!40000 ALTER TABLE `promociones` DISABLE KEYS */;
INSERT INTO `promociones` VALUES (1,'15% descuento habitaciones dobles',NULL,NULL,'1',4),(2,'15% descuento',NULL,NULL,'1',5);
/*!40000 ALTER TABLE `promociones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `idProvincia` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idProvincia`),
  KEY `fk_Provincia_Departamento1_idx` (`idDepartamento`),
  CONSTRAINT `fk_Provincia_Departamento1` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'Bagua',1),(2,'BongarÃ¡',1),(3,'Condorcanqui',1),(4,'Chachapoyas',1),(5,'Luya',1),(6,'RodrÃ­guez de Mendoza',1),(7,'Utcubamba',1),(8,'Aija',2),(9,'Antonio Raymondi',2),(10,'AsunciÃ³',2),(11,'Bolognesi',2),(12,'Casma',2),(13,'Carhuaz',2),(14,'Carlos Fitzcarrald',2),(15,'Corongo',2),(16,'Huaraz',2),(17,'Huari',2),(18,'Huarmey',2),(19,'Huaylas',2),(20,'Mariscal Luzuriaga',2),(21,'Ocros',2),(22,'Pallasca',2),(23,'Pomabamba',2),(24,'Recuay',2),(25,'Santa',2),(26,'Sihuas',2),(27,'Yungay',2),(28,'Abancay',3),(29,'Andahuaylas',3),(30,'Antabamba',3),(31,'Aymaraes',3),(32,'Cotabambas',3),(33,'Chincheros',3),(34,'Grau',3),(35,'Arequipa',4),(36,'Caylloma',4),(37,'CamanÃ¡',4),(38,'CaravelÃ­',4),(39,'Castilla',4),(40,'Condesuyos',4),(41,'Islay',4),(42,'La UniÃ³',4),(43,'Cangallo',5),(44,'Huamanga',5),(45,'Huanca Sancos',5),(46,'Huanta',5),(47,'La Mar',5),(48,'Lucanas',5),(49,'Parinacochas',5),(50,'Paucar del SaraSara',5),(51,'Sucre',5),(52,'VÃ­ctor Fajardo',5),(53,'VilcashuamÃ¡',5),(54,'Cajabamba',6),(55,'Cajamarca',6),(56,'CelendÃ­',6),(57,'ContumazÃ¡',6),(58,'Cutervo',6),(59,'Chota',6),(60,'Hualgayoc',6),(61,'JaÃ©',6),(62,'San Ignacio',6),(63,'San Marcos',6),(64,'San Miguel',6),(65,'San Pablo',6),(66,'Santa Cruz',6),(67,'Acomayo',7),(68,'Anta',7),(69,'Calca',7),(70,'Canas',7),(71,'Canchis',7),(72,'Cuzco',7),(73,'Chumbivilca',7),(74,'Espinar',7),(75,'La ConvenciÃ³',7),(76,'Paruro',7),(77,'Paucartambo',7),(78,'Quispicanchis',7),(79,'Urubamba',7),(80,'Acobamba',8),(81,'Angaraes',8),(82,'Castrovirreyna',8),(83,'Churcampa',8),(84,'Huancavelica',8),(85,'HuaytarÃ¡',8),(86,'Tayacaja',8),(87,'Ambo',9),(88,'Dos de Mayo',9),(89,'Huacaybamba',9),(90,'HuamalÃ­es',9),(91,'HuÃ¡nuco',9),(92,'Leoncio Prado',9),(93,'MaraÃ±o',9),(94,'Pachitea',9),(95,'Puerto Inca',9),(96,'Yarowilca',9),(97,'Lauricocha',9),(98,'Chincha',10),(99,'Ica',10),(100,'Nazca',10),(101,'Palpa',10),(102,'Pisco',10),(103,'ConcepciÃ³',11),(104,'Chanchamayo',11),(105,'Chupaca',11),(106,'Huancayo',11),(107,'Jauja',11),(108,'JunÃ­',11),(109,'Satipo',11),(110,'Tarma',11),(111,'Yauli',11),(112,'Ascope',12),(113,'BolÃ­var',12),(114,'ChepÃ©',12),(115,'Gran ChimÃº',12),(116,'JulcÃ¡',12),(117,'Otuzco',12),(118,'Pacasmayo',12),(119,'Pataz',12),(120,'SÃ¡nchez CarriÃ³',12),(121,'Santiago de Chuco',12),(122,'Trujillo',12),(123,'VirÃº',12),(124,'Chiclayo',13),(125,'FerreÃ±afe',13),(126,'Lambayeque',13),(127,'Barranca',14),(128,'Cajatambo',14),(129,'Canta',14),(130,'CaÃ±ete',14),(131,'Huaral',14),(132,'HuarochirÃ­',14),(133,'Huaura',14),(134,'Lima',14),(135,'OyÃ³',14),(136,'Yauyos',14),(137,'Prov. Const. Callao',15),(138,'Alto Amazonas',16),(139,'Loreto',16),(140,'Mariscal Castilla',16),(141,'Maynas',16),(142,'Requena',16),(143,'Ucayali',16),(144,'Manu',17),(145,'Tahuamanu',17),(146,'Tambopata',17),(147,'Ilo',18),(148,'Mariscal Nieto',18),(149,'SÃ¡nchez Cerro',18),(150,'Daniel Alcides CarriÃ³',19),(151,'Oxapampa',19),(152,'Pasco',19),(153,'Ayabaca',20),(154,'Huancabamba',20),(155,'MorropÃ³',20),(156,'Paita',20),(157,'Piura',20),(158,'Sechura',20),(159,'Sullana',20),(160,'Talara',20),(161,'AzÃ¡ngaro',21),(162,'Carabaya',21),(163,'Chucuito',21),(164,'El Collao',21),(165,'HuancanÃ©',21),(166,'Lampa',21),(167,'Melgar',21),(168,'Moho',21),(169,'San Antonio de Putina',21),(170,'San RomÃ¡',21),(171,'Sandia',21),(172,'Puno',21),(173,'Yunguyo',21),(174,'Bellavista',22),(175,'El Dorado',22),(176,'Huallaga',22),(177,'Lamas',22),(178,'Mariscal CÃ¡ceres',22),(179,'Moyobamba',22),(180,'Picota',22),(181,'Rioja',22),(182,'San MartÃ­',22),(183,'Tocache',22),(184,'Candarave',23),(185,'Jorge Basadre',23),(186,'Tacna',23),(187,'Tarata',23),(188,'Contralmirante Villar',24),(189,'Tumbes',24),(190,'Zarumilla',24),(191,'Atalaya',25),(192,'Coronel Portillo',25),(193,'Padre Abad',25),(194,'PurÃºs',25);
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntuacionhotel`
--

DROP TABLE IF EXISTS `puntuacionhotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntuacionhotel` (
  `idPuntuacionHotel` int(11) NOT NULL AUTO_INCREMENT,
  `idReserva` int(11) DEFAULT NULL,
  `limpieza` int(11) DEFAULT NULL,
  `servicio` int(11) DEFAULT NULL,
  `comodidad` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`idPuntuacionHotel`),
  KEY `fk_Puntuacion_Reserva1_idx` (`idReserva`),
  CONSTRAINT `fk_Puntuacion_Reserva1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntuacionhotel`
--

LOCK TABLES `puntuacionhotel` WRITE;
/*!40000 ALTER TABLE `puntuacionhotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `puntuacionhotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntuacionusuario`
--

DROP TABLE IF EXISTS `puntuacionusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntuacionusuario` (
  `idPuntuacionUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `puntualidad` int(11) DEFAULT NULL,
  `honrades` int(11) DEFAULT NULL,
  `educacion` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `idReserva` int(11) NOT NULL,
  PRIMARY KEY (`idPuntuacionUsuario`),
  KEY `fk_CalificacionUsuario_Reserva1_idx` (`idReserva`),
  CONSTRAINT `fk_CalificacionUsuario_Reserva1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntuacionusuario`
--

LOCK TABLES `puntuacionusuario` WRITE;
/*!40000 ALTER TABLE `puntuacionusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `puntuacionusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) DEFAULT NULL,
  `idSucursal` int(11) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_Reserva_Persona1_idx` (`idPersona`),
  KEY `fk_Reserva_Sucursal1_idx` (`idSucursal`),
  CONSTRAINT `fk_Reserva_Persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Sucursal1` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,'sauna',1,'2015-05-19 19:19:32'),(2,'piscina',1,'2015-05-19 19:19:32'),(3,'casino',1,'2015-05-19 19:19:32');
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpresa` int(11) DEFAULT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `pisos` int(11) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL,
  `longitud` decimal(18,10) DEFAULT NULL,
  `latitud` decimal(18,10) DEFAULT NULL,
  `limpieza` int(11) DEFAULT NULL,
  `servicio` int(11) DEFAULT NULL,
  `comodidad` int(11) DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  `entrada` varchar(200) DEFAULT NULL,
  `salida` varchar(10) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`idSucursal`),
  KEY `fk_Sucursal_Distrito1_idx` (`idDistrito`),
  KEY `fk_Sucursal_Empresa1_idx` (`idEmpresa`),
  CONSTRAINT `fk_Sucursal_Distrito1` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sucursal_Empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (4,6,1192,'scs',4,'044470117',-79.0069420000,-8.1093920000,0,0,0,0,3,'las 24 horas',NULL,'2015-05-19 19:19:32',1,'2015-05-19 19:19:32'),(5,7,1192,'sdsddsd',5,'044224455',-79.0238510000,-8.1185690000,0,0,0,0,4,'24 hrs.',NULL,'2015-05-19 19:46:37',1,'2015-05-19 19:19:32');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipohabitacion`
--

DROP TABLE IF EXISTS `tipohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipohabitacion` (
  `idTipoHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombreComercial` varchar(150) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipoHabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipohabitacion`
--

LOCK TABLES `tipohabitacion` WRITE;
/*!40000 ALTER TABLE `tipohabitacion` DISABLE KEYS */;
INSERT INTO `tipohabitacion` VALUES (1,'Simple',1),(2,'Familiar',1),(3,'Triple',1),(4,'Matrimonial',1),(5,'sadasd',1),(6,'Hambiental',1),(7,'doble',1);
/*!40000 ALTER TABLE `tipohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webadmin`
--

DROP TABLE IF EXISTS `webadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webadmin` (
  `idWebAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `apellido` varchar(200) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idWebAdmin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webadmin`
--

LOCK TABLES `webadmin` WRITE;
/*!40000 ALTER TABLE `webadmin` DISABLE KEYS */;
INSERT INTO `webadmin` VALUES (1,'marivn','de la cruz','mdlcr','m456',1,'m@dj.ca',1);
/*!40000 ALTER TABLE `webadmin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-28 16:19:10
