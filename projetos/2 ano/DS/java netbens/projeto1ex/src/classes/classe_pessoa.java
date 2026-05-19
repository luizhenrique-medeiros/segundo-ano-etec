/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Etec
 */
public class classe_pessoa {
    private String nome;
    private String endereço;
    private int idade;
    private long cpf;

public void cadastrar (String n, String e, int i, long c){

this.nome = n;
this.endereço = e;
this.idade = i;
this.cpf = c;
  }

public String mostrar(){
    
    return "Nome:" + this.nome + "\nEndereço:" + this.endereço + "\nIdade" + this.idade + "\nCpf" + this.cpf;
    
 }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }


}