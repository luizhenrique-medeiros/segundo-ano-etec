async function atualizarStatus(id, index) {
    try {
        const response = await fetch("php/atualizaStatus.php", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: `id=${id}`
        });
        const resultado = await response.json();

        if(resultado.sucesso) {
            const statusCell = document.getElementById(`status-${index}`);
            statusCell.textContent = "Entregue";

            const chegadaCell = document.getElementById(`chegada-${index}`);
            const agora = new Date();
            const hora = String(agora.getHours()).padStart(2, "0");
            const minuto = String(agora.getMinutes()).padStart(2, "0");
            chegadaCell.textContent = `${hora}:${minuto}`;
        } else {
            console.error("Erro ao atualizar status:", resultado.erro);
        }
    } catch (erro) {
        console.error("Erro na requisição:", erro);
    }
}

async function carregarPedidos() {
    try {
        const response = await fetch("php/pegaSenha.php");
        const pedidos = await response.json();

        const tabela = document.getElementById("tabela-pedidos");
        tabela.innerHTML = "";

        pedidos.forEach((p, index) => {
            const linha = document.createElement("tr");

            linha.innerHTML = `
                <td>${p.ID}</td>
                <td id="status-${index}">${p.status == 0 ? "Não entregue" : "Entregue"}</td>
                <td>${p.data}</td>
                <td>${p.horario_partida}</td>
                <td id="chegada-${index}">${p.horario_chegada}</td>
                <td>${p.cpf}</td>
                <td>${p.idp}</td>
                <td><button id="btn-${index}">Atualizar</button></td>
            `;

            tabela.appendChild(linha);

            const botao = document.getElementById(`btn-${index}`);
            botao.addEventListener("click", () => {
                if(p.status == 0) {
                    atualizarStatus(p.ID, index);
                    alert("teste");
                    p.status = 1; 
                }
            });
        });
    } catch (erro) {
        console.error("Erro ao carregar pedidos:", erro);
    }
}

document.addEventListener("DOMContentLoaded", carregarPedidos);
