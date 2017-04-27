<?php require_once('Connections/enose.php'); ?>
<?php 
error_reporting(E_ALL);
ini_set('display_errors', 1);

$data1 = array();
mysql_select_db($database_enose, $enose);
$query = "SELECT * FROM Enose WHERE ID='1'";
$result = mysql_query($query,$enose) or die(mysql_error());
$rows = mysql_num_rows($result);
if($rows>=1)
{
while($row = mysql_fetch_assoc($result))
{
$data[]= $row;
}
echo json_encode(array('data' =>$data));
}
else{
$data=array(
"null_trigger"=>"No data found."
);
echo json_encode($data);
}
mysql_close($enose);
 ?>