<?php

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include('conexaosenha.php');
$senha1 = $_GET['senha_n'];
$senha2 = $_GET['senha_n2'];

	try 
	{ 
		
		$conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));		
		
        $query = "UPDATE cadastro set atendido = 'S' WHERE senha_n = '$senha1' AND senha_n2 = '$senha2' AND atendido = 'N'";
				  
		$grava = $conecta->prepare($query);
		$grava->execute(array()); 
				
	} 
	catch(PDOException $e) 
	{ 
		echo('Deu erro: ' . $e->getMessage()); 
	}
 
?>
