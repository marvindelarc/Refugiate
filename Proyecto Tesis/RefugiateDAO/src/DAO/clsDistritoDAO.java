/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsDistrito;
import Entidades.clsProvincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsDistritoDAO 
{
    public static List<clsDistrito> Listar(boolean activo) throws Exception
    {
        List<clsDistrito> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idDistrito,idProvincia,nombre FROM distrito";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) 
            {
                if(lista==null){
                    lista = new ArrayList<clsDistrito>();
                    
                    clsProvincia objProvincia = new clsProvincia();
                    objProvincia.setIdProvincia(dr.getInt(2));
                    
                    clsDistrito entidad = new clsDistrito();
                    entidad.setIdDistrito(dr.getInt(1));
                    entidad.setObjProvincia(objProvincia);
                    entidad.setNombre(dr.getString(3));
                    lista.add(entidad);
                }
            }
        } catch (Exception e) {
            throw new Exception("Listar"+e.getMessage(), e);
        }
        finally
        {
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }
}
