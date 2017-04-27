<?php
# FileName="Connection_php_mysql.htm"
# Type="MYSQL"
# HTTP="true"
$hostname_enose = "160.153.89.96";
$database_enose = "Enose_DB";
$username_enose = "jeet";
$password_enose = "J@447788";
$enose = mysql_pconnect($hostname_enose, $username_enose, $password_enose) or trigger_error(mysql_error(),E_USER_ERROR); 
?>