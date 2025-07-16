package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoCFG {

    private static final String url = "jdbc:mysql://localhost:3306/sis_estoque";
    private static final String user = "root";
    private static final String password = "Root1234";

    private static Connection conn;

    public static Connection getConexao(){

        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            if (conn==null) {
                conn=DriverManager.getConnection(url, user, password);
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
                return conn;
            }else{
                return conn;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("");
            System.err.println("Erro: Driver JDBC MySQL não encontrado. Verifique se o JAR está no classpath e o nome da classe está correto.");
            e.printStackTrace();
            return null;
        }
        catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
