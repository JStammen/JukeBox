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
(0, 54, 'placeholder');

INSERT INTO `artist` (`artistID`, `artistName`) VALUES
(1, 'Slayer'),
(2, 'Robin Thicke'),
(3, 'Avicii'),
(4, 'Lorde'),
(5, 'Bakermat'),
(6, 'Mr. Probz'),
(7, 'Pharrell Williams'),
(8, 'Sam Smith');

INSERT INTO `member` (`memberID`, `artistID`, `firstname`, `surname`, `lastname`) VALUES
(1, 1, 'Kerry', NULL, 'King');

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
(19, 8, 'Im Not The Only One', '00:02:53');

INSERT INTO `user` (`name`, `userID`) VALUES
('Admin', 1),
('Sander', 2),
('Jop', 3),
('Paul', 4),
('Robbert', 5),
('Kayan', 6),
('Harm', 7);

INSERT INTO `playlist` (`playlistID`, `name`, `userID`) VALUES
(1, 'Metal', 7);

INSERT INTO `rating` (`rating`, `userID`, `trackID`) VALUES
(3, 1, 1),
(1,2,1);


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

INSERT INTO `trackonalbum` (`trackID`, `albumID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(7, 5),
(8, 5),
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
(19, 15);

INSERT INTO `trackonplaylist` (`playlistID`, `trackID`) VALUES
(1,1),
(1,2),
(1,3),
(1,4);