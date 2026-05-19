/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classVo;

/**
 *
 * @author Etec
 */
public class classP {
     private String nome;
    private String CPF;
    private String Endereço;
    private String Celular;
    
    public void cadastrar (String n, String c, String e, String ce){

this.nome = n;
this.CPF = c;
this.Endereço = e;
this.Celular = ce;
  }
    
    public String mostrar(){
    
    return "Nome:" + this.nome + "\nCPF:" + this.CPF + "\nEndereço:" + this.Endereço + "\nCelular:" + this.Celular;
    
 }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }
    
    
}
