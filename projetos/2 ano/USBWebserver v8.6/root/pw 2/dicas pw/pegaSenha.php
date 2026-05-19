<?php

	ini_set('default_charset','UTF-8');
	
	header("Access-Control-Allow-Origin: *");
	header("Access-Control-Allow-Headers: Content-Type");
	
    include('conexao-senha.php'); 

	$tipo = $_GET['tipo'];

    try { 
		$conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha);
		$conecta->exec("SET CHARACTER SET utf8");
		$consulta = $conecta->prepare("SELECT max(tb01_seq) as senha, tb01_tipo FROM tb01_senhas where tb01_tipo = '$tipo'");
		$consulta->execute(array()); 
		$resultadoDaConsulta = $consulta->fetchAll();
 
		$StringJson = "["; 
		
		if (!count($resultadoDaConsulta) ) {
			$StringJson .= '{"tb01_seq":"vazio"}]';
			echo($StringJson);
		}
						
	    if ( count($resultadoDaConsulta) ) {
		  foreach($resultadoDaConsulta as $registro) 
		  { 
			if ($StringJson != "[") 
				{$StringJson .= ",";}
			
			$StringJson .= '{"tb01_seq":"' . $registro['senha']  . '",';
			$StringJson .= '"tb01_tipo":"' . $registro['tb01_tipo'] . '"}';
			
		    }  
		echo $StringJson . "]"; 
        } 
 
	} catch(PDOException $e) { // caso retorne erro

		echo('Deu erro: ' . $e->getMessage()); 
	}
?>
