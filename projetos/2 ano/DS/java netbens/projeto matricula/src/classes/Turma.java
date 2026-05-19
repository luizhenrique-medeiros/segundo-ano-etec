
package classes;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Turma {
    private String serie;
    private String nome;
    private String cod;
    Conexao con;

public void consulta (String s,String n,String c){
     this.serie=s;
     this.nome=n;
     this.cod=c;
    }

public Turma(String c, String nome){
    this.cod = c;
    this.nome = nome;
    
}
public int Salvar(){
    int resultado=0;
    con=new Conexao();
    String sql= "INSERT INTO tb02_turma VALUES('" + this.cod + "','" + this.nome + "', '" + this.serie + "')";
    System.out.println(sql);


    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
 public int Excluir(){
    int resultado=0;
    con=new Conexao();
    String sql= "DELETE FROM tb02_turma WHERE tb02_cod_turma="+this.cod;
    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
  public ResultSet PesquisarId(){
    ResultSet rs = null;
    con= new Conexao();
    String todos= "SELECT * FROM tb02_turma WHERE tb02_cod_turma="+this.cod;
    try{
        con.Conectar();
        rs = con.selectSQL(todos);
        //con.desconectar();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println("Erro:"+ex);
    }
    return rs;
    }
   
    public int Atualizar(){
    int resultado=0;
    con=new Conexao();
    String sql= "UPDATE tb02_turma SET tb02_cod_turma='"+this.cod+"', tb02_nome='"+this.nome+"'"+ "WHERE tb02_serie="+this.serie;
    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
 public ResultSet carregar3(){
        ResultSet rs = null;
        con=new Conexao();
        try {
            con.Conectar();
            rs = con.selectSQL("Select tb02_nome , tb02_cod_turma from tb02_turma");            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro: "+ex);
        }
        return rs;
    }
   public ResultSet PesquisarTodos(){
    ResultSet rs = null;
    con= new Conexao();
    String todos= "SELECT * FROM tb02_turma";
    try{
        con.Conectar();
        rs = con.selectSQL(todos);
        //con.desconectar();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println("Erro:"+ex);
    }
    return rs;
    }


    public Turma() {
    }

   

    @Override
    public String toString() {
        return this.nome ;
    }
 


    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }


}
