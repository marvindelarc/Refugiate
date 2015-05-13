/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsEmpresa;
import Entidades.clsPagoEmpresa;
import Entidades.clsPaquete;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class clsPagoEmpresaDAO {
    public static List<clsPagoEmpresa> Listar(boolean activo) throws Exception
    {
        List<clsPagoEmpresa> lista = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_pago_empresa,id_empresa,id_paquete,monto,baucher,fechaRegistro,fechaInicio,fechaFin,estado FROM pago_empresa";
            if(activo)
                    sql+=" where estado=1"; 
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(lista==null)
                {
                    lista= new ArrayList<clsPagoEmpresa>(); 
                }  
                clsEmpresa objEmpresa = new clsEmpresa();
                objEmpresa.setIdEmpresa(dr.getInt(2));
                
                clsPaquete objPaquete = new clsPaquete();
                objPaquete.setIdPaquete(dr.getInt(3));
                
                clsPagoEmpresa entidad = new clsPagoEmpresa();
                entidad.setIdPagoEmpresa(dr.getInt(1));
                entidad.setObjEmpresa(objEmpresa);
                entidad.setObjPaquete(objPaquete);
                entidad.setMonto(dr.getFloat(4));
                entidad.setBaucher(dr.getBytes(5));
                entidad.setFechaRegistro(dr.getDate(6));
                entidad.setFechaInicio(dr.getDate(7));
                entidad.setFechaFin(dr.getDate(8));
                entidad.setEstado(dr.getInt(9));
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
    
    public  static int insertar(clsPagoEmpresa entidad) throws Exception
    {
        int rpta = 0;
        Connection conn = null;
        PreparedStatement  stmt = null;
        try {
            
           String sql= "INSERT INTO pago_empresa(id_empresa,id_paquete,monto,baucher,fechaRegistro,fechaInicio,fechaFin,estado)"
                   + " VALUES(?,?,?,?,?,?,?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjEmpresa().getIdEmpresa());
            stmt.setInt(2, entidad.getObjPaquete().getIdPaquete());
            stmt.setDouble(3, entidad.getMonto());
            stmt.setBytes(4, entidad.getBaucher());
            stmt.setDate(5, (Date) entidad.getFechaRegistro());
            stmt.setDate(6, (Date) entidad.getFechaInicio());
            stmt.setDate(7, (Date) entidad.getFechaFin());
            stmt.setInt(8, entidad.getEstado());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()){
                rpta=rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Insertar"+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    } 
    
    public static boolean actualizar(clsPagoEmpresa entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE pago_empresa SET id_empresa = ?,id_paquete = ?,monto = ?,baucher = ?,fechaRegistro = ?,fechaInicio = ?,fechaFin = ?,estado = ? WHERE id_empresa = ?;";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setInt(1, entidad.getObjEmpresa().getIdEmpresa());
            stmt.setInt(2, entidad.getObjPaquete().getIdPaquete());
            stmt.setDouble(3, entidad.getMonto());
            stmt.setBytes(4, entidad.getBaucher());
            stmt.setDate(5, (Date) entidad.getFechaRegistro());
            stmt.setDate(6, (Date) entidad.getFechaInicio());
            stmt.setDate(7, (Date) entidad.getFechaFin());
            stmt.setInt(8, entidad.getEstado());
            stmt.setInt(9, entidad.getIdPagoEmpresa());
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Error Actualizar "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    }  
}
