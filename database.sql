-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  Dim 16 déc. 2018 à 13:49
-- Version du serveur :  5.6.38
-- Version de PHP :  7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `cinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `actor`
--

CREATE TABLE `actor` (
  `id` int(11) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `id_film` smallint(5) UNSIGNED DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `death_date` date DEFAULT NULL,
  `url_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `actor`
--

INSERT INTO `actor` (`id`, `last_name`, `first_name`, `id_film`, `birth_date`, `death_date`, `url_image`) VALUES
(1, 'Reno', 'Jean', 1, '1948-07-30', NULL, 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/cdsN5efCYGQWlPrj7vFlZRBTR16.jpg'),
(5, 'Portman', 'Natalie', 1, '1981-06-09', NULL, 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/jJcRWku3e9OHrmRqytn6WcBjhvh.jpg'),
(7, 'Dujardin', 'Jean', 3, '1972-06-19', NULL, 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/fpNJxVL3I4atLSmWJqmVzDR4TWI.jpg'),
(8, 'Bourvil', '', 2, '1917-07-27', '1970-09-23', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/6fX9Tw5NSW5yPTonQ5s4iYdMRKg.jpg'),
(12, 'De Funes', 'Louis', 2, '1914-07-31', '1983-01-27', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/bT8NZYM28Qdyb2fc48vFfMaPgTo.jpg'),
(13, 'Anglade', 'Jean-Hugues', 1, '1955-07-29', NULL, 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/iy8Tfcb3Zq1INu1kGm069wccRev.jpg'),
(15, 'Lambert', 'Christophe', 2, '1957-03-29', NULL, 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/qKmxieTgzvsA5hSA7w1VoHizmmE.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` varchar(2) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
('AC', 'Action'),
('CO', 'Comédie'),
('DR', 'Drame'),
('PO', 'Policier'),
('WE', 'Western');

-- --------------------------------------------------------

--
-- Structure de la table `director`
--

CREATE TABLE `director` (
  `id` int(2) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `director`
--

INSERT INTO `director` (`id`, `first_name`, `last_name`) VALUES
(1, 'Oury', 'GÃ©rard'),
(2, 'Chabrol', 'Claude'),
(3, 'Besson', 'Luc'),
(4, 'Besnard', 'Eric');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `title` varchar(30) NOT NULL,
  `duration` int(3) NOT NULL,
  `release_date` date DEFAULT NULL,
  `budget` int(8) DEFAULT NULL,
  `revenue` int(8) DEFAULT NULL,
  `id_director` int(2) DEFAULT NULL,
  `id_category` varchar(2) DEFAULT NULL,
  `url_image` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`id`, `title`, `duration`, `release_date`, `budget`, `revenue`, `id_director`, `id_category`, `url_image`) VALUES
(1, 'Léon', 110, '1994-09-14', 17531000, 69250000, 3, 'PO', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/gbw7Tm7SUyiTMhI2B8yHk4OcT9I.jpg'),
(2, 'Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/4Lwmsz1qQ0fNBLf5KBBrlzsozee.jpg'),
(3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/kXBawoZ7QsNV7rt4IZEks3dYxOU.jpg'),
(4, 'Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/20dB0FrgphqUjqn55Bf5wO0qt8O.jpg'),
(11, 'titre', 22, '2018-11-08', 100, 100, 1, 'AC', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/wLuuLs2xxmU3Wbiql4O7raP81C8.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `film_actor`
--

CREATE TABLE `film_actor` (
  `id_film` smallint(5) UNSIGNED NOT NULL DEFAULT '0',
  `id_actor` int(4) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film_actor`
--

INSERT INTO `film_actor` (`id_film`, `id_actor`, `name`) VALUES
(1, 1, 'LÃ©on'),
(1, 5, 'Mathilda'),
(2, 1, 'Maxime Dubreuil'),
(2, 7, 'Cash'),
(3, 8, 'Augustin Bouvet'),
(3, 12, 'Stanislas Lefort'),
(4, 1, 'Le Batteur'),
(4, 13, 'Le Roller'),
(4, 15, 'Fred');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_film` (`id_film`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `NoRea` (`id_director`),
  ADD KEY `CodeCat` (`id_category`);

--
-- Index pour la table `film_actor`
--
ALTER TABLE `film_actor`
  ADD PRIMARY KEY (`id_film`,`id_actor`),
  ADD KEY `NoFilm` (`id_film`),
  ADD KEY `NoAct` (`id_actor`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `actor`
--
ALTER TABLE `actor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`id_director`) REFERENCES `director` (`id`),
  ADD CONSTRAINT `film_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);
