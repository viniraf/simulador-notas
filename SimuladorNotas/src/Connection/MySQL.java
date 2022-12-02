
package Connection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
/**
 *
 * @author Macrr
 */
public class MySQL {
    
    //atributos de conexão com o banco
    private Connection conn = null; //variável de conexão com o banco
    private Statement statement; //variável de manipulação do SQL
    private ResultSet resultSet;
    
    
    // Para mudar a conexão do banco, comente algum bloco e descomente outro
    
    // Bloco 1 - Pc facens
    /*
    private String servidor = "localhost:3306";
    private String nomeDoBanco = "SimuladorNotas";
    private String usuario = "root";
    private String senha = "facens";
    */
    
    // Bloco 2 - Pc vini
    /*
    private String servidor = "127.0.0.1:3306";
    private String nomeDoBanco = "SimuladorNotas";
    private String usuario = "root";
    private String senha = "";
    */
    
    // Bloco 3 - Pc ander
    
    private String servidor = "127.0.0.1:3306";
    private String nomeDoBanco = "SimuladorNotas";
    private String usuario = "root";
    private String senha = "facens";
    
    
    // Bloco 4 - Pc gaby
    /*
    private String servidor = "127.0.0.1:3306";
    private String nomeDoBanco = "SimuladorNotas";
    private String usuario = "root";
    private String senha = "";
    */
    
    //Construtor    
    public MySQL(){
    
    }
    
    public MySQL(String servidor, String nomeDoBanco, String usuario, String senha){
        this.servidor = servidor;
        this.nomeDoBanco = nomeDoBanco;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
        
    public void conectaBanco(){
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + nomeDoBanco + "?user=" + usuario + "&password=" + senha + "&useSSL=false" );
            //conn = DriverManager.getConnection("jdbc:mysql://localhost3306/banco_loja", "root", "root");
            
            if(conn != null){
                System.out.println("Conexao efetuada com sucesso! " + "ID: " + conn);
            }            
            
        } catch (Exception e) {
            System.out.println("Conexao não realizada - ERRO: " + e.getMessage());
        }
    }
    
    public boolean fechaBanco(){
        try {
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao " + e.getMessage());
            return false;
        }
    }
    
    public int insertSQL(String SQL){
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getConn().createStatement());            

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(SQL);            
        
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }
    
    public void executarSQL(String sql) {
        try {
            this.statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.resultSet = this.statement.executeQuery(sql);

//            while (this.getResultSet().next()) {
//                System.out.println(this.getResultSet().getInt(1));
//            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
    
    public boolean updateSQL(String pSQL){
        try {            
            //createStatement de con para criar o Statement
            this.setStatement(getConn().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            getStatement().executeUpdate(pSQL);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
