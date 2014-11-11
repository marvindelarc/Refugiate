
package Entidades;


public class clsProvincia {
    private int int_IdProvincia;
    private String str_Nombre;
    private clsDepartamento objDepartamento;

    public clsProvincia() {
    }

    public int getInt_IdProvincia() {
        return int_IdProvincia;
    }

    public void setInt_IdProvincia(int int_IdProvincia) {
        this.int_IdProvincia = int_IdProvincia;
    }

    public String getStr_Nombre() {
        return str_Nombre;
    }

    public void setStr_Nombre(String str_Nombre) {
        this.str_Nombre = str_Nombre;
    }

    public clsDepartamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(clsDepartamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

    
}
