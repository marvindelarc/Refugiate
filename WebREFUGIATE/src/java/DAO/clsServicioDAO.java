
package DAO;



import Entidades.clsServicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

public class clsServicioDAO {
    
    
       public static List<clsServicio> ListarDiferente(int IdSucursal) throws Exception
    {
        List<clsServicio> list = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarServicioDiferenteIdSucursal_sp "+IdSucursal;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(list == null)
                    list = new ArrayList<clsServicio>();

                clsServicio objComentario = new clsServicio();
                objComentario.setInt_IdServicio(dr.getInt(1));
                objComentario.setStr_Nombre(dr.getString(2));

                list.add(objComentario);
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
