/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsDepartamento;
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
    public static List<clsDistrito> Listar(int idProvincia) throws Exception
    {
        List<clsDistrito> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idDistrito,idProvincia,nombre FROM distrito where idProvincia = "+idProvincia;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) 
            {
                if(lista==null)
                {
                    lista = new ArrayList<clsDistrito>();
                }
                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setIdProvincia(dr.getInt(2));

                clsDistrito entidad = new clsDistrito();
                entidad.setIdDistrito(dr.getInt(1));
                entidad.setObjProvincia(objProvincia);
                entidad.setNombre(dr.getString(3));
                lista.add(entidad);                
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
    public static List<clsProvincia> BuscarProvincia(int idProvincia) throws Exception
    {
        List<clsProvincia> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idProvincia,nombre,idDepartamento FROM provincia where idProvincia = "+idProvincia;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) 
            {
                if(lista==null)
                {
                    lista = new ArrayList<clsProvincia>();
                }
                clsDepartamento objDepartamento = new clsDepartamento();
                objDepartamento.setIdDepartamento(dr.getInt(3));

                clsProvincia entidad = new clsProvincia();
                entidad.setIdProvincia(dr.getInt(1));
                entidad.setNombre(dr.getString(2));
                entidad.setObjDepartamento(objDepartamento);                
                lista.add(entidad);                
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