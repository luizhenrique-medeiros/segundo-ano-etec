
package classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Produto {
    private int cod;
    private String nomeprod;
    private double preco;
    private int quant;
    private String senha;
    private String nome; 
    Conexao con;
          
    public int Salvar(){
    int resultado=0;
    con=new Conexao();
    String sql= "INSERT INTO tb02_produto VALUES('" + this.cod + "','" + this.nomeprod + "', '" + this.preco + "', '" + this.quant + "')";


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
    String sql= "DELETE FROM tb02_produto WHERE tb02_cod_prod="+this.cod;
    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
   
    public int verificar(){
        int res=0;
        ResultSet rs = null;
        String sql= "SELECT * from tb01_usuario WHERE tb01_nome= '"+this.nomeprod+"' AND "+ "tb01_senha='"+this.senha+"'";
        con= new Conexao();
        try {
            con.Conectar();
            rs = con.selectSQL(sql);
            if(rs.next()){
               res=1;
            }
            //con.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro:" +ex);
        }
    return res;
    }
    
    
    
    public int Atualizar(){
    int resultado=0;
    con=new Conexao();
    String sql= "UPDATE tb02_produto SET tb02_nome='"+this.nomeprod+"', tb02_preço='"+this.preco+"', tb02_qtde='"+this.quant+"'"+ "WHERE tb02_cod_prod="+this.cod;
    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
    
    
    
    
    
      public void Usuario (int c,String n,double p,int q, String np, String s){
     this.cod=c;
     this.nome=n;
     this.preco=p;
     this.quant=q;
     this.nomeprod=np;
     this.senha=s;
     
  }
      
      
      

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
      
      
}
