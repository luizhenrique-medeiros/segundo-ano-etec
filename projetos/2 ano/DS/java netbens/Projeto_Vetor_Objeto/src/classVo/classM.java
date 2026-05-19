/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classVo;

/**
 *
 * @author Etec
 */
public class classM {
    private String nome;
    private String CRM;
    private String Especialidade;
    
    public void cadastrar (String n, String c, String e){

this.nome = n;
this.CRM = c;
this.Especialidade = e;

  }
    
    public String mostrar(){
    
    return "Nome:" + this.nome + "\nCRM:" + this.CRM + "\nEspecialidade:" + this.Especialidade ;
    
 }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }
    
    
}
