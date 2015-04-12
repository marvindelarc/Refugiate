package COM;


import DAO.clsComentarioDAO;
import Entidades.clsComentario;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paulo
 */
public class clsGestorComentarios {
    public static List<clsComentario> ListarComentario(boolean activo) throws Exception
    {
        return clsComentarioDAO.Listar(activo);
    }
    public static int insertarComentario(clsComentario entidad) throws Exception
    {
        return clsComentarioDAO.insertar(entidad);
    }
    public static boolean actualizarComentario(clsComentario entidad) throws Exception
    {
        return clsComentarioDAO.actualizar(entidad);
    }
}
