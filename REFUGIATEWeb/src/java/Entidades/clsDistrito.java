
package Entidades;

public class clsDistrito {
    private int int_IdDistrito;
    private String str_Nombre;
    private clsProvincia objProvincia;

    public clsDistrito() {
    }

    public int getInt_IdDistrito() {
        return int_IdDistrito;
    }

    public void setInt_IdDistrito(int int_IdDistrito) {
        this.int_IdDistrito = int_IdDistrito;
    }

    public String getStr_Nombre() {
        return str_Nombre;
    }

    public void setStr_Nombre(String str_Nombre) {
        this.str_Nombre = str_Nombre;
    }

    public clsProvincia getObjProvincia() {
        return objProvincia;
    }

    public void setObjProvincia(clsProvincia objProvincia) {
        this.objProvincia = objProvincia;
    }

  
}
