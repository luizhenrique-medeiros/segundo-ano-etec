
var senha;
var dia;
var mes; 
var ano;

var horas;
var minutos; 
var segundos;
var msg;

function atuapagina() {
	var xmlhttp = new XMLHttpRequest();

	var url = "http://localhost:8080/pw%202/projeto%202.1%20(guiche)/php/atuapagina.php";
	xmlhttp.open("GET", url, true);
xmlhttp.send();

  }
  window.addEventListener('load', atuapagina);



function emiteSenha(tipo)
	{
		senha++;
			
		var xmlhttp = new XMLHttpRequest();

		var url = "http://localhost:8080/pw%202/Projeto%202%20(senha%20guiche)/php/gerasenha.php/?tipo=" + tipo + "&seq=" + senha;

    xmlhttp.open("GET", url, true);
    xmlhttp.send();

		gerasenha(tipo);
	}


		// Pega a ultima senha de acordo com o tipo
		function pegaSenha(tipo)
		{
	
	
			var xmlhttp = new XMLHttpRequest();
			
			var url = "http://localhost:8080/pw%202/Projeto%202%20(senha%20guiche)/php/pegaSenha.php/?tipo=" + tipo;
			
			xmlhttp.onreadystatechange = function () 
			{
				
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
				{
					ConectaServidor(xmlhttp.responseText);
				}
			}
			
			xmlhttp.open("GET", url, true);
			xmlhttp.send();
			
				
			function ConectaServidor(response) {
				
				var dados = JSON.parse(response); //faz a conversão do texto da WEB para JSON
				var i=0;
				var conteudo = "";
				var linhas;
				
				// O for() vai montar a linha (<TR>) da tabela
				for (i = 0; i < dados.length; i++) //dados.length retorna o tamanho do vetor.
				{
					if (dados[i].senha_n == "vazio")
					{
						senha=1;
						conteudo += senha+1;
					}
					else{
					
						senha = String(dados[i].senha_n.padStart(2, '0'));
						conteudo += Math.trunc(dados[i].senha_n) + 1;
				}
				}	
	
				document.getElementById('num').innerHTML = tipo + conteudo;	
				
				emiteSenha(tipo);	
			
			}	
			
		}
		// Gera o papel da senha

	
function gerasenha(tipo) {
    var conteudo = "<br><br>";

    montaData(); // Pega a data/hora atual

    conteudo += "<p style='margin-top: 15%'>============================</p>";
    conteudo += "<p style='font-size: 20px;'>SENHA</p>";
    conteudo += "<p>============================</p>";
    // Certifique-se que o elemento 'num' existe e tem o valor da senha
    conteudo += "<p style='font-size: 32px; margin-top: 25%'>" + (document.getElementById('num') ? document.getElementById('num').innerHTML : 'N/A') + "</p>";
    conteudo += "<p style='font-size: 16px; margin-top: 37%'>" + dia + "/" + mes + "/" + ano + "</p>";
    conteudo += "<p style='font-size: 16px; margin-top: 5%'>" + horas + ":" + minutos + ":" + segundos + "</p>";

    const comprovanteElement = document.getElementById('comprovate');
    if (comprovanteElement) {
        comprovanteElement.innerHTML = conteudo;
    } else {
        console.error("Elemento 'comprovate' não encontrado!");
        return; // Aborta se o elemento principal não existir
    }


    // Atualiza outros elementos de data/hora se existirem
    const dataElement = document.getElementById('data');
    const horaElement = document.getElementById('hora');
    if (dataElement) dataElement.innerHTML = dia + "/" + mes + "/" + ano;
    if (horaElement) horaElement.innerHTML = horas + ":" + minutos + ":" + segundos;
    movimento(1);
}

function movimento(duracao) {
    const element = document.getElementById('comprovate');
    if (!element) {
        console.error("Elemento 'comprovate' não foi encontrado para a animação.");
        return; 
    }

    
    const startTop = 0;     
    const finalTop = 255;        
    const visiblePoint = 200;   
   

    let currentTop = startTop; // Posição vertical atual começa no ponto inicial

   
    element.style.position = 'absolute';
    element.style.left = '800px'; 
    element.style.top = currentTop + 'px';
    element.style.visibility = 'hidden'; 
	
    

    
    function deslocamento() {
        // Verifica se ainda não chegou ao ponto final
        if (currentTop < finalTop) {
            currentTop++; 
            element.style.top = currentTop + 'px'; 

            // Verifica se alcançou ou passou o ponto onde deve ficar visível
            if (currentTop >= visiblePoint) {
                element.style.visibility = 'visible';
            }
        } 
    }

    const id = setInterval(deslocamento, duracao);
}

	function montaData()
	{
		const dataAtual = new Date();

		dia = String(dataAtual. getDate()). padStart(2, '0');
		mes = addZero(dataAtual.getMonth() + 1);
		ano = addZero(dataAtual.getFullYear());

		horas = addZero(dataAtual.getHours());
		minutos = addZero(dataAtual.getMinutes());
		segundos = addZero(dataAtual.getSeconds());
	}
	function addZero(i){
		if (i<10 ){
			i="0" + i
		}
		return i;
	}



