/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import DAO.clsTipoHabitacionDAO;
import Entidades.clsTipoHabitacion;
import java.util.List;

/**
 *
 * @author EdHam
 */
public class clsGestor {
           
    //<editor-fold defaultstate="collapsed" desc="clsTipoHabitacion">
    public static List<clsTipoHabitacion> ListarTipoHabitacion(boolean activo) throws Exception
    {
        return clsTipoHabitacionDAO.Listar(activo);
    }
    
    public  static int insertarTipoHabitacion(clsTipoHabitacion entidad) throws Exception
    {
        return clsTipoHabitacionDAO.insertar(entidad);
    }
    
    public static boolean actualizarTipoHabitacion(clsTipoHabitacion entidad) throws Exception
    {
        return clsTipoHabitacionDAO.actualizar(entidad);
    }
    
// </editor-fold>
    
    //metelo aca todo y dividelo por regiones
    
}
