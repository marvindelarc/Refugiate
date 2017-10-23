package DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class clsConexion {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://170.239.86.92:3306/refugiate";
    public static String usuario = "root";
    public static String clave = "edsoftperu2017";
    
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
            System.exit(0);
        }
             return cnn;
    }

}
