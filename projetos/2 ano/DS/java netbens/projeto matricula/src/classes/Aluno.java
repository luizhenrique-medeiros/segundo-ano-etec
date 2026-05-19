
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Aluno {
    private int rm;
    private String cpf;
    private String endereco;
    private String telefone;
    private String nome;
    Conexao con;
    
    public int Excluir(){
    int resultado=0;
    con=new Conexao();
    String sql= "DELETE FROM tb03_aluno WHERE tb03_rm="+this.rm;
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
    String todos= "SELECT * FROM tb03_aluno WHERE tb03_rm="+this.rm;
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
    String sql= "UPDATE tb03_aluno SET tb03_cpf='"+this.cpf+"',tb03_endereço='"+this.endereco+"',tb03_telefone='"+this.telefone+"', tb03_nome='"+this.nome+"'"+ "WHERE tb03_rm="+this.rm;
    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
      public int Salvar(){
    int resultado=0;
    con=new Conexao();
    String sql= "INSERT INTO tb03_aluno VALUES('" + this.rm + "', '" + this.nome + "', '" + this.endereco + "', '" + this.telefone + "', '" + this.cpf + "')";


    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
      public ResultSet PesquisarTodos(){
    ResultSet rs = null;
    con= new Conexao();
    String todos= "SELECT * FROM tb03_aluno";
    try{
        con.Conectar();
        rs = con.selectSQL(todos);
        //con.desconectar();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println("Erro:"+ex);
    }
    return rs;
    }
       public ResultSet carregar2(){
        ResultSet rs = null;
        con=new Conexao();
        try {
            con.Conectar();
            rs = con.selectSQL("Select tb03_nome, tb03_rm from tb03_aluno");            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro: "+ex);
        }
        return rs;
    }
       
    public Aluno() {
    }

    public Aluno(int rm, String nome) {
        this.rm = rm;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rm );
    }


  public void Aluno (String n,String c,String e,String tl, int rm){
     this.nome=n;
     this.cpf=c;
     this.endereco=e;
     this.telefone=tl;
     this.rm=rm;
  }

    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
  
}
