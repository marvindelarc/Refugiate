package DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class clsConexion {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://;databaseName=Refugiate";
    private static String usuario = "sa";
    private static String clave = "123";
    
    public clsConexion() {
    }
    public static Connection getConnection() throws Exception{
        Connection cnn = null;
        try {
             Class.forName(driver);
            cnn=DriverManager.getConnection(url,usuario,clave);
            System.out.println("conexion establecida");
        } catch (Exception e) {
             System.out.println("no se pùdo establecer la conexion");
        }
             return cnn;
    }


}
