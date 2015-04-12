package DAO;


import DAO.clsConexion;
import Entidades.clsBajaEmpresaPersona;
import Entidades.clsEmpresa;
import Entidades.clsPersona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
public class clsBajaEmpresaPersonaDAO {
    public static List<clsBajaEmpresaPersona> Listar(boolean activo) throws Exception
    {
        List<clsBajaEmpresaPersona> lista = null;
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql = "SELECT idBajaEmpresaPersona,idEmpresa,idPersona,comentario,fechaRegistro,fechaFinal,estado FROM bajaempresapersona";
            if (activo)
                sql+=" where estado = 1";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while (dr.next()) {
                if (lista == null) {
                    lista = new ArrayList<clsBajaEmpresaPersona>();
                    
                    clsEmpresa objEmpresa = new clsEmpresa();
                    objEmpresa.setIdEmpresa(dr.getInt(2));
                    
                    clsPersona objPersona = new clsPersona();
                    objPersona.setIdPersona(dr.getInt(3));
                    
                    clsBajaEmpresaPersona entidad = new clsBajaEmpresaPersona();
                    entidad.setIdBajaEmpresaPersona(dr.getInt(1));
                    entidad.setComentario(dr.getString(4));
                    entidad.setFechaRegistro(dr.getTimestamp(5));
                    entidad.setFechaFinal(dr.getTimestamp(6));
                    entidad.setEstado(dr.getInt(7));
                    entidad.setObjEmpresa(objEmpresa);
                    entidad.setObjPersona(objPersona);
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
    
    public static int insertar(clsBajaEmpresaPersona entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement  stmt = null;
        try {
            String sql = "INSERT INTO bajaempresapersona (idEmpresa,idPersona,comentario,fechaRegistro,fechaFinal,estado)"
                        + "VALUES(?,?,?,?,?,?);";
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjEmpresa().getIdEmpresa());
            stmt.setInt(2, entidad.getObjPersona().getIdPersona());
            stmt.setString(3, entidad.getComentario());
            stmt.setTimestamp(4, entidad.getFechaRegistro());
            stmt.setTimestamp(5, entidad.getFechaFinal());
            stmt.setInt(6, entidad.getEstado());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                rpta = rs.getInt(6);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Insertar"+e.getMessage(), e);
        }
        finally
        {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
    
    public static boolean actualizar(clsBajaEmpresaPersona entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql = "";
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
        } catch (Exception e) {
        }
    }
}
