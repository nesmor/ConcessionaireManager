-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 27, 2019 at 05:49 PM
-- Server version: 5.7.25-0ubuntu0.16.04.2
-- PHP Version: 7.0.33-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `concessionaire_manager`
--
CREATE DATABASE concessionaire_manager;
-- --------------------------------------------------------

--
-- Table structure for table `agency`
--

CREATE TABLE `agency` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agency`
--

INSERT INTO `agency` (`id`, `name`, `location_id`) VALUES
(1, 'Concesionario Caracas', 1),
(2, 'Concesionario Maracay', 2);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_date` datetime DEFAULT NULL,
  `document_number` varchar(10) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `status` varchar(10) DEFAULT 'ACTIVE',
  `updated_date` datetime DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `create_date`, `deleted_date`, `document_number`, `email`, `name`, `phone_number`, `status`, `updated_date`, `agency_id`) VALUES
(1, '2019-04-26 19:57:07', NULL, '13608741', 'nestor.e.s.m@gmail.com', 'Nestor Sanchez', '0412332448', 'ACTIVE', NULL, 1),
(2, '2019-04-27 16:00:23', NULL, '2000000', 'dorotea@gmail.com', 'Doris Barazarte', '584123324480', NULL, '2019-04-27 16:33:36', 2),
(3, '2019-04-27 16:11:40', NULL, '1463256', 'dorotea@gmail.com', 'Doris Barazarte', '584123324480', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `name`) VALUES
(1, 'Caracas'),
(2, 'Maracay'),
(3, 'Maracaibo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agency`
--
ALTER TABLE `agency`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_dg0dp55afow6u56rf8ku91ojc` (`location_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_mcxhs25405p3p7mrre6he23nf` (`document_number`),
  ADD KEY `fk_customer_agency` (`agency_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agency`
--
ALTER TABLE `agency`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `agency`
--
ALTER TABLE `agency`
  ADD CONSTRAINT `fk_agency_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `fk_customer_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;