-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Gegenereerd op: 13 jan 2015 om 13:27
-- Serverversie: 5.6.21
-- PHP-versie: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `jukebox`
--

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `album`
--

INSERT INTO `album` (`artistID`, `albumID`, `albumname`) VALUES
(1, 1, 'Hellbound'),
(2, 2, 'The Ultimate Best of Johnny Cash'),
(3, 3, 'The very best of volume 1'),
(4, 4, 'The very best of volume 1'),
(4, 5, 'The very best of volume 2'),
(5, 6, 'Dusk to Dawn');

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `artist`
--

INSERT INTO `artist` (`artistID`, `artistName`) VALUES
(1, 'The Living End'),
(2, 'Johnny Cash'),
(3, 'The Golden Earring'),
(4, 'Golden Earring'),
(5, 'Emancipation');

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `playlist`
--

INSERT INTO `playlist` (`playlistID`, `name`, `userID`) VALUES
(1, 'Good Rock', 7),
(2, 'Old but gold', 7),
(3, 'My list', 5);

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `rating`
--

INSERT INTO `rating` (`rating`, `userID`, `trackID`) VALUES
(3, 3, 1),
(2, 3, 2),
(5, 3, 3),
(4, 3, 4),
(4, 3, 5),
(4, 3, 6),
(4, 3, 7),
(5, 3, 8),
(2, 3, 9),
(4, 3, 10),
(4, 3, 11),
(3, 3, 12),
(4, 3, 13),
(5, 3, 14),
(5, 3, 15),
(5, 3, 16),
(1, 5, 1),
(2, 5, 2),
(5, 5, 3),
(2, 5, 4),
(1, 5, 5),
(5, 5, 6),
(3, 5, 7),
(2, 5, 8),
(3, 5, 9),
(5, 5, 10),
(4, 5, 11),
(2, 5, 12),
(3, 5, 13),
(4, 5, 14),
(5, 5, 15),
(5, 5, 16),
(2, 7, 1),
(4, 7, 2),
(5, 7, 3),
(2, 7, 4),
(4, 7, 5),
(4, 7, 6),
(3, 7, 7),
(5, 7, 8),
(4, 7, 9),
(5, 7, 10),
(4, 7, 11),
(4, 7, 12),
(4, 7, 13),
(5, 7, 14),
(3, 7, 15),
(2, 7, 16);

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `track`
--

INSERT INTO `track` (`trackID`, `artistID`, `title`, `duration`) VALUES
(1, 1, 'Trace of Doubt', '00:03:23'),
(2, 1, 'Hellbound', '00:03:23'),
(3, 1, 'Tabletop Show', '00:03:23'),
(4, 1, 'The Living End', '00:03:23'),
(5, 1, 'Strange', '00:03:23'),
(6, 1, 'Hedlines', '00:03:23'),
(7, 1, 'Mispent Youth', '00:03:23'),
(8, 1, 'So Lonely', '00:03:23'),
(9, 2, 'Hurt', '00:03:23'),
(10, 2, 'I Walk the Line', '00:03:23'),
(11, 3, 'Another 45 miles', '00:03:23'),
(12, 4, 'Radar love', '00:03:23'),
(13, 4, 'Bombay', '00:03:23'),
(14, 4, 'When the lady smiles', '00:03:23'),
(15, 5, 'Valhalla', '00:03:23'),
(16, 5, 'Outlaw', '00:03:23');

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `tracklocation`
--

INSERT INTO `tracklocation` (`trackID`, `path`) VALUES
(1, '/MusicLibrary/1/1/1.mp3'),
(2, '/MusicLibrary/1/1/2.mp3'),
(3, '/MusicLibrary/1/1/3.mp3'),
(4, '/MusicLibrary/1/1/4.mp3'),
(5, '/MusicLibrary/1/1/5.mp3'),
(6, '/MusicLibrary/1/1/6.mp3'),
(7, '/MusicLibrary/1/1/7.mp3'),
(8, '/MusicLibrary/1/1/8.mp3'),
(9, '/MusicLibrary/2/2/9.mp3'),
(10, '/MusicLibrary/2/2/10.mp3'),
(11, '/MusicLibrary/3/3/11.mp3'),
(12, '/MusicLibrary/4/4/12.mp3'),
(13, '/MusicLibrary/4/5/13.mp3'),
(14, '/MusicLibrary/4/5/14.mp3'),
(15, '/MusicLibrary/5/6/15.mp3'),
(16, '/MusicLibrary/5/6/16.mp3');

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `trackonalbum`
--

INSERT INTO `trackonalbum` (`trackID`, `albumID`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 2),
(10, 2),
(11, 3),
(12, 4),
(13, 5),
(14, 5),
(15, 6),
(16, 6);

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `trackonplaylist`
--

INSERT INTO `trackonplaylist` (`playlistID`, `trackID`) VALUES
(2, 1),
(3, 1),
(1, 3),
(2, 4),
(3, 8),
(1, 9),
(2, 9),
(1, 11),
(1, 12),
(1, 14),
(3, 14),
(3, 15);

-- --------------------------------------------------------

--
-- Gegevens worden geÃ«xporteerd voor tabel `user`
--

INSERT INTO `user` (`name`, `userID`) VALUES
('Admin', 1),
('Sander', 2),
('Jop', 3),
('Paul', 4),
('Robbert', 5),
('Kayan', 6),
('Harm', 7);