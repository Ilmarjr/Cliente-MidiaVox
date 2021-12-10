
package br.com.clienteweb.dao;

import br.com.clienteweb.commonvo.DestinationVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Ilmar Macedo Alves Junior
 * @date 2021/12/10
 *
 */
public class DestinationDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    List<DestinationVO> list = new ArrayList<DestinationVO>();
    
    /*Metodo que insere um registro no banco de dados Mysql
    * @param objDestinationVO1, objeto base para a insercao no banco de dados
    * @return int
    */
    public int create(DestinationVO objDestinationVO) throws ClassNotFoundException{
        String sql = "insert into TBA_DESTINATION (DTN_ID,DTN_DESTINATION) values (?,?)";
        int status = 0;
        conn = new MysqlDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objDestinationVO.getId());
            pstm.setString(2, objDestinationVO.getDestination());
            
            status = pstm.executeUpdate();
            pstm.close();
            
        } catch (SQLException erro) {
            
        }
        return status;
    }
    /*Metodo que edita um registro no banco de dados Mysql
    * @param objDestinationVO1, objeto base para a alteracao no banco de dados
    * @param lastId, dado do id que esta registrado no bando de dados caso o id seja alterado na edicao
    * @return int
    */
    public int update(DestinationVO objDestinationVO, String lastId) throws ClassNotFoundException{
        String sql = "update TBA_DESTINATION set DTN_ID = ?, DTN_DESTINATION = ? where DTN_ID = ?";
        int status = 0;
        conn = new MysqlDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql); 
            pstm.setString(1, objDestinationVO.getId());
            pstm.setString(2, objDestinationVO.getDestination());
            pstm.setString(3, lastId);
            
            status = pstm.executeUpdate();
            pstm.close();
            
        } catch (SQLException erro) {
        }
        return status;
    }
    /*Metodo que retorna uma lista registros do banco de dados Mysql
    * @param objDestinationVO1, objeto base para a pesquisa no banco de dados
    * @param sql, comando sql para a pesquisa
    * @param parametros, numero de parametros para pesquisar
    * @return List
    */
    public List<DestinationVO> getList(DestinationVO objDestinationVO1, String sql, int parametros) throws ClassNotFoundException {
        conn = new MysqlDAO().conectaBD();
        try {
            switch (parametros) {
                case 0:
                    pstm = conn.prepareStatement(sql);
                    break;
                case 1:
                    pstm = conn.prepareStatement(sql);
                    pstm.setString(1, objDestinationVO1.getDestination());
                    break;
                case 2:
                    pstm = conn.prepareStatement(sql);
                    pstm.setString(1, objDestinationVO1.getId());
                    break;
                case 3:
                    pstm = conn.prepareStatement(sql);
                    pstm.setString(1, objDestinationVO1.getId());
                    pstm.setString(2, objDestinationVO1.getDestination());
                    break;
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                DestinationVO objDestinationVO = new DestinationVO();
                objDestinationVO.setId(rs.getString("DTN_ID"));
                objDestinationVO.setDestination(rs.getString("DTN_DESTINATION"));
                list.add(objDestinationVO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DestinationDAO Get: " + erro);
        }
        return list;
    }
    /*Metodo que retorna um registro do banco de dados Mysql
    * @param id, id do registro a ser pesquisado
    * @return objDestinationVO
    */
    public DestinationVO getOne(String id) throws ClassNotFoundException{
        String sql = "Select * from TBA_DESTINATION where DTN_ID = ?";
        DestinationVO objDestinationVO = new DestinationVO();
        
        conn = new MysqlDAO().conectaBD();
         
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
             while (rs.next()) {
               objDestinationVO = new DestinationVO();
                objDestinationVO.setId(rs.getString("DTN_ID"));
                objDestinationVO.setDestination(rs.getString("DTN_DESTINATION"));
             }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
        
        return objDestinationVO;
    }
    /*Metodo que apaga um registro do banco de dados Mysql
    * @param objDestinationVO1, objeto base para pesquisar qual registro será deletado no banco de dados
    */
    public void Delete(DestinationVO objDestinationVO) throws ClassNotFoundException{
        String sql = "Delete from TBA_DESTINATION where DTN_ID = ?";

        conn = new MysqlDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objDestinationVO.getId());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }
}
