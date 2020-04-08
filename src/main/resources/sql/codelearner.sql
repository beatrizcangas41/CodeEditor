-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 08, 2020 at 02:38 AM
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
(1, 'Hello World!, Line & Block Comments'),
(2, 'Preprocessor Directives'),
(3, 'Variable Initialization'),
(4, 'Variable Types'),
(5, 'Escape Characters'),
(6, 'Operators - Level 1'),
(7, 'Operators - Level 2'),
(8, ' Basic Input / Output');

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
  `question_type` varchar(15) NOT NULL,
  PRIMARY KEY (`questionID`),
  KEY `moduleID` (`moduleID`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `description`, `choice_solution`, `solution`, `moduleID`, `question_type`) VALUES
(33, 'The following is an appropriate way to print a statement: cout << \"I love C++\";\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 8, 'True / False'),
(8, 'The following is an appropriate way to declare a variable as an int: \r\n\r\n    int main() {\r\n        int a;\r\n        return 0;\r\n    } \r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 3, 'True / False'),
(9, 'The following is an appropriate way to declare and initialize a variable as an integer:\r\n\r\nint main() {\r\n    int a = 5;\r\n}\r\n\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 3, 'True / False'),
(10, 'The two following codes are equivalent:\r\n    \r\n   Code 1: double a, b, c;\r\n   \r\n   Code 2: \r\n           double a;\r\n           double b;\r\n           double c;\r\n\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 3, 'True / False'),
(11, 'Which of the following is the appropriate variable type to use with the word \"float\" ? \r\n\r\n        a. word                                                       \r\n        b. char\r\n        c. string\r\n        d. float', 'C', 'STRING', 4, 'Multiple Choice'),
(7, 'The following is an appropriate way to declare a variable as an int:\r\n\r\n    int main() {\r\n        int = a;\r\n    }\r\n\r\n    a. TRUE\r\n    b. FALSE', 'B', 'FALSE', 3, 'True / False'),
(12, 'What is the correct statement ending character in c++?\r\n    a. :\r\n    b. #\r\n    c. /\r\n    d. ;', 'D', ';', 4, 'Multiple Choice'),
(13, 'The following code will print Arnold Schwarzenegger to the screen:\r\n\r\n    #include <iostream>\r\n    #include <string>\r\n    using namespace std;\r\n    \r\n    int main () {\r\n        string name;\r\n        name = \"Arnold Schwarzenegger\";\r\n        cout << name;\r\n        return 0;\r\n    }\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 4, 'True / False'),
(14, 'What will be the output of the following C++ code?\r\n\r\n     #include <iostream>\r\n     using namespace std;\r\n     int main() {\r\n         int i, j;\r\n         j = 10;\r\n         i = (j++, j + 100, 999 + j);\r\n         cout << i;\r\n         return 0;\r\n     }\r\n\r\n    a. 1000\r\n    b. 11\r\n    c. 1010\r\n    d. 1001\r\n', 'C', '1010', 6, 'Multiple Choice'),
(15, 'What will be the output of the following C++ code?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n    int main () {\r\n        int n;\r\n\r\n        for (n = 5; n > 0; n--) {\r\n           cout << n;\r\n           if (n == 3) break;\r\n        }\r\n        \r\n        return 0;\r\n    }\r\n\r\n    a. 543\r\n    b. 54\r\n    c. 5432\r\n    d. 53\r\n', 'A', '543', 6, 'Multiple Choice'),
(16, 'What will be the output of the following C++ code?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n\r\n        int main() {\r\n            int i;\r\n\r\n            for (i = 0; i < 10; i++) {\r\n                cout << i;\r\n           }\r\n        \r\n           return 0;\r\n    }\r\n\r\n    a. 0123456789\r\n    b. 10\r\n    c. 012345678910\r\n    d. compile time error\r\n', 'A', '0123456789', 6, 'Multiple Choice'),
(17, 'The following code snippet will produce this result. \r\n\r\n    Code snippet:  cout << “a\\nb\\nc”;\r\n\r\n    Result:\r\n\r\n        a\r\n        b\r\n        c\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 5, 'True / False'),
(18, 'Assigning a variable in c++ can be done using which of the following operators?\r\n\r\n    a. +\r\n    b. ==\r\n    c. //\r\n    d. =', 'D', '=', 6, 'Multiple Choice'),
(19, 'What is the result of the following cout statement?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n\r\n        int main () {\r\n            int a = 5;\r\n            a+=3;        \r\n            cout << a;\r\n        }\r\n\r\n    a. Error\r\n    b. 5\r\n    c. 3\r\n    d. 8\r\n', 'D', '8', 8, 'Multiple Choice'),
(20, 'Which of the following are the correct way(s) of incrementing the variable x by 1.  Assume the variable stores an integer value: \r\n\r\n    a. x += 1;\r\n    b. ++x;\r\n    c. x = x + 1;\r\n    d. All of the above\r\n', 'D', 'ALL OF THE ABOVE', 6, 'Multiple Choice'),
(21, 'The operators ‘=’ and ‘==’ have the same meaning in c++:\r\n\r\n    a. TRUE\r\n    b. FALSE', 'B', 'FALSE', 6, 'True / False'),
(22, '‘!=’ is an example of what type of operator?\r\n\r\n    a. Arithmetic\r\n    b. Assignment\r\n    c. Compound Assignment\r\n    d. Relational\r\n', 'D', 'RELATIONAL', 6, 'Multiple Choice'),
(23, '‘||’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true:\r\n \r\n    a. TRUE\r\n    b. FALSE\r\n', 'B', 'FALSE', 6, 'True / False'),
(24, '‘&&’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true:\r\n \r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 6, 'True / False'),
(25, '‘||’ corresponds to the boolean (logical) operator OR, which yields true if either of its operands are true:\r\n \r\n    a. TRUE  \r\n    b. FALSE\r\n', 'A', 'TRUE', 6, 'True / False'),
(26, 'The preprocessor directive that allows for standard input and output is:\r\n\r\n    #include iostream\r\n\r\n    a. TRUE \r\n    b. FALSE\r\n', 'B', 'FALSE', 2, 'True / False'),
(27, 'The preprocessor directive that allows for standard input and output is:\r\n\r\n    #include <iostream>\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 2, 'True / False'),
(28, 'Which of the following is the insertion operator?\r\n\r\n    a. >>\r\n    b. ==\r\n    c. <<\r\n    d. \\\\\r\n', 'C', '<<', 6, 'Multiple Choice'),
(29, 'Which of the following is the extraction operator?\r\n\r\n    a. >>\r\n    b. ==\r\n    c. <<\r\n    d. \\\\\r\n', 'A', '>>', 6, 'Multiple Choice'),
(30, 'The extraction operator is used with the standard input “cin”:\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 6, 'True / False'),
(31, 'The insertion operator is used with the standard input “cin”:\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'B', 'FALSE', 6, 'True / False'),
(32, 'The following code correctly accepts a user entered value into the string “hobby” and prints “Your favorite hobby is” followed by the hobby entered by the user:\r\n\r\n    #include <iostream>\r\n    #include <string>\r\n    using namespace std;\r\n\r\n    int main () {\r\n        string hobby ;\r\n        cout << \"Please enter your favorite hobby: \";\r\n        cin >> hobby;\r\n        cout << \"Your favorite hobby is “ << hobby;\r\n        return 0;\r\n    }\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 8, 'True / False');

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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `createdOn`, `token`, `address`, `user_type`, `user_status`, `name`, `email`, `username`, `password`) VALUES
(1, '2020-03-30 17:17:55', 'c06ea589-d704-4a96-831c-3ba4755f50bc', NULL, 'User', b'1', 'Beatriz', 'beatrizcangas41@gmail.com', 'beatriz', '$2a$10$X9NvMsPcL/1jVeDHcYC5AeTfnMU5o/e94d0qlhaXVRpTpOReDmzx.'),
(2, '2020-04-04 19:30:55', NULL, NULL, 'User', b'1', 'asdf', 'beatrizcangas41@gmail.com', 'asdf', '$2a$10$F0XCymbScCqWfzyRkAwrNeKY1UlmFMYD1BV.5Z8DJ/eamvBxamjSq');

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
-- Stand-in structure for view `user_score_performance`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `user_score_performance`;
CREATE TABLE IF NOT EXISTS `user_score_performance` (
`userID` int(10)
,`createdOn` datetime
,`token` char(36)
,`address` varchar(100)
,`user_type` enum('User','Admin')
,`user_status` bit(1)
,`name` varchar(100)
,`email` varchar(50)
,`username` varchar(50)
,`password` varchar(64)
,`score` double
,`NumberOfCorrectAnswers` int(11)
,`NumberOfIncorrectAnswers` int(11)
,`performance` double
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

-- --------------------------------------------------------

--
-- Structure for view `user_score_performance`
--
DROP TABLE IF EXISTS `user_score_performance`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_score_performance`  AS  select `u`.`userID` AS `userID`,`u`.`createdOn` AS `createdOn`,`u`.`token` AS `token`,`u`.`address` AS `address`,`u`.`user_type` AS `user_type`,`u`.`user_status` AS `user_status`,`u`.`name` AS `name`,`u`.`email` AS `email`,`u`.`username` AS `username`,`u`.`password` AS `password`,`s`.`score` AS `score`,`s`.`numberOfCorrectAnswers` AS `NumberOfCorrectAnswers`,`s`.`numberOfIncorrectAnswers` AS `NumberOfIncorrectAnswers`,`p`.`performance` AS `performance` from ((`user` `u` join `score` `s` on((`u`.`userID` = `s`.`userID`))) join `performance` `p` on((`u`.`userID` = `p`.`userID`))) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
