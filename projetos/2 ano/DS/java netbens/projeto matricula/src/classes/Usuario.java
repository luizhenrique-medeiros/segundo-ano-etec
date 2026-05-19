
package classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    Conexao con;
          
    public int Salvar(){
    int resultado=0;
    con=new Conexao();
    String sql= "INSERT INTO tb01_usuario VALUES('" + this.id + "','" + this.nome + "', '" + this.login + "', '" + this.senha + "')";


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
    String sql= "DELETE FROM tb01_usuario WHERE tb01_id="+this.id;
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
    String todos= "SELECT * FROM tb01_usuario";
    try{
        con.Conectar();
        rs = con.selectSQL(todos);
        //con.desconectar();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println("Erro:"+ex);
    }
    return rs;
    }
    public int verificar(){
        int res=0;
        ResultSet rs = null;
        String sql= "SELECT * from tb01_usuario WHERE tb01_login= '"+this.login+"' AND "+ "tb01_senha='"+this.senha+"'";
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
    
    
    public ResultSet PesquisarId(){
    ResultSet rs = null;
    con= new Conexao();
    String todos= "SELECT * FROM tb01_usuario WHERE tb01_id="+this.id;
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
    String sql= "UPDATE tb01_usuario SET tb01_login='"+this.login+"', tb01_senha='"+this.senha+"'"+ "WHERE tb01_id="+this.id;
    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    //con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
    
    
    
      public void Usuario (int i,String n,String l,String s){
     this.id=i;
     this.nome=n;
     this.login=l;
     this.senha=s;
     
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
      
      
}
