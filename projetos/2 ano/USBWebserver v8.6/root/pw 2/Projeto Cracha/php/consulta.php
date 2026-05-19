<?php
$ta = $_GET['ta'];

$conn = new mysqli("localhost", "root", "usbw", "2ds_luizh_bd_crasha");
if ($conn->connect_error) {
    die("Erro na conexão: " . $conn->connect_error);
}

$sql = "SELECT * FROM tb01_colaborador WHERE tb01_ta='$ta'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();

    // Se a coluna tb01_foto for blob
    if (!empty($row['tb01_foto'])) {
        $row['tb01_foto'] = base64_encode($row['tb01_foto']);
    }

    echo json_encode($row);
} else {
    echo json_encode([]);
}
$conn->close();
?>
