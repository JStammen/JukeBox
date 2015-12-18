<?php

    session_start();
    $hostname = '192.168.0.105';
    $dbname   = 'jukebox';
    $username = 'datasolutions'; 
    $password = 'jukebox';
    mysql_connect($hostname, $username, $password) or DIE('Connection to host is failed, perhaps the service is down!');
    mysql_select_db($dbname) or DIE('Database name is not available!');

    $userName=mysql_real_escape_string($_POST['username']); 
    //$passWord=md5(mysql_real_escape_string($_POST['password']));
    $query = "SELECT name FROM user WHERE name='$userName'";
    $res = mysql_query($query);
    $rows = mysql_num_rows($res);
    if ($rows==1) 
    {
        $_SESSION['userName'] = $_POST['username'];
        header("Location: index.php");
    }
    else 
    {
        echo "<script language=\"JavaScript\">\n";
		echo "alert('Username was incorrect!');\n";
		echo "window.location='login.html'";
		echo "</script>";
    }
?>