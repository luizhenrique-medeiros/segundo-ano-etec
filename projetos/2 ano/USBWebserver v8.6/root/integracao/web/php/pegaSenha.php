<?php
ini_set('default_charset','UTF-8');
header("Access-Control-Allow-Origin: *");  // Permite qualquer origem
header("Access-Control-Allow-Methods: GET, POST, PUT, DELETE");  // Permite os métodos HTTP que você usa
header("Access-Control-Allow-Headers: Content-Type");  // Permite cabeçalhos como Content-Type
header('Content-Type: application/json'); // Definir o tipo da resposta como JSON


include('conexaosenha.php'); 


try { 
    $conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha);
    $conecta->exec("SET CHARACTER SET utf8");

    $dados = $conecta->prepare("SELECT * FROM tb01_pedidos WHERE tb01_status = '0'");
    $dados->execute(array()); 
    $resultdados= $dados->fetchAll(PDO::FETCH_ASSOC); 

    $StringJson = "["; 		            
    if (count($resultdados)) {
        foreach($resultdados as $registro) { 
            if ($StringJson != "[") {
                $StringJson .= ",";
            }

            $StringJson .= '{';
            $StringJson .= '"ID":"' . $registro['tb01_ID'] . '",';
            $StringJson .= '"status":"' . $registro['tb01_status'] . '",';
            $StringJson .= '"data":"' . $registro['tb01_data'] . '",';
            $StringJson .= '"horario_partida":"' . $registro['tb01_horario_partida'] . '",';
            $StringJson .= '"horario_chegada":"' . $registro['tb01_horario_chegada'] . '",';
            $StringJson .= '"cpf":"' . $registro['tb01_cpf'] . '",';
            $StringJson .= '"idp":"' . $registro['tb01_idp'] . '"';
            $StringJson .= '}';
        }  
        echo $StringJson . "]"; 
    } 
}
catch(PDOException $e) {
    echo('Deu erro: ' . $e->getMessage()); 
}  
?>
