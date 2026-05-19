<?php

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include('conexaosenha.php');

	try 
	{ 
		// Grava banco de dados
		
		$conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));		
		
        $query = "UPDATE teste set senha_atual= '0'";
				  
		$grava = $conecta->prepare($query);
		$grava->execute(array()); 
				
	} 
	catch(PDOException $e) 
	{ 
		echo('Deu erro: ' . $e->getMessage()); 
	}
 
?>
