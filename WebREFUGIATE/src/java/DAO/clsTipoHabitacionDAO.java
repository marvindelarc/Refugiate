
package DAO;



import Entidades.clsTipoHabitacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

public class clsTipoHabitacionDAO {
    
    
       public static List<clsTipoHabitacion> ListarDiferente(int IdSucursal) throws Exception
    {
        List<clsTipoHabitacion> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarTipoHabitacionDiferenteIdSucursal_sp "+IdSucursal;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsTipoHabitacion>();

                clsTipoHabitacion objTipoHabitacion = new clsTipoHabitacion();
                objTipoHabitacion.setInt_IdTipoHabitacion(dr.getInt(1));
                objTipoHabitacion.setNombreComercial(dr.getString(2));

                list.add(objTipoHabitacion);
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo Habitacion "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
 
}
