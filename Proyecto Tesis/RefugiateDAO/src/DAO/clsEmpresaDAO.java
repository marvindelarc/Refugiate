/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsEmpresa;
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
public class clsEmpresaDAO {
    public static List<clsEmpresa> Listar(boolean activo) throws Exception{
        List<clsEmpresa> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idEmpresa,nombreComercial,nombre,slogan,ruc,puntos,fechaRegistro,logo,banner,estado FROM empresa";
            if (activo) 
                sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) 
            {
                if (lista == null) {
                    lista = new ArrayList<clsEmpresa>();
                    clsEmpresa entidad =  new clsEmpresa();
                    entidad.setIdEmpresa(dr.getInt(1));
                    entidad.setNombreComercial(dr.getString(2));
                    entidad.setNombre(dr.getString(3));
                    entidad.setSlogan(dr.getString(4));
                    entidad.setRuc(dr.getString(5));
                    entidad.setPuntos(dr.getInt(6));
                    entidad.setFechaRegistro(dr.getTimestamp(7));
                    entidad.setLogo(dr.getBytes(8));
                    entidad.setBanner(dr.getByte(9));
                    entidad.setEstado(dr.getInt(10));
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
