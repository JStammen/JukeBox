<?php
session_start();
session_destroy();
   {
        echo "<script language=\"JavaScript\">\n";
		echo "alert('You are signed out');\n";
		echo "window.location='login.html'";
		echo "</script>";
    }
?>
