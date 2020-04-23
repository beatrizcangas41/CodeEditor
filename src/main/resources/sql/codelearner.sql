-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 23, 2020 at 12:04 AM
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
  `programming_language_ID` int(11) NOT NULL,
  PRIMARY KEY (`moduleID`,`moduleName`),
  KEY `programming_language_ID` (`programming_language_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`moduleID`, `moduleName`, `programming_language_ID`) VALUES
(1, 'Hello World!, Line & Block Comments', 1),
(2, 'Preprocessor Directives', 1),
(3, 'Variable Initialization', 1),
(4, 'Variable Types', 1),
(5, 'Escape Characters', 1),
(6, 'Operators', 1),
(7, 'Basic Input / Output', 1);

-- --------------------------------------------------------

--
-- Table structure for table `performance`
--

DROP TABLE IF EXISTS `performance`;
CREATE TABLE IF NOT EXISTS `performance` (
  `performance` decimal(10,2) NOT NULL,
  `userID` int(10) NOT NULL,
  PRIMARY KEY (`performance`,`userID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `performance`
--

INSERT INTO `performance` (`performance`, `userID`) VALUES
('41.46', 2);

-- --------------------------------------------------------

--
-- Table structure for table `programming_language`
--

DROP TABLE IF EXISTS `programming_language`;
CREATE TABLE IF NOT EXISTS `programming_language` (
  `programming_language_ID` int(11) NOT NULL AUTO_INCREMENT,
  `programming_language_name` varchar(25) NOT NULL,
  `code_name` varchar(25) NOT NULL,
  PRIMARY KEY (`programming_language_ID`) USING BTREE,
  KEY `programming_language_ID` (`programming_language_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `programming_language`
--

INSERT INTO `programming_language` (`programming_language_ID`, `programming_language_name`, `code_name`) VALUES
(1, 'C++', 'C_PlusPlus'),
(2, 'JavaScript', 'JavaScript'),
(3, 'Ruby', 'Ruby'),
(4, 'SQL', 'SQL'),
(5, 'Java', 'Java'),
(6, 'Python', 'Python'),
(7, 'Swift', 'Swift'),
(8, 'Objective-C', 'ObjectiveC');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `questionID` int(10) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `option_A` varchar(50) NOT NULL,
  `option_B` varchar(50) NOT NULL,
  `option_C` varchar(50) NOT NULL,
  `option_D` varchar(50) NOT NULL,
  `choice_solution` varchar(1) DEFAULT NULL,
  `solution` varchar(500) NOT NULL,
  `moduleID` int(10) NOT NULL,
  `question_type` varchar(15) NOT NULL,
  `programming_language_ID` int(11) NOT NULL,
  PRIMARY KEY (`questionID`),
  KEY `moduleID` (`moduleID`),
  KEY `programming_language_ID` (`programming_language_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `description`, `option_A`, `option_B`, `option_C`, `option_D`, `choice_solution`, `solution`, `moduleID`, `question_type`, `programming_language_ID`) VALUES
(1, 'The following is an appropriate way to print a statement: cout << \"I love C++\";', 'True', 'False', '', '', 'A', 'TRUE', 1, 'True / False', 1),
(2, 'How do you create a block comment in c++?\r\n', '//', '/?', '**', '/*  */', 'D', '/*  */', 1, 'Multiple Choice', 1),
(3, 'The \'#\' is used for comments in c++', 'True', 'False', '', '', 'B', 'FALSE', 1, 'True / False', 1),
(4, ' All preprocessor directives in c++ begin with “!”.', 'True', 'False', '', '', 'B', 'FALSE', 2, 'True / False', 1),
(5, 'All preprocessor directives in c++ begin with “#”.', 'True', 'False', '', '', 'A', 'TRUE', 2, 'True / False', 1),
(6, 'The following is an appropriate way to initialize a variable as an integer.\r\n\r\n    int main() {\r\n        a = int;\r\n    }', 'True', 'False', '', '', 'B', 'FALSE', 3, 'True / False', 1),
(7, 'The following is an appropriate way to declare a variable as an int:\r\n\r\n    int main() {\r\n        int = a;\r\n    }', 'True', 'False', '', '', 'B', 'FALSE', 3, 'True / False', 1),
(8, 'The following is an appropriate way to declare a variable as an int: \r\n\r\n    int main() {\r\n        int a;\r\n        return 0;\r\n    } ', 'True', 'False', '', '', 'A', 'TRUE', 3, 'True / False', 1),
(9, 'The following is an appropriate way to declare and initialize a variable as an integer:\r\n\r\n    int main() {\r\n        int a = 5;\r\n    }', 'True', 'False', '', '', 'A', 'TRUE', 3, 'True / False', 1),
(10, 'The two following codes are equivalent:\r\n    \r\n    Code snippet 1: double a, b, c;\r\n   \r\n    Code snippet 2: \r\n                    double a;\r\n                    double b;\r\n                    double c;', 'True', 'False', '', '', 'A', 'TRUE', 3, 'True / False', 1),
(11, 'Which of the following is the appropriate variable type to use with the word \"float\" ?', 'Word', 'Char', 'String', 'FLoat', 'C', 'String', 4, 'Multiple Choice', 1),
(12, 'What is the correct statement ending character in c++?', ':', '#', '/', ';', 'D', ';', 4, 'Multiple Choice', 1),
(13, 'The following code will print Arnold Schwarzenegger to the screen:\r\n\r\n    #include <iostream>\r\n    #include <string>\r\n    using namespace std;\r\n    \r\n    int main () {\r\n        string name;\r\n        name = \"Arnold Schwarzenegger\";\r\n        cout << name;\r\n        return 0;\r\n    }', 'True', 'False', '', '', 'A', 'TRUE', 4, 'True / False', 1),
(14, 'What will be the output of the following C++ code?\r\n\r\n     #include <iostream>\r\n     using namespace std;\r\n     int main() {\r\n         int i, j;\r\n         j = 10;\r\n         i = (j++, j + 100, 999 + j);\r\n         cout << i;\r\n         return 0;\r\n     }', '1000', '11', '1010', '1001', 'C', '1010', 6, 'Multiple Choice', 1),
(15, 'What will be the output of the following C++ code?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n    int main () {\r\n        int n;\r\n\r\n        for (n = 5; n > 0; n--) {\r\n           cout << n;\r\n           if (n == 3) break;\r\n        }\r\n        \r\n        return 0;\r\n    }', '543', '54', '5432', '53', 'A', '543', 6, 'Multiple Choice', 1),
(16, 'What will be the output of the following C++ code?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n\r\n        int main() {\r\n            int i;\r\n\r\n            for (i = 0; i < 10; i++) {\r\n                cout << i;\r\n           }\r\n        \r\n           return 0;\r\n    }', '0123456789', '10', '012345678910', 'compile time error', 'A', '0123456789', 6, 'Multiple Choice', 1),
(17, 'The following code snippet will produce this result. \r\n\r\n    Code snippet:  cout << “a\\nb\\nc”;\r\n\r\n    Result:\r\n            a\r\n            b\r\n            c', 'True', 'False', '', '', 'A', 'TRUE', 5, 'True / False', 1),
(18, 'Assigning a variable in c++ can be done using which of the following operators?', '*', '==', '//', '=', 'D', '=', 6, 'Multiple Choice', 1),
(19, 'What is the result of the following cout statement?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n\r\n        int main () {\r\n            int a = 5;\r\n            a+=3;        \r\n            cout << a;\r\n        }', 'Error', '5', '3', '8', 'D', '8', 7, 'Multiple Choice', 1),
(20, 'Which of the following are the correct way(s) of incrementing the variable x by 1.  Assume the variable stores an integer value: ', 'x += 1;', '++x;', 'x = x + 1;', 'All of the above', 'D', 'All of the above', 6, 'Multiple Choice', 1),
(21, 'The operators ‘=’ and ‘==’ have the same meaning in c++.', 'True', 'False', '', '', 'B', 'FALSE', 6, 'True / False', 1),
(22, '‘!=’ is an example of what type of operator?', 'Arithmetic', 'Assignment', 'Compound Assignment', 'Relational', 'D', 'Relational', 6, 'Multiple Choice', 1),
(23, '‘||’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true.', 'True', 'False', '', '', 'B', 'FALSE', 6, 'True / False', 1),
(24, '‘&&’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true.', 'True', 'False', '', '', 'A', 'TRUE', 6, 'True / False', 1),
(25, '‘||’ corresponds to the boolean (logical) operator OR, which yields true if either of its operands are true.', 'True', 'False', '', '', 'A', 'TRUE', 6, 'True / False', 1),
(26, 'The preprocessor directive that allows for standard input and output is: #include iostream', 'True', 'False', '', '', 'B', 'FALSE', 2, 'True / False', 1),
(27, 'The preprocessor directive that allows for standard input and output is: #include <iostream>', 'True', 'False', '', '', 'A', 'TRUE', 2, 'True / False', 1),
(28, 'Which of the following is the insertion operator?', '>>', '==', '<<', '\\\\', 'C', '<<', 7, 'Multiple Choice', 1),
(29, 'Which of the following is the extraction operator?\r\n', '>>', '==', '<<', '\\\\', 'A', '>>', 7, 'Multiple Choice', 1),
(30, 'The extraction operator is used with the standard input “cin”', 'True', 'False', '', '', 'A', 'TRUE', 7, 'True / False', 1),
(31, 'The insertion operator is used with the standard input “cin”', 'True', 'False', '', '', 'B', 'FALSE', 7, 'True / False', 1),
(32, 'The following code correctly accepts a user entered value into the string “hobby” and prints “Your favorite hobby is” followed by the hobby entered by the user:\r\n\r\n    #include <iostream>\r\n    #include <string>\r\n    using namespace std;\r\n\r\n    int main () {\r\n        string hobby ;\r\n        cout << \"Please enter your favorite hobby: \";\r\n        cin >> hobby;\r\n        cout << \"Your favorite hobby is “ << hobby;\r\n        return 0;\r\n    }', 'True', 'False', '', '', 'A', 'TRUE', 7, 'True / False', 1),
(33, 'When a loop is nested inside another loop, a break or continue statement terminates or restarts the outermost loop of the nested loop structure.', 'True', 'False', '', '', 'B', 'FALSE', 1, 'True / False', 1),
(34, 'Which of the following determines the operator that is processed prior to another operator? ', 'Operator associativity', 'Operator precedence', 'Whether the operator is an arithmetic operator', 'None of the Above', 'C', 'Whether the operator is an arithmetic operator', 1, 'Multiple Choice', 1),
(35, 'A switch statement must have:', 'Default case', 'More than one non-default case', 'A break statement', 'None of the above', 'D', 'None of the above', 1, 'Multiple Choice', 1),
(36, 'Which of the following is used as the escape character when printing a line:', '\'/\'', '\'\\\'', '\'|\'', '\'//\'', 'B', '\'\\\'', 5, 'Multiple Choice', 1),
(37, 'Generating a new line in c++ can be done using:', '/n', '\\n', '‘/n’', '‘\\n’', 'D', '‘\\n’', 5, 'Multiple Choice', 1);

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
-- Stand-in structure for view `question_module_language`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `question_module_language`;
CREATE TABLE IF NOT EXISTS `question_module_language` (
`questionID` int(10)
,`description` varchar(500)
,`choice_solution` varchar(1)
,`solution` varchar(500)
,`moduleID` int(10)
,`question_type` varchar(15)
,`programming_language_ID` int(11)
,`moduleName` varchar(50)
,`programming_language_name` varchar(25)
);

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
  `scoreID` int(11) NOT NULL AUTO_INCREMENT,
  `score` decimal(10,2) NOT NULL,
  `userID` int(10) NOT NULL,
  `moduleID` int(10) NOT NULL,
  `programming_language_ID` int(11) NOT NULL,
  `numberOfCorrectAnswers` int(11) NOT NULL,
  `numberOfIncorrectAnswers` int(11) NOT NULL,
  `totalNumberOfAnswers` int(11) NOT NULL,
  PRIMARY KEY (`scoreID`,`score`,`userID`,`moduleID`,`programming_language_ID`) USING BTREE,
  KEY `programming_language_ID` (`programming_language_ID`),
  KEY `moduleID` (`moduleID`),
  KEY `userID` (`userID`),
  KEY `score` (`score`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`scoreID`, `score`, `userID`, `moduleID`, `programming_language_ID`, `numberOfCorrectAnswers`, `numberOfIncorrectAnswers`, `totalNumberOfAnswers`) VALUES
(1, '16.67', 2, 1, 1, 1, 5, 6),
(2, '33.33', 2, 1, 1, 2, 4, 6),
(3, '83.33', 2, 1, 1, 5, 1, 6),
(4, '16.67', 2, 1, 1, 1, 5, 6),
(5, '33.33', 2, 1, 1, 2, 4, 6),
(6, '83.33', 2, 1, 1, 5, 1, 6),
(7, '50.00', 2, 1, 1, 3, 3, 6),
(8, '16.66', 2, 1, 1, 1, 5, 6),
(11, '33.33', 2, 1, 1, 2, 4, 6),
(13, '0.00', 2, 1, 1, 0, 6, 6),
(14, '33.33', 2, 1, 1, 2, 4, 6),
(15, '33.33', 2, 1, 1, 2, 4, 6),
(16, '33.33', 2, 1, 1, 2, 4, 6),
(17, '33.33', 2, 1, 1, 2, 4, 6),
(18, '50.00', 2, 1, 1, 3, 3, 6),
(19, '16.67', 2, 1, 1, 1, 5, 6),
(20, '33.33', 2, 1, 1, 2, 4, 6),
(21, '16.67', 2, 1, 1, 1, 5, 6),
(22, '50.00', 2, 1, 1, 3, 3, 6),
(23, '66.67', 2, 1, 1, 4, 2, 6),
(24, '33.33', 2, 1, 1, 2, 4, 6),
(25, '66.67', 2, 1, 1, 4, 2, 6),
(26, '50.00', 2, 1, 1, 3, 3, 6),
(27, '50.00', 2, 1, 1, 3, 3, 6),
(28, '50.00', 2, 1, 1, 3, 3, 6),
(29, '50.00', 2, 1, 1, 3, 3, 6),
(30, '33.33', 2, 1, 1, 2, 4, 6),
(31, '50.00', 2, 1, 1, 3, 3, 6),
(32, '66.67', 2, 1, 1, 4, 2, 6),
(33, '66.67', 2, 1, 1, 4, 2, 6),
(35, '33.33', 2, 1, 1, 2, 4, 6),
(36, '50.00', 2, 1, 1, 3, 3, 6),
(37, '50.00', 2, 1, 1, 3, 3, 6),
(38, '16.67', 2, 1, 1, 1, 5, 6),
(39, '66.67', 2, 1, 1, 4, 2, 6),
(40, '50.00', 2, 1, 1, 3, 3, 6),
(41, '50.00', 2, 1, 1, 3, 3, 6),
(44, '33.33', 2, 1, 1, 2, 4, 6),
(46, '50.00', 2, 1, 1, 3, 3, 6),
(50, '0.00', 2, 5, 1, 0, 3, 3),
(51, '33.33', 0, 5, 1, 1, 2, 3),
(52, '50.00', 2, 2, 1, 2, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token` char(36) DEFAULT NULL,
  `user_type` enum('User','Admin') NOT NULL DEFAULT 'User',
  `user_status` bit(1) NOT NULL DEFAULT b'1',
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `createdOn`, `token`, `user_type`, `user_status`, `firstName`, `lastName`, `email`, `username`, `password`) VALUES
(1, '2020-03-30 17:17:55', 'c06ea589-d704-4a96-831c-3ba4755f50bc', 'User', b'1', 'Beatriz', '', 'beatrizcangas41@gmail.com', 'beatriz', '$2a$10$X9NvMsPcL/1jVeDHcYC5AeTfnMU5o/e94d0qlhaXVRpTpOReDmzx.'),
(2, '2020-04-04 19:30:55', '4142842d-24ce-411d-8359-15d66490143c', 'User', b'1', 'asdf', '', 'beatrizcangas41@gmail.com', 'asdf', '$2a$10$rrYpRY8DEbZttOIDPbteDOwt/I2pw5imlnHlz/uDMEh7yQct4nwvy');

-- --------------------------------------------------------

--
-- Stand-in structure for view `user_module_score`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `user_module_score`;
CREATE TABLE IF NOT EXISTS `user_module_score` (
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `user_score_performance`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `user_score_performance`;
CREATE TABLE IF NOT EXISTS `user_score_performance` (
);

-- --------------------------------------------------------

--
-- Structure for view `question_module`
--
DROP TABLE IF EXISTS `question_module`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `question_module`  AS  select `question`.`questionID` AS `questionID`,`question`.`description` AS `description`,`question`.`choice_solution` AS `choice_solution`,`question`.`solution` AS `solution`,`question`.`moduleID` AS `moduleID`,`module`.`moduleName` AS `moduleName` from (`question` join `module` on((`question`.`moduleID` = `module`.`moduleID`))) ;

-- --------------------------------------------------------

--
-- Structure for view `question_module_language`
--
DROP TABLE IF EXISTS `question_module_language`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `question_module_language`  AS  select `q`.`questionID` AS `questionID`,`q`.`description` AS `description`,`q`.`choice_solution` AS `choice_solution`,`q`.`solution` AS `solution`,`q`.`moduleID` AS `moduleID`,`q`.`question_type` AS `question_type`,`q`.`programming_language_ID` AS `programming_language_ID`,`m`.`moduleName` AS `moduleName`,`pl`.`programming_language_name` AS `programming_language_name` from ((`question` `q` join `module` `m` on((`q`.`moduleID` = `m`.`moduleID`))) join `programming_language` `pl` on((`q`.`programming_language_ID` = `pl`.`programming_language_ID`))) ;

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

--
-- Constraints for dumped tables
--

--
-- Constraints for table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `module_ibfk_1` FOREIGN KEY (`programming_language_ID`) REFERENCES `programming_language` (`programming_language_ID`);

--
-- Constraints for table `performance`
--
ALTER TABLE `performance`
  ADD CONSTRAINT `performance_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`moduleID`) REFERENCES `module` (`moduleID`),
  ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`programming_language_ID`) REFERENCES `programming_language` (`programming_language_ID`);

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `score_ibfk_2` FOREIGN KEY (`moduleID`) REFERENCES `module` (`moduleID`),
  ADD CONSTRAINT `score_ibfk_3` FOREIGN KEY (`programming_language_ID`) REFERENCES `programming_language` (`programming_language_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
