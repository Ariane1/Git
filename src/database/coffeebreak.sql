-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 17 Mars 2014 à 19:17
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `coffeebreak`
--
CREATE DATABASE IF NOT EXISTS `coffeebreak` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `coffeebreak`;

-- --------------------------------------------------------

--
-- Structure de la table `coffees`
--

CREATE TABLE IF NOT EXISTS `coffees` (
  `COF_NAME` varchar(255) NOT NULL,
  `PRICE` int(11) NOT NULL,
  KEY `COF_NAME` (`COF_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
