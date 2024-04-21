-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2024 at 03:51 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `univdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `LecturerID` char(5) NOT NULL,
  `LecturerName` varchar(50) NOT NULL,
  `LecturerEmail` varchar(50) NOT NULL,
  `LecturerPassword` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`LecturerID`, `LecturerName`, `LecturerEmail`, `LecturerPassword`) VALUES
('D2042', 'Cuk Tho', 'cuk.tho@binus.ac.id', '188344631212302404694524240483257464135'),
('D6071', 'Priskardus Hermanto Candra', 'priskardus@binus.ac.id', '186822357379319763059070457618879502465'),
('D6671', 'Yulianto', 'yulianto@binus.ac.id', '322692192312935809451177824842877101981'),
('D6747', 'MILKHATUSSYAFA\'AH TAUFIQ', 'milkha@binus.ac.id', '200772696647278314722223075383710238216'),
('D7606', 'Elizabeth Paskahlia Gunawan', 'elizabeth.gunawan@binus.ac.id', '35096827412688972991802551680945652361'),
('tes', 'asd', 'asd@binus.ac.id', '50289237170436618337630361918168106925');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `StudentID` varchar(10) DEFAULT NULL,
  `ClassID` char(4) DEFAULT NULL,
  `Assignment` int(11) DEFAULT NULL,
  `Quiz` int(11) DEFAULT NULL,
  `Exam` int(11) DEFAULT NULL,
  `finalScore` int(11) DEFAULT NULL,
  `Result` char(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`StudentID`, `ClassID`, `Assignment`, `Quiz`, `Exam`, `finalScore`, `Result`) VALUES
('qwe', 'LA20', 100, 20, 100, 73, 'PASS'),
('S0002', 'LA20', 12, NULL, NULL, NULL, NULL),
('S0003', 'LA20', NULL, 34, NULL, NULL, NULL),
('S0004', 'LA20', NULL, NULL, 90, NULL, NULL),
('S0001', 'LB20', NULL, 20, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` char(5) NOT NULL,
  `StudentName` varchar(50) NOT NULL,
  `StudentEmail` varchar(50) NOT NULL,
  `StudentPassword` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentID`, `StudentName`, `StudentEmail`, `StudentPassword`) VALUES
('qwe', 'qwe', 'qwe@binus', '244093844520859738569103536117907334795'),
('S0001', 'Adriel Felin', 'adriel.felin@binus.ac.id', '150404989191067278549472741522612424798'),
('S0002', 'Ady Nugroho', 'ady.nugroho@binus.ac.id ', '95129484377963431530427186444838561842'),
('S0003', 'Ahmad Waliyyul Afkar', 'ahmad.afkar@binus.ac.id ', '188590577365237656127337980195653753344'),
('S0004', 'Albertus Giovanni Prasetyo', 'albertus.prasetyo@binus.ac.id ', '136579610275374325063931405187736610646'),
('S1234', 'Raynaldy Dwi Kharisma', 'raynaldy.kharisma@binus.ac.id', '148329421325737181773500122625491926412');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`LecturerID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
