
package br.com.clienteweb.service;

import br.com.clienteweb.commonvo.DestinationVO;
import br.com.clienteweb.dao.DestinationDAO;
import java.util.List;

/**
 * @author Ilmar Macedo Alves Junior
 * @date 2021/12/10
 *
 */
public class DestinationService {

    DestinationDAO objDestinationDAO = new DestinationDAO();
    
    /*Metodo que insere ou atualiza um registro no banco de dados Mysql
    * @param objDestinationVO1, objeto base para a insercao no banco de dados
    * @return int
    */
    public int createOrUpdate(DestinationVO objDestinationVO) throws ClassNotFoundException {
        String id = objDestinationDAO.getOne(objDestinationVO.getId()).getId();
        boolean containObjectDestination = id.equals(objDestinationVO.getId());
        if(containObjectDestination){
            return objDestinationDAO.update(objDestinationVO,objDestinationVO.getId());
        }else
        return objDestinationDAO.create(objDestinationVO);
    }
    
    /*Metodo que retorna uma lista registros do banco de dados Mysql
    * @param objDestinationVO1, objeto base para a pesquisa no banco de dados
    * @return List
    */
    public List<DestinationVO> getDestination(DestinationVO objDestinationVO) throws ClassNotFoundException {
        String sql = new String();
        int parametros = 0; 
        //Sera emitido um comando diferente a depender do numero de parametros para a pesquisa
        if (objDestinationVO.getId().equals("")) {
            sql = "Select * from TBA_DESTINATION where DTN_DESTINATION = ? order by DTN_ID";
            parametros = 1;
        } else if (objDestinationVO.getDestination().equals("")) {
            sql = "Select * from TBA_DESTINATION where DTN_ID = ?";
            parametros = 2;
        } else {
            sql = "Select * from TBA_DESTINATION where DTN_ID = ? and DTN_DESTINATION = ?";
            parametros = 3;
        }
        if (objDestinationVO.getId().equals("") & objDestinationVO.getDestination().equals("")) {
            sql = "Select * from TBA_DESTINATION order by DTN_ID";
            parametros = 0;
        }
        return objDestinationDAO.getList(objDestinationVO, sql, parametros);
    }
    
    /*Metodo que chama a função para apagar um registro do banco de dados Mysql
    * @param objDestinationVO1, objeto base para pesquisar qual registro será deletado no banco de dados
    */
    public void deleteDestination(DestinationVO objDestinationVO) throws ClassNotFoundException {
        objDestinationDAO.Delete(objDestinationVO);
    }
    
    /*Metodo que retorna um registro do banco de dados Mysql
    * @param id, id do registro a ser pesquisado
    * @return objDestinationVO
    */
    public DestinationVO getOneDestination(String id) throws ClassNotFoundException {
        
        return objDestinationDAO.getOne(id);
        
    }
    /*Metodo que edita um registro no banco de dados Mysql
    * @param objDestinationVO1, objeto base para a alteracao no banco de dados
    * @param lastId, dado do id que esta registrado no bando de dados caso o id seja alterado na edicao
    * @return int
    */
    public int updateDestination(DestinationVO objDestinationVO, String lastId) throws ClassNotFoundException{
        return objDestinationDAO.update(objDestinationVO,lastId);
    }
}
