/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsDepartamento;
import Entidades.clsProvincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsProvinciaDAO {
    public static List<clsProvincia> Listar(boolean activo) throws Exception
    {
        List<clsProvincia> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idProvincia,idDepartamento,nombre FROM provincia;";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null){
                    lista= new ArrayList<clsProvincia>();
                    
                    clsDepartamento objDepartamento = new clsDepartamento();
                    objDepartamento.setIdDepartamento(dr.getInt(2));
                    
                    clsProvincia entidad = new clsProvincia();
                    entidad.setIdProvincia(dr.getInt(1));
                    entidad.setObjDepartamento(objDepartamento); 
                    entidad.setNombre(dr.getString(3));  
                    lista.add(entidad);
                }
            }
        } catch (Exception e) {
            throw new Exception("Listar "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return lista;
    }
}
