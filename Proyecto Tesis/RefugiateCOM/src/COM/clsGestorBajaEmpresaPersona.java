/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import DAO.clsBajaEmpresaPersonaDAO;
import Entidades.clsBajaEmpresaPersona;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsGestorBajaEmpresaPersona {
    public static List<clsBajaEmpresaPersona> ListarBajaEmpresaPersonas (boolean activo) throws Exception
    {
        return clsBajaEmpresaPersonaDAO.Listar(activo);
    }
    
}
