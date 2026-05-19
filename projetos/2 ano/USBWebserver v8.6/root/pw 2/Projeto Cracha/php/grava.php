<?php
header('Content-Type: application/json');

$conn = new mysqli("localhost", "root", "usbw", "2ds_luizh_bd_crasha");
if ($conn->connect_error) {
    die(json_encode(["erro" => "Erro na conexão: " . $conn->connect_error]));
}

$ta = $_POST['ta'];
$nome = $_POST['nome'];
$funcao = $_POST['funcao'];
$apto = $_POST['apto'];
$vencimento = $_POST['vencimento'];
$treinamento = $_POST['treinamento'];


if (!isset($_FILES['foto']) || $_FILES['foto']['error'] != UPLOAD_ERR_OK) {
    echo json_encode([
        "status" => "erro",
        "mensagem" => "Nenhuma imagem foi enviada. Selecione uma foto para o crachá."
    ]);
    exit;
}

$fotoBlob = file_get_contents($_FILES['foto']['tmp_name']);
$fotoSize = strlen($fotoBlob);

$sql = "REPLACE INTO tb01_colaborador 
        (tb01_ta, tb01_nome, tb01_funcao, tb01_apto, tb01_vencimento, tb01_treinamento, tb01_foto)
        VALUES (?, ?, ?, ?, ?, ?, ?)";

$stmt = $conn->prepare($sql);
$stmt->bind_param("issssss", $ta, $nome, $funcao, $apto, $vencimento, $treinamento, $fotoBlob);

// Se quiser garantir o envio de grandes blobs, pode usar send_long_data, mas para imagens pequenas bind_param já resolve
// if ($fotoSize > 0) {
//     $stmt->send_long_data(6, $fotoBlob);
// }

if ($stmt->execute()) {
    $resposta = [
        "status" => "sucesso",
        "ta" => $ta,
        "nome" => $nome,
        "funcao" => $funcao,
        "apto" => $apto,
        "vencimento" => $vencimento,
        "treinamento" => $treinamento,
        "foto_tamanho" => $fotoSize
    ];
} else {
    $resposta = [
        "status" => "erro",
        "mensagem" => $stmt->error
    ];
}

$stmt->close();
$conn->close();

echo json_encode($resposta);
?>
