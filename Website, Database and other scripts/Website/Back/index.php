<?php
session_start();
if (!isset($_SESSION['userName']))  {
header("Location:login.html");} 
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
<head>
	<title>Jukebox</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="screen.css" media="screen" />
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="javascript/redirectimport.js"></script>
	<script src="javascript/redirectrating.js"></script>
	<script src="javascript/search.js"></script>
	<script src="javascript/select.js"></script>
	<script type="text/javascript">var usernamePHP = "<?php echo $_SESSION['userName'];?>";</script>
</head>
<body>
<div id="header">
	<ul id="navlist">
	<li><a href="index.php">Home</a></li>
    <li> <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">Import</a></li>
	<div id="light" class="white_content"><h2>Upload your track here. </h2>
		
		<!--192.168.0.104-->
		<form id="importform" action="http://192.168.0.104:8080/import" method="POST" enctype="multipart/form-data">
			<h3>1. Select file:</h3>
			<input type="file" name="File"></br></br>
			<table class="tg">
			  <tr>
				<th class="tableheader" colspan="2">Track Details</th>
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
				<td></td>
			  </tr>
			  <tr>
				<td>Duration:</td>
				<td></td>
			  </tr>
			</table>
			<h3>2. Click the button to upload the file.</h3>
			<input id="redirectimport" type="submit" value="Upload" name="submit"></br>
		</form>
		
<button id="PopUpCloseButton"  type="button">	
	<a  href= "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">Close</a></button></div>
    <div id="fade" class="black_overlay">
	</div>
	<li style="float:right;"><a href="logout.php">Logout</a></li>
	</ul>
</div>

<div class="colmask threecol">
        <div class="colmid">
            <div class="colleft">
                <div class="col1">
                    <h2>Filter</h2>

                    <div id="table-scroll">
                        <table id="container" border="1px;">

                        </table>
                    </div>

                </div>
                <div class="col2">
                    <h2>Music</h2>

                    <form>
                        <input type="text" name="criteria" class="search rounded" placeholder="Search...">
                        <input type="submit" value="Search" id="zoeken" style="display: none;">
                    </form>
                </div>

				<div class="col3" style="text-align: center">
                    <h2>Information</h2>

					<form action="http://192.168.0.106:8090/rate" method="POST" enctype="'multipart/form-data">
							<h3>Rate:</h3>
							<select id="rating" name="selectrating" style="width:90px">
							 </select>
							 <input type="hidden" id="hiddeninput" value="<?php echo $_SESSION['userName']; ?>" name ="userName">
							 <input type="hidden" name ="trackID" value="" id="myvalue">
							 <input type="submit" value="Rate" id="redirectrating" >
							 <br><H3>Average:</H3><br><input type="text" id="average" value="" readonly>
					</form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>

</html>

