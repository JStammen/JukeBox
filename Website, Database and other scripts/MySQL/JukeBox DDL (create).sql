-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2015 at 01:13 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE IF NOT EXISTS `artist` (
  `artistID` int(11) NOT NULL AUTO_INCREMENT,
  `artistName` varchar(100) NOT NULL,
  PRIMARY KEY (`artistID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;

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

-- --------------------------------------------------------

--
-- Table structure for table `tracklocation`
--

CREATE TABLE IF NOT EXISTS `tracklocation` (
  `trackID` int(11) NOT NULL,
  `path` varchar(256) NOT NULL,
  PRIMARY KEY (`trackID`,`path`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `name` varchar(50) NOT NULL,
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`name`),
  UNIQUE KEY `userID` (`userID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ;


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
