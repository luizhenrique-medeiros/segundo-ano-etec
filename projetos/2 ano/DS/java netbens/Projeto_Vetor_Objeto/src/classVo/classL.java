/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classVo;

/**
 *
 * @author Etec
 */
public class classL {
    private String nome;
    private String senha;
    
  public void cadastrar (String n, String s)   {
   
      this.nome = n;
    this.senha = s;
  }
   public String mostrar(){
    
    return "Nome:" + this.nome + "\nSenha:" + this.senha;
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
