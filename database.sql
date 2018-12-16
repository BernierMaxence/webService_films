-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  Dim 16 déc. 2018 à 13:28
-- Version du serveur :  5.6.38
-- Version de PHP :  7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `cinema`
--

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
(1, 1, 'Léon'),
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
-- Index pour la table `film_actor`
--
ALTER TABLE `film_actor`
  ADD PRIMARY KEY (`id_film`,`id_actor`),
  ADD KEY `NoFilm` (`id_film`),
  ADD KEY `NoAct` (`id_actor`);
