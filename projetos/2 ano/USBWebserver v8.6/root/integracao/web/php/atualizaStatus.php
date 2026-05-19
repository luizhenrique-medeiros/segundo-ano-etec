<?php
header("Access-Control-Allow-Origin: *");  // Permite qualquer origem
header("Access-Control-Allow-Methods: GET, POST, PUT, DELETE");  // Permite os métodos HTTP que você usa
header("Access-Control-Allow-Headers: Content-Type");  // Permite cabeçalhos como Content-Type
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Headers: Content-Type");

include('conexaosenha.php');

if(isset($_POST['id'])) {
    $id = $_POST['id'];

    try {
        $conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha);
        $conecta->exec("SET CHARACTER SET utf8");

        $stmt = $conecta->prepare("UPDATE tb01_pedidos SET tb01_status = 1 WHERE tb01_ID = :id");
        $stmt->bindParam(':id', $id);
        $stmt->execute();

        echo json_encode(["sucesso" => true]);
    } catch(PDOException $e) {
        echo json_encode(["sucesso" => false, "erro" => $e->getMessage()]);
    }
} else {
    echo json_encode(["sucesso" => false, "erro" => "ID não informado"]);
}
?>
