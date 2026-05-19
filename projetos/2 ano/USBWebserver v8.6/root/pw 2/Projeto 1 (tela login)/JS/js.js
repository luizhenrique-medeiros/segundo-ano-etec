$(document).ready(function() {
    // Exibe o modal ao carregar a página
    $("#ageModal").modal('show');
});



function pegaComanda()
{
    var usuario = document.getElementById("user").value;
    var senha = document.getElementById("pass").value;

    var xmlhttp = new XMLHttpRequest();
    

    //Prepara link para acionar PHP
    //http://localhost:8080/PW/Projeto%201%20(tela%20login)/php/pegaComanda.php?user=vitor@gmail.com&pass=123
    var url = "http://localhost:8080/pw%202/Projeto%201%20(tela%20login)/php/pegaComanda.php?user="+usuario+"&pass="+senha;
    
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
            if (dados[i].tb01_senha == "vazio" || dados[i].tb01_email == "vazio")
            {					
                alert ("Senha ou email não encontrados")

            }
            else
            {
                comanda = dados[i].tb01_senha; 
                comanda++;
                document.getElementById('pass').innerHTML = dados[i].tb01_senha;
                senia = dados[i].tb01_senha;
                comanda = dados[i].tb01_email; 
                comanda++;
                document.getElementById('user').innerHTML = dados[i].tb01_email;
                email = dados[i].tb01_email;
                window.location.href = "https://www.google.com";
                

            }
        }			
    }		
}