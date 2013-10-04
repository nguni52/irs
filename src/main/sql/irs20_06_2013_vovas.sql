-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 20, 2013 at 04:21 PM
-- Server version: 5.5.25
-- PHP Version: 5.4.3

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `asset_manager`
--

INSERT INTO `asset_manager` (`asset_manager_id`, `asset_manager_description`, `contact_number`, `email_address`) VALUES
(1, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(2, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(3, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(4, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(5, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(6, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(7, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(8, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(9, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(10, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(11, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(12, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(13, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(14, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(15, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(16, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(17, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(18, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(19, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(20, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(21, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(22, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(23, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(24, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(25, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(26, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(27, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(28, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(29, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(30, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(31, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(32, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(33, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(34, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(35, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(36, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(37, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(38, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(39, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(40, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(41, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(42, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(43, 'Allan Gray', '0731234567', 'mk@gmail.com'),
(44, 'Allan Gray', '0731234567', 'mk@gmail.com');

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

--
-- Dumping data for table `asset_manager_person`
--

INSERT INTO `asset_manager_person` (`person_id`, `asset_manager_id`) VALUES
(4, 2),
(87, 1);

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

--
-- Dumping data for table `asset_manager_physical_address`
--

INSERT INTO `asset_manager_physical_address` (`asset_manager_id`, `physical_address_id`) VALUES
(2, 5),
(1, 128);

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

--
-- Dumping data for table `asset_manager_postal_address`
--

INSERT INTO `asset_manager_postal_address` (`asset_manager_id`, `postal_address_id`) VALUES
(2, 5),
(1, 128);

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(20) NOT NULL,
  `authority` varchar(10) NOT NULL,
  KEY `username_idx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('petertosh', 'ROLE_ADMIN'),
('andre', 'ROLE_ADMIN');

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
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `employee_no` varchar(10) NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `person_id_idx` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_investor`
--

CREATE TABLE IF NOT EXISTS `employee_investor` (
  `employee_id` int(11) NOT NULL,
  `investor_id` int(11) NOT NULL,
  KEY `investor_id_idx` (`investor_id`)
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `investor`
--

INSERT INTO `investor` (`investor_id`, `investor_description`, `contact_number`, `email_address`) VALUES
(1, 'Apple TV', '0731234567', 'apple@me.com'),
(2, 'Apple TV', '0731234567', 'apple@me.com'),
(3, 'Apple TV', '0731234567', 'apple@me.com'),
(4, 'Apple TV', '0731234567', 'apple@me.com'),
(5, 'Apple TV', '0731234567', 'apple@me.com'),
(6, 'Apple TV', '0731234567', 'apple@me.com'),
(7, 'Apple TV', '0731234567', 'apple@me.com'),
(8, 'Apple TV', '0731234567', 'apple@me.com'),
(9, 'Apple TV', '0731234567', 'apple@me.com'),
(10, 'Apple TV', '0731234567', 'apple@me.com'),
(11, 'Apple TV', '0731234567', 'apple@me.com'),
(12, 'Apple TV', '0731234567', 'apple@me.com'),
(13, 'Apple TV', '0731234567', 'apple@me.com'),
(14, 'Apple TV', '0731234567', 'apple@me.com'),
(15, 'Apple TV', '0731234567', 'apple@me.com'),
(16, 'Apple TV', '0731234567', 'apple@me.com'),
(17, 'Apple TV', '0731234567', 'apple@me.com'),
(18, 'Apple TV', '0731234567', 'apple@me.com'),
(19, 'Apple TV', '0731234567', 'apple@me.com'),
(20, 'Apple TV', '0731234567', 'apple@me.com'),
(21, 'Apple TV', '0731234567', 'apple@me.com'),
(22, 'Apple TV', '0731234567', 'apple@me.com'),
(23, 'Apple TV', '0731234567', 'apple@me.com'),
(24, 'Apple TV', '0731234567', 'apple@me.com'),
(25, 'Apple TV', '0731234567', 'apple@me.com'),
(26, 'Apple TV', '0731234567', 'apple@me.com'),
(27, 'Apple TV', '0731234567', 'apple@me.com'),
(28, 'Apple TV', '0731234567', 'apple@me.com'),
(29, 'Apple TV', '0731234567', 'apple@me.com'),
(30, 'Apple TV', '0731234567', 'apple@me.com'),
(31, 'Apple TV', '0731234567', 'apple@me.com'),
(32, 'Apple TV', '0731234567', 'apple@me.com'),
(33, 'Apple TV', '0731234567', 'apple@me.com'),
(34, 'Apple TV', '0731234567', 'apple@me.com'),
(35, 'Apple TV', '0731234567', 'apple@me.com'),
(36, 'Apple TV', '0731234567', 'apple@me.com'),
(37, 'Apple TV', '0731234567', 'apple@me.com'),
(38, 'Apple TV', '0731234567', 'apple@me.com'),
(39, 'Apple TV', '0731234567', 'apple@me.com'),
(40, 'Apple TV', '0731234567', 'apple@me.com'),
(41, 'Apple TV', '0731234567', 'apple@me.com'),
(42, 'Apple TV', '0731234567', 'apple@me.com'),
(43, 'Apple TV', '0731234567', 'apple@me.com'),
(44, 'Apple TV', '0731234567', 'apple@me.com');

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

--
-- Dumping data for table `investor_person`
--

INSERT INTO `investor_person` (`person_id`, `investor_id`) VALUES
(1, 1),
(3, 2),
(5, 3),
(7, 4),
(9, 5),
(11, 6),
(13, 7),
(15, 8),
(17, 9),
(19, 10),
(21, 11),
(23, 12),
(25, 13),
(27, 14),
(29, 15),
(31, 16),
(33, 17),
(36, 18),
(38, 19),
(40, 20),
(42, 21),
(44, 22),
(46, 23),
(48, 24),
(50, 25),
(52, 26),
(54, 27),
(56, 28),
(58, 29),
(60, 30),
(62, 31),
(64, 32),
(66, 33),
(68, 34),
(70, 35),
(72, 36),
(74, 37),
(76, 38),
(78, 39),
(80, 40),
(82, 41),
(84, 42),
(86, 43),
(88, 44);

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

--
-- Dumping data for table `investor_physical_address`
--

INSERT INTO `investor_physical_address` (`investor_id`, `physical_address_id`) VALUES
(1, 1),
(3, 6),
(4, 9),
(5, 12),
(6, 15),
(7, 18),
(8, 21),
(9, 24),
(10, 27),
(11, 30),
(12, 33),
(13, 36),
(14, 39),
(15, 42),
(16, 45),
(17, 48),
(18, 51),
(19, 54),
(20, 57),
(21, 60),
(22, 63),
(23, 66),
(24, 69),
(25, 72),
(26, 75),
(27, 78),
(28, 81),
(29, 84),
(30, 87),
(31, 90),
(32, 93),
(33, 96),
(34, 99),
(35, 102),
(36, 105),
(37, 108),
(38, 111),
(39, 114),
(40, 117),
(41, 120),
(42, 123),
(43, 126),
(44, 129),
(2, 130);

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

--
-- Dumping data for table `investor_postal_address`
--

INSERT INTO `investor_postal_address` (`investor_id`, `postal_address_id`) VALUES
(1, 1),
(3, 6),
(4, 9),
(5, 12),
(6, 15),
(7, 18),
(8, 21),
(9, 24),06/03/2013
(10, 27),
(11, 30),
(12, 33),
(13, 36),
(14, 39),
(15, 42),
(16, 45),
(17, 48),
(18, 51),
(19, 54),
(20, 57),
(21, 60),
(22, 63),
(23, 66),
(24, 69),
(25, 72),
(26, 75),
(27, 78),
(28, 81),
(29, 84),
(30, 87),
(31, 90),
(32, 93),
(33, 96),
(34, 99),
(35, 102),
(36, 105),
(37, 108),
(38, 111),
(39, 114),
(40, 117),
(41, 120),
(42, 123),
(43, 126),
(44, 129),
(2, 130);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=89 ;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`person_id`, `job_title_id`, `gender`, `title`, `identity_number`, `firstname`, `surname`, `work_number`, `mobile_number`, `email_address`) VALUES
(1, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(2, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(3, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(4, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(5, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(6, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(7, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(8, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(9, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(10, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(11, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(12, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(13, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(14, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(15, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(16, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(17, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(18, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(19, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(20, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(21, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(22, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(23, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(24, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(25, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(26, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(27, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(28, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(29, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(30, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(31, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(32, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(33, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(34, 1, 'Male', 'Mr', '1983092223233', 'Andre', 'Phillips', '011-111-1000', '078-000-0001', 'kenny@rol'),
(35, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(36, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(37, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(38, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(39, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(40, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(41, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(42, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(43, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(44, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(45, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(46, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(47, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(48, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(49, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(50, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(51, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(52, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(53, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(54, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(55, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(56, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(57, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(58, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(59, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(60, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(61, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(62, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(63, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(64, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(65, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(66, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(67, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(68, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(69, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(70, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(71, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(72, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(73, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(74, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(75, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(76, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(77, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(78, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(79, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(80, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(81, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(82, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(83, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(84, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(85, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(86, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za'),
(87, 1, 'male', 'Mr.', '1983092223233', 'Bujhar', 'Mqolweni', '011-111-1000', '078-000-0001', 'bm@allangray.co.za'),
(88, 1, 'male', 'Mr', '1983092223233', 'Investor', 'Gandhi', '011-111-1000', '078-110-0001', 'm@lutendo.co.za');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=131 ;

--
-- Dumping data for table `physical_address`
--

INSERT INTO `physical_address` (`physical_address_id`, `unit_number`, `complex_name`, `street_number`, `street_name`, `suburb`, `city`, `postal_code`, `same_as_postal`, `status`) VALUES
(1, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(2, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(3, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(4, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(5, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(6, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(7, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(8, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(9, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(10, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(11, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(12, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(13, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(14, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(15, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(16, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(17, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(18, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(19, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(20, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(21, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(22, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(23, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(24, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(25, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(26, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(27, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(28, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(29, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(30, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(31, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(32, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(33, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(34, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(35, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(36, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(37, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(38, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(39, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(40, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(41, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(42, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(43, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(44, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(45, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(46, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(47, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(48, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(49, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(50, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(51, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(52, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(53, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(54, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(55, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(56, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(57, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(58, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(59, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(60, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(61, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(62, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(63, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(64, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(65, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(66, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(67, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(68, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(69, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(70, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(71, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(72, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(73, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(74, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(75, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(76, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(77, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(78, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(79, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(80, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(81, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(82, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(83, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(84, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(85, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(86, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(87, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(88, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(89, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(90, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(91, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(92, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(93, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(94, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(95, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(96, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(97, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(98, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(99, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(100, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(101, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(102, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(103, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(104, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(105, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(106, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(107, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(108, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(109, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(110, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(111, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(112, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(113, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(114, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(115, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(116, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(117, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(118, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(119, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(120, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(121, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(122, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(123, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(124, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(125, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(126, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(127, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(128, 12, 'Allan Gray Building', 24, 'Zille Road', 'Pinelands', 'Cape Town', 8001, NULL, 1),
(129, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1),
(130, 12, 'IAC Building', 24, 'Vovas Road', 'Sandton', 'Sandton', 2308, NULL, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=131 ;

--
-- Dumping data for table `postal_address`
--

INSERT INTO `postal_address` (`postal_address_id`, `number`, `suburb`, `postal_code`, `status`) VALUES
(1, '55', 'Sandton', 204, 1),
(2, '33', 'Pinelands', 204, 1),
(3, '55', 'Sandton', 204, 1),
(4, '55', 'Sandton', 204, 1),
(5, '33', 'Pinelands', 204, 1),
(6, '55', 'Sandton', 204, 1),
(7, '55', 'Sandton', 204, 1),
(8, '33', 'Pinelands', 204, 1),
(9, '55', 'Sandton', 204, 1),
(10, '55', 'Sandton', 204, 1),
(11, '33', 'Pinelands', 204, 1),
(12, '55', 'Sandton', 204, 1),
(13, '55', 'Sandton', 204, 1),
(14, '33', 'Pinelands', 204, 1),
(15, '55', 'Sandton', 204, 1),
(16, '55', 'Sandton', 204, 1),
(17, '33', 'Pinelands', 204, 1),
(18, '55', 'Sandton', 204, 1),
(19, '55', 'Sandton', 204, 1),
(20, '33', 'Pinelands', 204, 1),
(21, '55', 'Sandton', 204, 1),
(22, '55', 'Sandton', 204, 1),
(23, '33', 'Pinelands', 204, 1),
(24, '55', 'Sandton', 204, 1),
(25, '55', 'Sandton', 204, 1),
(26, '33', 'Pinelands', 204, 1),
(27, '55', 'Sandton', 204, 1),
(28, '55', 'Sandton', 204, 1),
(29, '33', 'Pinelands', 204, 1),
(30, '55', 'Sandton', 204, 1),
(31, '55', 'Sandton', 204, 1),
(32, '33', 'Pinelands', 204, 1),
(33, '55', 'Sandton', 204, 1),
(34, '55', 'Sandton', 204, 1),
(35, '33', 'Pinelands', 204, 1),
(36, '55', 'Sandton', 204, 1),
(37, '55', 'Sandton', 204, 1),
(38, '33', 'Pinelands', 204, 1),
(39, '55', 'Sandton', 204, 1),
(40, '55', 'Sandton', 204, 1),
(41, '33', 'Pinelands', 204, 1),
(42, '55', 'Sandton', 204, 1),
(43, '55', 'Sandton', 204, 1),
(44, '33', 'Pinelands', 204, 1),
(45, '55', 'Sandton', 204, 1),
(46, '55', 'Sandton', 204, 1),
(47, '33', 'Pinelands', 204, 1),
(48, '55', 'Sandton', 204, 1),
(49, '55', 'Sandton', 204, 1),
(50, '33', 'Pinelands', 204, 1),
(51, '55', 'Sandton', 204, 1),
(52, '55', 'Sandton', 204, 1),
(53, '33', 'Pinelands', 204, 1),
(54, '55', 'Sandton', 204, 1),
(55, '55', 'Sandton', 204, 1),
(56, '33', 'Pinelands', 204, 1),
(57, '55', 'Sandton', 204, 1),
(58, '55', 'Sandton', 204, 1),
(59, '33', 'Pinelands', 204, 1),
(60, '55', 'Sandton', 204, 1),
(61, '55', 'Sandton', 204, 1),
(62, '33', 'Pinelands', 204, 1),
(63, '55', 'Sandton', 204, 1),
(64, '55', 'Sandton', 204, 1),
(65, '33', 'Pinelands', 204, 1),
(66, '55', 'Sandton', 204, 1),
(67, '55', 'Sandton', 204, 1),
(68, '33', 'Pinelands', 204, 1),
(69, '55', 'Sandton', 204, 1),
(70, '55', 'Sandton', 204, 1),
(71, '33', 'Pinelands', 204, 1),
(72, '55', 'Sandton', 204, 1),
(73, '55', 'Sandton', 204, 1),
(74, '33', 'Pinelands', 204, 1),
(75, '55', 'Sandton', 204, 1),
(76, '55', 'Sandton', 204, 1),
(77, '33', 'Pinelands', 204, 1),
(78, '55', 'Sandton', 204, 1),
(79, '55', 'Sandton', 204, 1),
(80, '33', 'Pinelands', 204, 1),
(81, '55', 'Sandton', 204, 1),
(82, '55', 'Sandton', 204, 1),
(83, '33', 'Pinelands', 204, 1),
(84, '55', 'Sandton', 204, 1),
(85, '55', 'Sandton', 204, 1),
(86, '33', 'Pinelands', 204, 1),
(87, '55', 'Sandton', 204, 1),
(88, '55', 'Sandton', 204, 1),
(89, '33', 'Pinelands', 204, 1),
(90, '55', 'Sandton', 204, 1),
(91, '55', 'Sandton', 204, 1),
(92, '33', 'Pinelands', 204, 1),
(93, '55', 'Sandton', 204, 1),
(94, '55', 'Sandton', 204, 1),
(95, '33', 'Pinelands', 204, 1),
(96, '55', 'Sandton', 204, 1),
(97, '55', 'Sandton', 204, 1),
(98, '33', 'Pinelands', 204, 1),
(99, '55', 'Sandton', 204, 1),
(100, '55', 'Sandton', 204, 1),
(101, '33', 'Pinelands', 204, 1),
(102, '55', 'Sandton', 204, 1),
(103, '55', 'Sandton', 204, 1),
(104, '33', 'Pinelands', 204, 1),
(105, '55', 'Sandton', 204, 1),
(106, '55', 'Sandton', 204, 1),
(107, '33', 'Pinelands', 204, 1),
(108, '55', 'Sandton', 204, 1),
(109, '55', 'Sandton', 204, 1),
(110, '33', 'Pinelands', 204, 1),
(111, '55', 'Sandton', 204, 1),
(112, '55', 'Sandton', 204, 1),
(113, '33', 'Pinelands', 204, 1),
(114, '55', 'Sandton', 204, 1),
(115, '55', 'Sandton', 204, 1),
(116, '33', 'Pinelands', 204, 1),
(117, '55', 'Sandton', 204, 1),
(118, '55', 'Sandton', 204, 1),
(119, '33', 'Pinelands', 204, 1),
(120, '55', 'Sandton', 204, 1),
(121, '55', 'Sandton', 204, 1),
(122, '33', 'Pinelands', 204, 1),
(123, '55', 'Sandton', 204, 1),
(124, '55', 'Sandton', 204, 1),
(125, '33', 'Pinelands', 204, 1),
(126, '55', 'Sandton', 204, 1),
(127, '55', 'Sandton', 204, 1),
(128, '33', 'Pinelands', 204, 1),
(129, '55', 'Sandton', 204, 1),
(130, '55', 'Sandton', 204, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trustee`
--

CREATE TABLE IF NOT EXISTS `trustee` (
  `trustee_id` int(11) NOT NULL,
  `trustee_role_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `investor_id` int(11) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`trustee_id`),
  KEY `person_id_idx` (`person_id`),
  KEY `trustee_role_id_idx` (`trustee_role_id`),
  KEY `investor_id_idx` (`investor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`, `password_expired`) VALUES
(1, 'petertosh', '161ebd7d45089b3446ee4e0d86dbcf92', 1, 0),
(18, 'andre', '161ebd7d45089b3446ee4e0d86dbcf92', 1, 1);

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

--
-- Dumping data for table `user_person`
--

INSERT INTO `user_person` (`person_id`, `user_id`) VALUES
(34, 18),
(1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
