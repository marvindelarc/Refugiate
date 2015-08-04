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
INSERT INTO `departamento` VALUES (1,'Amazonas'),(2,'Ancash'),(3,'Apurimac'),(4,'Arequipa'),(5,'Ayacucho'),(6,'Cajamarca'),(7,'Cusco'),(8,'Huancavelica'),(9,'Huanuco'),(10,'Ica'),(11,'Juní'),(12,'La Libertad'),(13,'Lambayeque'),(14,'Lima'),(15,'Prov. Const. del   Callao'),(16,'Loreto'),(17,'Madre de Dios'),(18,'Moquegua'),(19,'Pasco'),(20,'Piura'),(21,'Puno'),(22,'San Martí'),(23,'Tacna'),(24,'Tumbes'),(25,'Ucayali');
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
INSERT INTO `distrito` VALUES (1,'Bagua',1),(2,'La Peca',1),(3,'Aramango',1),(4,'Copalli',1),(5,'El Parco',1),(6,'Imaza',1),(7,'Corosha',2),(8,'Cuispes',2),(9,'Chisquilla',2),(10,'Churuja',2),(11,'Florida',2),(12,'Jazá',2),(13,'Recta',2),(14,'San Carlos',2),(15,'Shipasbamba',2),(16,'Valera',2),(17,'Yambrasbamba',2),(18,'El Cenepa',3),(19,'Nieva',3),(20,'Río Santiago',3),(21,'Chachapoyas',4),(22,'Asunció',4),(23,'Balsas',4),(24,'Cheto',4),(25,'Chiliquí',4),(26,'Chuquibamba',4),(27,'Granada',4),(28,'Huancas',4),(29,'La Jalca',4),(30,'Leymebamba',4),(31,'Levanto',4),(32,'Magdalena',4),(33,'Mariscal Castilla',4),(34,'Molinopampa',4),(35,'Montevideo',4),(36,'Olleros',4),(37,'Quinjalca',4),(38,'San Francisco de Daguas',4),(39,'San Isidro de Maino',4),(40,'Soloco',4),(41,'Sonche',4),(42,'Camporredondo',5),(43,'Cocabamba',5),(44,'Colcamar',5),(45,'Conila',5),(46,'Inguilpata',5),(47,'Lámud',5),(48,'Longuita',5),(49,'Lonya Chico',5),(50,'Luya',5),(51,'Luya Viejo',5),(52,'María',5),(53,'Ocalli',5),(54,'Ocumal',5),(55,'Pisuquía',5),(56,'Providencia',5),(57,'San Cristóbal',5),(58,'San Francisco del Yeso',5),(59,'San Jerónimo',5),(60,'San Juan de Lopecancha',5),(61,'Santa Catalina',5),(62,'Santo Tomás',5),(63,'Tingo',5),(64,'Trita',5),(65,'Chirimoto',6),(66,'Cochamal',6),(67,'Huambo',6),(68,'Limabamba',6),(69,'Longar',6),(70,'Mariscal Benavides',6),(71,'Milpuc',6),(72,'Omia',6),(73,'San Nicolás',6),(74,'Santa Rosa',6),(75,'Totora',6),(76,'Vista Alegre',6),(77,'Bagua Grande',7),(78,'Cajaruro',7),(79,'Cumba',7),(80,'El Milagro',7),(81,'Jamalca',7),(82,'Lonya Grande',7),(83,'Yamó',7),(84,'Aija',8),(85,'Coris',8),(86,'Huacllá',8),(87,'La Merced',8),(88,'Succha',8),(89,'Llamellí',9),(90,'Aczo',9),(91,'Chaccho',9),(92,'Chingas',9),(93,'Mirgas',9),(94,'San Juan de Rontoy',9),(95,'Chacas',10),(96,'Acochaca',10),(97,'Abelardo Pardo Lezameta',11),(98,'Antonio Raymondi',11),(99,'Aquia',11),(100,'Canis',11),(101,'Colquioc',11),(102,'Cajacay',11),(103,'Chiquiá',11),(104,'Huallanca',11),(105,'Huasta',11),(106,'Huayllacayá',11),(107,'La Primavera',11),(108,'Mangas',11),(109,'Paclló',11),(110,'San Miguel de Corpanqui',11),(111,'Ticllos',11),(112,'Casma',12),(113,'Buena Vista Alta',12),(114,'Comandante Noel',12),(115,'Yautá',12),(116,'Carhuás',13),(117,'Acopampa',13),(118,'Amashca',13),(119,'Anta',13),(120,'Ataquero',13),(121,'Marcará',13),(122,'Pariahuanca',13),(123,'San Miguel de Aco',13),(124,'Shilla',13),(125,'Tinco',13),(126,'Yungar',13),(127,'San Luis',14),(128,'San Nicolás',14),(129,'Yauya',14),(130,'Aco',15),(131,'Bambas',15),(132,'Cusca',15),(133,'La Pampa',15),(134,'Yánac',15),(135,'Yupá',15),(136,'Cochabamba',16),(137,'Colcabamba',16),(138,'Huanchay',16),(139,'Independencia',16),(140,'Jangas',16),(141,'La Libertad',16),(142,'Olleros',16),(143,'Pampas',16),(144,'Pariacoto',16),(145,'Pira',16),(146,'Tarica',16),(147,'Huari',17),(148,'Anra',17),(149,'Cajay',17),(150,'Chavín de Huantar',17),(151,'Huacachi',17),(152,'Huacchis',17),(153,'Huachis',17),(154,'Huantar',17),(155,'Masi',17),(156,'Paucas',17),(157,'Pontó',17),(158,'Rahuapampa',17),(159,'Rapayá',17),(160,'San Marcos',17),(161,'San Pedro de Chaná',17),(162,'Uco',17),(163,'Huarmey',18),(164,'Cochapeti',18),(165,'Culebras',18),(166,'Huaya',18),(167,'Malvas',18),(168,'Caraz',19),(169,'Huallanca',19),(170,'Huata',19),(171,'Huaylas',19),(172,'Mato',19),(173,'Pamparomás',19),(174,'Pueblo Libre',19),(175,'Santa Cruz',19),(176,'Santo Toribio',19),(177,'Yuracmarca',19),(178,'Piscobamba',20),(179,'Casca',20),(180,'Eleazar Guzmán Barró',20),(181,'Fidel OIivas Escudero',20),(182,'Llama',20),(183,'Llumpa',20),(184,'Musga',20),(185,'Lucma',20),(186,'Ocros',21),(187,'Acas',21),(188,'Cajamarquilla',21),(189,'Carhuapamga',21),(190,'Cochas',21),(191,'Congas',21),(192,'Llipa',21),(193,'San Cristóbal de Rajá',21),(194,'San Pedro',21),(195,'Santiago de Chilcas',21),(196,'Cabana',22),(197,'Bolognesi',22),(198,'Conchucos',22),(199,'Huacaschuque',22),(200,'Huandoval',22),(201,'Lacabamba',22),(202,'Llapo',22),(203,'Pallasca',22),(204,'Pampas',22),(205,'Santa Rosa',22),(206,'Tauca',22),(207,'Pomabamba',23),(208,'Huayllá',23),(209,'Parobamba',23),(210,'Quinuabamba',23),(211,'Recuay',24),(212,'Catac',24),(213,'Cotaparaco',24),(214,'Huayllapampa',24),(215,'Llacllí',24),(216,'Marca',24),(217,'Pampas Chico',24),(218,'Pararí',24),(219,'Tapacocha',24),(220,'Ticapampa',24),(221,'Chimbote (cercado)',25),(222,'Cáceres del Perú',25),(223,'Coishco',25),(224,'Macate',25),(225,'Moro',25),(226,'Nepeña',25),(227,'Nuevo Chimbote',25),(228,'Samanco',25),(229,'Santa',25),(230,'Sihuas',26),(231,'Acobamba',26),(232,'Alfonso Ugarte',26),(233,'Cashapampa',26),(234,'Chingalpo',26),(235,'Huayllabamba',26),(236,'Quiches',26),(237,'Ragash',26),(238,'San Jua',26),(239,'Sicsibamba',26),(240,'Yungay',27),(241,'Cascapara',27),(242,'Mancos',27),(243,'Matacoto',27),(244,'Quillo',27),(245,'Ranrahirca',27),(246,'Shupluy',27),(247,'Yanama',27),(248,'Abancay',28),(249,'Chacoche',28),(250,'Circa',28),(251,'Curahuasi',28),(252,'Huanipaca',28),(253,'Lambrama',28),(254,'Pichirhua',28),(255,'San Pedro de Cachora',28),(256,'Tamburco',28),(257,'Andahuaylas',29),(258,'Andarapa',29),(259,'Chiara',29),(260,'Huancarama',29),(261,'Huancaray',29),(262,'Huayana',29),(263,'Kaquiabamba',29),(264,'Kishuara',29),(265,'Pacobamba',29),(266,'Pacucha',29),(267,'Pampachiri',29),(268,'Pomacocha',29),(269,'San Antonio de Cachi',29),(270,'San Jerónimo',29),(271,'San Miguel de Chaccrapampa',29),(272,'Santa María de Chicmo',29),(273,'Talavera de la Reyna',29),(274,'Tumay Huaraca ',29),(275,'Turpo',29),(276,'Antabamba',30),(277,'El Oro',30),(278,'Huaquirca',30),(279,'Juan Espinoza Medrano',30),(280,'Oropesa',30),(281,'Pachaconas',30),(282,'Sabaino',30),(283,'Chalhuanca',31),(284,'Capaya',31),(285,'Caraybamba',31),(286,'Chapimarca',31),(287,'Colcabamba',31),(288,'Cotaruse',31),(289,'Huayllu',31),(290,'Justo Apu Sahuaraura',31),(291,'Lucre',31),(292,'Pocohuanca',31),(293,'San Juan de Chacña',31),(294,'Sañayca',31),(295,'Soraya',31),(296,'Tapairihua',31),(297,'Tintay',31),(298,'Toraya',31),(299,'Yanaca',31),(300,'Tambobamba',32),(301,'Cotabambas',32),(302,'Coyllurqui',32),(303,'Haquira',32),(304,'Mara',32),(305,'Chalhuahuacho',32),(306,'Chincheros',33),(307,'Anco-Huallo',33),(308,'Cocharcas',33),(309,'Huaccana',33),(310,'Ocobamba',33),(311,'Ongoy',33),(312,'Uranmarca',33),(313,'Ranracancha',33),(314,'Chuquibambilla',34),(315,'Curpahuasi',34),(316,'Gamarra',34),(317,'Huayllati',34),(318,'Mamara',34),(319,'Micaela Bastidas',34),(320,'Pataypampa',34),(321,'Progreso',34),(322,'San Antonio',34),(323,'Santa Rosa',34),(324,'Turpay',34),(325,'Vilcabamba',34),(326,'Virundo',34),(327,'Curasco',34),(328,'Alto Selva Alegre',35),(329,'Arequipa',35),(330,'Cayma',35),(331,'Cerro Colorado',35),(332,'Characato',35),(333,'Chiguata',35),(334,'Jacobo Hunter',35),(335,'José Luis Bustamante y Rivero',35),(336,'La Joya',35),(337,'Mariano Melgar',35),(338,'Miraflores',35),(339,'Mollebaya',35),(340,'Paucarpata',35),(341,'Pocsi',35),(342,'Polobaya',35),(343,'Quequeña',35),(344,'Sabandía',35),(345,'Sachaca',35),(346,'San Juan de Siguas',35),(347,'San Juan de Tarucani',35),(348,'Santa Isabel de Siguas',35),(349,'Santa Rita de Siguas',35),(350,'Socabaya',35),(351,'Tiabaya',35),(352,'Uchumayo',35),(353,'Vitor',35),(354,'Yanahuara',35),(355,'Yarabamba',35),(356,'Yura',35),(357,'Achoma',36),(358,'Cabanaconde',36),(359,'Callalli',36),(360,'Caylloma',36),(361,'Chivay',36),(362,'Coporaque',36),(363,'Huambo',36),(364,'Huanca',36),(365,'Ichupampa',36),(366,'Lari',36),(367,'Lluta',36),(368,'Maca',36),(369,'Madrigal',36),(370,'San Antonio de Chuca',36),(371,'Sibayo',36),(372,'Tapay',36),(373,'Tisco',36),(374,'Tuti',36),(375,'Yanque',36),(376,'Camaná',37),(377,'José María Quimper',37),(378,'Mariano Nicolás Valcarcel',37),(379,'Mariscal Cáceres',37),(380,'Nicolás de Piérola',37),(381,'Ocoña',37),(382,'Quilca',37),(383,'Samuel Pastor',37),(384,'Caravelí',38),(385,'Acarí',38),(386,'Atico',38),(387,'Atiquipa',38),(388,'Bella Unió',38),(389,'Cahuacho',38),(390,'Chala',38),(391,'Chaparra',38),(392,'Huanuhuanu',38),(393,'Jaqui',38),(394,'Lomas',38),(395,'Quicacha',38),(396,'Yauca',38),(397,'Aplao',39),(398,'Andahua',39),(399,'Ayo',39),(400,'Chachas',39),(401,'Chilcaymarca',39),(402,'Choco',39),(403,'Huancarqui',39),(404,'Machaguay',39),(405,'Orcopampa',39),(406,'Pampacolca',39),(407,'Tipá',39),(408,'Uñó',39),(409,'Uraca',39),(410,'Viraco',39),(411,'Chuquibamba',40),(412,'Andaray',40),(413,'Cayarani',40),(414,'Chichas',40),(415,'Iray',40),(416,'Río Grande',40),(417,'Salamanca',40),(418,'Yanaquihua - Ispacas',40),(419,'Mollendo',41),(420,'Cocachacra',41),(421,'Deán Valdivia',41),(422,'Islay',41),(423,'Mejía',41),(424,'Punta de Bombó',41),(425,'Alca',42),(426,'Charcana',42),(427,'Huaynacotas',42),(428,'Pampamarca',42),(429,'Puyca',42),(430,'Quechualla',42),(431,'Sayla',42),(432,'Tauría',42),(433,'Tomepampa',42),(434,'Toro',42),(435,'Cangallo',43),(436,'Chuschi',43),(437,'Los Morochucos',43),(438,'María Parado de Bellido',43),(439,'Paras',43),(440,'Totos',43),(441,'Ayacucho',44),(442,'Acocro',44),(443,'Acos Vinchos',44),(444,'Carmen Alto',44),(445,'Chiara',44),(446,'Jesús Nazareno',44),(447,'Ocros',44),(448,'Pacaycasa',44),(449,'Quinua',44),(450,'San José de Ticllas',44),(451,'San Juan Bautista',44),(452,'Santiago de Pischa',44),(453,'Socos',44),(454,'Tambillo',44),(455,'Vinchos',44),(456,'Carapo',45),(457,'Sacsamarca',45),(458,'Sancos',45),(459,'Santiago de Lucanamarca',45),(460,'Huanta',46),(461,'Ayahuanco',46),(462,'Huamanguilla',46),(463,'Iguai',46),(464,'Llochegua',46),(465,'Luricocha',46),(466,'Santillana',46),(467,'Sivia',46),(468,'San Miguel',47),(469,'Anco',47),(470,'Ayna',47),(471,'Chilcas',47),(472,'Chungui',47),(473,'Luis Carranza',47),(474,'San Francisco',47),(475,'Santa Rosa',47),(476,'Tambo',47),(477,'Samugari1',47),(478,'Puquio',48),(479,'Aucara',48),(480,'Cabana',48),(481,'Carmen Salcedo',48),(482,'Chaviña',48),(483,'Chipao',48),(484,'Huac-Huas',48),(485,'Laramate',48),(486,'Leoncio Prado',48),(487,'Llauta',48),(488,'Lucanas',48),(489,'Ocaña',48),(490,'Otoca',48),(491,'Saisa',48),(492,'San Cristóbal',48),(493,'San Jua',48),(494,'San Pedro',48),(495,'San Pedro de Palco',48),(496,'Sancos',48),(497,'Santa Ana de Huaycahuacho',48),(498,'Santa Lucía',48),(499,'Coracora',49),(500,'Chumpi',49),(501,'Coronel Castañeda',49),(502,'Pacapausa',49),(503,'Pullo',49),(504,'Puyusca',49),(505,'San Francisco de Ravacayco',49),(506,'Upahuacho',49),(507,'Pauza',50),(508,'Colta',50),(509,'Corculla',50),(510,'Lampa',50),(511,'Marcabamba',50),(512,'Oyolo',50),(513,'Pararca',50),(514,'San Javier de Alpabamba',50),(515,'San José de Ushua',50),(516,'Sara Sara',50),(517,'Querobamba',51),(518,'Belé',51),(519,'Chalcos',51),(520,'Chilcayoc',51),(521,'Huacaña',51),(522,'Morcolla',51),(523,'Paico',51),(524,'San Pedro de Larcay',51),(525,'San Salvador de Quije',51),(526,'Santiago de Paucaray',51),(527,'Soras',51),(528,'Huancapi',52),(529,'Alcamenca',52),(530,'Apongo',52),(531,'Asquipata',52),(532,'Canaria',52),(533,'Cayara',52),(534,'Colca',52),(535,'Huamanquiquia',52),(536,'Huaya',52),(537,'Sarhua',52),(538,'Vilcanchos',52),(539,'Vilcashuamá',53),(540,'Accomarca',53),(541,'Carhuanca',53),(542,'Concepció',53),(543,'Huambalpa',53),(544,'Independencia',53),(545,'Saurama',53),(546,'Vischongo',53),(547,'Cachachi',54),(548,'Cajabamba',54),(549,'Condebamba',54),(550,'Sitacocha',54),(551,'Cajamarca',55),(552,'Asunció',55),(553,'Chetilla',55),(554,'Cospá',55),(555,'Jesús',55),(556,'Llacanora',55),(557,'La Encañada',55),(558,'Los Baños del Inca',55),(559,'Magdalena',55),(560,'Matará',55),(561,'Namora',55),(562,'San Jua',55),(563,'Celendí',56),(564,'Chumuch',56),(565,'Cortegana',56),(566,'Huasmi',56),(567,'Jorge Chávez',56),(568,'José Gálvez',56),(569,'La Libertad de Pallá',56),(570,'Miguel Iglesias',56),(571,'Oxamarca',56),(572,'Sorochuco',56),(573,'Sucre',56),(574,'Utco',56),(575,'Contumazá',57),(576,'Chilete',57),(577,'Cupisnique',57),(578,'Guzmango',57),(579,'San Benito',57),(580,'Santa Cruz de Toledo',57),(581,'Tantarica',57),(582,'Yoná',57),(583,'Cutervo',58),(584,'Callayuc',58),(585,'Choros',58),(586,'Cujillo',58),(587,'La Ramada',58),(588,'Pimpingos',58),(589,'Querocotillo',58),(590,'San Andrés de Cutervo',58),(591,'San Juan de Cutervo',58),(592,'San Luis de Lucma',58),(593,'Santa Cruz',58),(594,'Santo Domingo de la Capilla',58),(595,'Santo Tomás',58),(596,'Socota',58),(597,'Toribio Casanova',58),(598,'Chota',59),(599,'Anguía',59),(600,'Chadí',59),(601,'Chalamarca',59),(602,'Chiguirip',59),(603,'Chimba',59),(604,'Choropampa',59),(605,'Cochabamba',59),(606,'Conchá',59),(607,'Huambos',59),(608,'Lajas',59),(609,'Llama',59),(610,'Miracosta',59),(611,'Paccha',59),(612,'Pio',59),(613,'Querocoto',59),(614,'San Juan de Licupis',59),(615,'Tacabamba',59),(616,'Tocmoche',59),(617,'Bambamarca',60),(618,'Chugur',60),(619,'Hualgayoc',60),(620,'Jaé',61),(621,'Bellavista',61),(622,'Chontalí',61),(623,'Colasay',61),(624,'Huabal',61),(625,'Las Pirias',61),(626,'Pomahuaca',61),(627,'Pucará',61),(628,'Sallique',61),(629,'San Felipe',61),(630,'San José del Alto',61),(631,'Santa Rosa',61),(632,'San Ignacio',62),(633,'Chirinos',62),(634,'Huarango',62),(635,'La Coipa',62),(636,'Namballe',62),(637,'San José de Lourdes',62),(638,'Tabaconas',62),(639,'Pedro Gálvez',63),(640,'Eduardo Villanueva',63),(641,'Gregorio Pita',63),(642,'Ichocá',63),(643,'Jose Manuel Quiroz',63),(644,'José Sabogal',63),(645,'Chancay',63),(646,'San Miguel',64),(647,'Bolívar',64),(648,'Calquis',64),(649,'Catilluc',64),(650,'El Prado',64),(651,'La Florida',64),(652,'Llapa',64),(653,'Nanchoc',64),(654,'Niepos',64),(655,'San Gregorio',64),(656,'San Silvestre de Conchá',64),(657,'Tongod',64),(658,'Unión Agua Blanca',64),(659,'San Pablo',65),(660,'San Bernardino',65),(661,'San Luis',65),(662,'Tumbade',65),(663,'Santa Cruz',66),(664,'Andabamba',66),(665,'Catache',66),(666,'Chancaybaños',66),(667,'La Esperanza',66),(668,'Ninabamba',66),(669,'Pulá',66),(670,'Saucepampa',66),(671,'Sexi',66),(672,'Uticyacu',66),(673,'Yauyuca',66),(674,'Udima',66),(675,'Acomayo',67),(676,'Acopia',67),(677,'Acos',67),(678,'Mosoc Llacta',67),(679,'Pomacanchi',67),(680,'Rondoca',67),(681,'Sangarará',67),(682,'Anta',68),(683,'Ancahuasi',68),(684,'Cachimayo',68),(685,'Chinchaypujio',68),(686,'Huarocondo',68),(687,'Limatambo',68),(688,'Mollepata',68),(689,'Pucyura',68),(690,'Zurite',68),(691,'Calca',69),(692,'Coya',69),(693,'Lamay',69),(694,'Lares',69),(695,'Pisac',69),(696,'San Salvador',69),(697,'Taray',69),(698,'Yanatile',69),(699,'Yanaoca',70),(700,'Checca',70),(701,'Kunturkanki',70),(702,'Langui',70),(703,'Layo',70),(704,'Pampamarca',70),(705,'Quehue',70),(706,'Túpac Amaru',70),(707,'Sicuani',71),(708,'Checacupe',71),(709,'Combapata',71),(710,'Marangani',71),(711,'Pitumarca',71),(712,'San Pablo',71),(713,'San Pedro',71),(714,'Tinta',71),(715,'Cuzco',72),(716,'Ccorca',72),(717,'Poroy',72),(718,'San Jerónimo',72),(719,'San Sebastiá',72),(720,'Santiago',72),(721,'Saylla',72),(722,'Wanchaq',72),(723,'Santo Tomás',73),(724,'Capacmarca',73),(725,'Chamaca',73),(726,'Colquemarca',73),(727,'Livitaca',73),(728,'Llusco',73),(729,'Quiñota',73),(730,'Velille',73),(731,'Yauri',74),(732,'Condoroma',74),(733,'Coporaque',74),(734,'Ocoruro',74),(735,'Pallpata',74),(736,'Pichigua',74),(737,'Suykutambo',74),(738,'Alto Pichigua',74),(739,'Santa Ana',75),(740,'Echarate',75),(741,'Huayopata',75),(742,'Kimbiri',75),(743,'Maranura',75),(744,'Ocobamba',75),(745,'Pichari',75),(746,'Quelloúno',75),(747,'Santa Teresa',75),(748,'Vilcabamba',75),(749,'Paruro',76),(750,'Accha',76),(751,'Ccapi',76),(752,'Colcha',76),(753,'Huanoquite',76),(754,'Omacha',76),(755,'Paccaritambo',76),(756,'Pillpinto',76),(757,'Yaurisque',76),(758,'Paucartambo',77),(759,'Caicay',77),(760,'Challabamba',77),(761,'Colquepata',77),(762,'Huancarani',77),(763,'Kosñipata',77),(764,'Andahuaylillas',78),(765,'Camanti',78),(766,'Ccarhuayo',78),(767,'Ccatca',78),(768,'Cusipata',78),(769,'Huaro',78),(770,'Lucre',78),(771,'Marcapata',78),(772,'Ocongate',78),(773,'Oropesa',78),(774,'Quiquijana',78),(775,'Urcos',78),(776,'Urubamba',79),(777,'Chinchero',79),(778,'Huayllabamba',79),(779,'Machupicchu',79),(780,'Maras',79),(781,'Ollantaytambo',79),(782,'Yucay',79),(783,'Acobamba',80),(784,'Andabamba',80),(785,'Anta',80),(786,'Caja',80),(787,'Marcas',80),(788,'Paucará',80),(789,'Pomacocha',80),(790,'Rosario',80),(791,'Lircay',81),(792,'Anchonga',81),(793,'Callanmarca',81),(794,'Ccochaccasa',81),(795,'Chincho',81),(796,'Congalla',81),(797,'Huanca-Huanca',81),(798,'Huayllay Grande',81),(799,'Julcamarca',81),(800,'San Antonio de Antaparco',81),(801,'Santo Tomás de Pata',81),(802,'Seclla',81),(803,'Castrovirreyna',82),(804,'Arma',82),(805,'Aurahuá',82),(806,'Capillas',82),(807,'Chupamarca',82),(808,'Cocas',82),(809,'Huachos',82),(810,'Huamatambo',82),(811,'Mollepampa',82),(812,'San Jua',82),(813,'Santa Ana',82),(814,'Tantara',82),(815,'Ticrapo',82),(816,'Churcampa',83),(817,'Anco',83),(818,'Chinchihuasi',83),(819,'Cosme1',83),(820,'El Carme',83),(821,'La Merced',83),(822,'Locroja',83),(823,'Pachamarca',83),(824,'Paucarbamba',83),(825,'San Miguel de Mayocc',83),(826,'San Pedro de Coris',83),(827,'Acobambilla',84),(828,'Acoria',84),(829,'Ascenció',84),(830,'Conayca',84),(831,'Cuenca',84),(832,'Huachocolpa',84),(833,'Huando',84),(834,'Huancavelica',84),(835,'Huayllahuara',84),(836,'Izcuchaca',84),(837,'Laria',84),(838,'Manta',84),(839,'Mariscal Cáceres',84),(840,'Moya',84),(841,'Nuevo Occoro',84),(842,'Palca',84),(843,'Pilchaca',84),(844,'Vilca',84),(845,'Yauli',84),(846,'Huaytará',85),(847,'Ayaví',85),(848,'Córdova',85),(849,'Huayacundo Arma',85),(850,'Laramarca',85),(851,'Ocoyo',85),(852,'Pilpichaca',85),(853,'Querco',85),(854,'Quito-Arma',85),(855,'San Antonio de Cusicancha',85),(856,'San Francisco de Sangayaico',85),(857,'San Isidro',85),(858,'Santiago de Chocorvos',85),(859,'Santiago de Quirahuara',85),(860,'Santo Domingo de Capillas',85),(861,'Tambo',85),(862,'Pampas',86),(863,'Acostambo',86),(864,'Acraquía',86),(865,'Ahuaycha',86),(866,'Colcabamba',86),(867,'Daniel Hernández',86),(868,'Huachocolpa',86),(869,'Huaribamba',86),(870,'Ñahuimpuquio',86),(871,'Pazos',86),(872,'Quishuar',86),(873,'Salcabamba',86),(874,'Salcahuasi',86),(875,'San Marcos de Rocchac',86),(876,'Surcubamba',86),(877,'Tintay Puncu',86),(878,'Ambo',87),(879,'Cayna',87),(880,'Colpas',87),(881,'Conchamarca',87),(882,'Huacar',87),(883,'San Francisco',87),(884,'San Rafael',87),(885,'Tomay Kichwa',87),(886,'La Unió',88),(887,'Chuquis',88),(888,'Marías',88),(889,'Pachas',88),(890,'Quivilla',88),(891,'Ripá',88),(892,'Shunqui',88),(893,'Sillapata',88),(894,'Yanas',88),(895,'Huacaybamba',89),(896,'Canchabamba',89),(897,'Cochabamba',89),(898,'Pinra',89),(899,'Llata',90),(900,'Arancay',90),(901,'Chavín de Pariarca',90),(902,'Jacas Grande',90),(903,'Jirca',90),(904,'Miraflores',90),(905,'Monzó',90),(906,'Punchao',90),(907,'Puños',90),(908,'Singa',90),(909,'Tantamayo',90),(910,'Huanuquito',90),(911,'Huánuco',91),(912,'Amarilis',91),(913,'Chinchao',91),(914,'Churumbamba',91),(915,'Margos',91),(916,'Pillco Marca',91),(917,'Quisqui (Kichki)',91),(918,'San Francisco de Cayrá',91),(919,'San Pedro de Chaulá',91),(920,'Santa María del Valle',91),(921,'Yarumayo',91),(922,'Yacus',91),(923,'Rupa-Rupa',92),(924,'Daniel Alomía Robles',92),(925,'Hermilio Valdizá',92),(926,'José Crespo y Castillo',92),(927,'Luyando',92),(928,'Mariano Dámaso Beraú',92),(929,'Huacrachuco',93),(930,'Choló',93),(931,'San Buenaventura',93),(932,'Panao',94),(933,'Chaglla',94),(934,'Molino',94),(935,'Umari',94),(936,'Puerto Inca',95),(937,'Codo del Pozuzo',95),(938,'Honoria',95),(939,'Tournavista',95),(940,'Yuyapichis',95),(941,'Chavinillo',96),(942,'Cahuac',96),(943,'Chacabamba',96),(944,'Aparicio Pomares',96),(945,'Jacas Chico',96),(946,'Obas',96),(947,'Pampamarca',96),(948,'Choras',96),(949,'Baños',97),(950,'Jesús',97),(951,'Jivia',97),(952,'Queropalca',97),(953,'Rondos',97),(954,'San Francisco de Asís',97),(955,'San Miguel de Cauri',97),(956,'Lichkacachka',97),(957,'Chincha Alta',98),(958,'Alto Lará',98),(959,'Chaví',98),(960,'Chincha Baja',98),(961,'El Carme',98),(962,'Grocio Prado',98),(963,'Pueblo Nuevo',98),(964,'San Juan de Yanac',98),(965,'San Pedro de Huacarpana',98),(966,'Sunampe',98),(967,'Tambo de Mora',98),(968,'Ica',99),(969,'La Tinguiña',99),(970,'Los Aquijes',99),(971,'Ocucaje',99),(972,'Pachacutec',99),(973,'Parcona',99),(974,'Pueblo Nuevo',99),(975,'Salas',99),(976,'San José de los Molinos',99),(977,'San Juan Bautista',99),(978,'Santiago',99),(979,'Subtanjalla',99),(980,'Tate',99),(981,'Yauca del Rosario',99),(982,'Nazca',100),(983,'Changuillo',100),(984,'El Ingenio',100),(985,'Marcona',100),(986,'Vista Alegre',100),(987,'Palpa',101),(988,'Llipata',101),(989,'Río Grande',101),(990,'Santa Cruz',101),(991,'Tibillo',101),(992,'Pisco',102),(993,'Huancano',102),(994,'Humay',102),(995,'Independencia',102),(996,'Paracas',102),(997,'San Andrés',102),(998,'San Clemente',102),(999,'Túpac Amaru Inca',102),(1000,'Concepció',103),(1001,'Aco',103),(1002,'Andamarca',103),(1003,'Chambara',103),(1004,'Cochas',103),(1005,'Comas',103),(1006,'Heroínas Toledo',103),(1007,'Manzanares',103),(1008,'Mariscal Castilla',103),(1009,'Matahuasi',103),(1010,'Mito',103),(1011,'Nueve de Julio',103),(1012,'Orcotuna',103),(1013,'San José de Quero',103),(1014,'Santa Rosa de Ocopa',103),(1015,'Chanchamayo',104),(1016,'San Luis de Shuaro',104),(1017,'Perené',104),(1018,'Pichanaqui',104),(1019,'San Ramó',104),(1020,'Vitoc',104),(1021,'Chupaca',105),(1022,'Ahuac',105),(1023,'Chongos Bajo',105),(1024,'Huachac',105),(1025,'Huamancaca Chico',105),(1026,'San Juan de Yscos',105),(1027,'San Juan de Jarpa',105),(1028,'Tres de Diciembre',105),(1029,'Yanacancha',105),(1030,'Huancayo',106),(1031,'Carhuacallanga',106),(1032,'Chacapampa',106),(1033,'Chicche',106),(1034,'Chilca',106),(1035,'Chongos Alto',106),(1036,'Chupuro',106),(1037,'Colca',106),(1038,'Cullhuas',106),(1039,'El Tambo',106),(1040,'Huacrapuquio',106),(1041,'Hualhuas',106),(1042,'Huancá',106),(1043,'Huasicancha',106),(1044,'Huayucachi',106),(1045,'Ingenio',106),(1046,'Pariahuanca',106),(1047,'Pilcomayo',106),(1048,'Pucará',106),(1049,'Qhichuay',106),(1050,'Quilcas',106),(1051,'San Agustín de Cajas',106),(1052,'San Jerónimo de Tuná',106),(1053,'San Pedro de Saño',106),(1054,'Santo Domingo de Acobamba',106),(1055,'Sapallanga',106),(1056,'Sicaya',106),(1057,'Viques',106),(1058,'Jauja',107),(1059,'Acolla',107),(1060,'Apata',107),(1061,'Ataura',107),(1062,'Canchayllo',107),(1063,'Curicaca',107),(1064,'El Mantaro',107),(1065,'Huamalí',107),(1066,'Huaripampa',107),(1067,'Huertas',107),(1068,'Janjaillo',107),(1069,'Julcá',107),(1070,'Leonor Ordóñez',107),(1071,'Llocllapampa',107),(1072,'Marco',107),(1073,'Masma',107),(1074,'Masma Chicche',107),(1075,'Molinos',107),(1076,'Monobamba',107),(1077,'Muqui',107),(1078,'Muquiyauyo',107),(1079,'Paca',107),(1080,'Paccha',107),(1081,'Pancá',107),(1082,'Parco',107),(1083,'Pomacancha',107),(1084,'Ricrá',107),(1085,'San Lorenzo',107),(1086,'San Pedro de Chuná',107),(1087,'Sausa',107),(1088,'Sincos',107),(1089,'Tunan Marca',107),(1090,'Yauli',107),(1091,'Yauyos',107),(1092,'Juní',108),(1093,'Carhuamayo',108),(1094,'Ondores',108),(1095,'Ulcumayo',108),(1096,'Satipo',109),(1097,'Coviriali',109),(1098,'Llaylla',109),(1099,'Mazamari',109),(1100,'Pampa Hermosa',109),(1101,'Pangoa',109),(1102,'Río Negro',109),(1103,'Río Tambo',109),(1104,'Tarma',110),(1105,'Acobamba',110),(1106,'Huaricolca',110),(1107,'Huasahuasi',110),(1108,'La Unió',110),(1109,'Palca',110),(1110,'Palcamayo',110),(1111,'San Pedro de Cajas',110),(1112,'Tapo',110),(1113,'La Oroya',111),(1114,'Cacapalpa',111),(1115,'Huay-Huay',111),(1116,'Marcapomacocha',111),(1117,'Morococha',111),(1118,'Paccha',111),(1119,'Santa Barbara de Carhuacayá',111),(1120,'Santa Rosa de Sacco',111),(1121,'Suitucancha',111),(1122,'Yauli',111),(1123,'Ascope',112),(1124,'Chicama',112),(1125,'Chocope',112),(1126,'Magdalena de Cao',112),(1127,'Paijá',112),(1128,'Rázuri',112),(1129,'Santiago de Cao',112),(1130,'Casa Grande',112),(1131,'Bolívar',113),(1132,'Bambamarca',113),(1133,'Condormarca',113),(1134,'Longotea',113),(1135,'Uchumarca',113),(1136,'Ucuncha',113),(1137,'Chepé',114),(1138,'Pacanga',114),(1139,'Pueblo Nuevo',114),(1140,'Cascas',115),(1141,'Lucma',115),(1142,'Marmot',115),(1143,'Sayapullo',115),(1144,'Julcá',116),(1145,'Calamarca',116),(1146,'Carabamba',116),(1147,'Huaso',116),(1148,'Otuzco',117),(1149,'Agallpampa',117),(1150,'Charat',117),(1151,'Huaranchal',117),(1152,'La Cuesta',117),(1153,'Mache',117),(1154,'Paranday',117),(1155,'Salpo',117),(1156,'Sinsicap',117),(1157,'Usquil',117),(1158,'San Pedro de Lloc',118),(1159,'Guadalupe',118),(1160,'Jequetepeque',118),(1161,'Pacasmayo',118),(1162,'San José',118),(1163,'Tayabamba',119),(1164,'Buldibuyo',119),(1165,'Chillia',119),(1166,'Huancaspata',119),(1167,'Huaylillas',119),(1168,'Huayo',119),(1169,'Ongó',119),(1170,'Parcoy',119),(1171,'Patáz',119),(1172,'Pías',119),(1173,'Challas',119),(1174,'Taurija',119),(1175,'Urpay',119),(1176,'Huamachuco',120),(1177,'Chugay',120),(1178,'Cochorco',120),(1179,'Curgos',120),(1180,'Marcabal',120),(1181,'Sanagorá',120),(1182,'Sarí',120),(1183,'Sartimbamba',120),(1184,'Santiago de Chuco',121),(1185,'Angasmarca',121),(1186,'Cachicadá',121),(1187,'Mollebamba',121),(1188,'Mollepata',121),(1189,'Quiruvilca',121),(1190,'Santa Cruz de Chuca',121),(1191,'Sitabamba',121),(1192,'Trujillo',122),(1193,'El Porvenir',122),(1194,'Florencia de Mora',122),(1195,'Huanchaco',122),(1196,'La Esperanza',122),(1197,'Laredo',122),(1198,'Moche',122),(1199,'Poroto',122),(1200,'Salaverry',122),(1201,'Simbal',122),(1202,'Victor Larco',122),(1203,'Virú',123),(1204,'Chao',123),(1205,'Guadalupito',123),(1206,'Chiclayo',124),(1207,'Cayalti',124),(1208,'Chongoyape',124),(1209,'Eté',124),(1210,'Puerto Eté',124),(1211,'José Leonardo Ortiz',124),(1212,'La Victoria',124),(1213,'Lagunas',124),(1214,'Monsefu',124),(1215,'Nueva Arica',124),(1216,'Oyotú',124),(1217,'Patapo',124),(1218,'Picsi',124),(1219,'Pimentel',124),(1220,'Pomalca',124),(1221,'Pucalá',124),(1222,'Reque',124),(1223,'Santa Rosa',124),(1224,'Tumá',124),(1225,'Saña',124),(1226,'Ferreñafe',125),(1227,'Cañaris',125),(1228,'Incahuasi',125),(1229,'Manuel Antonio Mesones Muro',125),(1230,'Pítipo',125),(1231,'Pueblo Nuevo',125),(1232,'Lambayeque',126),(1233,'Chóchope',126),(1234,'Íllimo',126),(1235,'Jayanca',126),(1236,'Mochumí',126),(1237,'Mórrope',126),(1238,'Motupe',126),(1239,'Olmos',126),(1240,'Pacora',126),(1241,'Salas',126),(1242,'San José',126),(1243,'Túcume',126),(1244,'Barranca',127),(1245,'Paramonga',127),(1246,'Pativilca',127),(1247,'Supe',127),(1248,'Supe Puerto',127),(1249,'Manás',128),(1250,'Gorgor',128),(1251,'Huancapó',128),(1252,'Cajatambo',128),(1253,'Copa',128),(1254,'Canta',129),(1255,'Arahuay',129),(1256,'Huamantanga',129),(1257,'Huaros',129),(1258,'Lachaqui',129),(1259,'San Buenaventura',129),(1260,'Santa Rosa de Quives',129),(1261,'Asia',130),(1262,'Calango',130),(1263,'Cerro Azul',130),(1264,'Chilca',130),(1265,'Coayllo',130),(1266,'Imperial',130),(1267,'Lunahuaná',130),(1268,'Mala',130),(1269,'Nuevo Imperial',130),(1270,'Pacará',130),(1271,'Quilmaná',130),(1272,'San Antonio',130),(1273,'San Luis',130),(1274,'San Vicente de Cañete',130),(1275,'Santa Cruz de Flores',130),(1276,'Zúñiga',130),(1277,'27 de noviembre',131),(1278,'Atavillos Alto',131),(1279,'Atavillos Bajo',131),(1280,'Aucallama',131),(1281,'Chancay',131),(1282,'Huaral',131),(1283,'Ihuarí',131),(1284,'Lampía',131),(1285,'Pacaraos',131),(1286,'Santa Cruz de Andamarca',131),(1287,'Sumbilca',131),(1288,'San Miguel de Acos',131),(1289,'Matucana',132),(1290,'Antioquía',132),(1291,'Callahuanca',132),(1292,'Carampoma',132),(1293,'Chicla',132),(1294,'Cuenca',132),(1295,'Huachupampa',132),(1296,'Huanza',132),(1297,'Huarochirí',132),(1298,'Lahuaytambo',132),(1299,'Langa',132),(1300,'Laraos',132),(1301,'Mariatana',132),(1302,'Ricardo Palma',132),(1303,'San Andrés de Tupicocha',132),(1304,'San Antonio de Chaclla',132),(1305,'San Bartolomé',132),(1306,'San Damiá',132),(1307,'San Juan de Iris',132),(1308,'San Juan de Tantaranche',132),(1309,'San Lorenzo de Quinti',132),(1310,'San Mateo',132),(1311,'San Mateo de Otao',132),(1312,'San Pedro de Casta',132),(1313,'San Pedro de Huancayre',132),(1314,'Sangallaya',132),(1315,'Santa Cruz de Cocachacra',132),(1316,'Santa Eulalia',132),(1317,'Santiago de Anchucaya',132),(1318,'Santiago de Tuna',132),(1319,'Santo Domingo de los Olleros',132),(1320,'San Jerónimo de Surco',132),(1321,'Huacho',133),(1322,'Ámbar',133),(1323,'Caleta de Carquí',133),(1324,'Checras',133),(1325,'Hualmay',133),(1326,'Huaura',133),(1327,'Leoncio Prado',133),(1328,'Paccho',133),(1329,'Santa Leonor',133),(1330,'Santa María',133),(1331,'Sayá',133),(1332,'Vegueta',133),(1333,'Lima',134),(1334,'Ancó',134),(1335,'Ate',134),(1336,'Barranco',134),(1337,'Breña',134),(1338,'Carabayllo',134),(1339,'Chaclacayo',134),(1340,'Chorrillos',134),(1341,'Cieneguilla',134),(1342,'Comas',134),(1343,'El Agustino',134),(1344,'Independencia',134),(1345,'Jesús María',134),(1346,'La Molina',134),(1347,'La Victoria',134),(1348,'Lince',134),(1349,'Los Olivos',134),(1350,'Lurigancho-Chosica',134),(1351,'Luri',134),(1352,'Magdalena del Mar',134),(1353,'Pueblo Libre',134),(1354,'Miraflores',134),(1355,'Pachacámac',134),(1356,'Pucusana',134),(1357,'Puente Piedra',134),(1358,'Punta Hermosa',134),(1359,'Punta Negra',134),(1360,'Rímac',134),(1361,'San Bartolo',134),(1362,'San Borja',134),(1363,'San Isidro',134),(1364,'San Juan de Lurigancho',134),(1365,'San Juan de Mirafloresv',134),(1366,'San Luis',134),(1367,'San Martín de Porres',134),(1368,'San Miguel',134),(1369,'Santa Anita',134),(1370,'Santa María del Mar',134),(1371,'Santa Rosa',134),(1372,'Santiago de Surco',134),(1373,'Surquillo',134),(1374,'Villa El Salvador',134),(1375,'Villa María del Triunfo',134),(1376,'Oyó',135),(1377,'Andajes',135),(1378,'Caujul',135),(1379,'Cochamarca',135),(1380,'Navá',135),(1381,'Pachangara',135),(1382,'Yauyos',136),(1383,'Alis',136),(1384,'Ayauca',136),(1385,'Ayaviri',136),(1386,'Azángaro',136),(1387,'Cacra',136),(1388,'Carania',136),(1389,'Catahuasi',136),(1390,'Chocos',136),(1391,'Cochas',136),(1392,'Colonia',136),(1393,'Hongos',136),(1394,'Huampara',136),(1395,'Huancaya',136),(1396,'Huangáscar',136),(1397,'Huantá',136),(1398,'Huañec',136),(1399,'Laraos',136),(1400,'Lincha',136),(1401,'Madea',136),(1402,'Miraflores',136),(1403,'Omas',136),(1404,'San Lorenzo de Putinza',136),(1405,'Quinches',136),(1406,'Quinocay',136),(1407,'San Joaquí',136),(1408,'San Pedro de Pilas',136),(1409,'Tanta',136),(1410,'Tauripampa',136),(1411,'Tomas',136),(1412,'Tupe',136),(1413,'Viñac',136),(1414,'Vitis',136),(1415,'Prov. Const. Callao',137),(1416,'Yurimaguas',138),(1417,'Balsapuerto',138),(1418,'Jeberos',138),(1419,'Lagunas',138),(1420,'Santa Cruz',138),(1421,'Teniente César López Rojas',138),(1422,'Nauta',139),(1423,'Parinari',139),(1424,'Tigre',139),(1425,'Trompeteros',139),(1426,'Urarinas',139),(1427,'Ramón Castilla',140),(1428,'Pebas',140),(1429,'Yavari',140),(1430,'San Pablo',140),(1431,'Iquitos',141),(1432,'Alto Nanay',141),(1433,'Fernando Lores',141),(1434,'Indiana',141),(1435,'Las Amazonas',141),(1436,'Mazá',141),(1437,'Napo',141),(1438,'Punchana',141),(1439,'Putumayo',141),(1440,'Torres Causana',141),(1441,'Bele',141),(1442,'San Juan Bautista',141),(1443,'Teniente Manuel Clavero',141),(1444,'Requena',142),(1445,'Alto Tapiche',142),(1446,'Capelo',142),(1447,'Emilio San Martí',142),(1448,'Maquía',142),(1449,'Puinahua',142),(1450,'Saquena',142),(1451,'Sopli',142),(1452,'Tapiche',142),(1453,'Jenaro Herrera',142),(1454,'Yaquerana',142),(1455,'Contamana',143),(1456,'Inahuaya',143),(1457,'Padre Márquez',143),(1458,'Pampa Hermosa',143),(1459,'Sarayacu',143),(1460,'Alfredo Vargas Guerra',143),(1461,'Yanayacu',143),(1462,'Manu',144),(1463,'Fitzcarrald',144),(1464,'Madre de Dios',144),(1465,'Huepetuhe',144),(1466,'Iñapari',145),(1467,'Iberia',145),(1468,'Tahuamanu',145),(1469,'Tambopata',146),(1470,'Inambari',146),(1471,'Las Piedras',146),(1472,'Laberinto',146),(1473,'Ilo',147),(1474,'El Algarrobal',147),(1475,'Pacocha',147),(1476,'Moquegua',148),(1477,'Carumas',148),(1478,'Cuchumbaya',148),(1479,'Samegua',148),(1480,'San Cristobal de Calacoa',148),(1481,'Torata',148),(1482,'Omate',149),(1483,'Chojata',149),(1484,'Coalaque',149),(1485,'Ichuña',149),(1486,'La Capilla',149),(1487,'Lloque',149),(1488,'Matalaque',149),(1489,'Puquina',149),(1490,'Quinistaquillas',149),(1491,'Ubinas',149),(1492,'Yunga',149),(1493,'Yanahuanca',150),(1494,'Chacayá',150),(1495,'Goyllarisquizga',150),(1496,'Paucar',150),(1497,'San Pedro de Pillao',150),(1498,'Santa Ana de Tusi',150),(1499,'Tapuc',150),(1500,'Vilcabamba',150),(1501,'Oxapampa',151),(1502,'Chontabamba',151),(1503,'Huancabamba',151),(1504,'Palcazú',151),(1505,'Pozuzo',151),(1506,'Puerto Bermúdez',151),(1507,'Villa Rica',151),(1508,'Ciudad Constitució',151),(1509,'Chaupimarca',152),(1510,'Huachó',152),(1511,'Huariaca',152),(1512,'Huayllay',152),(1513,'Ninacaca',152),(1514,'Pallanchacra',152),(1515,'Paucartambo',152),(1516,'San Francisco de Asís de Yarusyacá',152),(1517,'Simón Bolívar',152),(1518,'Ticlacayá',152),(1519,'Tinyahuarco',152),(1520,'Vicco',152),(1521,'Yanacancha',152),(1522,'Ayabaca',153),(1523,'Frías',153),(1524,'Jililí',153),(1525,'Lagunas',153),(1526,'Montero',153),(1527,'Pacaipampa',153),(1528,'Paimas',153),(1529,'Sapillica',153),(1530,'Sicchez',153),(1531,'Suyo',153),(1532,'Huancabamba',154),(1533,'Canchaque',154),(1534,'El Carmen de la Frontera',154),(1535,'Huarmaca',154),(1536,'Lalaquiz',154),(1537,'San Miguel de El Faique',154),(1538,'Sondor',154),(1539,'Sondorillo',154),(1540,'Chulucanas',155),(1541,'Buenos Aires',155),(1542,'Chalaco',155),(1543,'La Matanza',155),(1544,'Morropó',155),(1545,'Salitral',155),(1546,'San Juan de Bigote',155),(1547,'Santa Catalina de Mossa',155),(1548,'Santo Domingo',155),(1549,'Yamango',155),(1550,'Paita',156),(1551,'Amotape',156),(1552,'Colá',156),(1553,'El Arenal',156),(1554,'La Huaca',156),(1555,'Tamarindo',156),(1556,'Vichayal',156),(1557,'Piura',157),(1558,'Castilla',157),(1559,'Catacaos',157),(1560,'Cura Mori',157),(1561,'El Tallá',157),(1562,'La Arena',157),(1563,'La Unió',157),(1564,'Las Lomas',157),(1565,'Tambo Grande',157),(1566,'Sechura',158),(1567,'Bellavista de la Unió',158),(1568,'Bernal',158),(1569,'Cristo nos Valga',158),(1570,'Rinconada Llicuar',158),(1571,'Vice',158),(1572,'Sullana',159),(1573,'Bellavista',159),(1574,'Ignacio Escudero',159),(1575,'Lancones',159),(1576,'Marcavelica',159),(1577,'Miguel Checa',159),(1578,'Querecotillo',159),(1579,'Salitral',159),(1580,'Pariñas',160),(1581,'El Alto',160),(1582,'La Brea',160),(1583,'Lobitos',160),(1584,'Los Órganos',160),(1585,'Máncora',160),(1586,'Azángaro',161),(1587,'Achaya',161),(1588,'Arapa',161),(1589,'Asillo',161),(1590,'Caminaca',161),(1591,'Chupa',161),(1592,'José Domingo Choquehuanca',161),(1593,'Muñani',161),(1594,'Potoni',161),(1595,'Samá',161),(1596,'San Antó',161),(1597,'San José',161),(1598,'San Juan de Salinas',161),(1599,'Santiago de Pupuja',161),(1600,'Tirapata',161),(1601,'Ajoyani',162),(1602,'Ayapata',162),(1603,'Coasa',162),(1604,'Corani',162),(1605,'Crucero',162),(1606,'Ituata',162),(1607,'Macusani',162),(1608,'Ollachea',162),(1609,'San Gabá',162),(1610,'Usicayos',162),(1611,'Desaguadero',163),(1612,'Huacullani',163),(1613,'Juli',163),(1614,'Kelluyo',163),(1615,'Pisacoma',163),(1616,'Pomata',163),(1617,'Zepita',163),(1618,'Capazo',164),(1619,'Conduriri',164),(1620,'Ilave',164),(1621,'Pilcuyo',164),(1622,'Santa Rosa',164),(1623,'Cojata',165),(1624,'Huancané',165),(1625,'Huatasani',165),(1626,'Inchupalla',165),(1627,'Pusi',165),(1628,'Rosaspata',165),(1629,'Taraco',165),(1630,'Vilque Chico',165),(1631,'Cabanilla',166),(1632,'Calapuja',166),(1633,'Lampa',166),(1634,'Nicasio',166),(1635,'Ocuviri',166),(1636,'Palca',166),(1637,'Paratia',166),(1638,'Pucará',166),(1639,'Santa Lucía',166),(1640,'Vilavila',166),(1641,'Antauta',167),(1642,'Ayaviri',167),(1643,'Cupi',167),(1644,'Llalli',167),(1645,'Macari',167),(1646,'Ñuñoa',167),(1647,'Orurillo',167),(1648,'Santa Rosa',167),(1649,'Umachiri',167),(1650,'Conina',168),(1651,'Huayrapata',168),(1652,'Moho',168),(1653,'Tilali',168),(1654,'Ananea',169),(1655,'Pedro Vilca Apaza',169),(1656,'Putina',169),(1657,'Quilcapuncu',169),(1658,'Sina',169),(1659,'Cabana',170),(1660,'Cabanillas',170),(1661,'Caracoto',170),(1662,'Juliaca',170),(1663,'Massiapo',171),(1664,'Cuyocuyo',171),(1665,'Limbani',171),(1666,'Patambuco',171),(1667,'Quiaca',171),(1668,'San Juan del Oro',171),(1669,'San Pedro de Putina Punco',171),(1670,'Sandia',171),(1671,'Yanahuaya',171),(1672,'Phara',171),(1673,'Ácora',172),(1674,'Amantaní',172),(1675,'Atuncolla',172),(1676,'Capachica',172),(1677,'Chucuito',172),(1678,'Coata',172),(1679,'Huata',172),(1680,'Mañazo',172),(1681,'Paucarcolla',172),(1682,'Pichacani',172),(1683,'Platería',172),(1684,'Puno',172),(1685,'San Antonio',172),(1686,'Tiquillaca',172),(1687,'Vilque',172),(1688,'Yunguyo',173),(1689,'Anapia',173),(1690,'Copani',173),(1691,'Cuturapi',173),(1692,'Ollaraya',173),(1693,'Tinicachi',173),(1694,'Unicachi',173),(1695,'Bellavista',174),(1696,'Alto Biavo',174),(1697,'Bajo Biavo',174),(1698,'Huallaga',174),(1699,'San Pablo',174),(1700,'San Rafael',174),(1701,'San José de Sisa',175),(1702,'Agua Blanca',175),(1703,'San Martí',175),(1704,'Santa Rosa',175),(1705,'Shantoja',175),(1706,'Saposoa',176),(1707,'Alto Saposoa',176),(1708,'El Eslabó',176),(1709,'Piscoyacu',176),(1710,'Sacanche',176),(1711,'Tingo de Saposoa',176),(1712,'Lamas',177),(1713,'Alonso de Alvarado',177),(1714,'Barranquita',177),(1715,'Caynarachi',177),(1716,'Cuñumbuqui',177),(1717,'Pinto Recodo',177),(1718,'Rumisapa',177),(1719,'San Roque de Cumbaza',177),(1720,'Shanao',177),(1721,'Tabalosos',177),(1722,'Zapatero',177),(1723,'Juanjuí',178),(1724,'Campanilla',178),(1725,'Huicungo',178),(1726,'Pachiza',178),(1727,'Pajarillo',178),(1728,'Juanjuicillo',178),(1729,'Moyobamba',179),(1730,'Calzada',179),(1731,'Habana',179),(1732,'Jepelacio',179),(1733,'Soritor',179),(1734,'Yantalo',179),(1735,'Picota',180),(1736,'Buenos Aires',180),(1737,'Caspisapa',180),(1738,'Pilluana',180),(1739,'Pucacaca',180),(1740,'San Cristóbal',180),(1741,'San Hilarió',180),(1742,'Shamboyacu',180),(1743,'Leoncio Prado',180),(1744,'Tingo de Ponazav',180),(1745,'Tres Unidos',180),(1746,'Rioja',181),(1747,'Awajú',181),(1748,'Elías Soplín Vargas',181),(1749,'Nueva Cajamarca',181),(1750,'Pardo Miguel',181),(1751,'Posic',181),(1752,'San Fernando',181),(1753,'Yorongos',181),(1754,'Yuracyacu',181),(1755,'Tarapoto',182),(1756,'Alberto Leveau',182),(1757,'Cacatachi',182),(1758,'Chazuta',182),(1759,'Chipurana',182),(1760,'El Porvenir',182),(1761,'Huimbayoc',182),(1762,'Juan Guerra',182),(1763,'La Banda de Shilcayo',182),(1764,'Morales',182),(1765,'Papaplaya',182),(1766,'San Antonio',182),(1767,'Sauce',182),(1768,'Shapaja',182),(1769,'Tocache',183),(1770,'Nuevo Progreso',183),(1771,'Pólvora',183),(1772,'Shunte',183),(1773,'Uchiza',183),(1774,'Candarave',184),(1775,'Cairani',184),(1776,'Camilaca',184),(1777,'Curibaya',184),(1778,'Huanuara',184),(1779,'Quilahuani',184),(1780,'Ilabaya',185),(1781,'Ite',185),(1782,'Locumba',185),(1783,'Tacna',186),(1784,'Alto de la Alianza',186),(1785,'Calana',186),(1786,'Ciudad Nueva',186),(1787,'Coronel Gregorio Albarracín Lanchipa',186),(1788,'Inclá',186),(1789,'Pachía',186),(1790,'Palca',186),(1791,'Pocollay',186),(1792,'Sama',186),(1793,'Tarata',187),(1794,'Chucatamani',187),(1795,'Estique',187),(1796,'Estique-Pampa',187),(1797,'Sitajara',187),(1798,'Susapaya',187),(1799,'Tarucachi',187),(1800,'Ticaco',187),(1801,'Canoas de Punta Sal',188),(1802,'Casitas',188),(1803,'Zorritos',188),(1804,'Tumbes',189),(1805,'Corrales',189),(1806,'La Cruz',189),(1807,'Pampas de Hospital',189),(1808,'San Jacinto',189),(1809,'San Juan de la Virge',189),(1810,'Zarumilla',190),(1811,'Aguas Verdes',190),(1812,'Matapalo',190),(1813,'Papayal',190),(1814,'Raimondi',191),(1815,'Sepahua',191),(1816,'Tahuanía',191),(1817,'Yurúa',191),(1818,'Callería',192),(1819,'Campoverde',192),(1820,'Iparía',192),(1821,'Manantay',192),(1822,'Masisea',192),(1823,'Yarinacocha',192),(1824,'Nueva Requena',192),(1825,'Padre Abad',193),(1826,'Irazola',193),(1827,'Curimaná',193),(1828,'Purús',194);
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
INSERT INTO `empresa` VALUES (6,'telo XD','telo XD','telos asa','12123123122',0,'2015-05-19 19:19:32','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0d\0\0\0`\0\0\0�s�B\0\0 \0IDATx^��\\u�����l*] T�CD�X@Q/��T��U�����r>��JR�R��iAz�$$�l�M�3g�~�����f[�\Zp��-3g�y���~O��$U��d}D(���!N���O���>	@�2_+oƏ�l��������*�eMφ�����^^��y)�����W����ox��\\���v��GGk�W�� �*����|��.d�4�1+�*��\Z�*�T)���5j��t2J8��p��]��\\ЯXo+�7�Y-謈�s%?��Ɂ�n�X\\Q�u����1>�������/CV<{%�mx�*TqT�w[5�k�`B�t�5�PT�!�H�Q�)��2��)\0�=�0i���}!\0KY��Q95M�̫5���q-��tϒ%Z����_Ɯ�\0fs��Z�	��~��RI�E�5#��f��6�ɥU@b�H�}�J>$��Z�/)\n�z�ad{R\0m!���`����0��D���Ə���%4���onN�f��@\n��\\ד���F�!��*�%���ɾ��nD���H��Αz�hr��x��A�B��rɀ��B���@�{���;e^�R��RϻK�\"h�,��=_��f�\"�����J^�x��F]����?�D���x?g�BM%�TBr�k��m[V\r!�yͬM�TB�b��\'+j�UT*G�<�1��~��\"9�<���O�m�]��x�7{s�d�\r�s\\��%��o	�Y���0;��B��>H�5�׮��HJ%S�J0����٨3��0��\n�S[��I��Z�:�K(^*������W٤\0��;QD��bZ�������y����%�G��A�|Zj�_@��3*rJ#\Z�*�g�����W\n�HP\0�u�e���4���J\\�Ce�dM�q_���s��0�g�M�2��\r��U4�S*�j��Q9-��h�ϋW������C�UjhP��k����i�t�m���MPA>È��/�+~sgM=\Z3�ʤS*uv�u�SZ�܋z�/s�~}���,���j(�}2	��pxs h*��h0�Gb�)�\\��ar��=:$�a��\\��{���#�N�5kz�Ug�Cq�q�\n�� ����h��;����C԰�r�5���yb=��^�o;sy��!��W����?>OoϾF���S��`�&������!�%WK�	���u�?���}��k�	Fi�\nC�x,�hQ��|�^|E�2\\(�T��+��E≺�8ev�\\��z��M�5M��nX�1�zJ�HT�gH�\n8�SSA��b\0�\rA��ҷݤ�O��&e}��\\����*J�����,�Aφc��k��(ҕ7?ot֨0$Hp��h����]�0ĸ�<`0�\n3f�r#!5q����*�j @T�\"�;\n��X`�v�� .�p$��fjǾ�^���>�`t\"Tj�cz��sT����<+�*��y�L�▵�6�_gz��np�u�B\nOM�pa�������v$�o���Xԯ��R�I(����ʋT;iJ���\Z�Q{�A.l��;��+������ؓ�J��bD�9����=��l�������s�Y�P`�	C��ܧ�PH�\ZW��˲�dc�S�(9P�ȇ�8%|�	u�C����H4�Wc�!8��ڋmz�����/TT���n\Zʤ̂��&��6������7�-�j���f~������H�1�xN	M*�A�C�ј���i����:�@$xY��^�ڭ��[��@�.��Z�F��l�S���0�<K�i\Z����?��rL��I��w�k5>f���9CVxR+�E:+ؤ��6����\"c,@�V9$������T�s�\0�������,�\n�\0,�������w���w/���\"����e�6�\0C����-Z�����u���q`��\ZA\ZZ�5�\"�c��9-)O�<�z-�5��9KQ�rn�.�M�$��\"��a0�������l���U�J����8���J���aH��8xU���|u���%���Aٲ\"�0w�������+�k���~���5���y6_��V�=��D����^��Zc���Q��x�6+�)Z�yy�<r�Nhqa���Z}��e��F�qY��ܬy\'}��~-z�����%Up�^���9�k���6϶�{�k�l��� ��|Y�`z�����^�Sߨ\\!��[/��\'n�U���!��Nm(魶����k̐�𚨎m�<DP�\nh;0�W�#��:d����\'��]%qy�q��:��*\"��4S�r��q`�v��.��\Z�s�:eHU���ݴd�ۚ�z>��~���t4��Z�!-�q���=���>��S}�������w�kgQF����9C6(���%�Y���X5�8���] �H�5~�i���9�����.�Jj�]7�/W3�/�55^BB���?��O�^`�^�P�۷�EZ�ҁ�����HQ��.R��C�T�Q���u��{�$G��j���\0��\Z�\'�|�,WT��\r��6\\��Kz��!vq\\>?ҤhP?�4���Sin6I4��+Nʮ8e�}�1��\rj(�� >�	`���Qub��Ͽ�gv?HT`B\r�\0�D���(ӥ�E�� ��ɫ��F��K-�t��̺qڶ�m!W��6�*P��9*7_5h.\0Qȡ���`󏵄\0w�����\nZ���wߠ�~�\"�sf;�\"�5�#r=��0.\n$�-�X`T����d����^������I4��AK�R�iS���D��łj�E�fU=]�1UYZ�����d.&Ș���j�Q	\Z�\\r^��8�N-�RVƬ�+<\"	1��R�Ř�+J5���t���܉C�m.=O[�$fՓ��Yk$�|p\'^��ІC0�+W;�O���u��ڷ�xU,e���PI�ц��i�+u�S#��#f��#�O��/��� �� n��q�}\'��؍��4�K�A+׿ C?8��3�Q������(�#ٖ �J���F�\\�%��(�nV���!Q�qYO�ߦF\'�2��(����c�?�h�d�bT{��&��\'?S yAu��߸�����U�J��p�86��j����\0�g����֐�8�z��~�OS�c�g_��1�4lr������ۥh�2��cv��zp��\\�H�������Z�̖\0@�@m\r-!�!�%1�#�T�w�dH)dgHGg_C�����Xc�!~��w�ާg�E|R��!�Һ��}���<$C\"��V�sR�A3H�1�=���w�����/��^�*�Ö���B���7�RS��<~�ѩ��ˍ��\Z�!aCEc��T��.w9A!6����M���DN-�Y�� k0���,\'u`�<���<³�y脥��K/���T���tí!bFjZST紂吋��L�ʅ�9���\"M=�d�<�7��+@�cUe��&,V����O)�n�ܨ�ʕ�\n��L(�ӜV�FP�=�\r	tEd�\ZH:Y�rC^���&�:j�HFȝ=nyk+��6�!6k����N=��Y�Eh�,+��� ��s`\\í!2���R;�W.\'����³�W_��**�A+�)B,*�q�H�Z��s����\r�W��i�W���89Agv����������i��&M�X�eU�|��n�6z�o���V�^�{�`HB�����\'�xϝTg֩+�E!���p�N.t��ᤔ������xe���\Z�z:/:I;f�jv\"J��I�t��2^�׽�;c�!>ʝ>��p�c����!x���K����֧(*�\Z��y�}����Ihv�A�~wk\Zp�������P�8���ϙ1�7K�/�[n/�#�$��x�ǆ~�y���s!aE�O�s��!V#l?E��O��l��?k��0���r�\Zv�;6�(g��2�ˣ��aw-\'��,\'p�a�A>>^��-��+��VK��cH\0���7�kҳg�z���r��gv�CcS`���cLB�����i��[W]��[���A��c�B���\Z`O�SY�H�E�\r�D�+�#�ѳ�1fI%���y�!��}�>���pu=��9�k��5v/KW��=���<}����a�WmO\\Š����X@++�O�W(�/���\"��1�3��J����y7�pz���XJW��}�ޘ\0��t�0*^� `����u\nf\0�W,�B�x���^g�+�Ɗ�i��)c�!�.��Q��-��i�U��`Q��!��,kŒx�G���c�u.e=7����,}���.=W[�$9T�vF��\ZCpg}�a�	�o�H�\n�H�/��]Eq��%�V�z��\0����p��\0��/��?W{�|�69����A�ı��ڦ6�	Oꪦf5�z)UBտ��uIz	5#`�28�E��A�޽,��h��7i���� ��N6�5�$�By\na59��.��b|�U�[B���T�k\'�g��)1ol�nx��I�k���.��,h�^���>y�&�;>Vu�|(Ό1���nj����{��z^X��\r	�1�Υ��2P���\Z�!��1��ze)\n����0ʓ1Ɛ\n�I%ڷ� �x�ҏ=1:1���{5y��ԻZ����c���[}V��ۧ�#�鿯9C|X�\0����P�mC_z�Px��j�{��Jk�\n���_�.k(\r\r�K\n�%Tt�۫���/75�f�Y?O}��/i�a����<��n�\0,V��%����<l��>�X��U��Ҹ�5	��fm ,��\rl���^�C������R�:T\0}Z%A�*D\n�10<�7�e��[_�Km7�h$�$M�#Zc�!��(����P��b�^�\0Vy��Uں�bpTW��C�b���mR0]�3�G�h����}�)�5�5�b��y\n�����F*�����P�|]e9Q� Ǿ*�e�D2�7T����J����>��t�vt�\Zc�3d�FD;��	�Sߋ�UBi�:\\�gHiT��W̌�C�~�kutR�N��T����,29%����6\"v����\"��ը=����P�G{7��J��)�]Nm�U�ب��k�|H�8��3��V��,�S���W�wA1�X˩�q�R��A��{?���;��}��F�!�j��ӫV��Χ�1<�@�I����@�]�\"j?����m���s���1�e�zO�=�V��׽i�f�y��z^D�i]j�\Z7��Q\'��:���k�3��ȼ��p.ɫq�����}����1Ɛ2��m��5[l��.�v���Q�K5����!��Ƭ�k	�cX��ͯ:7֠I.=9 e�-ƶh1>�w@+���L�\'qH/�i���\'��Tû	o�������K�3��Z�BW釁߻g�P��E�Lb;��D���xB\'bHn��\"nE}���Hx��5�G�y[`��1���a�=��á��i*�p/ߛ)�3[e���?V�/I��Ά�hCzM��	�C�X��\n�e���ϛ32�,��&�L�	m�K���v�v��,E��\"�����A����-��z�K�����m�rj�\r�޲P�$%�$쨖r�	��yjyIB�>yW�v�²I�~\"!F�R(wj�j���Q�z�Mk�89Ew,S���q�_��F�-z�8A����8�\r	h�=�Ɛg�x�ǂ!��t���b�	ٽ��\r�\\�4���<�E����;�.�p����F�}vCX�.�ŵ�֐�	QG��T^B#J\r��]e�Q�����x�a��G�B�OyE��ǅ!�LGw,E՘Z0b\0@��*����v��3�0����d4	;%@π�m\\	��vF��w�	�\0��́w�PG<�)��5��6f�P��yOi��Cp\r���T�&���2mq6�͊���9j>�ŘJg���u�=�`/CԻ?���o��]�@uM�꯲���f1�!S�.�Z��{;J��c2�;D�{�����D������H��֐��b��.���MR�}�D�\0���_�m�Q��B�B�R_�zKD�V�_����g<���8dV���4�X,��t��|��_Rv	3{��p4��Q;�n�i��ҫA\n5Z���	o2AG�:ϛ��ҏ?T:��z���C����S}n��F�0Q�����յ�� 6����1���7���>��<Y_��)�Uؒ>qgC��y������74N���F<t;}Ֆ�f���xy�-8c����1_���`-s�=a���L���iQ��<3�������T�W(ns���>\n�/{S�m�����ɼ	�\'LK��\\#�-?�Q�~]��\'�ʷ��4��N�la��`t�QOާ��;���U\\9t��!�k3)?I9L1�;�_~�s����VR�Rmp�\"��z�3;l�/��!PYy��P�0��`�wusK�&�ա{&L��mI%�ɴW�QY��Q�۟y�l����f���z_�\rԴk�:��z�K��������}-��9�a����&��U��:�\Z�!�q���;�A��3�eJA��w���kұ�?O�*�zAm��}�u�r��~��8��1B;<���מ.�B:���*�܀�*����@���vKo�v��sr��>\n�G��F��#�/R4Jf���Cj��F�E9���z�+�G�bɛ�W�{�θ\Z}w�r�-�\n�\0í!��fc��u����-Yƌ�g[j�T�ɨ\Z�?J���\"��}��U5���\r�����z��!�����@�������k�3���5���e�3˯�R�.�^���S���\"C��S�#\n\n\0\"��1mﰷ��Y[�\\��,6��d�	��M��d��F�kvQ�w㺬9���R̄�D�YG�̀6b��ϋur���YR$���d��{oRd��T�-e�� �X���v��F�{��@�J�\nH�QK_W���^I�\Z,;&��E��\\o�����ٲb��=S�2�d����ݦ����~�l�@\'�k��63�H1n�y��=�B�\r���1��s\ru�y{����f�̙���HB����@�n�Y�W+qE��:��0[�\\\n����L^$�tf�ɣ5��3��g���_;�ۊ��9;�gU���N3h��\nG�C��\r/-�P�\\� 17ކ�\r�J���D�T��-��xSwm�h?\'�ɞ�J����������TM��\\o�g^)\\��˯ի�iOz��]׈���{�SŌ#?�|���9CxWC⌍&L��iВ�ZK]����ug�)�Ⓩ{�m-�c�3�����k��{;���o�7U��!��bU3Ě�����\n_����-�y6����\0��zÏ��B\\���.{W���bo��d8_���>�Y���Bm��o3˥/��6�g�W�͘~�I�y��UA[ĨX�f�\Z��k��{:8��*<9�cu�j1ď�k�ۧ�I��\Z�҄mChN�����A��C��w\\-�@4z!�CX�����Ɂ����q�i�.�\0�_Y�L���1s��t���RW\"�]/r:в�7�+Q�|o�n��`��u��\r3��]\r(!�>���u�+EJ���w�L�0;�Gҋ��];VN�]�� @Lf�����(���88���\Z1CL\ZlT��H��է�a5��;�spk+�)���WZU��s���Y��k^�=�����D��\Z*u0�M-����>�:�t� U�wֱe��0�?7����n�s���0��*���J����.a�����=A\r�>��(�\0�{�!��vú����N���]Jl2��\\;�g�tIKXn�c�2]?ys5RZC�yD����i��Y������97�y�҈ҟ�I����nɰC�Z5�x\'�\0���.�X�N;^���p�(n_	f���v=�X���`_yQQ��ʎ�RUuz���HTDw����j�Cf(���\"�Z�����z�����M�!��Lس���>D\0�:\r$b���?P��al���`v���@C:l�4͜��ny�y&����b\\X�1�u-�\Z3�P�ڒ~Ql�$F����#�>�Z��|�,͸�?9o���|/Ħ��zKV�\\��薭wW�\r���[���(i�qV�g�c�>�d}vOa\r�e\n����K�d�l\"\rƐ���\\ℯi�+�:�k��+�;b�l!�n.�C�������Z��U��P����K��WSG�cޚ3$�gv;\"�ttq�Iux?=1���\0���7_�vr�������$_�]�T�[6݆�U�OBL���{o��\0\0�IDAT���/�YF�\\bP�$�T��l�l�ggq�`q�h�������4������Q�ԗ]�X??ka�fo�+#F8ނ2�\\?�H��x�~��[����V=[�Y<�Y�~F�E9\r��s�,;�(�������4����;��5�,\"a�lVwM�I�.Nk#��\r�g�aǍE��s\ZLz�	੥*)44I}@�3���l�۱(�ٻ�7O�q��/?R��B\r�O+̱}.��Ya�w�AK�>Q)f�\\f�y��4ηJ݉��\r��b�ڈ��וIZRb�w�+k��f�w��}�B��8�����ά��]��X��<C��ɱ�?Q+5��9v8� �l(��w�b�E��f�M�7ӎ1��7?�泾�!al�͜�Q{�Uʢ�LF���,�~{�:��B��x�l��L����>\02�#�6̰��	�@�:ˎ��t�3��q�ѳ�������Jv����|�LZ��r�0��jǠB1z��/���#OA���Tafg3�f9�C��\"��26*K��c\'v�5*o��W�s�e�I�v~�\'���>���u��-dJ95�\\s_d��3�I�@Zr�\\�qG0�o$�Z\'1 -@_;c�4����fy�ao�v��&w��\0�Cn�U�/��`M�0�\n,�6�DĂqe����w�V���أ�k��������4�w���9�����Ȍ�c���個wч�y젣�:o.���鵱�Q>*o�8ڳ�mnԏ��ï�>�A�4o����f�2�&��Nō�����s� ��x�B�u�I+8Ve�ͼ�ſ2�>�II�Pښ�y�F������-�|�Z�3\'���Nvs<���a&>*Dz���$6��|��A�=wЌ���]���;�� LP�C�c��\Z�(����e����Z�N;��`O�>����PC�JQ]�P��d�Fi�\nC�0�^�gJ�N�\08�v�E�#�#1.i�q���wE�pcm���M�y$ĩ��5��0I�\ZPA���dG��<;O�=�|/�WǇ2��3}xH��O���L�f��ƩSq��{��M�#����\Z�Kg�;z��+����r%D..ڰ6?p��\'&�v�߂��.�PL�b���G��:J1���Ǌ�9 l��.H<\'��Ȧ{�x���-*�.j�#�C�ʻ����kw�b\0��2ꨠtl�6N���-v��!�`�\r�9��7㎚kl�8\r�Z�	��F�=1섕0�`v���;Wߤ�ϻT�eK= ����֪�=���z�pBjq���?Lbi#��s;8\\`$�w�T�F�!}n�Kr�u0\'tە�60](\ZW\'���g��3#��ڼ�z�%y�[n�睥��{RbLz��wc�,#Y�L�����T��G�W�t<Og��-xW�o�Us���j9]�g��������H�w�\r˂J;���sg���B�ה�#yߨ3�²\0v��CM���z|��hgrJ<��C�!C=*�&�t���v$BpB�8,��Xk��fK�o���؟$�:QC���_bH�3%w5��\"-�u��y��m9&���!\n٬\"\0H���ت\0�^�\'6(�k]f�����˽3��Mb�`�K#`9���QgH�\rخɗy�M�̈́���1��������S;ma%C �\r�ϳ�\rԲ#���Q�����C2,����)�����tq&J�^E��l��#ީT%��4hUis)�0>M�!`��N��)�w��Z�#�uG�\\\Z��#���3\"Y��@o;KĢ�$qG:�8�>���3��u��Y�p��j.k>�\'�|�;v9A$8�ٌ:/	Ǘ��ة���%E����$�8���^�H�d,{���뇱m����\"�	f�X1R����6��R��ӯ#!�p�}�u&6 H��ٯ�V���#0T�G!�M�f�#6��6v�kX_������V,n�zI �@Ƙ���1:��Iø�2������^1�ĦO��^bj�K{��[&����hZmC�.���x75dܒ�\0�Ǯ�dm��<�t�N�V�\\Vz��98��*�뻐�6�Ir7/����B�yU2v��]b��c-��u��LBlK[�r(�4�xZ˞6\0R6\0���Nv\00K1�xJs�x_c;�!���B�t\\����������H9@ ѻ���k�`���2R�e�,_b��:@��{�W	Y���F�����0�����y�\'Y��{?a�(um.�	Cֆz��ޏ-CF��K�/��KAb�\0\0\0\0IEND�B`�','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0\0?\0\0\0;P׶\0\0 \0IDATx^�|U��=��;	�����;�� MP��(6z}6D��^E@�J��K��z���{ι�����O?��8�ܜ23g����.����G#�7��̺T$Í�G�R�����ߓ�~�����)<�p�9���T7gkݐ�s�w��1mJ����]ϳo�:��xi����\"\"n�G78ܓ��*�p�;OKvw�Sϓϒ��a��nnɼ�w��s�&�����~I��_��(���vZ\'��n���U�󐱑\'h��:�����4ϒ6�������>�b�=�,k��7�O�\\[�D�[~�\0����\\`�F���W!�M�jW�qAG�Χ< �l@*�M�����ɶ)�vs���������h���@+��n�\'{}���ڷ�M��=�R�\nk2:~\n�jw�\0�?w<�n����L�J����ظ���<!�\n�Z7ĥz�AY	�yP�̪,`dI��(>ً�������N�������<�@����@��;���>m2�~��}$&9�?{d�5 I\r$�P`4��>�!F�u1E�o��幫��)�&����h>\'e�e���h�/�D@����o��h�EH�D�c���8r��=����!�R����3V��;ٳ%*ϭ�^�OQYu�\Z�>�F�ˆ�4a��s5�lM�\\�Ɔ�g�J% ��N�$�%����wb�����BS�nP��<�;�\"��kԗ�x=��k�����\n�.���v��\ZɴE�G~�J��ipgO��y�2��d5n߾����\\Ѽ\n-�7�D��h���������Y# ���8Z\r���\'n�^M�n����L�Ju������ܺ\Z�iﾀvM�XƋY�E�U�P���I)ZZ��`������g��a	��`���K��P������D\'����o�f��y��\rn/5��\\�HƓ���ҝDL}�)�hQ��\"�\"H񞢈�4\0���6���?ӏ�\0Cmĉ�b�����َ5�v��EŢ��1��E)�ԔT��g��#��g����07c����q��-���C��@dT�����q7l��n�	G��;���.\"6	�I\n�����P)�O����o�>8K\0�)lI�7w�z:��HA\"�1\'|}����^C�	\n�ͱ$IBB<}��L7DD�ˌA~\Z7�9y?:���ˢl�P%q��y^��f�\'�p=\ZS��A�\'�+�D��#&>��g�@?Ka{ت��8��%���	��U��6��ﱼ�~L<��l���&����y���n�ǁ�{�R��䄨!�}�\Z���ϊ��v��$���g��}g�]������ș�/>U�J����v�~d<z���r%�a�}�a�qD�&�H�J�35S����B��y�j�f$8|�D�\n�X*\'f�݂�ٳb,�� l�ws����91�{K|�b\'v��G*��.��k��ٳ��t/�ׯ�dGv8���OV�S���e�����x�F~tlV߮?�\r�O!�(��X!l�q1��bҰ��Ը2�l>��A�(�!\0O�,�.-+Pcsǒ�\'�j�AP\"��û7G�����\"�@9k�^l��<�#��핂��r�?��7n������\0ӗ\0�CU/���TR�=i0�����>���M�D�a3��2W��D��� 2ޗ�|*j���^-1��u��&k�����/W�`�\\ȗ#7;�\\��0fPg�9unF&\")�:}|���$���	|�� ��Db���(GPz{�v�\\�/u|B�cٚ�P�\\$\'%b����ܼ,��(��?Z����4��!>�O���y�1��0c���z/w��j%���)�E0͚Dp��\0����O���0e��H��@1��n� )2C�6�cErb�ǫp/5�}�Cr\\&��%\n�ݜ�(�=��\Z\'/��T�\"8v�Ο�F�\'K�k�j6u=.��Ło��259-ZP�G韝b�\0���٧��t#:	^��=�cѨl>L{�%�E$��;K��C��B� �N^�P�CXlO����k����-\'ЭK#��	g����ѬfY���[�A����KV���^�ЫU\rt�G�F�k���j�|ԯZ��nz{�{k�c�Q�V5|�lr�Ȃ��<�������و�Mň\r��׋ذ�<�<U��\"�q�E<��c�п5~<ræ�Ab\\2��o��v�������-зsM�^��O���eC��y�s�i�([�F6F�� d�Mel���I����Hb|�]���w^�g��\"0 ��4��s��앛��`�ge�Q�3Y`o�`�}���n�ͮO�ݮu)R4�>X�-?�B�F�q��\rD�\rC��U���9�PөQ$�\\ݏ�4�~�6\Zխ����;ױ��W�\'�����\rjF��u1r�T�RC_j��}�2e�М*��s7�@��(��Ĳ����OŁ:�*`�ϻP�P0�N膼9C���9���-�R���ĆϣN�b�����k�?�7�����SѬ�4�݊C�z����Y�G����z�v����54���jX��	j!ը�tjV�5+��Y�ѐ񽟘�%[�c��8��&{��ʭd�Ű�\r0k��G\0�H���# \Z�-Lۡ�����kݚcT�j�mi3j	��<�ǟ��_O]Ct�-ԮR��\\B<͞��#�$��������!X����ı�!�3o��ڌ:5�a���<v.�I����a����q܋I��YQ�Tq4,���s�_y�Ç$sd��Y���â�/!_�Pj>��kԥ6Ξ��u[O�N�∼u�����Fw�u\n�|8�3�S\\�M���\0u?�\0�\rK�SwP���V<1qȓ���/ݸk~9���D��Ӝ�SUr�l=x	��[�hw�x�ި�`��r+<�0�w|�� �]��H�y$_�F�u�D\"��~�,�9E�$���a����%�Dt{�	,��+b�o�����i�o���i��Ջ �h�����稥��_罆l�`��݁O�ނ�ՋaјNx��\r����eGv�(|�V{܍H������cʐV�Q,I��$1���0t�jT)��㺡Hh\0�����a���q��U����y�4�o�Æ=7H*�������c��Vå�kǆ���A���W��~�{|1o/������$���+@��;>\\~�>[�nͪ૷ڑKq�����\'�T(7�L�=�������꓊�^j�����+7�#�z4L*���i��L����ވ��FT<�����@��\r1l�Rܽ��$y�݊ŗv���9C�=��,t)��z��I���7�5�\r���ć3�G�ꅱjj��~��0Np�ӵ�ᓡm����S�a�O\'�Ę������xՂ(Q�\">�p\r*��ǜ	=Q$G0�}{�칊/��WH�^%7Tu�$Q���R\"}�L72�q��5���ј��N�I�\'�������c�+�v�\nm܏�<9	���KĸA-ѵq��8\Z�^��\n���}�s-��^Q��S��|7��7�s�`����k�L�,\\��~0G���/=\"y��?2�\Z���kw�5��UK�ghV$�t�,h[�4B�0g�ܥ�Ӯa)ʗ[��}<w������Q�fyl�q1$A_}�C�S���l�w\ZE�gŋ-k �nfo8�{	�x�R>4�\\B#k�w�a�o4�n#��䍺er�$ʍu?a��?����\0��,�|�.�F�j%p��]:���I���H2��CㆆUJ �$������wʕ̍������7���ɚOVɇ���a���ؼ��tB�|аb!4�YY}������X��غ�$]��Ԩ\n�o�Alt$\ZV+�C�����H������j�a2�C�%�B3�\\\0F�#��ߓB�`��z�P����ƍH��sz����?_Oxk$�;⩥H�=����MLF<]�ޞ� ʙ	�dD��=���̅��f�sgȼ��Ry-�L����x��Q)H��|(G\n�L�A�@�<y~�����$����� �����⽼<l�\'\0M�O ��$�(�}�b?<%E��x�~O��%}����\'y�GJadp��6*��{H��f,H~=I�16�Y����`�$�E�ϋ�e	(\"�LV3Kr�4�B�*���Dä�\'<�GR�~L�$�J+���IM�V �C�5��.m ���\n;��\"	�����S�?x�� ��I��u�J�� %v�xM% �Sy?IT���&�ڤ^����4�}*	g-���h�	�찿i������ʽ���%�i;���\\��)�I��@-�`���F�J��\\�($�&����>�d�˵�r��G�����#\r����>�w�# ������lb\n��S��rv�S4Z�\n���	I�S+Ɖ(<G+ň �x���&5;M��$I��hՠa�&$R�����\0��&I2�����\"!��y\"�\Z�f�[��g�-umL����d� �T��kј�5�\0���w������8AD�(�vM�4e0���3Gˀ��u<��k�=���P�R�^rh�l>5\rD�(Llh\\kQ����c�U��J�����x^Z�܃��\\�\"�R9�gZ�d��*\rR󅀐�`�j�%ŦΊh����o�Q�5�ݭ��fk��\"�������p��UZ�vZB�<�9�*�`eX+�b�Y�QL:�:�onn,۠�i��60i��`	����U5u6�4<���6c�:��e(�e\\C4�U\n�j�+REx\n�=��J���\'�V*��Uci\ZF���wʣ:��cU�s�#�����d�\'�-PET\r�-��\'+��n�A\0�^���<��P��j�UF��s\r5c\Z/f�6X���\0�⥤\n$ %9��\'���`�W�4�+�!m� � ��s�u�����k��(��\"�a���У�f\\煳Ĥ��v�����J��*�b���sI{�߫��S/��T�M+�)�V�o�ۭS�ӸܼL-�ʕ�֝�d�6�T�����L���&�t�S����:j&�؄��6,\0.i��6�Ŏ��j*\Z��6$�� ͵�O��G��k#`�Ŵ��6�hܤ����?�@��zo���=�k����\n2\0�ʏpZF�1�Gqk�J�X5��� �A/��EY�F�D�D���1��,��?���[\0c�H�)�ť��dp*h8�\"�!�C�9]��Y4�xL�/�Q�����^磫��d��`����0.�X\\AI�5�;\0�ͥ������^K�u��o߆Xֲ�x��U��eh.`�Y��e#�wI��T����3WqN?�ܐ\n����E�\r��I#䖗�!�dM��\"$��w��q���\"X$\'��t��^L�b�j^�)͝�t��!U��<�T�R+�����~W����$�p�Q1<��\r,��}/�Z�ҘF��[[(���Kf���{dd���e/菰�״�V�g;`��I҈��\'��ޒ���D&r:d�������*�ǌA?䱜��E���3�T�ͮ���X�����>x\n[v��k���h01�ȘK>>d�Bé���G���жq9�c�d����Xv����t�ߝ�_��h/\\��k:�ʼ�ۓ�^�{�[���r��M\\�JT�_(H��.bcYU� ���/V ӑ�x�\rT�P�I�$9��9���ۇ~���V�\r�$�����O����.�Q�w�֢���bY��\0�H+Hp��`�}9��Fj��\\��c�\r���ϡ�_�`T�Fܘ<,]���u,��+V�r�RNw�4Z�\n�l��Z�P7���#�}�ˊO_���-Ʋ���<\0\n|ٻv�D׮/ ��}�V�[�Ͽ (d1��C&�1�1cFc���\n*Yk�IRֲH�\"X�a�����\Z����ƀ�\0L߾}q�\0#^(�	�D%���+qs�k�\r?³}L��e-��E�!k�|�	��$���{\0F�!�v4��HNf��S�\n�>[�\r��9�G�Ps�*&2���ۛQ����1�?B��E1�O�a��h���RN$��,7�q_��r��H��i��ޒWȅ�Q���̴O�5���N�d��F7��l�ѣz�І�_�{�X/��M��X���ֲ݊�Hquw�i�B���6%���ֳ��1�s3Dƻi��_�!�vGޕ��Kvs�GǺ�WҬ�%�K��r?\r|3^<0��񑛛;���\\�#�Z�Ӥ]ׯ�a@�~ػk�ִ͓\'/>�9U�T���ܬ�	c�L��VO����ǩ���o�qY�A�w���(lٺU�����L{[�@Je��֫��)\\���e�]���\n�������Ȉ�Ψ]������`����j�c�^����n��S�*�L�\0�1ѷN\"l� ��G�%�gH����	��ӛ����B�\Z�ᓻ_��S�T�4�F�ъVV�5��<��\\�QY�\r\ZX�X:�1th��s�R0r�l�w�n���ɰg�G�0g����՘(K�kp�/R�-E\0K\n��b]n[[\'��섧���	o�������N���L�*P6<�Y\'ı���(Kv��e��\\&U���ȼQ坬?8%ظ�5\ZS=i�5��z�rZ^6�X�-h�����!1�Bv��g�/�? 1nZ/1!vGL��9�gJۃ#�h\'���C>���X\'�pi�r��ѳ�l=�j����S�#M+A������b�\'����X���1c��/��v�\0�F�`75����2Oǋ���z\r���~�-�`I�S�P!|��5ws�\rk���5&WgDd�=8p\0;w�ċ/���E�r����`�ݤ��4�t6��>I������9كm&A����۷�\0�͛:��v�H���\0#Gr8�(�@൝Hp�3S��ܙZ �Jf��D�f�䯄�\r:ç�3�qZ�;K��鲤��\r�`L�N�g\n0��2��Jn/�����)x�_+�x�I���/\Z$��%σ��bE0�au2�DbAǋ��œ�a����lY|��[��d��f�����D4\Z1�j��fi/\nXV���#��AOr=����sąg�r�F��0$��%T�K4�*���fS�?]��ޮo�\0�T�\rF��̬Q�	��&m��3L��铌��W��Y�.}0D��NWIl�HP\"NA�榉��#�Js[*xؠ��!Jʤ�H+!�=�H5�a�zf��-�5I�v�߇��2�7l޼�֑��:<�	�������=���\0�����_�7_�D�/�<��5k�=|3�Yp�`\Z<�˔V��t�F��;���Z�S�M�ѣ�H������c���p����\n]���K[���<��Ч����XHc��7�m���F]���wq���,n��]���ɟ�9��O���\"k���N;�fe�9�Z�,B�>Rf!�aЈ�����g\n0\Z���!+��@d���cҼ�����q�bE��S��l�grK��:{n�.W\0��fEάA�\"��V����|�=>q��c1a�3$|Ct�<͛���1m����}���Y��&��T q���D�2�k.A�C@�Z�D�0p �=2�����Vf(��� Y\0�n I�ӫ����(�F��HN���-S�ڞvO�S\r0m�^�L2�\r�9\'�AL�I2�`ziOTc�۳�D�w�	����Ei��)&������s�;ֽ\\�R\0�sx����r^�U�L���K+^2��?���焅]�s��ٳ��]U�^-VrW�\Z��z0����8W�(3P��Ǝ�\0S����\Z\Z�	֢x��\\��҇��U��\\\\5*\'pY��yW�>i�k��&Ӓu�����۸2(�NoT�4��0-��+sR����,q���)X!�_��������5w���2Guy~HPl�\0�����L7���~^��i���j܊f�H䦊��/�vq�}4�Z�t���%r������a��ZS���G\\|���>4*t�����D���3��7&7[����2�\"8\"��K2  ���?��KYD;5�bw2MN9VdP�1�a�^�ITd<�m���TWDÀ����+�\0���\nq�Wje�\Z=��4�17	j2���[5�1;��Q��:Wʀ��w�����O��瘝��\0�`Zodw��ϑ�\0��ט~i�[�Mރ.�pk\\���k��ݷߪ�������S<��)g[��]�KB��a���<p����䯾�ݲ����*�#�i���� _��I\'��)S8�nȒ%֯���?\r�\0\0 \0IDAT@��qu���\'=ؤ7��><��˜ӅĊZ�}�]�?0���qc�8/��M\0�ȁ�C�L�6raYb.s�%�B�>�Yγa7��.�sΘJf�%���ƶ��������;������-)࡟{О���j#��gǔ�/�PQ�D�߬\r�����,Ek��a\Z�i�p\'�7�%���[����v�=���&[�K&w��(V ;���P��	lA�|Y��H\ng��Tڑ\Z�ǚ���2!��t��N�z*GN�ǽ��Z٬R�b([$����Ӹ#FBrGS98w-��]��k7��y�d����\nf��]�\\R��f���\"7\"X	^�\"@@\0u8���1@!>F�p�E�$6�v�:.^���w�#��%��C�y���7�D+O��\'���mD�$ӥ����>�ĉ0���9��d�m�{���lKt�6	�h��\'Q5g�7[i��3]��ls؝��.�^��;wYo��B�Q��_,nM��3MX�!��7*c\nV,[��=���i�-8z��1�&���a�L^�p�5\n�������(;� I\\�f-C�ˊꢪ�\n��\\昃\0u�d�hS���(�Xi���`29���9 m\\�~��(�c�B�G5gK�u�xkv��.?Of�\Z!���Ɣ>�AbU�찮��+���޽{�+�.�hRf�\Z�9r\"k�l�$�ʽ�k��������k�C̎oy/�`l�_�^>_�;ٕ��o���4J��.��M{\"�bS������ےۇ�ʜ�Q�᝕� ��p�&���8w��eɗl-J���R!���\"r�Ǻ��˸��S�N����|NT��nEc�χ����d��;w)}��\n��K�Ú\0?7����VD{V9�G-�C�%�>o>���ˍH��κ ������+>�܁)X��<>]����¦����T\n�\n%�^�|��lC<Y�$�\0�����z������E���X\Z�JF\n��ǋ��G���GA5���OZ��7�fcx�$R�0�s}��aw��d�a��t�/\\�:�*��<)�\neE��U���*ȟ�1�V$���l�l��Y�.�K���СZ.Lz��mirO�w��8���r�B1\'�naL~�;\n,du�Mv�c���cؼ�7�\"��_B��u�B��z���%��\r+%9/�Ę*i.h�ߤ7�i��ʛ$`�V(�u��tikBq#gN�F�~}�{�Lpnب�M��s�����_�5��U�h���Vz�>�6U�m�2e���C��曯�f�\Z��K���([�,4�/\\ĵ���\Z/��.]������y.�_��lϦ�7+��ɓ�~����>��\"��L$��\r�!**���ے����em����իWIb�b4�v�\'�|��M���{��̝�k��s�?�Z�ji\0���H�Ԕ8��4�[>a�*:k,M^6�,�?k6�No�5�m�=��i�}	��Y�l�Y��7cj���8�l�R��h�\00�:ˉ\\�ig��ʉ�~��Ƚ�N	\ng�G>�ݚ�`\0���[��\\͒�o~�I��K17�vBV�$���%U�����P��S5����Kʞ����\0���\rH���PbWH�8,���=�-��%\Z9y��ɕ����Q�S��P ���i��\r�c��0��]��Z8�I�C�٫����T��|�R��q��ђ�]�ý}��k	�=Q�*!;�D����\'��;�9��x��B��\n���(��6�/7B��ڜ�,�׫O ��c�q�a�[�f��1��B�k�!F�Rڈ�0s�a${��F#j.��^4K&<��!��2�X���q��}8���ܜ����ڢMH�$��p|Я	s��T��^����\r2���[���p/��S�Vk\n�~��_�\ZÇ\r��ū����^G�٘ԮQ�ϝ�4p��fOb�%Ho,_�ݻvQ�X�2��;׮\\��7�$�U�X�\\<XS�_x��QpdSbXء+�6/��\'M��}���_+.\\KW,G�b%��\'���3x�E3��&���&`N��j��=��Ç+�E��.m�v�`�L\0�6�故����0p� �̕��ց���B/R/z����]�g1v�x�	�n���\Z7V���x���Ѳ��P>��}$��:o��y��=��\r8\'G,��εo�ԄLYv\"��ɪksr��,h���q�\'�������ԭU4s�}�r=���y���?�z	ϲ�|�o>*]���@��[�!�SUɑ�]��So\n��\n�_��g=R���y�E�I����Z��Ao��Nq>z�����E�2y�FQ7�|H4;�P0�/?[��ĩ�|)r��!57,ϓ��8���V�Ԯ&��q�$�K�/žˌ\rbU唒�ѨB!1?b#�&{q2�\0U3��Z�*Aj۰��qx�||�z{�����w�r�Zs�\0hH[���=U�V���{��i4�ů�\\u�^>j\r�G��W�X,�<r��b��>q1�*b�\0�4U=�=6I�0Q��� ��@�g���*渳��Vftp�l۶]�\n˄��~��i2M�<Ez��+��S#7z4��5S/�ޢ��f�v�����p+�K/��ܰ��X��a��j]��\ZB�J5l~��!��X1iBBB��y {�4u}q��mܧib�+���X)���sLO���c>AR\0�`�BX�d)\n)�P�9��g;<�4M�;\n0�{���I�u�]8w���őZ(���+�\n�$��ҡ	8A��`�;\'���v8D�,��\0L�^�|2��{{��ڒQ��Ų­p�=�a��}��;Tҝ�*����߷Ls��^x̌5|��pi89�L}j�d}�>���]����\Z s��[���p�����:����+��Z���/J\\�0Q��Ⱥ�tus�Mf\r�;�=/՛�\r_�f�+I�)�>���=W_cgm�\r/�[�89Q�� ��Btץ&J�9?���~bҜ�UX����E��AW�hEn���(&w�:�����dNl�Z��D�ͭ&Jq��S�D����y��N�dp姉��	�$v�6+R5	�!���w~ɲ*9���=�c�cx��x�Kc�S��״�ܫ��\r�`]Lˇ\0̈/7����`�9\n0��$�(\Z��c��DK�FaS���e�����u\Z��=^���d���Q�\r+��\nyc�G�Q8�`Ě.b�f|�n�S�6nB��j#\nm۸2�dx�}�g���SPhа1����F�4�[�\0sA���O(�Hl��?��g۷�d��%J�&�>��_j\nթS]_z	�/�MM!�|ʹL�<	�}��z|�-X�b�VL>1sD�E�6l����G�)T/�S\0ӾM+��w4`&M��&E25_1�\n.�g�i�b��~	|B6�8K��<��#��ɓ\'��$X�^�j�j肴o�/xE�`0��i0�d�-õy�#7j�Ң�?��I	Ƅ51/�(&p�K�Y�\Z��ʧ���2�Y�������C4-����t\0�pۇx�l�Ju���ϗ��qx�C-z��b\rE�dıQcgl���p��R��J�KFv���ł��ܼ�4����~�.�Z�\n6��>�݁�gD~V~_��	���r���\no���;.�+��ar��r����q��{�\ZId\r�2^�G��2A��=��p��<��4��g��`��AH���$�z$bƫ-йQ&y`�/��g�	`b�W��&���-(���v��M�*�d���a8ˊ�)�RB\\����F)n9<��v�C�\\��+	0\'ɧ`l�����3b&�2��4�$�,�E���~�!���\Z�A��]_z*J��«]\Z�Q���<q���:}�wg�}?���-�M����c�N�m�)��\"\Z���V�Wp]����g�\r�E2��\r�c0�Ï�b�:.B�7T�\r&Qfނ䮼�s�O�v\n�����C��П	����E(�b�\r�s�M!�;u�$C��ش�{�Fa6�;���<�H60i�����N����tl�ZM$��z�c�!�wʌ������Y�z�rQ��Go��^}�������{`T��\0`�^�\'7��7��5���}��2�0�##�1�t��\riK2�b}r �Tm7�\r�\\%i��i�u�)o`̄>]����-��;p�E67�-�пz���I����?�\n��=~�&wڋAyn��Ϫ��%q#��5�$��>6�p��r������$����/�C�X�-G���	�Cp�&�L�dn����i.	��vo}�\n?�v�}	P�Sa@��@ I�~�G�j���\"�����b�7[�B\rI��sv�Z��g�`|���t��OX����n��đ����4,���k4 �bU|7V�OƁs�1��)�:N���j\"B��-^)�x�[}�M����e`D�q1����\Z���j\r�w�p������ <�$���=����DILԚ搩�&/B~\n�֨ɉ��C�ʍ��de�6��7e\'	\Z֑����r�\ZͰ���7GZ�f�� 3x�+XD�0�b���U��p$\'��H��\'�P�v3�C�6��$�1�Y��]�?�Įіd����L7ӧOS�\n	��իP�$�H\"\'����$&����Y�Io\"M�(\0��tۄ��T\\��g۵���=�۶ä�S5HH�W�\n��H��\Z�,O�w��W��xM5�d.��Ȥ�6�##�1&�8&�D�[�.�G�y*!�fGd)�Ay�}hhadj\"\\�{=p��[3� �?��zRbARB)����������&���^Z�q���w/�M��bq�n*&�\r�y���\\b��\rs\r��m�w:WǊ�g��;��Xn,Z8�\Z�Z��ֶSDXLn��m\'�{�2�-�Ǟz�$�Vȅ�G�G�7�I�,����o�ǦC�b�P۠�$������.�e�u¥��>q-~�^;�$q�[¡������W.o��G�3���}t��6&#����l�h(��g�n�7m��F�+掐��`l�2�,h^�,���b������Gh�wN �r��zc��[*�U��V�����ƶi���X{5�YP�_��8N���صȧ|��g�MO��q��u4�	7[3�h���i|e�P����D�����f�GW�p0��݃vm�6A�<���b�z��\r`��H�D���\Z��	�����K�@;��HB��0��Q���`\n)����\\9�D�(&��Y��;8ca,��;��*���7m��t	6���d˖�w��ns�\0������*�0��:�ڡ�\':.��P�!�7�%\Z {���cځ��a�����V)Ij�v�����n$�\r�\Z���H�hB�F�Ռ��Rxd�*)	!N�H�f^�\Z:2���|��8�5���שeD3�-|9�^C��$v��\ZI�L=|ҿ	�Н�e�2���9�\\�,OL����P�8]���U9��N�.�Z�-�t�ʏf�;4����K�^ΕIa���%,��68<�LS�mHHAݒ����>�x=/O^�m4��sd�cкf(���4�0:�X�]9�����9�0���M���ܳ`=P+����H\0��\0�``֌���,w��)^�/���5���I�\'$y�q�ԥ�`.w|����S�ͼ࿔�X�JA�&гM]�+B�1Qy�TF|�$�Ԙ}��*�@9��L�K-��B\ZL���?���\r�J8���Gߞ���H�u�͙�\'�5s�����tɐ�b\"����ݻС�3:��}j�d�]�(sA�PL7F5���3W��@\r�Kq���`�w\0��Hrd���ܒ�����K�˽{a��I*�2/e��h ��l�Yx=,L]ܑ��IB�Ŭ�_��Aj���۶l�*��dW/�h0������\")�s�\Z.�xwHt+y-V��%��etd��p�(ٯ��t@p�:t^�ߍ\Z��8�j�2߄O���\\���2lo�%�(�LَM�2��BZ�R3xㅚx�SM��k�KДEu+[�J�Ц#\"��|���W1o#����xV=W���rU`�h2Ů�\\\"���F��650��g0D�ǲ�b�؎�P�\Z������W��\'8˨7	�S `��a\Z׻1�0��lҥb����M\'��Gk��h�G�͜��|��W��D�Ǥ��NsGs��６*{�K᳡�MT��03M�k69�>�C�ݥ�Ɠ\'�J�����霭�|�oHUƊ��]-�_3����^2�#�!�$�|�Z�H.\Z�Zq�\"uÕ�����9�#�1���H�t�f���1OԬT��U@]rG��g.($�=�38�Y�t���Hj�	����＋n/��bT2>I�X���u�g�[S���h\'y�0#��$���̞�;`,Dc��J�7f\\���3�Er=l��5��E�7s\r�5����B֝�҄�ulm(::\ZW/_��ݻ��ǎUPIfDBkp��ů$��D/[��\0��l���{�acn���t-�<H9\"�X�M����Ó���O�VvdH��!����v�f�{��x�1BJ�ْ�0ϡ���^$Y��k9�����jD�)!ټ�P��v�i���B/�����-M�������dbv��,L��򽘵��\\4/��\n�ɟ�F����)M#m`�	0]����ܿ8#��U�L��e�19���B�@��������/ң#q������	���OVPo�CVPH��]W�o�\"�0r�1�� �2^�5�?.߈B��+����?�M�侬�7�ي���O�ӺB���t���R�#�t︻\n0�-߃ϖMuS\'2&� �\Z��7ro�}F2l��`�M�A<|\"M��ł�l��썏W��xn�~?E��ʣ{�c,�-�Z$�����Q��ة>j�ͫ	I2u�ɐ	�h?٦�E�գ®]U/I�v�1�&J������K�N�Ax��1���o{�x��45�(�ڵQ �j�[�0hث�1��5�B��Ћ��Fx����I�9�\"�cH�T�*0�Z�FF_�@�/��;17�M��:_F\Z��@�*�\ZY2��B�K`��Uș3���T^��yx_٥<��S|k��lpl�qjgJ^)�kX��e-��P�	��[0ct$\\A�d�1�ó��D�r����h9x��dǉOSN]�r���%�;�$77`b��e-͘�%6	���\n��W�z�8��E��e�I�;�{�#oh��Yp��=M%HQ��2��ЭUU|9��CfѸ�([ �m���!J�a���\Z������[�`��i�^-*r�0\Z�QS�`�u�3��U��5��E���K��Hr0��͚6W�3�cL��)�o�}��<wFK_B��W\"2N�Q+�R�-�6v��9+����`L�5F�H-j�Zr;f\n����y�2��\0c�HU�eŲ1]Q0ԋ�IX���~�<���_�nX�T�UL4�8� N�z4�B�B�ڮ+�n��D�C楶�0�\Z+�/���E��\\�7bj�y�&\Z�H����M��\'�l���}<`v�=I^鷬�#�z��L���C-NH޿��dn\"\r�ܩZ,J\\���8�]�T)4i�8J�.Ŕ��a����SJ���Ǡ�Bŋ�DZMw�����f��3��~�P\rS��̿?{��K\ZO�+�B�\\�)�5�{h�n�s�p��B`\n�?��qfS[�u�V�^�ۏE3K�Ą�5����z?�!m+*��Ix&5N�dzd4�D�ٰ�#oW�J����\"ӭ	\nD����r��h[�\ndu����3~��M�\rIe�^����JSf�Oe����45�E�:�\\��\Z&[���4|�+:��^Ɲ���,<g<#U{5��f\")�`��k�3vb�\\#A7�ҫQ��3s\0.`l\rF�9}�h���\\L���R�\\_�1����gG�G<���\Z?���i;������3��X���\0�D�|�H\r̀�	r�I���@����L���P`���D�N�w��`�+����n��sw`#�ɭ#E��%��w�@@᜸:1��u�\\�>�]�f<38���h0Ү�����%���>3�/<٢����>˖.U��|����MQ�������$L[��b\"I��Q��A��2��r0 NF>?�!�Y�O�H��H�]||\"z��͒��stϴlN���%8|W/1FGJOdϙ�\"Qe>�|�����w����F��d\\�7ɿ\n��$*��07u��1Hb��T�J\\�BJփ�I�,\0\0 \0IDAT�8�)�Y���e�lM\"6�dմ��H^�s�7+\\�F�a���x{�z���$N�HP�����*+��w;�r���r��`T猈0�]F��-=��jE2�W)�;�z�;*�}\'S����Xz�0�*���`&����`26��D.��-&��%���NB���W�H��&��3k����k4���x�����`��( $/5��3�bX9c\"�6\nh	����c�y[��U�Ĕ�P��α�\n�qcН����@v�{c��`�H��t�P���S4;I0�2%\'��w������Z{�$����o�\'�^$\0K�vg�\0ݗ\\0��B�E$���0���7�8���HD�R%�P\'��9=P0(��4ZV)��g0���-4/����=�����������<?���%�=}JI���oR��O�u�#���3�D\0F��~�\Z����\0#Z��W���Y_��N��\'�kى��[�k�Hw���	���2]�0�)C^��b�\r2CŔ��;&&Ⱦ�<{��A�={�La�HKI��i\r�ׇ���]ߐ�V��$�7c�6�wHF6(�>=~�*7g�9_<$Q�^5?q�2/� �T�C�q���(�z?7�_8Ε�[�^�I�P�Fm��#��G����EVu}�q9MƬb:�����b�g�\Z�>FeD\"h���F��bu�յ�&�i#��;��<��[�s~K�-;*�\\	���T|%\0��4��Z�X�E�gi�P6��=K�a�Q5=i���!�\\\"#�)�	Y�ӌ�G�X��4�����Jł���{�|�-��F����\0C/�M�:�H�q1�W\"\0˦�A�\0Q eDd���\'\"��F|��G�\Zb[�+GR<�̆�?큷��9m�A�?]ʊȜ0$Y�&a��}Q&o��`�^�]���n���.2:�T���t��8�%㺢@���£�\"Z���	t���k��y[�`�WJ�v\n�\Z߿!�4�1�$�W�ࢎ��O��֬Z��P����v�z���G��x0_�dP������LI^jg{w�D;�H�%����(�1��ä���z��|Hq+&�u���v_|�1� �.��� Q�ju�5�i��+r�oǎ�)��^<I���Q����AC�a�j]J1�r���tl],�9F�E�aɋ\0`��5\0#%3������:>X���Q��:ᛦ3�W��$�&�^`��t}�ʻ�l�71���6�%�|�RO �s䐼r����͵߽�ַ��!h&�Q��D�N�����b~�$�Q��f�Th�\'Y��Y��<��>]C=\r2�b�v�L����5t��-�;w��hN*>�A����xFon�!O�Ԏ�)&n�Sע�s�*�>u�re�ry��<���UH�6Ǻ�`b���\0�m,G3`Ḏ(�����B0\r0�.`�,��\0LCLe�`���L\rf�S�u!��*��A4�\"���\"i50Y�N��)��:��=Q^�\n��J��_��`��H<[\"��*mr^�X�{5��%{�ά��,f�C�H�*%��a\0����m�@1�QDS˘��F���㥴ϕ�\"Xf�W-J\r�#s�<����<��-eNe���_����wyk�?x��?$����#��!	c{�Ő�5�v�D�!�ƒ~[�z��e+^G)���O;t��ae*V�]	�\0T�#��W�:�-7u2��M�M-��>����kc�x�P�3:l��:y���!n�5kסD�N-��̢TF���-��:?�</}T���̟7o��jLl,z\r�~={����JD7��]��%�A�T�Ǌ�,��r���YF�#\0�3gȶ%��\0C9i�R2���{�/�p}���;��T9�\0M&��r+�xlmmD�D��Fޖo �Vu�8퓇hC%yUt,M����iF����;�F�=%Ѳ�\r�3���I�F>&��kA�iZ�4�V̥�C��m�&���]밄��� ������t[�\'h�	�U�yܸR,�Y8q�C5��sw2�x3eL�<WԨ�(tiU��>��;O�ۨ��a%.cÚU!3��%����\n0�G��\0s}�`R�\r��8�j.\0#\Z�61�,�1�ڀ(��׻7G����G��J��-G1n�D����\"hR\'`�9���(&Vȏ������K�H�T�Wf�����$��j�Mc��������7��y��6q2�x\r	+a6��θv;�X���B�r�����D٧�na��*���Cf1�1n�l�HN��T�H\"��$½2Q�ŵ)��2	��\"Р~}�d����_2��G&.]���},�zo^}���%oif0��`�����\n0�)�������(��y��5�/��\'�l�ƍ��\\g�/�k�O��W�|�5y\\�m�f�qGܿ�V,�u����đS/R�~���oG���U�^}|����N���S\n�>���Z#F2�m�\r�	0L i��vM�43��E��`$y�X�6V\r1i��)�9K&�k\"�X#\"�fABX:g\n��1��H��(��3���όe��ьaf�ʥj�xm�JR���_�ȏV�@X�����z�B�XY�b�1UR�E�pg+d@�n��ULT����9s�6AD^�	��2Ԇ�T(�ڕQ����|�\"M#	��6hqq�C�[�Լ,�!Ḗ�v/��1���1��X��\0s�nj�4fP��=D�Y��\n�H0����%7j0�\0c4�`,�H���K�8�2��(3��L)u�v4�e�\Z�a�����`��Z��=�D�@jq�xi�r�;�t	ojxk�����{���f�Z,���zI�uHUVLJ��s���B!�kc�`=C�_\n�Ь(�\'e\n�@�<ّ58�ŭ����?umю�S/�{�7��I�+�\\$��WKa~M?�\\�T��\\�r�O�b��ZUn���Q�ޒ�x�S$��E�ٳm�I��4G���a�\Z��6%s=�ZƐ�C1�)�im4\nÉH�[������-�����ѩsg��q�-SNL�3�Na���\nJR�B���º2��6����|�f�h.~�1�����\\-#W�\\�ıc���!$���w���rP��I2�\0��D�A�R5�k��U54}QL6=������/	\r����7�y�M/j��^���+����\ra+�&\"��L�طj�#��#�h��L�s�����M.�\'X������T)����;,~���\r�Y�Yrm$&_:��Q�˨��Fܚ7�?3$A>^hP�$�>����-UQ�M�\"\n���dI�\"!��`���x\n���F�ӾQ�iߴ�#�a�j04�,\rF�x��4���r��Ý7|��\rf>�,I��t\Z���$ڝ�f@-�.u�L%���bpTgP���\'e��1���ʝM�(V�0�\'L_x��^Yi̽�G���9��2ӛn�ܬ�Be�f��#���p5�X8�>x��n���S^GV5IfN�S��9�����Y��ZJ�\'�ƞ�*ཞ�#X��e�Mm���q��ȋh��i��b8���㩧Z��ߩ����v�o�a:�U��3\0s��Y�}��V��#\"�3��6��ŕ������M��}<}\nƏ�`r?�0|�S\'ԨYy��Ӻ.�:�\r���fqR�Ạ�L�HHH��ݺa�ԩ�����I����)ժ1��\Z[�U�<�$x��G����H4 )P%���rk�o\"0��9&�Q\"yen���4��U�	0|i	a{q��Y�nr*JZ���Y���l���fD��ǹ�Z��z�Fv���X�`\"q>�h�&�*>��i\Z�{�y�+䍨L\"���ll3\"?�t/cX�hŶc4[���e�U7��o����(j�==q%�lQ�{���z7�h�q��Y婞!#��p���M��S�HN�r����iZ���p&:.~�-6��IWj0�06A�v�#ϰp<9��r0j\"	�K/R����mA��9�D�� �:3�ʺ\0`�B�л��)�J�B�B)^Y5��Vr7�u�`���hZ�����&�Yj�]����b�|�&s4�vUU�Tb{d�h���WӼ��أ6칀m��P�1ۊʋ-�������i�]sE�K��f�{�J�:\rm�����{b\"X�&�����r���7DK?�l�P-F�,]=Z��/���^�b��!�+�1��aU{�t���Eʨ\\�+#|�����H;��Ǘ�V�V�TW<Xb*1%F�bV��~�9*U�DWz��mpp�>S<�}��H�\0�̕4�l�MbvŲ�X0o�.�m:��\'��E	[�h��uRJB�n�H�\"�`ܼu�U��1���V�k�d��	��F`Y�v5������*0^\0�U��X;�O���/#K�y}�ɢ��oIԐr�C�gހ{�\ZH�m#n�x��t�ݜ��P�Bnk(�R� A�E�#w[V��!�39���0������ͪʜ�It���=��Vlñ�w������[�1l��Hr�W\0����le<߶>��h%�4�Am�$^�K0�w#��{x���E/��E���7\'���[4���\n����jųa����=Kb���^$�� �%�;ol\'�&�k�;��H�F�~3H�>h\"e!����/����jt�^3�f�E�g��b�J9�������䵽H�˕XE��*x���h��%k�#�$��<$kU���@�_�L��\n5�+���\"c.zȮ�2a������:�\r��1��yC�RStz��L\\�<�����A�.�����������u$0���h5�RE��TІ��[�0��	��D�z�at������Έ�L�`�$Us[���b�p_�����ɅR�EJ/H���%ː�n`\0l�р�!%\Z��(�)�-&�<ɦf���ۑ���J��eh�f���7f8뽜;{Ω9��B\0&{6̜�5j֨�J�ÿ��� ���!12��/?K��DV�+_�<>x�=|��l\r�o��)��F���,J�e���MI�#Z��O�+`[��@��y�������.�{۩�/�h0B�W,(�;X��f�E_���zp����/�Ր��[��W��2i���^�wv�/Nw�R�9_���\Z���=�\n�7�,��Y��Ҵh\'֨&n뮙b���$]q���<�vHj�6�S8v�2������I�#����yRc����\rr��d��ܛ:��͂�!�JŚm�N=��b�{<ä=�-����e�r�[�K�`��-c�N*�|9���aX�&8u�.�#�%I-\\+�߃fHN*=:���x��U�w�:�ӹkq�ϔ2	�)	S��U�*�[��Հ��O�	���Ƃ5[�H����|d�s��!]Z�4\rg��J�x�>ZT}Q�x�nC;W��7�{�2���ގ���Qr\'E����Պj]���j\'��j��VAri��QX�� 	��Od��Ĳx C�+10�M㊨�X~UsWo݇~9�Z��j6flnotk__\'ݮ#����\\`�;QI��)&#e&}�S�-��q{ߖՋ�j�b����{1�\nǶ�t�?$S3���p�4;�R�Jx�������!ڳ\\\'���,]�4zQ ?�2�_|�^*kٲ%�6e��{��E�E��GM�(��X�舉�K��xɒ�\Z�%�]Ws�W�m���ٳǴ�Z��d�yP��s幅���36lؤ5w�(�BV/3�A��XO��Y�����Z��$r�X�>�S�vm��h*��4�;Hl�ԣy��׉fs�5q�̙���(m[U�X�<�p6�*��xWh\"y\\ݣ��(��[ Wӗ��#�%�A-��q��r?��X�]8\Z�_(�e�r@ �S>>�4\n���6�9.�H��NH�`���+�$����V���K��\'�+�[1�¤:�/k�z��F���\Z�*�!��NH0]83��f�x&���_M���zvB.A�o^���(�&�G�@/N�*k[F����$��|)���%:R.��ɳEC0���b��	y�-(�fl����x�h&�G�׺��)x�N,SV�\\�.%���aBlkؖ��~-��0�9Fw#b���Y(�!܌Ο�\ZC�����%mX}A�KI�w\"�s��\0�qm��q�.	�A~�P��eu����KH��\Z7����2 �w�~EqG�R&�6��Zeu��\n`�� �ϗ����e��m�m��C>4U�d���]J>�����jA����h�+���-Ir�M+	�[f\0�j��5���sLt���Iַ�1\Zn!���xR���$|��9縔Ra�K�eT��L<�>�= T��	��V�CH���D�2���(��8�~ٮ~/jf5���=��h�-��Q��)g6�B��z����)�G�!~��O2�cupn�\Z�$�&����&�0�#�������G�j(��ָ�Btb�Mӄe��\0c�L�#N����T�g=PG���Vi�\n��J��4�������JK�@ީ�]�]�^��$1����k������Z�RH9\"���7m�E;i�4kٴ�\"gN�nX���>1%iV����m+��=f>���tXPzh�*�ڷE�X8��z�Z�X���T搖���s��j~(�9j5�ꋽY��M+�H��zbj��LQ��Y�ŸN�#b����%3`�Y���o��sza��&d�Jރ �:t�+��I���~���=Z�sm��&�J���|��[B`��}�}��oʤ#Nٱ��zZ�{g8�3��A���QYY	W�3���i?�4��W,ܝ�^g���4�Tn�vk�$�X���ZdJ�H#\\�U#�����	��y�u��D��ܙ��?Ȧ~�<�Ȳ�y�h`���eך���	�U���ie�aA��d��-RʸΌP���FcH�w2��,h6�Rd�	����gK�����R�zOE`�)��ƊX���6\n��D�L4*��q�Kf�M���}qr���$3P���47Z�nx%��2&f�XU�2z��E]��6�i��\rΞY�ڜ�nk�Üo�t�Y���\Z�$�{2.�B���:v�n�K�m2N�Lk�:_l�?<�@�����5�������{�yf����y����f��5�]�\\Ӝ��ge*��]���g׫��W*�3������K�kwe�5���\Z\n�fri�.g���ӛqk13�c�j18S~V�s/({��y��(�Dq��&�+O9�c��1ǿ��d�bj��\0�q�z��֊B�h��N��a�YRdI�g���]�wW@�������%hF�O�WY�Bn�?\ZsI�r��ʽ���M*�gۭ�W��~�y���UAa�?�>zNX�OЅ�\00(i�\0L犘֯�y�N#�fj+\"VU\"��Vc\'r[�a��R�-�N�E3f\n������s�t��с�Q���h�|s��6�X\0`��5��\Z��F�8�!����{d����K��<����%��a@ck6�\Z����HZ�~�$��Q������Gf`��Ӝ��w�/fǄ��O�Pag3�#-�Bޠن�ZP�,�dHN����!��<M�5�B�C�{�ic\"�I���������\0֯�9i$C���$o����WE���9laX�*�:�U��FƉ�\Zc#Z��R������T#x\n.�g\Z5$�κқ��\0���OW\0�z�a򲺫\\Z+��K�ެ$v?��!�y|9X��5lcJC�D�\n&6N�04��ᣀj����b\0Y�w��;G��M�Q�-�A�	�i�89&��������;qZ�. ��j\r�S\\5~�~W2&\ra�mF\ZHz�Q�Lg\Z��T�׺83����=���s�L#���\r�\0�+�����\Z]:���\\�ӹ�������6�T�ch2���\\09?M��Ch9B�{5���j���_��澁�p�9eL����T�#���@��J`\\�G����x`d� [���\0�S�Uֆ\n�7\'�8�J�Vδ���T>��k�>.w6\'��]�kA�(�4Z�S� �&`!R���I!�O-����J��v�b��Jx�����\"�tQ�/!!�`��f���.G�<AȦ��������7�3���������&�mrfD��>P�]*4�Z{7J2�%?N�?�#K_אN�R\Z(�����<}���5GhY��|L	�p�f撏5��p���oT�y6��s�ϟO����;�!09T ��[v��\"��K(��C�w���D����њ�rtX$^ٷ�c��s|+|�X���)򐌐��mQئF�X������uea���CS���i�?�o��Hj\0\0IDAT�K.�f>�D.OD=���m�����6yW.O ���\"e���Q�︄��V52D�4}�̜y�\\\Z��z��h����ْ;8�������	����\'\"�-�/���y�)�Ws������g�1eK���ʹ���{a!��g�o*+��\\\'URQ�te�j�i���.�����K��-�p�1Hi�\Z�\"�PH����U\Z�+��N\":�\0\rdM|ts��ɭ/�d��=��\\�E�U~fPNߐ�Ȕ�5���Qkk���?L���x̶��VL�3�ۛ��a�}3��(��\'�K�G��Ø��P�;�^\"���glc��?���jɏ�Yy��z����شԆF���_��Z�ִ����#����� _h���z2&���ױ�4�����-\"b?�䀛7tBYz\0�1 �neAZ�d��U�s�ű����7f�h��P�Z\\���\\�{�v@:[s�8�	1���xT���%�\'���oD0�m����Ռ1�Y�Z�\\ `��᮪l)�z�����u�?��b���&J�qɠ>\0\0\0\0IEND�B`�',1,'2015-05-19 19:19:32'),(7,'la cueva del  zorro','la cueva ','comodidad y discreción ','12123123122',0,'2015-05-19 19:46:36','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0d\0\0\0!\0\0\0/w�\0\02IDAThC�YPTU�wL\'|E��/Ұ�(JGf��i�,-S|�,��Y8�3>5_�d�P�(6�S:N�*��Z8��*+f�Ce����r����{a��6�s��7{�������s�5��ڔmJ]�	ic�N�NH�@SG�!:!m��������h4\Z:t�Y�2�쐃8Y?q���A\n�&���o�\"�S,�a�b�@�������?0��uaΌkm2؜aaaZ�*�2��(~���cE�X��_�S_V?���-�sƶ��4G�ԏL����#\"���$,�[�l\0oo�f��lc���iQ�5ُOD� HSfp�3D��񷽘����\\?��\Z�Z���5B���;������f��j�j!35nܺ	���`��q�s�߄�QrIw#8��\r�m����D8J_#�s��w���8eY����6k:�ٖ��y`|�u�s���vdl�%̴33\rf�LW�5�*����\r�Ft�В���X�P�\\fȷ��G�v�I�P��t^�y.c~\0�)�u��+�#Uji���444�c��{y	�T�:@;�g\0\\+��);�yb?�	�[�ʼ{n��$����\0͵����B��#�4ksW	y�2��V���T^�X(���Y���`\']X]o����]�$\'dɪdX��,�WV^IX9*�f�x�2RvJ��[��e��n���K(�\rg^\Z ��l�N�!�7otS�����d2�#�}�\\�#��se�Y]�	}�%r[nMrBfΉ�S�Lٙ\n�gO�������������	��\r�7���}0�o�Z��|m�ڄ�Հ�-\\NȢ�Ka�e��������g�C^y��V�.�@j��AV\\��Tw�M_��p&�3�|���ΛR��p�▝ˊ��gw����_���H�3��~v�Ȭ�nY|uL\\,��e�Շ��wF�V�w�*�	��������dZ	��݈��z4�nG9>Ay��kc��|A����.`�%��_���R�Y�����&�^�T���!��3�vOR)�\'rO	�T	�z�.����!!��H<h!D~��S�E��s��/��S�V��.��?6)�B�z���R��^��>�1�@���`��]Pu�\n�$��şA���*Ԑr��] ��z�\'B�q�N*\Z��xl�����׭���Q=D)ю�8,���q�c��N�:U��������0p�,�qsQ%�]_ۣz0x6]������j&�\n��:񗮲$�C�7� �\"�H�Eī�=�rD\0���)�E��8~��v�)���Y����J�By�)_���\0%��>k;���C��)��U��\0֭[gWn���Ќ.���G��1/d7u����V�\r?>!P3!���e��{�����s��BPt��#�NaJ\'�#(I��Xΐɦ6~.�.��x��Kɭ:�)b����KeKl�r��/������3`9�ѡ3\n1�^��5������_3!rc�Î���2#������n`��V��H��(D/�Ǖ���� �] �\')#\'%>��-����>C��6m□�M>K����$UY��]b�-a���r��`����oE��N�\"��(}�,���F~�,B1/~\'�C6tx��Y\"��\\(�q(�Ii$��kth�[��BCC����\'�������R8��K�R�5l�0A��,�&hi1OB{HH�@HRRDEE	K���~\n\n\\�����#]Z���O���YCpp��ܣaU���t�p:��屿�qV�5�����mI\'DżAAA)�a_qq�d����腲�e\n�b������g�]o��Vv�0�wYV�\\���s�0�wYV�\\���s�0�wYV��ٚ3@L���\0\0\0\0IEND�B`�','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0\0P\0\0\0��j9\0\0 \0IDATx^�]`ն�s{��	��;�(R�RE@@EA���`y�JU�\"b#VTD�QM�\0���{����k�%Ԑ� |��3>^�ܙ3g��g���G�������{���t��{���{�r\\��l`.��=p�.Y��30��_�+ݿ!U�o3��sI�r�#���7�IM\n\n%	�W\"���i[��z�-M�+c�L�do��/��a��00��)��{Z쁟�L%$����!\n)|D>-�:����iC���IafD�Ϡ�:@�OU���d��ǩ�֪.I�%��c��#]���&o�r�;��Ҩ�]��И��҆��J���TA5������NA����MKJ�:ld`X$E�FMJ%�\rH(T*5 e� �6�1J���/��|��=�_���F�<��#�b��zK��0�~�L\n�I]�G!H���FG�D\"�>@���DR1)�z� ��S�<�ꃄ�+\n�D�@���(���ƒ������q�Q.�����:#��i�g���j������0(H)��B�2����l`N��9\"�GKv��b�ŐP؀rT�\0�%�H��`	����kU�\\\Z�̓�Zw��>y��~3�/p��z����=y7�u	�]�~+ݹ�����ۢ<�I����\rC��i9uH����A�°(�^�� y�6�8�TUD5na��(I�g�	�&�K+���WK��J��H�d���b�T�y���{��J\\R#�`���rV�KQ��d\n���}<%ݜzI�{��v�h�[#�B��� ��M���8\'|n\0�� E(����&5\"S���	F���M9��%�.J��bĹZx\\A�FHF(�0N0>�Ri�R��Jj9������+��r;/z\\��^��bk�W�L*�Oj	��R�%Q�G%H�Ґ��ǃ�]���x��7ۋ��\\\n`�3d	�?����8F1\'$�A;�F#\0���\Z��AITU�,��Tj�K����-���T4���\rYe�K����QS@�u27��Q�22^�l�xO{�J�{��F\\TS����}1��|Ұˡ�H\rT��	�]���$��К�������tQ����\"qן�R:I���+�d/���l#�M!D�¨>���p��\Zr��<@EZ��@s���5U�+����Lj��(�\0ͨ�<\r\"M��T��4�Pl���w]>.�����(�4�/Q����C$F��@\0���9\n������!�!�bu�&����v���rۺ��I�yL�Q!\r�E�>���)C-e&�Q$F�g�=�q�	���0���d7�s@	颼�v�)�4R�:�t�&-��7y˶�zk�029R��VHЀ��d ����!��j�E���_g6�t�{�n\Z<�]�.�s^��?�kP	�����%wt�p�LX�����Tõ���x08\n�åԐ�bI{�5�p��6��H�.9��>��Y-EL��܌����圏y9ԔFV\Z|����\"�����6F	�(�OJ��Jp^�P��NB� t2Vr�Kɦ�A5\Z��J��J��r��&vQ\0�UW�CWA eH�v�(_ۙ�uX�������8^[�(,,�޽{S�6)k<�;��r+�M=p�Je~|�Q��J���@|�XdRz��C��RP��K.��JZ^K��w���r�\\�@�5u���������]��=�N���弨����aЂ�a�����\n#���%RV��%OrmR�I!�#�Jn\"M�Z����0QH�(�*]%�h ���g0 P\0��0n�ZdH��S�Kn[�[�1�Ojp8���z\n�8d2T�E�FT��o���O}f��9����i���5���y�z�L\\Ѐ*>�����#{�B.LR���&<iUL�b��$%9�N�.����2�l�H!�3�\0�v�C~���F3%M�zA�(��QC� T���}#<d~�	�	���$�	\\9u�Z\\EI��\"_�*Z�6��/�@�D7�:�dM\r�?�kg����Q|��$��_��;�4�b\"����U�}S����,SgRZ��\Z6l��=�]�����\"��C��|���?����o�*(o�/���q�+��B��B�������Bk,Y��\"���H�,!cȋu\\�ŅP.B��2��\0�Ѳ���3dH��Jm)�����/\'��t���]l;\0h�(��)�Y�{8������B(\0o\"�,*\n	D���\0B.S�z=�ޜұG�\'�9�F�n�\nD2�z�0j�B@!�S*���\Z%M�}�����	P������W\n��hR�u��n�\'J��r���������;r����k��o����M�����U�ԇֿ�}o��.	8��a]I�\r<#���vm��m#=��&�`tؠ�0����;p����Y��|}��qh=��H��8��v�T�ah	����DH:L��\r����c=+u���vl�`8�p�B\"����v;)�x��,&�*_P)��e�\ZBhۧ�兆�P��M_��j�zݴ�>�Z:Pr �|j\r�}��En��jm�f^}e���R�iӦ	��E:�av�F�ѣu���oۥx������*\r���j{	���nV���	�.R\0��ݘ�;�wQ���f:�_���l��\'Q�@\Ze��!��M�٣�i�?��ٝ�X�I��&�Է��$/�T���Rm)s/j \n�!�>���������0�	H��\"��7�\0r19@Qn�S�\Zaj�����N������3RVb7�5f���.�Ȝ�1�#�0���&����V�i��4�����8��׾�3g�������JB6LHv�D�v���.��شi��K�.�U��ȗf#�Bx�\rN߾}�h�⡋}��������ٷ�����&�a�-�#D @���i�n�$�ƅA��� ذ�\'\"���i0�	��DhQ���W�Gi��l:��F*�ȓz\Z`�v$�.Z�����ŻW����p�9@��Z�8N�-�5��4Cn�ہ6I�sD����ơ@�Rb�_у\\;דz�VdZ�ĕA�a�h;G��)h��˺WQ`�k޻��t��^֜98G��}�A�\rh����� ���ܔ��c�Kg����Ώ/���������Z{{�Šc��cժU?�ܹ�[~~�\"đ#Gά[����u����\"20Y?/���eŜz�]p4\0߳�5��%�?�rD������k��XL\\&I���;);h����\"��E\0�Fp= \nP����ӣ-j��GE\n�X$,+��B� ��+�>��Mk6dN���p��W?��C}��P�7�8w\n<����#6l�O���!�eH$���I�Hb�R6����Q�}�j�v��J:��E#o�O]uj\Z�:�S�=�%i�Ďj��J9�^(~���@H:2@\r�9^���VϠ�~�ύb3P�dw\0% �)&��ٱMJ���-��A���m��矝{��A�\n���f�N�\Z�X�7��r�==P�	[?�6{�F�XYc�\\�C�������jp\"���͑t~���2���9j�7HQ.��\0Ås��i��UDn\0�e���\n|������ul��L�y����ଧtkc\n����74mڿ�.=�xl y�J��J����H�Ib�9�2{RN�d�g�տ��\"s�f����ll�\0��q����� C�M\rl6z�k˨v�P|��E�%0.P�����\Z١S��WD�t�ޥ�^��}?�&y���d(�ي�=���Ky���\nS֗?�Y�Y��\Z-�F���v�M*�������@��ؼ����/@%��2Y���h���	�B��K��Z�/!�*pu4��\"�UIYP��i��q�Q��$��L ^��=-\n͵?*u�~9谏Y{p\r\"����U(`I�tn��k�Ϝ�X|_�vZ�a0m�Ԣ�g8�����&4���Y@4��#`LT��g͈\"\0}�z�=Nc�&ߢIC���\Z��S#kЀ�ߓ	�ˇV��\';6��u����?��܎���\"9U��(�d��������P����3+7�s�1�d�l�p>ލJMʔ.m�U��0�������k�Q��t۠!U���S�rT8`���,\Z�*�Pt	����IR9:s��0�!s��[\0���PG4�����{�\08������0��tˎ�R�r�/b�\"_t�kr�/�7�w2�N־=tM�U䙟�?M����޷f��t\Z��zh�խ�<�Ł�\'d}����c�a`��j�02��U\"=�ї*��+�$s�~���?}@���,A�>�~�J�x����8����Aפ�a�l�,61/�B� u9���i�F���������P���d�[v�5����\r��x\\�{�K�����W���m�s�=��=P��zi��>�%\0�;��,*��0� �`��\Z^A������=X��Up��#\r�b����0V��r�Ga�W|]�7Ϳr%9�+9�s�dJ4��ޘ�|R���Y����4&���g�v��A_�����ުo\n�k0ʩa%0a�[TA7�ގ�N�B*X2UhҗQ��[�~���<��h����8�H�]Ք�DGIϮ�$~,q�Qh�>����V:D���m�M�E�/��5�a��̶�m)щ;m�R��?Y.�o��Z�kE��3���R���5�����w�h�m8_K�;`��c�%�ޜ��J�uO�{	�J}���|���@x��F�-%=�H�d_>S.Kɥ¤�����ٺ!�=}��p�\\H�Df2�S��^je�ӘNm��w��$יƗ3�����vk��|ys�GO}m���(%���t�����$ԧ�cw.Z��Ob�m�ACς���Ub�\'W�@�J~��R�N�������o�85�٨z5 s�ކ��X7�nmP_��p����G��wn����R3g�������m�v�%֬�4������Ji��S�P��10M�&*�vA.��kD���\n���+�3Rn�YiS$��ǖϕ��޹�;HBP�?��))�A�/mR��QRL�u���c�	v��k���sڑo��;�~uށ����v�k�XtֻȱUN%<a`�LHY��a]��U\"��aSK���ba#�p���9�\r��P���6p�S^�������bPx�k������>�!�Eu*\\;횿g`����=W]8��\Zٛ�;�bRL�0/�(K��xL]�3�OiϺeb���*=�7�t�v*�(���>�j�ֿ6��>��:���՚!o&�5p�f�o���E�$���N���CU�w��:=c�A���jA\'\'���3����ylxt�H�����Xj9��HZƛ��\Z\'8@��������AY��Y�G0�]�JU<\"��h��1R�[�7�<I��~	)4���y��F��-�:|#�R���$��\n��>�A���Ոj����\r�\r�j^�aEoeC�¬sP��\0�;#��>-��r_ċN(��uՑ�H_�F��.p��:u|��4)�n����	�CwQʊ�cU�b���2Tt 6��xy���^�$�(���ىk��E~��C*��\"�vy(���(�ǩ����g;�z�Y��$�5X.� #\\�Tݦ�Xs�����H�_Ü\r�Bb��ȇC��q�~��{��t6#n�7+\Zb�%]�H�׮��Jq��}ѭe�/���w���\"������`���!qw�@O㊮C�S���sH,=���2��p4}��\\+<�\ZT��+;ίk�M��b/�IF?��As�<����:_ѭ�Z���v�����āR=�a�U���5=��F[�0���\'���\r�3�F=�7?���Ȣ�#꣇W�!�{53\"��G�S�ݍLi��jد���~W<�D?&j2j�<���_��c������?�3�� G	g��a�y��e4E���&����duJڼx�9m�3�Z���+��@�:�<��������W~W2/(\'�rS����fXN!K�x1�%�LdɃ6���Os��̜=J��x�T(���<�B�*��\\�mk0x�r���\r�i����\n�\r`�Q��m<f�M�o��@ ���(���(()��\n#��$\0��	%Z,A�d���/�l|���\"k��*�1�aR*���ĭ�xu�Ӥ�(ݗ���R��� ��Gv#D�^.�f\';�G��3I{�Jǉs�Gb�3����DGJ�{���(��Ѧ����θF�,*�d5<7�VVӖ���G��?t��^&xO����`��d��_��;[��J0*��a��� ���a�e�����jmF�]3��+\'�ɮ��ú\0��|�4qݺ>YN]\Z�\"����ON��V�I�Ke/����u��޿\Z�U�,���Rи�����uæH�l�%��2��i�u?<����5E������nE���~]_���U�SRk)��t�ث�J�Uem���\n��>\'&!����\\�P�M��c�:\\d�j��V��ܬ����b�\r�*�[U8p�^�i�������Ydt	�C2�^Tڐ�\r�E�1S�UM�+B�\r���ͫ��Iםq��/~\"Ҷفf9�ܯ�UD�1\rQW���E>�c��	�&x�d)�B�o�>����I4��),`�t�ł���ú#`G~�]���ǳ�ٕg%2�9�5<�0`�p�P^�X2T�xI�Y	2I$q��q¸n9)����m�J�j;��E�Xd�����\'�P���q����5�h�HK���}�P�5�(n�徃�>qBcբ�*�{��\\r\0�\'-?^�d/7!�^�O2 -.h�+X����k�7֤)b\Z��Þ�J��GՕ��k&](��E�)_Y���Km���WسntN��۠I�̭�y�0��\n(+��ZS?F儮-b��em+�b��\n廣��@�^y��	w^�I�\'��,C\"kP�<�\ZZP�CF��:��Ê7��T�#QT�Z�m��_���w��J��S1&����5n�����op-(,�b��0�ui#=�ѫL��r��N&3Mi�4�Q�d��Z4B4����\n,�Xx������Uj֠��l)MX����A$Ɠ9\'t�|0���T��W�n/m*��ڐ�U�n��O6oB�b+mw����(?P���\Z���ҩ��A�������Ga��!N&��1��>���;[��1��~��@VWc��A�x&5�J�s���n3|6��a$xV�F�:@���գ���Y鳌�h�s�V��X�2��|�X�痵q礎�α�$�Z�saJC������%E�.��\Z/�	g��j���X��3x	�oA�Z��ㄐsE����G�2��l�4�.�QX�\n�5 %�dV}�hH�s��+��-XaTX0�\ry1��HvE%��O���=�<sn�a�6c��#S��ր!J�0;��	���v\'�);fn\r����5���Oi���\'��7��K�Zm,������a 倡dx��/{��W��T��`|�)�0i�%~�~Tk�[紹܇���������x�0�60�i[V����\Z�r��G%h\Z�N��D���D�#ؠ\0��yj\"_�և2�ͮo�[�q���2|���X�AZ�d�hr�/E�>\"N�7�\\�6TX��vh��-���w�q�<I*�xD{���$)�r��\'�|d@�!�xl��An�8D�5�����i�����A����d#��Gm��V���v��V���~jߑ�qp��x��N�*@�|2�ۭ��<�(��+�=5by$����ő`�r6�a`�;�/�\\��8�v*PjK�A��ׄ�	s�k\'�\r�Q��i�!o0�0\n�^�ٻ�؈%4�)����Tǣ��S�X�J� �����wI%2ð��^�Z\rt�\Z�|#Ɖ.o�-��j��Q�w�\0y��C�!\Z\rJ����`��&�kt��\"z�g�SI�`���P$x�&&#��S��ǹe�-o����A<�/�vr\Z���%��IN2��x�9�<���E�n���\"�u���jK�U:>��)TzP�ӝ�f��&��E[�0�]#��\'\rL�d��|`(��\'O����`�T1�+`�����v)��9���E�>>4�ߠ��L��ae>�QYRL���G��_��ֹ9u�>D���\"ƕ#A�	��h��\'X�e��R�t-�Kt�Z�V7@��Rh_Tm�s��wOd����xm�>ݴ}%�,�\"?������|m��Q��=��Ynڥoo�Ѣ\0\0 \0IDAT.�}U@-�� ��3�FLj��j�ٸ.���E��������&��{�{`>�6~:&Ltg������%艫Z���Z��e�S^.�H����p���zjǦޮV�����b��G/�j8����Fe�\"�W�\r�{61�Y��]������6�d@ƶx{L��yڟ�S��J�u �1���[���0��*>�~��A����g\n_(Y�\'I79��ˠ�+���ɣ�����=���U�a`��`r�h�I\"n�z<\rQ\0��\\���\Z(�-����a�N��\0�r��(��1���F�6L\\��-#4��\\A�yg�ܖ=����Z=8FV\0�K0P6}=��xһ�~�\"��sa�k)����t7�>W.%��@�e�\n�/���������{=4���)�-Ih��\Z�1On�$\'�Z��#SxO7ҙ�@��Hp5� \r���k?��u���Dn=����V�Dz3dj���\r0Q��{0ŏ�{λq��X�5�b�\\\n�A�J�K!P�t�p���r�g��,��J���j\0<�Z.�K��\"�-�����0��,M���i���+0\r2����O������\Z���ضl�7�f���{>�P͛H3b\"ښ���^��?�c>�/&���$�#����qz\ZҼ����M\"�+ұ��6�D�4��TR���܇v�\"BO��s�Z�wă����,�q����M�B$:j����g-:��F�;�܉�z��n��Gr�K2��\0�I���[��!8�(DמNiݬQ�y�G[v�;Z7��=�A�T|2.��Ϟ��a@�`e}��r??ở������������2��h�%�ݸVZ����4��� `5L�0��Q-�`2�ВA�ճ��vJ��T������HT짬w\'^�3���;�5�|N 0F�@0�\'��z�K��;����J:뾊ږ��=B��7$Y`XxaE��d��ߤk�G�}Vxr���?�������_Ef-j�+ո����O�Luf�I��Hf�	�\n�1,�@R�E�`�#S60�.~##4 !��r��z���|G�����J����Gc�29���M��Hu�9�qM�KR�<{�94y�ռ����[�AJE�R����P��+J��F��O�/�=�����b�?���U�Q���i�+Y�����V2ێ�7�,��~)�C6H�eC�a��\r���\0Y������SԨ(���������:*ӭ�dҎ(9�ȉ�z0�I/�r�ҝ��,J����?������\"?Kᆎ�8\Zf��+ �/��DQm�HR�J!�ك�e��f\r0�J\n�ց+)�����J`<�h���~�$��_;Fهp蚍�� �Q�cq��y���wO}>}mnݔN���1��a������>G@.�]�{����	d`=ω�\n�c8O�\r�(�a`�͆�\0BfS.h.�8���$�\Z.�Go�;Zը�p��Y!��<*z��6]�s�g��p����OR��f�R�C����{JDA��9C�n�7p���( / 9U�7�f��HB�J띩=D�Frkkȥdu^7x���є��G�����b�J0c��������\\�#70!\'#��h6�OF0���)��^���ZK�����k�(�D����p�x�2\"Ԡ*%d ��+��Tئ՞�kqd�)��9B��d���k�3�\':B��P��a��=����?�Ln� T7M3r�[1;^D?��L/����X�H�\Z��y��ȋv����Ʌ��3�d�S��7�\'Z݋��\n��Ɩ��5����Z/ܹ9c\'|�(��m��5ݥU9�����p�� ���z1{zש�$wC���c����Q�P�\r�R#26w��дB]ByM?��s����if�� ����������iV��Zt����7�q��qU���z8g\0�uQ4��9���u+\\���_g�S�G��SB�w�+}�Qo��F��(�\Z���\'6b���]�p�j8�ͨ�\\���j�]��O��	ʉ�3S\ZF0��r��\\���U�9��\\a{�#?	�C��)�m�P���E�a� �j4\n:�(�P�۞���̻C�2~����$f�Z�I�6����E����v{�66\"l\\�Oa4J��j����\'��\r������䇁EK��\0���q\\��h���\\��.C��7�c`���}������i�dF�)�o���u۩\0�4���I]���)���ች^�Wd�5J$��B�L���]B�QWS�W^MS��Q��r���\Z�(Ap�5%e�3!Jʇ�]ñ���P����?��p7�q��#�\nr�JFqrE(\\�e�\'xG9a�$z�5\r.�\Z:;�6jխY�y�7G��G���,���-~T�^ر��F4��V��.Q�����{��_̅�!`�y��C��w�\Z+�u}���r�yu	�u�Y��l�u�V�����\n����}������閰���O��9��͆�Ya��+��QQ=\r��n]#�p�=����K	~t����y?o�/�f_:����[���	��A)ר9Qb�#xZL�1-j�����y/.�|��mad>�y�\r�d�w������R���Q�;��~�:�|t`4B�\n�I?��S�Ii�~�\"40��n�\Z9Z�a�(\n����6k��Û����۬��p�X,TS�\'��� yｆ���	��<���1����_{�ߦq0����D�;���K<t�EJ���c?�ۭ�oS�T����n��j<0�lW��\'^R�����M�&�*�k?&�\"�9��n���M$+\"�PB�_���-Lć���ڷ�@�$�}��C^E�Mh�s>� 7�E�k%��[�n�1����!���-�Qk7�Lt&�^&T\r4����Vw�w�չ#<E0�nXs�����Y���[%�}�tIݬ���1p�f��R��fa�L���A$l��C�jא�c�����W[���ur�j)=jD�%z<=����]����2v�\\]���v��>�\'tG\\Ȝ	^���rvl�zi�Xb���`H	�fld?����+���A):�hbe��#��d>u����JD�J b0�po�$�<�f��\"��e�Bd*�LPE��6�mU30Y��Y�P{k�BH?~��>�<�`v�6�<޽�j�g�-��RA�@_Uq�D)8�{��������m/@�����\"��Q�����GHH��^�yK�fz܊|��/�}����X���\0/\n��s�?�5�:�E���͠�9���	���� v}bo�t�x#�m� �b||\"�TF\0G<]9L��;1�+���7`�lPFZi��Jz��,�����FG]��?Ա���^���ܱ��&++}���)*d-;��dV����Ւ�p�My��U\'og\"o��*+t�����8u�Hs;�����P[�{����_���{~ߞT�#��\\����c�>��\\�6��	z,cgZ+h\0�(��I<ֱ]�����ԛ�_���1;�6,��\n���f�ߘ��U�ȺH���H����TF3QГ�j];��9������NA	\'�dw��Y#\"���^���rr�J�w\"6p�r��U�N?���D�7P��^#ʡ*�`̷M��������In�<P����l���q�i���g�g_ϻ�\rP�\Z�N���ҵ	5\\������_]-\n�;a��Ǝ@�N��#��2c�����א7&u��(�N%&d�#�����T�_�J����07�Ј��&2%��6�(�ߧ!�K�I�X�<�|iR2��Z)X�=Z:��Nc�=\r�iD}x��*�0T>c��F�L��E��ww#���|�}����\"py����e������PM$\rN�ꊡ�Z�Ie��_�1H��.�%�����K2�r�	~�Vw��:�*�	*��[���K���S��~�ԒsN�yiofj������Z���1�ڸE�CF�\ZRdiF\0+x�3=ܺ��������Byk�a���kYK����j�j��B����i䢴H�0���ӷ�)~�鲁\"a�+G븆�����4���8*����L�Ѐ��.�I8�!�L��2�jf��S�Ul`��F��P��\"x��H8� ����mX����}(�8 2�=w�0e�$Ŝ���IW݀	6s��\"60{����ˁKЂ�w�4vdұ؎����{���֔���~�� X��D�\r�̤�\"60����aj�!j�%G�@>\"�u_Ϩ����/�k�~��Ӥ�&a@��,\"�r�	��DXZʵӱ��)q����^�A�r�>��q4���Q���[R�>��\"˱�`Su������RD#hޥ!��f��\nH�~#��n�R�C�lU�emAR��&]�n~3�n\"�������G�F�6�=�Y_ o�Z#\0���y\r�z��q��<\n�\\�1��(�R���I��,3w�#��C�js-�\r�_n�dz�}�����|hL���	��<�\r�d�Y���PD>���z[��ѵc�O����\rD�q�>�7D�7kɔ�^������Hi ��i\0��p�p0��7�\r4�Q}�����#�P~*����o�»w�&�#v��PG�f�G��i׈Ĭ]�@H��z=N�� y#50�`�@0*�rA�q�^�h���?d��R��b���?Vx�Wb���	.�d+����)��3��N70���<*�@��+U٢��6�+��`Xy�Ef`�ڶ`��u��Ɉ6��b7z@�Q#.�p`�g)�j��[ajl+=����	���.o֋�6���2��dC��2!	�{�\'�4�`1�^P@��\rF\Z~#g˲��r7�P����t�c����@���@L�v��v��)C<\\�(Ǯ�6O���.W�վ�`�vޑf��=�l2��mJW�hg�p]�Vi���1@%��3tf}]�.��[���<���r�����Z��h�}����HK�������E�.�H��aX��qS���}�Ͼ���օ~nj�OC�,9����!/,!�C�<dIA]��~}ax�ϫ��[+Q�E�\"��]$�-V�&\'��z��E\r������3V#�Q�8>����)��h��5�M-sV�\Z�\na	!h	���(��37�:�8Ec|i�\0I@�n.�*\"�/�\Z}z��S�/I(�!tԇS��%�5KZ�񸑕��v��.W!��/S��#��1����6�K�XCH��\"����\Z�XԂRb�\0���\r�G\ro�\\$Y�*�dg��!Y+x�n�\'% ���z%��?aX�f`���\'�D%o�\n)sw3c�R\'�_04�Y�p,lbBpY0n]>�����>�Q/�6����I����Q3sLr��wW�p���[���4q��xl&E5�WԎbj?a�-F������@ʲ\\�s[�ܫ%�[B�2De�q˿VD�����>��Oq���,��+��Z��s:��6����E�ͣc\"���3\0q��Fp�P��SLMb\0�%o�淦�j^�1~��b\'�i�B�\n2 S�\n���/��FSݺ�Aj�9K���\r�0y�x����e:8Z��4�{j�-�U�����U\".x��޹��{yO���\"!kG�8p^�*�����bn{2\"�u0����0�Yg53?\'E\"7N.��cS2�g�!ʫj��<H����Ђヴ�3�ɝK�\\0��ި��ߓ��)��\ZB�R���?�B��c�(ѓ�H\r�@���b60��He})<����|J���C�v��Pmk�^�pVW���5���Dl�dQ���Z<Nh2��wی�okߌ�	 ˰b�O��H$����1�-���a�\Z�:��_0˒s�4^bg��~$O����zKKI�t^C�iu�n3��6o�&���\r0���V�Sӑ�ڽ	qb���g.�9X��~�K^��n*����P6cr�H�-%N�uN?�f+N���/%C�I\r�h�Uy�i��f\\�\"R��i}�pn��T�&\0H<�?0�dфD��u�|=c`�H�M���Џ�\Z��~��0�T�wr\"��l�I�2\0Ll�-_N��<�T\\�Ѻ&�~����U y/�����\r\".k�I#��+\n]��A(y�Gf`f\r��?��KL��&���@�\0Un��S��$<�9�5�CE��\rT�^�g�Yz0�����s�\"_��p��iG�mՄ��\"v�5����s#��&�k��]Є4�a�;v0R�Mrm\\!���##P ��D�3�����a��I�.#Գ��܇p�O���h�l��C����^e�[�sL�����)$�Bi4Y�~��́Y�.o߆B��3�m���w�H����H&M��E��\\�W�0|��E��Ա�9�Z���y�]�SU~Vh�y�w@C�!S�A���WQ��ߒ��xY:]v<��:�)J@a.�允�#�ۄ��];6����U9��׾��_�`�*	��A4?���Ȗ�Y@W�3y���y9�Qo�`}w�n�9g�%���%�@d.����\\�ǈR����bovv��G�8;�w]��b����; ����`���\rG�X�C��Qb�\r�f���.o��B��{��p$��_�\"pU1��fҞ�����}s\"�\\����3y��z ����VRu�q,y�Rl�U�Qf`�IȢV�+�����S%�o2�=\n���THq8�Pu�7�VH���νs��)K�\\Mj�qU0w��j]r�L@D�;���͌�]|�rO~��}��mA�I v���B�}y7�S����!q��/��|�R@h&BO���y�̻�8��V?!RA&���[,�Mchѥ*�<�����+���x�l���\n:��2Ec�x�]����{��%��!�ޅ	��y%�6Д�䱘�Ӵ/U����Z�t�s�Sn4/\\��w�4�К\ZҰQ�^DU���s��������@�d\rh�#��\Z�ޭ~<u�ȳϿ���֟�����*[������J���CF�Al����xE����x���+;����tp�#>�4�{�;D�F]��Ʉ��9a`� UH60�6&2s��H����I^�7S���ߒ�oc;�	X�ʆ���%,�.D^�^RS�d�щb�u�e���\n��\"�Q��)�!uP�`�䥑#��c�(�[����\rU�?e�Cj���TɚT�z���g���xR@�\'�A\n���������)<R�?#s�p�H��8����~�VөxKU���T\060rU/en�l�x�q0�������)��I?�H��\\��՞�\\�.���T`A	-ߎ��g?�߷��0cLT\\d�\\\"t Į�\'��Wh�n�|�g��	���l�7X���SmC��xW��C4h˛Բ\0\\ѤOHW�̽����Q�j�i�J�$t{E�؍�%U���;�%B�(�ѭ���w3�8�Cj��֭��\n�p�~x�k$�Py�F�!/��Fueu���w�8��{�T��+10�}%bCYT������ǁ\'n�G��/\\$*\n��<$o��v�E�K\\>�����\"���~�wT�Z��=�y�e2C,R\'��Ћ�}*��AH��\nRY�G��f?t3R,P҆�XiQΣ\0�^r��C�����5J�������{i�a�z\Z�>P�������\'e,u��	�8��X���ǘ��5�P��^*t�O$�U<:�G0Hk۷���KY�6K=P�z\0��jP��K�K^rz?�\n\\���\\\Z���)#i�\0��Ns�s���i�\\Z�u$��4�5\"�c�>�b�=�T&ή�:�|.��m�\0��֘���s�#yYj�������#���!M*~i����k\ZH���U���n�Ἂ��,d	�QꟋ���3���²v�^���cT+*���4��T�?�w��b|���o�^�)5VB$�Z~f6v�Q�[3\n�6�;{b�8�PpjE���FD.s\ZF�e�\\�/l�N�RF�:��*��K+ΒV��Z���/��fߴ�\"$����,oB�N\n�11-*�T���w L��$ ��ɹ>�q�hR�n�ByN��<�/��WKP0�\0�`���\Z��p����Zw�:�Q�����n�;��-�5��d�k\n4���)�\\��S!�Qtww�6X�a\0ռ�#ܝ����=\0\0 \0IDAT�)��%Q��L2���R�b%��(��)�X�t�&��DS%���:���W6V��	�Ҍ����SV+n�����\n��3�##v@GX6�Ռ��pp����/\r`�%�8�V�@\0��k��\0{\n�HqQ��ri@��L�����Ch�ą�����|/�t�л�b���.�Ww>��ߐ���p�!�1�/�F�ZmI�\';������Z j��@��T(��;�i���1�D�>S$�����?g�[�5�{�,9��\\��a�qʽr�Iް�`-��c#��N�9C�|���DW�cI\r\r��wQ�F�]�7�\n������r���گU4}0��3>���k�`��ڄ�lX}�p�6����`\"40��`d	E����w!�������D9\Z�)���$yı]C2?�A򶟀d E�*��>��RIӮTm��zI��u��{�#I$iP(��u\\�������Jj�R���E��1\\��Ҋ��x���{��R 5 \Z�l��\Z���h\nH�+�\"���\\c:)��IT6LX��熕��\'��ǻ�����/�3�^EZh�B�1Ɋ��\r��Eq\n�]����B�6��M��ԭ�R\Z�\nŻ�@1F���eQ-�/Cq,�n�_��۽���!T�~��:���H&NU�q,�{Fmɣi%����)ՠ�%����Q-e-�v���֭G��ˑ9\r�ȏp�U�J���v=ߡs�[�6^��w�\n�Ŕ��T�x��kt������{c^��`#�d�~��L��[��l`x�J�C�Ia9�\"�v\\��M��6Ϋ8wJ)\ZL�{V�Ǽ�f�;k�6��P��)g|����DT�Ҡ�?�\"!�Sڱ���fA=�H�7aj�`�:܂��4.�����R�r��1׈d�A�A	.a�`.�fz�A��f �=���<2����<���\Z�T��A�5 �主\'#$@0�%!:���{��+��o���>Z����Oɋg�b�`\\����>������E�A�J����yÃP�M�-Tij���~��>����;�\0���W(�����ڦ����P�1f�ނ�m�ƺ�dE��&�V=	d)���Dsa��g�!d2������@����)����m�^���0�JG��\n\r�G�jT\r���zjw�	�6��>�O\nd�ɔ��M�-a1�>����s���uN�{^Z��}cR����\Z4K�*%8s��w�8a`�뉭��wƸ���tk��͈<1���7ҧ�pBI#V���Q��b�Ly�?f�yo�x8����6�3���@6u��\'L!b��� �ףY���xF�V���\r�l3�M-���~\\��ᷟ�b�p��@���@16�U�C�Ǟ[u��N�{���/b�\Z�P�-���.�V�&o�`��?p�+P�^.�&9�p�����=�}�M�^+z~��R�t�8ʎF�%��V�G[R��S)w�8ҹ�sBd��XD�\n)S���eT�>���*���޼`s}��}��j!���[E�\0��V�\n���h�m)�\\�[���pC���\\���R�����C�\"�E�.�~�yn:�@�\"�~��]�C5��Kt�����ۘ����[�1i�n���u�ژ�<�*��I�J��z�c[=��~�C\0����\"\r}��Ҕ���z��b��DS)˦>i`�<+r�u�n�Q�p�}\'�4��ʃ�Y8D�s�%�,(�s�^��\Z��^5kQj�3�\0�<�=i\"A:Ny���}wռW��Im�=N[�B0��_\'b����/�y�1��	��p��p�0��¹H\\�f�7K\Z:fj�yI��u;��~n��lY�Bj5R ��#Ltji[Luj�`�y������VSDZD�$,`~��%rO~.%��Js}���?����$\r�2~�j�����]25|k[��f~�o�A	�w�^������z]�G�\n�=����;��/��6�,H��r�7��.x.�#�t�m/j���p��sU�˳G83Ra��	$Ҙ1���6|ȅ�X�+\Z~f\\��S�ay��٢�t��_��k{��j!b�>\Z�.�>���Kf`�݅G&�����r�wFx!B�M	<oM���^��d[��t�����fV�����m�L����=�K�~�8��$P��\'�v�{p��\\d�[��S��~���\Z;W찡�3��eѤ�\rLxo!�h�݂��YݭG������kxUM�J�?�{W��d_P�#���Nm�ͥ���\"e�����1���_00\n�`L�*�g��w��\0��=8h<�5���T0gÄ�n���u��.�\ZТ�˰k���J~pV��2����/�\n����؂Fy{*�������j����,�B�t:���/!f?�:� L��ܚ���9�=r�Y�-�w�~\nɍpQ\"���>�Os�K�oD�s��R��=\"�w��>���E;p�h�N3�@U�P\"%��I�.�G���?{���NȤe�\"��r��<&����� /\Z#�!��<���7�J�P	���_@6NQ�#��[5%t�ͻ�\'J�9�?\rت�-o����_K7��R2ª:���Y���<i��A\Zݻ��:�aC�^��6YW�63��ێ,��nU�^}cU���QC��\\F5r�a�xO�O��ϋ#�X\Z�.6e٤S.����>���)���9��-�l�a\Z^T�C�,�l3v}Y���)���+���_�xq�̘���{suvj+��d,z�{��.�jȈ�շ67��>�0ud�H�s���5��X��2�ʉH���``��pAq~�La��Wc�Z%��E]b@�KLt]�(Hލ��p�������ύ���c��A�?\\M\"W�j��+���ss�N��(�����S�����#P\\���T��n�Q�_?g��l�Ů�wP=�g$���Ġ���yP�TC�S^�+;��9�Q�v�(z5�j �\r�����E�b�Ss�1�-�\"�1|�s��\Z�;{�#}t�?�h�>7+;Y�j����c�)�(�Ŝ}��`e�͖JI;�R��[kGDJ��>\\}(�	�������]�D��7�嗯��t�����7(Q�\'3�G��^5�~��5r[���w�u]��|찶?t=S�����aO	�2�q�R7��H�\"����p�\"ߋԂe�Fm�̓�d��/��\0��.ɒ��n�KXF���[`�5���Ǻo��C���w�E��7���).R�9�Г׋��mr����OP�(��	i��\"S�C�+m�����0g,�,�`�q���+/8�ט+D�ң�����@���� �#@�-{S�i��c<��*�?�B}*�`��]7&:�v������O��r=�Mc��JW>�.�d>Y�Vk���*�8�<|d���ǽiI\n�T��B�z1��9�`�X}�S��b�lԁZ<��sPY��\Zi���3�cu��,�����4R�ݩ؊���q*���oI���T���&���32l`���VJ�Q�[�B�	C2�ǁ47�&t((����� �ZL�/W=���-;��=J]�=�{8I�Ѳ<����[�@9䠤��˯@>��Ek\\�;LV��U9?z��}L�y�>z���5xΊ�+�:g�}pI>:s���\\5鳥�r�*�F~\'��ī�r��ի�Θ��{WGc+M��Q�3�{T��|_$�(��pvy�5f����!\'��>���=�_=y#̖�F ԫ,r���E����H�\"�H\n�\")��#w�,��D�j����&o�O�.\r͟6u��jQD��&��K�?��y�˧?[��v�?�myOi {\'B�:��&Ɖ=�r���wN��jnShLoH��7���N�G�e}�,E��T(�n�a�lw6���\r�g�+��-�s�x��K�==�����F�ʏ\n\"��i�n��4�z2��:�ʞ[Wٵ�O���P��3J�5\0+\0�aߧ�@4��}A��f�+�;ɠL�Sv�\n�Ǔ{C��Y�iݿ�%�OF\Z�=+�G��e���Z��D�M\"��\"K�Ξ@*\Z��D\Z�בh�87�%-~�M��v����O,���3�&[��H�@z��A��P	�L6�����作�b[����㲡��oK�C1�{�b��Ԡv��ߺSW��k���9U�0V�h����_t!��\Z:|,]�X=f��a��Tc�qTYO.����[1U���L�����/�TW��9�eG���D�)}ɹ��g���y�����O[�:Sosh��\"��H<F1������#̦.�3L�QF�|&�q]_l�A��&o��ۿ��a����H\r�J@?a�!�)\0y���U��mK�mo�m^<Pk�JT�_cA=`�Q 0�S\n�9�|�s,��F�F�A�;i��P�͆\Z��\r`��,X�ȅ�r���;��zO���TV?�8J���H1��uMF҅��;]G��OU�j�����������6~MA�U�=�`�0djlw[��V����9�����Cs|�@o�#�Rd�\"&Dh8..��I³���ຸA�W��)Th�%WO��%0��Q@�(})�~o��l0����,ٯ\r����E��9�M�{0����[�����qT��,�r&-oN��[�}\nȰ�ۥ\\�����軟�.+\n\0a0!d�8�n�����Q}�<Q�%�n�_z~T8��f��ާ��q��\0��)��V\0õD��hE	�-�e���h��F�/�Z�?�����{�[��m\\rf��L�\n��!#G<yWG�\nDn`�`4����:�}�τґ.�Lp�x[T��9��7�;�G����X�X�\rm(\0�� j�h�G�\0)3����f�>�D�9��]�\r���\'8l㫁4ԓ\0�[<�2\n`wH���,V�+�9x�ބ��1�%�x�Byc�r�S�����3ƪw���h�0�ܨG�Z�@.�Ci��@2�x�=���ݝ���ġM��=ԯ~�1O4h���Z�����%���ʎJ\'�%�9��. �.�y��;��H@�3<\r�A�˰���Ta&��4��Q�R頢>�%V�#�d\"K��6�o`���{r_�ȧU�g�!�\Z�2������B���u�Q�\r��L��%���ƫ?� {X�j1H40�F)�E9����j��ױ�\"\\�(�:E2^ �����̍�kw<9�5��\Z�F�i�]x�&,�Ɍ�|��C_������*T���04�q�*��ξVc�+�N�������C�.�/x�b4\n_��u3����b�a��\rW4���N�\'��P�4I��{w�b�����+�p��ޘE�;3¶gʭ\")k+i��e�L(�$����I�E��xD���g�%�8L6R����YD��@0�M�8j���L��b.���\0��*&^mٴ#�5uxg���V�f�ݽp&���\"��5���煄�N���}�xw���r��]H@ޜ��<J=���}�j;󽈢}��G���t�Q�!�\n� ��T0�Q�^��>��|;_ۢ1\"��Z���c[b$gbʺ�b�J)P�%���j��	��[!4�ǆ�A�O\'v�Nz<���Fp5�j-���:��*ӈ�q·,h����������1��=�Vz�+6%��6��x,�6$I���1�.����?9������l��;�{�$$P��K\'\0,��,Þ�8J&ג��C��d�T��]B=�X��)c��#Ϩ��q���;���:�FE���}9����?6Z��O{Q]�LTc�� ��g���K\r/�5%�+{u�k��g��=Ģ����\n��vD�_f�=.��\r�hJH�y�7�ld\"��|�2˥8�ɺ�R��(��\n���O-����޵\0GU��sw7�Ȓ�&$�\0��D�b����U (\"C�gTb�\n/+�Ѵ�e��X��C�`+����<K�%���tI�d����q��w��@ ��#rv��޻�~{�����`G7巸�?~2�[�,^���f���#V9����)�浫s�p6O<�O�ED���K^9ww=�LN}�m���o��w�p���]�~+�b��W]�khIF�`����������w�wm9ݰ���h�Y}<2�(�\nSvr< ��9l�A��\\n\Z����ό#��cz��<�PKif2ɧ��;�%������߰��u��ى)���r|����qH����?��,�{��f������\r�:�ft�-gI9W4m����b)O��Ql�vO#��ȅ*)}�N>ͅ�g%�@��Ax���g������~`��Qm�P&h��s����=hbW������{����g����ƈ�-��R���l��v���z>m�?���56���������=������C�,�(���ʾ��s�:֗�痿��N�>�����藳�`F��y̐�6Fp:s���SON���S���ō�cE��z�Y47k0�6\"?\Z�I`O�����W�8\"i����>D�$�d�U�6��/������v�����%Sx�g(dZM���] ��ZR�8ee�\n���y�Ϟb��Y��=��̥r�Ԃ����>Z��aj#Đ��P����� �]�%�����z�t$\'\'����\\�I��#�V��6��H��1@����ޝ��&�� at��.H��*��=ǂ�Ήפ���z+��IY,	�j\Z4�9�g\r�9:\\:��_ȴ�<�ŽD˼m~.��T��]��}ZX�z=2��T�MlЦ��Ufx�Ph�h7�@>>�� %��S򁔩RX��\\)0ᯢX��`���0�M)��)��T�Dw�L�Bwz��BY�M8����4��@��e ����.�l�����R8<�?�H��ӡ�+�ӕ}��m�S^Y?����2���	aj��iw�m��Q�ʮ�V���ͫ�����X|�^���7*�4e��v�����~�O�C� -8H��x0-��+[F����qv�Jr��x,�p�D���p]K?��\ZѲ_���n���[�oӗ�aI6:	ը�aV����\nv��Lf��e�w�S�J��u^�xw}�7��T�.�{��4�!�Lc��Z\'��^�N롲u�2 S�<\"�putiЛ�\\b!|��װ�����v��t7���3�} l��gHS/��~�n��P�ؓ�s�۵h�ր��BC*����u�_L���T_�L�B�\"1�݌<y�R��9��M�{������T���)V�l�|��7Э�0��5�5T��5�k�A��W�偒�\\Ag�i<o��:t���C~;?]*0�Ʋ4|1�x�����\r\"a�*Z�u\r_%�F�>f��bw�X��x�s��H��攈t�VM,�lX���Yŵ�\0�%�ˠ��1AjX�V���!�lD�W�)���O���+���=�����\\��m��~+�Z���~�H�\ZwM;�3�h��(h\Z�>��p�d,_�A�&c#������$�Fh��.�.c���wUT��q�l��Eo�\Z�\Z h������d`.#5�H�!��Rp\n\'#k�x���䩍[剴C��@@ p�\\`\"ǭ>�(�8��u2��8��9��]�P�8������U����&A�D\rcZb����F�-�d�ػ� 4��D�2���E�=5��CPc�l#a����dm���*B�\n�K�I+�E\rq�	W��e?>��{6�ys�&��H���t	v�Rѩw�YFas��\0��2L�h�*�b�۲2)˘�C������@ԭE:!|f�T\\W+�v��\r����R�R��fJ^R�]!�w��<�1mSTq7�@@ p��U,�O.�G1\n\0؞�z�H��׊��U#\0MK��l�v��=ؐ�\n�9�!Х���x?4�V{�M���#��\"�����2����u]��d=j��|�J��<0�z}�&�\'Fq0��@@A �on۩���w�J��pa�\\�ȕ��	��U��,C\"W4�nH�G2�ii��xH\\Gy<�idZ)0tE~F6��ָq�T�u�Iu�D���T΅��T���3~����\ZuĽ%t��^�q����RN�Th)BP��Rs؝��g��T.��Ƈ\\���՟���ؕ�lI\ru�Ҩ\r\'�]W#\ra��CLG|�E�~0ߚ*��.NMص�+0\r�qd���\0:��wr�i��~H�\0\0\0[IDAT4�F�(�@������<3�U���P�7|l�b1�E��\"]���tΔD �g�W����M���{YvQ�2Ќ�j��i��\nUH��D>4��p�摲�Ij0$�}�������b�}C�;��k�%�GZ�2!S����qpNԯ��?��S ��C ���<�t�A��� �Yq0\'�b�\r��*R�D�E��)�ZY�V�/D���yf��o���	` b4R4�(8F7pb�ǀ/A����fh>�2M�zv�:R�Kù�m�x��90w�F���U��a���w�W$h?Q/0�~��ԯ����Eؖ&h��\rk?d�\\��tG��h:D�ETd�\0���r�������K�Y�v/+��0\'�Ŵ@)\')s�M��W�4ko�ߙ�{��\0eF:`��!;Pc�$��0~̊�?��)�N�a[\n�@�Gݾmq�?� c4#�qK�;�C�W\\���T��~$G.�ڥ\0l\0�\"B�E�8�!2g@Q\"���}f\"���\Z�M�y��������ܿ��ك�(�����05n�@|��k��3j�-!D�n/0�ӽT�:O�׺�Y}�[vvi��<��d�h�s����A$y���l`#��ݸ����������hw0�uU�\rL���D��<=G��޵���8����	7C�+0�������n�Ql��|�!��N\r�]�LV�X�&IV���ˉq���xh�TG��Î8��\"I�4����$�:������vD����|&����#��E��Jj�+5IY�:w�b/��@�;�%\nLw �-t��t�����Q`n�[@\0 �>D��>lő�=�	������\0\0\0\0IEND�B`�',1,'2015-05-19 19:19:32');
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
INSERT INTO `provincia` VALUES (1,'Bagua',1),(2,'Bongará',1),(3,'Condorcanqui',1),(4,'Chachapoyas',1),(5,'Luya',1),(6,'Rodríguez de Mendoza',1),(7,'Utcubamba',1),(8,'Aija',2),(9,'Antonio Raymondi',2),(10,'Asunció',2),(11,'Bolognesi',2),(12,'Casma',2),(13,'Carhuaz',2),(14,'Carlos Fitzcarrald',2),(15,'Corongo',2),(16,'Huaraz',2),(17,'Huari',2),(18,'Huarmey',2),(19,'Huaylas',2),(20,'Mariscal Luzuriaga',2),(21,'Ocros',2),(22,'Pallasca',2),(23,'Pomabamba',2),(24,'Recuay',2),(25,'Santa',2),(26,'Sihuas',2),(27,'Yungay',2),(28,'Abancay',3),(29,'Andahuaylas',3),(30,'Antabamba',3),(31,'Aymaraes',3),(32,'Cotabambas',3),(33,'Chincheros',3),(34,'Grau',3),(35,'Arequipa',4),(36,'Caylloma',4),(37,'Camaná',4),(38,'Caravelí',4),(39,'Castilla',4),(40,'Condesuyos',4),(41,'Islay',4),(42,'La Unió',4),(43,'Cangallo',5),(44,'Huamanga',5),(45,'Huanca Sancos',5),(46,'Huanta',5),(47,'La Mar',5),(48,'Lucanas',5),(49,'Parinacochas',5),(50,'Paucar del SaraSara',5),(51,'Sucre',5),(52,'Víctor Fajardo',5),(53,'Vilcashuamá',5),(54,'Cajabamba',6),(55,'Cajamarca',6),(56,'Celendí',6),(57,'Contumazá',6),(58,'Cutervo',6),(59,'Chota',6),(60,'Hualgayoc',6),(61,'Jaé',6),(62,'San Ignacio',6),(63,'San Marcos',6),(64,'San Miguel',6),(65,'San Pablo',6),(66,'Santa Cruz',6),(67,'Acomayo',7),(68,'Anta',7),(69,'Calca',7),(70,'Canas',7),(71,'Canchis',7),(72,'Cuzco',7),(73,'Chumbivilca',7),(74,'Espinar',7),(75,'La Convenció',7),(76,'Paruro',7),(77,'Paucartambo',7),(78,'Quispicanchis',7),(79,'Urubamba',7),(80,'Acobamba',8),(81,'Angaraes',8),(82,'Castrovirreyna',8),(83,'Churcampa',8),(84,'Huancavelica',8),(85,'Huaytará',8),(86,'Tayacaja',8),(87,'Ambo',9),(88,'Dos de Mayo',9),(89,'Huacaybamba',9),(90,'Huamalíes',9),(91,'Huánuco',9),(92,'Leoncio Prado',9),(93,'Maraño',9),(94,'Pachitea',9),(95,'Puerto Inca',9),(96,'Yarowilca',9),(97,'Lauricocha',9),(98,'Chincha',10),(99,'Ica',10),(100,'Nazca',10),(101,'Palpa',10),(102,'Pisco',10),(103,'Concepció',11),(104,'Chanchamayo',11),(105,'Chupaca',11),(106,'Huancayo',11),(107,'Jauja',11),(108,'Juní',11),(109,'Satipo',11),(110,'Tarma',11),(111,'Yauli',11),(112,'Ascope',12),(113,'Bolívar',12),(114,'Chepé',12),(115,'Gran Chimú',12),(116,'Julcá',12),(117,'Otuzco',12),(118,'Pacasmayo',12),(119,'Pataz',12),(120,'Sánchez Carrió',12),(121,'Santiago de Chuco',12),(122,'Trujillo',12),(123,'Virú',12),(124,'Chiclayo',13),(125,'Ferreñafe',13),(126,'Lambayeque',13),(127,'Barranca',14),(128,'Cajatambo',14),(129,'Canta',14),(130,'Cañete',14),(131,'Huaral',14),(132,'Huarochirí',14),(133,'Huaura',14),(134,'Lima',14),(135,'Oyó',14),(136,'Yauyos',14),(137,'Prov. Const. Callao',15),(138,'Alto Amazonas',16),(139,'Loreto',16),(140,'Mariscal Castilla',16),(141,'Maynas',16),(142,'Requena',16),(143,'Ucayali',16),(144,'Manu',17),(145,'Tahuamanu',17),(146,'Tambopata',17),(147,'Ilo',18),(148,'Mariscal Nieto',18),(149,'Sánchez Cerro',18),(150,'Daniel Alcides Carrió',19),(151,'Oxapampa',19),(152,'Pasco',19),(153,'Ayabaca',20),(154,'Huancabamba',20),(155,'Morropó',20),(156,'Paita',20),(157,'Piura',20),(158,'Sechura',20),(159,'Sullana',20),(160,'Talara',20),(161,'Azángaro',21),(162,'Carabaya',21),(163,'Chucuito',21),(164,'El Collao',21),(165,'Huancané',21),(166,'Lampa',21),(167,'Melgar',21),(168,'Moho',21),(169,'San Antonio de Putina',21),(170,'San Romá',21),(171,'Sandia',21),(172,'Puno',21),(173,'Yunguyo',21),(174,'Bellavista',22),(175,'El Dorado',22),(176,'Huallaga',22),(177,'Lamas',22),(178,'Mariscal Cáceres',22),(179,'Moyobamba',22),(180,'Picota',22),(181,'Rioja',22),(182,'San Martí',22),(183,'Tocache',22),(184,'Candarave',23),(185,'Jorge Basadre',23),(186,'Tacna',23),(187,'Tarata',23),(188,'Contralmirante Villar',24),(189,'Tumbes',24),(190,'Zarumilla',24),(191,'Atalaya',25),(192,'Coronel Portillo',25),(193,'Padre Abad',25),(194,'Purús',25);
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
