/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import DAO.clsDistritoDAO;
import Entidades.clsDistrito;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsGestorDistrito {
    public static List<clsDistrito> listarDistrito(boolean activo) throws Exception
    {
        return clsDistritoDAO.Listar(activo);
    }
}
