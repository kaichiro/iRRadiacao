package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que provê conexão DB
 */
public class DataConnection {

    private static final String DRIVE = "com.mysql.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/iRRadiacaoV31";
//    private static final String USER = "root";
//    private static final String PASS = "30915283";

    /**
     * Método que pega a conexão DB
     *
     * @return
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException {

        ConnectionProperties CntPrp = new ConnectionProperties();
        
        String url = "jdbc:mysql://" + CntPrp.getHost() + ":" + CntPrp.getPort() + "/" + CntPrp.getNameDB();
        try {
            Class.forName(DRIVE);
//            System.out.println("getConnection() executado com sucesso!");
            return DriverManager.getConnection(url, CntPrp.getUser(), CntPrp.getPassword() /*URL, USER, PASS*/);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("getConnection() error: " + ex);
            utils.Utilitarios.MsgExcecao("\r\n Parâmetros de conexão a base de dados inválidos.\r\n Consulte o arquivo 'config.cnx' e verifique os parâmetros de acesso a base de dados!\r\n\r\n" + ex);
            throw new RuntimeException("Erro na conexão (getConnection):\n" + ex);
        }
    }

    /**
     * Método que fecha uma conexão DB
     *
     * @param con parâmetro de conexão com o banco de dados
     */
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
//                System.out.println("closeConnection(con) executado com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println("getConnection(con) error: " + ex);
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que fecha uma conexão DB
     *
     * @param con parâmetro de conexão com o banco de dados
     * @param stmt parâmetro de preparação de conteúdo de parâmetros da
     * instrução SQL (DML)
     */
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
//                System.out.println("closeConnection(con, stmt) executado com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println("getConnection(con, stmt) error: " + ex);
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que fecha uma conexão DB
     *
     * @param con parâmetro de conexão com o banco de dados
     * @param stmt parâmetro de preparação de conteúdo de parâmetros da
     * instrução SQL (DML)
     * @param rs parâmetro de retorno de instrução SQL (select)
     */
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
//                System.out.println("closeConnection(con, stmt, rs) executado com sucesso!");
            }
        } catch (SQLException ex) {
            System.out.println("getConnection(con, stmt, rs) error: " + ex);
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
