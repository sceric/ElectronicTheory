<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Komponent databas</title>

<!--Scrulbar script

<style type="text/css">
<!--
body {
scrollbar-face-color: #e6e6e6;
scrollbar-highlight-color: #ffffff;
scrollbar-shadow-color: #ffffff;
scrollbar-3dlight-color: #cccccc;
scrollbar-arrow-color: #333333;
scrollbar-track-color: #ffffff;
scrollbar-darkshadow-color: #cccccc;
}
-->
</style>

</head>
<body>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'] ?>">


<h2>KOMPONENT DATABAS</h2>

<form method="post" action="insert_kunder.php">

Part Number:<br>
<input name="parnum" type="text" size="30"><br>

Description:<br>
<input name="descript" type="text" size="30"><br>

Value:<br>
<input name="value" type="text" size="30"><br>

Group:<br>
<input name="group" type="text" size="30"><br>

Cost:<br>
<input name="cost" type="text" size="30"><br>

Supplier:<br>
<input name="suppli" type="text" size="30"><br>

Supplier Part Nr:<br>
<input name="supparnum" type="text" size="30"><br>

Alt Supplier:<br>
<input name="altsuppli" type="text" size="30"><br>

Alt Supplier Part Nr:<br>
<input name="altsupparnum" type="text" size="30"><br>

Layout Simbol:<br>
<input name="layout" type="text" size="30"><br>

Data Sheet:<br>
<input name="datasheet" type="text" size="30"><br>

Manufacture Part Nr:<br>
<input name="manparnum" type="text" size="30"><br>


Release:<br>
<input name="release" type="text" size="30"><br><br>


<table width="300" border="0">
	<tr>
		<td width="114">Surface Mount:
		</td>
		<td><select name="surfacemount">
		<option selected>-- select --</option>
		<option>Yes</option>
		<option>No</option>
		</select>
		</td>
	</tr>
	<tr>
		<td width="114">RoHS Compliant:
		</td>
		<td><select name="rohs">
		<option selected>-- select --</option>
		<option>Yes</option>
		<option>No</option>
		</select>
		</td>
	</tr>

	<tr>
		<td width="114">Activ:
		</td>
		<td>
		<select name="activ">
		<option selected>-- select --</option>
		<option>Yes</option>
		<option>No</option>
		</select>
		</td>
		</tr>
		</table>

<br>

Comment:<br>
<textarea name="comment" cols="23" rows="6" 
style="border-top: 2px solid #CC6630; border-bottom: 2px solid #CC6630;"></textarea>

<br>
<br>

<input type="submit" value="Accept"><b> </b><input type="reset" name="Rensa" value="Reset">
<b> </b><input type="submit" value="Search">


<?php

// ansluter till databasen
$opendb = mysql_connect("localhost", "root", "password") or die(mysql_error());
mysql_select_db("kunder_order") or die(mysql_error());

// hämtar information från den angivna tabellen
$result = mysql_query("SELECT * FROM kunder WHERE kundnr='$_POST[kundnr]' 
OR fnamn LIKE '$_POST[fnamn]' OR enamn LIKE '$_POST[enamn]' OR ort LIKE '$_POST[ort]'")

or die(mysql_error());

// HTML-tabellens formatering - tabellstart
echo "Resultatet av sökningen:<br />";
echo "<table border='1' bordercolor='#cccccc' cellspacing='0' cellpadding='3'>";
echo "<tr bgcolor='#cccccc'><td>Kundnr</td>
         <td>Förnamn</td><td>Efternamn</td><td>Ort</td></tr>";

// hämtar resultatrader från tabellen
while($row = mysql_fetch_array( $result )) 
     {
     // skriver ut innehållet i raderna till HTML-tabellen

     echo "<tr><td>"; 
     echo $row['parnum'];
     echo "</td><td>"; 
     echo $row['descript'];
     echo "</td><td>"; 
     echo $row['value'];
     echo "</td><td>"; 
     echo $row['group'];
     echo "</td><td>"; 
     echo $row['cost'];
     echo "</td><td>"; 
     echo $row['suppli'];
     echo "</td><td>"; 
     echo $row['supparnum'];
     echo "</td><td>"; 
     echo $row['altsuppli'];
     echo "</td><td>"; 
     echo $row['altsupparnum'];
     echo "</td><td>"; 
     echo $row['layout'];
     echo "</td><td>"; 
     echo $row['datasheet'];
     echo "</td><td>"; 
     echo $row['manparnum'];
     echo "</td><td>"; 
     echo $row['release'];
     echo "</td><td>"; 
     echo $row['surfacemount'];
     echo "</td><td>"; 
     echo $row['rohs'];
     echo "</td><td>"; 
     echo $row['activ'];
     echo "</td><td>"; 
     echo $row['comment'];
     echo "</td></tr>"; 
     }

// HTML-tabellens formatering - tabellslut
echo "</table>"; 

// stänger databasen
mysql_close($opendb);

?>
</form>







</body>
</html>