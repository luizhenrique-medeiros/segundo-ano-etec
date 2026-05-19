<?php
ini_set('default_charset', 'UTF-8');
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Headers: Content-Type");

include('conexaosenha.php'); 
$conn = new mysqli($servidor, $usuario, $senha, $banco);
date_default_timezone_set('America/Sao_Paulo');
$dati = new DateTime();

$dataHora = $dati->format('Y-m-d H:i:s');

$data = json_decode(file_get_contents('php://input'), true);

$valor = (int) $data['valor'];
$ganhou = $data['ganhou'];
$valorGanho = (int) $data['valorGanho'];
$sql = "INSERT INTO tb01_apostas (tb01_data_hora, tb01_valor_apostado, tb01_ganhadores) VALUES ('$dataHora', '$valor', '$ganhou')";
$conn->query($sql);
if ($conn->query($sql)){
if ($ganhou){
$sqlGanhos="INSERT INTO tb02_ganhos (tb02_aposta_id, tb02_valor_ganho) VALUES ($last_id, $valorGanho)";
}
//$sqlCount = "SELECT COUNT(*) as total FROM tb01_apostas"
//$result = $conn->query($sqlCount);
//$row = $result->fetch_assoc();
//echo json_encode(['totalApostas' => $row['total']]);
echo("icluiu");
}
else{
http_response_code(500);
echo json_encode(["error" => "Erro ao inserir dados"]);
}
$conn->close();
?>
