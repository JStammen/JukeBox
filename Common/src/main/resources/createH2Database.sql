CREATE TABLE "PUBLIC"."ALBUM"
(
   ARTISTID integer NOT NULL,
   ALBUMID integer auto_increment PRIMARY KEY NOT NULL,
   ALBUMNAME varchar(50) NOT NULL
)
;
CREATE TABLE "PUBLIC"."ARTIST"
(
   ARTISTID integer auto_increment PRIMARY KEY NOT NULL,
   ARTISTNAME varchar(100) NOT NULL
)
;
CREATE TABLE "PUBLIC"."ARTISTOFALBUM"
(
   ARTISTID integer NOT NULL,
   ALBUMID integer NOT NULL,
   CONSTRAINT PK_ARTISTOFALBUM PRIMARY KEY (ARTISTID,ALBUMID)
)
;
CREATE TABLE "PUBLIC"."MEMBER"
(
   MEMBERID integer auto_increment PRIMARY KEY NOT NULL,
   ARTISTID integer NOT NULL,
   FIRSTNAME varchar(20) NOT NULL,
   SURNAME varchar(8) DEFAULT NULL,
   LASTNAME varchar(25) NOT NULL
)
;
CREATE TABLE "PUBLIC"."PLAYLIST"
(
   PLAYLISTID integer auto_increment PRIMARY KEY NOT NULL,
   NAME varchar(50) NOT NULL,
   USERID integer NOT NULL
)
;
CREATE TABLE "PUBLIC"."RATING"
(
   RATING integer NOT NULL,
   USERID integer NOT NULL,
   TRACKID integer NOT NULL,
   CONSTRAINT PK_RATING PRIMARY KEY (USERID,TRACKID)
)
;
CREATE TABLE "PUBLIC"."TRACK"
(
   TRACKID integer auto_increment PRIMARY KEY NOT NULL,
   ARTISTID integer NOT NULL,
   TITLE varchar(50) NOT NULL,
   DURATION time NOT NULL
)
;
CREATE TABLE "PUBLIC"."TRACKDETAIL"
(
   TRACKID integer PRIMARY KEY NOT NULL,
   TRACKNUMBER integer NOT NULL,
   GENRE varchar(20) DEFAULT NULL,
   RELEASEYEAR integer DEFAULT NULL
)
;
CREATE TABLE "PUBLIC"."TRACKLOCATION"
(
   TRACKID integer NOT NULL,
   PATH varchar(256) NOT NULL,
   CONSTRAINT PK_TRACKLOCATION PRIMARY KEY (TRACKID,PATH)
)
;
CREATE TABLE "PUBLIC"."TRACKONALBUM"
(
   TRACKID integer NOT NULL,
   ALBUMID integer NOT NULL,
   CONSTRAINT PK_TRACKONALBUM PRIMARY KEY (TRACKID,ALBUMID)
)
;
CREATE TABLE "PUBLIC"."TRACKONPLAYLIST"
(
   PLAYLISTID integer NOT NULL,
   TRACKID integer NOT NULL,
   CONSTRAINT PK_TRACKONPLAYLIST PRIMARY KEY (PLAYLISTID,TRACKID)
)
;
CREATE TABLE "PUBLIC"."USER"
(
   NAME varchar(50) NOT NULL,
   USERID integer auto_increment PRIMARY KEY NOT NULL
)
;
ALTER TABLE "PUBLIC"."ARTISTOFALBUM"
ADD CONSTRAINT FK_ARTISTOFALBUMARTISTID
FOREIGN KEY (ARTISTID)
REFERENCES "PUBLIC"."ARTIST"(ARTISTID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."ARTISTOFALBUM"
ADD CONSTRAINT FK_ARTISTOFALBUMALBUMID
FOREIGN KEY (ALBUMID)
REFERENCES "PUBLIC"."ALBUM"(ALBUMID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."MEMBER"
ADD CONSTRAINT FK_ARTISTMEMBER
FOREIGN KEY (ARTISTID)
REFERENCES "PUBLIC"."ARTIST"(ARTISTID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."PLAYLIST"
ADD CONSTRAINT FK_PLAYLISTTRACK
FOREIGN KEY (USERID)
REFERENCES "PUBLIC"."USER"(USERID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."RATING"
ADD CONSTRAINT FK_RATINGTRACKID
FOREIGN KEY (TRACKID)
REFERENCES "PUBLIC"."TRACK"(TRACKID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."RATING"
ADD CONSTRAINT FK_RATINGUSERID
FOREIGN KEY (USERID)
REFERENCES "PUBLIC"."USER"(USERID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."TRACK"
ADD CONSTRAINT FK_TRACKARTISTID
FOREIGN KEY (ARTISTID)
REFERENCES "PUBLIC"."ARTIST"(ARTISTID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."TRACKDETAIL"
ADD CONSTRAINT FK_TRACKDETAILTRACKID
FOREIGN KEY (TRACKID)
REFERENCES "PUBLIC"."TRACK"(TRACKID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."TRACKLOCATION"
ADD CONSTRAINT FK_TRACKLOCATIONTRACKID
FOREIGN KEY (TRACKID)
REFERENCES "PUBLIC"."TRACK"(TRACKID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."TRACKONALBUM"
ADD CONSTRAINT FK_TRACKONALBUMALBUMID
FOREIGN KEY (ALBUMID)
REFERENCES "PUBLIC"."ALBUM"(ALBUMID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."TRACKONALBUM"
ADD CONSTRAINT FK_TRACKONALBUMTRACKID
FOREIGN KEY (TRACKID)
REFERENCES "PUBLIC"."TRACK"(TRACKID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."TRACKONPLAYLIST"
ADD CONSTRAINT FK_TRACKONPLAYLISTTRACKID
FOREIGN KEY (TRACKID)
REFERENCES "PUBLIC"."TRACK"(TRACKID) ON DELETE CASCADE ON UPDATE CASCADE
;
ALTER TABLE "PUBLIC"."TRACKONPLAYLIST"
ADD CONSTRAINT FK_TRACKONPLAYLISTPLAYLISTID
FOREIGN KEY (PLAYLISTID)
REFERENCES "PUBLIC"."PLAYLIST"(PLAYLISTID) ON DELETE CASCADE ON UPDATE CASCADE
;