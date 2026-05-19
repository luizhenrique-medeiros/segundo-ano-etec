/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Etec
 */
public class classPet {
    private String nome;
    private String especie;
    private String responsavel;
    private int idade;
    

public void cadastrar (String n, String e, int i, String r){

this.nome = n;
this.responsavel = r;
this.idade = i;
this.especie = e;
  }

public String mostrar(){
    
    return "Nome:" + this.nome + "\nresponsavel:" + this.responsavel + "\nIdade" + this.idade + "\nespecie" + this.especie;
    
 }   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
