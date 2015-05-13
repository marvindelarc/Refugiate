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
    public static List<clsProvincia> Listar(int IdDepartamento) throws Exception
    {
        List<clsProvincia> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idProvincia,idDepartamento,nombre FROM provincia where idDepartamento="+IdDepartamento;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)//ctm te voy a cahar de verdad idiota de mierda no ves lo q has hecho date cuenta ps mujer
                                        
                    lista= new ArrayList<clsProvincia>();
                    
                    clsDepartamento objDepartamento = new clsDepartamento();
                    objDepartamento.setIdDepartamento(dr.getInt(2));
                    
                    clsProvincia entidad = new clsProvincia();
                    entidad.setIdProvincia(dr.getInt(1));
                    entidad.setObjDepartamento(objDepartamento); 
                    entidad.setNombre(dr.getString(3));  
                    lista.add(entidad);
                
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
    public static List<clsDepartamento> BuscarDepartamento(int IdDepartamento) throws Exception
    {
        List<clsDepartamento> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT idDepartamento,nombre FROM departamento where idDepartamento="+IdDepartamento;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)//ctm te voy a cahar de verdad idiota de mierda no ves lo q has hecho date cuenta ps mujer
                                        
                    lista= new ArrayList<clsDepartamento>();
                    
                    clsDepartamento entidad = new clsDepartamento();
                    entidad.setIdDepartamento(dr.getInt(1));                    
                    entidad.setNombre(dr.getString(2));  
                    lista.add(entidad);                
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