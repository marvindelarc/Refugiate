/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsDepartamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsDepartamentoDAO {
    public static List<clsDepartamento> Listar(boolean activo) throws Exception
    {
        List<clsDepartamento> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idDepartamento,nombre FROM departamento";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) 
            {                
                if (lista == null) 
                {
                    lista= new ArrayList<clsDepartamento>();
                }
                clsDepartamento entidad = new clsDepartamento();
                entidad.setIdDepartamento(dr.getInt(1));
                entidad.setNombre(dr.getString(2));
                lista.add(entidad);                
            }
        } catch (Exception e) {
            throw new Exception("Listar "+e.getMessage(), e);
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
