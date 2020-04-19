-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 19, 2020 at 05:29 AM
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
  PRIMARY KEY (`moduleID`,`moduleName`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  `performance` double NOT NULL,
  `userID` int(10) NOT NULL,
  PRIMARY KEY (`performance`,`userID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `programming_language`
--

DROP TABLE IF EXISTS `programming_language`;
CREATE TABLE IF NOT EXISTS `programming_language` (
  `programming_language_ID` int(11) NOT NULL AUTO_INCREMENT,
  `programming_language_name` varchar(25) NOT NULL,
  `code_name` varchar(25) NOT NULL,
  PRIMARY KEY (`programming_language_ID`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `programming_language`
--

INSERT INTO `programming_language` (`programming_language_ID`, `programming_language_name`, `code_name`) VALUES
(1, 'C++', 'C_PlusPlus'),
(2, 'JavaScript', 'JavaScript'),
(3, 'Ruby', 'Ruby'),
(4, 'SQL', 'SQL'),
(6, 'Python', 'Python'),
(7, 'Swift', 'Swift'),
(8, 'Objective-C', 'ObjectiveC'),
(5, 'Java', 'Java');

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
  `programming_language_ID` int(11) NOT NULL,
  PRIMARY KEY (`questionID`),
  KEY `moduleID` (`moduleID`),
  KEY `programming_language_ID` (`programming_language_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `description`, `choice_solution`, `solution`, `moduleID`, `question_type`, `programming_language_ID`) VALUES
(1, 'The following is an appropriate way to print a statement: cout << \"I love C++\";\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 1, 'True / False', 1),
(8, 'The following is an appropriate way to declare a variable as an int: \r\n\r\n    int main() {\r\n        int a;\r\n        return 0;\r\n    } \r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 3, 'True / False', 1),
(9, 'The following is an appropriate way to declare and initialize a variable as an integer:\r\n\r\nint main() {\r\n    int a = 5;\r\n}\r\n\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 3, 'True / False', 1),
(10, 'The two following codes are equivalent:\r\n    \r\n   Code 1: double a, b, c;\r\n   \r\n   Code 2: \r\n           double a;\r\n           double b;\r\n           double c;\r\n\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 3, 'True / False', 1),
(11, 'Which of the following is the appropriate variable type to use with the word \"float\" ? \r\n\r\n        a. Word                                                       \r\n        b. Char\r\n        c. String\r\n        d. Float', 'C', 'String', 4, 'Multiple Choice', 1),
(7, 'The following is an appropriate way to declare a variable as an int:\r\n\r\n    int main() {\r\n        int = a;\r\n    }\r\n\r\n    a. TRUE\r\n    b. FALSE', 'B', 'FALSE', 3, 'True / False', 1),
(12, 'What is the correct statement ending character in c++?\r\n    a. :\r\n    b. #\r\n    c. /\r\n    d. ;', 'D', ';', 4, 'Multiple Choice', 1),
(13, 'The following code will print Arnold Schwarzenegger to the screen:\r\n\r\n    #include <iostream>\r\n    #include <string>\r\n    using namespace std;\r\n    \r\n    int main () {\r\n        string name;\r\n        name = \"Arnold Schwarzenegger\";\r\n        cout << name;\r\n        return 0;\r\n    }\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 4, 'True / False', 1),
(14, 'What will be the output of the following C++ code?\r\n\r\n     #include <iostream>\r\n     using namespace std;\r\n     int main() {\r\n         int i, j;\r\n         j = 10;\r\n         i = (j++, j + 100, 999 + j);\r\n         cout << i;\r\n         return 0;\r\n     }\r\n\r\n    a. 1000\r\n    b. 11\r\n    c. 1010\r\n    d. 1001\r\n', 'C', '1010', 6, 'Multiple Choice', 1),
(15, 'What will be the output of the following C++ code?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n    int main () {\r\n        int n;\r\n\r\n        for (n = 5; n > 0; n--) {\r\n           cout << n;\r\n           if (n == 3) break;\r\n        }\r\n        \r\n        return 0;\r\n    }\r\n\r\n    a. 543\r\n    b. 54\r\n    c. 5432\r\n    d. 53\r\n', 'A', '543', 6, 'Multiple Choice', 1),
(16, 'What will be the output of the following C++ code?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n\r\n        int main() {\r\n            int i;\r\n\r\n            for (i = 0; i < 10; i++) {\r\n                cout << i;\r\n           }\r\n        \r\n           return 0;\r\n    }\r\n\r\n    a. 0123456789\r\n    b. 10\r\n    c. 012345678910\r\n    d. compile time error\r\n', 'A', '0123456789', 6, 'Multiple Choice', 1),
(17, 'The following code snippet will produce this result. \r\n\r\n    Code snippet:  cout << “a\\nb\\nc”;\r\n\r\n    Result:\r\n\r\n        a\r\n        b\r\n        c\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 5, 'True / False', 1),
(18, 'Assigning a variable in c++ can be done using which of the following operators?\r\n\r\n    a. +\r\n    b. ==\r\n    c. //\r\n    d. =', 'D', '=', 6, 'Multiple Choice', 1),
(19, 'What is the result of the following cout statement?\r\n\r\n    #include <iostream>\r\n    using namespace std;\r\n\r\n        int main () {\r\n            int a = 5;\r\n            a+=3;        \r\n            cout << a;\r\n        }\r\n\r\n    a. Error\r\n    b. 5\r\n    c. 3\r\n    d. 8\r\n', 'D', '8', 7, 'Multiple Choice', 1),
(20, 'Which of the following are the correct way(s) of incrementing the variable x by 1.  Assume the variable stores an integer value: \r\n\r\n    a. x += 1;\r\n    b. ++x;\r\n    c. x = x + 1;\r\n    d. All of the above\r\n', 'D', 'All of the above', 6, 'Multiple Choice', 1),
(21, 'The operators ‘=’ and ‘==’ have the same meaning in c++:\r\n\r\n    a. TRUE\r\n    b. FALSE', 'B', 'FALSE', 6, 'True / False', 1),
(22, '‘!=’ is an example of what type of operator?\r\n\r\n    a. Arithmetic\r\n    b. Assignment\r\n    c. Compound Assignment\r\n    d. Relational\r\n', 'D', 'Relational', 6, 'Multiple Choice', 1),
(23, '‘||’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true:\r\n \r\n    a. TRUE\r\n    b. FALSE\r\n', 'B', 'FALSE', 6, 'True / False', 1),
(24, '‘&&’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true:\r\n \r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 6, 'True / False', 1),
(25, '‘||’ corresponds to the boolean (logical) operator OR, which yields true if either of its operands are true:\r\n \r\n    a. TRUE  \r\n    b. FALSE\r\n', 'A', 'TRUE', 6, 'True / False', 1),
(26, 'The preprocessor directive that allows for standard input and output is:\r\n\r\n    #include iostream\r\n\r\n    a. TRUE \r\n    b. FALSE\r\n', 'B', 'FALSE', 2, 'True / False', 1),
(27, 'The preprocessor directive that allows for standard input and output is:\r\n\r\n    #include <iostream>\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 2, 'True / False', 1),
(28, 'Which of the following is the insertion operator?\r\n\r\n    a. >>\r\n    b. ==\r\n    c. <<\r\n    d. \\\\\r\n', 'C', '<<', 7, 'Multiple Choice', 1),
(29, 'Which of the following is the extraction operator?\r\n\r\n    a. >>\r\n    b. ==\r\n    c. <<\r\n    d. \\\\\r\n', 'A', '>>', 7, 'Multiple Choice', 1),
(30, 'The extraction operator is used with the standard input “cin”:\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'A', 'TRUE', 7, 'True / False', 1),
(31, 'The insertion operator is used with the standard input “cin”:\r\n\r\n    a. TRUE\r\n    b. FALSE\r\n', 'B', 'FALSE', 7, 'True / False', 1),
(32, 'The following code correctly accepts a user entered value into the string “hobby” and prints “Your favorite hobby is” followed by the hobby entered by the user:\r\n\r\n    #include <iostream>\r\n    #include <string>\r\n    using namespace std;\r\n\r\n    int main () {\r\n        string hobby ;\r\n        cout << \"Please enter your favorite hobby: \";\r\n        cin >> hobby;\r\n        cout << \"Your favorite hobby is “ << hobby;\r\n        return 0;\r\n    }\r\n\r\n    a. TRUE\r\n    b. FALSE', 'A', 'TRUE', 7, 'True / False', 1),
(2, 'How do you create a block comment in c++?\r\n    a. //\r\n    b. /?\r\n    c. **\r\n    d. /*  */\r\n', 'D', '/*  */', 1, 'Multiple Choice', 1),
(3, 'The \'#\' is used for comments in c++\r\n    a. T\r\n    b. F', 'B', 'FALSE', 1, 'True / False', 1),
(34, 'Which of the following determines the operator that is processed prior to another operator? \r\n    a. Operator associativity \r\n    b. Operator precedence \r\n    c. Whether the operator is an arithmetic operator\r\n    d. None of these determine the order in which operators are processed', 'C', 'Whether the operator is an arithmetic operator', 1, 'Multiple Choice', 1),
(33, 'When a loop is nested inside another loop, a break or continue statement terminates or restarts the outermost loop of the nested loop structure.\r\n    a. T\r\n    b. F', 'B', 'FALSE', 1, 'True / False', 1),
(35, 'A switch statement must have\r\n    a. Default case \r\n    b. More than one non-default case\r\n    c. A break statement \r\n    d. None of the above', 'D', 'None of the above', 1, 'Multiple Choice', 1),
(4, ' All preprocessor directives in c++ begin with “!”.\r\n    a. True\r\n    b. False\r\n', 'B', 'FALSE', 2, 'True / False', 1),
(5, 'All preprocessor directives in c++ begin with “#”.\r\n    a. True\r\n    b. False\r\n', 'A', 'TRUE', 2, 'True / False', 1),
(6, 'The following is an appropriate way to initialize a variable as an integer.\r\n\r\n    int main() {\r\n        a = int;\r\n    }\r\n\r\n    a. True\r\n    b. False', 'B', 'FALSE', 3, 'True / False', 1),
(36, 'Which of the following is used as the escape character when printing a line:\r\n    \r\n    a. \'/\'\r\n    b. \'\\\'\r\n    c. \'|\'\r\n    d. \'//\'', 'B', '\'\\\'', 5, 'Multiple Choice', 1),
(37, 'Generating a new line in c++ can be done using:\r\n\r\n    a. /n\r\n    b. \\n\r\n    c. ‘/n’\r\n    d. ‘\\n’', 'D', '‘\\n’', 5, 'Multiple Choice', 1);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
