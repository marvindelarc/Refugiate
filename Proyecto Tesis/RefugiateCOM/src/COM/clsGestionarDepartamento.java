/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import DAO.clsDepartamentoDAO;
import Entidades.clsDepartamento;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsGestionarDepartamento {
    public static List<clsDepartamento> ListarDepartamento(boolean activo) throws Exception{
        return clsDepartamentoDAO.Listar(activo);
    }
}
