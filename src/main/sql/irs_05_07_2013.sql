-- phpMyAdmin SQL Dump
-- version 3.5.8.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 05, 2013 at 03:14 PM
-- Server version: 5.5.31-0ubuntu0.13.04.1
-- PHP Version: 5.4.9-4ubuntu2.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `irs`
--

-- --------------------------------------------------------

--
-- Table structure for table `asset_manager`
--

CREATE TABLE IF NOT EXISTS `asset_manager` (
  `asset_manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `asset_manager_description` varchar(45) NOT NULL,
  `contact_number` varchar(15) NOT NULL,
  `email_address` varchar(45) NOT NULL,
  PRIMARY KEY (`asset_manager_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Table structure for table `asset_manager_person`
--

CREATE TABLE IF NOT EXISTS `asset_manager_person` (
  `person_id` int(11) NOT NULL,
  `asset_manager_id` int(11) NOT NULL,
  KEY `person_id_idx` (`person_id`),
  KEY `asset_manager_id_idx` (`asset_manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `asset_manager_physical_address`
--

CREATE TABLE IF NOT EXISTS `asset_manager_physical_address` (
  `asset_manager_id` int(11) NOT NULL,
  `physical_address_id` int(11) NOT NULL,
  KEY `asset_manager_id_idx` (`asset_manager_id`),
  KEY `physical_address_id_idx` (`physical_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `asset_manager_postal_address`
--

CREATE TABLE IF NOT EXISTS `asset_manager_postal_address` (
  `asset_manager_id` int(11) NOT NULL,
  `postal_address_id` int(11) NOT NULL,
  KEY `postal_address_is_idx` (`postal_address_id`),
  KEY `asset_manager_id_idx` (`asset_manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(20) NOT NULL,
  `authority` varchar(10) NOT NULL,
  KEY `username_idx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `authority`
--

CREATE TABLE IF NOT EXISTS `authority` (
  `authority_id` int(11) NOT NULL,
  `authority` varchar(10) NOT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `investor`
--

CREATE TABLE IF NOT EXISTS `investor` (
  `investor_id` int(11) NOT NULL AUTO_INCREMENT,
  `investor_description` varchar(45) NOT NULL,
  `contact_number` varchar(15) NOT NULL,
  `email_address` varchar(45) NOT NULL,
  PRIMARY KEY (`investor_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

-- --------------------------------------------------------

--
-- Table structure for table `investor_person`
--

CREATE TABLE IF NOT EXISTS `investor_person` (
  `person_id` int(11) NOT NULL,
  `investor_id` int(11) NOT NULL,
  KEY `investor_id_idx` (`investor_id`),
  KEY `person_id_idx` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `investor_physical_address`
--

CREATE TABLE IF NOT EXISTS `investor_physical_address` (
  `investor_id` int(11) NOT NULL,
  `physical_address_id` int(11) NOT NULL,
  KEY `investor_id_idx` (`investor_id`),
  KEY `physical_address_id_idx` (`physical_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `investor_postal_address`
--

CREATE TABLE IF NOT EXISTS `investor_postal_address` (
  `investor_id` int(11) NOT NULL,
  `postal_address_id` int(11) NOT NULL,
  KEY `investor_id_idx` (`investor_id`),
  KEY `postal_address_is_idx` (`postal_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `job_title`
--

CREATE TABLE IF NOT EXISTS `job_title` (
  `job_title_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_title_description` varchar(45) NOT NULL,
  PRIMARY KEY (`job_title_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_title_id` int(11) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `title` varchar(15) NOT NULL,
  `identity_number` varchar(13) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `work_number` varchar(15) DEFAULT NULL,
  `mobile_number` varchar(15) NOT NULL,
  `email_address` varchar(45) NOT NULL,
  PRIMARY KEY (`person_id`),
  KEY `job_title_id_idx` (`job_title_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=55 ;

-- --------------------------------------------------------

--
-- Table structure for table `physical_address`
--

CREATE TABLE IF NOT EXISTS `physical_address` (
  `physical_address_id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_number` int(11) DEFAULT NULL,
  `complex_name` varchar(45) DEFAULT NULL,
  `street_number` int(11) DEFAULT NULL,
  `street_name` varchar(45) DEFAULT NULL,
  `suburb` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `same_as_postal` tinyint(1) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`physical_address_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

-- --------------------------------------------------------

--
-- Table structure for table `portfolio`
--

CREATE TABLE IF NOT EXISTS `portfolio` (
  `portfolio_id` int(11) NOT NULL AUTO_INCREMENT,
  `investor_id` int(11) NOT NULL,
  `portfolio_description` varchar(45) NOT NULL,
  PRIMARY KEY (`portfolio_id`),
  KEY `investor_id_idx` (`investor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `postal_address`
--

CREATE TABLE IF NOT EXISTS `postal_address` (
  `postal_address_id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(30) NOT NULL,
  `suburb` varchar(45) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`postal_address_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

-- --------------------------------------------------------

--
-- Table structure for table `trustee`
--

CREATE TABLE IF NOT EXISTS `trustee` (
  `trustee_id` int(11) NOT NULL AUTO_INCREMENT,
  `investor_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `trustee_role_id` int(11) NOT NULL,
  `date_from` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_to` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`trustee_id`),
  KEY `investor_id_idx` (`investor_id`),
  KEY `person_id_idx` (`person_id`),
  KEY `trustee_role_id_idx` (`trustee_role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

-- --------------------------------------------------------

--
-- Table structure for table `trustee_role`
--

CREATE TABLE IF NOT EXISTS `trustee_role` (
  `trustee_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `trustee_role_description` varchar(45) NOT NULL,
  PRIMARY KEY (`trustee_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `password_expired` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_person`
--

CREATE TABLE IF NOT EXISTS `user_person` (
  `person_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `person_id_idx` (`person_id`),
  KEY `user_is_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
