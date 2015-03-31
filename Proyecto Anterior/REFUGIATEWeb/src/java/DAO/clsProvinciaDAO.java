
package DAO;


import Entidades.clsDepartamento;
import Entidades.clsProvincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

public class clsProvinciaDAO {
    
    
       public static List<clsProvincia> listarProvinciaXDepartamento(int IdDepartamento) throws Exception
    {
        List<clsProvincia> listProvincia = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="exec ListarProvinciaXIdDepartamento_sp "+IdDepartamento;
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listProvincia == null)
                    listProvincia = new ArrayList<clsProvincia>();
                
                clsDepartamento Departamento = new clsDepartamento();
                Departamento.setInt_IdDepartamento(dr.getInt(2));
                
                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_IdProvincia(dr.getInt(1));
                objProvincia.setStr_Nombre(dr.getString(3));
                objProvincia.setObjDepartamento(Departamento);

                listProvincia.add(objProvincia);
            }

        } catch (Exception e) {
            throw new Exception("Listar Provincia "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listProvincia;
    }
 
}
