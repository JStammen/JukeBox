<?php
session_start();
if (!isset($_SESSION['userName'])) {
    header("Location:login.html");
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
    <head>
        <title>Jukebox</title>
        <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="screen.css" media="screen" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
       
	   
	   <script src="js/search.js"></script>
        <script type="text/javascript">var usernamePHP = "<?php echo $_SESSION['userName']; ?>";
		    var importServiceIP = "http://192.168.0.104";
            var importServicePort = ":8080";
            var searchServiceIP = "http://192.168.0.106";
            var searchServicePort = ":8080";
            var rateServiceIP = "http://192.168.0.106";
            var rateServicePort = ":8090";
            var siteIpForRedirect = "http://192.168.0.105";
            var playServiceIP = "http://192.168.0.103";
            var playServicePort = ":8070";
            var previewServiceIP = "http://192.168.0.103";
            var previewServicePort = ":8090";
            var fileServerIP = "http://192.168.0.101";
		</script>
		<script src="js/select.js"></script>
		<script src="js/rate.js"></script>
		<script src="js/import.js"</script>
 
        
		
    </head>


    <audio autoplay id="audioElement">
        <source src=""></source>
        Your browser does not support the audio element.
    </audio>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


    <div id="header">
        <div id="searchbox">

            <form>
                <span><input  type="text" id="searchBoxInput" name="criteria" placeholder ="Search" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Search'"  ></span>
                <script type="text/javascript">
						$(document).ready(function () {
						
								searchByCriteria("%");
								selectTrack();
								var zoekvak = document.getElementById("searchBoxInput");
								zoekvak.addEventListener("keydown", function (e) {
								if (e.keyCode === 13) {  //checks whether the pressed key is "Enter"
										searchByCriteria($('form input[name=criteria]').val());
										e.preventDefault();
										return false;
								}
							});
						});
                </script>
            </form>
        </div>
        <ul id="navlist">
            <li> <a href="javascript:siteIpForRedirect">Home</a></li>
            <li> <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display = 'block';
                    document.getElementById('fade').style.display = 'block'">Import</a></li>

            <div id="light" class="white_content"><h1 align="middle">Import Music </h1>
                <div id="importheader">
                </div>
               <form id="importForm" action="javascript:;" name="importForm" method="post" enctype="multipart/form-data">

                    <table class="importTable">
                        <tr>
                            <th class="tableHeader" colspan="2">Track Details</th>
                        </tr>
                        <tr>
                            <td>Title:</td>
                            <td><input type="text" name="Title" placeholder="Fill in track title" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Fill in track title'"></td>
                        </tr>
                        <tr>
                            <td>Artist:</td>
                            <td><input type="text" name="Artist" placeholder="Fill in artist name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Fill in artist name'"></td>
                        </tr>
                        <tr>
                            <td>Album:</td>
                            <td><input type="text" name="Album" placeholder="Fill in album name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Fill in album name'"></td>
                        </tr>
                        <tr>
                            <td>Genre:</td>
                            <td><input type="text" name="Genre" placeholder="Fill in genre" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Fill in genre'"></td>
                        </tr>
                        <tr>
                            <td>Duration:</td>
                            <td><input type="text" name="Duration" placeholder="Fill in duration" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Fill in duration'"></td>
                        </tr>
                    </table>
                    </br>
				<input type="file" name="File" ></br>
				<button style="float:right;" type="submit" name="save" id="submitImport">
                            Upload 
                </button>
				
                <button style="float:right;" type="button" onclick="javascript:void(0);
                        document.getElementById('light').style.display = 'none';
                        document.getElementById('fade').style.display = 'none';">

                    Close
                </button>
                </form>
            </div>
						
            <div id="fade" class="black_overlay">
            </div>
            <li>
                <a href="logout.php">Logout</a>
            </li>
        </ul>
    </div>

    <div class="col" id="colleft">
        <div id="playlist">

        </div>
        <div id="player">
            <div id="albumart"></div>
            <div id="nowplaying"></div>
            <div class="controls">
                <div class="button" id="previous">
                    <input type="image" src="Buttons/previous.png" id="previous" onclick="previousTrack()" />
                </div>
                <div class="button" id="play">
                    <input type="image" src="Buttons/play.png" id="playpause" value="playbutton" onclick="playPauseToggle()" />
                </div>
                <div class="button" id="next">
                    <input type="image" src="Buttons/next.png" id="next" onclick="nextTrack()" />
                </div>
            </div>
            <!--            <div class="playbar"></div>-->
        </div>
    </div>

    <div class="col" id="colmid">
        <table style="width:100%" id = "container" class="result" cellspacing="0" cellpadding="3" >


            <tr>
                <th class="no">#</th>
                <th class="Title">Title</th>
                <th class="Album">Album</th> 
                <th class="Artist">Artist</th>
                <th class="Duration"> </th>
                <th class="Add"> </th>
            </tr>
        </table>
    </div>

    <div class="col" id="colright">
        <div  id="trackInformatie">
            <form  method="POST" enctype="'multipart/form-data" id="rateForm">
                <h3>Rate:</h3>
                <select id="rating" name="selectrating" style="width:90px">
                </select>
                <input type="hidden" id="hiddeninput" value="<?php echo $_SESSION['userName']; ?>" name ="userName"/>
                <input type="hidden" name ="trackID" value="" id="myvalue"/>
                <button type="submit" id="redirectrating" > Rate </button>
                <br/>
                <br/>
                <H3>Average:</H3>
                <br/>

                <div id ="average">
                </div>
                <br/>
                <br/>
            </form>
        </div>
        <div id="trackinfo"></div>
    </div>
</div>

</div>
<div id="footer">
</div>

<script>
    var selectedTitle;
    var selectedAlbum;
    var selectedID = 0;
    var currentSrc;                                                          //Current src for audio
    var previewDuration = 10;                                                //Preview duration in seconds
    var unselect;
    var audio = document.getElementById("audioElement");
    var playPause = document.getElementById("playpause");
    var prevIsPlaying = false;
    var currentPreview;
    var previewTimer = 0;


    document.getElementById("audioElement").onended = function () {
        audio.pause();
    };

    function playPauseToggle() {                                             //Toggles play&pause button
        //Fetches the button
        if (playPause.value == "playbutton") {                                    //Button is currently a play-button
            audio.play();
            playPause.value = "pausebutton";
            playPause.src = "Buttons/pause.png";
        }
        else if (playPause.value == "pausebutton") {                              //Button is currently a pause-button
            audio.pause();
            playPause.value = "playbutton";
            playPause.src = "Buttons/play.png";
        }
        else if (playPause.value == "stopbutton") {                              //Button is currently a pause-button
            audio.pause();
            playPause.value = "playbutton";
            playPause.src = "Buttons/play.png";
        }

    }

    function play(ip, poort, selectedId, startTime, type) {
        if (selectedId > 0) {
            getURL(ip, poort, selectedId, "audioElement", type);
            audio.load();
            audio.currentTime = startTime;
            audio.play();
        }
    }
    function playTrack(selectedId, selectedTitle, selectedAlbum) {
        stopPreviewTimer();
        play(playServiceIP, playServicePort, selectedId, 0, "play");
        playPause.value = "pausebutton";
        playPause.src = "Buttons/pause.png";
        nowPlaying(selectedTitle, selectedAlbum);                        //Show track info near audio controls


    }
    function playPreview(i, selectedId) {
        togglePreview(i, selectedId)
        if (selectedId > 0 && prevIsPlaying == false) {
            stopPreviewTimer();
            play(previewServiceIP, previewServicePort, selectedId, 10, "play");
            playPause.value = "pausebutton";
            playPause.src = "Buttons/pause.png";
            console.log(i)
            startPreviewTimer();
            prevIsPlaying = true;
            currentPreview = i;
        } else if (prevIsPlaying == true && currentPreview == i) {
            stopPreview();
        } else if (prevIsPlaying == true && currentPreview != i) {
            stopPreviewTimer();
            play(previewServiceIP, previewServicePort, selectedId, 10, "play");
            playPause.value = "pausebutton";
            playPause.src = "Buttons/pause.png";
            console.log(i)
            startPreviewTimer();
            prevIsPlaying = true;
            currentPreview = i;
        }

    }

    var timer;                                                              //Needs to be var in order to clear
    function startPreviewTimer() {
        timer = setInterval(
                function () {
                    previewTick();
                }, 1000
                );
    }

    function previewTick() {
        previewTimer++;
        console.log(previewTimer);
        if (previewTimer == previewDuration) {
            stopPreview();
            clearInterval(timer);
            previewTimer = 0;
        }
    }
    function stopPreviewTimer(){
        clearInterval(timer);
        previewTimer = 0;
        timer;
    }
    function stopPreview() {
        audio.pause();
        stopPreviewTimer();
        prevIsPlaying = false;
        currentPreview = 0;
    }

    function selectTrack() {
        var table = document.getElementById("container");
        var rows = table.getElementsByTagName("tr");

        for (i = 0; i < rows.length; i++) {
            var currentRow = table.rows[i];
            var createClickHandler =
                    function (row)
                    {
                        var selectedTitle;
                        var selectedAlbum;

                        return function () {

                            if (unselect != null) {
                                unselect.value = "unselected";
                                if (unselect.rowIndex % 2 == 0) {
                                    unselect.style.backgroundColor = "white";
                                }
                                else {
                                    unselect.style.backgroundColor = "#EBEBEB";
                                }
                            }
                            row.value = "selected";
                            row.style.backgroundColor = "#369";
                            unselect = row;
                            var cells = row.getElementsByTagName("td");
                            selectedTitle = cells[1].innerHTML;
                            selectedArtist = cells[2].innerHTML;
                            selectedAlbum = cells[3].innerHTML;
                            selectedID = cells[5].innerHTML;
                            showInfo(selectedTitle, selectedArtist, selectedAlbum);
                            selectTrackForRating(selectedID);

                        };
                    };

            currentRow.onclick = createClickHandler(currentRow);
        }
    }



    function nextTrack() {
        if (selectedId < 10) {
            selectedId++;
            playTrack(selectedID, selectedtitle, selectedAlbum);
            nowPlayingClear();
        }
    }

    function previousTrack() {
        if (selectedId > 1) {
            selectedId--;
            playTrack(selectedID, selectedtitle, selectedAlbum);
            nowPlayingClear();
        }
    }

    function showInfo(title, artist, album) {

        var infoelement = document.getElementById("trackinfo");
        infoelement.innerHTML = "<h1>" + title.replace("`", "'") + "</h1><span id=\"artistinfo\">" + artist
                + "</span><br><br><span id=\"albuminfo\">" + album
                + "</span><br><br><br><img width=\"150\" src=\"Albumart/" + album
                + ".jpg\">"; //'" + title + "'

    }

    function nowPlaying(selectedTitle, selectedAlbum) {
        var np = document.getElementById("nowplaying");
//        selectedTitle = selectedTitle.replace("`", "'");
        np.textContent = "Now playing: " + selectedTitle;

        var aa = document.getElementById("albumart");
        aa.innerHTML = "<img src=\"Albumart/" + selectedAlbum.toString() + ".jpg\" id=\"AlbumImage\">";
    }

    function nowPlayingClear() {
        var np = document.getElementById("nowplaying");
//        selectedTitle = selectedTitle.replace("`", "'");
        np.textContent = " ";

        var aa = document.getElementById("albumart");
        aa.innerHTML = "";
    }

    function getURL(ip, poort, localTrackId, element, type)
    {
        var requestVar = "/" + type + "?trackid=";


        xmlhttp = new XMLHttpRequest();

        xmlhttp.onreadystatechange = function ()
        {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            {
                var response = xmlhttp.responseText;
                document.getElementById(element).setAttribute("src", fileServerIP + response.substring(20));
                document.getElementById(element).load();
            }
        };
        xmlhttp.open("GET", ip + poort + requestVar + localTrackId, true);
        xmlhttp.send();
    }

</script>

</html>
