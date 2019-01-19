{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf200
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- phpMyAdmin SQL Dump\
-- version 4.8.3\
-- https://www.phpmyadmin.net/\
--\
-- Host: localhost:3306\
-- Generation Time: Jan 18, 2019 at 12:58 PM\
-- Server version: 5.7.23\
-- PHP Version: 7.2.10\
\
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";\
SET time_zone = "+00:00";\
\
--\
-- Database: `cinema`\
--\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `actor`\
--\
\
CREATE TABLE `actor` (\
  `id` int(11) NOT NULL,\
  `last_name` varchar(20) NOT NULL,\
  `first_name` varchar(20) DEFAULT NULL,\
  `id_film` smallint(5) UNSIGNED DEFAULT NULL,\
  `birth_date` date DEFAULT NULL,\
  `death_date` date DEFAULT NULL,\
  `url_image` varchar(100) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=latin1;\
\
--\
-- Dumping data for table `actor`\
--\
\
INSERT INTO `actor` (`id`, `last_name`, `first_name`, `id_film`, `birth_date`, `death_date`, `url_image`) VALUES\
(7, 'Dujardin', 'Jean', 3, '1972-06-19', NULL, 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/fpNJxVL3I4atLSmWJqmVzDR4TWI.jpg'),\
(8, 'Bourvil', '', 2, '1917-07-27', '1970-09-23', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/6fX9Tw5NSW5yPTonQ5s4iYdMRKg.jpg'),\
(12, 'De Funes', 'Louis', 2, '1914-07-31', '1983-01-27', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/bT8NZYM28Qdyb2fc48vFfMaPgTo.jpg'),\
(15, 'Lambert', 'Christophe', 2, '1957-03-29', NULL, 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/qKmxieTgzvsA5hSA7w1VoHizmmE.jpg');\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `category`\
--\
\
CREATE TABLE `category` (\
  `id` varchar(2) NOT NULL,\
  `name` varchar(20) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=latin1;\
\
--\
-- Dumping data for table `category`\
--\
\
INSERT INTO `category` (`id`, `name`) VALUES\
('AC', 'Action'),\
('CO', 'Com\'e9die'),\
('DR', 'Drame'),\
('PO', 'Policier'),\
('WE', 'Western');\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `director`\
--\
\
CREATE TABLE `director` (\
  `id` int(2) NOT NULL,\
  `first_name` varchar(20) NOT NULL,\
  `last_name` varchar(20) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=latin1;\
\
--\
-- Dumping data for table `director`\
--\
\
INSERT INTO `director` (`id`, `first_name`, `last_name`) VALUES\
(1, 'Oury', 'G\'c3\'a9rard'),\
(2, 'Chabrol', 'Claude'),\
(3, 'Besson', 'Luc'),\
(4, 'Besnard', 'Eric');\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `film`\
--\
\
CREATE TABLE `film` (\
  `id` int(11) NOT NULL,\
  `title` varchar(30) NOT NULL,\
  `duration` int(3) NOT NULL,\
  `release_date` date DEFAULT NULL,\
  `budget` int(8) DEFAULT NULL,\
  `revenue` int(8) DEFAULT NULL,\
  `id_director` int(2) DEFAULT NULL,\
  `id_category` varchar(2) DEFAULT NULL,\
  `url_image` varchar(100) DEFAULT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=latin1;\
\
--\
-- Dumping data for table `film`\
--\
\
INSERT INTO `film` (`id`, `title`, `duration`, `release_date`, `budget`, `revenue`, `id_director`, `id_category`, `url_image`) VALUES\
(2, 'Cash', 100, '2008-04-18', 18340000, 60340000, 4, 'PO', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/4Lwmsz1qQ0fNBLf5KBBrlzsozee.jpg'),\
(3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/kXBawoZ7QsNV7rt4IZEks3dYxOU.jpg'),\
(4, 'Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/20dB0FrgphqUjqn55Bf5wO0qt8O.jpg');\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `film_actor`\
--\
\
CREATE TABLE `film_actor` (\
  `id_film` smallint(5) UNSIGNED NOT NULL DEFAULT '0',\
  `id_actor` int(4) NOT NULL,\
  `name` varchar(30) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=latin1;\
\
--\
-- Dumping data for table `film_actor`\
--\
\
INSERT INTO `film_actor` (`id_film`, `id_actor`, `name`) VALUES\
(2, 7, 'Cash'),\
(3, 8, 'Augustin Bouvet'),\
(3, 12, 'Stanislas Lefort'),\
(4, 15, 'Fred');\
\
--\
-- Indexes for dumped tables\
--\
\
--\
-- Indexes for table `actor`\
--\
ALTER TABLE `actor`\
  ADD PRIMARY KEY (`id`),\
  ADD KEY `fk_id_film` (`id_film`);\
\
--\
-- Indexes for table `category`\
--\
ALTER TABLE `category`\
  ADD PRIMARY KEY (`id`);\
\
--\
-- Indexes for table `director`\
--\
ALTER TABLE `director`\
  ADD PRIMARY KEY (`id`);\
\
--\
-- Indexes for table `film`\
--\
ALTER TABLE `film`\
  ADD PRIMARY KEY (`id`),\
  ADD KEY `NoRea` (`id_director`),\
  ADD KEY `CodeCat` (`id_category`);\
\
--\
-- Indexes for table `film_actor`\
--\
ALTER TABLE `film_actor`\
  ADD PRIMARY KEY (`id_film`,`id_actor`),\
  ADD KEY `NoFilm` (`id_film`),\
  ADD KEY `NoAct` (`id_actor`);\
\
--\
-- AUTO_INCREMENT for dumped tables\
--\
\
--\
-- AUTO_INCREMENT for table `actor`\
--\
ALTER TABLE `actor`\
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;\
\
--\
-- AUTO_INCREMENT for table `film`\
--\
ALTER TABLE `film`\
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;\
\
--\
-- Constraints for dumped tables\
--\
\
--\
-- Constraints for table `film`\
--\
ALTER TABLE `film`\
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`id_director`) REFERENCES `director` (`id`),\
  ADD CONSTRAINT `film_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);\
}