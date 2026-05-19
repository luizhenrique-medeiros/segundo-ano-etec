<?php
ini_set('default_charset','UTF-8');

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");
header('Content-Type: application/json'); // Definir o tipo da resposta como JSON


$senha2 = $_GET['senha_n'];



include('conexaosenha.php'); 


try { 
    $conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha);
    $conecta->exec("SET CHARACTER SET utf8");
    $consultaPrioritario = $conecta->prepare("SELECT senha_n, senha_L FROM cadastro WHERE senha_L = 'P' AND senha_n = '$senha2' AND atendido = 'N'");
    $consultaPrioritario->execute(array()); 
    $resultadoPrioritario = $consultaPrioritario->fetchAll(PDO::FETCH_ASSOC);




if (!empty($resultadoPrioritario)) {

    
$StringJson = "["; 		
    if (!count($resultadoPrioritario) ) {
        $StringJson .= '{"senha_n":"vazio"}]';
        echo($StringJson);
    }
                    
    if ( count($resultadoPrioritario) ) {
      foreach($resultadoPrioritario as $registro) 
      { 
        if ($StringJson != "[") 
            {$StringJson .= ",";}
        
        $StringJson .= '{"senha_n":"' . $registro['senha_n']  . '",';
        $StringJson .= '"senha_L":"' . $registro['senha_L'] . '",';
        $StringJson .= '"verificar":"0"}';
        
        }  
    echo $StringJson . "]"; 
    } 

 }

 else {

$consultaSenha = $conecta->prepare("SELECT senha_atual FROM teste WHERE id = 1");
$consultaSenha->execute();
$resultadoSenha = $consultaSenha->fetch(PDO::FETCH_ASSOC);

if ($resultadoSenha) {
    $senha3 = $resultadoSenha['senha_atual']; 

  
    $novaSenha = $senha3 + 1;
    $atualizaSenha = $conecta->prepare("UPDATE teste SET senha_atual = :novaSenha WHERE id = 1");
    $atualizaSenha->execute(array(':novaSenha' => $novaSenha));
} 
   else {
    $senha3 = 0; 
   }

    $consultaNormal = $conecta->prepare("SELECT senha_n2, senha_L FROM cadastro WHERE senha_L = 'N' AND senha_n2 = '$senha3' AND atendido = 'N'");
    $consultaNormal->execute(array()); 
    $resultadoNormal = $consultaNormal->fetchAll(PDO::FETCH_ASSOC);;


    $StringJson = "["; 		
    if (!count($resultadoNormal) ) {
        $StringJson .= '{"senha_n2":"vazio"}]';
        echo($StringJson);
    }
                    
    if ( count($resultadoNormal) ) {
      foreach($resultadoNormal as $registro) 
      { 
        if ($StringJson != "[") 
            {$StringJson .= ",";}
        
            $StringJson .= '{"senha_n2":"' . $registro['senha_n2']  . '",';
            $StringJson .= '"senha_L":"' . $registro['senha_L'] . '",';
            $StringJson .= '"verificar":"1"}';
            
        }  
    echo $StringJson . "]"; 
    } 



 }
 
}
catch(PDOException $e) { // caso retorne erro

    echo('Deu erro: ' . $e->getMessage()); 

}   

?>
