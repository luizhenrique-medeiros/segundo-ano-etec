/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author etec
 */
public class corrida {
    
    private String resultado;
    private int inscricao;
    private String nome;
    private double peso;
    private double altura;
    private String sexo;
    private String email;
    Conexao con;

    public ResultSet PesquisarTodos(){
    ResultSet rs = null;
    con= new Conexao();
     String todos = "SELECT * FROM tb01_corrida WHERE tb01_nome LIKE '%" + this.nome + "%'";
    try{
        con.Conectar();
        rs = con.selectSQL(todos);
        //con.desconectar();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println("Erro:"+ex);
    }
    return rs;
    }
    
     public ResultSet PesquisarTodos2(){
    ResultSet rs = null;
    con= new Conexao();
     String todos = "SELECT * FROM tb01_corrida";
    try{
        con.Conectar();
        rs = con.selectSQL(todos);
        //con.desconectar();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println("Erro:"+ex);
    }
    return rs;
    }
public void corrida (String r,int i,String n,Double p,Double a,String s, String e){
     this.resultado =r;
    this.inscricao=i;
    this.nome=n;
    this.peso=p;
    this.altura=a;
    this.sexo=s;
    this.email=e;
}
     
    
    
    
    public int getInscricao() {
        return inscricao;
    }

    public void setInscricao(int inscricao) {
        this.inscricao = inscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    

      
}

