let currentBet = 0;

document.querySelectorAll('.bet').forEach(button => {
    button.addEventListener('click', () => {
        currentBet += parseInt(button.getAttribute('data-value'));
        document.getElementById('currentBet').innerText = currentBet;
    });
});

document.getElementById('lever').addEventListener('click', () => {
    const slot1 = Math.floor(Math.random() * 10);
    const slot2 = Math.floor(Math.random() * 10);
    const slot3 = Math.floor(Math.random() * 10);

    document.getElementById('slot1').innerText = slot1;
    document.getElementById('slot2').innerText = slot2;
    document.getElementById('slot3').innerText = slot3;

    let ganhou = false;
    let valorGanho = 0;

    if (slot1 === slot2 && slot2 === slot3) {
        ganhou = true;
        valorGanho = currentBet * (slot1 + 1);
        document.getElementById('valorGanho').innerText = valorGanho;
    } else {
        document.getElementById('valorPerdido').innerText = currentBet;
    }

    saveResult(currentBet, ganhou, valorGanho);

    currentBet = 0;
    document.getElementById('currentBet').innerText = currentBet;
});

function saveResult(valor, ganhou, valorGanho) {
    fetch('php/php.php', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ valor, ganhou, valorGanho })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('totalApostas').innerText = data.totalApostas;
    })
    .catch(error => console.error('Erro ao salvar resultado:', error));
}
