/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Etec
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    // String com o caminho onde está o banco de dados
    String URL = "jdbc:mysql://carmine:3306/2dsa_bd_matricula_vitor-c_luiz-h";
    //Login
    String usuario = "aluno";
    //Senha
    String senha = "etec@147";
    // Variavel para o comando SQL
    public static Statement statement = null;
    // Variavel para a conexão
    private Connection conexao = null;
 
    // Métodos Conectar e Desconectar Banco de Dados 
    // =============================================

    public void Conectar() throws ClassNotFoundException, SQLException {       
        // Carga do driver de conexão
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Fazendo a conexão
        conexao = DriverManager.getConnection(URL, usuario, senha);
        statement = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public void desconectar() throws SQLException{           
        // Fechando a conexão
        conexao.close();
    }
    
    public static int runSQL(String sql) 
    {
        int qtdreg = 0;     
    try{
      qtdreg = statement.executeUpdate(sql);
         System.out.println("Registro processado");
      }catch(SQLException sqlex){
           System.out.println("Erro acesso ao BD"+ sqlex);
      //   JOptionPane.showMessageDialog(null, "Erro");
      }
      return qtdreg;
    }
    
    public ResultSet selectSQL(String sql){
        ResultSet rs=null;
        try{
            rs = statement.executeQuery(sql);  
            System.out.println(sql);
        }catch(SQLException sqlex){
           System.out.println("Erro acesso ao BD"+ sqlex);
      }
        return rs;
    }
}