/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import DAO.clsDetalleReservaDAO;
import Entidades.clsDetalleReserva;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsGestorDetalleReserva {
    public static List<clsDetalleReserva> ListarDetalleReservas(boolean ectivo) throws Exception
    {
        return clsDetalleReservaDAO.Listar(ectivo);
    }
    public static int insertarDetalleReserva(clsDetalleReserva entidad) throws Exception
    {
        return clsDetalleReservaDAO.insertar(entidad);
    }
    public static boolean actualizarDetalleReserva(clsDetalleReserva entidad) throws Exception
    {
        return clsDetalleReservaDAO.actualizar(entidad);
    }
}
