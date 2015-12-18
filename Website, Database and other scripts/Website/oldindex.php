<?php
session_start();
if (!isset($_SESSION['userName']))  {
header("Location:login.html");} 

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
    <head>
        <title>Jukebox</title>
        <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="robots" content="index, follow" />
        <link rel="stylesheet" type="text/css" href="screen.css" media="screen" />
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="js/RedirectImport.js"></script>
        <script src="js/RedirectRating.js"></script>
        <script src="js/search.js"></script>
        <script src="js/select.js"></script>
        <script src="js/PlayService.js"></script>
		<script type="text/javascript">var usernamePHP = "<?php echo $_SESSION['userName'];?>";













			function setImportVariable(){
				document.getElementById('importForm').action = "http://localhost:8080/import";
			};
			</script>

    </head>
    

    <audio controls autoplay id="audioElement">
        <source src=""></source>
        Your browser does not support the audio element.
    </audio>
    <audio autoplay id="previewaudio">
        <source src=""></source>
        Your browser does not support the audio element.
    </audio>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


    <div id="header">
        <div id="searchbox">

            <form>
                <span><input  type="text" id="searchBoxInput" name="criteria" placeholder="Search on title, album or artist"  ></span>
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
            <li><a href="#">Home</a></li>
            <li> <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display = 'block';
                    document.getElementById('fade').style.display = 'block'">Import</a></li>

            <div id="light" class="white_content"><h1 align="middle">Import Music </h1>
                <div id="importheader">
                </div>
                <form id="importForm"method="POST" enctype="multipart/form-data">

                    <table class="importTable">
                        <tr>
                            <th class="tableHeader" colspan="2">Track Details</th>
                        </tr>
                        <tr>
                            <td>Title:</td>
                            <td><input type="text" name="Title" placeholder="Fill in track title"></td>
                        </tr>
                        <tr>
                            <td>Artist:</td>
                            <td><input type="text" name="Artist" placeholder="Fill in artist name"></td>
                        </tr>
                        <tr>
                            <td>Album:</td>
                            <td><input type="text" name="Album" placeholder="Fill in album name"></td>
                        </tr>
                        <tr>
                            <td>Genre:</td>
                            <td><input type="text" name="Genre" placeholder="Fill in genre"></td>
                        </tr>
                        <tr>
                            <td>Duration:</td>
                            <td><input type="text" name="Duration" placeholder="Fill in duration"></td>
                        </tr>
                    </table>
                    </br>
                    <input type="file" name="File"></br>

                        <button style="float:right;" type="submit" id="redirectimport" onclick="setImportVariable()" >
                            Save & upload 
                        </button>
                </form>



                <button style="float:right;" type="button" onclick="javascript:void(0);
                        document.getElementById('light').style.display = 'none';
                        document.getElementById('fade').style.display = 'none';">
                    Discard & close

                </button>


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
            <form action="http://192.168.0.106:8090/rate" method="POST" enctype="'multipart/form-data">
                <h3>Rate:</h3>
                <select id="rating" name="selectrating" style="width:90px">
                </select>
                <input type="hidden" id="hiddeninput" value="<?php echo $_SESSION['userName']; ?>" name ="userName"/>
                <input type="hidden" name ="trackID" value="" id="myvalue"/>
                <button type="submit" id="redirectrating" > Rate </button>
                <br/>

                <H3>Average:</H3>
                <br/>
                <input type="text" id="average" value="" readonly/>




            </form>
        </div>
        <div id="trackinfo"></div>
    </div>
</div>

</div>
<div id="footer">
</div>



























































































































































































































</html>
