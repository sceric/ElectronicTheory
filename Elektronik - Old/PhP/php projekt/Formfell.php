<style type="text/css"> 
<!-- 
.text {font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 11px;} 
h2 {font-family: Verdana, Arial, Helvetica, sans-serif;    font-size: 14px; color: #336633; letter-spacing: 2px; font-weight: normal;} 
.textbakgrund {background-color: #ccff66;} 
--> 
</style> 

<?php 

// anger en variabel som kan lagra de eventuella felaktigheterna 
$errors = array(); 
// kontrollera om ett Namn angivits 
if (!$_POST["name"]) 
$errors[] = "- ditt namn"; 
// kontrollera om ett Ämne angivits 
if (!$_POST["subject"]) 
$errors[] = "- ärende i ämnesraden"; 

// kontrollera om en Epostadress angivits 
$emailcheck = $_POST["email"]; 
if(!preg_match("/^[a-z0-9\å\ä\ö._-]+@[a-z0-9\å\ä\ö.-]+\.[a-z]{2,6}$/i", $emailcheck)) 
$errors[] = "- din epostadress saknas eller är felaktig";     

// kontrollera om ett Meddelande angivits 
if (!$_POST["message"]) 
$errors[] = "- inget meddelande har skrivits!"; 
// om felaktig information finns visas detta meddelande 
if (count($errors)>0){ 
echo "<span class='text'>"; 
echo "<h2>Följande information måste anges innan du kan skicka formuläret:</h2><br /><br />"; 
foreach($errors as $fel) 
echo "<span class='textbakgrund'> $fel <br /><br /></span>"; 
echo "<br />Ange den information som saknas och skicka formuläret igen. Tack! <br /><br />"; 
echo "<a href='javascript:history.go(-1)'>&laquo; klicka här för att komma tillbaka till formuläret</a></span>"; 
} 

else { 
// formuläret är korrekt ifyllt och informationen bearbetas 
$to = "din@mailadress.se"; 
$from = $_POST["email"]; 
$subject = $_POST["subject"]; 
$name = $_POST["name"]; 
$message = $_POST["message"]; 

if (mail($to, $subject, $message ,"From: $name <$from>")) 
echo nl2br("<span class='text'><h2>Ditt meddelande har skickats!</h2> 
<b>ämne:</b> $subject 
<b>meddelande:</b> 
$message 
</span>"); 
     
    else 
    echo "Det gick inte att skicka ditt meddelande"; 
} 
?> 