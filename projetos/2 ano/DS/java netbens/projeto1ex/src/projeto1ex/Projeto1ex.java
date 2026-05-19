/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto1ex;

import classes.classe_pessoa;
import tela.TelaPessoa;

/**
 *
 * @author Etec
 */
public class Projeto1ex {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        classe_pessoa alguem = new classe_pessoa();
        alguem.cadastrar("Luiz", "Rua:Santina N° 90", 20, 1234567890);
        System.out.println(alguem.mostrar());
        
        classe_pessoa fulano = new classe_pessoa();
        alguem.cadastrar("Luna", "Rua:Caixique N° 236", 17,231457680);
        System.out.println(alguem.mostrar());
    }
    
}
