CREATE DATABASE  IF NOT EXISTS `scheduler` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scheduler`;

--
-- Table structure for table `employee_profile`
--
SET FOREIGN_KEY_CHECKS=0; -- to disable them
DROP TABLE IF EXISTS `employee_profile`;
CREATE TABLE `employee_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(128) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `post_code` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `company`
--
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id`    int(11) NOT NULL AUTO_INCREMENT,
  `name`  varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `team`
--
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `company_team`
--
DROP TABLE IF EXISTS `company_team`;
CREATE TABLE `company_team` (
  `company_id` int(11) NOT NULL,
  `team_id`    int(11) NOT NULL,

  PRIMARY KEY (`company_id`,`team_id`),

  KEY `FK_COMPANY_TEAMS_idx` (`team_id`),

  CONSTRAINT `FK_COMPANY` FOREIGN KEY (`company_id`)
  REFERENCES `company` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_TEAM1` FOREIGN KEY (`team_id`)
  REFERENCES `team` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name`  varchar(45) DEFAULT NULL,
  `email`      varchar(45) DEFAULT NULL,
  `employee_profile_id` int(11) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_PROFILE_idx` (`employee_profile_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`employee_profile_id`)
  REFERENCES `employee_profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,

  KEY `FK_COMPANY_idx` (`company_id`),
  CONSTRAINT `FK_EMPLOYEE_COMPANY` FOREIGN KEY (`company_id`)
  REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `employee_team`
--
DROP TABLE IF EXISTS `employee_team`;
CREATE TABLE `employee_team` (
  `employee_id` int(11) NOT NULL,
  `team_id`     int(11) NOT NULL,

  PRIMARY KEY (`employee_id`,`team_id`),

  KEY `FK_EMPLOYEE_TEAMS_idx` (`team_id`),

  CONSTRAINT `FK_EMPLOYEE` FOREIGN KEY (`employee_id`)
  REFERENCES `employee` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_TEAM2` FOREIGN KEY (`team_id`)
  REFERENCES `team` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=1; -- to disable them

