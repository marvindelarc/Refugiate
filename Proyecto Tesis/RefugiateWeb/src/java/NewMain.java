
import COM.clsGestorCatalogo;
import Entidades.clsTipoHabitacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EdHam
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        clsTipoHabitacion entidad = new clsTipoHabitacion();
        entidad.setNombreComercial("Simple");
        System.out.print(clsGestorCatalogo.insertarTipoHabitacion(entidad));
        
    }
    
}
