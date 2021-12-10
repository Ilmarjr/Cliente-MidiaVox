
package br.com.clienteweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Ilmar Macedo Alves Junior
 * @date 2021/12/10
 *
 */
public class MysqlDAO {
    //Metodo de conexao com o banco de dados Mysql
    public Connection conectaBD() throws ClassNotFoundException  {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/destination?user=root&password=";
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            
        }
        return conn;
    }
}
