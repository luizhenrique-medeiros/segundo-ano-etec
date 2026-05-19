// Preview da foto
document.getElementById("fotoInput").addEventListener("change", function (e) {
    const file = e.target.files[0];
    if (file) {
        const reader = new FileReader();

        reader.onload = function (event) {
            document.getElementById("fotoPreview").innerHTML = "";
            document.getElementById("fotoPreview").style.backgroundImage = `url(${event.target.result})`;
            document.getElementById("fotoPreview").style.backgroundSize = "cover";
            document.getElementById("crachaFoto").src = event.target.result;
        };
        reader.readAsDataURL(file);
    }
});

// Consulta (puxar do banco)

function consulta() {
    let ta = document.getElementById("ta").value.trim();
    if (!ta) {
        alert("Preencha o campo: TA");
        document.getElementById("ta").focus();
        return;
    }
    fetch(`php/consulta.php?ta=${ta}`)
        .then(res => res.json())
        .then(data => {
            if (!data || Object.keys(data).length === 0) {
                alert("Colaborador não encontrado!");
                // Limpa os campos
                document.getElementById("nome").value = "";
                document.getElementById("funcao").value = "";
                document.getElementById("apto").value = "";
                document.getElementById("vencimento").value = "";
                document.getElementById("treinamento").value = "";
                document.getElementById("crachaFoto").src = "";
                document.getElementById("fotoPreview").style.backgroundImage = "";
                return;
            }
            document.getElementById("nome").value = data.tb01_nome || "";
            document.getElementById("funcao").value = data.tb01_funcao || "";
            document.getElementById("apto").value = data.tb01_apto || "";
            document.getElementById("vencimento").value = data.tb01_vencimento || "";
            document.getElementById("treinamento").value = data.tb01_treinamento || "";

            // Exibe a imagem se existir
            if (data.tb01_foto) {
                const imgSrc = "data:image/jpeg;base64," + data.tb01_foto;
                document.getElementById("crachaFoto").src = imgSrc;
                document.getElementById("fotoPreview").style.backgroundImage = `url(${imgSrc})`;
            } else {
                document.getElementById("crachaFoto").src = "";
                document.getElementById("fotoPreview").style.backgroundImage = "";
            }
        });
}

// Grava no banco
function grava() {
    if (!validacampo()) return;
    let dados = new FormData();
    dados.append("ta", document.getElementById("ta").value);
    dados.append("nome", document.getElementById("nome").value);
    dados.append("funcao", document.getElementById("funcao").value);
    dados.append("apto", document.getElementById("apto").value);
    dados.append("vencimento", document.getElementById("vencimento").value);
    dados.append("treinamento", document.getElementById("treinamento").value);

    const fileInput = document.getElementById('fotoInput');
    if (fileInput.files[0]) {
        dados.append("foto", fileInput.files[0]);
    }

    fetch("php/grava.php", {
        method: "POST",
        body: dados
    })
    .then(res => res.json())
    .then(data => {
        if (data.status === "sucesso") {
            alert("Colaborador gravado com sucesso!");
        } else if (data.status === "erro") {
            alert(data.mensagem || "Erro ao gravar colaborador.");
        }
    })
    .catch(err => {
        alert("Erro na comunicação com o servidor.");
        console.error("Erro:", err);
    });
}



// Gera crachá
function geraCracha() {
    if (!validacampo()) return;

    const nome = document.getElementById("nome").value.trim();
    const funcao = document.getElementById("funcao").value.trim();

    // Atualiza os campos do crachá
    document.getElementById("crachaNome").textContent = nome;
    document.getElementById("crachaFuncao").textContent = funcao;

    // Limpa o QR Code anterior, se houver
    const qrcodeContainer = document.getElementById("qrcode");
    qrcodeContainer.innerHTML = ""; // importante para não gerar vários sobrepostos

    // Gera o QR Code com o nome do colaborador
    QRCode.toCanvas(qrcodeContainer, nome, { 
        width: 128,            // tamanho do QR Code
        margin: 2,             // margem ao redor
        color: {
            dark: "#000000",   // cor do código
            light: "#ffffff"   // fundo branco
        }
    }, function (error) {
        if (error) {
            console.error("Erro ao gerar QR Code:", error);
            alert("Erro ao gerar o QR Code!");
        } else {
            console.log("QR Code gerado com sucesso!");
        }
    });
}


function imprimirCracha() {
    if (!validacampo()) return;
    let frente = document.getElementById("cracha").outerHTML;
    let verso = document.getElementById("crachaVerso").outerHTML;
    let janela = window.open("", "_blank");
    janela.document.write(`
        <html>
        <head>
            <title>Cracha Funcional</title>
            <link rel="stylesheet" href="css/css.css">
            <style>
                body { margin: 0; padding: 0; }
                .cracha-section { page-break-after: always; }
            </style>
        </head>
        <body>
            ${frente}
            ${verso}
        </body>
        </html>
    `);
    janela.document.close();
    janela.print();
}










function validacampo() {
    const campos = [
        { id: "ta", nome: "TA" },
        { id: "nome", nome: "Nome" },
        { id: "funcao", nome: "Função" },
        { id: "apto", nome: "Apto a" },
        { id: "vencimento", nome: "Vencimento" },
        { id: "treinamento", nome: "Treinamento" }
    ];
    for (const campo of campos) {
        const valor = document.getElementById(campo.id).value.trim();
        if (!valor) {
            alert(`Preencha o campo: ${campo.nome}`);
            document.getElementById(campo.id).focus();
            return false;
        }
    }
    // Validação da foto: exige que o crachaFoto tenha src válido OU que o usuário tenha selecionado uma imagem
    const fileInput = document.getElementById("fotoInput");
    const crachaFoto = document.getElementById("crachaFoto");
    const src = crachaFoto.src || "";
    const temFoto =
        (src.startsWith("data:image") && src.length > 30) || // imagem carregada do banco ou do input
        (fileInput.files && fileInput.files.length > 0);
    if (!temFoto) {
        alert("Selecione uma foto para o crachá.");
        fileInput.focus();
        return false;
    }
    return true;
}



