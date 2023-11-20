CREATE TABLE IF NOT EXISTS `questionnaire` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_published` tinyint DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE  IF NOT EXISTS `question` (
  `id` int NOT NULL,
  `qn_id` int NOT NULL,
  `q_title` varchar(60) DEFAULT NULL,
  `option_type` varchar(20) DEFAULT NULL,
  `is_necessary` tinyint DEFAULT '0',
  `q_option` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`qn_id`)
) ;

CREATE TABLE IF NOT EXISTS `user` (
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `age` int DEFAULT '0',
  `qn_id` int NOT NULL DEFAULT '0',
  `q_id` int NOT NULL DEFAULT '0',
  `ans` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ;


