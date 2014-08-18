
package DAO;


import Entidades.clsDepartamento;
import Entidades.clsDistrito;
import Entidades.clsProvincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

public class clsDistritoDAO {
    


    
     
      public static List<clsDistrito> listarDistritoXProvincia(int IdProvincia) throws Exception
    {
        List<clsDistrito> listDistrito = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarDistritoXIdProvincia_sp "+IdProvincia;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listDistrito == null)
                    listDistrito = new ArrayList<clsDistrito>();

                
                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_IdProvincia(dr.getInt(2));
                
                clsDistrito objDistrito = new clsDistrito();
                objDistrito.setInt_IdDistrito(dr.getInt(1));
                objDistrito.setStr_Nombre(dr.getString(3));
                objDistrito.setObjProvincia(objProvincia);

                listDistrito.add(objDistrito);
            }

        } catch (Exception e) {
            throw new Exception("Listar Distrito "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDistrito;
    }
      
      
     public static clsDistrito buscarId (int idDistrito) throws Exception
    {
        clsDistrito objDistrito = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec BuscarXIdDistrito_sp "+idDistrito;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {
                clsDepartamento objclsDepartamento = new clsDepartamento();
                objclsDepartamento.setStr_Nombre(dr.getString(5));
                
                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_IdProvincia(dr.getInt(2));
                objProvincia.setStr_Nombre(dr.getString(4));
                objProvincia.setObjDepartamento(objclsDepartamento);
                
                objDistrito = new clsDistrito();
                objDistrito.setInt_IdDistrito(dr.getInt(1));
                objDistrito.setStr_Nombre(dr.getString(3));
                objDistrito.setObjProvincia(objProvincia);

            }

        } catch (Exception e) {
            throw new Exception("Listar Distrito "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return objDistrito;
    }

     
}
