-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 04, 2014 at 07:15 PM
-- Server version: 5.5.40
-- PHP Version: 5.4.35-0+deb7u2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jukebox`
--

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `artistID` int(11) NOT NULL,
  `albumID` int(11) NOT NULL AUTO_INCREMENT,
  `albumname` varchar(50) NOT NULL,
  PRIMARY KEY (`albumID`),
  KEY `FK_AlbumArtist` (`artistID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`artistID`, `albumID`, `albumname`) VALUES
(1, 1, 'Seasons in the Abyss'),
(1, 2, 'Reign In Blood'),
(2, 3, 'Blurred Lines'),
(2, 4, 'Get Her Back'),
(3, 5, 'True'),
(3, 6, 'Levels'),
(4, 7, 'Pure Heroine'),
(5, 8, 'One Day'),
(5, 9, 'Uitzicht'),
(6, 10, 'Waves'),
(6, 11, 'Nothing Really Matters'),
(6, 12, 'The Treatment'),
(7, 13, 'Despicable Me 2'),
(7, 14, 'Get Lucky'),
(8, 15, 'In The Lonely Hour'),
(0, 54, 'placeholder'),
(52, 59, 'Londinium'),
(56, 60, 'Gloria'),
(57, 61, 'The Joy of Guns'),
(58, 62, 'Fate of Norns'),
(59, 63, 'Death Cult Armageddon'),
(60, 64, 'Romantiek met mayonaise'),
(61, 65, 'Litany'),
(62, 66, 'The very best of volume 1'),
(63, 67, 'The very best of ACDC'),
(64, 68, 'Hellbound'),
(65, 69, 'Nevermind'),
(66, 70, 'JB Parody'),
(67, 71, 'placeholder'),
(69, 73, 'Best of Greatest Hits'),
(70, 74, 'the lol'),
(72, 75, 'maarKampf'),
(73, 76, 'Gobeness'),
(74, 77, 'Rupert n co'),
(75, 78, 'Tosbhia'),
(76, 79, 'gjkwelrjg'),
(77, 80, 'Geger'),
(78, 81, 'InternetExplorer 4'),
(79, 82, 'Fatcase'),
(80, 83, 'c'),
(81, 84, 'a'),
(82, 85, 'd'),
(83, 86, 'g'),
(84, 87, 'metworst'),
(85, 88, 'fewfew'),
(86, 89, 'fwfweef'),
(87, 90, 'wefwefewfwefwefewfewfwef'),
(88, 91, 'nopeja'),
(89, 92, 'trolbytes'),
(90, 93, 'Harm and knife'),
(91, 94, 'tessst'),
(91, 95, 'Tacomatjes'),
(92, 96, 'fee'),
(93, 97, 'booobs'),
(86, 98, 'fwefwefew'),
(86, 99, 'fwefwefwe'),
(94, 100, 'lolcake'),
(95, 101, 'lolcake'),
(96, 102, 'fweffew'),
(97, 103, 'fewfwefwe'),
(98, 104, 'fdgtfghhh'),
(99, 105, 'fwefwfwe'),
(100, 106, 'gegerger'),
(101, 107, 'fwfew'),
(102, 108, 'dewdwe'),
(103, 109, 'dwedew'),
(104, 110, 'fwefwe'),
(99, 111, 'wfwefwe'),
(102, 112, 'dwdwedwe'),
(97, 113, 'fwfwe'),
(96, 114, 'fwfew'),
(105, 115, 'fwfew'),
(105, 116, 'fwefwe'),
(102, 117, 'dwedew'),
(97, 118, 'fwfew'),
(106, 119, 'Iknowright'),
(107, 120, 'prolapse'),
(107, 121, 'Curses'),
(108, 122, 'wobwob'),
(109, 123, 'Tacomas'),
(110, 124, 'Kayak'),
(111, 125, 'test'),
(112, 126, 'Tambu'),
(113, 127, 'tambu');

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE IF NOT EXISTS `artist` (
  `artistID` int(11) NOT NULL AUTO_INCREMENT,
  `artistName` varchar(100) NOT NULL,
  PRIMARY KEY (`artistID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`artistID`, `artistName`) VALUES
(1, 'Slayer'),
(2, 'Robin Thicke'),
(3, 'Avicii'),
(4, 'Lorde'),
(5, 'Bakermat'),
(6, 'Mr. Probz'),
(7, 'Pharrell Williams'),
(8, 'Sam Smith'),
(52, 'Archive'),
(53, 'Skrillex'),
(54, 'Ill Bill'),
(55, 'God Forbid'),
(56, 'Disillusion'),
(57, 'Combichrist'),
(58, 'Amon Amarth'),
(59, 'Dimmu Borgir'),
(60, 'Youp van t Hek'),
(61, 'Vader'),
(62, 'Golden Earring'),
(63, 'ACDC'),
(64, 'The Living End'),
(65, 'Nirvana'),
(66, 'Theamaus'),
(67, 'Borgore (ft. Miley Cyrus)'),
(69, 'Judas Priest'),
(70, 'Tacoma'),
(75, 'Toshiba'),
(76, 'gjklwehgr'),
(77, 'gerger'),
(78, 'coooler dan'),
(79, 'Yomama'),
(80, 'b'),
(81, 'a'),
(82, 'd'),
(83, 'g'),
(84, 'Gobelet of fire'),
(85, 'few'),
(86, 'fwefwefwe'),
(87, 'fwfwefwefwefwef'),
(88, 'lollol'),
(89, 'Tac0ema'),
(90, 'FRODJENKSINSNSNS'),
(91, 'Tacom'),
(92, 'dfshf'),
(93, 'boobs'),
(94, 'cake'),
(95, 'fakepants'),
(96, 'fwfwe'),
(97, 'fwefwe'),
(98, 'gfgfgf'),
(99, 'fwefwef'),
(100, 'GOrger'),
(101, 'fwfew'),
(102, 'dwedwe'),
(103, 'dwede'),
(104, 'frefwe'),
(105, 'fwefew'),
(106, 'TacomaNot'),
(107, 'Proleter'),
(108, 'Dot EXE'),
(109, 'Stammen'),
(110, 'Harm'),
(111, 'TEST'),
(112, 'Toto'),
(113, 'TOTO voorbeeld');

-- --------------------------------------------------------

--
-- Table structure for table `artistofalbum`
--

CREATE TABLE IF NOT EXISTS `artistofalbum` (
  `artistID` int(11) NOT NULL,
  `albumID` int(11) NOT NULL,
  PRIMARY KEY (`artistID`,`albumID`),
  KEY `albumID` (`albumID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `memberID` int(11) NOT NULL AUTO_INCREMENT,
  `artistID` int(11) NOT NULL,
  `firstname` char(20) NOT NULL,
  `surname` char(8) DEFAULT NULL,
  `lastname` char(25) NOT NULL,
  PRIMARY KEY (`memberID`),
  KEY `FK_ArtistMember` (`artistID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`memberID`, `artistID`, `firstname`, `surname`, `lastname`) VALUES
(1, 1, 'Kerry', NULL, 'King');

-- --------------------------------------------------------

--
-- Table structure for table `playlist`
--

CREATE TABLE IF NOT EXISTS `playlist` (
  `playlistID` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`playlistID`),
  KEY `FK_PlaylistUser` (`userID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `playlist`
--

INSERT INTO `playlist` (`playlistID`, `name`, `userID`) VALUES
(1, 'Metal', 7),
(7, 'test', 2),
(8, 'C muziek', 5),
(9, 'Gobe muziek', 5);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `rating` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `trackID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`trackID`),
  KEY `FK_RatingTrack` (`trackID`),
  KEY `FK_RatingUser` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`rating`, `userID`, `trackID`) VALUES
(1, 1, 1),
(3, 1, 2),
(2, 1, 3),
(5, 1, 4),
(4, 1, 5),
(1, 1, 6),
(2, 1, 7),
(3, 1, 8),
(5, 1, 9),
(1, 1, 10),
(3, 1, 13),
(2, 1, 14),
(5, 1, 15),
(1, 1, 18),
(5, 1, 94),
(5, 1, 104),
(1, 2, 1),
(5, 2, 2),
(3, 2, 7),
(2, 2, 8),
(2, 2, 12),
(3, 2, 15),
(5, 2, 81),
(5, 3, 1),
(5, 4, 1),
(1, 4, 18),
(5, 5, 1),
(1, 5, 2),
(5, 5, 3),
(5, 5, 4),
(1, 5, 5),
(5, 5, 6),
(1, 5, 7),
(5, 5, 9),
(5, 5, 18),
(1, 5, 90),
(1, 7, 1),
(5, 7, 2),
(5, 7, 3),
(4, 7, 5),
(5, 7, 7),
(4, 7, 8);

-- --------------------------------------------------------

--
-- Table structure for table `track`
--

CREATE TABLE IF NOT EXISTS `track` (
  `trackID` int(11) NOT NULL AUTO_INCREMENT,
  `artistID` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `duration` time NOT NULL,
  PRIMARY KEY (`trackID`),
  KEY `FK_TrackArtist` (`artistID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=117 ;

--
-- Dumping data for table `track`
--

INSERT INTO `track` (`trackID`, `artistID`, `title`, `duration`) VALUES
(1, 1, 'War Ensemble', '00:04:52'),
(2, 1, 'Raining Blood', '00:04:15'),
(3, 2, 'Blurred Lines', '00:04:24'),
(4, 2, 'Get Her Back', '00:03:32'),
(5, 3, 'Wake Me Up', '00:04:07'),
(6, 3, 'Levels', '00:03:20'),
(7, 3, 'Hey Brother', '00:04:15'),
(8, 3, 'Addicted To You', '00:02:28'),
(9, 4, 'Royals', '00:03:10'),
(10, 4, 'Team', '00:03:13'),
(11, 5, 'One Day', '00:03:39'),
(12, 5, 'Uitzicht', '00:05:09'),
(13, 6, 'Waves', '00:03:28'),
(14, 6, 'Nothing Really Matters', '00:03:42'),
(15, 6, 'Do It All Again', '00:02:58'),
(16, 7, 'Happy', '00:03:53'),
(17, 7, 'Get Lucky', '00:04:08'),
(18, 8, 'Stay With Me', '00:02:53'),
(19, 8, 'Im Not The Only One', '00:02:53'),
(80, 52, 'Old Artist', '04:03:00'),
(81, 53, 'Wild for the night', '00:03:23'),
(82, 54, 'My Uncle', '00:03:23'),
(83, 55, 'Judge the Blood', '00:03:23'),
(84, 56, 'Dread It', '00:03:23'),
(85, 56, 'Lava', '00:03:23'),
(86, 57, 'Vater Unser', '00:03:23'),
(87, 58, 'The Pursuit of Vikings', '00:03:23'),
(88, 59, 'Vredesbyrd', '00:03:23'),
(89, 60, 'Flappie', '00:03:23'),
(90, 61, 'Wings', '00:03:23'),
(91, 62, 'Another 45 miles', '00:03:23'),
(94, 63, 'Hard as a Rock', '00:03:23'),
(95, 63, 'Highway to Hell', '00:03:23'),
(96, 63, 'Hells Bells', '00:03:23'),
(97, 63, 'Who made who', '00:03:23'),
(98, 62, 'Buddy Joe', '00:03:23'),
(99, 64, 'Trace of Doubt', '00:03:23'),
(100, 64, 'Hellbound', '00:03:23'),
(101, 64, 'Tabletop Show', '00:03:23'),
(102, 64, 'The Living End', '00:03:23'),
(103, 64, 'Strange', '00:03:23'),
(104, 65, 'Smells Like Teen Spirit', '00:03:23'),
(106, 67, 'Decisions', '00:03:23'),
(108, 69, 'Breaking the Law', '00:03:23'),
(109, 69, 'United', '00:03:23'),
(112, 108, 'Battlecry', '00:03:23'),
(113, 111, 'testje', '00:03:23'),
(114, 112, 'the turning point', '00:03:23'),
(115, 113, 'The turning poinT', '00:03:23'),
(116, 3, 'Hey Brother', '00:03:23');

-- --------------------------------------------------------

--
-- Table structure for table `trackdetail`
--

CREATE TABLE IF NOT EXISTS `trackdetail` (
  `trackID` int(11) NOT NULL,
  `tracknumber` int(11) NOT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `releaseyear` int(11) DEFAULT NULL,
  PRIMARY KEY (`trackID`),
  KEY `FK_TrackdetailTrack` (`trackID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trackdetail`
--

INSERT INTO `trackdetail` (`trackID`, `tracknumber`, `genre`, `releaseyear`) VALUES
(1, 1, 'Metal', 1990),
(2, 2, 'Metal', 1990),
(3, 3, 'Metal', 1990),
(4, 4, 'Metal', 1990),
(5, 5, 'Metal', 1990),
(6, 6, 'Metal', 1990),
(7, 7, 'Metal', 1990),
(8, 8, 'Metal', 1990),
(9, 9, 'Metal', 1990),
(10, 10, 'Metal', 1990),
(11, 1, 'Pop', 2013),
(12, 2, 'Pop', 2013),
(13, 3, 'Pop', 2013),
(14, 4, 'Pop', 2013),
(15, 5, 'Pop', 2013),
(16, 6, 'Pop', 2013);

-- --------------------------------------------------------

--
-- Table structure for table `tracklocation`
--

CREATE TABLE IF NOT EXISTS `tracklocation` (
  `trackID` int(11) NOT NULL,
  `path` varchar(256) NOT NULL,
  PRIMARY KEY (`trackID`,`path`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tracklocation`
--

INSERT INTO `tracklocation` (`trackID`, `path`) VALUES
(80, '/home/pi/80.mp3'),
(81, '/home/pi/MusicLibrary/81.mp3'),
(82, '/home/pi/MusicLibrary/82.mp3'),
(86, '/home/pi/MusicLibrary/86.mp3'),
(87, '/home/pi/MusicLibrary/87.mp3'),
(88, '/MusicLibrary/59/63/88.mp3'),
(89, '/MusicLibrary/60/64/89.mp3'),
(90, 'MusicLibrary/61/65/90.mp3'),
(91, '/MusicLibrary/62/66/91.mp3'),
(94, '/MusicLibrary/63/67/94.mp3'),
(95, '/MusicLibrary/63/67/95.mp3'),
(96, '/MusicLibrary/63/67/96.mp3'),
(97, '/MusicLibrary/63/67/97.mp3'),
(98, '/MusicLibrary/62/66/98.mp3'),
(99, '/MusicLibrary/64/68/99.mp3'),
(100, '/MusicLibrary/64/68/100.mp3'),
(101, '/MusicLibrary/64/68/101.mp3'),
(102, '/MusicLibrary/64/68/102.mp3'),
(103, '/MusicLibrary/64/68/103.mp3'),
(104, '/MusicLibrary/65/69/104.mp3'),
(106, '/MusicLibrary/67/71/106.mp3'),
(108, 'MusicLibrary/69/73/108.mp3'),
(113, '/MusicLibrary/111/125/113.mp3'),
(114, '/MusicLibrary/112/126/114.mp3'),
(115, '/MusicLibrary/113/127/115.mp3'),
(116, '/MusicLibrary/3/5/116.mp3');

-- --------------------------------------------------------

--
-- Table structure for table `trackonalbum`
--

CREATE TABLE IF NOT EXISTS `trackonalbum` (
  `trackID` int(11) NOT NULL,
  `albumID` int(11) NOT NULL,
  PRIMARY KEY (`trackID`,`albumID`),
  KEY `FK_trackopalbumalbumID` (`albumID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trackonalbum`
--

INSERT INTO `trackonalbum` (`trackID`, `albumID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(7, 5),
(8, 5),
(116, 5),
(6, 6),
(9, 7),
(10, 7),
(11, 8),
(12, 9),
(13, 10),
(14, 11),
(15, 12),
(16, 13),
(17, 14),
(18, 15),
(19, 15),
(81, 54),
(82, 54),
(84, 54),
(85, 54),
(86, 54),
(87, 54),
(88, 54),
(89, 54),
(90, 65),
(91, 66),
(98, 66),
(94, 67),
(95, 67),
(96, 67),
(97, 67),
(99, 68),
(100, 68),
(101, 68),
(102, 68),
(103, 68),
(104, 69),
(106, 71),
(108, 73),
(109, 73),
(112, 122),
(113, 125),
(114, 126),
(115, 127);

-- --------------------------------------------------------

--
-- Table structure for table `trackonplaylist`
--

CREATE TABLE IF NOT EXISTS `trackonplaylist` (
  `playlistID` int(11) NOT NULL,
  `trackID` int(11) NOT NULL,
  PRIMARY KEY (`playlistID`,`trackID`),
  KEY `trackID` (`trackID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trackonplaylist`
--

INSERT INTO `trackonplaylist` (`playlistID`, `trackID`) VALUES
(1, 2),
(1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `name` varchar(50) NOT NULL,
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`name`),
  UNIQUE KEY `userID` (`userID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `user`
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
-- Constraints for dumped tables
--

--
-- Constraints for table `artistofalbum`
--
ALTER TABLE `artistofalbum`
  ADD CONSTRAINT `artistofalbum_ibfk_1` FOREIGN KEY (`artistID`) REFERENCES `artist` (`artistID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `artistofalbum_ibfk_2` FOREIGN KEY (`albumID`) REFERENCES `album` (`albumID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `FK_ArtistMember` FOREIGN KEY (`artistID`) REFERENCES `artist` (`artistID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `FK_PlaylistUser` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FK_RatingTrack` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `track`
--
ALTER TABLE `track`
  ADD CONSTRAINT `FK_TrackArtist` FOREIGN KEY (`artistID`) REFERENCES `artist` (`artistID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `trackdetail`
--
ALTER TABLE `trackdetail`
  ADD CONSTRAINT `FK_TrackdetailTrack` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tracklocation`
--
ALTER TABLE `tracklocation`
  ADD CONSTRAINT `FK_tracklocation` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `trackonalbum`
--
ALTER TABLE `trackonalbum`
  ADD CONSTRAINT `FK_trackopalbumalbumID` FOREIGN KEY (`albumID`) REFERENCES `album` (`albumID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_trackopalbumtrackID` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `trackonplaylist`
--
ALTER TABLE `trackonplaylist`
  ADD CONSTRAINT `trackonplaylist_ibfk_1` FOREIGN KEY (`trackID`) REFERENCES `track` (`trackID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `trackonplaylist_ibfk_2` FOREIGN KEY (`playlistID`) REFERENCES `playlist` (`playlistID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
