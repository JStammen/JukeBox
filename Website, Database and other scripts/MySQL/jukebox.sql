-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Gegenereerd op: 13 jan 2015 om 14:17
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
-- Tabelstructuur voor tabel `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `artistID` int(11) NOT NULL,
`albumID` int(11) NOT NULL,
  `albumname` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `album`
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
-- Tabelstructuur voor tabel `artist`
--

CREATE TABLE IF NOT EXISTS `artist` (
`artistID` int(11) NOT NULL,
  `artistName` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `artist`
--

INSERT INTO `artist` (`artistID`, `artistName`) VALUES
(1, 'The Living End'),
(2, 'Johnny Cash'),
(3, 'The Golden Earring'),
(4, 'Golden Earring'),
(5, 'Emancipation');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `artistofalbum`
--

CREATE TABLE IF NOT EXISTS `artistofalbum` (
  `artistID` int(11) NOT NULL,
  `albumID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `member`
--

CREATE TABLE IF NOT EXISTS `member` (
`memberID` int(11) NOT NULL,
  `artistID` int(11) NOT NULL,
  `firstname` char(20) NOT NULL,
  `surname` char(8) DEFAULT NULL,
  `lastname` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `playlist`
--

CREATE TABLE IF NOT EXISTS `playlist` (
`playlistID` int(11) NOT NULL,
  `name` char(50) NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `playlist`
--

INSERT INTO `playlist` (`playlistID`, `name`, `userID`) VALUES
(1, 'Good Rock', 7),
(2, 'Old but gold', 7),
(3, 'My list', 5);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `rating` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `trackID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `rating`
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
-- Tabelstructuur voor tabel `track`
--

CREATE TABLE IF NOT EXISTS `track` (
`trackID` int(11) NOT NULL,
  `artistID` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `duration` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `track`
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
-- Tabelstructuur voor tabel `trackdetail`
--

CREATE TABLE IF NOT EXISTS `trackdetail` (
  `trackID` int(11) NOT NULL,
  `tracknumber` int(11) NOT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `releaseyear` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `tracklocation`
--

CREATE TABLE IF NOT EXISTS `tracklocation` (
  `trackID` int(11) NOT NULL,
  `path` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `tracklocation`
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
-- Tabelstructuur voor tabel `trackonalbum`
--

CREATE TABLE IF NOT EXISTS `trackonalbum` (
  `trackID` int(11) NOT NULL,
  `albumID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `trackonalbum`
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
-- Tabelstructuur voor tabel `trackonplaylist`
--

CREATE TABLE IF NOT EXISTS `trackonplaylist` (
  `playlistID` int(11) NOT NULL,
  `trackID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `trackonplaylist`
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
-- Tabelstructuur voor tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `name` varchar(50) NOT NULL,
`userID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `user`
--

INSERT INTO `user` (`name`, `userID`) VALUES
('Admin', 1),
('Sander', 2),
('Jop', 3),
('Paul', 4),
('Robbert', 5),
('Kayan', 6),
('Harm', 7);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `album`
--
ALTER TABLE `album`
 ADD PRIMARY KEY (`albumID`), ADD KEY `FK_AlbumArtist` (`artistID`);

--
-- Indexen voor tabel `artist`
--
ALTER TABLE `artist`
 ADD PRIMARY KEY (`artistID`);

--
-- Indexen voor tabel `artistofalbum`
--
ALTER TABLE `artistofalbum`
 ADD PRIMARY KEY (`artistID`,`albumID`), ADD KEY `albumID` (`albumID`);

--
-- Indexen voor tabel `member`
--
ALTER TABLE `member`
 ADD PRIMARY KEY (`memberID`), ADD KEY `FK_ArtistMember` (`artistID`);

--
-- Indexen voor tabel `playlist`
--
ALTER TABLE `playlist`
 ADD PRIMARY KEY (`playlistID`), ADD KEY `FK_PlaylistUser` (`userID`);

--
-- Indexen voor tabel `rating`
--
ALTER TABLE `rating`
 ADD PRIMARY KEY (`userID`,`trackID`), ADD KEY `FK_RatingTrack` (`trackID`), ADD KEY `FK_RatingUser` (`userID`);

--
-- Indexen voor tabel `track`
--
ALTER TABLE `track`
 ADD PRIMARY KEY (`trackID`), ADD KEY `FK_TrackArtist` (`artistID`);

--
-- Indexen voor tabel `trackdetail`
--
ALTER TABLE `trackdetail`
 ADD PRIMARY KEY (`trackID`), ADD KEY `FK_TrackdetailTrack` (`trackID`);

--
-- Indexen voor tabel `tracklocation`
--
ALTER TABLE `tracklocation`
 ADD PRIMARY KEY (`trackID`,`path`);

--
-- Indexen voor tabel `trackonalbum`
--
ALTER TABLE `trackonalbum`
 ADD PRIMARY KEY (`trackID`,`albumID`), ADD KEY `FK_trackopalbumalbumID` (`albumID`);

--
-- Indexen voor tabel `trackonplaylist`
--
ALTER TABLE `trackonplaylist`
 ADD PRIMARY KEY (`playlistID`,`trackID`), ADD KEY `trackID` (`trackID`);

--
-- Indexen voor tabel `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`name`), ADD UNIQUE KEY `userID` (`userID`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `album`
--
ALTER TABLE `album`
MODIFY `albumID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT voor een tabel `artist`
--
ALTER TABLE `artist`
MODIFY `artistID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT voor een tabel `member`
--
ALTER TABLE `member`
MODIFY `memberID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `playlist`
--
ALTER TABLE `playlist`
MODIFY `playlistID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `track`
--
ALTER TABLE `track`
MODIFY `trackID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT voor een tabel `user`
--
ALTER TABLE `user`
MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `artistofalbum`
--
ALTER TABLE `artistofalbum`
ADD CONSTRAINT `artistofalbum_ibfk_1` FOREIGN KEY (`artistID`) REFERENCES `artist` (`artistID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `artistofalbum_ibfk_2` FOREIGN KEY (`albumID`) REFERENCES `album` (`albumID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `member`
--
ALTER TABLE `member`
ADD CONSTRAINT `FK_ArtistMember` FOREIGN KEY (`artistID`) REFERENCES `artist` (`artistID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `playlist`
--
ALTER TABLE `playlist`
ADD CONSTRAINT `FK_PlaylistUser` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `rating`
--
ALTER TABLE `rating`
ADD CONSTRAINT `FK_RatingTrack` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `track`
--
ALTER TABLE `track`
ADD CONSTRAINT `FK_TrackArtist` FOREIGN KEY (`artistID`) REFERENCES `artist` (`artistID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `trackdetail`
--
ALTER TABLE `trackdetail`
ADD CONSTRAINT `FK_TrackdetailTrack` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `tracklocation`
--
ALTER TABLE `tracklocation`
ADD CONSTRAINT `FK_tracklocation` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `trackonalbum`
--
ALTER TABLE `trackonalbum`
ADD CONSTRAINT `FK_trackopalbumalbumID` FOREIGN KEY (`albumID`) REFERENCES `album` (`albumID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_trackopalbumtrackID` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `trackonplaylist`
--
ALTER TABLE `trackonplaylist`
ADD CONSTRAINT `trackonplaylist_ibfk_1` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `trackonplaylist_ibfk_2` FOREIGN KEY (`playlistID`) REFERENCES `playlist` (`playlistID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
