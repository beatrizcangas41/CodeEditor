-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 04, 2020 at 03:34 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `codelearner`
--
CREATE DATABASE IF NOT EXISTS `codelearner` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `codelearner`;

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `moduleID` int(10) NOT NULL,
  `moduleName` varchar(50) NOT NULL,
  PRIMARY KEY (`moduleID`,`moduleName`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`moduleID`, `moduleName`) VALUES
(1, '\"Hello World!”, Line & Block Comments'),
(2, 'Preprocessor Directives'),
(3, 'Variable Initialization'),
(4, 'Variable Types'),
(5, 'Operators'),
(6, 'Escape Characters');

-- --------------------------------------------------------

--
-- Table structure for table `performance`
--

DROP TABLE IF EXISTS `performance`;
CREATE TABLE IF NOT EXISTS `performance` (
  `performance` double NOT NULL,
  `userID` int(10) NOT NULL,
  PRIMARY KEY (`performance`,`userID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `questionID` int(10) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `choice_solution` varchar(1) DEFAULT NULL,
  `solution` varchar(500) NOT NULL,
  `moduleID` int(10) NOT NULL,
  PRIMARY KEY (`questionID`),
  KEY `moduleID` (`moduleID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `description`, `choice_solution`, `solution`, `moduleID`) VALUES
(1, 'The following is an appropriate way to print a statement: cout << \"I love C++\";\r\n    a. T\r\n    b. F', 'A', 'TRUE', 1),
(2, 'The following is an appropriate way to declare a variable as an int: \r\n\r\nint main() {\r\n    int a;\r\n    return 0;\r\n} \r\n\r\n\r\n    a. T\r\n    b. F', 'A', 'TRUE', 1),
(3, 'The following is an appropriate way to declare and initialize a variable as an integer:\r\n\r\nint main() {\r\n    int a = 5;\r\n    return 0;\r\n}\r\n\r\n\r\n    a. T\r\n    b. F', 'A', 'TRUE', 1),
(4, 'The two following codes are equivalent:\r\n    \r\n   Code 1: double a, b, c;\r\n   \r\n   Code 2: \r\n           double a;\r\n           double b;\r\n           double c;\r\n\r\n\r\n    a. T\r\n    b. F', 'A', 'TRUE', 2),
(5, 'Which of the following is the appropriate variable type to use with the word \"float\" ? \r\n        a. word                                                       \r\n        b. char\r\n        c. string\r\n        d. float', 'C', 'STRING', 2);

-- --------------------------------------------------------

--
-- Stand-in structure for view `question_module`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `question_module`;
CREATE TABLE IF NOT EXISTS `question_module` (
`questionID` int(10)
,`description` varchar(500)
,`choice_solution` varchar(1)
,`solution` varchar(500)
,`moduleID` int(10)
,`moduleName` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
  `score` double NOT NULL,
  `userID` int(11) NOT NULL,
  `moduleID` int(11) NOT NULL,
  `numberOfCorrectAnswers` int(11) NOT NULL,
  `numberOfIncorrectAnswers` int(11) NOT NULL,
  `totalNumberOfAnswers` int(11) NOT NULL,
  PRIMARY KEY (`score`,`userID`,`moduleID`),
  UNIQUE KEY `userID` (`userID`),
  UNIQUE KEY `moduleID` (`moduleID`),
  UNIQUE KEY `user-module-ID` (`userID`,`moduleID`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token` char(36) DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `user_type` enum('User','Admin') NOT NULL DEFAULT 'User',
  `user_status` bit(1) NOT NULL DEFAULT b'1',
  `name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `createdOn`, `token`, `address`, `user_type`, `user_status`, `name`, `email`, `username`, `password`) VALUES
(1, '2020-03-30 17:17:55', 'c06ea589-d704-4a96-831c-3ba4755f50bc', NULL, 'User', b'1', 'Beatriz', 'beatrizcangas41@gmail.com', 'beatriz', '$2a$10$X9NvMsPcL/1jVeDHcYC5AeTfnMU5o/e94d0qlhaXVRpTpOReDmzx.');

-- --------------------------------------------------------

--
-- Stand-in structure for view `user_module_score`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `user_module_score`;
CREATE TABLE IF NOT EXISTS `user_module_score` (
`score` double
,`userID` int(11)
,`moduleID` int(11)
,`numberOfCorrectAnswers` int(11)
,`numberOfIncorrectAnswers` int(11)
,`totalNumberOfAnswers` int(11)
,`name` varchar(100)
,`moduleName` varchar(50)
);

-- --------------------------------------------------------

--
-- Structure for view `question_module`
--
DROP TABLE IF EXISTS `question_module`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `question_module`  AS  select `question`.`questionID` AS `questionID`,`question`.`description` AS `description`,`question`.`choice_solution` AS `choice_solution`,`question`.`solution` AS `solution`,`question`.`moduleID` AS `moduleID`,`module`.`moduleName` AS `moduleName` from (`question` join `module` on((`question`.`moduleID` = `module`.`moduleID`))) ;

-- --------------------------------------------------------

--
-- Structure for view `user_module_score`
--
DROP TABLE IF EXISTS `user_module_score`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_module_score`  AS  select `s`.`score` AS `score`,`s`.`userID` AS `userID`,`s`.`moduleID` AS `moduleID`,`s`.`numberOfCorrectAnswers` AS `numberOfCorrectAnswers`,`s`.`numberOfIncorrectAnswers` AS `numberOfIncorrectAnswers`,`s`.`totalNumberOfAnswers` AS `totalNumberOfAnswers`,`u`.`name` AS `name`,`m`.`moduleName` AS `moduleName` from ((`score` `s` join `user` `u` on((`s`.`userID` = `u`.`userID`))) join `module` `m` on((`s`.`moduleID` = `m`.`moduleID`))) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
