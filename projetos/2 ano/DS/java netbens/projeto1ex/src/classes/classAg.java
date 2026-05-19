/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Etec
 */
public class classAg {
    private String data;
    private String horario;
    private String pet;
    private String responsavel;

public void cadastrar (String d, String h, String p, String r){

this.data = d;
this.horario = h;
this.pet = p;
this.responsavel = r;
  }

public String mostrar(){
    
    return "Data:" + this.data + "\nHorario:" + this.horario + "\nPet:" + this.pet + "\nResponsavel:" + this.responsavel;
    
 }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }


}
