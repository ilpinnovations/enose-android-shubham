<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
$hostname = "160.153.89.96";
$database= "Enose_DB";
$username= "jeet";
$password = "J@447788";
$enose = mysql_pconnect($hostname, $username, $password) or die(mysql_error());
?>