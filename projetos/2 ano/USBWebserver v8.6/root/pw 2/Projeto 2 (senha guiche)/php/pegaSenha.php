<?php

ini_set('default_charset','UTF-8');

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");
header('Content-Type: application/json'); // Definir o tipo da resposta como JSON

include('conexaosenha.php'); 

$tipo = $_GET['tipo'];

try { 
    if ($tipo == "P") {
$conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha);
    $conecta->exec("SET CHARACTER SET utf8");
    $consulta = $conecta->prepare("SELECT max(senha_n) as senha, senha_L FROM cadastro where senha_L = '$tipo'");
    $consulta->execute(array()); 
    $resultadoDaConsulta = $consulta->fetchAll();

    $StringJson = "["; 		
    if (!count($resultadoDaConsulta) ) {
        $StringJson .= '{"senha_n":"vazio"}]';
        echo($StringJson);
    }
                    
    if ( count($resultadoDaConsulta) ) {
      foreach($resultadoDaConsulta as $registro) 
      { 
        if ($StringJson != "[") 
            {$StringJson .= ",";}
        
        $StringJson .= '{"senha_n":"' . $registro['senha']  . '",';
        $StringJson .= '"senha_L":"' . $registro['senha_L'] . '"}';
        
        }  
    echo $StringJson . "]"; 
    } 
    }
    else {
            $conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha);
                $conecta->exec("SET CHARACTER SET utf8");
                $consulta = $conecta->prepare("SELECT max(senha_n2) as senha, senha_L FROM cadastro where senha_L = '$tipo'");
                $consulta->execute(array()); 
                $resultadoDaConsulta = $consulta->fetchAll();
            
                $StringJson = "["; 		
                if (!count($resultadoDaConsulta) ) {
                    $StringJson .= '{"senha_n":"vazio"}]';
                    echo($StringJson);
                }
                                
                if ( count($resultadoDaConsulta) ) {
                  foreach($resultadoDaConsulta as $registro) 
                  { 
                    if ($StringJson != "[") 
                        {$StringJson .= ",";}
                    
                    $StringJson .= '{"senha_n":"' . $registro['senha']  . '",';
                    $StringJson .= '"senha_L":"' . $registro['senha_L'] . '"}';
                    
                    }  
                echo $StringJson . "]"; 
                } 

    }


} 







catch(PDOException $e) { // caso retorne erro

    echo('Deu erro: ' . $e->getMessage()); 
}
?>
