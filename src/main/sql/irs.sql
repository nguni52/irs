-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 04, 2013 at 04:48 PM
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
-- Table structure for table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `investment_admin` varchar(50) NOT NULL,
  `postal_address_id` int(11) NOT NULL,
  `physical_address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `job_title`
--

CREATE TABLE IF NOT EXISTS `job_title` (
  `job_title_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_title_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`job_title_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `physical_address`
--

CREATE TABLE IF NOT EXISTS `physical_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `street_name` varchar(100) NOT NULL,
  `suburb` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `province` varchar(50) NOT NULL,
  `code` int(11) NOT NULL,
  `country` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `postal_address`
--

CREATE TABLE IF NOT EXISTS `postal_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `box_number` varchar(20) NOT NULL,
  `suburb` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `code` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `trustee`
--

CREATE TABLE IF NOT EXISTS `trustee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `cell` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `trustee_role_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `trustee`
--

INSERT INTO `trustee` (`id`, `client_id`, `firstname`, `surname`, `cell`, `tel`, `trustee_role_id`, `status`) VALUES
(3, 5, 'Steven', 'Golden', '1234567890', '1234567899', 2, 1),
(2, 9, 'Johnny', 'Dopey', '0725304067', '1234567890', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `trustee_role`
--

CREATE TABLE IF NOT EXISTS `trustee_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `trustee_role`
--

INSERT INTO `trustee_role` (`id`, `description`) VALUES
(1, 'CEOM'),
(2, 'CEO'),
(3, 'TESTER1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeID` varchar(30) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `jobTitle` varchar(10) NOT NULL,
  `enabled` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `employeeID`, `firstname`, `lastname`, `telephone`, `email`, `jobTitle`, `role`) VALUES
(7, 'ABD001', 'Abdul', 'Bujhar', '0987654321', 'test@yahoo.nom', 'traineee', 'admin'),
(4, 'a0018874', 'Nkululeko', 'Phakela', '0117177167', 'info@Nguni52.co.za', 'Lawyer', 'administrator'),
(9, 'Joh001', 'John', 'Doe', '1234567890', 'jdoe@test.com', 'SysEng', 'admin'),
(10, '123qwe', 'Peter', 'West', '0980980988', 'pw@west.com', 'CEO', 'none'),
(11, '123', 'fred', 'dooby', '1234567890', 'tes', 'manager', 'admin'),
(19, '0909', 'Joey', 'DiPillo', '09090909', 'joey@g1.com', 'sales', 'admin'),
(20, '2323', 'Winston', 'Hubert', '1234567890', 'wh@test.com', 'sales', 'admin'),
(21, '4455', 'Abegail L', 'McKenzie', '1234567890', 'amkcenzie@yahoo.com', 'wait ress', 'admin'),
(22, '123', 'taribo', 'west', '0123456789', 'twest@yahoo.com', 'defender', 'ADMIN'),
(23, '1234098', 'Lionel', 'McKenzie', '0112003000', 'leo@yahoo.com', 'Manger', 'admin');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
