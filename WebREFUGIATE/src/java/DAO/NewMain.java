/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.clsComentario;
import Entidades.clsCostoTipoHabitacion;
import Entidades.clsDepartamento;
import Entidades.clsDetalleReserva;
import Entidades.clsProvincia;
import Entidades.clsReserva;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
         
            clsComentario entidad= new clsComentario();
            entidad.setInt_IdReserva(120);
            entidad.setStr_Descripcion("mas de verdad maso");
           System.out.println(""+clsComentarioDAO.insertar(entidad));
    }
}
