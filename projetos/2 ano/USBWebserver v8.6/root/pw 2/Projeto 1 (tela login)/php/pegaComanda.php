<?php

	ini_set('default_charset','UTF-8');
	
	header("Access-Control-Allow-Origin: *");
	header("Access-Control-Allow-Headers: Content-Type");
	
    include('conexao-kilo.php'); 

    $user = $_GET['user'];
    $pass = $_GET['pass'];


    try { 
		$conecta = new PDO("mysql:host=localhost:3307;dbname=luiz_bd_login", "root" , "usbw");
		$conecta->exec("SET CHARACTER SET utf8");
		$consulta = $conecta->prepare("SELECT * FROM tb01_login where tb01_email = '$user' and tb01_senha = '$pass'");
		$consulta->execute(array()); 
		$resultadoDaConsulta = $consulta->fetchAll();
 
		$StringJson = "["; 
		
		if (!count($resultadoDaConsulta) ) {
			$StringJson = '[{"tb01_senha":"vazio"},{"tb01_email":"vazio"}]';
			echo($StringJson);
		}
						
	    if ( count($resultadoDaConsulta) ) {
		  foreach($resultadoDaConsulta as $registro) 
		  { 
			if ($StringJson != "[") 
				{$StringJson .= ",";}
			
			$StringJson .= '{"tb01_senha":"' . $registro['tb01_senha']  . '",';
			$StringJson .= '"tb01_email":"' . $registro['tb01_email'] . '"}';
			
		    }  
		echo $StringJson . "]"; 
        } 
 
	} catch(PDOException $e) { // caso retorne erro

		echo('Deu erro: ' . $e->getMessage()); 
	}
?>
