package classes;


import classes.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Matricula {
    private String turma;
    private String situacao;
    private String ano;
    private String rm;
    private String nmat;
      Conexao con;
    
        public int Salvar(){
    int resultado=0;
    con=new Conexao();
    String sql= "INSERT INTO tb04_matricula VALUES('" + this.nmat + "','" + this.turma + "', '" + this.rm + "', '" + this.situacao + "', '" + this.ano + "' )";
            System.out.println(sql);
    try{
    con.Conectar();
    resultado=con.runSQL(sql);
    con.desconectar();
    }catch (ClassNotFoundException | SQLException ex){
    System.out.println("Erro:" +ex);
    }
    return resultado;
    }
         public int Excluir(){
    int resultado=0;
    con=new Conexao();
    String sql= "DELETE FROM tb04_matricula WHERE tb04_num="+this.nmat;
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
    String todos= "SELECT * FROM tb04_matricula WHERE tb04_num="+this.nmat;
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
    String sql= "UPDATE tb04_matricula SET tb04_ano_letivo='"+this.ano+"', tb04_situação='"+this.situacao+"'"+ "WHERE tb04_num="+this.nmat;
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
    String todos= "SELECT * FROM tb04_matricula";
    try{
        con.Conectar();
        rs = con.selectSQL(todos);
        //con.desconectar();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println("Erro:"+ex);
    }
    return rs;
    }

public void consulta (String t,String s,String an, String r,String n){
     this.turma=t;
     this.situacao=s;
     this.ano=an;
     this.rm=r;
     this.nmat=n;
  }


    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getNmat() {
        return nmat;
    }

    public void setNmat(String nmat) {
        this.nmat = nmat;
    }
    


}