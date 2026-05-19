<?php

	header("Access-Control-Allow-Origin: *");
	header("Access-Control-Allow-Headers: Content-Type");
    date_default_timezone_set('America/Sao_Paulo');	
	
	include('conexaosenha.php'); 
	
    $tipo = $_GET['tipo'];
    $seq = $_GET['seq'];

    $data = new DateTime(); 
	
    $sdata = $data->format('Y-m-d');
	$shora = $data->format('H:i:s'); 

	try 
	{ 
		// Grava banco de dados
		if ($tipo == "P") {
		$conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));		
		
        $query = "insert into cadastro(senha_n,senha_L,tb01_data,hora,atendido) values ('$seq','$tipo','$sdata','$shora','N')";
				  
		$grava = $conecta->prepare($query);
		$grava->execute(array()); 
		}
		else {
			$conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));		
		
			$query = "insert into cadastro(senha_n2,senha_L,tb01_data,hora,atendido) values ('$seq','$tipo','$sdata','$shora','N')";
					  
			$grava = $conecta->prepare($query);
			$grava->execute(array()); 
		}
	} 
	catch(PDOException $e) 
	{ 
		echo('Deu erro: ' . $e->getMessage()); 
	}
 
?>
