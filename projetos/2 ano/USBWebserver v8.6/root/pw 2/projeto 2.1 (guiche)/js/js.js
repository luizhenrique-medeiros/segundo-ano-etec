var senha_n = 0 ;
function atuaSenha(senha,senha2)
	{		
		// SENHA È O SENHA_N
		//SENHA2 È O SENHA_N2
		//SENHA3 È O TIPO
		var xmlhttp = new XMLHttpRequest();

		var url = "http://localhost:8080/pw%202/projeto%202.1%20(guiche)/php/atuaSenha.php/?senha_n=" + senha + "&senha_n2=" + senha2;
		
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}
	function atuaSenha2(senha2,senha)
	{		
		// SENHA È O SENHA_N
		//SENHA2 È O SENHA_N2
		//SENHA3 È O TIPO
		var xmlhttp = new XMLHttpRequest();

		var url = "http://localhost:8080/pw%202/projeto%202.1%20(guiche)/php/atuaSenha.php/?senha_n2=" + senha2 + "&senha_n=" + senha;
		
		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	}


		function pegaSenha()
		{
			senha_n = senha_n+1;

			var xmlhttp = new XMLHttpRequest();
			
			var url = "http://localhost:8080/pw%202/projeto%202.1%20(guiche)/php/pegaSenha.php/?senha_n=" + senha_n;
			
			xmlhttp.onreadystatechange = function () 
			{
				
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
				{
					ConectaServidor(xmlhttp.responseText);
				}
			}
			
			xmlhttp.open("GET", url, true);
			xmlhttp.send();
		}
				
		function ConectaServidor(response) {
			var dados = JSON.parse(response); 
			var i = 0;
			var verificar2 = 0; 
			var verificar = 0; 
			var senha = "";
			var senha2 = "";
			var senha3 = "";
		
			for (i = 0; i < dados.length; i++) 
			{
				if ((dados[i].senha_n == "vazio") || (dados[i].senha_n2 == "vazio")) {
					alert("não há mais pacientes");
					return;
					
				} else {
					if (dados[i].verificar !== undefined) { 
						verificar = parseInt(dados[i].verificar); 
					}
					
					if (verificar == 0) {
						if (dados[i].senha_n !== undefined) {
							senha = String(dados[i].senha_n).padStart();
							senha3 = String(dados[i].senha_L);
						}
					} else {
						if (dados[i].senha_n2 !== undefined) {
							senha2 = String(dados[i].senha_n2).padStart();
							senha3 = String(dados[i].senha_L);
						}
					}
				}
			}
		
			let numeroAleatorio = Math.floor(Math.random() * 5) + 1;
			document.getElementById('guiche').innerHTML = numeroAleatorio;
		
			if (verificar == 0) {
				document.getElementById('num').innerHTML = senha3 + senha;
				document.getElementById('chamadas').innerHTML += senha3 + senha + "<br>";  
				senha2 = 0;
				atuaSenha(senha,senha2);  
			} else {
				document.getElementById('num').innerHTML = senha3 + senha2;
				document.getElementById('chamadas').innerHTML += senha3 + senha2 + "<br>";
				senha = 0;
				 atuaSenha2(senha2,senha);
			}
		}
		
		
	
		function atuapagina() {
			var xmlhttp = new XMLHttpRequest();

			var url = "http://localhost:8080/pw%202/projeto%202.1%20(guiche)/php/atuapagina.php";
			xmlhttp.open("GET", url, true);
		xmlhttp.send();

		  }
		  window.addEventListener('load', atuapagina);